/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * Int32DeserializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.EnumFixture;
import com.expedia.tesla.serialization.TeslaDeserializationException;

/**
 * Deserialization enum tests for the Tesla Binary format.
 * 
 * @author yzuo
 */
public class EnumDeserializationTest extends BaseFixture implements EnumFixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readEnum_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readEnum(null, Int.MAPPER);
	}

	@Test
	public void readEnum_Max_Succeeds() throws Exception {
		final Int actual = this.getReader(MAX_BINARY)
				.readEnum(null, Int.MAPPER);
		assertEquals(Int.Max, actual);
	}

	@Test
	public void readEnum_Min_Succeeds() throws Exception {
		final Int actual = this.getReader(MIN_BINARY)
				.readEnum(null, Int.MAPPER);
		assertEquals(Int.Min, actual);
	}

	@Test
	public void readEnum_Positive_Succeeds() throws Exception {
		final Int actual = this.getReader(POSITIVE_BINARY).readEnum(null,
				Int.MAPPER);
		assertEquals(Int.Positive, actual);
	}

	@Test
	public void readEnum_Negative_Succeeds() throws Exception {
		final Int actual = this.getReader(NEGATIVE_BINARY).readEnum(null,
				Int.MAPPER);
		assertEquals(Int.Negative, actual);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readInt32_OversizeValue_Throws() throws Exception {
		this.getReader(OVERSIZE_BINARY).readEnum(null, Int.MAPPER);
	}

}
