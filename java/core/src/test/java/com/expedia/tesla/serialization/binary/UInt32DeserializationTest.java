/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * UInt32DeserializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.TeslaDeserializationException;
import com.expedia.tesla.serialization.UInt32Fixture;

/**
 * Deserialization UInt32 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class UInt32DeserializationTest extends BaseFixture implements
		UInt32Fixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readUInt32_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readUInt32(null);
	}

	@Test
	public void readUInt32_MinValue_Succeeds() throws Exception {
		final int actual = this.getReader(MIN_BINARY).readUInt32(null);
		assertEquals((int) MIN_VALUE, actual);
	}

	@Test
	public void readUInt32_MaxValue_Succeeds() throws Exception {
		final int actual = this.getReader(MAX_BINARY).readUInt32(null);
		assertEquals((int) MAX_VALUE, actual);
	}

	@Test
	public void readUInt32_SmallValue_Succeeds() throws Exception {
		final int actual = this.getReader(SMALL_BINARY).readUInt32(null);
		assertEquals((int) SMALL_VALUE, actual);
	}

	@Test
	public void readUInt32_LargeValue_Succeeds() throws Exception {
		final int actual = this.getReader(LARGE_BINARY).readUInt32(null);
		assertEquals((int) LARGE_VALUE, actual);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readUInt32_OversizeValue_Throws() throws Exception {
		this.getReader(OVERSIZE_BINARY).readUInt32(null);
	}
}
