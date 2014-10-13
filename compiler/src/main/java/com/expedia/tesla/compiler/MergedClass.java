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

package com.expedia.tesla.compiler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.expedia.tesla.SchemaVersion;
import com.expedia.tesla.schema.Array;
import com.expedia.tesla.schema.Class;
import com.expedia.tesla.schema.Field;
import com.expedia.tesla.schema.Nullable;
import com.expedia.tesla.schema.Poly;
import com.expedia.tesla.schema.Reference;
import com.expedia.tesla.schema.Schema;
import com.expedia.tesla.schema.TeslaSchemaException;
import com.expedia.tesla.schema.Type;

/**
 * Tesla class may has multiple definitions from different versions. Tesla
 * compiler merges all definitions into a single class. The merged class will be
 * able to work with all versions.
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 */
public class MergedClass {
	private String name;
	private List<String> baseTypeNames = new ArrayList<String>();
	private List<Field> fields;
	private List<Field> inheritedFields;
	private List<Field> allFields;
	private Map<SchemaVersion, Schema> schemas = new TreeMap<SchemaVersion, Schema>();
	private Map<SchemaVersion, Class> classDefinitions = new TreeMap<SchemaVersion, Class>();
	private String description;

	public static List<MergedClass> merge(List<Schema> schemas)
			throws TeslaSchemaException {
		// Find out all classes.
		Set<String> classes = new TreeSet<String>();
		for (Schema schema : schemas) {
			for (Type type : schema.getTypes()) {
				if (type instanceof Class) {
					classes.add(((Class) type).getName());
				}
			}
		}

		List<MergedClass> mcs = new ArrayList<MergedClass>();
		for (String clssName : classes) {
			mcs.add(new MergedClass(clssName, schemas));
		}
		return mcs;
	}

	public MergedClass(String name, List<Schema> schemas)
			throws TeslaSchemaException {
		List<List<Field>> fieldVersions = new ArrayList<List<Field>>();
		List<List<Field>> inheritedFieldVersions = new ArrayList<List<Field>>();
		Set<String> baseTypeNames = new TreeSet<String>();
		String description = null;
		for (Schema schema : schemas) {
			Type def = schema.findType(Class.nameToId(name));
			if (def != null && def instanceof Class) {
				Class clss = (Class) def;
				fieldVersions.add(clss.getFields());
				inheritedFieldVersions.add(clss.getInheritedFields());
				if (clss.getBaseTypeNames() != null) {
					baseTypeNames.addAll(clss.getBaseTypeNames());
				}
				description = clss.getDescription();

				this.schemas.put(schema.getVersion(), schema);
				classDefinitions.put(schema.getVersion(), clss);
			}
		}

		this.name = name;
		this.baseTypeNames.addAll(baseTypeNames);
		this.description = description;

		this.fields = mergeFields(fieldVersions);
		this.inheritedFields = mergeFields(inheritedFieldVersions);
		this.allFields = new ArrayList<Field>();
		this.allFields.addAll(this.inheritedFields);
		this.allFields.addAll(this.fields);

	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return Class.toShortName(name);
	}

	public void setShortName(String shortName) {
		String namespace = getNameSpace();
		if (namespace == null || namespace.isEmpty()) {
			setName(shortName);
		} else {
			this.setName(namespace + '.' + shortName);
		}
	}

	public String getNameSpace() {
		return Class.toNameSpace(name);
	}

	public void setNameSpace(String namespace) {
		if (namespace == null || namespace.isEmpty()) {
			setName(getShortName());
		} else {
			setName(namespace + '.' + getShortName());
		}
	}

	public List<String> getBaseTypeNames() {
		return this.baseTypeNames;
	}

	public String getDescription() {
		return this.description;
	}

	public Collection<Schema> getVersions() {
		return this.schemas.values();
	}

	public Map<SchemaVersion, Class> getClassVersions() {
		return this.classDefinitions;
	}

	public List<Field> getFields() {
		return fields;
	}

	public List<Field> getInheritedFields() {
		return inheritedFields;
	}

	public List<Field> getAllFields() {
		return allFields;
	}

	private List<Field> mergeFields(List<List<Field>> fieldVersions)
			throws TeslaSchemaException {
		List<Field> allFields = new ArrayList<Field>();

		for (List<Field> fields : fieldVersions) {
			for (Field field : fields) {
				boolean exist = false;
				for (Field f : allFields) {
					if (f.getName().compareTo(field.getName()) == 0) {
						exist = true;
						if (!areFieldTypesCompatible(f.getType(),
								field.getType())) {
							throw new TeslaSchemaException(
									String.format(
											"Field '%s' of class '%s' has incompatible type in different schema versions: '%s' vs '%s'",
											field.getName(), this.name, f
													.getType().getTypeId(),
											field.getType().getTypeId()));
						}
					}
				}
				if (!exist) {
					allFields.add(field);
				}
			}
		}

		return allFields;
	}

	public static boolean areFieldTypesCompatible(Type t1, Type t2) {
		// ignore nullability or reference
		if (t1.isNullable()) {
			return areFieldTypesCompatible(((Nullable) t1).getElementType(), t2);
		} else if (t2.isNullable()) {
			return areFieldTypesCompatible(t1, ((Nullable) t2).getElementType());
		} else if (t1.isReference()) {
			return areFieldTypesCompatible(((Reference) t1).getElementType(),
					t2);
		} else if (t2.isReference()) {
			return areFieldTypesCompatible(t1,
					((Reference) t2).getElementType());
		} else if (t1.isPrimitive()) {
			return t1 == t2;
		} else if (t1.isUserType()) {
			return t1.getTypeId().equals(t2.getTypeId());
		} else if (t1.isArray() && t2.isArray()) {
			return areFieldTypesCompatible(((Array) t1).getElementType(),
					((Array) t2).getElementType());
		} else if (t1.isMap() && t2.isMap()) {
			return areFieldTypesCompatible(
					((com.expedia.tesla.schema.Map) t1).getKeyType(),
					((com.expedia.tesla.schema.Map) t2).getKeyType())
					&& areFieldTypesCompatible(
							((com.expedia.tesla.schema.Map) t1).getValueType(),
							((com.expedia.tesla.schema.Map) t2).getValueType());
		} else if (t1.isPoly() || t2.isPoly()) {
			// TODO: fix this
			return true;
		}

		return false;
	}

	public Set<Type> referedUserTypes() {
		Set<Type> result = new HashSet<Type>();
		for (Field f : getAllFields()) {
			result.addAll(referedUserTypes(f.getType()));
		}
		return result;
	}

	public Set<Type> referedUserTypes(Type t) {
		Set<Type> result = new HashSet<Type>();
		if (t.isArray()) {
			result = referedUserTypes(((Array) t).getElementType());
		} else if (t.isMap()) {
			com.expedia.tesla.schema.Map map = (com.expedia.tesla.schema.Map) t;
			result.addAll(referedUserTypes(map.getKeyType()));
			result.addAll(referedUserTypes(map.getValueType()));
		} else if (t.isNullable()) {
			result = referedUserTypes(((Nullable) t).getElementType());
		} else if (t.isPoly()) {
			Poly pt = (Poly) t;
			for (Type et : pt.getElementTypes()) {
				result.addAll(referedUserTypes(et));
			}
		} else if (t.isUserType()) {
			result.add(t);
		}
		return result;
	}
}
