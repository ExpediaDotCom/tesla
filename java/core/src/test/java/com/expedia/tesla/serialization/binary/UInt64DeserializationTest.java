/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * UInt64DeserializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.TeslaDeserializationException;
import com.expedia.tesla.serialization.UInt64Fixture;

/**
 * Deserialization UInt64 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class UInt64DeserializationTest extends BaseFixture implements
		UInt64Fixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readUInt64_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readUInt64(null);
	}

	@Test
	public void readUInt64_MinValue_Succeeds() throws Exception {
		final long actual = this.getReader(MIN_BINARY).readUInt64(null);
		assertEquals(MIN_VALUE.longValue(), actual);
	}

	@Test
	public void readUInt64_MaxValue_Succeeds() throws Exception {
		final long actual = this.getReader(MAX_BINARY).readUInt64(null);
		assertEquals(MAX_VALUE.longValue(), actual);
	}

	@Test
	public void readUInt64_SmallValue_Succeeds() throws Exception {
		final long actual = this.getReader(SMALL_BINARY).readUInt64(null);
		assertEquals(SMALL_VALUE.longValue(), actual);
	}

	@Test
	public void readUInt64_LargeValue_Succeeds() throws Exception {
		final long actual = this.getReader(LARGE_BINARY).readUInt64(null);
		assertEquals(LARGE_VALUE.longValue(), actual);
	}

}
