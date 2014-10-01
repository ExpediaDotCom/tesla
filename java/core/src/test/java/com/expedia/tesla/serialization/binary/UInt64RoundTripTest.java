/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * BinaryUInt64RoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import com.expedia.tesla.serialization.RoundTripFactory;
import com.expedia.tesla.serialization.UInt64RoundTripTemplate;

/**
 * Round-trip UInt64 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class UInt64RoundTripTest extends UInt64RoundTripTemplate {
	public UInt64RoundTripTest() {
		super(new RoundTripFactory());
	}
}
