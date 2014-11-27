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

package com.expedia.tesla.serialization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Map enums to/from integer values or string names.
 * 
 * @author Yunfei Zuo(yzuo@expedia.com)
 * 
 */
public class EnumMapper<T extends Enum<T>> {
	
	/**
	 * Build an enum mapper by adding enums one by one.
	 */
	public static class Builder<T extends Enum<T>> {
		private final Map<T, Integer> enumValueMap = new HashMap<T, Integer>();
		private final Map<Integer, T> valueEnumMap = new HashMap<Integer, T>();
		private final Map<T, String> enumNameMap = new HashMap<T, String>();
		private final Map<String, T> nameEnumMap = new HashMap<String, T>();

		/**
		 * Add an enum value. The enum value will have the same name as its Java source code. 
		 * 
		 * @param e
		 * 		enum value
		 * @param value
		 * 		the mapped integer value
		 * @return
		 * 		the builder itself, which can be used to chain the operations.
		 */
		public Builder<T> add(T e, int value) {
			return add(e, value, e.name());
		}

		/**
		 * Add an enum value. 
		 * 
		 * @param e
		 * 		enum value
		 * @param value
		 * 		the mapped integer value
		 * @param name
		 * 		the enum value name  
		 * @return
		 * 		the builder itself, which can be used to chain the operations.
		 */
		public Builder<T> add(T e, int value, String name) {
			enumValueMap.put(e, value);
			valueEnumMap.put(value, e);
			enumNameMap.put(e, name);
			nameEnumMap.put(name, e);
			return this;
		}

		/**
		 * Create an {@code EnumMapper} with the current enum values.
		 *   
		 * @return 
		 * 		an {@code EnumMapper} object.
		 */
		public EnumMapper<T> build() {
			return new EnumMapper<T>(enumValueMap, valueEnumMap, enumNameMap, nameEnumMap);
		}
	}

	private final Map<T, Integer> enumValueMap = new HashMap<T, Integer>();
	private final Map<Integer, T> valueEnumMap = new HashMap<Integer, T>();
	private final Map<T, String> enumNameMap = new HashMap<T, String>();
	private final Map<String, T> nameEnumMap = new HashMap<String, T>();

	private EnumMapper(Map<T, Integer> enumValueMap,
			Map<Integer, T> valueEnumMap, Map<T, String> enumNameMap,
			Map<String, T> nameEnumMap) {
		// copy mapping tables.
		this.enumValueMap.putAll(enumValueMap);
		this.valueEnumMap.putAll(valueEnumMap);
		this.enumNameMap.putAll(enumNameMap);
		this.nameEnumMap.putAll(nameEnumMap);
	}

	/**
	 * Map an enum value to an integer value.
	 * 
	 * @param e
	 * 		the enum value
	 * @return
	 * 		the corresponding integer value
	 */
	public int toInteger(T e) {
		return enumValueMap.get(e);
	}

	/**
	 * Map an integer value to its corresponding enum value.
	 * 
	 * @param value
	 * 		the integer value represents the enum
	 * @return
	 * 		the corresponding enum value
	 */
	public T fromInteger(int value) {
		return valueEnumMap.get(value);
	}

	/**
	 * Map an enum to a string.
	 * 
	 * @param e
	 * 		the enum value
	 * @return
	 * 		the corresponding string value
	 */
	public String toName(T e) {
		return enumNameMap.get(e);
	}

	/**
	 * Map a string value to its corresponding enum value.
	 * 
	 * @param value
	 * 		the string represents the name of the enum
	 * @return
	 * 		the corresponding enum value
	 */
	public T fromName(String name) {
		return nameEnumMap.get(name);
	}

	/**
	 * Converts a list of enum instances to their corresponding enum strings
	 * 
	 * @param listVal
	 * 		a list of enum values
	 * @return
	 * 		a list of the corresponding name strings with the same order of the input.
	 */
	public List<String> toNameList(List<T> listVal) {
		if (listVal == null) {
			return null;
		}

		List<String> result = new ArrayList<String>(listVal.size());
		for (T val : listVal) {
			result.add(enumNameMap.get(val));
		}
		return result;
	}

	/**
	 * Converts a list of enum strings to their corresponding enum instances
	 * 
	 * @param listVal
	 * 		the list of enum name strings
	 * @return
	 * 		a list of the corresponding enum objects with the same order of the input.
	 */
	public List<T> fromNameList(List<String> listVal) {
		if (listVal == null) {
			return null;
		}

		List<T> result = new ArrayList<T>(listVal.size());
		for (String val : listVal) {
			result.add(nameEnumMap.get(val));
		}
		return result;
	}

	/**
	 * Converts a list of enum instances to their corresponding enum integers
	 * 
	 * @param listVal
	 * 		a list of enum values
	 * @return
	 * 		a list of the corresponding integer values with the same order of the input.
	 */
	public List<Integer> toIntegerList(List<T> listVal) {
		if (listVal == null) {
			return null;
		}

		List<Integer> result = new ArrayList<Integer>(listVal.size());
		for (T val : listVal) {
			result.add(enumValueMap.get(val));
		}
		return result;
	}
}
