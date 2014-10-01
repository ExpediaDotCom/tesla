/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * BooleanDeserializationTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.BooleanFixture;
import com.expedia.tesla.serialization.TeslaDeserializationException;

/**
 * Deserialization Boolean tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class BooleanDeserializationTest extends BaseFixture implements
		BooleanFixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readBoolean_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readBoolean(null);
	}

	@Test
	public void readBoolean_False_Succeeds() throws Exception {
		final boolean actual = this.getReader(FALSE_BINARY).readBoolean(null);
		assertEquals(FALSE_VALUE, actual);
	}

	@Test
	public void readBoolean_True_Succeeds() throws Exception {
		final boolean actual = this.getReader(TRUE_BINARY).readBoolean(null);
		assertEquals(TRUE_VALUE, actual);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readBoolean_Invalid_Throws() throws Exception {
		this.getReader(INVALID_BINARY).readBoolean(null);
	}

}
