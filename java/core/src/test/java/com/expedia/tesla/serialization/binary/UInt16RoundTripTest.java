/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * BinaryUInt16RoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import com.expedia.tesla.serialization.RoundTripFactory;
import com.expedia.tesla.serialization.UInt16RoundTripTemplate;

/**
 * Round-trip UInt16 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class UInt16RoundTripTest extends UInt16RoundTripTemplate {
	public UInt16RoundTripTest() {
		super(new RoundTripFactory());
	}
}
