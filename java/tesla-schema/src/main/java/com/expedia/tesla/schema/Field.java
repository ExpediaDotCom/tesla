/**
 * Field.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

package com.expedia.tesla.schema;

import java.util.HashMap;
import java.util.Map;

public class Field {
	protected String name;
	protected String displayName;
	protected Type type;
	protected Map<String, String> attributes;
	protected String description;

	public Field() {
	}

	public Field(String name, String displayName, Type type,
			Map<String, String> attributes, String description) {
		setName(name);
		setDisplayName(displayName);
		setType(type);
		setAttributes(attributes);
		setDescription(description);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String value) {
		this.displayName = value;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type value) {
		this.type = value;
	}

	public Map<String, String> getAttributes() {
		return this.attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public String getAttribute(String name) {
		return this.attributes == null ? null : this.attributes.get(name);
	}

	public void setAttribute(String name, String value) {
		if (this.attributes == null) {
			this.attributes = new HashMap<String, String>();
		}
		this.attributes.put(name, value);
	}

	public String getGetterName() {
		return getAttribute("getter");
	}

	public void setGetterName(String value) {
		this.attributes.put("getter", value);
	}

	public String getSetterName() {
		return getAttribute("getter");
	}

	public void setSetterName(String value) {
		setAttribute("setter", value);
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public boolean getIsOptional() {
		return type instanceof Nullable;
	}

	public boolean getIsReference() {
		return type instanceof Reference;
	}

	public int getRank() {
		Type type = getType();
		int rank = 0;
		while (type instanceof Array) {
			type = ((Array) type).getElementType();
			rank++;
		}

		return rank;
	}

	public boolean getIsArray() {
		return type instanceof Array;
	}

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