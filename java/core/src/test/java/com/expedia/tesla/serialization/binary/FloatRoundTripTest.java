/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * BinaryFloatRoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import com.expedia.tesla.serialization.FloatRoundTripTemplate;
import com.expedia.tesla.serialization.RoundTripFactory;

/**
 * Round-trip Float tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class FloatRoundTripTest extends FloatRoundTripTemplate {
	public FloatRoundTripTest() {
		super(new RoundTripFactory());
	}
}
