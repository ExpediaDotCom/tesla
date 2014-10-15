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

package com.expedia.tesla.schema;

import com.expedia.tesla.TeslaException;

/**
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 * 
 */
public class TeslaSchemaException extends TeslaException {

	/**
     * 
     */
	private static final long serialVersionUID = 2147201426650821223L;

	public TeslaSchemaException(String message) {
		super(message);
	}

	public TeslaSchemaException(String message, Throwable e) {
		super(message, e);
	}

}
