/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * Int16RoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Generic round-trip serialization tests for Int16 values. Implement getWriter
 * and getReader to instantiate this test suite.
 * 
 * @author dheld
 */
public abstract class Int16RoundTripTemplate extends BaseRoundTripTemplate
		implements Int16Fixture {
	private void test(short value) throws Exception {
		this.getWriter().writeInt16(null, value);
		assertEquals(value, this.getReader().readInt16(null));
	}

	public Int16RoundTripTemplate(RoundTripFactory factory) {
		super(factory);
	}

	@Test
	public void writeReadInt16_MinValue_Succeeds() throws Exception {
		test(MIN_VALUE);
	}

	@Test
	public void writeReadInt16_MaxValue_Succeeds() throws Exception {
		test(MAX_VALUE);
	}

	@Test
	public void writeReadInt16_NegativeValue_Succeeds() throws Exception {
		test(NEGATIVE_VALUE);
	}

	@Test
	public void writeReadInt16_PositiveValue_Succeeds() throws Exception {
		test(POSITIVE_VALUE);
	}
}
