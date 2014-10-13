/*******************************************************************************
 * Copyright (c) 2014 Expedia Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package com.expedia.tesla.schema;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.JAXBException;

import com.expedia.tesla.SchemaVersion;

/**
 * A Tesla schema defines an application object version.
 * <p>
 * A Tesla schema file (TML) defines a version of Tesla user types:
 * {@link Class}s or {@link Enum}s. They may refer predefined Tesla types such
 * as {@link Primitive}, {@link Nullable}, {@link Reference}, {@link Array},
 * {@link Map} and {@link Poly}.
 * <p>
 * User types are required to have a type name, while predefined types may or
 * may not have one.
 * <p>
 * Tesla type id is the unique string identification of all types defined in a
 * Tesla schema. It has the format as following:
 * {@code [class|enum|array|map|poly|reference][extra_interface,extrea_concrete_type]<element_type1[,element_type2]...>}
 * <p>
 * <b>Examples:</b>
 * <ul>
 * <li>{@code class<MyClass>}: user class {@code MyClass}</li>
 * <li>{@code class<MyEunm>}: enum {@code MyEnum}</li>
 * <li>{@code array<int32>}: {@code int32} array</li>
 * <li>{@code array<array<int32>>}: 2-D {@code int32} array</li>
 * <li>{@code array<class<MyClass>>}: {@code MyClass} array, this is equivalent
 * to {@code array[java.util.List,java.util.ArrayList]<class<MyClass>>}</li>
 * <li>{@code may<int32,class<MyClass>>}: map with {@code int32} keys and
 * {@code MyClass} values, this is equivalent to
 * {@code may[java.util.map,java.util.HashMap]<int32,class<MyClass>>}</li>
 * <li>{@code may[java.util.map,java.util.TreeMap]<int32,class<MyClass>>}: map
 * with {@code int32} keys and {@code MyClass} values, with language specific
 * type information</li>
 * </ul>
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 * 
 */
public class Schema {

	public static final String TYPE_ID_PATTERN = "((?<=<)|(?=<))|((?<=>)|(?=>))|((?<=\\[)|(?=\\[))|((?<=\\])|(?=\\]))|((?<=,)|(?=,))";
	public static final java.util.Map<String, Type> PRIMITIVES = new java.util.HashMap<String, Type>();

	static {
		PRIMITIVES.put(Primitive.BYTE.getTypeId(), Primitive.BYTE);
		PRIMITIVES.put(Primitive.INT16.getTypeId(), Primitive.INT16);
		PRIMITIVES.put(Primitive.INT32.getTypeId(), Primitive.INT32);
		PRIMITIVES.put(Primitive.INT64.getTypeId(), Primitive.INT64);
		PRIMITIVES.put(Primitive.UINT16.getTypeId(), Primitive.UINT16);
		PRIMITIVES.put(Primitive.UINT32.getTypeId(), Primitive.UINT32);
		PRIMITIVES.put(Primitive.UINT64.getTypeId(), Primitive.UINT64);
		PRIMITIVES.put(Primitive.BOOLEAN.getTypeId(), Primitive.BOOLEAN);
		PRIMITIVES.put(Primitive.FLOAT.getTypeId(), Primitive.FLOAT);
		PRIMITIVES.put(Primitive.DOUBLE.getTypeId(), Primitive.DOUBLE);
		PRIMITIVES.put(Primitive.STRING.getTypeId(), Primitive.STRING);
		PRIMITIVES.put(Primitive.BINARY.getTypeId(), Primitive.BINARY);
	}

	protected SchemaVersion version;
	protected java.util.Map<String, Type> typeMap = new java.util.HashMap<String, Type>();

	/**
	 * Load a Tesla schema from TML file.
	 * 
	 * @param path
	 *            The path of the TML file
	 * @return The schema object.
	 * @throws TeslaSchemaException
	 *             On schema errors.
	 * @throws IOException
	 *             On IO errors.
	 */
	public static Schema build(String path) throws TeslaSchemaException,
			IOException {
		return TmlProcessor.build(path);
	}

	/**
	 * Save the schema in TML file.
	 * 
	 * @param os
	 *            The output stream where the TML will be written to.
	 * @throws IOException
	 *             On IO errors.
	 * @throws JAXBException
	 *             If any unexpected problem occurs during the marshalling.
	 */
	public void save(OutputStream os) throws IOException, JAXBException {
		TmlProcessor.save(this, os);
	}

	/**
	 * Get a collection of all types defined in this schema. It includes not
	 * only user types such as {@code classe} and {@code Enum}, but also
	 * {@code Primitive}, {@code Nullable}, {@code Reference}, {@code Array},
	 * {@code Map} and {@code Poly}.
	 * 
	 * @return A collection of all types defined in this schema
	 */
	public Collection<Type> getTypes() {
		return typeMap.values();
	}

	/**
	 * Get a collection of all user types defined in this schema. It includes
	 * only user types such as {@code classe} and {@code Enum}.
	 * 
	 * @return A collection of all user types defined in this schema
	 */
	public Collection<UserType> getUserTypes() {
		Collection<UserType> uts = new ArrayList<UserType>();
		for (Type t : typeMap.values()) {
			if (t.isUserType()) {
				uts.add((UserType) t);
			}
		}
		return uts;
	}

	/**
	 * Find a type in the schema by either type id or type name.
	 * 
	 * @param id
	 * @return
	 */
	public Type findType(String idOrName) {
		if (typeMap.containsKey(idOrName)) {
			return typeMap.get(idOrName);
		} else if (typeMap.containsKey(Class.nameToId(idOrName))) {
			return typeMap.get(Class.nameToId(idOrName));
		} else if (typeMap.containsKey(Enum.nameToId(idOrName))) {
			return typeMap.get(Enum.nameToId(idOrName));
		}
		return null;
	}

	/**
	 * Get the current schema version.
	 * 
	 * @return Current schema version.
	 */
	public SchemaVersion getVersion() {
		return version;
	}

	/**
	 * Get all types that extend a specified type in the schema.
	 * 
	 * @param typeId
	 *            The base type id.
	 * @param directOnly
	 *            Only return the direct child types if this is true.
	 *            Otherwise, return all types that has the specified type in
	 *            its inheritance hierarchy.
	 * 
	 * @return A collection of derived types.
	 */
	public Collection<Type> getDerivedTypes(String baseTypeId,
			boolean directOnly) {
		return getDerivedTypes(typeMap.get(baseTypeId), directOnly);
	}

	/**
	 * Get all types that extend a specified type in the schema.
	 * 
	 * @param baseType
	 *            The base type.
	 * @param directOnly
	 *            Only return the direct child types if this is true.
	 *            Otherwise, return all types that has the specified type in
	 *            its inheritance hierarchy.
	 * 
	 * @return A collection of derived types.
	 */
	public Collection<Type> getDerivedTypes(Type baseType,
			boolean directOnly) {
		if (!baseType.isClass()) {
			return null;
		}
		java.util.Map<Type, Set<Type>> derivedTypeMap = createDerivedMap();
		return getDerivedTypes(baseType, directOnly, derivedTypeMap);
	}

	private Set<Type> getDerivedTypes(Type type, boolean directOnly,
			java.util.Map<Type, Set<Type>> derivedTypeMap) {
		Set<Type> drivedTypes = derivedTypeMap.get(type);
		if (directOnly) {
			return drivedTypes;
		}

		Set<Type> indirectDerivedTypes = new TreeSet<Type>();
		for (Type t : drivedTypes) {
			indirectDerivedTypes.addAll(getDerivedTypes(t, false,
					derivedTypeMap));
		}
		drivedTypes.addAll(indirectDerivedTypes);
		return drivedTypes;
	}

	private java.util.Map<Type, Set<Type>> createDerivedMap() {
		java.util.Map<Type, Set<Type>> derivedTypeMap = new java.util.TreeMap<Type, Set<Type>>();
		for (Type t : typeMap.values()) {
			if (t.isClass()) {
				derivedTypeMap.put(t, new TreeSet<Type>());
			}
		}
		for (Type t : typeMap.values()) {
			if (t.isClass()) {
				Class clss = (Class) t;
				for (Type base : clss.getBases()) {
					derivedTypeMap.get(base).add(clss);
				}
			}
		}
		return derivedTypeMap;
	}

	public static class SchemaBuilder extends Schema {
		
		public Schema build() {
			Schema schema = new Schema();
			schema.typeMap = this.typeMap;
			schema.version = this.version;
			return schema;
		}

		public Type addType(String id) throws TeslaSchemaException {
			Type t = findType(id);
			if (t != null) {
				return t;
			}

			String[] tokens = id.split(TYPE_ID_PATTERN);
			return addType(new PeekIterator<String>(Arrays.asList(tokens)
					.iterator()));
		}

		private Type addType(PeekIterator<String> itr)
				throws TeslaSchemaException {
			if (!itr.hasNext())
				return null;

			String token = itr.next();
			if (PRIMITIVES.containsKey(token)) {
				return cacheType(PRIMITIVES.get(token));
			} else if (token.equals("class")) {
				return addClass(itr);
			} else if (token.equals("enum")) {
				return addEnum(itr);
			} else if (token.equals("array")) {
				return addArray(itr);
			} else if (token.equals("nullable")) {
				return addNullable(itr);
			} else if (token.equals("poly")) {
				return addPoly(itr);
			} else if (token.equals("reference")) {
				return addReference(itr);
			} else if (token.equals("map")) {
				return addMap(itr);
			} else {
				throw new TeslaSchemaException(
						String.format(
								"Type '%s' is not defined. Do you mean 'class<%s>' or 'enum<%s>'?",
								token, token, token));
			}
		}

		private Type addClass(PeekIterator<String> itr)
				throws TeslaSchemaException {
			if (!itr.next().equals("<"))
				throw new TeslaSchemaException("");
			String name = itr.next();
			if (!itr.next().equals(">"))
				throw new TeslaSchemaException("");
			Class c = new Class();
			c.setName(name);
			return cacheType(c);
		}

		private Type addEnum(PeekIterator<String> itr)
				throws TeslaSchemaException {
			if (!itr.next().equals("<"))
				throw new TeslaSchemaException("");
			String name = itr.next();
			if (!itr.next().equals(">"))
				throw new TeslaSchemaException("");
			Enum e = new Enum();
			e.setName(name);
			return cacheType(e);
		}

		private Type addNullable(PeekIterator<String> itr)
				throws TeslaSchemaException {
			if (!itr.next().equals("<"))
				throw new TeslaSchemaException("");
			Type elementType = addType(itr);
			if (!itr.next().equals(">"))
				throw new TeslaSchemaException("");
			Nullable t = new Nullable();
			t.setElementType(elementType);
			return cacheType(t);
		}

		private Type addReference(PeekIterator<String> itr)
				throws TeslaSchemaException {
			if (!itr.next().equals("<"))
				throw new TeslaSchemaException("");
			Type elementType = addType(itr);
			if (!itr.next().equals(">"))
				throw new TeslaSchemaException("");
			Reference t = new Reference();
			t.setElementType(elementType);
			return cacheType(t);
		}

		private Type addArray(PeekIterator<String> itr)
				throws TeslaSchemaException {
			String containerTypeId = null;
			String token = itr.next();
			if (token.equals("[")) {
				containerTypeId = "";
				do {
					token = itr.next();
					if (token.equals("]")) {
						token = itr.next();
						break;
					}
					containerTypeId += token;
				} while (true);
			}
			if (!token.equals("<"))
				throw new TeslaSchemaException("" + token);
			Type elementType = addType(itr);
			if (!itr.next().equals(">"))
				throw new TeslaSchemaException("");
			Array t = new Array();
			t.setElementType(elementType);
			t.setExtraTypeId(containerTypeId);
			return cacheType(t);
		}

		private Type addMap(PeekIterator<String> itr)
				throws TeslaSchemaException {
			String containerTypeId = null;
			String token = itr.peek();
			if (token.equals("[")) {
				itr.next();
				containerTypeId = "";
				do {
					token = itr.next();
					if (token.equals("]")) {
						break;
					}
					containerTypeId += token;
				} while (true);
			}
			token = itr.next();
			if (!token.equals("<"))
				throw new TeslaSchemaException("Invalid map id, expect '<'");
			Type keyType = addType(itr);
			if (!itr.next().equals(",")) {
				throw new TeslaSchemaException("Invalid map id, expect ','");
			}
			Type valueType = addType(itr);
			if (!itr.next().equals(">"))
				throw new TeslaSchemaException("Invalid map id, expect '>'");
			Map t = new Map();
			t.setExtraTypeId(containerTypeId);
			t.setKeyType(keyType);
			t.setValueType(valueType);
			return cacheType(t);
		}

		private Type addPoly(PeekIterator<String> itr)
				throws TeslaSchemaException {
			if (!itr.next().equals("<"))
				throw new TeslaSchemaException("");
			List<Type> elementTypes = new ArrayList<Type>();
			Type elementType = null;
			String token = null;
			do {
				elementType = addType(itr);
				elementTypes.add(elementType);
				token = itr.next();
			} while (token.equals(","));
			if (!token.equals(">"))
				throw new TeslaSchemaException("");
			Poly t = new Poly();
			t.setElementTypes(elementTypes);
			return cacheType(t);
		}

		private Type cacheType(Type type) {
			String id = type.getTypeId();
			if (typeMap.containsKey(id)) {
				return typeMap.get(id);
			} else {
				typeMap.put(id, type);
				return type;
			}
		}

		public void setVersion(SchemaVersion schemaVersion) {
			this.version = schemaVersion;
		}

		void validate() throws TeslaSchemaException {
			// check if there are undefined user types
			for (UserType type : getUserTypes()) {
				if (!type.isDefined()) {
					throw new TeslaSchemaException(String.format(
							"Undefined user type '%s'", type.getTypeId()));
				}
			}

			// duplicated fields?
			for (UserType type : getUserTypes()) {
				if (type instanceof Class) {
					validateClass((Class) type);
				} else {
					validateEnum((Enum) type);
				}
			}
		}

		private void validateEnum(Enum type) throws TeslaSchemaException {
			Set<String> entryNames = new HashSet<>();
			for (EnumEntry entry : type.getEntries()) {
				if (entryNames.contains(entry.getName())) {
					throw new TeslaSchemaException(String.format(
							"Duplicated enum value '%s' defined in '%s'",
							entry.getName(), type.getTypeId()));
				} else {
					entryNames.add(entry.getName());
				}
			}
		}

		private void validateClass(Class type) throws TeslaSchemaException {
			List<Field> inheritedFields = type.getInheritedFields();
			List<Field> fields = type.getFields();
			Set<String> fieldNames = new HashSet<>();
			for (Field field : inheritedFields) {
				fieldNames.add(field.getName());
			}
			for (Field field : fields) {
				if (fieldNames.contains(field.getName())) {
					throw new TeslaSchemaException(String.format(
							"Duplicated field '%s' defined in '%s'",
							field.getName(), type.getTypeId()));
				}
				fieldNames.add(field.getName());
			}
		}
	}
}
