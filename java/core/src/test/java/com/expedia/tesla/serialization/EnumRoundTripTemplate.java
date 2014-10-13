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
 * Generic round-trip serialization tests for enum values. Implement getWriter
 * and getReader to instantiate this test suite.
 * 
 * @author yzuo
 */
public abstract class EnumRoundTripTemplate extends BaseRoundTripTemplate
		implements EnumFixture {
	private void test(Int value) throws Exception {
		this.getWriter().writeEnum(null, value, Int.MAPPER);
		assertEquals(value, this.getReader().readEnum(null, Int.MAPPER));
	}

	public EnumRoundTripTemplate(RoundTripFactory factory) {
		super(factory);
	}

	@Test
	public void writeReadEnum_MinValue_Succeeds() throws Exception {
		test(Int.Min);
	}

	@Test
	public void writeReadEnum_MaxValue_Succeeds() throws Exception {
		test(Int.Max);
	}

	@Test
	public void writeReadEnum_NegativeValue_Succeeds() throws Exception {
		test(Int.Negative);
	}

	@Test
	public void writeReadEnum_PositiveValue_Succeeds() throws Exception {
		test(Int.Positive);
	}
}
