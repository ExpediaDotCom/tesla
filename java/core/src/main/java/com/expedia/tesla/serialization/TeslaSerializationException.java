/*******************************************************************************
 * Copyright (c) 2012, Expedia, Inc.
 *
 * TeslaSerializationException.java
 *
 * Tesla serialization exception.
 ******************************************************************************/

package com.expedia.tesla.serialization;

import java.io.IOException;

public class TeslaSerializationException extends IOException {
	private static final long serialVersionUID = 1602837571431292189L;

	public TeslaSerializationException(String message) {
		super(message);
	}

	public TeslaSerializationException(String message, Throwable cause) {
		super(message, cause);
	}
}
