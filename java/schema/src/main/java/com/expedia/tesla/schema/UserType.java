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
/**
 * UserType.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

package com.expedia.tesla.schema;

public abstract class UserType extends Type {
	protected String name;
	protected String description;
	protected boolean isDefined = false;

	public UserType() {
	}

	public UserType(String name, String description) {
		setName(name);
		setDescription(description);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public String getShortName() {
		return toShortName(name);
	}

	public String getNameSpace() {
		return toNameSpace(name);
	}
	
	protected void define() {
		isDefined = true;
	}
	
	boolean isDefined() {
		return isDefined;
	}

	private static String[] splitFullName(String fullName) {
		String[] result = new String[2];

		if (fullName.matches(".+\\..+")) {
			int pos = fullName.lastIndexOf('.');
			result[0] = fullName.substring(0, pos);
			result[1] = fullName.substring(pos + 1);
		} else {
			result[1] = fullName;
		}
		return result;
	}

	public static String toShortName(String fullName) {
		return splitFullName(fullName)[1];
	}

	public static String toNameSpace(String fullName) {
		return splitFullName(fullName)[0];
	}
}