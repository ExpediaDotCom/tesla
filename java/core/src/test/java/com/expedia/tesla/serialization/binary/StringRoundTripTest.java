/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * BinaryStringRoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import com.expedia.tesla.serialization.RoundTripFactory;
import com.expedia.tesla.serialization.StringRoundTripTemplate;

/**
 * Round-trip String tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class StringRoundTripTest extends StringRoundTripTemplate {
	public StringRoundTripTest() {
		super(new RoundTripFactory());
	}
}
