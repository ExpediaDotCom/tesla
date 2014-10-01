/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * BinaryByteRoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import com.expedia.tesla.serialization.ByteRoundTripTemplate;
import com.expedia.tesla.serialization.RoundTripFactory;

/**
 * Round-trip Byte tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class ByteRoundTripTest extends ByteRoundTripTemplate {
	public ByteRoundTripTest() {
		super(new RoundTripFactory());
	}
}
