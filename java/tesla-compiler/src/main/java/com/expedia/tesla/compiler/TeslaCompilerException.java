/**
 *
 * TeslaCompilerException.java
 *
 * Copyright 2013 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.tesla.compiler;

import com.expedia.tesla.TeslaException;

/**
 * Tesla compiler exception.
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 */
public class TeslaCompilerException extends TeslaException {
	private static final long serialVersionUID = 8816193306223321191L;

	public TeslaCompilerException(String message) {
		super(message);
	}

	public TeslaCompilerException(String message, Throwable e) {
		super(message, e);
	}

}
