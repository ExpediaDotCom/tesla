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
import com.expedia.tesla.serialization.UInt16Fixture;

/**
 * Deserialization UInt16 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class UInt16DeserializationTest extends BaseFixture implements
		UInt16Fixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readUInt16_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readUInt16(null);
	}

	@Test
	public void readUInt16_MinValue_Succeeds() throws Exception {
		final short actual = this.getReader(MIN_BINARY).readUInt16(null);
		assertEquals((short) MIN_VALUE, actual);
	}

	@Test
	public void readUInt16_MaxValue_Succeeds() throws Exception {
		final short actual = this.getReader(MAX_BINARY).readUInt16(null);
		assertEquals((short) MAX_VALUE, actual);
	}

	@Test
	public void readUInt16_SmallValue_Succeeds() throws Exception {
		final short actual = this.getReader(SMALL_BINARY).readUInt16(null);
		assertEquals((short) SMALL_VALUE, actual);
	}

	@Test
	public void readUInt16_LargeValue_Succeeds() throws Exception {
		final short actual = this.getReader(LARGE_BINARY).readUInt16(null);
		assertEquals((short) LARGE_VALUE, actual);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readUInt16_OversizeValue_Throws() throws Exception {
		this.getReader(OVERSIZE_BINARY).readUInt16(null);
	}
}
