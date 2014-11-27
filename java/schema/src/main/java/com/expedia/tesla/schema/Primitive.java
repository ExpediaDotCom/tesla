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
 * Primitive.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

package com.expedia.tesla.schema;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a predefined basic Tesla type.
 * <p>
 * Unlike any other types, Tesla {@code Primitive}s are singleton.
 *  
 * @author Yunfei Zuo (yzuo@expedia.com)
 *
 */
public class Primitive extends Type implements Named {
	public static final Primitive BYTE = new Primitive("byte");
	public static final Primitive INT16 = new Primitive("int16");
	public static final Primitive INT32 = new Primitive("int32");
	public static final Primitive INT64 = new Primitive("int64");
	public static final Primitive UINT16 = new Primitive("uint16");
	public static final Primitive UINT32 = new Primitive("uint32");
	public static final Primitive UINT64 = new Primitive("uint64");
	public static final Primitive BOOLEAN = new Primitive("boolean");
	public static final Primitive FLOAT = new Primitive("float");
	public static final Primitive DOUBLE = new Primitive("double");
	public static final Primitive STRING = new Primitive("string");
	public static final Primitive BINARY = new Primitive("binary");
	public static final Set<Primitive> ALL_PRIMITIVES = new HashSet<Primitive>();

	protected String name;

	static {
		ALL_PRIMITIVES.add(BYTE);
		ALL_PRIMITIVES.add(INT16);
		ALL_PRIMITIVES.add(INT32);
		ALL_PRIMITIVES.add(INT64);
		ALL_PRIMITIVES.add(UINT16);
		ALL_PRIMITIVES.add(UINT32);
		ALL_PRIMITIVES.add(UINT64);
		ALL_PRIMITIVES.add(BOOLEAN);
		ALL_PRIMITIVES.add(FLOAT);
		ALL_PRIMITIVES.add(DOUBLE);
		ALL_PRIMITIVES.add(STRING);
		ALL_PRIMITIVES.add(BINARY);
	}

	private Primitive(String name) {
		this.name = name;
	}

	/**
	 * Get the type name.
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTypeId() {
		return getName();
	}
}