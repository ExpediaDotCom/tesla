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

import java.util.Arrays;
import java.util.List;

/**
 * Test fixture values for Byte tests.
 * 
 * @author dheld
 */
public interface ByteFixture {
	static final int MIN_VALUE = 0x00;
	static final byte[] MIN_BINARY = { 0x00 };
	static final String MIN_JSON = "0";
	static final int MAX_VALUE = (byte) 0xFF;
	static final byte[] MAX_BINARY = { (byte) 0xFF };
	static final String MAX_JSON = "255";
	static final int SMALL_VALUE = 0x03;
	static final byte[] SMALL_BINARY = { 0x03 };
	static final String SMALL_JSON = "3";
	static final int LARGE_VALUE = (byte) 0xCC;
	static final byte[] LARGE_BINARY = { (byte) 0xCC };
	static final String LARGE_JSON = "204";
	static final List<Byte> ARRAY_VALUES = Arrays.asList((byte) MIN_VALUE,
			(byte) MAX_VALUE, (byte) SMALL_VALUE, (byte) LARGE_VALUE);
	static final byte[] ARRAY_BINARY = { (byte) ARRAY_VALUES.size(), MIN_VALUE,
			(byte) MAX_VALUE, SMALL_VALUE, (byte) LARGE_VALUE };
	static final String ARRAY_JSON = '[' + MIN_JSON + ',' + MAX_JSON + ','
			+ SMALL_JSON + ',' + LARGE_JSON + ']';
}
