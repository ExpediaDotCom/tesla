/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * Int32RoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Generic round-trip serialization tests for Int32 values. Implement getWriter
 * and getReader to instantiate this test suite.
 * 
 * @author dheld
 */
public abstract class Int32RoundTripTemplate extends BaseRoundTripTemplate
		implements Int32Fixture {
	private void test(int value) throws Exception {
		this.getWriter().writeInt32(null, value);
		assertEquals(value, this.getReader().readInt32(null));
	}

	public Int32RoundTripTemplate(RoundTripFactory factory) {
		super(factory);
	}

	@Test
	public void writeReadInt32_MinValue_Succeeds() throws Exception {
		test(MIN_VALUE);
	}

	@Test
	public void writeReadInt32_MaxValue_Succeeds() throws Exception {
		test(MAX_VALUE);
	}

	@Test
	public void writeReadInt32_NegativeValue_Succeeds() throws Exception {
		test(NEGATIVE_VALUE);
	}

	@Test
	public void writeReadInt32_PositiveValue_Succeeds() throws Exception {
		test(POSITIVE_VALUE);
	}
}
