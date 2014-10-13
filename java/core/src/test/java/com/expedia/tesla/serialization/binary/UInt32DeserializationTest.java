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

import org.junit.Test;

import com.expedia.tesla.serialization.TeslaDeserializationException;
import com.expedia.tesla.serialization.UInt32Fixture;

/**
 * Deserialization UInt32 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class UInt32DeserializationTest extends BaseFixture implements
		UInt32Fixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readUInt32_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readUInt32(null);
	}

	@Test
	public void readUInt32_MinValue_Succeeds() throws Exception {
		final int actual = this.getReader(MIN_BINARY).readUInt32(null);
		assertEquals((int) MIN_VALUE, actual);
	}

	@Test
	public void readUInt32_MaxValue_Succeeds() throws Exception {
		final int actual = this.getReader(MAX_BINARY).readUInt32(null);
		assertEquals((int) MAX_VALUE, actual);
	}

	@Test
	public void readUInt32_SmallValue_Succeeds() throws Exception {
		final int actual = this.getReader(SMALL_BINARY).readUInt32(null);
		assertEquals((int) SMALL_VALUE, actual);
	}

	@Test
	public void readUInt32_LargeValue_Succeeds() throws Exception {
		final int actual = this.getReader(LARGE_BINARY).readUInt32(null);
		assertEquals((int) LARGE_VALUE, actual);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readUInt32_OversizeValue_Throws() throws Exception {
		this.getReader(OVERSIZE_BINARY).readUInt32(null);
	}
}
