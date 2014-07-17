/*******************************************************************************
 * Copyright (c) 2012, Expedia, Inc.
 *
 * TeslaDeserializationException.java
 *
 * Tesla Deserialization Exception.
 ******************************************************************************/

package com.expedia.tesla.serialization;

import com.expedia.tesla.TeslaException;

public class TeslaDeserializationException extends TeslaException {
	private static final long serialVersionUID = 8460203303982149351L;

	public TeslaDeserializationException(String message) {
		super(message);
	}

	public TeslaDeserializationException(String message, Throwable cause) {
		super(message, cause);
	}
}
