/**
 *
 * Enum.java
 *
 * Copyright 2013 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.tesla.schema;

import java.util.ArrayList;
import java.util.List;

public class Enum extends UserType {
	private List<EnumEntry> entries = new ArrayList<EnumEntry>();

	public Enum() {
	}

	public Enum(String name, String description, List<EnumEntry> entries) {
		setName(name);
		setDescription(description);
		setEntries(entries);
	}

	public java.util.List<com.expedia.tesla.schema.EnumEntry> getEntries() {
		return this.entries;
	}

	public void setEntries(
			java.util.List<com.expedia.tesla.schema.EnumEntry> value) {
		this.entries = value;
	}

	@Override
	public String getTypeId() {
		return nameToId(getName());
	}

	public boolean hasValue(String name) {
		for (EnumEntry e : getEntries()) {
			if (e.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public static String nameToId(String name) {
		return String.format("enum<%s>", name);
	}

	public static String idToName(String id) throws TeslaSchemaException {
		if (id.matches("^enum<.+>$")) {
			return id.substring("enum<".length(), id.length() - 1);
		} else {
			throw new TeslaSchemaException(String.format(
					"Invalid enum id '%s'", id));
		}
	}

	public void addValue(String name, int value, String description)
			throws TeslaSchemaException {
		if (hasValue(name)) {
			throw new TeslaSchemaException(String.format(
					"Enum value'%s' already exists in '%s'", name, getName()));
		}
		getEntries().add(new EnumEntry(name, value, description));
	}
}