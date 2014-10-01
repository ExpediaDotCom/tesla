/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * Int32Fixture.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

import static com.expedia.tesla.serialization.binary.BaseFixture.concat;

import java.util.Arrays;
import java.util.List;

/**
 * Test fixture values for Int32 tests.
 * 
 * @author dheld
 */
public interface Int32Fixture {
	static final int MIN_VALUE = Integer.MIN_VALUE;
	static final byte[] MIN_BINARY = { -1, -1, -1, -1, 15 };
	static final String MIN_JSON = "-2147483648";
	static final int MAX_VALUE = Integer.MAX_VALUE;
	static final byte[] MAX_BINARY = { -2, -1, -1, -1, 15 };
	static final String MAX_JSON = "2147483647";
	static final int NEGATIVE_VALUE = -4253;
	static final byte[] NEGATIVE_BINARY = { -71, 66 };
	static final String NEGATIVE_JSON = "-4253";
	static final int POSITIVE_VALUE = 77788899;
	static final byte[] POSITIVE_BINARY = { -58, -37, -105, 74 };
	static final String POSITIVE_JSON = "77788899";
	static final byte[] OVERSIZE_BINARY = { -110, -120, -32, -64, 92 };
	static final List<Integer> ARRAY_VALUES = Arrays.asList(MIN_VALUE,
			MAX_VALUE, NEGATIVE_VALUE, POSITIVE_VALUE);
	static final byte[] ARRAY_BINARY = concat((byte) ARRAY_VALUES.size(),
			MIN_BINARY, MAX_BINARY, NEGATIVE_BINARY, POSITIVE_BINARY);
	static final String ARRAY_JSON = '[' + MIN_JSON + ',' + MAX_JSON + ','
			+ NEGATIVE_JSON + ',' + POSITIVE_JSON + ']';
}
