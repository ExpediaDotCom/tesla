/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * BitConverterTest.java
 ******************************************************************************/

package com.expedia.tesla.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 * 
 */
public class BitConverterTest {
	@Test
	public void testGetBytesLong() {
		assertArrayEquals(new byte[] { (byte) 0x90, 0x78, 0x45, 0x23, 0x01,
				(byte) 0xEF, (byte) 0xCD, (byte) 0xAB },
				BitConverter.getBytes(0xABCDEF0123457890L));
	}

	@Test
	public void testToInt64() {
		assertEquals(
				0xABCDEF0123457890L,
				BitConverter.toInt64(new byte[] { (byte) 0x90, 0x78, 0x45,
						0x23, 0x01, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB }, 0));
	}
}
