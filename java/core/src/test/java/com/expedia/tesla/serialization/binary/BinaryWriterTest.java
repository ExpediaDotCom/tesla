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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedOutputStream;
import java.io.IOException;

import org.junit.Test;

import com.expedia.tesla.serialization.BinaryWriter;
import com.expedia.tesla.serialization.TeslaWriter;

/**
 * Unit tests for the Tesla BinaryWriter.
 * 
 * @author dheld
 */
public class BinaryWriterTest extends BaseFixture {
	@Test(expected = IllegalArgumentException.class)
	public void BinaryWriter_Null_Throws() throws Exception {
		new BinaryWriter(null, SCHEMA_VERSION).close();
	}

	@Test
	public void BinaryWriter_NonNull_Succeeds() throws Exception {
		assertNotNull(this.getWriter());
	}

	@Test
	public void getVersion__Succeeds() throws Exception {
		assertEquals(SCHEMA_VERSION.getSchemaHash(), this.getWriter().getVersion().getSchemaHash());
	}

	@Test(expected = IOException.class)
	public void flush_StreamIOException_Throws() throws Exception {
		this.getThrowWriter().flush();
	}

	@Test
	public void flush__Succeeds() throws Exception {
		final TeslaWriter writer = new BinaryWriter(new BufferedOutputStream(
				this.getOutputStream(), 16), SCHEMA_VERSION);
		writer.writeBoolean(null, true);
		assertArrayEquals(EMPTY_STREAM, this.getOutput());
		writer.flush();
		assertArrayEquals(BINARY_TRUE, this.getOutput());
		writer.close();
	}
}
