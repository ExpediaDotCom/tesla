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

import com.expedia.tesla.serialization.BinaryFixture;
import com.expedia.tesla.serialization.TeslaDeserializationException;

/**
 * Deserialization Binary tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class BinaryDeserializationTest extends BaseFixture implements
		BinaryFixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readBinary_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readBinary(null);
	}

	@Test
	public void readBinary_EmptyValueNonnullable_Succeeds() throws Exception {
		final byte[] actual = this.getReader(EMPTY_BINARY).readBinary(null);
		assertArrayEquals(EMPTY_VALUE, actual);
	}

	@Test
	public void readBinary_SmallValueNonnullable_Succeeds() throws Exception {
		final byte[] actual = this.getReader(SMALL_BINARY).readBinary(null);
		assertArrayEquals(SMALL_VALUE, actual);
	}

	@Test
	public void readBinary_LargeValueNonnullable_Succeeds() throws Exception {
		final byte[] actual = this.getReader(LARGE_BINARY).readBinary(null);
		assertArrayEquals(LARGE_VALUE, actual);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readBinary_UndersizeValueNonnullable_Throws() throws Exception {
		this.getReader(UNDERSIZE_BINARY).readBinary(null);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readBinary_OversizeValueNonnullable_Throws() throws Exception {
		this.getReader(OVERSIZE_BINARY).readBinary(null);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readBinary_ShortValueNonnullable_Throws() throws Exception {
		this.getReader(SHORT_BINARY).readBinary(null);
	}
}
