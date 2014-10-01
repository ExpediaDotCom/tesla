/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * BinarySerializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.BinaryFixture;

/**
 * Serialization Binary tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class BinarySerializationTest extends BaseFixture implements
		BinaryFixture {
	@Test(expected = java.io.IOException.class)
	public void writeBinary_StreamIOException_Throws() throws Exception {
		this.getThrowWriter().writeBinary(null, SMALL_VALUE);
	}

	@Test
	public void writeBinary_EmptyValueNonnullable_Succeeds() throws Exception {
		this.getWriter().writeBinary(null, EMPTY_VALUE);
		assertArrayEquals(EMPTY_BINARY, this.getOutput());
	}

	@Test
	public void writeBinary_SmallValueNonnullable_Succeeds() throws Exception {
		this.getWriter().writeBinary(null, SMALL_VALUE);
		assertArrayEquals(SMALL_BINARY, this.getOutput());
	}

	@Test
	public void writeBinary_LargeValueNonnullable_Succeeds() throws Exception {
		this.getWriter().writeBinary(null, LARGE_VALUE);
		assertArrayEquals(LARGE_BINARY, this.getOutput());
	}
}
