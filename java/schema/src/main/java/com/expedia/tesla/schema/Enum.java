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