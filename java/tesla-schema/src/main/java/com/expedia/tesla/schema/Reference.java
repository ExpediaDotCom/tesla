/**
 * Reference.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

package com.expedia.tesla.schema;

public class Reference extends Type {
	private Type elementType;

	public Reference() {
	}

	public Reference(Type elementType) {
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
		return "reference<" + getElementType().getTypeId() + ">";
	}
}