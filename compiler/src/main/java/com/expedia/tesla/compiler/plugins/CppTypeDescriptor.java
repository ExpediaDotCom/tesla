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
package com.expedia.tesla.compiler.plugins;

import com.expedia.tesla.schema.Type;

public class CppTypeDescriptor {
	public CppTypeDescriptor(Type t, String symbol, String cppTypeName) {
		this.setType(t);
		this.symbol = symbol;
		this.cppTypeName = cppTypeName;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getCppTypeName() {
		return cppTypeName;
	}

	public void setCppTypeName(String cppTypeName) {
		this.cppTypeName = cppTypeName;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	private Type type;
	private String symbol;
	private String cppTypeName;
}
