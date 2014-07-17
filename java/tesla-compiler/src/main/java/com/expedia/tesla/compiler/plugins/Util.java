/**
 *
 * Util.java
 *
 * Copyright 2013 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.tesla.compiler.plugins;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import com.expedia.tesla.schema.Schema;
import com.expedia.tesla.schema.UserType;

/**
 * Tesla compiler utility methods.
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 */
public class Util {
	public <T> String commaSeparate(Collection<T> list) {
		return delimiterSeparate(list, ", ");
	}

	public <T> String delimiterSeparate(Collection<T> list, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (T e : list) {
			if (sb.length() > 0) {
				sb.append(delimiter);
			}
			sb.append(e.toString());
		}
		return sb.toString();
	}

	public String firstCharLowerCase(String s) {
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}

	public String firstCharUpperCase(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	public String toShortName(String fullName) {
		return UserType.toShortName(fullName);
	}

	public String toNameSpace(String fullName) {
		return UserType.toNameSpace(fullName);
	}

	public String getNewLine() {
		return "\n";
	}

	/**
	 * Get a set of all user types defined in all schemas. It's the union of all
	 * user type definitions.
	 * 
	 * @param schemas
	 *            A collection of Tesla schema objects.
	 * @return A set of all user types defined in all schemas
	 */
	public Collection<UserType> getAllUserTypes(Collection<Schema> schemas) {
		Map<String, UserType> all = new TreeMap<String, UserType>();
		for (Schema schema : schemas) {
			for (UserType t : schema.getUserTypes()) {
				all.put(t.getName(), t);
			}
		}
		return all.values();
	}
}
