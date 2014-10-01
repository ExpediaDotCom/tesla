/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * BinaryDoubleRoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import com.expedia.tesla.serialization.DoubleRoundTripTemplate;
import com.expedia.tesla.serialization.RoundTripFactory;

/**
 * Round-trip Double tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class DoubleRoundTripTest extends DoubleRoundTripTemplate {
	public DoubleRoundTripTest() {
		super(new RoundTripFactory());
	}
}
