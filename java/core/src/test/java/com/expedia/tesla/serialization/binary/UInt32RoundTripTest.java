/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * BinaryUInt32RoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import com.expedia.tesla.serialization.RoundTripFactory;
import com.expedia.tesla.serialization.UInt32RoundTripTemplate;

/**
 * Round-trip UInt32 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class UInt32RoundTripTest extends UInt32RoundTripTemplate {
	public UInt32RoundTripTest() {
		super(new RoundTripFactory());
	}
}
