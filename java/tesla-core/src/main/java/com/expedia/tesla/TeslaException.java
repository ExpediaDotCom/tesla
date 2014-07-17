/**
 *
 * TeslaException.java
 *
 * Copyright 2013 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.tesla;

/**
 * Base exception class for all Tesla exceptions.
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 */
public class TeslaException extends Exception {
	private static final long serialVersionUID = -4537665339867523229L;

	public TeslaException(String message) {
		super(message);
	}

	public TeslaException(String message, Throwable e) {
		super(message, e);
	}
}
