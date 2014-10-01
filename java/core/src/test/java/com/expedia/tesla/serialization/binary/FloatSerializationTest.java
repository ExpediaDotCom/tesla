/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * FloatSerializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.FloatFixture;

/**
 * Serialization Float tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class FloatSerializationTest extends BaseFixture implements FloatFixture {
	@Test(expected = java.io.IOException.class)
	public void writeFloat_StreamIOException_Throws() throws Exception {
		this.getThrowWriter().writeFloat(null, POSITIVE_VALUE);
	}

	@Test
	public void writeFloat_Negative_Succeeds() throws Exception {
		this.getWriter().writeFloat(null, NEGATIVE_VALUE);
		assertArrayEquals(this.getOutput(), NEGATIVE_BINARY);
	}

	@Test
	public void writeFloat_Positive_Succeeds() throws Exception {
		this.getWriter().writeFloat(null, POSITIVE_VALUE);
		assertArrayEquals(this.getOutput(), POSITIVE_BINARY);
	}

	@Test
	public void writeFloat_TinyValue_Succeeds() throws Exception {
		this.getWriter().writeFloat(null, TINY_VALUE);
		assertArrayEquals(this.getOutput(), TINY_BINARY);
	}

	@Test
	public void writeFloat_MinValue_Succeeds() throws Exception {
		this.getWriter().writeFloat(null, MIN_VALUE);
		assertArrayEquals(MIN_BINARY, this.getOutput());
	}

	@Test
	public void writeFloat_MaxValue_Succeeds() throws Exception {
		this.getWriter().writeFloat(null, MAX_VALUE);
		assertArrayEquals(MAX_BINARY, this.getOutput());
	}

	@Test
	public void writeFloat_NegInfValue_Succeeds() throws Exception {
		this.getWriter().writeFloat(null, NEG_INF_VALUE);
		assertArrayEquals(this.getOutput(), NEG_INF_BINARY);
	}

	@Test
	public void writeFloat_PosInfValue_Succeeds() throws Exception {
		this.getWriter().writeFloat(null, POS_INF_VALUE);
		assertArrayEquals(this.getOutput(), POS_INF_BINARY);
	}

	@Test
	public void writeFloat_NaNValue_Succeeds() throws Exception {
		this.getWriter().writeFloat(null, NAN_VALUE);
		assertArrayEquals(this.getOutput(), NAN_BINARY);
	}
}
