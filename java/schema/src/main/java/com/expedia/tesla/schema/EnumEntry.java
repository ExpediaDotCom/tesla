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

/**
 * Represent an Tesla enum entry. An enum entry must have a unique name within the enum type, and an integer value. 
 * Tesla use integer values when it is encoded in binary.  
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 *
 */
public class EnumEntry implements Named {
	protected java.lang.String name;
	protected int value;
	protected java.lang.String description;

	/**
	 * Constructor.
	 * 
	 * @param name
	 * 		the name of the enum entry 
	 * @param value
	 * 		the integer value of the enum entry
	 * @param description
	 * 		the description of current enum entry
	 */
	public EnumEntry(String name, int value, String description) {
		this.name = name;
		this.value = value;
		this.description = description;
	}

	/**
	 * Get the entry name.
	 * @return
	 * 		the entry name
	 */
	public java.lang.String getName() {
		return this.name;
	}

	/**
	 * Get the integer value.
	 * @return
	 * 		the intger value
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * Get the description of current enum entry.
	 * 
	 * @return
	 * 		the description of current enum entry
	 */
	public java.lang.String getDescription() {
		return this.description;
	}
}