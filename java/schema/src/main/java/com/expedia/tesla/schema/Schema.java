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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

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

	/**
	 * The Regex pattern used to split Tesla type id string into tokens.
	 */
	public static final String TYPE_ID_TOKENIZER_PATTERN = 
			"((?<=<)|(?=<))|((?<=>)|(?=>))|((?<=\\[)|(?=\\[))|((?<=\\])|(?=\\]))|((?<=,)|(?=,))";
	private static final Pattern COMPILED_TYPE_ID_PATTERN = Pattern.compile(TYPE_ID_TOKENIZER_PATTERN);
	
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
			return Collections.emptyList();
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

		Set<Type> indirectDerivedTypes = new HashSet<Type>();
		for (Type t : drivedTypes) {
			indirectDerivedTypes.addAll(getDerivedTypes(t, false,
					derivedTypeMap));
		}
		drivedTypes.addAll(indirectDerivedTypes);
		return drivedTypes;
	}

	private java.util.Map<Type, Set<Type>> createDerivedMap() {
		java.util.Map<Type, Set<Type>> derivedTypeMap = new java.util.HashMap<Type, Set<Type>>();
		for (Type t : typeMap.values()) {
			if (t.isClass()) {
				derivedTypeMap.put(t, new HashSet<Type>());
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

			String[] tokens = COMPILED_TYPE_ID_PATTERN.split(id);
			return addType(new PeekIterator<String>(Arrays.asList(tokens).iterator()));
		}

		private Type addType(PeekIterator<String> itr)
				throws TeslaSchemaException {
			return Parser.add(itr, this);
		}

		private static abstract class Parser {
			protected static final java.util.Map<String, Parser> PARSERS = new HashMap<>();
			
			static {
				for (final Primitive t : Primitive.ALL_PRIMITIVES) {
					PARSERS.put(t.getTypeId(), new Parser(){
						@Override
						protected Type parse(PeekIterator<String> itr, 
								SchemaBuilder builder) throws TeslaSchemaException {
							return t;
						}
						@Override
						protected Type parseInternal(PeekIterator<String> itr, SchemaBuilder builder, 
								String containerTypeId) throws TeslaSchemaException {
							return t;
						}
					});
				}
				PARSERS.put("class", new Parser(){
					@Override
					protected Type parseInternal(PeekIterator<String> itr, SchemaBuilder builder, 
							String containerTypeId) throws TeslaSchemaException {
						return new Class(itr.next());
					}
				});
				PARSERS.put("enum", new Parser(){
					@Override
					protected Type parseInternal(PeekIterator<String> itr, SchemaBuilder builder, 
							String containerTypeId) throws TeslaSchemaException {
						return new Enum(itr.next());
					}
				});
				PARSERS.put("nullable", new Parser(){
					@Override
					protected Type parseInternal(PeekIterator<String> itr, SchemaBuilder builder, 
							String containerTypeId) throws TeslaSchemaException {
						return new Nullable(Parser.add(itr, builder));
					}
				});
				PARSERS.put("reference", new Parser(){
					@Override
					protected Type parseInternal(PeekIterator<String> itr, SchemaBuilder builder, 
							String containerTypeId) throws TeslaSchemaException {
						return new Reference(Parser.add(itr, builder));
					}
				});
				PARSERS.put("array", new Parser() {
						@Override
						protected Type parseInternal(PeekIterator<String> itr, SchemaBuilder builder, 
								String containerTypeId) throws TeslaSchemaException {
							Type elementType = Parser.add(itr, builder);
							return new Array(elementType, containerTypeId);
						}
				});
				PARSERS.put("map", new Parser() {
					@Override
					protected Type parseInternal(PeekIterator<String> itr, SchemaBuilder builder, 
							String containerTypeId) throws TeslaSchemaException {
						Type keyType = Parser.add(itr, builder);
						if (!",".equals(itr.next())) {
							throw new TeslaSchemaException("Invalid type id, expect ','");
						}
						Type valueType = Parser.add(itr, builder);
						
						return new Map(keyType, valueType, containerTypeId);
					}

				});
				PARSERS.put("poly", new Parser(){
					@Override
					protected Type parseInternal(PeekIterator<String> itr, SchemaBuilder builder, 
							String containerTypeId) throws TeslaSchemaException {
						List<Type> elementTypes = new ArrayList<Type>();
						while (true) {
							elementTypes.add(Parser.add(itr, builder));
							if (",".equals(itr.peek())) {
								itr.next();
							} else {
								break;
							}
						};
						return new Poly(elementTypes);
					}
				});
			}
			
			public static Type add(PeekIterator<String> itr, SchemaBuilder builder) throws TeslaSchemaException {
				if (!itr.hasNext())
					return null;

				String token = itr.next();
				Parser parser = PARSERS.get(token);
				if (parser == null) {
					throw new TeslaSchemaException(String.format(
						"Type '%s' is not defined. Do you mean 'class<%s>' or 'enum<%s>'?",
						token, token, token));
				}
				return builder.cacheType(parser.parse(itr, builder));
			}
			
			protected Type parse(PeekIterator<String> itr, SchemaBuilder builder) throws TeslaSchemaException {
				String containerTypeId = readContainerTypeId(itr);
				String token = itr.next();
				if (!"<".equals(token))
					throw new TeslaSchemaException("Invalid type id, expect '<'");
				Type t = parseInternal(itr, builder, containerTypeId);
				if (!">".equals(itr.next()))
					throw new TeslaSchemaException("Invalid map id, expect '>'");

				return t;
			}
			
			private String readContainerTypeId(PeekIterator<String> itr) {
				String token = itr.peek();
				if ("[".equals(token)) {
					StringBuilder sb = new StringBuilder();
					itr.next();
					do {
						token = itr.next();
						if ("]".equals(token)) {
							break;
						}
						sb.append(token);
					} while (true);
					return sb.toString();
				} else {
					return null;
				}
			}
			
			protected abstract Type parseInternal(PeekIterator<String> itr, 
					SchemaBuilder builder, String containerTypeId) throws TeslaSchemaException;
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
			for (UserType type : getUserTypes()) {
				// check if there are undefined user types
				if (!type.isDefined()) {
					throw new TeslaSchemaException(String.format(
							"Undefined user type '%s'", type.getTypeId()));
				}
				
				// Field uniqueness is already ensured by define() method. However, the field uniqueness across 
				// the class hierarchy still needs to be check.
				if (type instanceof Class) {
					String name = UserType.findDuplication(((Class)type).getAllFields());
					if (name != null) {
						throw new TeslaSchemaException(String.format(
								"Field '%s' is redefined in the hierarchy path of class %s.",
								name, type.getName()));
					}
				} 
			}
		}
	}
}
