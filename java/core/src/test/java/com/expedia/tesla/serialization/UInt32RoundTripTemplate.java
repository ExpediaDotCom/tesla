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
package com.expedia.tesla.serialization;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Generic round-trip serialization tests for UInt32 values. Implement getWriter
 * and getReader to instantiate this test suite.
 * 
 * @author dheld
 */
public abstract class UInt32RoundTripTemplate extends BaseRoundTripTemplate
		implements UInt32Fixture {
	private void test(long value) throws Exception {
		this.getWriter().writeUInt32(null, (int) value);
		assertEquals((int) value, this.getReader().readUInt32(null));
	}

	public UInt32RoundTripTemplate(RoundTripFactory factory) {
		super(factory);
	}

	@Test
	public void writeReadUInt32_MinValue_Succeeds() throws Exception {
		test(MIN_VALUE);
	}

	@Test
	public void writeReadUInt32_MaxValue_Succeeds() throws Exception {
		test(MAX_VALUE);
	}

	@Test
	public void writeReadUInt32_SmallValue_Succeeds() throws Exception {
		test(SMALL_VALUE);
	}

	@Test
	public void writeReadUInt32_LargeValue_Succeeds() throws Exception {
		test(LARGE_VALUE);
	}
}
