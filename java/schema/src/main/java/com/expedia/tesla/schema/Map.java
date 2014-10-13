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

public class Map extends Type {
	private Type keyType;
	private Type valueType;
	private String extraTypeId;

	public Map() {
	}

	public Map(Type keyType, Type valueType, String extraTypeId) {
		setKeyType(keyType);
		setValueType(valueType);
		setExtraTypeId(extraTypeId);
	}

	public Type getKeyType() {
		return this.keyType;
	}

	public void setKeyType(Type value) {
		this.keyType = value;
	}

	public Type getValueType() {
		return this.valueType;
	}

	public void setValueType(Type value) {
		this.valueType = value;
	}

	public String getExtraTypeId() {
		return this.extraTypeId;
	}

	public void setExtraTypeId(String value) {
		this.extraTypeId = value;
	}

	@Override
	public String getTypeId() {
		String ex = this.getExtraTypeId();
		if (ex != null && !ex.isEmpty()) {
			ex = "[" + ex + "]";
		} else {
			ex = "";
		}
		return String.format("map%s<%s,%s>", ex, this.getKeyType().getTypeId(),
				this.getValueType().getTypeId());
	}

}
