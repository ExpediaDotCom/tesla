/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * UInt32SerializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.UInt32Fixture;

/**
 * Serialization UInt32 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class UInt32SerializationTest extends BaseFixture implements
		UInt32Fixture {
	@Test(expected = java.io.IOException.class)
	public void writeUInt32_StreamIOException_Throws() throws Exception {
		this.getThrowWriter().writeUInt32(null, (int) SMALL_VALUE);
	}

	@Test
	public void writeUInt32_MinValue_Succeeds() throws Exception {
		this.getWriter().writeUInt32(null, (int) MIN_VALUE);
		assertArrayEquals(MIN_BINARY, this.getOutput());
	}

	@Test
	public void writeUInt32_MaxValue_Succeeds() throws Exception {
		this.getWriter().writeUInt32(null, (int) MAX_VALUE);
		assertArrayEquals(MAX_BINARY, this.getOutput());
	}

	@Test
	public void writeUInt32_SmallValue_Succeeds() throws Exception {
		this.getWriter().writeUInt32(null, (int) SMALL_VALUE);
		assertArrayEquals(SMALL_BINARY, this.getOutput());
	}

	@Test
	public void writeUInt32_LargeValue_Succeeds() throws Exception {
		this.getWriter().writeUInt32(null, (int) LARGE_VALUE);
		assertArrayEquals(LARGE_BINARY, this.getOutput());
	}

}
