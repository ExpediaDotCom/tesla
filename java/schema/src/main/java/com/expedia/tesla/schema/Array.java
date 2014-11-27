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

/**
 * Tesla array is a list of values with the same type. 
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 */
public class Array extends Type {
	
	private Type elementType;
	private String extraTypeId;

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
		if (elementType == null) {
			throw new IllegalArgumentException("elementType == null");
		}
		this.elementType = elementType;
		this.extraTypeId = extraTypeId;
	}

	/**
	 * Get the array element type.
	 * @return the elementType
	 */
	public Type getElementType() {
		return elementType;
	}

	/**
	 * @return the extraTypeId
	 */
	public String getExtraTypeId() {
		return extraTypeId;
	}

	/**
	 * {@inheritDoc}
	 */
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