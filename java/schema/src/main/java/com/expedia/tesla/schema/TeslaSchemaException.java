/**
 *
 * TeslaSchemaException.java
 *
 * Copyright 2013 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.tesla.schema;

import com.expedia.tesla.TeslaException;

/**
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 * 
 */
public class TeslaSchemaException extends TeslaException {

	/**
     * 
     */
	private static final long serialVersionUID = 2147201426650821223L;

	public TeslaSchemaException(String message) {
		super(message);
	}

	public TeslaSchemaException(String message, Throwable e) {
		super(message, e);
	}

}
