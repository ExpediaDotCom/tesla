/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * UInt64SerializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.UInt64Fixture;

/**
 * Serialization UInt64 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class UInt64SerializationTest extends BaseFixture implements
		UInt64Fixture {
	@Test(expected = java.io.IOException.class)
	public void writeUInt64_StreamIOException_Throws() throws Exception {
		this.getThrowWriter().writeUInt64(null, SMALL_VALUE.longValue());
	}

	@Test
	public void writeUInt64_MinValue_Succeeds() throws Exception {
		this.getWriter().writeUInt64(null, MIN_VALUE.longValue());
		assertArrayEquals(MIN_BINARY, this.getOutput());
	}

	@Test
	public void writeUInt64_MaxValue_Succeeds() throws Exception {
		this.getWriter().writeUInt64(null, MAX_VALUE.longValue());
		assertArrayEquals(MAX_BINARY, this.getOutput());
	}

	@Test
	public void writeUInt64_SmallValue_Succeeds() throws Exception {
		this.getWriter().writeUInt64(null, SMALL_VALUE.longValue());
		assertArrayEquals(SMALL_BINARY, this.getOutput());
	}

	@Test
	public void writeUInt64_LargeValue_Succeeds() throws Exception {
		this.getWriter().writeUInt64(null, LARGE_VALUE.longValue());
		assertArrayEquals(LARGE_BINARY, this.getOutput());
	}

}
