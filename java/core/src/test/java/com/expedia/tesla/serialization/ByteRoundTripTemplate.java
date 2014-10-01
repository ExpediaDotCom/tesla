/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * ByteRoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Generic round-trip serialization tests for Byte values. Implement getWriter
 * and getReader to instantiate this test suite.
 * 
 * @author dheld
 */
public abstract class ByteRoundTripTemplate extends BaseRoundTripTemplate
		implements ByteFixture {
	private void test(int value) throws Exception {
		this.getWriter().writeByte(null, (byte) value);
		assertEquals((byte) value, this.getReader().readByte(null));
	}

	public ByteRoundTripTemplate(RoundTripFactory factory) {
		super(factory);
	}

	@Test
	public void writeReadByte_MinValue_Succeeds() throws Exception {
		test(MIN_VALUE);
	}

	@Test
	public void writeReadByte_MaxValue_Succeeds() throws Exception {
		test(MAX_VALUE);
	}

	@Test
	public void writeReadByte_SmallValue_Succeeds() throws Exception {
		test(SMALL_VALUE);
	}

	@Test
	public void writeReadByte_LargeValue_Succeeds() throws Exception {
		test(LARGE_VALUE);
	}
}
