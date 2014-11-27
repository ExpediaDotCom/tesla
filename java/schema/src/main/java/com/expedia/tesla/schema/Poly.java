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

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Represent a Tesla {@code Poly} object. A Tesla {@code Poly} object is a place holder for an value that can be one of
 * the types listed in the {@code Poly} concrete type list. It is similar to C++ union or variant.
 * <p>
 * Example:
 * <p>
 * <ul>
 * 	<li>{@code ploy<int,string>}: the value can be {@code int} or {@code String}.</li>
 *  <li>{@code ploy<Foo,Bar>}: the value can be object of type {@code Foo} or {@code Bar}.</li>
 *  <li>{@code ploy<Foo,Bar,int>}: the value can be object of type {@code Foo}, or type of {@code Bar}, or even 
 *  {@code int}.</li>
 * </ul>
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 *
 */
public class Poly extends Type {
	
	/**
	 * A list of possible types the current value can be.
	 */
	protected java.util.List<Type> elementTypes;

	/**
	 * Constructor.
	 * 
	 * @param elementTypes
	 * 		A list of possible types the current value can be
	 */
	public Poly(List<Type> elementTypes) {
		this.elementTypes = elementTypes;
	}

	/**
	 * Get a list of possible types the current value can be.
	 * 
	 * @return
	 * 		A list of possible types the current value can be
	 */
	public java.util.List<Type> getElementTypes() {
		return this.elementTypes;
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
		Set<Type> types = new HashSet<Type>();
		for (Type t : getElementTypes()) {
			if (t.isClass()) {
				if (!((Class) t).isAbstract()) {
					types.add(t);
				}
				for (Type dt : schema.getDerivedTypes(t, false)) {
					types.add(dt);
				}
			} else {
				types.add(t);
			}
		}

		return types;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTypeId() {
		StringBuilder sb = new StringBuilder();
		sb.append("poly<");
		Iterator<Type> itr = getElementTypes().iterator();
		sb.append(itr.next().getTypeId());
		while (itr.hasNext()) {
			sb.append(",");
			sb.append(itr.next().getTypeId());
		}
		sb.append(">");
		return sb.toString();
	}
}