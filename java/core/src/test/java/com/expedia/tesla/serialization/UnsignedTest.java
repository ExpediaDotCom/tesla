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
