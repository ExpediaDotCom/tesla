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
 * 
 */
package com.expedia.tesla.serialization;

/**
 * Implements the Tesla binary reference definition:
 * <p>
 * For any new reference object, write a negative reference id followed by
 * actual serialized object data. For reference object that has been serialized
 * previously, only write a positive reference id value.
 * <p>
 * Tesla standard only requires that reference ids can identify the referred
 * objects. We will generate sequential integers for each class type
 * independently.
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 */
public class ReferencePolicy {
	private java.util.Map<java.lang.Class<?>, java.util.Map<?, Integer>> refWriteTable = new java.util.HashMap<Class<?>, java.util.Map<?, Integer>>();
	private java.util.Map<java.lang.Class<?>, java.util.Map<Integer, ?>> refReadTable = new java.util.HashMap<java.lang.Class<?>, java.util.Map<Integer, ?>>();

	/**
	 * Check if an object with the same value has already been written. It will
	 * generate a new reference id (n) and put it into a reference table, then
	 * return the corresponding negative value (-n). The caller of this method
	 * should always check the sign of the return value.
	 * 
	 * @param value
	 *            The object which is written as Tesla reference.
	 * @param clzz
	 *            The java.lang.Class<?> object that represents the type of the
	 *            {@code value}.
	 * @return Return a negative integer id if no object with the same value has
	 *         been serialized so far. Otherwise, return the positive reference
	 *         id that represents the value has already been serailzied.
	 * 
	 * @throws TeslaSerializationException
	 */
	public <T> int getOutputReferenceId(T value, Class<?> clzz) {
		@SuppressWarnings("unchecked")
		java.util.Map<T, Integer> e = (java.util.Map<T, Integer>) refWriteTable
				.get(clzz);
		if (e == null) {
			e = new java.util.HashMap<T, Integer>();
			refWriteTable.put(clzz, e);
		}
		Integer id = e.get(value);
		if (id != null) {
			return id;
		} else {
			int newId = e.size() + 1;
			e.put(value, newId);
			return -newId;
		}
	}

	/**
	 * Find the referred object that was deserialized previously.
	 * 
	 * @param id
	 *            Object reference id.
	 * @param clzz
	 *            The java.lang.Class<?> object that represents the type of the
	 *            reference object type.
	 * @return The reference object that was deserialized previously.
	 * @throws TeslaDeserializationException
	 *             If no such previously deserialized object.
	 */
	@SuppressWarnings("unchecked")
	public <T> T getInputReference(int id, java.lang.Class<?> clzz)
			throws TeslaDeserializationException {
		java.util.Map<Integer, ?> ids = refReadTable.get(clzz);
		T value = null;
		if (ids != null && (value = (T) ids.get(id)) != null) {
			return value;
		} else {
			throw new TeslaDeserializationException(String.format(
					"Bad data. Invalid reference id %d.", id));
		}
	}

	/**
	 * Put the reference id of the object that was deserialized so that all
	 * following reference can find this object by its reference id.
	 * 
	 * @param id
	 *            Object reference id (positive value).
	 * @param value
	 *            The referred objects
	 * @param classType
	 */
	public <T> void putInputReference(int id, T value,
			java.lang.Class<?> classType) {
		@SuppressWarnings("unchecked")
		java.util.Map<Integer, T> ids = (java.util.Map<Integer, T>) refReadTable
				.get(classType);
		if (ids == null) {
			ids = new java.util.HashMap<Integer, T>();
			refReadTable.put(classType, ids);
		}
		if (id < 0) {
			id = -id;
		}
		ids.put(id, value);
	}
}
