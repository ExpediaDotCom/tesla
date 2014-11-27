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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Tesla user class definition. A user class is typically defined in TML.
 * <p>
 * The order of class field and base classes are important to Tesla binary encoding. It always encode class fields in 
 * the order of definition. 
 * <p>
 * Tesla allows non-diamond multiple inheritance. A class can have 0, 1, or many base classes. A class with 0 base class
 * is a standalone class without inheritance relationship to others. A class with one base class reflects the 
 * inheritance relationship as Java class. The class will inherit all fields of parent class. Tesla will keep the class
 * inheritance relationship in the generated code. For a class with 2 or more base classes. Tesla will only keep the 
 * class inheritance relationship in C++. For other languages that don't support multiple inheritance, Tesla will put
 * all fields defined in base classes directly into the derived class.  
 * <p>
 * Following example defines classes with 0, 1 and 2 base classes.
 * <pre>
 * {@code
 * 		
 * 		List<Field> fields = Arrays.asList(f1, f2, f3);
 * 		
 * 		// Defines a class without base class
 * 		Class noBase = new Class("NoBase", null, fields, null);
 * 
 * 		// Defines a class with one base class
 * 		List<Class> bases = Arrays.asList(base);
 * 		Class singleBase = new Class("SingleBase", bases, fields, null);
 * 
 * 		// Defines a class with one base class
 * 		bases = Arrays.asList(base1, base2);
 * 		Class mulitBase = new Class("MultiBase", bases, fields, null);
 * } 
 * </pre>
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 */
public class Class extends UserType {
	// Keep order of base classes and fields.
	private List<Class> bases = Collections.emptyList();
	private List<Field> fields = Collections.emptyList();

	/**
	 * Create a new class. It needs to be defined later by calling {@link define} method.
	 */
	public Class(String name) {
		super(name);
	}

	/**
	 * Create and define a user class.
	 * 
	 * @param name
	 * 		class name
	 * @param bases
	 * 		base classes
	 * @param fields
	 * 		class fields
	 * @param description
	 * 		description string
	 * @throws TeslaSchemaException
	 * 		if there is any error.
	 */
	public Class(String name, List<Class> bases, List<Field> fields, String description) throws TeslaSchemaException {
		super(name);
		define(bases, fields, description);
	}

	/**
	 * Get base classes.
	 */
	public List<Class> getBases() {
		return this.bases;
	}

	/**
	 * Get class fields, not include the fields defined in bases classes.
	 */
	public List<Field> getFields() {
		return this.fields;
	}

	/**
	 * Define a user class.
	 * 
	 * @param bases
	 * 		base classes
	 * @param fields
	 * 		fields of current class
	 * @param description
	 * 		description
	 * @throws TeslaSchemaException
	 * 		if there is a duplicated field.
	 */
	public void define(List<Class> bases, List<Field> fields, String description) throws TeslaSchemaException {
		String name = null;
		if ((name = findDuplication(bases)) != null) {
			throw new TeslaSchemaException(String.format("User class '%s' has duplicated bases class '%s'.", 
					this.getName(), name));
		}
		if ((name = findDuplication(fields)) != null) {
			throw new TeslaSchemaException(String.format("User class '%s' has duplicated field '%s'.", 
					this.getName(), name));
		}
		this.bases = safeList(bases);
		this.fields = safeList(fields);
		define(description);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTypeId() {
		return nameToId(getName());
	}

	/**
	 * Get name of base classes.
	 */
	public List<String> getBaseTypeNames() {
		List<String> names = new ArrayList<String>();
		for (Class base : getBases()) {
			names.add(base.getName());
		}
		return names;
	}

	/**
	 * Get all inherited fields.
	 */
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

	/**
	 * Get all fields including inherited ones.
	 */
	public List<Field> getAllFields() {
		List<Field> all = new ArrayList<Field>();
		all.addAll(getInheritedFields());
		all.addAll(getFields());
		return all;
	}

	/**
	 * Find field by name.
	 * 
	 * @param name
	 * 		field name
	 * @return
	 * 		field with the provided name.
	 */
	public Field findField(String name) {
		for (Field f : getAllFields()) {
			if (f.getName().equals(name)) {
				return f;
			}
		}
		return null;
	}

	/**
	 * Determine if the class has a field with specified name.
	 * 
	 * @param name
	 * 		the name of field
	 */
	public boolean hasField(String name) {
		return findField(name) != null;
	}

	/**
	 * Covert class name to Tesla type id. Tesla class type id has the format of {@code class<name>}.
	 * 
	 * @param name
	 * 		class full name
	 * @return
	 * 		the corresponding Tesla type id.
	 */
	public static String nameToId(String name) {
		return String.format("class<%s>", name);
	}

	/**
	 * Covert class Tesla type id to name. Tesla class type id has the format of {@code class<name>}.
	 * 
	 * @param id
	 * @return
	 * @throws TeslaSchemaException
	 */
	public static String idToName(String id) throws TeslaSchemaException {
		if (id.matches("^class<.+>$")) {
			return id.substring("class<".length(), id.length() - 1);
		} else {
			throw new TeslaSchemaException(String.format(
					"Invalid class id '%s'", id));
		}
	}

	/**
	 * Determine if this class is abstract.
	 */
	public boolean isAbstract() {
		// TODO: not implemented yet.
		return false;
	}
}