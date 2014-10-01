/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * Int64Fixture.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

import static com.expedia.tesla.serialization.binary.BaseFixture.concat;

import java.util.Arrays;
import java.util.List;

/**
 * Test fixture values for Int64 tests.
 * 
 * @author dheld
 */
public interface Int64Fixture {
	static final long MIN_VALUE = Long.MIN_VALUE;
	static final byte[] MIN_BINARY = { -1, -1, -1, -1, -1, -1, -1, -1, -1, 1 };
	static final String MIN_JSON = "-9223372036854775808";
	static final long MAX_VALUE = Long.MAX_VALUE;
	static final byte[] MAX_BINARY = { -2, -1, -1, -1, -1, -1, -1, -1, -1, 1 };
	static final String MAX_JSON = "9223372036854775807";
	static final long NEGATIVE_VALUE = -42538675L;
	static final byte[] NEGATIVE_BINARY = { -27, -38, -56, 40 };
	static final String NEGATIVE_JSON = "-42538675";
	static final long POSITIVE_VALUE = 7778899112233L;
	static final byte[] POSITIVE_BINARY = { -46, -60, -91, -88, -27, -60, 3 };
	static final String POSITIVE_JSON = "7778899112233";
	static final byte[] OVERSIZE_BINARY = { -110, -120, -32, -64, -48, -96,
			-24, -16, -40, 5 };
	static final List<Long> ARRAY_VALUES = Arrays.asList(MIN_VALUE, MAX_VALUE,
			NEGATIVE_VALUE, POSITIVE_VALUE);
	static final byte[] ARRAY_BINARY = concat((byte) ARRAY_VALUES.size(),
			MIN_BINARY, MAX_BINARY, NEGATIVE_BINARY, POSITIVE_BINARY);
	static final String ARRAY_JSON = '[' + MIN_JSON + ',' + MAX_JSON + ','
			+ NEGATIVE_JSON + ',' + POSITIVE_JSON + ']';
}
