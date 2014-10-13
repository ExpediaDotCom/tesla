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
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.expedia.tesla.serialization.BinaryReader;

/**
 * Unit tests for the Tesla BinaryReader.
 * 
 * @author dheld
 */
public class BinaryReaderTest extends BaseFixture {
	@Test(expected = java.lang.NullPointerException.class)
	public void BinaryReader_Null_Throws() throws Exception {
		new BinaryReader((byte[]) null, SCHEMA_VERSION).close();
	}

	@Test
	public void BinaryReader_NonNull_Succeeds() throws Exception {
		assertNotNull(new BinaryReader(BINARY_FALSE, SCHEMA_VERSION));
	}

	@Test
	public void getVersion__Succeeds() throws Exception {
		assertEquals(SCHEMA_VERSION.getSchemaHash(),
				this.getReader(BINARY_FALSE).getVersion().getSchemaHash());
	}

}
