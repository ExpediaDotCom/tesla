/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * ByteDeserializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.ByteFixture;
import com.expedia.tesla.serialization.TeslaDeserializationException;

/**
 * Deserialization Byte tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class ByteDeserializationTest extends BaseFixture implements ByteFixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readByte_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readByte(null);
	}

	@Test
	public void readByte_MinValue_Succeeds() throws Exception {
		final byte actual = this.getReader(MIN_BINARY).readByte(null);
		assertEquals((byte) MIN_VALUE, actual);
	}

	@Test
	public void readByte_MaxValue_Succeeds() throws Exception {
		final int actual = this.getReader(MAX_BINARY).readByte(null);
		assertEquals((byte) MAX_VALUE, actual);
	}

	@Test
	public void readByte_SmallValue_Succeeds() throws Exception {
		final int actual = this.getReader(SMALL_BINARY).readByte(null);
		assertEquals((byte) SMALL_VALUE, actual);
	}

	@Test
	public void readByte_LargeValue_Succeeds() throws Exception {
		final int actual = this.getReader(LARGE_BINARY).readByte(null);
		assertEquals((byte) LARGE_VALUE, actual);
	}
}
