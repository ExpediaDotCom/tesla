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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.expedia.tesla.serialization.StringFixture;
import com.expedia.tesla.serialization.TeslaDeserializationException;

/**
 * Deserialization String tests for the Tesla String format.
 * 
 * @author dheld
 */
public class StringDeserializationTest extends BaseFixture implements
		StringFixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readString_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readString(null);
	}

	@Test
	public void readString_EmptyValueNonnullable_Succeeds() throws Exception {
		final String actual = this.getReader(EMPTY_BINARY).readString(null);
		assertEquals(EMPTY_VALUE, actual);
	}

	@Test
	public void readString_AsciiValueNonnullable_Succeeds() throws Exception {
		final String actual = this.getReader(ASCII_BINARY).readString(null);
		assertEquals(ASCII_VALUE, actual);
	}

	@Test
	public void readString_Latin1ValueNonnullable_Succeeds() throws Exception {
		final String actual = this.getReader(LATIN1_BINARY).readString(null);
		assertEquals(LATIN1_VALUE, actual);
	}

	@Test
	public void readString_SymbolValueNonnullable_Succeeds() throws Exception {
		final String actual = this.getReader(SYMBOL_BINARY).readString(null);
		assertEquals(SYMBOL_VALUE, actual);
	}

	@Test
	public void readString_CjkValueNonnullable_Succeeds() throws Exception {
		final String actual = this.getReader(CJK_BINARY).readString(null);
		assertEquals(CJK_VALUE, actual);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readString_UndersizeValueNonnullable_Throws() throws Exception {
		this.getReader(UNDERSIZE_BINARY).readString(null);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readString_OversizeValueNonnullable_Throws() throws Exception {
		this.getReader(OVERSIZE_BINARY).readString(null);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readString_ShortValueNonnullable_Throws() throws Exception {
		this.getReader(SHORT_BINARY).readString(null);
	}
}
