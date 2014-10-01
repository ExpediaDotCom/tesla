/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * StringRoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Generic round-trip serialization tests for String values. Implement getWriter
 * and getReader to instantiate this test suite.
 * 
 * @author dheld
 */
public abstract class StringRoundTripTemplate extends BaseRoundTripTemplate
		implements StringFixture {
	private void test(String value) throws Exception {
		this.getWriter().writeString(null, value);
		assertEquals(value, this.getReader().readString(null));
	}

	public StringRoundTripTemplate(RoundTripFactory factory) {
		super(factory);
	}

	@Test
	public void writeReadString_EmptyValue_Succeeds()
			throws Exception {
		test(EMPTY_VALUE);
	}

	@Test
	public void writeReadString_AsciiValue_Succeeds()
			throws Exception {
		test(ASCII_VALUE);
	}

	@Test
	public void writeReadString_Latin1Value_Succeeds()
			throws Exception {
		test(LATIN1_VALUE);
	}

	@Test
	public void writeReadString_CjkValue_Succeeds() throws Exception {
		test(CJK_VALUE);
	}
}
