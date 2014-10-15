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

import org.junit.Test;

import com.expedia.tesla.serialization.ByteFixture;

/**
 * Serialization Byte tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class ByteSerializationTest extends BaseFixture implements ByteFixture {
	@Test(expected = java.io.IOException.class)
	public void writeByte_StreamIOException_Throws() throws Exception {
		this.getThrowWriter().writeByte(null, (byte) SMALL_VALUE);
	}

	@Test
	public void writeByte_MinValue_Succeeds() throws Exception {
		this.getWriter().writeByte(null, (byte) MIN_VALUE);
		assertArrayEquals(MIN_BINARY, this.getOutput());
	}

	@Test
	public void writeByte_MaxValue_Succeeds() throws Exception {
		this.getWriter().writeByte(null, (byte) MAX_VALUE);
		assertArrayEquals(MAX_BINARY, this.getOutput());
	}

	@Test
	public void writeByte_SmallValue_Succeeds() throws Exception {
		this.getWriter().writeByte(null, (byte) SMALL_VALUE);
		assertArrayEquals(SMALL_BINARY, this.getOutput());
	}

	@Test
	public void writeByte_LargeValue_Succeeds() throws Exception {
		this.getWriter().writeByte(null, (byte) LARGE_VALUE);
		assertArrayEquals(LARGE_BINARY, this.getOutput());
	}
}
