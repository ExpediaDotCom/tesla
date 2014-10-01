/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * DoubleRoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Generic round-trip serialization tests for float values. Implement getWriter
 * and getReader to instantiate this test suite.
 * 
 * @author dheld
 */
public abstract class DoubleRoundTripTemplate extends BaseRoundTripTemplate
		implements DoubleFixture {
	private void test(double value) throws Exception {
		this.getWriter().writeDouble(null, value);
		assertEquals(value, this.getReader().readDouble(null), EPSILON);
	}

	public DoubleRoundTripTemplate(RoundTripFactory factory) {
		super(factory);
	}

	@Test
	public void writeReadDouble_Negative_Succeeds() throws Exception {
		test(NEGATIVE_VALUE);
	}

	@Test
	public void writeReadDouble_Positive_Succeeds() throws Exception {
		test(POSITIVE_VALUE);
	}

	@Test
	public void writeReadDouble_TinyValue_Succeeds() throws Exception {
		test(TINY_VALUE);
	}

	@Test
	public void writeReadDouble_MinValue_Succeeds() throws Exception {
		test(MIN_VALUE);
	}

	@Test
	public void writeReadDouble_MaxValue_Succeeds() throws Exception {
		test(MAX_VALUE);
	}

	@Test
	public void writeReadDouble_NegativeInfinity_Succeeds() throws Exception {
		test(NEG_INF_VALUE);
	}

	@Test
	public void writeReadDouble_PositiveInfinity_Succeeds() throws Exception {
		test(POS_INF_VALUE);
	}

	@Test
	public void writeReadDouble_NaN_Succeeds() throws Exception {
		test(NAN_VALUE);
	}
}
