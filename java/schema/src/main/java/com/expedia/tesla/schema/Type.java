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
 * The base class for all Tesla types.
 * 
 * @see Primitive
 * @see Class
 * @see Enum
 * @see Array
 * @see Nullable
 * @see Reference
 * @see Poly
 * @see Map
 * @see UserType
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 *
 */
public abstract class Type {
	
	/**
	 * Get the Tesla type id. 
	 */
	public abstract String getTypeId();

	/**
	 * Determine if the type is Tesla {@code Class}
	 */
	public boolean isClass() {
		return this instanceof Class;
	}

	/**
	 * Determine if the type is Tesla {@code Enum}
	 */
	public boolean isEnum() {
		return this instanceof Enum;
	}

	/**
	 * Determine if the type is Tesla {@code Array}
	 */
	public boolean isArray() {
		return this instanceof Array;
	}

	/**
	 * Determine if the type is Tesla {@code Nullable}
	 */
	public boolean isNullable() {
		return this instanceof Nullable;
	}

	/**
	 * Determine if the type is Tesla {@code Reference}
	 */
	public boolean isReference() {
		return this instanceof Reference;
	}

	/**
	 * Determine if the type is Tesla {@code Poly}
	 */
	public boolean isPoly() {
		return this instanceof Poly;
	}

	/**
	 * Determine if the type is Tesla {@code Enum}
	 */
	public boolean isPrimitive() {
		return this instanceof Primitive;
	}

	/**
	 * Determine if the type is Tesla {@code Map}
	 */
	public boolean isMap() {
		return this instanceof Map;
	}

	/**
	 * Determine if the type is Tesla {@code UserType}
	 */
	public boolean isUserType() {
		return this instanceof UserType;
	}
}