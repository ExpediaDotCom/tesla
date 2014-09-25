/**
 * Array.java
 * 
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.tesla.schema;

/**
 * Tesla array is a list of values with the same type. 
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 */
public class Array extends Type {
	
	private Type elementType;
	private String extraTypeId;

	Array() {
	}

	/**
	 * Construct a Tesla Array type with element type and extra type information.
	 * 
	 * @param elementType
	 * 		the {@link Type} object represents the element type.
	 * 
	 * @param extraTypeId
	 * 		the extra type id that specifies concrete type information for specific language.
	 */
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
	 * Get the array element type.
	 * @return the elementType
	 */
	public Type getElementType() {
		return elementType;
	}

	/**
	 * Set the array element type.
	 * 
	 * @param elementType
	 *        the elementType to set
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
	 *         the extraTypeId to set
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