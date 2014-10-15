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

import com.expedia.tesla.serialization.Int32RoundTripTemplate;
import com.expedia.tesla.serialization.RoundTripFactory;

/**
 * Round-trip Int32 tests for the Tesla Binary format.
 * 
 * @author dheld
 */
public class Int32RoundTripTest extends Int32RoundTripTemplate {
	public Int32RoundTripTest() {
		super(new RoundTripFactory());
	}
}
