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

import com.expedia.tesla.serialization.FloatFixture;
import com.expedia.tesla.serialization.TeslaDeserializationException;

/**
 * Deserialization Float tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class FloatDeserializationTest extends BaseFixture implements
		FloatFixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readFloat_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readFloat(null);
	}

	@Test
	public void readFloat_NegativeValue_Succeeds() throws Exception {
		final float actual = this.getReader(NEGATIVE_BINARY).readFloat(null);
		assertEquals(NEGATIVE_VALUE, actual, EPSILON);
	}

	@Test
	public void readFloat_PositiveValue_Succeeds() throws Exception {
		final float actual = this.getReader(POSITIVE_BINARY).readFloat(null);
		assertEquals(POSITIVE_VALUE, actual, EPSILON);
	}

	@Test
	public void readFloat_TinyValue_Succeeds() throws Exception {
		final float actual = this.getReader(TINY_BINARY).readFloat(null);
		assertEquals(TINY_VALUE, actual, EPSILON);
	}

	@Test
	public void readFloat_MinValue_Succeeds() throws Exception {
		final float actual = this.getReader(MIN_BINARY).readFloat(null);
		assertEquals(MIN_VALUE, actual, EPSILON);
	}

	@Test
	public void readFloat_MaxValue_Succeeds() throws Exception {
		final float actual = this.getReader(MAX_BINARY).readFloat(null);
		assertEquals(MAX_VALUE, actual, EPSILON);
	}

	@Test
	public void readFloat_NegInfValue_Succeeds() throws Exception {
		final float actual = this.getReader(NEG_INF_BINARY).readFloat(null);
		assertEquals(NEG_INF_VALUE, actual, EPSILON);
	}

	@Test
	public void readFloat_PosInfValue_Succeeds() throws Exception {
		final float actual = this.getReader(POS_INF_BINARY).readFloat(null);
		assertEquals(POS_INF_VALUE, actual, EPSILON);
	}

	@Test
	public void readFloat_NaNValue_Succeeds() throws Exception {
		final float actual = this.getReader(NAN_BINARY).readFloat(null);
		assertEquals(NAN_VALUE, actual, EPSILON);
	}

}
