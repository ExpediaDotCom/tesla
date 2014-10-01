/**
 * Nullable.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

package com.expedia.tesla.schema;

public class Nullable extends Type {
	private Type elementType;

	public Nullable() {
	}

	public Nullable(Type elementType) {
		setElementType(elementType);
	}

	public Type getElementType() {
		return this.elementType;
	}

	public void setElementType(Type value) {
		this.elementType = value;
	}

	@Override
	public String getTypeId() {
		return "nullable<" + getElementType().getTypeId() + ">";
	}

}