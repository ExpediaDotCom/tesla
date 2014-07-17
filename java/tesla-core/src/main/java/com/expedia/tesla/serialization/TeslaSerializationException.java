/*******************************************************************************
 * Copyright (c) 2012, Expedia, Inc.
 *
 * TeslaSerializationException.java
 *
 * Tesla serialization exception.
 ******************************************************************************/

package com.expedia.tesla.serialization;

import com.expedia.tesla.TeslaException;

public class TeslaSerializationException extends TeslaException {
	private static final long serialVersionUID = 1602837571431292189L;

	public TeslaSerializationException(String message) {
		super(message);
	}

	public TeslaSerializationException(String message, Throwable cause) {
		super(message, cause);
	}
}
