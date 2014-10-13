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
package com.expedia.tesla.serialization;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Generic round-trip serialization tests for Boolean values. Implement
 * getWriter and getReader to instantiate this test suite.
 * 
 * @author dheld
 */
public abstract class BooleanRoundTripTemplate extends BaseRoundTripTemplate
		implements BooleanFixture {
	public BooleanRoundTripTemplate(RoundTripFactory factory) {
		super(factory);
	}

	@Test
	public void writeReadBoolean_False_Succeeds() throws Exception {
		this.getWriter().writeBoolean(null, FALSE_VALUE);
		assertEquals(FALSE_VALUE, this.getReader().readBoolean(null));
	}

	@Test
	public void writeReadBoolean_True_Succeeds() throws Exception {
		this.getWriter().writeBoolean(null, TRUE_VALUE);
		assertEquals(TRUE_VALUE, this.getReader().readBoolean(null));
	}
}
