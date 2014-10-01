/**
 * EnumEntry.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

package com.expedia.tesla.schema;

public class EnumEntry {
	protected java.lang.String name;
	protected int value;
	protected java.lang.String description;

	public EnumEntry() {
	}

	public EnumEntry(String name, int value, String description) {
		setName(name);
		setValue(value);
		setDescription(description);
	}

	public java.lang.String getName() {
		return this.name;
	}

	public void setName(java.lang.String value) {
		this.name = value;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public java.lang.String getDescription() {
		return this.description;
	}

	public void setDescription(java.lang.String value) {
		this.description = value;
	}
}