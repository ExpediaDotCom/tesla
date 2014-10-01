/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * StringFixture.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

/**
 * Test fixture values for String tests.
 * 
 * Although javac should be able to decode this source file as UTF-8, there was
 * inconsistency in behavior between Eclipse and ant when running the unit
 * tests, so I have defined all of the non-ASCII literals using Unicode escapes.
 * 
 * @author dheld
 */
public interface StringFixture {
	static final String NULL_VALUE = null;
	static final String EMPTY_VALUE = "";
	static final byte[] EMPTY_BINARY = { (byte) EMPTY_VALUE.length() };
	static final String EMPTY_JSON = '"' + EMPTY_VALUE + '"';
	static final String ASCII_VALUE = "$ASCII";
	static final byte[] ASCII_BINARY = { (byte) ASCII_VALUE.length(), 36, 65,
			83, 67, 73, 73 };
	static final String LATIN1_VALUE = "2\u00A2"; // UTF-8: "2¢"
	static final byte[] LATIN1_BINARY = { 3, 50, -62, -94 };
	static final String SYMBOL_VALUE = "\u20ACzone"; // UTF-8: "€zone"
	static final byte[] SYMBOL_BINARY = { 7, -30, -126, -84, 122, 111, 110, 101 };
	static final String CJK_VALUE = "\uD852\uDF62\uD852\uDF62"; // UTF-8:
																// "𤭢𤭢"
	static final byte[] CJK_BINARY = { 8, -16, -92, -83, -94, -16, -92, -83,
			-94 };
	static final byte[] UNDERSIZE_BINARY = { -27, -38, -56, 40 };
	static final byte[] OVERSIZE_BINARY = { -46, -60, -91, -88, -27, -60, 3 };
	static final byte[] SHORT_BINARY = { 3, 0 };
}
