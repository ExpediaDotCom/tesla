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

import com.expedia.tesla.serialization.BooleanFixture;

/**
 * Serialization Boolean tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class BooleanSerializationTest extends BaseFixture implements
		BooleanFixture {
	@Test(expected = java.io.IOException.class)
	public void writeBoolean_StreamIOException_Throws() throws Exception {
		this.getThrowWriter().writeBoolean(null, true);
	}

	@Test
	public void writeBoolean_False_Succeeds() throws Exception {
		this.getWriter().writeBoolean(null, FALSE_VALUE);
		assertArrayEquals(FALSE_BINARY, this.getOutput());
	}

	@Test
	public void writeBoolean_True_Succeeds() throws Exception {
		this.getWriter().writeBoolean(null, TRUE_VALUE);
		assertArrayEquals(TRUE_BINARY, this.getOutput());
	}
}
