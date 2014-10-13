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
public class SchemaVersion implements Comparable<SchemaVersion> {
	private long schemaHash;
	private int versionNumber;
	private String name;
	private String tmlFileName;

	public SchemaVersion(long schemaHash, int versionNumber, String name,
			String tmlFileName) {
		this.name = name;
		this.schemaHash = schemaHash;
		this.versionNumber = versionNumber;
		this.tmlFileName = tmlFileName;
	}

	public SchemaVersion(long schemaHash) {
		this(schemaHash, (short) 0, null, null);
	}

	public SchemaVersion(int versionNumber) {
		this(versionNumber, versionNumber, null, null);
	}

	public SchemaVersion(SchemaVersion version) {
		this(version.getSchemaHash(), version.getVersionNumber(), version
				.getName(), version.tmlFileName);
	}

	public String getName() {
		return name;
	}

	public String getTmlFileName() {
		return tmlFileName;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public long getSchemaHash() {
		return schemaHash;
	}

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
