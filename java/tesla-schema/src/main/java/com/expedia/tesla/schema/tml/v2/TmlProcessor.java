/**
 *
 * TmlProcessor.java
 *
 * Copyright 2013 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.expedia.tesla.schema.tml.v2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXParseException;

import com.expedia.tesla.schema.Class;
import com.expedia.tesla.schema.Enum;
import com.expedia.tesla.schema.EnumEntry;
import com.expedia.tesla.schema.Field;
import com.expedia.tesla.schema.Primitive;
import com.expedia.tesla.schema.Schema;
import com.expedia.tesla.SchemaVersion;
import com.expedia.tesla.schema.TeslaSchemaException;
import com.expedia.tesla.schema.Type;

/**
 * TML file is an user friendly Tesla schema file format. It will be
 * preprocessed to before Tesla compiler convert it into Tesla schema object
 * model. Following steps will be taken when a TML file was preprocessed.
 * <p>
 * <li>Read and preprocess all imported TML files recusively.</li>
 * <li>Scan all user type definitions and put them into a local user type list.
 * All types defined in the current TML can be refered with short name.</li>
 * <li>Resolve all short names to full name.</li>
 * <p>
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 * 
 */
public abstract class TmlProcessor {

	private static Set<String> PRIMITIVE_NAMES = new TreeSet<String>();
	private static JAXBContext jaxbContext;

	static {
		for (Primitive t : Primitive.ALL_PRIMITIVES) {
			PRIMITIVE_NAMES.add(t.getName());
		}
		try {
			jaxbContext = JAXBContext.newInstance(Tml.class);
		} catch (JAXBException e) {
			throw new RuntimeException("Failed to create JAXB context.", e);
		}
	}

	/**
	 * Read, preprocess and parse TML file. Get all user types defined in the
	 * current TML and its included TML files.
	 * 
	 * @param path
	 *            The path of TML file.
	 * 
	 * @return A list of objects represent either class ({@link Tml.Types.Class}
	 *         or enum ({@link Tml.Types.Enum}.
	 * 
	 * @throws Exception
	 */
	public static List<Object> load(String path) throws Exception {
		File file = new File(path);
		TmlGraph graph = new TmlGraph(file);
		preprocess(graph, file);
		return getAllUserTypes(graph, file);
	}

	public static void save(Schema schema, OutputStream os) throws IOException,
			JAXBException {
		List<Object> userTypes = new ArrayList<Object>();
		for (Type t : schema.getTypes()) {
			if (t.isClass()) {
				Class clzz = (Class) t;
				Tml.Types.Class tmlClss = new Tml.Types.Class();

				tmlClss.setName(clzz.getName());
				tmlClss.setDescription(clzz.getDescription());

				if (!clzz.getBaseTypeNames().isEmpty()) {
					Iterator<String> itr = clzz.getBaseTypeNames().iterator();
					StringBuilder sb = new StringBuilder();
					sb.append(itr.next());
					while (itr.hasNext()) {
						sb.append(",");
						sb.append(itr.next());
					}
					tmlClss.setExtends(sb.toString());
				}

				for (Field f : clzz.getFields()) {
					Tml.Types.Class.Field tf = new Tml.Types.Class.Field();
					tf.setName(f.getName());
					tf.setType(f.getType().getTypeId().replace("<", "(")
							.replace(">", ")"));
					tf.setDescription(f.getDescription());
					for (String attr : f.getAttributes().keySet()) {
						tf.getOtherAttributes().put(new QName(attr),
								f.getAttribute(attr));
					}
					tmlClss.getField().add(tf);
				}
				userTypes.add(tmlClss);
			} else if (t.isEnum()) {
				Enum e = (Enum) t;
				Tml.Types.Enum enm = new Tml.Types.Enum();

				enm.setName(e.getName());
				enm.setDescription(e.getDescription());

				for (EnumEntry ev : e.getEntries()) {
					Tml.Types.Enum.Entry entry = new Tml.Types.Enum.Entry();
					entry.setName(ev.getName());
					entry.setValue(ev.getValue());
					entry.setDescription(ev.getDescription());
					enm.getEntry().add(entry);
				}
				userTypes.add(enm);
			}
		}
		save(userTypes, os, schema.getVersion().getName());
	}

	public static void save(List<Object> userTypes, OutputStream os,
			String versionName) throws IOException, JAXBException {
		Tml tml = new Tml();
		Tml.Types types = new Tml.Types();
		types.getClazzOrEnum().addAll(userTypes);
		tml.setTypes(types);
		Tml.Version ver = new Tml.Version();
		ver.setName(versionName);
		tml.setVersion(ver);
		TmlGraph.marshallTml(tml, os);
	}

	private static String array(String elementType, int rank) {
		assert (rank >= 0);
		switch (rank) {
		case 0:
			return elementType;
		case 1:
			return String.format("array<%s>", elementType);
		default:
			return String.format("array<%s>", array(elementType, rank - 1));
		}
	}

	private static String getTypeName(Object classOrEnum) {
		if (classOrEnum instanceof Tml.Types.Class) {
			return ((Tml.Types.Class) classOrEnum).getName();
		} else if (classOrEnum instanceof Tml.Types.Enum) {
			return ((Tml.Types.Enum) classOrEnum).getName();
		} else {
			throw new IllegalArgumentException();
		}
	}

	private static boolean isPrimitive(String name) {
		return PRIMITIVE_NAMES.contains(name.toLowerCase());
	}

	private static void preprocess(TmlGraph graph, File file) throws Exception {
		// Convert short type declaration names to full names
		dfs(graph, file, new TmlVisitor() {
			@Override
			public void visit(TmlNode tml) {
				String namespace = tml.getTml().getNamespace() == null ? null
						: tml.getTml().getNamespace().getName();
				for (Object t : tml.getTml().getTypes().getClazzOrEnum()) {
					if (t instanceof Tml.Types.Class) {
						Tml.Types.Class clss = (Tml.Types.Class) t;
						clss.setName(toFullName(clss.getName(), namespace));
					} else if (t instanceof Tml.Types.Enum) {
						Tml.Types.Enum enm = (Tml.Types.Enum) t;
						enm.setName(toFullName(enm.getName(), namespace));
					}
				}
			}
		});

		// Resolve type references
		dfs(graph, file, new TmlVisitor() {
			@Override
			public void visit(TmlNode tml) throws TeslaSchemaException {
				String namespace = tml.getTml().getNamespace() == null ? null
						: tml.getTml().getNamespace().getName();
				List<Object> types = tml.getTml().getTypes().getClazzOrEnum();
				for (Object t : types) {
					if (t instanceof Tml.Types.Class) {
						Tml.Types.Class clss = (Tml.Types.Class) t;

						// Base type references
						if (clss.getExtends() != null
								&& !clss.getExtends().isEmpty()) {
							String[] baseTypeNames = clss.getExtends().split(
									"\\s*,\\s*");
							String fullNames = "";
							for (int i = 0; i < baseTypeNames.length; i++) {
								fullNames += fullNames.isEmpty() ? "" : ",";
								fullNames += resolveTypeRefernceToTypeId(
										normalizeTypeId(baseTypeNames[i]),
										namespace, types, null); // TODO: dump
																	// name
																	// symbols
							}
							clss.setExtends(fullNames);
						}

						// Field type references
						for (Tml.Types.Class.Field field : clss.getField()) {
							if (field.getDisplayname() == null
									|| field.getDisplayname().isEmpty()) {
								field.setDisplayname(field.getName());
							}
							field.setType(normalizeTypeId(field.getType()));
							field.setType(resolveTypeRefernceToTypeId(
									field.getType(), namespace, types, null)); // TODO:
																				// dump
																				// name
																				// symbols
							if (field.getRank() != null && field.getRank() > 0) {
								field.setType(array(field.getType(),
										field.getRank()));
								field.setRank((short) 0);
							}
							if (field.isReference() != null
									&& field.isReference()) {
								field.setType(String.format("reference<%s>",
										field.getType()));
								field.setReference(false);
							}
							if (field.isNullable() != null
									&& field.isNullable()) {
								field.setType(String.format("nullable<%s>",
										field.getType()));
								field.setNullable(false);
							}
						}
					}
				}
			}
		});
	}

	private static String resolveTypeRefernceToTypeId(String name,
			String defaultNamespace, List<Object> currentUserTypes,
			List<Object> importedUserTypes) throws TeslaSchemaException {

		Pattern pattern = Pattern.compile("(.*)(class<)(.+)(>)(.*)");
		while (true) {
			Matcher matcher = pattern.matcher(name);
			if (matcher.matches()) {
				name = matcher.group(1) + matcher.group(3) + matcher.group(5);
			} else {
				break;
			}
		}

		pattern = Pattern.compile("(.*)(enum<)(.+)(>)(.*)");
		while (true) {
			Matcher matcher = pattern.matcher(name);
			if (matcher.matches()) {
				name = matcher.group(1) + matcher.group(3) + matcher.group(5);
			} else {
				break;
			}
		}

		String[] tokens = name.split(Schema.TYPE_ID_PATTERN);
		if (tokens.length >= 3) {
			String id = "";
			for (int i = 0; i < tokens.length; i++) {
				if (!tokens[i]
						.matches(",|<|>|\\[|\\]|array|map|nullable|reference|poly")) {
					tokens[i] = resolveTypeRefernceToTypeId(tokens[i],
							defaultNamespace, currentUserTypes,
							importedUserTypes);
				}
				id += tokens[i];
			}
			return id;
		}

		// 1. primitive
		if (isPrimitive(name)) {
			return normalizePrimitiveName(name);
		}

		// 2. search local types by full name.
		String fn = toFullName(name, defaultNamespace);
		for (Object t : currentUserTypes) {
			if (t instanceof Tml.Types.Class
					&& fn.equals(((Tml.Types.Class) t).getName())) {
				return Class.nameToId(((Tml.Types.Class) t).getName());
			} else if (t instanceof Tml.Types.Enum
					&& fn.equals(((Tml.Types.Enum) t).getName())) {
				return Enum.nameToId(((Tml.Types.Enum) t).getName());
			}
		}

		// 3. try to search dumped imported types
		String id = null;
		if (importedUserTypes != null) {
			fn = null;
			for (Object t : importedUserTypes) {
				if (toShortName(getTypeName(t)).equals(name)) {
					if (fn == null) {
						fn = getTypeName(t);
						if (t instanceof Tml.Types.Class) {
							id = Class.nameToId(fn);
						} else if (t instanceof Tml.Types.Enum) {
							id = Enum.nameToId(fn);
						} else {
							assert false : "Invalid type";
						}
					} else {
						throw new TeslaSchemaException(String.format(
								"Ambiguous name '%s'. Could be %s or %s.",
								name, fn, getTypeName(t)));
					}
				}
			}
			if (id != null) {
				return id;
			}
		}

		return name;
	}

	private static String toFullName(String name, String defaultNamespace) {
		if (name.matches(".+\\..+") || isPrimitive(name)) { // already full name
			return name;
		}

		if (defaultNamespace != null && !defaultNamespace.isEmpty()) {
			return String.format("%s.%s", defaultNamespace, name);
		}

		return name;
	}

	private static String toShortName(String name) {
		return name.replaceFirst("^.+\\.", "");
	}

	private static String normalizePrimitiveName(String name) {
		if (isPrimitive(name)) {
			return name.toLowerCase();
		}
		return name;
	}

	private static String normalizeTypeId(String id) {
		return id.replaceAll("\\s", "").replaceAll("\\(", "<")
				.replaceAll("\\)", ">");
	}

	public static Tml unmarshalTml(String path) throws JAXBException {
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		return (Tml) unmarshaller.unmarshal(new File(path));
	}

	public static long getSchemaHash(String filename)
			throws NoSuchAlgorithmException, IOException {
		return getSchemaHash(new FileInputStream(filename));
	}

	private static long getSchemaHash(InputStream is)
			throws NoSuchAlgorithmException, IOException {
		MessageDigest md = MessageDigest.getInstance("SHA1");
		try {
			DigestInputStream dis = new DigestInputStream(is, md);
			while (dis.read() != -1)
				;
			byte[] digest = md.digest();
			return (new BigInteger(digest)).longValue();
		} finally {
			is.close();
		}
	}

	private static void dfs(TmlGraph graph, File root, TmlVisitor visitor)
			throws Exception {
		dfs(graph, root, new HashSet<File>(), visitor);
	}

	private static void dfs(TmlGraph graph, File current, Set<File> visited,
			TmlVisitor visitor) throws Exception {
		if (visited.contains(current)) {
			return;
		}

		for (TmlNode imp : graph.imports(current)) {
			imp.acceptVisitor(visitor);
		}

		TmlNode tn = graph.findVertex(current);
		tn.acceptVisitor(visitor);
		visited.add(current);
	}

	private static List<Object> getAllUserTypes(TmlGraph graph, File root)
			throws Exception {
		final List<Object> userTypes = new ArrayList<Object>();
		dfs(graph, root, new TmlVisitor() {
			@Override
			public void visit(TmlNode tml) {
				userTypes.addAll(tml.getTml().getTypes().getClazzOrEnum());
			}
		});
		return userTypes;
	}

	public static Schema build(String path) throws Exception {
		List<Object> types = TmlProcessor.load(path);
		long hash = TmlProcessor.getSchemaHash(path);
		Tml.Version ver = TmlGraph.unmarshallTml(new File(path)).getVersion();
		return TmlProcessor.build(types,
				new SchemaVersion(hash, ver.getNumber() == null ? (short) 0
						: ver.getNumber().shortValue(), ver.getName(), path));
	}

	public static com.expedia.tesla.schema.Schema build(List<Object> types,
			SchemaVersion ver) throws TeslaSchemaException {
		com.expedia.tesla.schema.Schema schema = new com.expedia.tesla.schema.Schema();
		Set<String> userTypeIdSet = new TreeSet<String>();

		for (Object type : types) {
			// build classes, without fields.
			if (type instanceof Tml.Types.Class) {
				Tml.Types.Class c = (Tml.Types.Class) type;
				String id = Class.nameToId(c.getName());
				userTypeIdSet.add(id);

				Class clss = (Class) schema.addType(id);
				List<Class> bases = new ArrayList<Class>();
				if (c.getExtends() != null && !c.getExtends().isEmpty()) {
					for (String b : c.getExtends().split(",")) {
						Class base = (Class) schema.addType(b);
						bases.add(base);
					}
					clss.setBases(bases);
				}
				clss.setDescription(c.getDescription());
			} else if (type instanceof Tml.Types.Enum) {
				// build enums, without entries.
				Tml.Types.Enum e = (Tml.Types.Enum) type;
				String id = Enum.nameToId(e.getName());
				userTypeIdSet.add(id);

				Enum enm = (Enum) schema.addType(id);
				enm.setName(e.getName());
				enm.setDescription(e.getDescription());
			}
		}

		for (Object type : types) {
			// build class fields
			if (type instanceof Tml.Types.Class) {
				Tml.Types.Class c = (Tml.Types.Class) type;
				Class cls = (Class) schema
						.findType(Class.nameToId(c.getName()));

				List<Field> fields = new ArrayList<Field>();
				for (Tml.Types.Class.Field f : c.getField()) {
					Field field = new Field();
					field.setName(f.getName());
					field.setDisplayName(f.getDisplayname());
					field.setType(schema.addType(f.getType()));
					field.setDescription(f.getDescription());
					Map<String, String> attributes = new TreeMap<String, String>();
					for (Map.Entry<QName, String> attr : f.getOtherAttributes()
							.entrySet()) {
						attributes.put(attr.getKey().getLocalPart(),
								attr.getValue());
					}
					field.setAttributes(attributes);
					fields.add(field);
				}
				cls.setFields(fields);
			} else if (type instanceof Tml.Types.Enum) {
				Tml.Types.Enum e = (Tml.Types.Enum) type;
				Enum enm = (Enum) schema.findType(Enum.nameToId(e.getName()));

				List<EnumEntry> entries = new ArrayList<EnumEntry>();
				for (Tml.Types.Enum.Entry tmlEntry : e.getEntry()) {
					entries.add(new EnumEntry(tmlEntry.getName(), tmlEntry
							.getValue(), tmlEntry.getDescription()));
				}

				enm.setEntries(entries);
			}
		}

		// check if there are undefined user types
		for (Type type : schema.getTypes()) {
			String id = type.getTypeId();
			if (type.isUserType() && !userTypeIdSet.contains(id)) {
				throw new TeslaSchemaException(String.format(
						"Undefined user type '%s'", type.getTypeId()));
			}
		}

		schema.setVersion(ver);
		return schema;

	}
}

class TmlNode {
	private File file;
	private SchemaVersion version;
	private Tml tml;

	public TmlNode(File file, SchemaVersion version, Tml tml) {
		this.file = file;
		this.version = version;
		this.tml = tml;
	}

	public File getFile() {
		return file;
	}

	public SchemaVersion getVersion() {
		return version;
	}

	public Tml getTml() {
		return tml;
	}

	public void acceptVisitor(TmlVisitor visitor) throws Exception {
		visitor.visit(this);
	}
}

interface TmlVisitor {
	void visit(TmlNode tml) throws Exception;
}

class TmlGraph {
	private final Map<File, TmlNode> vertices = new HashMap<File, TmlNode>();
	private final Map<File, List<File>> edges = new HashMap<File, List<File>>();
	private static JAXBContext jaxbContext;

	static {
		try {
			jaxbContext = JAXBContext.newInstance(Tml.class);
		} catch (JAXBException e) {
			throw new RuntimeException("Failed to create JAXB context.", e);
		}
	}

	public TmlGraph(File file) throws Exception {
		build(file);
	}

	private TmlNode build(File file) throws Exception {
		if (hasVertex(file)) {
			return findVertex(file);
		}

		TmlNode current = readTml(file);
		addVertex(current);

		for (Tml.Import imp : current.getTml().getImport()) {
			addEdge(current, build(new File(imp.getFile())));
		}
		return current;
	}

	private void addEdge(TmlNode current, TmlNode imported) {
		edges.get(current.getFile()).add(imported.getFile());
	}

	private void addVertex(TmlNode v) {
		File cf = v.getFile();

		assert (!hasVertex(cf));
		assert (!vertices.containsKey(cf));
		assert (!edges.containsKey(cf));

		vertices.put(cf, v);
		edges.put(cf, new ArrayList<File>());
	}

	public TmlNode findVertex(File file) {
		return vertices.get(file);
	}

	public boolean hasVertex(File file) {
		return findVertex(file) != null;
	}

	public Collection<TmlNode> imports(File file) {
		assert (hasVertex(file));
		Collection<TmlNode> imported = new ArrayList<TmlNode>();
		for (File f : edges.get(file)) {
			assert (hasVertex(f));
			imported.add(findVertex(f));
		}
		return imported;
	}

	private static TmlNode readTml(File file) throws Exception {
		validateTml(file);
		Tml tml = unmarshallTml(file);
		SchemaVersion version = new SchemaVersion(0L, tml.getVersion()
				.getNumber() == null ? (short) 0 : tml.getVersion().getNumber()
				.shortValue(), tml.getVersion().getName(),
				file.getAbsolutePath());
		return new TmlNode(file, version, tml);
	}

	private static void validateTml(File file) throws Exception {
		URL schemaFile = TmlGraph.class.getClassLoader().getResource(
				"tml-v2.xsd");
		Source xmlFile = new StreamSource(file);
		Validator validator = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
				.newSchema(schemaFile).newValidator();
		try {
			validator.validate(xmlFile);
		} catch (SAXParseException ex) {
			throw new TeslaSchemaException("Invalid TML: "
					+ file.getCanonicalPath(), ex);
		}
	}

	public static Tml unmarshallTml(File file) throws JAXBException {
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		return (Tml) unmarshaller.unmarshal(file);
	}

	public static void marshallTml(Tml tml, OutputStream os)
			throws IOException, JAXBException {
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.marshal(tml, os);
	}

	private static long getSchemaHash(String filename)
			throws NoSuchAlgorithmException, IOException {
		return getSchemaHash(new FileInputStream(filename));
	}

	private static long getSchemaHash(InputStream is)
			throws NoSuchAlgorithmException, IOException {
		MessageDigest md = MessageDigest.getInstance("SHA1");
		try {
			DigestInputStream dis = new DigestInputStream(is, md);
			while (dis.read() != -1)
				;
			byte[] digest = md.digest();
			return (new BigInteger(digest)).longValue();
		} finally {
			is.close();
		}
	}
}