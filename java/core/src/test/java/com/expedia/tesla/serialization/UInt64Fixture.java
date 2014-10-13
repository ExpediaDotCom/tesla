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

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.expedia.tesla.utils.Unsigned;

/**
 * Test fixture values for UInt64 tests.
 * 
 * @author dheld
 */
public interface UInt64Fixture {
	static final BigInteger MIN_VALUE = BigInteger.ZERO;
	static final byte[] MIN_BINARY = { 0 };
	static final String MIN_JSON = "0";
	static final BigInteger MAX_VALUE = Unsigned.MAX_UINT64;
	static final byte[] MAX_BINARY = { -1, -1, -1, -1, -1, -1, -1, -1, -1, 1 };
	static final String MAX_JSON = "18446744073709551615";
	static final BigInteger SMALL_VALUE = BigInteger.valueOf(58585858);
	static final byte[] SMALL_BINARY = { -126, -26, -9, 27 };
	static final String SMALL_JSON = "58585858";
	static final BigInteger LARGE_VALUE = BigInteger.valueOf(3214342321L)
			.shiftLeft(32);
	static final byte[] LARGE_BINARY = { -128, -128, -128, -128, -112, -106,
			-66, -53, -65, 1 };
	static final String LARGE_JSON = "13805495146843734016";
	static final byte[] OVERSIZE_BINARY = { -110, -40, -80, -120, -1, -1, -1,
			-1, -1, 55 };
	static final List<Long> ARRAY_VALUES = Arrays.asList(MIN_VALUE.longValue(),
			MAX_VALUE.longValue(), SMALL_VALUE.longValue(),
			LARGE_VALUE.longValue());
	static final byte[] ARRAY_BINARY = concat((byte) ARRAY_VALUES.size(),
			MIN_BINARY, MAX_BINARY, SMALL_BINARY, LARGE_BINARY);
	static final String ARRAY_JSON = '[' + MIN_JSON + ',' + MAX_JSON + ','
			+ SMALL_JSON + ',' + LARGE_JSON + ']';
}
