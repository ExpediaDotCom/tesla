/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * BinaryBooleanRoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import com.expedia.tesla.serialization.BooleanRoundTripTemplate;
import com.expedia.tesla.serialization.RoundTripFactory;

/**
 * Round-trip Boolean tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class BooleanRoundTripTest extends BooleanRoundTripTemplate {
	public BooleanRoundTripTest() {
		super(new RoundTripFactory());
	}
}
