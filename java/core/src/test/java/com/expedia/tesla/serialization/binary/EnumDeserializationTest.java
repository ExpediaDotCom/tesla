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

import com.expedia.tesla.serialization.EnumFixture;
import com.expedia.tesla.serialization.TeslaDeserializationException;

/**
 * Deserialization enum tests for the Tesla Binary format.
 * 
 * @author yzuo
 */
public class EnumDeserializationTest extends BaseFixture implements EnumFixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readEnum_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readEnum(null, Int.MAPPER);
	}

	@Test
	public void readEnum_Max_Succeeds() throws Exception {
		final Int actual = this.getReader(MAX_BINARY)
				.readEnum(null, Int.MAPPER);
		assertEquals(Int.Max, actual);
	}

	@Test
	public void readEnum_Min_Succeeds() throws Exception {
		final Int actual = this.getReader(MIN_BINARY)
				.readEnum(null, Int.MAPPER);
		assertEquals(Int.Min, actual);
	}

	@Test
	public void readEnum_Positive_Succeeds() throws Exception {
		final Int actual = this.getReader(POSITIVE_BINARY).readEnum(null,
				Int.MAPPER);
		assertEquals(Int.Positive, actual);
	}

	@Test
	public void readEnum_Negative_Succeeds() throws Exception {
		final Int actual = this.getReader(NEGATIVE_BINARY).readEnum(null,
				Int.MAPPER);
		assertEquals(Int.Negative, actual);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readInt32_OversizeValue_Throws() throws Exception {
		this.getReader(OVERSIZE_BINARY).readEnum(null, Int.MAPPER);
	}

}
