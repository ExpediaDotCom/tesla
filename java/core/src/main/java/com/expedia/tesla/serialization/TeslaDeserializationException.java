/*******************************************************************************
 * Copyright (c) 2012, Expedia, Inc.
 *
 * TeslaDeserializationException.java
 *
 * Tesla Deserialization Exception.
 ******************************************************************************/

package com.expedia.tesla.serialization;

import java.io.IOException;

public class TeslaDeserializationException extends IOException {
	private static final long serialVersionUID = 8460203303982149351L;

	public TeslaDeserializationException(String message) {
		super(message);
	}

	public TeslaDeserializationException(String message, Throwable cause) {
		super(message, cause);
	}
}
