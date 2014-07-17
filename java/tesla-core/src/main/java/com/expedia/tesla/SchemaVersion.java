/**
 *
 * SchemaVersion.java
 *
 * Copyright 2013 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.tesla;

/**
 * Application schema version interface. An application schema is defined in a
 * schema file (TML) file. Tesla use schema file hash internally as application
 * schema version.
 * 
 * <p>
 * Tesla can easily detect schema mismatch by comparing schema file hash.
 * However, it is not human friendly. This class gives more human friendly
 * version alias. Tesla provide a following version alias:
 * <li>Version name: any string value. This is defined in TML file.</li>
 * <li>Version number: an short integer number.</li>
 * <li>TML file name: the name of TML file in which the schema is defined.</li>
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 * 
 */
public class SchemaVersion implements Comparable<SchemaVersion>, ISchemaVersion {
	private long schemaHash;
	private short versionNumber;
	private String name;
	private String tmlFileName;

	public SchemaVersion(long schemaHash, short versionNumber, String name,
			String tmlFileName) {
		this.name = name;
		this.schemaHash = schemaHash;
		this.versionNumber = versionNumber;
		this.tmlFileName = tmlFileName;
	}

	public SchemaVersion(long schemaHash) {
		this(schemaHash, (short) 0, null, null);
	}

	public SchemaVersion(short versionNumber) {
		this(versionNumber, versionNumber, null, null);
	}

	public SchemaVersion(SchemaVersion version) {
		this(version.getSchemaHash(), version.getVersionNumber(), version
				.getName(), version.tmlFileName);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getTmlFileName() {
		return tmlFileName;
	}

	@Override
	public short getVersionNumber() {
		return versionNumber;
	}

	@Override
	public long getSchemaHash() {
		return schemaHash;
	}

	@Override
	public int compareTo(SchemaVersion o) {
		long d = this.schemaHash - o.schemaHash;
		return d == 0 ? 0 : (d < 0 ? -1 : 1);
	}

	@Override
	public String toString() {
		return String.format(
				"SchemaVersion name: %s, number: %d, hash: %d, tml: %s", name,
				versionNumber, schemaHash, tmlFileName);
	}
}
