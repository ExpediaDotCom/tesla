/**
 *
 * Compiler.java
 *
 * Copyright 2013 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.tesla.compiler;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.BOMInputStream;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.expedia.tesla.TeslaException;
import com.expedia.tesla.TeslaVersion;
import com.expedia.tesla.compiler.plugins.JavaTypeMapper;
import com.expedia.tesla.schema.Schema;
import com.expedia.tesla.SchemaVersion;
import com.expedia.tesla.schema.TeslaSchemaException;
import com.expedia.tesla.schema.tml.v2.TmlProcessor;

/**
 * Telsa compiler compiles Tesla schema file (TML) into source code. This is the
 * entry point of the compiler tool.
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 */
public class Compiler {
	private CmdOpt cmdopt;

	public CmdOpt getCmdopt() {
		return cmdopt;
	}

	public void setCmdopt(CmdOpt cmdopt) {
		this.cmdopt = cmdopt;
	}

	public void run(String[] args) throws Exception {
		cmdopt = new CmdOpt(args);
		if (cmdopt.jspath != null) {
			runJavascript();
		} else if (cmdopt.genTmlRootClasses != null) {
			genTml();
		} else {
			compile();
		}
	}

	public void javascript(FileReader script) throws IOException {
		Context cx = Context.enter();
		try {
			Scriptable scope = cx.initStandardObjects();

			Object jsOut = Context.javaToJS(System.out, scope);
			ScriptableObject.putProperty(scope, "out", jsOut);
			ScriptableObject.putProperty(scope, "compiler", this);

			Object result = cx.evaluateReader(scope, script, "<cmd>", 1, null);
			System.err.println(Context.toString(result));
		} finally {
			Context.exit();
		}
	}

	public void compile() throws Exception {
		List<Schema> schemas = loadSchemas();
		writeSourceFiles(schemas);
	}

	public void runJavascript() throws Exception {
		FileReader r = new FileReader(this.cmdopt.jspath);
		javascript(r);
	}

	public void genTml() throws Exception {
		SchemaVersion ver = new SchemaVersion(0L, (short) 1,
				"generated schema", null);
		if (cmdopt.schemaVersion != null) {
			short vno = Short.parseShort(cmdopt.schemaVersion
					.getProperty("number"));
			String vname = cmdopt.schemaVersion.getProperty("name");
			ver = new SchemaVersion(0L, vno, vname, null);
		}
		JavaTypeMapper mapper = new JavaTypeMapper();
		Schema schema = new Schema();
		schema.setVersion(ver);

		for (String name : cmdopt.genTmlRootClasses) {
			try {
				java.lang.Class<?> clzz = loadClass(name, cmdopt.classpath);
				mapper.fromJavaClass(schema, clzz);
			} catch (ClassNotFoundException ex) {
				throw new TeslaCompilerException(
						String.format(
								"Could not found class '%s', please make sure you have "
										+ "set the classpath correctly by either JVM classpath or use compiler's '-cp' command line option.",
								name), ex);
			}
		}
		TmlProcessor.save(schema, new FileOutputStream(cmdopt.tmlFiles[0]));
	}

	/**
	 * Parse Tesla Schema file(s) (TML).
	 * 
	 * @return A list of schema objects.
	 * @throws IOException
	 *             If there was any file system errors.
	 * @throws TeslaSchemaException
	 *             If there was any error other than IO failures happened when
	 *             the TML files were parsed.
	 */
	public List<Schema> loadSchemas() throws IOException, TeslaSchemaException {
		return loadSchemas(cmdopt.tmlFiles);
	}

	/**
	 * Parse Tesla Schema file(s) (TML).
	 * 
	 * @param files
	 *            The paths of all TML files.
	 * @return A list of schema objects.
	 * @throws IOException
	 *             If there was any file system errors.
	 * @throws TeslaSchemaException
	 *             If there was any error other than IO failures happened when
	 *             the TML files were parsed.
	 */
	public List<Schema> loadSchemas(String[] files) throws IOException,
			TeslaSchemaException {
		try {
			List<Schema> schemas = new ArrayList<Schema>();
			for (String tml : files) {
				TmlVersionInfo vi;
				vi = getTmlVersion(tml);
				if (vi.teslaVersion == TeslaVersion.V2) {
					Schema schema = TmlProcessor.build(tml);
					schemas.add(schema);
				} else {
					for (short i = vi.minSchemaVersion; i <= vi.maxSchemaVersion; i++) {
						String xsl = getXsl(tml, i);
						StreamSource xslSource = new StreamSource(
								new StringReader(xsl));
						Transformer transformer = TransformerFactory
								.newInstance().newTransformer(xslSource);
						BOMInputStream input = new BOMInputStream(
								new FileInputStream(tml));
						StreamSource xmlSource = new StreamSource(input);
						StringWriter writer = new StringWriter();
						transformer.setOutputProperty(OutputKeys.METHOD, "xml");
						transformer.setOutputProperty(OutputKeys.INDENT, "yes");
						transformer.setOutputProperty(
								"{http://xml.apache.org/xslt}indent-amount",
								"2");
						transformer.transform(xmlSource, new StreamResult(
								writer));

						File temp = File.createTempFile(
								String.format("%s-v%d", tml, i), ".tmp");

						schemas.add(TmlProcessor.build(temp.getAbsolutePath()));
					}
				}
			}
			checkVersions(schemas);

			return schemas;
		} catch (Exception e) {
			throw new TeslaSchemaException("Failed to parse TML(s).", e);
		}
	}

	public List<MergedClass> mergeClasses(List<Schema> schemas)
			throws TeslaSchemaException {
		return MergedClass.merge(schemas);
	}

	public List<MergedEnum> mergeEnums(List<Schema> schemas)
			throws TeslaSchemaException {
		return MergedEnum.merge(schemas);
	}

	public String getLanguage() {
		return cmdopt.language;
	}

	public void setLanguage(String language) {
		cmdopt.language = language;
	}

	public void writeSourceFiles(List<Schema> schemas) throws Exception {
		writeClasses(mergeClasses(schemas));
		writeEnums(mergeEnums(schemas));
		writeAppSchema(schemas);
	}

	public Template createTemplate(String path, String defaultTemplate) {
		String defaultResourcePath = "resources/" + cmdopt.language + "/"
				+ defaultTemplate;
		if (path == null || path.isEmpty()) {
			path = defaultResourcePath;
		}

		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "file, classpath");
		ve.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, "");
		ve.setProperty("classpath.resource.loader.class",
				ClasspathResourceLoader.class.getName());
		ve.init();

		try {
			return ve.getTemplate(path);
		} catch (ResourceNotFoundException ex) {
			if (path != defaultResourcePath) {
				return ve.getTemplate(defaultResourcePath);
			} else {
				throw ex;
			}
		}
	}

	public String getResourceAbsolutePath(String path) {
		if (path != null && !path.isEmpty() && new File(path).exists()) {
			return new File(path).getAbsolutePath();
		}
		return "resources/" + cmdopt.language + "/" + path;
	}

	public void checkVersions(List<Schema> schemas) throws TeslaSchemaException {
		Set<String> versionNames = new TreeSet<String>();
		for (Schema schema : schemas) {
			String name = schema.getVersion().getName().toUpperCase();
			if (versionNames.contains(name)) {
				throw new TeslaSchemaException(String.format(
						"Duplicated schema name \"%s\". "
								+ "Schema name is case insensitive.", name));
			}
			versionNames.add(name);
		}
	}

	public void loadExtension(Map<String, Object> variables) throws Exception {
		if (cmdopt.extension != null) {
			for (String varName : cmdopt.extension.stringPropertyNames()) {
				String varClassName = cmdopt.extension.getProperty(varName);
				java.lang.Class<?> clazz = java.lang.Class
						.forName(varClassName);
				variables.put(varName, clazz.newInstance());
			}
		}
	}

	public void writeEnums(List<MergedEnum> enums) throws Exception {
		Template template = createTemplate(cmdopt.enumTemplatePath, "enum.vm");
		for (MergedEnum me : enums) {
			Map<String, Object> variables = new TreeMap<String, Object>();
			variables.put("enum", me);
			variables.put("util", createUtilObject());
			loadExtension(variables);
			VelocityContext context = createContext(variables);

			Writer writer = null;
			try {
				writer = new FileWriter(getOutputPath(me.getName()));
				template.merge(context, writer);
			} finally {
				if (writer != null) {
					writer.close();
				}
			}
		}
	}

	public String getOutputPath(String fullName) {
		String path = null;
		if (cmdopt.language.equals("java")) {
			path = FilenameUtils.concat(cmdopt.outputDir,
					fullName.replace('.', File.separatorChar))
					+ ".java";
		} else if (cmdopt.language.equals("csharp")) {
			String[] tmp = fullName.split("\\.");
			path = FilenameUtils.concat(cmdopt.outputDir, tmp[tmp.length - 1]
					+ ".cs");
		} else if (cmdopt.language.equals("cpp")) {
			String[] tmp = fullName.split("\\.");
			path = FilenameUtils.concat(cmdopt.outputDir, tmp[tmp.length - 1]
					+ ".h");
		}
		File dir = new File(path).getParentFile();
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return path;
	}

	public void writeClasses(List<MergedClass> classes) throws Exception {
		Template template = createTemplate(cmdopt.classTemplatePath, "class.vm");
		Template derivedTemplate = cmdopt.mtcWithDrived ? createTemplate(
				"class_mtc.vm", "class_mtc.vm") : null;
		for (MergedClass mc : classes) {
			Map<String, Object> variables = new TreeMap<String, Object>();
			variables.put("class", mc);
			variables.put("util", createUtilObject());
			variables.put("serializerName", cmdopt.appSchemaClassName);
			if (cmdopt.extension != null) {
				for (String varName : cmdopt.extension.stringPropertyNames()) {
					String varClassName = cmdopt.extension.getProperty(varName);
					java.lang.Class<?> clazz = java.lang.Class
							.forName(varClassName);
					variables.put(varName, clazz.newInstance());
				}
			}
			VelocityContext context = createContext(variables);
			Writer writer = null;
			try {
				if (derivedTemplate != null) {
					writer = new FileWriter(getOutputPath(mc.getName()));
					derivedTemplate.merge(context, writer);
				}

				// transform namespace
				String namespace = mc.getNameSpace();
				if (cmdopt.mtc && namespace != null && !namespace.isEmpty()) {
					mc.setNameSpace(namespace + ".g");
				}
				context.put("isAbastract", cmdopt.mtc);
				if (writer != null) {
					writer.close();
				}
				writer = new FileWriter(getOutputPath(mc.getName()));
				template.merge(context, writer);
				// restore namespace
				if (cmdopt.mtc && namespace != null && !namespace.isEmpty()) {
					mc.setNameSpace(namespace);
				}
			} finally {
				if (writer != null) {
					writer.close();
				}
			}
		}
	}

	public VelocityContext createContext(Map<String, Object> variables) {
		VelocityContext context = new VelocityContext();
		if (variables != null) {
			for (String varName : variables.keySet()) {
				context.put(varName, variables.get(varName));
			}
		}
		return context;
	}

	@SuppressWarnings("deprecation")
	private Object createUtilObject() {
		if (cmdopt.language.equals("java")) {
			return new JavaUtils();
		} else if (cmdopt.language.equals("cpp")) {
			return new CppUtils();
		} else if (cmdopt.language.equals("csharp")) {
			return new CSharpUtils();
		}
		return null;
	}

	public void writeAppSchema(List<Schema> schemas) throws IOException {
		if (cmdopt.appSchemaClassName == null
				|| cmdopt.appSchemaClassName.isEmpty()) {
			return;
		}

		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class",
				ClasspathResourceLoader.class.getName());
		ve.init();

		String appSchemaClassShortName = cmdopt.appSchemaClassName;
		String appSchemaClassNamespace = null;
		if (cmdopt.appSchemaClassName.matches(".+\\..+")) {
			int pos = cmdopt.appSchemaClassName.lastIndexOf('.');
			appSchemaClassShortName = cmdopt.appSchemaClassName
					.substring(pos + 1);
			appSchemaClassNamespace = cmdopt.appSchemaClassName.substring(0,
					pos);
		}

		String defaultTemplate = cmdopt.language.equals("java") ? "serializer.vm"
				: "application_schema.vm";
		Template template = createTemplate(cmdopt.appSchemaTemplatePath,
				defaultTemplate);
		VelocityContext context = new VelocityContext();
		context.put("schemas", schemas);
		context.put("className", appSchemaClassShortName);
		context.put("namespace", appSchemaClassNamespace);
		context.put("util", createUtilObject());
		context.put("mapper", new JavaTypeMapper());

		Writer writer = new FileWriter(getOutputPath(cmdopt.appSchemaClassName));
		template.merge(context, writer);
		writer.flush();
		writer.close();
	}

	public String getXsl(String tml, short versionNumber) throws IOException {
		InputStream is = this.getClass().getResourceAsStream(
				"resources/tml-convert-v1.xsl");
		return IOUtils.toString(is)
				.replaceAll("SCHEMA_VERSION", Short.toString(versionNumber))
				.replaceAll("NAME_SPACE", cmdopt.namespace)
				.replaceAll("TML_FILE_NAME", new File(tml).getName());
	}

	public TmlVersionInfo getTmlVersion(String path)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		Document doc = factory.newDocumentBuilder().parse(path);
		Element root = doc.getDocumentElement();
		TmlVersionInfo vi = new TmlVersionInfo();
		String nm = root.getNamespaceURI();
		if (nm == "urn:expedia:tesla:tml:v1") {
			Element classesNode = (Element) root.getElementsByTagNameNS(
					"urn:expedia:tesla:tml:v1", "Classes").item(0);
			vi.teslaVersion = TeslaVersion.V1;
			vi.minSchemaVersion = Short.parseShort(classesNode
					.getAttribute("minVersion"));
			vi.maxSchemaVersion = Short.parseShort(classesNode
					.getAttribute("maxVersion"));
		} else if (nm == "urn:expedia:tesla:tml:v2") {
			vi.teslaVersion = TeslaVersion.V2;
		} else {
			throw new AssertionError("Unexpected TML version");
		}
		return vi;
	}

	public URL[] parseClassPath(String classpath) throws IOException {
		final String splitPattern = Character.toString(File.pathSeparatorChar);
		final String wildcardPattern = ".+\\*";
		String[] paths = classpath.split(splitPattern);
		List<URL> urls = new ArrayList<URL>();
		for (String path : paths) {
			path = path.trim();
			if (path.matches(wildcardPattern)) {
				File folder = new File(path.replace("\\*", ""));
				if (folder.exists()) {
					File[] files = folder.listFiles();
					for (File f : files) {
						urls.add(f.toURI().toURL());
					}
				}
			} else {
				urls.add(new File(path).toURI().toURL());
			}
		}
		URL[] result = new URL[urls.size()];
		return urls.toArray(result);
	}

	/**
	 * Load a Java class by it's full name.
	 * 
	 * @param name
	 *            The full name of the Java class to load.
	 * @param classpath
	 *            The class paths or jar files from where the Java class be
	 *            loaded. If this is null or empty string. {@code loadClass}
	 *            will try to load from JVM classpath instead.
	 * @return The java.lang.Class object represents the Java class.
	 * @throws ClassNotFoundException
	 *             If the class is not found.
	 * @throws IOException
	 *             If the jar file cannot open.
	 */
	public java.lang.Class<?> loadClass(String name, String classpath)
			throws ClassNotFoundException, IOException {
		return loadClass(name,
				(classpath == null || classpath.isEmpty()) ? null
						: parseClassPath(classpath));
	}

	/**
	 * Load a Java class by it's full name.
	 * 
	 * @param name
	 *            The full name of the Java class to load.
	 * @param urls
	 *            An array of URL objects represent class paths or jar files.
	 * @return The java.lang.Class object represents the Java class.
	 * @throws ClassNotFoundException
	 *             If the class is not found.
	 * @throws IOException
	 *             If the jar file cannot open.
	 */
	public java.lang.Class<?> loadClass(String name, URL[] urls)
			throws ClassNotFoundException, IOException {
		java.lang.Class<?> clzz = null;
		if (urls != null && urls.length > 0) {
			URLClassLoader cl = URLClassLoader.newInstance(urls);
			clzz = cl.loadClass(name);
		}

		if (clzz == null) {
			clzz = Class.forName(name);
		}

		return clzz;
	}

	class TmlVersionInfo {
		TeslaVersion teslaVersion;
		short minSchemaVersion;
		short maxSchemaVersion;
	}

	public static class CmdOpt {

		String language = "java";
		String namespace = "";
		String appSchemaClassName = null;
		String outputDir = System.getProperty("user.dir");
		String classTemplatePath;
		String enumTemplatePath;
		String appSchemaTemplatePath;
		boolean mtc = false;
		boolean mtcWithDrived = false;
		Properties extension;
		String[] tmlFiles;
		String jspath;
		String[] genTmlRootClasses;
		String classpath;
		Properties schemaVersion;

		public CmdOpt() {
		}

		public CmdOpt(String[] args) {
			parseCmdOptions(args);
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public String getNamespace() {
			return namespace;
		}

		public void setNamespace(String namespace) {
			this.namespace = namespace;
		}

		public String getAppSchemaClassName() {
			return appSchemaClassName;
		}

		public void setAppSchemaClassName(String appSchemaClassName) {
			this.appSchemaClassName = appSchemaClassName;
		}

		public String getOutputDir() {
			return outputDir;
		}

		public void setOutputDir(String outputDir) {
			this.outputDir = outputDir;
		}

		public String getClassTemplatePath() {
			return classTemplatePath;
		}

		public void setClassTemplatePath(String classTemplatePath) {
			this.classTemplatePath = classTemplatePath;
		}

		public String getEnumTemplatePath() {
			return enumTemplatePath;
		}

		public void setEnumTemplatePath(String enumTemplatePath) {
			this.enumTemplatePath = enumTemplatePath;
		}

		public String getAppSchemaTemplatePath() {
			return appSchemaTemplatePath;
		}

		public void setAppSchemaTemplatePath(String appSchemaTemplatePath) {
			this.appSchemaTemplatePath = appSchemaTemplatePath;
		}

		public boolean isMtc() {
			return mtc;
		}

		public void setMtc(boolean mtc) {
			this.mtc = mtc;
		}

		public boolean isMtcWithDrived() {
			return mtcWithDrived;
		}

		public void setMtcWithDrived(boolean mtcWithDrived) {
			this.mtcWithDrived = mtcWithDrived;
		}

		public Properties getExtension() {
			return extension;
		}

		public void setExtension(Properties extension) {
			this.extension = extension;
		}

		public String[] getTmlFiles() {
			return tmlFiles;
		}

		public void setTmlFiles(String[] tmlFiles) {
			this.tmlFiles = tmlFiles;
		}

		public String getJspath() {
			return jspath;
		}

		public void setJspath(String jspath) {
			this.jspath = jspath;
		}

		public String[] getGenTmlRootClasses() {
			return genTmlRootClasses;
		}

		public void setGenTmlRootClasses(String[] genTmlRootClasses) {
			this.genTmlRootClasses = genTmlRootClasses;
		}

		public String getClasspath() {
			return classpath;
		}

		public void setClasspath(String classpath) {
			this.classpath = classpath;
		}

		public Properties getSchemaVersion() {
			return schemaVersion;
		}

		public void setSchemaVersion(Properties schemaVersion) {
			this.schemaVersion = schemaVersion;
		}

		@SuppressWarnings("static")
		private boolean parseCmdOptions(String[] args) {
			Options options = new Options();

			options.addOption(OptionBuilder
					.withArgName("language")
					.withLongOpt("language")
					.hasArg()
					.withDescription(
							"The output code language (Java, C# or C++).")
					.isRequired(false).create("l"));
			options.addOption(OptionBuilder
					.withArgName("class-template")
					.hasArg()
					.withDescription(
							"Apache Velocity template file used to "
									+ "generate source code for classes.")
					.isRequired(false).create("t"));
			options.addOption(OptionBuilder
					.withArgName("enum-template")
					.hasArg()
					.withDescription(
							"Apache Velocity template file used to "
									+ "generate source code for enum types.")
					.isRequired(false).create("m"));
			options.addOption(OptionBuilder
					.withArgName("appschema-template")
					.hasArg()
					.withDescription(
							"Apache Velocity template file used to "
									+ "generate source code for application schema type.")
					.isRequired(false).create("v"));
			options.addOption(OptionBuilder
					.withArgName("class.name")
					.withDescription(
							"Generate application schema manager help "
									+ "class. Must include the full name with name space (e.g. "
									+ "com.expedia.sample.AppSchema). Please don't include the "
									+ "srouce file extension name.")
					.withLongOpt("appschema").hasArg().create("s"));
			options.addOption(OptionBuilder.withDescription(
					"Generate MTC data model objects as base classes.").create(
					"mtc"));
			options.addOption(OptionBuilder
					.withLongOpt("mtc-with-entity")
					.withDescription(
							"Generate source code templates for MTC data model domain objects. These classes will have"
									+ " auto generated base classes which are pure data objects.")
					.create("mtcdo"));
			options.addOption(OptionBuilder
					.withArgName("namespace")
					.hasArg()
					.withDescription(
							"TML V1 only. The output code name space. "
									+ "Empty namespace by default.")
					.isRequired(false).create("n"));
			options.addOption(OptionBuilder
					.withArgName("output-path")
					.hasArg()
					.withLongOpt("output")
					.withDescription(
							"The output directory. Output to current "
									+ "directory by default.")
					.isRequired(false).create("o"));
			options.addOption(OptionBuilder.withArgName("file-path").hasArg()
					.withLongOpt("javascript")
					.withDescription("The path of javascript file.")
					.isRequired(false).create("j"));
			options.addOption(OptionBuilder
					.withArgName("variable=class_name")
					.withLongOpt("extension")
					.hasArgs()
					.withValueSeparator()
					.withDescription(
							"Define extension "
									+ "context. Compiler will create an instance of <class_name> "
									+ "and put it into Velocity template context. This object can be "
									+ "referred in user template by $<varialbe>.")
					.create("E"));
			options.addOption(OptionBuilder
					.withArgName("class-name")
					.hasArg()
					.withLongOpt("gentml")
					.withDescription(
							"Generate schema (TML file) from the user class definition by"
									+ " java reflection. The compiler will load the class by name and "
									+ "generate Tesla fields for all public properties by default. "
									+ "Please use -classpath option to specify the search path "
									+ "for your class, or put them in JVM classpath.")
					.create("g"));
			options.addOption(OptionBuilder
					.withArgName("class-path")
					.hasArg()
					.withLongOpt("classpath")
					.withDescription(
							"Java classpath that compiler will search for user classes.")
					.create("cp"));
			options.addOption(OptionBuilder
					.withArgName("component=value")
					.withLongOpt("schema-version")
					.hasArgs()
					.withValueSeparator()
					.withDescription(
							"Specify a schema version name and (or) version number for the generated schema. This"
									+ " will only be used when -g or -gentml option is used. Version name is required while "
									+ "version number is option. For more information about Tesla schema version, please refer"
									+ " Tesla documentation or specification. Sample:\n -sv \"name=Abc Service v2.5.1\" "
									+ "number=6").create("sv"));
			options.addOption("h", "help", false, "print this message. ");

			CommandLineParser parser = new PosixParser();
			CommandLine cmd = null;
			boolean invalidCmd = false;
			try {
				cmd = parser.parse(options, args);
			} catch (ParseException e) {
				invalidCmd = true;
			}

			// if h is passed, print cmd help and continue
			if (cmd != null && cmd.hasOption("h"))
				(new HelpFormatter())
						.printHelp(
								"tgen <OPTION>... <SCHEMA_FILE>...\n"
										+ "generate source code from Tesla schema files.",
								options);

			if (cmd != null) {
				tmlFiles = cmd.getArgs();
				if (tmlFiles == null || tmlFiles.length == 0) {
					invalidCmd = true;
				}
			}

			if (invalidCmd) {
				(new HelpFormatter())
						.printHelp(
								"tgen <OPTION>... <SCHEMA_FILE>...\n"
										+ "generate source code from Tesla schema files.",
								options);
				return false;
			}

			if (cmd.hasOption("l")) {
				language = cmd.getOptionValue("l").toLowerCase();
				if (language.equals("c#"))
					language = "csharp";
				if (language.equals("c++"))
					language = "cpp";
			}
			if (cmd.hasOption("t")) {
				classTemplatePath = cmd.getOptionValue("t");
			}
			if (cmd.hasOption("m")) {
				enumTemplatePath = cmd.getOptionValue("m");
			}
			if (cmd.hasOption("v")) {
				appSchemaTemplatePath = cmd.getOptionValue("v");
			}
			if (cmd.hasOption("n")) {
				namespace = cmd.getOptionValue("n");
			}
			if (cmd.hasOption("s")) {
				appSchemaClassName = cmd.getOptionValue("s");
			}
			if (cmd.hasOption("o")) {
				outputDir = cmd.getOptionValue("o");
				outputDir = new File(outputDir).getAbsolutePath();
			}
			mtc = cmd.hasOption("mtc");
			mtcWithDrived = cmd.hasOption("mtcdo");
			if (cmd.hasOption("E")) {
				extension = cmd.getOptionProperties("E");
			}
			if (cmd.hasOption("j")) {
				jspath = cmd.getOptionValue("j");
			}
			if (cmd.hasOption("g")) {
				genTmlRootClasses = cmd.getOptionValue("g").split("[,|:|;]");
			}
			if (cmd.hasOption("cp")) {
				classpath = cmd.getOptionValue("cp");
			}
			if (cmd.hasOption("sv")) {
				schemaVersion = cmd.getOptionProperties("sv");
			}

			return true;
		}

	}

	public static void main(String[] args) {
		try {
			new Compiler().run(args);
		} catch (Exception e) {
			System.err.printf("Error: %s\n", e.getMessage());
			e.printStackTrace();
		}
	}
}