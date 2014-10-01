/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * BaseRoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

/**
 * Convenience interface for round-trip test suites.
 * 
 * @author dheld
 */
public class BaseRoundTripTemplate {
	private final RoundTripFactory factory;

	protected TeslaWriter getWriter() {
		return factory.createWriter();
	}

	protected TeslaReader getReader() {
		return factory.createReader();
	}

	public BaseRoundTripTemplate(RoundTripFactory factory) {
		this.factory = factory;
	}
}
