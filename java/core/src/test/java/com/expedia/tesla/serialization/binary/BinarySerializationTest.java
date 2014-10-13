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

import com.expedia.tesla.serialization.BinaryFixture;

/**
 * Serialization Binary tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class BinarySerializationTest extends BaseFixture implements
		BinaryFixture {
	@Test(expected = java.io.IOException.class)
	public void writeBinary_StreamIOException_Throws() throws Exception {
		this.getThrowWriter().writeBinary(null, SMALL_VALUE);
	}

	@Test
	public void writeBinary_EmptyValueNonnullable_Succeeds() throws Exception {
		this.getWriter().writeBinary(null, EMPTY_VALUE);
		assertArrayEquals(EMPTY_BINARY, this.getOutput());
	}

	@Test
	public void writeBinary_SmallValueNonnullable_Succeeds() throws Exception {
		this.getWriter().writeBinary(null, SMALL_VALUE);
		assertArrayEquals(SMALL_BINARY, this.getOutput());
	}

	@Test
	public void writeBinary_LargeValueNonnullable_Succeeds() throws Exception {
		this.getWriter().writeBinary(null, LARGE_VALUE);
		assertArrayEquals(LARGE_BINARY, this.getOutput());
	}
}
