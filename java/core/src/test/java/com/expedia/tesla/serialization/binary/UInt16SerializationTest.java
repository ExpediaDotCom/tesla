/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * UInt16SerializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.UInt16Fixture;

/**
 * Serialization UInt16 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class UInt16SerializationTest extends BaseFixture implements
		UInt16Fixture {
	@Test(expected = java.io.IOException.class)
	public void writeUInt16_StreamIOException_Throws() throws Exception {
		this.getThrowWriter().writeUInt16(null, (short) SMALL_VALUE);
	}

	@Test
	public void writeUInt16_MinValue_Succeeds() throws Exception {
		this.getWriter().writeUInt16(null, (short) MIN_VALUE);
		assertArrayEquals(MIN_BINARY, this.getOutput());
	}

	@Test
	public void writeUInt16_MaxValue_Succeeds() throws Exception {
		this.getWriter().writeUInt16(null, (short) MAX_VALUE);
		assertArrayEquals(MAX_BINARY, this.getOutput());
	}

	@Test
	public void writeUInt16_SmallValue_Succeeds() throws Exception {
		this.getWriter().writeUInt16(null, (short) SMALL_VALUE);
		assertArrayEquals(SMALL_BINARY, this.getOutput());
	}

	@Test
	public void writeUInt16_LargeValue_Succeeds() throws Exception {
		this.getWriter().writeUInt16(null, (short) LARGE_VALUE);
		assertArrayEquals(LARGE_BINARY, this.getOutput());
	}
}
