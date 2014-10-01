/**
 * Type.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

package com.expedia.tesla.schema;

public abstract class Type {
	public Type() {
	}

	public abstract String getTypeId();

	public boolean isClass() {
		return this instanceof Class;
	}

	public boolean isEnum() {
		return this instanceof Enum;
	}

	public boolean isArray() {
		return this instanceof Array;
	}

	public boolean isNullable() {
		return this instanceof Nullable;
	}

	public boolean isReference() {
		return this instanceof Reference;
	}

	public boolean isPoly() {
		return this instanceof Poly;
	}

	public boolean isPrimitive() {
		return this instanceof Primitive;
	}

	public boolean isMap() {
		return this instanceof Map;
	}

	public boolean isUserType() {
		return this instanceof UserType;
	}
}