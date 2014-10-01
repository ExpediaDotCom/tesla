/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * UInt16DeserializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.TeslaDeserializationException;
import com.expedia.tesla.serialization.UInt16Fixture;

/**
 * Deserialization UInt16 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class UInt16DeserializationTest extends BaseFixture implements
		UInt16Fixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readUInt16_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readUInt16(null);
	}

	@Test
	public void readUInt16_MinValue_Succeeds() throws Exception {
		final short actual = this.getReader(MIN_BINARY).readUInt16(null);
		assertEquals((short) MIN_VALUE, actual);
	}

	@Test
	public void readUInt16_MaxValue_Succeeds() throws Exception {
		final short actual = this.getReader(MAX_BINARY).readUInt16(null);
		assertEquals((short) MAX_VALUE, actual);
	}

	@Test
	public void readUInt16_SmallValue_Succeeds() throws Exception {
		final short actual = this.getReader(SMALL_BINARY).readUInt16(null);
		assertEquals((short) SMALL_VALUE, actual);
	}

	@Test
	public void readUInt16_LargeValue_Succeeds() throws Exception {
		final short actual = this.getReader(LARGE_BINARY).readUInt16(null);
		assertEquals((short) LARGE_VALUE, actual);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readUInt16_OversizeValue_Throws() throws Exception {
		this.getReader(OVERSIZE_BINARY).readUInt16(null);
	}
}
