/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * BinaryInt32RoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import com.expedia.tesla.serialization.Int32RoundTripTemplate;
import com.expedia.tesla.serialization.RoundTripFactory;

/**
 * Round-trip Int32 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class Int32RoundTripTest extends Int32RoundTripTemplate {
	public Int32RoundTripTest() {
		super(new RoundTripFactory());
	}
}
