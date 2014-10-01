/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * UInt16RoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Generic round-trip serialization tests for UInt16 values. Implement getWriter
 * and getReader to instantiate this test suite.
 * 
 * @author dheld
 */
public abstract class UInt16RoundTripTemplate extends BaseRoundTripTemplate
		implements UInt16Fixture {
	private void test(int value) throws Exception {
		this.getWriter().writeUInt16(null, (short) value);
		assertEquals((short) value, this.getReader().readUInt16(null));
	}

	public UInt16RoundTripTemplate(RoundTripFactory factory) {
		super(factory);
	}

	@Test
	public void writeReadUInt16_MinValue_Succeeds() throws Exception {
		test(MIN_VALUE);
	}

	@Test
	public void writeReadUInt16_MaxValue_Succeeds() throws Exception {
		test(MAX_VALUE);
	}

	@Test
	public void writeReadUInt16_SmallValue_Succeeds() throws Exception {
		test(SMALL_VALUE);
	}

	@Test
	public void writeReadUInt16_LargeValue_Succeeds() throws Exception {
		test(LARGE_VALUE);
	}
}
