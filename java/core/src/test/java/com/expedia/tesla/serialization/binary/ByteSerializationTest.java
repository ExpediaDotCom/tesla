/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * ByteSerializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.ByteFixture;

/**
 * Serialization Byte tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class ByteSerializationTest extends BaseFixture implements ByteFixture {
	@Test(expected = java.io.IOException.class)
	public void writeByte_StreamIOException_Throws() throws Exception {
		this.getThrowWriter().writeByte(null, (byte) SMALL_VALUE);
	}

	@Test
	public void writeByte_MinValue_Succeeds() throws Exception {
		this.getWriter().writeByte(null, (byte) MIN_VALUE);
		assertArrayEquals(MIN_BINARY, this.getOutput());
	}

	@Test
	public void writeByte_MaxValue_Succeeds() throws Exception {
		this.getWriter().writeByte(null, (byte) MAX_VALUE);
		assertArrayEquals(MAX_BINARY, this.getOutput());
	}

	@Test
	public void writeByte_SmallValue_Succeeds() throws Exception {
		this.getWriter().writeByte(null, (byte) SMALL_VALUE);
		assertArrayEquals(SMALL_BINARY, this.getOutput());
	}

	@Test
	public void writeByte_LargeValue_Succeeds() throws Exception {
		this.getWriter().writeByte(null, (byte) LARGE_VALUE);
		assertArrayEquals(LARGE_BINARY, this.getOutput());
	}
}
