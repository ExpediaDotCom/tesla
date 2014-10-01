/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * UInt64RoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

/**
 * Generic round-trip serialization tests for UInt64 values. Implement getWriter
 * and getReader to instantiate this test suite.
 * 
 * @author dheld
 */
public abstract class UInt64RoundTripTemplate extends BaseRoundTripTemplate
		implements UInt64Fixture {
	private void test(BigInteger value) throws Exception {
		this.getWriter().writeUInt64(null, value.longValue());
		assertEquals(value.longValue(), this.getReader().readUInt64(null));
	}

	public UInt64RoundTripTemplate(RoundTripFactory factory) {
		super(factory);
	}

	@Test
	public void writeReadUInt64_MinValue_Succeeds() throws Exception {
		test(MIN_VALUE);
	}

	@Test
	public void writeReadUInt64_MaxValue_Succeeds() throws Exception {
		test(MAX_VALUE);
	}

	@Test
	public void writeReadUInt64_SmallValue_Succeeds() throws Exception {
		test(SMALL_VALUE);
	}

	@Test
	public void writeReadUInt64_LargeValue_Succeeds() throws Exception {
		test(LARGE_VALUE);
	}
}
