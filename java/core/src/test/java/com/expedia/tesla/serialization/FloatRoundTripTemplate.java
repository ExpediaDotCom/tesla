/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * FloatRoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Generic round-trip serialization tests for Float values. Implement getWriter
 * and getReader to instantiate this test suite.
 * 
 * @author dheld
 */
public abstract class FloatRoundTripTemplate extends BaseRoundTripTemplate
		implements FloatFixture {
	private void test(float value) throws Exception {
		this.getWriter().writeFloat(null, value);
		assertEquals(value, this.getReader().readFloat(null), EPSILON);
	}

	public FloatRoundTripTemplate(RoundTripFactory factory) {
		super(factory);
	}

	@Test
	public void writeReadFloat_Negative_Succeeds() throws Exception {
		test(NEGATIVE_VALUE);
	}

	@Test
	public void writeReadFloat_Positive_Succeeds() throws Exception {
		test(POSITIVE_VALUE);
	}

	@Test
	public void writeReadFloat_TinyValue_Succeeds() throws Exception {
		test(TINY_VALUE);
	}

	@Test
	public void writeReadFloat_MinValue_Succeeds() throws Exception {
		test(MIN_VALUE);
	}

	@Test
	public void writeReadFloat_MaxValue_Succeeds() throws Exception {
		test(MAX_VALUE);
	}

	@Test
	public void writeReadFloat_NegativeInfinity_Succeeds() throws Exception {
		test(NEG_INF_VALUE);
	}

	@Test
	public void writeReadFloat_PositiveInfinity_Succeeds() throws Exception {
		test(POS_INF_VALUE);
	}

	@Test
	public void writeReadFloat_NaN_Succeeds() throws Exception {
		test(NAN_VALUE);
	}
}
