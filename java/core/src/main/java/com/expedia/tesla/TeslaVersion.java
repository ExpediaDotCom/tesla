/**
 *
 * TeslaVersion.java
 *
 * Copyright 2013 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.tesla;

import java.util.HashMap;
import java.util.Map;

/**
 * This class defines the version of Tesla library itself.
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 */
public enum TeslaVersion {
	V1(1), V2(2);

	private int value;
	private static final Map<Integer, TeslaVersion> intToTypeMap = new HashMap<Integer, TeslaVersion>();

	static {
		for (TeslaVersion type : TeslaVersion.values()) {
			intToTypeMap.put(type.value, type);
		}
	}

	private TeslaVersion(int value) {
		this.value = value;
	}

	/**
	 * Convert enum to integer value
	 * 
	 * @return integer value
	 */
	public int toInteger() {
		return this.value;
	}

	/**
	 * Convert integer value to enum
	 * 
	 * @param i
	 *            integer value
	 * @return enum value
	 * @throws TeslaException
	 */
	public static TeslaVersion fromInteger(int i) throws TeslaException {
		TeslaVersion type = intToTypeMap.get(Integer.valueOf(i));
		if (type == null) {
			throw new TeslaException("Invalid TeslaVersion: " + i);
		}
		return type;
	}
}
