/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * Int16DeserializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.Int16Fixture;
import com.expedia.tesla.serialization.TeslaDeserializationException;

/**
 * Deserialization Int16 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class Int16DeserializationTest extends BaseFixture implements
		Int16Fixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readInt16_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readInt16(null);
	}

	@Test
	public void readInt16_MinValue_Succeeds() throws Exception {
		final short actual = this.getReader(MIN_BINARY).readInt16(null);
		assertEquals(MIN_VALUE, actual);
	}

	@Test
	public void readInt16_MaxValue_Succeeds() throws Exception {
		final short actual = this.getReader(MAX_BINARY).readInt16(null);
		assertEquals(MAX_VALUE, actual);
	}

	@Test
	public void readInt16_NegativeValue_Succeeds() throws Exception {
		final short actual = this.getReader(NEGATIVE_BINARY).readInt16(null);
		assertEquals(NEGATIVE_VALUE, actual);
	}

	@Test
	public void readInt16_PositiveValue_Succeeds() throws Exception {
		final short actual = this.getReader(POSITIVE_BINARY).readInt16(null);
		assertEquals(POSITIVE_VALUE, actual);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readInt16_OversizeValue_Throws() throws Exception {
		this.getReader(OVERSIZE_BINARY).readInt16(null);
	}
}
