/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * UnsignedTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

import com.expedia.tesla.utils.Unsigned;

/**
 * Unsigned util class unit tests.
 * 
 * @author yzuo
 */
public class UnsignedTest {
	@Test
	public void toUByte_max() {
		assertEquals(0xFF, Unsigned.toUByte((byte) -1));
	}

	@Test
	public void toUInt16_max() {
		assertEquals(0xFFFF, Unsigned.toUInt16((short) -1));
	}

	@Test
	public void toUInt32_max() {
		assertEquals(0xFFFFFFFFL, Unsigned.toUInt32(-1));
	}

	@Test
	public void toUInt64_max() {
		assertEquals(new BigInteger("FFFFFFFFFFFFFFFF", 16),
				Unsigned.toUInt64(-1));
	}
}
