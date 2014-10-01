/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * ByteFixture.java
 ******************************************************************************/
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
