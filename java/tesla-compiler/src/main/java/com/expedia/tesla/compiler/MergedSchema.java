/**
 *
 * MergedSchema.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.tesla.compiler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.expedia.tesla.schema.Schema;
import com.expedia.tesla.schema.TeslaSchemaException;

/**
 * Merge a set of Tesla schemas.
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 */
public class MergedSchema {
	private List<Schema> schemas = new ArrayList<>();
	private List<MergedClass> classes;
	private List<MergedEnum> enums;
	
	/**
	 * Constructor. Merge all user types defined in all schemas.
	 * 
	 * @param schemas
	 * 		Tesla schemas.
	 * 
	 * @throws TeslaSchemaException
	 * 		If Tesla can't merge the schemas.
	 */
	public MergedSchema(Collection<Schema> schemas) throws TeslaSchemaException {
		checkVersions(schemas);
		this.schemas.addAll(schemas);
		merge();
	}
	
	private void merge() throws TeslaSchemaException {
		this.classes = MergedClass.merge(schemas);
		this.enums = MergedEnum.merge(schemas);
	}

	private void checkVersions(Collection<Schema> schemas) throws TeslaSchemaException {
		Set<String> versionNames = new TreeSet<String>();
		for (Schema schema : schemas) {
			String name = schema.getVersion().getName().toUpperCase();
			if (versionNames.contains(name)) {
				throw new TeslaSchemaException(String.format(
						"Duplicated schema name \"%s\". Schema name is case insensitive.", name));
			}
			versionNames.add(name);
		}
	}
	
	/**
	 * Get all managed schemas.
	 * 
	 * @return
	 * 		All managed schemas.
	 */
	public Collection<Schema> getSchemas() {
		return this.schemas;
	}

	/**
	 * Get all merged user classes.
	 * 
	 * @return
	 * 		All merged user classes.
	 */
	public List<MergedClass> getClasses() {
		return this.classes;
	}

	/**
	 * Get all merged user enums.
	 * 
	 * @return
	 * 		All merged user enums.
	 */
	public List<MergedEnum> getEnumes() {
		return this.enums;
	}	
}
