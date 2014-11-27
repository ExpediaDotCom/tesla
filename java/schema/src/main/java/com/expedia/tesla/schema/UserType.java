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
 * UserType.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

package com.expedia.tesla.schema;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A Telsa user type is a type defined by user in a schema. 
 * 
 * @see Class
 * @see Enum
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 *
 */
public abstract class UserType extends Type implements Named {
	private String name;
	private String description;
	private boolean isDefined = false;

	/**
	 * Create a new user type. The type must be defined by calling {@code define} method on the concrete type. 
	 * 
	 * @param name
	 */
	public UserType(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Invalid user type name");
		}
		this.name = name;
	}

	/**
	 * Get user type full name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Get description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Get user type short name.
	 */
	public String getShortName() {
		return toShortName(name);
	}

	/**
	 * Get user type name space
	 */
	public String getNameSpace() {
		return toNameSpace(name);
	}
	
	protected void define(String description) {
		this.description = description;
		isDefined = true;
	}
	
	/**
	 * Is the current user type defined. 
	 */
	boolean isDefined() {
		return isDefined;
	}

	private static String[] splitFullName(String fullName) {
		String[] result = new String[2];

		if (fullName.matches(".+\\..+")) {
			int pos = fullName.lastIndexOf('.');
			result[0] = fullName.substring(0, pos);
			result[1] = fullName.substring(pos + 1);
		} else {
			result[1] = fullName;
		}
		return result;
	}

	/**
	 * Extract short name from a full type name.
	 *  
	 * @param fullName
	 * 		full type name
	 * 
	 * @return
	 * 		short name
	 */
	public static String toShortName(String fullName) {
		return splitFullName(fullName)[1];
	}

	/**
	 * Extract name space from a full type name.
	 *  
	 * @param fullName
	 * 		full type name
	 * 
	 * @return
	 * 		name space.
	 */
	public static String toNameSpace(String fullName) {
		return splitFullName(fullName)[0];
	}
	
	/**
	 * Replace {@code null} with read only an empty list.
	 *  
	 * @param list
	 * 		the list that might be {@code null}
	 * 
	 * @return
	 * 		an read only empty list if the input is {@code null}, otherwise, return the original list.
	 */
	public static <T> List<T> safeList(List<T> list) {
		return list == null ? Collections.<T>emptyList() : list;
	}
	
	/**
	 * Replace {@code null} with read only an empty list.
	 *  
	 * @param list
	 * 		the list that might be {@code null}
	 * 
	 * @return
	 * 		an read only empty list if the input is {@code null}, otherwise, return the original list.
	 */
	public static <T> Collection<T> safeCollection(Collection<T> collection) {
		return safeList((List<T>)collection);
	}
	
	/**
	 * Check if there are items with the same name.
	 * 
	 * @param items
	 * 		named items
	 * 
	 * @return
	 * 		if there are more than one items have the same name, return the item name, otherwise, return null. 
	 */
	public static <T extends Named> String findDuplication(Collection<T> items) {
		if (items == null) {
			return null;
		}
		
		Set<String> set = new HashSet<>();
		for (T v : items) {
			if (set.contains(v.getName())) {
				return v.getName();
			}
			set.add(v.getName());
		}
		return null;
	}
}