/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * Int64RoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Generic round-trip serialization tests for Int64 values. Implement getWriter
 * and getReader to instantiate this test suite.
 * 
 * @author dheld
 */
public abstract class Int64RoundTripTemplate extends BaseRoundTripTemplate
		implements Int64Fixture {
	private void test(long value) throws Exception {
		this.getWriter().writeInt64(null, value);
		assertEquals(value, this.getReader().readInt64(null));
	}

	public Int64RoundTripTemplate(RoundTripFactory factory) {
		super(factory);
	}

	@Test
	public void writeReadInt64_MinValue_Succeeds() throws Exception {
		test(MIN_VALUE);
	}

	@Test
	public void writeReadInt64_MaxValue_Succeeds() throws Exception {
		test(MAX_VALUE);
	}

	@Test
	public void writeReadInt64_NegativeValue_Succeeds() throws Exception {
		test(NEGATIVE_VALUE);
	}

	@Test
	public void writeReadInt64_PositiveValue_Succeeds() throws Exception {
		test(POSITIVE_VALUE);
	}
}
