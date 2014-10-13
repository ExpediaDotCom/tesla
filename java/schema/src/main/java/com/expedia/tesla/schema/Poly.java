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
 * Reference.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

package com.expedia.tesla.schema;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Poly extends Type {
	protected java.util.List<Type> elementTypes;

	public Poly() {
	}

	public Poly(List<Type> elementTypes) {
		setElementTypes(elementTypes);
	}

	public java.util.List<Type> getElementTypes() {
		return this.elementTypes;
	}

	public void setElementTypes(java.util.List<Type> value) {
		this.elementTypes = value;
	}

	/**
	 * Get all possible concrete types can hold by this ploy type, include all
	 * derived types.
	 * 
	 * @param schema
	 *            The current schema.
	 * @return All possible concrete types.
	 */
	public Collection<Type> getConcreteTypeList(Schema schema) {
		Set<Type> types = new TreeSet<Type>();
		for (Type t : getElementTypes()) {
			if (!t.isClass() || !((Class) t).isAbstract()) {
				types.add(t);
			}
			for (Type dt : schema.getDerivedTypes(t, false)) {
				if (!dt.isClass() || ((Class) dt).isAbstract()) {
					types.add(dt);
				}
			}
		}

		return types;
	}

	@Override
	public String getTypeId() {
		String s = "";
		boolean flag = false;
		for (Type t : getElementTypes()) {
			if (flag) {
				s += ",";
			}
			s += t.getTypeId();
			flag = true;
		}
		return "poly<" + s + ">";
	}
}