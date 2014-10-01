/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * BinaryRoundTripFactory.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

import java.io.ByteArrayOutputStream;

import com.expedia.tesla.serialization.binary.BaseFixture;

/**
 * Round-trip factory for the Tesla Binary format.
 * 
 * @author dheld
 */
public class RoundTripFactory {
	private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();

	public TeslaWriter createWriter() {
		this.buffer.reset();
		return new BinaryWriter(buffer, BaseFixture.SCHEMA_VERSION);
	}

	public TeslaReader createReader() {
		return new BinaryReader(buffer.toByteArray(),
				BaseFixture.SCHEMA_VERSION);
	}
}
