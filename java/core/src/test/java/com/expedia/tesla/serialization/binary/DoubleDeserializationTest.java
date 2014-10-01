/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * DoubleDeserializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.DoubleFixture;
import com.expedia.tesla.serialization.TeslaDeserializationException;

/**
 * Deserialization Double tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class DoubleDeserializationTest extends BaseFixture implements
		DoubleFixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readDouble_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readDouble(null);
	}

	@Test
	public void readDouble_NegativeValue_Succeeds() throws Exception {
		final double actual = this.getReader(NEGATIVE_BINARY).readDouble(null);
		assertEquals(NEGATIVE_VALUE, actual, EPSILON);
	}

	@Test
	public void readDouble_PositiveValue_Succeeds() throws Exception {
		final double actual = this.getReader(POSITIVE_BINARY).readDouble(null);
		assertEquals(POSITIVE_VALUE, actual, EPSILON);
	}

	@Test
	public void readDouble_TinyValue_Succeeds() throws Exception {
		final double actual = this.getReader(TINY_BINARY).readDouble(null);
		assertEquals(TINY_VALUE, actual, EPSILON);
	}

	@Test
	public void readDouble_MinValue_Succeeds() throws Exception {
		final double actual = this.getReader(MIN_BINARY).readDouble(null);
		assertEquals(MIN_VALUE, actual, EPSILON);
	}

	@Test
	public void readDouble_MaxValue_Succeeds() throws Exception {
		final double actual = this.getReader(MAX_BINARY).readDouble(null);
		assertEquals(MAX_VALUE, actual, EPSILON);
	}

	@Test
	public void readDouble_NegInfValue_Succeeds() throws Exception {
		final double actual = this.getReader(NEG_INF_BINARY).readDouble(null);
		assertEquals(NEG_INF_VALUE, actual, EPSILON);
	}

	@Test
	public void readDouble_PosInfValue_Succeeds() throws Exception {
		final double actual = this.getReader(POS_INF_BINARY).readDouble(null);
		assertEquals(POS_INF_VALUE, actual, EPSILON);
	}

	@Test
	public void readDouble_NaNValue_Succeeds() throws Exception {
		final double actual = this.getReader(NAN_BINARY).readDouble(null);
		assertEquals(NAN_VALUE, actual, EPSILON);
	}

}
