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

import com.expedia.tesla.serialization.BooleanFixture;
import com.expedia.tesla.serialization.TeslaDeserializationException;

/**
 * Deserialization Boolean tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class BooleanDeserializationTest extends BaseFixture implements
		BooleanFixture {
	@Test(expected = TeslaDeserializationException.class)
	public void readBoolean_EmptyStream_Throws() throws Exception {
		this.getReader(EMPTY_STREAM).readBoolean(null);
	}

	@Test
	public void readBoolean_False_Succeeds() throws Exception {
		final boolean actual = this.getReader(FALSE_BINARY).readBoolean(null);
		assertEquals(FALSE_VALUE, actual);
	}

	@Test
	public void readBoolean_True_Succeeds() throws Exception {
		final boolean actual = this.getReader(TRUE_BINARY).readBoolean(null);
		assertEquals(TRUE_VALUE, actual);
	}

	@Test(expected = TeslaDeserializationException.class)
	public void readBoolean_Invalid_Throws() throws Exception {
		this.getReader(INVALID_BINARY).readBoolean(null);
	}

}
