/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * BinaryBinaryRoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import com.expedia.tesla.serialization.BinaryRoundTripTemplate;
import com.expedia.tesla.serialization.RoundTripFactory;

/**
 * Round-trip Binary tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class BinaryRoundTripTest extends BinaryRoundTripTemplate {
	public BinaryRoundTripTest() {
		super(new RoundTripFactory());
	}
}
