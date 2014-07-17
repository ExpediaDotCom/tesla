/**
 *
 * Class.java
 *
 * Copyright 2013 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.tesla.schema;

import java.util.ArrayList;
import java.util.List;

/**
 * Tesla user class definition. A user class is typically defined in TML.
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 */
public class Class extends UserType {
	private List<Class> bases = new ArrayList<Class>();
	private List<Field> fields = new ArrayList<Field>();
	private List<Class> derivedTypes = new ArrayList<Class>();

	public Class() {
	}

	public Class(String name, List<Class> bases, List<Field> fields,
			String description) {
		setName(name);
		setDescription(description);
		setBases(bases);
		setFields(fields);
	}

	public List<Class> getBases() {
		return this.bases;
	}

	public void setBases(List<Class> value) {
		this.bases = value;
	}

	public List<Field> getFields() {
		return this.fields;
	}

	public void setFields(List<Field> value) {
		this.fields = value;
	}

	public Field addField(String name, String displayName, Type fieldType,
			java.util.Map<String, String> attributes, String descprition)
			throws TeslaSchemaException {
		if (getFields() == null) {
			setFields(new ArrayList<Field>());
		}
		for (Field f : getFields()) {
			if (f.getName().equals(name))
				throw new TeslaSchemaException(String.format(
						"Field '%s' already exists in class '%'.", name,
						this.getName()));
		}
		Field field = new Field(name, displayName, fieldType, attributes,
				descprition);
		getFields().add(field);
		return field;
	}

	@Override
	public String getTypeId() {
		return nameToId(getName());
	}

	public List<String> getBaseTypeNames() {
		List<String> names = new ArrayList<String>();
		for (Class base : getBases()) {
			names.add(base.getName());
		}
		return names;
	}

	public List<Field> getInheritedFields() {
		List<Field> fields = new ArrayList<Field>();
		List<Class> bases = getBases();
		if (bases != null) {
			for (Type type : bases) {
				fields.addAll(((Class) type).getInheritedFields());
				fields.addAll(((Class) type).getFields());
			}
		}
		return fields;
	}

	public List<Field> getAllFields() {
		List<Field> all = new ArrayList<Field>();
		all.addAll(getInheritedFields());
		all.addAll(getFields());
		return all;
	}

	public Field findField(String name) {
		for (Field f : getAllFields()) {
			if (f.getName().equals(name)) {
				return f;
			}
		}
		return null;
	}

	public boolean hasField(String name) {
		return findField(name) != null;
	}

	public List<Class> getDerivedTypes() {
		return derivedTypes;
	}

	public void setDerivedTypes(List<Class> derivedTypes) {
		this.derivedTypes = derivedTypes;
	}

	public void addDerivedTypes(Class derived) {
		this.derivedTypes.add(derived);
	}

	public static String nameToId(String name) {
		return String.format("class<%s>", name);
	}

	public static String idToName(String id) throws TeslaSchemaException {
		if (id.matches("^class<.+>$")) {
			return id.substring("class<".length(), id.length() - 1);
		} else {
			throw new TeslaSchemaException(String.format(
					"Invalid class id '%s'", id));
		}
	}

	public boolean isAbstract() {
		// TODO Auto-generated method stub
		return false;
	}
}