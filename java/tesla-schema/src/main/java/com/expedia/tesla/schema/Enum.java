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
	protected List<EnumEntry> entries = new ArrayList<EnumEntry>();

	public Enum() {
	}

	public Enum(String name, List<EnumEntry> entries, String description) {
		super(name, null);
		define(entries, description);
	}

	public java.util.List<com.expedia.tesla.schema.EnumEntry> getEntries() {
		return this.entries;
	}

	protected void setEntries(java.util.List<com.expedia.tesla.schema.EnumEntry> value) {
		this.entries = value;
	}
	
	public void define(List<EnumEntry> entries, String description) {
		setDescription(description);
		setEntries(entries);
		define();
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
}