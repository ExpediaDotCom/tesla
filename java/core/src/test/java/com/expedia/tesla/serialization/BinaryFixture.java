/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * BinaryFixture.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

import static com.expedia.tesla.serialization.binary.BaseFixture.concat;

/**
 * Test fixture values for Binary tests.
 * 
 * @author dheld
 */
public interface BinaryFixture {
	static final byte[] NULL_VALUE = null;
	static final byte[] EMPTY_VALUE = {};
	static final byte[] EMPTY_BINARY = { (byte) EMPTY_VALUE.length };
	static final byte[] SMALL_VALUE = { 3, 42, -5 };
	static final byte[] SMALL_BINARY = concat((byte) SMALL_VALUE.length,
			SMALL_VALUE);
	static final byte[] LARGE_VALUE = { -16, -15, -14, -13, -12, -11, -10, -9,
			-8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
			11, 12, 13, 14, 15, 16 };
	static final byte[] LARGE_BINARY = concat((byte) LARGE_VALUE.length,
			LARGE_VALUE);
	static final byte[] UNDERSIZE_BINARY = { -27, -38, -56, 40 };
	static final byte[] OVERSIZE_BINARY = { -46, -60, -91, -88, -27, -60, 3 };
	static final byte[] SHORT_BINARY = { 3, 0 };
}
