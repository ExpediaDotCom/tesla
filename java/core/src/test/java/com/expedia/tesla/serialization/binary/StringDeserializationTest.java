/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * StringDeserializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.StringFixture;
import com.expedia.tesla.serialization.TeslaDeserializationException;

/**
 * Deserialization String tests for the Tesla String format.
 * 
 * @author dheld
 */
public class StringDeserializationTest extends BaseFixture implements
		StringFixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readString_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readString(null);
	}

	@Test
	public void readString_EmptyValueNonnullable_Succeeds() throws Exception {
		final String actual = this.getReader(EMPTY_BINARY).readString(null);
		assertEquals(EMPTY_VALUE, actual);
	}

	@Test
	public void readString_AsciiValueNonnullable_Succeeds() throws Exception {
		final String actual = this.getReader(ASCII_BINARY).readString(null);
		assertEquals(ASCII_VALUE, actual);
	}

	@Test
	public void readString_Latin1ValueNonnullable_Succeeds() throws Exception {
		final String actual = this.getReader(LATIN1_BINARY).readString(null);
		assertEquals(LATIN1_VALUE, actual);
	}

	@Test
	public void readString_SymbolValueNonnullable_Succeeds() throws Exception {
		final String actual = this.getReader(SYMBOL_BINARY).readString(null);
		assertEquals(SYMBOL_VALUE, actual);
	}

	@Test
	public void readString_CjkValueNonnullable_Succeeds() throws Exception {
		final String actual = this.getReader(CJK_BINARY).readString(null);
		assertEquals(CJK_VALUE, actual);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readString_UndersizeValueNonnullable_Throws() throws Exception {
		this.getReader(UNDERSIZE_BINARY).readString(null);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readString_OversizeValueNonnullable_Throws() throws Exception {
		this.getReader(OVERSIZE_BINARY).readString(null);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readString_ShortValueNonnullable_Throws() throws Exception {
		this.getReader(SHORT_BINARY).readString(null);
	}
}
