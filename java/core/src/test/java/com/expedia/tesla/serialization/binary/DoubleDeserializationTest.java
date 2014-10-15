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

import com.expedia.tesla.serialization.DoubleFixture;
import com.expedia.tesla.serialization.TeslaDeserializationException;

/**
 * Deserialization Double tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class DoubleDeserializationTest extends BaseFixture implements
		DoubleFixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readDouble_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readDouble(null);
	}

	@Test
	public void readDouble_NegativeValue_Succeeds() throws Exception {
		final double actual = this.getReader(NEGATIVE_BINARY).readDouble(null);
		assertEquals(NEGATIVE_VALUE, actual, EPSILON);
	}

	@Test
	public void readDouble_PositiveValue_Succeeds() throws Exception {
		final double actual = this.getReader(POSITIVE_BINARY).readDouble(null);
		assertEquals(POSITIVE_VALUE, actual, EPSILON);
	}

	@Test
	public void readDouble_TinyValue_Succeeds() throws Exception {
		final double actual = this.getReader(TINY_BINARY).readDouble(null);
		assertEquals(TINY_VALUE, actual, EPSILON);
	}

	@Test
	public void readDouble_MinValue_Succeeds() throws Exception {
		final double actual = this.getReader(MIN_BINARY).readDouble(null);
		assertEquals(MIN_VALUE, actual, EPSILON);
	}

	@Test
	public void readDouble_MaxValue_Succeeds() throws Exception {
		final double actual = this.getReader(MAX_BINARY).readDouble(null);
		assertEquals(MAX_VALUE, actual, EPSILON);
	}

	@Test
	public void readDouble_NegInfValue_Succeeds() throws Exception {
		final double actual = this.getReader(NEG_INF_BINARY).readDouble(null);
		assertEquals(NEG_INF_VALUE, actual, EPSILON);
	}

	@Test
	public void readDouble_PosInfValue_Succeeds() throws Exception {
		final double actual = this.getReader(POS_INF_BINARY).readDouble(null);
		assertEquals(POS_INF_VALUE, actual, EPSILON);
	}

	@Test
	public void readDouble_NaNValue_Succeeds() throws Exception {
		final double actual = this.getReader(NAN_BINARY).readDouble(null);
		assertEquals(NAN_VALUE, actual, EPSILON);
	}

}
