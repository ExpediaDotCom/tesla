/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * StringSerializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.StringFixture;

/**
 * Serialization String tests for the Tesla String format.
 * 
 * @author dheld
 */
public class StringSerializationTest extends BaseFixture implements
		StringFixture {
	@Test(expected = java.io.IOException.class)
	public void writeString_StreamIOException_Throws() throws Exception {
		this.getThrowWriter().writeString(null, ASCII_VALUE);
	}

	@Test
	public void writeString_EmptyValue_Succeeds() throws Exception {
		this.getWriter().writeString(null, EMPTY_VALUE);
		assertArrayEquals(EMPTY_BINARY, this.getOutput());
	}

	@Test
	public void writeString_AsciiValue_Succeeds() throws Exception {
		this.getWriter().writeString(null, ASCII_VALUE);
		assertArrayEquals(ASCII_BINARY, this.getOutput());
	}

	@Test
	public void writeString_Latin1Value_Succeeds() throws Exception {
		this.getWriter().writeString(null, LATIN1_VALUE);
		assertArrayEquals(LATIN1_BINARY, this.getOutput());
	}

	@Test
	public void writeString_SymbolValue_Succeeds() throws Exception {
		this.getWriter().writeString(null, SYMBOL_VALUE);
		assertArrayEquals(SYMBOL_BINARY, this.getOutput());
	}

	@Test
	public void writeString_CjkValue_Succeeds() throws Exception {
		this.getWriter().writeString(null, CJK_VALUE);
		assertArrayEquals(CJK_BINARY, this.getOutput());
	}
}
