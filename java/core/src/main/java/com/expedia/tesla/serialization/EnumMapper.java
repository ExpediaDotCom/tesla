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
 * @author yzuo
 * 
 */
public class EnumMapper<T extends Enum<T>> {
	public static class Builder<T extends Enum<T>> {
		private final List<T> enumList = new ArrayList<T>();
		private final List<Integer> valueList = new ArrayList<Integer>();
		private final List<String> nameList = new ArrayList<String>();

		public Builder<T> add(T e, int value) {
			return add(e, value, e.name());
		}

		public Builder<T> add(T e, int value, String name) {
			enumList.add(e);
			valueList.add(value);
			nameList.add(name);
			return this;
		}

		public EnumMapper<T> build() {
			return new EnumMapper<T>(enumList, valueList, nameList);
		}
	}

	private final Map<T, Integer> enumValueMap = new HashMap<T, Integer>();
	private final Map<Integer, T> valueEnumMap = new HashMap<Integer, T>();
	private final Map<T, String> enumNameMap = new HashMap<T, String>();
	private final Map<String, T> nameEnumMap = new HashMap<String, T>();

	private EnumMapper(List<T> enumList, List<Integer> valueList,
			List<String> nameList) {
		if (enumList.size() != valueList.size()
				|| enumList.size() != nameList.size()) {
			throw new AssertionError("Invalid enum mapping.");
		}

		for (int i = 0; i < enumList.size(); i++) {
			enumValueMap.put(enumList.get(i), valueList.get(i));
			valueEnumMap.put(valueList.get(i), enumList.get(i));
			enumNameMap.put(enumList.get(i), nameList.get(i));
			nameEnumMap.put(nameList.get(i), enumList.get(i));
		}
	}

	public int toInteger(T e) {
		return enumValueMap.get(e);
	}

	public T fromInteger(int value) {
		return valueEnumMap.get(value);
	}

	public String toName(T e) {
		return enumNameMap.get(e);
	}

	public T fromName(String name) {
		return nameEnumMap.get(name);
	}

	/**
	 * Converts list of enum instances to corresponding enum strings
	 * 
	 * @param listVal
	 * @return
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
	 * Converts list of enum strings to corresponding enum instances
	 * 
	 * @param listVal
	 * @return
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
	 * Converts list of enum instances to corresponding enum integers
	 * 
	 * @param listVal
	 * @return
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
