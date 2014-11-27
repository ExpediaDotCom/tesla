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
 * Nullable.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

package com.expedia.tesla.schema;

/**
 * A type that can be null.
 * <p>
 * All Tesla types are not allowed to be null unless it wrapped in a {@code Nullable}. The generated code from the 
 * builtin source code templates will check for {@code null} only for {@code Nullable} types. 
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 *
 */
public class Nullable extends Type {
	private Type elementType;

	/**
	 * Wrap a Tesla type into a nullable type, which accepts {@code null}. 
	 * 
	 * @param elementType
	 * 		the Tesla type that could be {@code null}.
	 */
	public Nullable(Type elementType) {
		this.elementType = elementType;
	}

	/**
	 * Get wrapped Tesla type.
	 */
	public Type getElementType() {
		return this.elementType;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTypeId() {
		return "nullable<" + getElementType().getTypeId() + ">";
	}

}