/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * BinaryInt16RoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import com.expedia.tesla.serialization.Int16RoundTripTemplate;
import com.expedia.tesla.serialization.RoundTripFactory;

/**
 * Round-trip Int16 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class Int16RoundTripTest extends Int16RoundTripTemplate {
	public Int16RoundTripTest() {
		super(new RoundTripFactory());
	}
}
