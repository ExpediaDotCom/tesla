/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * Int64SerializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.Int64Fixture;

/**
 * Serialization Int64 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class Int64SerializationTest extends BaseFixture implements Int64Fixture {
	@Test(expected = java.io.IOException.class)
	public void writeInt64_StreamIOException_Throws() throws Exception {
		this.getThrowWriter().writeInt64(null, NEGATIVE_VALUE);
	}

	@Test
	public void writeInt64_MinValue_Succeeds() throws Exception {
		this.getWriter().writeInt64(null, MIN_VALUE);
		assertArrayEquals(MIN_BINARY, this.getOutput());
	}

	@Test
	public void writeInt64_MaxValue_Succeeds() throws Exception {
		this.getWriter().writeInt64(null, MAX_VALUE);
		assertArrayEquals(MAX_BINARY, this.getOutput());
	}

	@Test
	public void writeInt64_NegativeValue_Succeeds() throws Exception {
		this.getWriter().writeInt64(null, NEGATIVE_VALUE);
		assertArrayEquals(NEGATIVE_BINARY, this.getOutput());
	}

	@Test
	public void writeInt64_PositiveValue_Succeeds() throws Exception {
		this.getWriter().writeInt64(null, POSITIVE_VALUE);
		assertArrayEquals(POSITIVE_BINARY, this.getOutput());
	}

}
