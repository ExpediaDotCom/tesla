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

import static com.expedia.tesla.serialization.TeslaConstants.BOOLEAN_FALSE;
import static com.expedia.tesla.serialization.TeslaConstants.BOOLEAN_TRUE;

import java.util.Arrays;
import java.util.List;

/**
 * Test fixture values for Byte tests.
 * 
 * @author dheld
 */
public interface BooleanFixture {
	static final boolean FALSE_VALUE = false;
	static final byte[] FALSE_BINARY = { BOOLEAN_FALSE };
	static final String FALSE_JSON = "false";
	static final boolean TRUE_VALUE = true;
	static final byte[] TRUE_BINARY = { BOOLEAN_TRUE };
	static final String TRUE_JSON = "true";
	static final byte[] INVALID_BINARY = { 0x42 };
	static final List<Boolean> ARRAY_VALUES = Arrays.asList(true, false, false,
			true, false);
	static final byte[] ARRAY_BINARY = { (byte) ARRAY_VALUES.size(),
			BOOLEAN_TRUE, BOOLEAN_FALSE, BOOLEAN_FALSE, BOOLEAN_TRUE,
			BOOLEAN_FALSE };
	static final String ARRAY_JSON = '[' + TRUE_JSON + ',' + FALSE_JSON + ','
			+ FALSE_JSON + ',' + TRUE_JSON + ',' + FALSE_JSON + ']';
}
