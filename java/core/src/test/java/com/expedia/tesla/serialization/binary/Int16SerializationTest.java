/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * Int16SerializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.Int16Fixture;

/**
 * Serialization Int16 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class Int16SerializationTest extends BaseFixture implements Int16Fixture {
	@Test(expected = java.io.IOException.class)
	public void writeInt16_StreamIOException_Throws() throws Exception {
		this.getThrowWriter().writeInt16(null, NEGATIVE_VALUE);
	}

	@Test
	public void writeInt16_MinValue_Succeeds() throws Exception {
		this.getWriter().writeInt16(null, MIN_VALUE);
		assertArrayEquals(MIN_BINARY, this.getOutput());
	}

	@Test
	public void writeInt16_MaxValue_Succeeds() throws Exception {
		this.getWriter().writeInt16(null, MAX_VALUE);
		assertArrayEquals(MAX_BINARY, this.getOutput());
	}

	@Test
	public void writeInt16_NegativeValue_Succeeds() throws Exception {
		this.getWriter().writeInt16(null, NEGATIVE_VALUE);
		assertArrayEquals(NEGATIVE_BINARY, this.getOutput());
	}

	@Test
	public void writeInt16_PositiveValue_Succeeds() throws Exception {
		this.getWriter().writeInt16(null, POSITIVE_VALUE);
		assertArrayEquals(POSITIVE_BINARY, this.getOutput());
	}
}
