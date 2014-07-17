/**
 * 
 */

package com.expedia.tesla.compiler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.expedia.tesla.schema.Enum;
import com.expedia.tesla.schema.EnumEntry;
import com.expedia.tesla.schema.Schema;
import com.expedia.tesla.SchemaVersion;
import com.expedia.tesla.schema.TeslaSchemaException;
import com.expedia.tesla.schema.Type;

/**
 * @author yzuo
 * 
 */
public class MergedEnum extends Enum {
	private Map<SchemaVersion, Schema> schemas = new TreeMap<SchemaVersion, Schema>();
	private Map<SchemaVersion, Enum> enumDefinitions = new TreeMap<SchemaVersion, Enum>();

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

		List<MergedEnum> mcs = new ArrayList<MergedEnum>();
		for (String name : enums) {
			mcs.add(new MergedEnum(name, schemas));
		}
		return mcs;
	}

	public MergedEnum(String name, List<Schema> schemas)
			throws TeslaSchemaException {
		super(name, null, null);
		List<List<EnumEntry>> versions = new ArrayList<List<EnumEntry>>();
		for (Schema schema : schemas) {
			Type type = schema.findType(Enum.nameToId(name));
			if (type != null && type instanceof Enum) {
				Enum enumDef = (Enum) type;
				versions.add(enumDef.getEntries());
				this.description = enumDef.getDescription();

				this.schemas.put(schema.getVersion(), schema);
				enumDefinitions.put(schema.getVersion(), enumDef);
			}
		}
		this.setEntries(mergeEntries(versions));
	}

	public Collection<Schema> getVersions() {
		return this.schemas.values();
	}

	public Map<SchemaVersion, Enum> getEnumVersions() {
		return this.enumDefinitions;
	}

	private List<EnumEntry> mergeEntries(List<List<EnumEntry>> versions)
			throws TeslaSchemaException {
		List<EnumEntry> allEntries = new ArrayList<EnumEntry>();

		for (List<EnumEntry> schemaVersion : versions) {
			for (EnumEntry entry : schemaVersion) {
				boolean exist = false;
				for (EnumEntry e : allEntries) {
					if (e.getName().compareTo(entry.getName()) == 0) {
						exist = true;
						if (e.getValue() != entry.getValue()) {
							throw new TeslaSchemaException(
									String.format(
											"Conflict enum values for '%s.%s' ( %d vs %d).",
											this.name, e.getName(),
											e.getValue(), entry.getValue()));
						}
					}
				}
				if (!exist) {
					allEntries.add(entry);
				}
			}
		}

		return allEntries;
	}
}
