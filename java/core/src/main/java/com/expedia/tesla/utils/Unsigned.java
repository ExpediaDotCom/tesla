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

package com.expedia.tesla.utils;

import java.math.BigInteger;

public final class Unsigned {
	public static final int MAX_BYTE = Byte.MAX_VALUE * 2 + 1;
	public static final int MAX_UINT16 = Short.MAX_VALUE * 2 + 1;
	public static final long MAX_UINT32 = Integer.MAX_VALUE * 2L + 1;
	public static final BigInteger MAX_UINT64 = BigInteger
			.valueOf(Long.MAX_VALUE).multiply(BigInteger.valueOf(2))
			.add(BigInteger.ONE);

	public static void validateByte(int value) {
		if (value < 0 || Unsigned.MAX_BYTE < value) {
			throw new IllegalArgumentException("value");
		}
	}

	public static boolean isInvalidUInt16(long value) {
		return value < 0 || Unsigned.MAX_UINT16 < value;
	}

	public static void validateUInt16(int value) {
		if (isInvalidUInt16(value)) {
			throw new IllegalArgumentException("value");
		}
	}

	public static boolean isInvalidUInt32(long value) {
		return value < 0 || Unsigned.MAX_UINT32 < value;
	}

	public static void validateUInt32(long value) {
		if (isInvalidUInt32(value)) {
			throw new IllegalArgumentException("value");
		}
	}

	public static boolean isInvalidUInt64(BigInteger value) {
		return value.signum() == -1
				|| value.compareTo(Unsigned.MAX_UINT64) == 1;
	}

	public static void validateUInt64(BigInteger value) {
		if (isInvalidUInt64(value)) {
			throw new IllegalArgumentException("value");
		}
	}

	public static int toUByte(byte value) {
		return value & 0xFF;
	}

	public static int toUInt16(short value) {
		return value & 0xFFFF;
	}

	public static long toUInt32(int value) {
		return value & 0xFFFFFFFFL;
	}

	public static BigInteger toUInt64(long value) {
		long lower63 = value & 0x7FFFFFFFFFFFFFFFL;
		assert (lower63 >= 0);
		BigInteger v = BigInteger.valueOf(lower63);
		if ((value & 0x8000000000000000L) != 0L) {
			return v.flipBit(63);
		}
		return v;
	}
}
