/**
 * UserType.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

package com.expedia.tesla.schema;

public abstract class UserType extends Type {
	protected String name;
	protected String description;

	public UserType() {
	}

	public UserType(String name, String description) {
		setName(name);
		setDescription(description);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public String getShortName() {
		return toShortName(name);
	}

	public String getNameSpace() {
		return toNameSpace(name);
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

	public static String toShortName(String fullName) {
		return splitFullName(fullName)[1];
	}

	public static String toNameSpace(String fullName) {
		return splitFullName(fullName)[0];
	}
}