/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * BooleanSerializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.BooleanFixture;

/**
 * Serialization Boolean tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class BooleanSerializationTest extends BaseFixture implements
		BooleanFixture {
	@Test(expected = java.io.IOException.class)
	public void writeBoolean_StreamIOException_Throws() throws Exception {
		this.getThrowWriter().writeBoolean(null, true);
	}

	@Test
	public void writeBoolean_False_Succeeds() throws Exception {
		this.getWriter().writeBoolean(null, FALSE_VALUE);
		assertArrayEquals(FALSE_BINARY, this.getOutput());
	}

	@Test
	public void writeBoolean_True_Succeeds() throws Exception {
		this.getWriter().writeBoolean(null, TRUE_VALUE);
		assertArrayEquals(TRUE_BINARY, this.getOutput());
	}
}
