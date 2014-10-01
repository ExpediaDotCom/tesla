/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * FloatFixture.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

import static com.expedia.tesla.serialization.binary.BaseFixture.concat;

import java.util.Arrays;
import java.util.List;

/**
 * Test fixture values for Float tests.
 * 
 * @author dheld
 */
public interface FloatFixture {
	static final float EPSILON = 0.0000001f;
	static final float NEGATIVE_VALUE = -89171.120f;
	static final byte[] NEGATIVE_BINARY = { -113, 41, -82, -57 };
	static final String NEGATIVE_JSON = "-89171.12";
	static final float POSITIVE_VALUE = 1.783421e31f;
	static final byte[] POSITIVE_BINARY = { 113, 25, 97, 115 };
	static final String POSITIVE_JSON = "1.783421E31";
	static final float TINY_VALUE = Float.MIN_VALUE;
	static final byte[] TINY_BINARY = { 1, 0, 0, 0 };
	static final String TINY_JSON = "1.4E-45";
	static final float MIN_VALUE = -1 * Float.MAX_VALUE;
	static final byte[] MIN_BINARY = { -1, -1, 127, -1 };
	static final String MIN_JSON = "-3.4028235E38";
	static final float MAX_VALUE = Float.MAX_VALUE;
	static final byte[] MAX_BINARY = { -1, -1, 127, 127 };
	static final String MAX_JSON = "3.4028235E38";
	static final float NEG_INF_VALUE = Float.NEGATIVE_INFINITY;
	static final byte[] NEG_INF_BINARY = { 0, 0, -128, -1 };
	static final String NEG_INF_JSON = "\"-Infinity\"";
	static final float POS_INF_VALUE = Float.POSITIVE_INFINITY;
	static final byte[] POS_INF_BINARY = { 0, 0, -128, 127 };
	static final String POS_INF_JSON = "\"Infinity\"";
	static final float NAN_VALUE = Float.NaN;
	static final byte[] NAN_BINARY = { 0, 0, -64, 127 };
	static final String NAN_JSON = "\"NaN\"";
	static final List<Float> ARRAY_VALUES = Arrays.asList(NEGATIVE_VALUE,
			POSITIVE_VALUE, TINY_VALUE, MIN_VALUE, MAX_VALUE, NEG_INF_VALUE,
			POS_INF_VALUE, NAN_VALUE);
	static final byte[] ARRAY_BINARY = concat((byte) ARRAY_VALUES.size(),
			NEGATIVE_BINARY, POSITIVE_BINARY, TINY_BINARY, MIN_BINARY,
			MAX_BINARY, NEG_INF_BINARY, POS_INF_BINARY, NAN_BINARY);
	static final String ARRAY_JSON = '[' + NEGATIVE_JSON + ',' + POSITIVE_JSON
			+ ',' + TINY_JSON + ',' + MIN_JSON + ',' + MAX_JSON + ','
			+ NEG_INF_JSON + ',' + POS_INF_JSON + ',' + NAN_JSON + ']';
}
