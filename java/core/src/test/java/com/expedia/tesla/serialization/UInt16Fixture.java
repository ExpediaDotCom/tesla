/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * UInt16Fixture.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

import static com.expedia.tesla.serialization.binary.BaseFixture.concat;

import java.util.Arrays;
import java.util.List;

import com.expedia.tesla.utils.Unsigned;

/**
 * Test fixture values for UInt16 tests.
 * 
 * @author dheld
 */
public interface UInt16Fixture {
	static final int MIN_VALUE = 0;
	static final byte[] MIN_BINARY = { 0 };
	static final String MIN_JSON = "0";
	static final int MAX_VALUE = Unsigned.MAX_UINT16;
	static final byte[] MAX_BINARY = { -1, -1, 3 };
	static final String MAX_JSON = "65535";
	static final int SMALL_VALUE = 36;
	static final byte[] SMALL_BINARY = { 36 };
	static final String SMALL_JSON = "36";
	static final int LARGE_VALUE = 42321;
	static final byte[] LARGE_BINARY = { -47, -54, 2 };
	static final String LARGE_JSON = "42321";
	static final byte[] OVERSIZE_BINARY = { -110, -40, 5 };
	static final List<Short> ARRAY_VALUES = Arrays.asList((short) MIN_VALUE,
			(short) MAX_VALUE, (short) SMALL_VALUE, (short) LARGE_VALUE);
	static final byte[] ARRAY_BINARY = concat((byte) ARRAY_VALUES.size(),
			MIN_BINARY, MAX_BINARY, SMALL_BINARY, LARGE_BINARY);
	static final String ARRAY_JSON = '[' + MIN_JSON + ',' + MAX_JSON + ','
			+ SMALL_JSON + ',' + LARGE_JSON + ']';
}
