/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * BinaryInt64RoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import com.expedia.tesla.serialization.Int64RoundTripTemplate;
import com.expedia.tesla.serialization.RoundTripFactory;

/**
 * Round-trip Int64 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class Int64RoundTripTest extends Int64RoundTripTemplate {
	public Int64RoundTripTest() {
		super(new RoundTripFactory());
	}
}
