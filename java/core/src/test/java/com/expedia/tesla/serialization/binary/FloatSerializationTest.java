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

import com.expedia.tesla.serialization.FloatFixture;

/**
 * Serialization Float tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class FloatSerializationTest extends BaseFixture implements FloatFixture {
	@Test(expected = java.io.IOException.class)
	public void writeFloat_StreamIOException_Throws() throws Exception {
		this.getThrowWriter().writeFloat(null, POSITIVE_VALUE);
	}

	@Test
	public void writeFloat_Negative_Succeeds() throws Exception {
		this.getWriter().writeFloat(null, NEGATIVE_VALUE);
		assertArrayEquals(this.getOutput(), NEGATIVE_BINARY);
	}

	@Test
	public void writeFloat_Positive_Succeeds() throws Exception {
		this.getWriter().writeFloat(null, POSITIVE_VALUE);
		assertArrayEquals(this.getOutput(), POSITIVE_BINARY);
	}

	@Test
	public void writeFloat_TinyValue_Succeeds() throws Exception {
		this.getWriter().writeFloat(null, TINY_VALUE);
		assertArrayEquals(this.getOutput(), TINY_BINARY);
	}

	@Test
	public void writeFloat_MinValue_Succeeds() throws Exception {
		this.getWriter().writeFloat(null, MIN_VALUE);
		assertArrayEquals(MIN_BINARY, this.getOutput());
	}

	@Test
	public void writeFloat_MaxValue_Succeeds() throws Exception {
		this.getWriter().writeFloat(null, MAX_VALUE);
		assertArrayEquals(MAX_BINARY, this.getOutput());
	}

	@Test
	public void writeFloat_NegInfValue_Succeeds() throws Exception {
		this.getWriter().writeFloat(null, NEG_INF_VALUE);
		assertArrayEquals(this.getOutput(), NEG_INF_BINARY);
	}

	@Test
	public void writeFloat_PosInfValue_Succeeds() throws Exception {
		this.getWriter().writeFloat(null, POS_INF_VALUE);
		assertArrayEquals(this.getOutput(), POS_INF_BINARY);
	}

	@Test
	public void writeFloat_NaNValue_Succeeds() throws Exception {
		this.getWriter().writeFloat(null, NAN_VALUE);
		assertArrayEquals(this.getOutput(), NAN_BINARY);
	}
}
