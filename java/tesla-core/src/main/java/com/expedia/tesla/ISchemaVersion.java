/**
 *
 * ISchemaVersion.java
 *
 * Copyright 2013 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.tesla;

/**
 * Application schema version interface.
 * 
 * Tesla V1 use one TML file to define all versions. The schema is versioned by
 * a 16 bit integer value. You can specify a min/max version number for each
 * class or field definition.
 * 
 * Tesla V2 use totally different verioning system. Each application schema
 * version is defined in its own TML file. Once the version is shipped, it can't
 * be changed. A new version of the same objects is defined in a different copy
 * of TML file. Tesla compiler will merge all versions for you automatically
 * when the TML files are compiled. Meanwhile, compiler will generate a hash
 * value for each schema version. This hash value will be used to validate the
 * schema when it is serializing/deserializing an object.
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 * 
 */
public interface ISchemaVersion {
	/**
	 * Get the schema hash.
	 * 
	 * @return schema hash
	 */
	long getSchemaHash();

	/**
	 * Get the schema name.
	 * 
	 * Each user application schema must have a unique human friendly name (e.g.
	 * "Sample Service v2.1.3").
	 * 
	 * @return Schema name.
	 */
	String getName();

	/**
	 * Get the schema (TML) file name.
	 * 
	 * @return The TML file name. null if the schema is generated from source
	 *         code directly.
	 */
	String getTmlFileName();

	/**
	 * Get the application schema version number.
	 * 
	 * Version number is an optional schema version component. Tesla doesn't
	 * check uniqueness of this version number.
	 * 
	 * @return The version number defined in the schema (TML). It will return 0
	 *         if the version number is not defined.
	 */
	short getVersionNumber();
}
