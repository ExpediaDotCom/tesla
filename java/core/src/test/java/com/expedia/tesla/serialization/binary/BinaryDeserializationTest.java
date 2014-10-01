/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * BinaryDeserializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.BinaryFixture;
import com.expedia.tesla.serialization.TeslaDeserializationException;

/**
 * Deserialization Binary tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class BinaryDeserializationTest extends BaseFixture implements
		BinaryFixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readBinary_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readBinary(null);
	}

	@Test
	public void readBinary_EmptyValueNonnullable_Succeeds() throws Exception {
		final byte[] actual = this.getReader(EMPTY_BINARY).readBinary(null);
		assertArrayEquals(EMPTY_VALUE, actual);
	}

	@Test
	public void readBinary_SmallValueNonnullable_Succeeds() throws Exception {
		final byte[] actual = this.getReader(SMALL_BINARY).readBinary(null);
		assertArrayEquals(SMALL_VALUE, actual);
	}

	@Test
	public void readBinary_LargeValueNonnullable_Succeeds() throws Exception {
		final byte[] actual = this.getReader(LARGE_BINARY).readBinary(null);
		assertArrayEquals(LARGE_VALUE, actual);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readBinary_UndersizeValueNonnullable_Throws() throws Exception {
		this.getReader(UNDERSIZE_BINARY).readBinary(null);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readBinary_OversizeValueNonnullable_Throws() throws Exception {
		this.getReader(OVERSIZE_BINARY).readBinary(null);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readBinary_ShortValueNonnullable_Throws() throws Exception {
		this.getReader(SHORT_BINARY).readBinary(null);
	}
}
