/**
 * Primitive.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

package com.expedia.tesla.schema;

import java.util.HashSet;
import java.util.Set;

public class Primitive extends Type {
	public static final Primitive BYTE = new Primitive("byte");
	public static final Primitive INT16 = new Primitive("int16");
	public static final Primitive INT32 = new Primitive("int32");
	public static final Primitive INT64 = new Primitive("int64");
	public static final Primitive UINT16 = new Primitive("uint16");
	public static final Primitive UINT32 = new Primitive("uint32");
	public static final Primitive UINT64 = new Primitive("uint64");
	public static final Primitive BOOLEAN = new Primitive("boolean");
	public static final Primitive FLOAT = new Primitive("float");
	public static final Primitive DOUBLE = new Primitive("double");
	public static final Primitive STRING = new Primitive("string");
	public static final Primitive BINARY = new Primitive("binary");
	public static final Set<Primitive> ALL_PRIMITIVES = new HashSet<Primitive>();

	protected String name;

	static {
		ALL_PRIMITIVES.add(BYTE);
		ALL_PRIMITIVES.add(INT16);
		ALL_PRIMITIVES.add(INT32);
		ALL_PRIMITIVES.add(INT64);
		ALL_PRIMITIVES.add(UINT16);
		ALL_PRIMITIVES.add(UINT32);
		ALL_PRIMITIVES.add(UINT64);
		ALL_PRIMITIVES.add(BOOLEAN);
		ALL_PRIMITIVES.add(FLOAT);
		ALL_PRIMITIVES.add(DOUBLE);
		ALL_PRIMITIVES.add(STRING);
		ALL_PRIMITIVES.add(BINARY);
	}

	private Primitive(String name) {
		setName(name);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String value) {
		this.name = value;
	}

	@Override
	public String getTypeId() {
		return getName();
	}
}