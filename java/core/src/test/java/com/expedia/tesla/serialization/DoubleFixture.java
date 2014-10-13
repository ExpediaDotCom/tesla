/*******************************************************************************
 * Copyright (c) 2014 Expedia Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.expedia.tesla.serialization;

import static com.expedia.tesla.serialization.binary.BaseFixture.concat;

import java.util.Arrays;
import java.util.List;

/**
 * Test fixture values for Double tests.
 * 
 * @author dheld
 */
public interface DoubleFixture {
	static final double EPSILON = 0.00000000000001f;
	static final double NEGATIVE_VALUE = -89171.120f;
	static final byte[] NEGATIVE_BINARY = { 0, 0, 0, -32, 49, -59, -11, -64 };
	static final String NEGATIVE_JSON = "-89171.1171875";
	static final double POSITIVE_VALUE = 1.7834216952748e31f;
	static final byte[] POSITIVE_BINARY = { 0, 0, 0, -32, 46, 35, 108, 70 };
	static final String POSITIVE_JSON = "1.7834217553127544E31";
	static final double TINY_VALUE = Double.MIN_VALUE;
	static final byte[] TINY_BINARY = { 1, 0, 0, 0, 0, 0, 0, 0 };
	static final String TINY_JSON = "4.9E-324";
	static final double MIN_VALUE = -1 * Double.MAX_VALUE;
	static final byte[] MIN_BINARY = { -1, -1, -1, -1, -1, -1, -17, -1 };
	static final String MIN_JSON = "-1.7976931348623157E308";
	static final double MAX_VALUE = Double.MAX_VALUE;
	static final byte[] MAX_BINARY = { -1, -1, -1, -1, -1, -1, -17, 127 };
	static final String MAX_JSON = "1.7976931348623157E308";
	static final double NEG_INF_VALUE = Double.NEGATIVE_INFINITY;
	static final byte[] NEG_INF_BINARY = { 0, 0, 0, 0, 0, 0, -16, -1 };
	static final String NEG_INF_JSON = "\"-Infinity\"";
	static final double POS_INF_VALUE = Double.POSITIVE_INFINITY;
	static final byte[] POS_INF_BINARY = { 0, 0, 0, 0, 0, 0, -16, 127 };
	static final String POS_INF_JSON = "\"Infinity\"";
	static final double NAN_VALUE = Double.NaN;
	static final byte[] NAN_BINARY = { 0, 0, 0, 0, 0, 0, -8, 127 };
	static final String NAN_JSON = "\"NaN\"";
	static final List<Double> ARRAY_VALUES = Arrays.asList(NEGATIVE_VALUE,
			POSITIVE_VALUE, TINY_VALUE, MIN_VALUE, MAX_VALUE, NEG_INF_VALUE,
			POS_INF_VALUE, NAN_VALUE);
	static final byte[] ARRAY_BINARY = concat((byte) ARRAY_VALUES.size(),
			NEGATIVE_BINARY, POSITIVE_BINARY, TINY_BINARY, MIN_BINARY,
			MAX_BINARY, NEG_INF_BINARY, POS_INF_BINARY, NAN_BINARY);
	static final String ARRAY_JSON = '[' + NEGATIVE_JSON + ',' + POSITIVE_JSON
			+ ',' + TINY_JSON + ',' + MIN_JSON + ',' + MAX_JSON + ','
			+ NEG_INF_JSON + ',' + POS_INF_JSON + ',' + NAN_JSON + ']';
}
