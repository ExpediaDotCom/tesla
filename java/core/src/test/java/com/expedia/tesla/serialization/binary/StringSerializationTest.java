/*******************************************************************************
 * Copyright (c) 2014 Expedia Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.StringFixture;

/**
 * Serialization String tests for the Tesla String format.
 * 
 * @author dheld
 */
public class StringSerializationTest extends BaseFixture implements
		StringFixture {
	@Test(expected = java.io.IOException.class)
	public void writeString_StreamIOException_Throws() throws Exception {
		this.getThrowWriter().writeString(null, ASCII_VALUE);
	}

	@Test
	public void writeString_EmptyValue_Succeeds() throws Exception {
		this.getWriter().writeString(null, EMPTY_VALUE);
		assertArrayEquals(EMPTY_BINARY, this.getOutput());
	}

	@Test
	public void writeString_AsciiValue_Succeeds() throws Exception {
		this.getWriter().writeString(null, ASCII_VALUE);
		assertArrayEquals(ASCII_BINARY, this.getOutput());
	}

	@Test
	public void writeString_Latin1Value_Succeeds() throws Exception {
		this.getWriter().writeString(null, LATIN1_VALUE);
		assertArrayEquals(LATIN1_BINARY, this.getOutput());
	}

	@Test
	public void writeString_SymbolValue_Succeeds() throws Exception {
		this.getWriter().writeString(null, SYMBOL_VALUE);
		assertArrayEquals(SYMBOL_BINARY, this.getOutput());
	}

	@Test
	public void writeString_CjkValue_Succeeds() throws Exception {
		this.getWriter().writeString(null, CJK_VALUE);
		assertArrayEquals(CJK_BINARY, this.getOutput());
	}
}
