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

import com.expedia.tesla.serialization.Int32Fixture;
import com.expedia.tesla.serialization.TeslaDeserializationException;

/**
 * Deserialization Int32 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class Int32DeserializationTest extends BaseFixture implements
		Int32Fixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readInt32_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readInt32(null);
	}

	@Test
	public void readInt32_MinValue_Succeeds() throws Exception {
		final int actual = this.getReader(MIN_BINARY).readInt32(null);
		assertEquals(MIN_VALUE, actual);
	}

	@Test
	public void readInt32_MaxValue_Succeeds() throws Exception {
		final int actual = this.getReader(MAX_BINARY).readInt32(null);
		assertEquals(MAX_VALUE, actual);
	}

	@Test
	public void readInt32_NegativeValue_Succeeds() throws Exception {
		final int actual = this.getReader(NEGATIVE_BINARY).readInt32(null);
		assertEquals(NEGATIVE_VALUE, actual);
	}

	@Test
	public void readInt32_PositiveValue_Succeeds() throws Exception {
		final int actual = this.getReader(POSITIVE_BINARY).readInt32(null);
		assertEquals(POSITIVE_VALUE, actual);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readInt32_OversizeValue_Throws() throws Exception {
		this.getReader(OVERSIZE_BINARY).readInt32(null);
	}

}
