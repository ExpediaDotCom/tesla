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
 * Field.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

package com.expedia.tesla.schema;

import java.util.Map;

/**
 * Represent a Tesla class field.  
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 */
public class Field implements Named {
	protected String name;
	protected String displayName;
	protected Type type;
	protected Map<String, String> attributes;
	protected String description;

	/**
	 * Constructor.
	 * 
	 * @param name
	 * 		the name of the field
	 * @param displayName
	 * 		the optional display name of the field, the value as {@code name} will be used if this is {@code null} 
	 * @param type
	 * 		the type of the field
	 * @param attributes
	 * 		optional user field attributes 
	 * @param description
	 * 		the description of the field
	 */
	public Field(String name, String displayName, Type type,
			Map<String, String> attributes, String description) {
		this.name = name;
		this.displayName = displayName;
		this.type = type;
		this.attributes = attributes;
		this.description = description;
	}

	/**
	 * Get the name of the field.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Get the display name of the field.
	 */
	public String getDisplayName() {
		return this.displayName;
	}

	/**
	 * Get the type of the field.
	 */
	public Type getType() {
		return this.type;
	}

	/**
	 * Get the optional user field attributes.
	 */
	public Map<String, String> getAttributes() {
		return this.attributes;
	}

	/**
	 * Find field attribute by name.
	 * 
	 * @param name
	 * 		the name of the field attribute
	 * @return
	 * 		the field attribute if found, otherwise, return {@code null}
	 */
	public String getAttribute(String name) {
		return this.attributes == null ? null : this.attributes.get(name);
	}

	/**
	 * Get the property getter name.
	 */
	public String getGetterName() {
		return getAttribute("getter");
	}

	/**
	 * Get the property setter name.
	 */
	public String getSetterName() {
		return getAttribute("setter");
	}

	/**
	 * Get the field description.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Determine if the field is optional.
	 */
	public boolean getIsOptional() {
		return type instanceof Nullable;
	}

	/**
	 * Determine if the field is a Tesla reference.
	 */
	public boolean getIsReference() {
		return type instanceof Reference;
	}

	/**
	 * Get the rank of the array if the field is a Tesla array. Otherwise, return 0.
	 */
	public int getRank() {
		Type type = getType();
		int rank = 0;
		while (type instanceof Array) {
			type = ((Array) type).getElementType();
			rank++;
		}

		return rank;
	}

	/**
	 * Determine if the field is a Tesla array.
	 */
	public boolean getIsArray() {
		return type instanceof Array;
	}

	/**
	 * Get field type name.
	 */
	@Deprecated
	public String getTypeName() {
		if (type instanceof Primitive) {
			return ((Primitive) type).getName();
		} else if (type instanceof UserType) {
			return ((UserType) type).getName();
		}
		return null;
	}
}