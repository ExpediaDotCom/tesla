/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * ISerializableRoundTripTest.java
 ******************************************************************************/
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
