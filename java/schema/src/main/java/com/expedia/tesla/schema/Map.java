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
 * Tesla map is a list of typed key value pairs. 
 *  
 * @author Yunfei Zuo (yzuo@expedia.com)
 *
 */
public class Map extends Type {
	private Type keyType;
	private Type valueType;
	private String extraTypeId;

	/**
	 * Create a Tesla map type. 
	 * 
	 * @param keyType
	 * 		the key type
	 * @param valueType
	 * 		the value type
	 * @param extraTypeId
	 * 		the optional programming language specific type extension. An sample of this for Java is 
	 * 		{@code java.util.Map,java.util.TreeMap}. This tells Tesla compiler to use interface type java.util.Map when 
	 * 		it declares a variable in the generated source, and use java.util.TreeMap when it {@code new} an instance
	 * 		of this type. Tesla use {@code java.util.Map,java.util.TreeMap} by default.
	 */
	public Map(Type keyType, Type valueType, String extraTypeId) {
		if (keyType == null) {
			throw new IllegalArgumentException("key type is required");
		}
		if (valueType == null) {
			throw new IllegalArgumentException("value type is required");
		}
		this.keyType = keyType;
		this.valueType = valueType;
		this.extraTypeId = extraTypeId;
	}

	/**
	 * Get the key type.
	 */
	public Type getKeyType() {
		return this.keyType;
	}

	/**
	 * Get the value type.
	 */
	public Type getValueType() {
		return this.valueType;
	}

	/**
	 * Get the programming language specific type extension 
	 */
	public String getExtraTypeId() {
		return this.extraTypeId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTypeId() {
		String ex = this.getExtraTypeId();
		if (ex != null && !ex.isEmpty()) {
			ex = "[" + ex + "]";
		} else {
			ex = "";
		}
		return String.format("map%s<%s,%s>", ex, this.getKeyType().getTypeId(),
				this.getValueType().getTypeId());
	}

}
