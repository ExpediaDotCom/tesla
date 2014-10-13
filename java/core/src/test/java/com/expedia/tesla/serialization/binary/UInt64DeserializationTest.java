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
import com.expedia.tesla.serialization.UInt64Fixture;

/**
 * Deserialization UInt64 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class UInt64DeserializationTest extends BaseFixture implements
		UInt64Fixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readUInt64_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readUInt64(null);
	}

	@Test
	public void readUInt64_MinValue_Succeeds() throws Exception {
		final long actual = this.getReader(MIN_BINARY).readUInt64(null);
		assertEquals(MIN_VALUE.longValue(), actual);
	}

	@Test
	public void readUInt64_MaxValue_Succeeds() throws Exception {
		final long actual = this.getReader(MAX_BINARY).readUInt64(null);
		assertEquals(MAX_VALUE.longValue(), actual);
	}

	@Test
	public void readUInt64_SmallValue_Succeeds() throws Exception {
		final long actual = this.getReader(SMALL_BINARY).readUInt64(null);
		assertEquals(SMALL_VALUE.longValue(), actual);
	}

	@Test
	public void readUInt64_LargeValue_Succeeds() throws Exception {
		final long actual = this.getReader(LARGE_BINARY).readUInt64(null);
		assertEquals(LARGE_VALUE.longValue(), actual);
	}

}
