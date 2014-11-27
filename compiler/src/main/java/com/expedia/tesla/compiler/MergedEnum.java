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

package com.expedia.tesla.compiler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.expedia.tesla.SchemaVersion;
import com.expedia.tesla.schema.Enum;
import com.expedia.tesla.schema.EnumEntry;
import com.expedia.tesla.schema.Schema;
import com.expedia.tesla.schema.TeslaSchemaException;
import com.expedia.tesla.schema.Type;

/**
 * Tesla enum may has multiple definitions from different versions. Tesla compiler merges all definitions into 
 * a single enum definition, which contains the union of enum entries from all versions. 
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 */
public class MergedEnum extends Enum {
	private Map<SchemaVersion, Schema> schemas = new TreeMap<SchemaVersion, Schema>();
	private Map<SchemaVersion, Enum> enumDefinitions = new TreeMap<SchemaVersion, Enum>();

	/**
	 * Merge all enums versions. The enums with the same name in different schemas will be merged. 
	 *  
	 * @param schemas
	 * 		schema versions
	 * 
	 * @return
	 * 		all merged enums
	 * 
	 * @throws TeslaSchemaException
	 * 		if there are enum value conflict between versions.
	 */
	public static List<MergedEnum> merge(List<Schema> schemas)
			throws TeslaSchemaException {
		Set<String> enums = new TreeSet<String>();
		for (Schema schema : schemas) {
			for (Type type : schema.getTypes()) {
				if (type instanceof Enum) {
					enums.add(((Enum) type).getName());
				}
			}
		}

		List<MergedEnum> mcs = new ArrayList<>();
		for (String name : enums) {
			mcs.add(new MergedEnum(name, schemas));
		}
		return mcs;
	}

	private MergedEnum(String name, List<Schema> schemas)
			throws TeslaSchemaException {
		super(name, null, null);
		Collection<Collection<EnumEntry>> versions = new ArrayList<>();
		String description = null;
		for (Schema schema : schemas) {
			Type type = schema.findType(Enum.nameToId(name));
			if (type instanceof Enum) {
				Enum enumDef = (Enum) type;
				versions.add(enumDef.getEntries());
				description = enumDef.getDescription();

				this.schemas.put(schema.getVersion(), schema);
				enumDefinitions.put(schema.getVersion(), enumDef);
			}
		}
		define(mergeEntries(versions), description);
	}

	/**
	 * Get all schema versions that defines this enum.
	 */
	public Collection<Schema> getVersions() {
		return this.schemas.values();
	}

	/**
	 * Get all enum definitions. Each entry in the result represents a version.
	 */
	public Map<SchemaVersion, Enum> getEnumVersions() {
		return this.enumDefinitions;
	}

	private Collection<EnumEntry> mergeEntries(Collection<Collection<EnumEntry>> versions)
			throws TeslaSchemaException {
		LinkedHashMap<String, EnumEntry> allEntries = new LinkedHashMap<>();

		for (Collection<EnumEntry> schemaVersion : versions) {
			for (EnumEntry entry : schemaVersion) {
				EnumEntry e = allEntries.get(entry.getName());
				if (e != null) {
					if (e.getValue() != entry.getValue()) {
						throw new TeslaSchemaException(String.format("Conflict enum values for '%s.%s' ( %d vs %d).",
							this.getName(), e.getName(), e.getValue(), entry.getValue()));
					}
				} else {
					allEntries.put(entry.getName(), entry);
				}
			}
		}

		return new ArrayList<EnumEntry>(allEntries.values());
	}
}
