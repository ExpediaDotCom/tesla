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
/**
 * Reference.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

package com.expedia.tesla.schema;

/**
 * Represent a Tesla reference type.
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 *
 */
public class Reference extends Type {
	private Type elementType;

	/**
	 * Wrap a Tesla type as Tesla reference type.
	 * 
	 * @param elementType
	 * 		the type to be wrapped as Tesla reference. 
	 */
	public Reference(Type elementType) {
		this.elementType = elementType;
	}

	/**
	 * Get the actual type refers to.
	 */
	public Type getElementType() {
		return this.elementType;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTypeId() {
		return "reference<" + getElementType().getTypeId() + ">";
	}
}