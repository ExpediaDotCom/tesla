/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * BinaryInt32RoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import com.expedia.tesla.serialization.EnumRoundTripTemplate;
import com.expedia.tesla.serialization.RoundTripFactory;

/**
 * Round-trip enum tests for the Tesla Binary format.
 * 
 * @author yzuo
 */
public class EnumRoundTripTest extends EnumRoundTripTemplate {
	public EnumRoundTripTest() {
		super(new RoundTripFactory());
	}
}
