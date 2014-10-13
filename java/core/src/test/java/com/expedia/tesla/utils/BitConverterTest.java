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
