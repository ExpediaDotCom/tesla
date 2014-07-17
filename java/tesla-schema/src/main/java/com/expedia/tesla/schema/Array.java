/**
 * Array.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

package com.expedia.tesla.schema;

public class Array extends Type {
	private Type elementType;
	private String extraTypeId;

	Array() {
	}

	Array(Type elementType, String extraTypeId) {
		this.elementType = elementType;
		this.extraTypeId = extraTypeId;
		if (elementType == null) {
			throw new AssertionError("elementType == null");
		}
		if (elementType.getTypeId() == null) {
			throw new AssertionError("elementType.getTypeId() == null");
		}
	}

	/**
	 * @return the elementType
	 */
	public Type getElementType() {
		return elementType;
	}

	/**
	 * @param elementType
	 *            the elementType to set
	 */
	public void setElementType(Type elementType) {
		this.elementType = elementType;
	}

	/**
	 * @return the extraTypeId
	 */
	public String getExtraTypeId() {
		return extraTypeId;
	}

	/**
	 * @param extraTypeId
	 *            the extraTypeId to set
	 */
	public void setExtraTypeId(String extraTypeId) {
		this.extraTypeId = extraTypeId;
	}

	@Override
	public String getTypeId() {
		String s = getExtraTypeId();
		if (s != null) {
			s = "[" + s + "]";
		} else {
			s = "";
		}
		return "array" + s + "<" + getElementType().getTypeId() + ">";
	}
}