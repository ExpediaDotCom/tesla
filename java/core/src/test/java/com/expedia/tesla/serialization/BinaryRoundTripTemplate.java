/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * BinaryRoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * Generic round-trip serialization tests for Binary values. Implement getWriter
 * and getReader to instantiate this test suite.
 * 
 * @author dheld
 */
public abstract class BinaryRoundTripTemplate extends BaseRoundTripTemplate
		implements BinaryFixture {
	private void test(byte[] value) throws Exception {
		this.getWriter().writeBinary(null, value);
		assertArrayEquals(value, this.getReader().readBinary(null));
	}

	public BinaryRoundTripTemplate(RoundTripFactory factory) {
		super(factory);
	}

	@Test
	public void writeReadBinary_EmptyValue_Succeeds()
			throws Exception {
		test(EMPTY_VALUE);
	}

	@Test
	public void writeReadBinary_SmallValue_Succeeds()
			throws Exception {
		test(SMALL_VALUE);
	}

	@Test
	public void writeReadBinary_LargeValue_Succeeds()
			throws Exception {
		test(LARGE_VALUE);
	}
}
