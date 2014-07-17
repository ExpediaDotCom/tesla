/**
 *
 * Schema.java
 *
 * Copyright 2013 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.tesla.schema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.expedia.tesla.SchemaVersion;

public class Schema {

	public static final String TYPE_ID_PATTERN = "((?<=<)|(?=<))|((?<=>)|(?=>))|((?<=\\[)|(?=\\[))|((?<=\\])|(?=\\]))|((?<=,)|(?=,))";
	public static final java.util.Map<String, Type> PRIMITIVES = new java.util.HashMap<String, Type>();
	private SchemaVersion version;

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

	private final java.util.Map<String, Type> typeMap = new java.util.HashMap<String, Type>();

	public Collection<Type> getTypes() {
		return typeMap.values();
	}

	public Collection<UserType> getUserTypes() {
		Collection<UserType> uts = new ArrayList<UserType>();
		for (Type t : typeMap.values()) {
			if (t.isUserType()) {
				uts.add((UserType) t);
			}
		}
		return uts;
	}

	public Type findType(String id) {
		return typeMap.get(id);
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

	private Type addType(PeekIterator<String> itr) throws TeslaSchemaException {
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

	private Type addClass(PeekIterator<String> itr) throws TeslaSchemaException {
		if (!itr.next().equals("<"))
			throw new TeslaSchemaException("");
		String name = itr.next();
		if (!itr.next().equals(">"))
			throw new TeslaSchemaException("");
		Class c = new Class();
		c.setName(name);
		return cacheType(c);
	}

	private Type addEnum(PeekIterator<String> itr) throws TeslaSchemaException {
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

	private Type addArray(PeekIterator<String> itr) throws TeslaSchemaException {
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

	private Type addMap(PeekIterator<String> itr) throws TeslaSchemaException {
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

	private Type addPoly(PeekIterator<String> itr) throws TeslaSchemaException {
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

	public SchemaVersion getVersion() {
		return version;
	}

	public void setVersion(SchemaVersion schemaVersion) {
		this.version = schemaVersion;
	}

	public Collection<Type> getDerivedTypes(String typeId, boolean directOnly) {
		return getDerivedTypes(typeMap.get(typeId), directOnly);
	}

	public Collection<Type> getDerivedTypes(Type type, boolean directOnly) {
		if (!type.isClass()) {
			return null;
		}
		java.util.Map<Type, Set<Type>> derivedTypeMap = createDerivedMap();
		return getDerivedTypes(type, directOnly, derivedTypeMap);
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
}
