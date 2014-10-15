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