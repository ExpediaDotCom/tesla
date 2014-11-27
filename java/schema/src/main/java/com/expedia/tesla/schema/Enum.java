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

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * Tesla enum is similar to C enum, which represents enum value with integer internally. Every enum entry must have 
 * a name and an integer value and optionally a description string. 
 *  
 * @author Yunfei Zuo (yzuo@expedia.com)
 *
 */
public class Enum extends UserType {
	// Try to keep the definition order.
	protected LinkedHashMap<String, EnumEntry> entryMap = new LinkedHashMap<String, EnumEntry>();

	/**
	 * Create a new enum type. It needs to be defined by calling {@link define} method.
	 * 
	 * @param name
	 * 		the enum type name
	 */
	public Enum(String name) {
		super(name);
	}

	/**
	 * Create and define a enum type.
	 * 
	 * @param name
	 * 		the enum type name
	 * @param entries
	 * 		the enum entries
	 * @param description
	 * 		the optional description
	 * @throws TeslaSchemaException
	 * 		if there are entries with the same name.
	 */
	public Enum(String name, Collection<EnumEntry> entries, String description) throws TeslaSchemaException {
		super(name);
		define(entries, description);
	}

	/**
	 * Get all enum entries.
	 */
	public Collection<EnumEntry> getEntries() {
		return this.entryMap.values();
	}
	
	private void setEntries(Collection<EnumEntry> v) throws TeslaSchemaException {
		entryMap.clear();
		for (EnumEntry e : safeCollection(v)) {
			if (entryMap.containsKey(e.name)) {
				throw new TeslaSchemaException(String.format("User enum '%s' has duplicated entry '%s'.", 
						this.getName(), e.getName()));
			}
			entryMap.put(e.getName(), e);
		}
	}
	
	/**
	 * Find enum entry by name.
	 * 
	 * @param name
	 * 		enum entry name
	 * 
	 * @return
	 * 		the enum entry with the specified name.
	 */
	public EnumEntry findEntry(String name) {
		return entryMap.get(name);
	}

	/**
	 * Define the current enum type by providing entries and optional description.
	 * 
	 * @param entries
	 * 		the enum entries
	 * @param description
	 * 		the optional description
	 * @throws TeslaSchemaException
	 * 		if there are entries with the same name.
	 */
	public void define(Collection<EnumEntry> entries, String description) throws TeslaSchemaException {
		setEntries(entries);
		define(description);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTypeId() {
		return nameToId(getName());
	}

	/**
	 * Determine if this enum type has an entry with specified name.
	 */
	public boolean hasEntry(String name) {
		for (EnumEntry e : getEntries()) {
			if (e.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Convert enum full name to Tesla type id.
	 */
	public static String nameToId(String name) {
		return String.format("enum<%s>", name);
	}

	/**
	 * Extract the enum full name from Tesla type id.
	 *  
	 * @param id
	 * 		Tesla type id
	 * 
	 * @return
	 * 		the full name of enum type it represents.
	 * 
	 * @throws TeslaSchemaException
	 * 		if the input is not a legal enum type id (with format of {@code enum<foo.bar>}.
	 */
	public static String idToName(String id) throws TeslaSchemaException {
		if (id.matches("^enum<.+>$")) {
			return id.substring("enum<".length(), id.length() - 1);
		} else {
			throw new TeslaSchemaException(String.format(
					"Invalid enum id '%s'", id));
		}
	}

}