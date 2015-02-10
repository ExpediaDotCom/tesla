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

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

import com.expedia.tesla.schema.Array;
import com.expedia.tesla.schema.Class;
import com.expedia.tesla.schema.Enum;
import com.expedia.tesla.schema.EnumEntry;
import com.expedia.tesla.schema.Field;
import com.expedia.tesla.schema.Map;
import com.expedia.tesla.schema.Nullable;
import com.expedia.tesla.schema.Primitive;
import com.expedia.tesla.schema.Reference;
import com.expedia.tesla.schema.Schema;
import com.expedia.tesla.schema.TeslaSchemaException;
import com.expedia.tesla.schema.Type;
import com.expedia.tesla.schema.UserType;

public class JavaTypeMapper {
	
	private static final java.util.Map<Primitive, JavaTypeDescriptor> PRIM_DESCRIPTORS = new java.util.HashMap<Primitive, JavaTypeDescriptor>();
	private static final java.util.Map<String, java.lang.Class<?>> BOXES = new java.util.TreeMap<String, java.lang.Class<?>>();
	private static final java.util.Map<String, Primitive> PRIM_INDEX = new java.util.TreeMap<String, Primitive>();
	private boolean mapToJavaArray = false;

	private static class Pmap {
		Pmap(Primitive primtive, java.lang.Class<?> unboxed,
				java.lang.Class<?> boxed) {
			this.primtive = primtive;
			this.unboxed = unboxed;
			this.boxed = boxed;
		}

		Primitive primtive;
		java.lang.Class<?> unboxed;
		java.lang.Class<?> boxed;
	}

	private static final Pmap[] PRIM_MAPS = new Pmap[] {
			new Pmap(Primitive.BYTE, byte.class, Byte.class),
			new Pmap(Primitive.UINT16, short.class, Short.class),
			new Pmap(Primitive.UINT32, int.class, Integer.class),
			new Pmap(Primitive.UINT64, long.class, Long.class),
			new Pmap(Primitive.INT16, short.class, Short.class),
			new Pmap(Primitive.INT32, int.class, Integer.class),
			new Pmap(Primitive.INT64, long.class, Long.class),
			new Pmap(Primitive.BOOLEAN, boolean.class, Boolean.class),
			new Pmap(Primitive.FLOAT, float.class, Float.class),
			new Pmap(Primitive.DOUBLE, double.class, Double.class),
			new Pmap(Primitive.STRING, String.class, String.class),
			new Pmap(Primitive.BINARY, byte[].class, byte[].class) };

	static {

		for (Pmap pm : PRIM_MAPS) {
			PRIM_DESCRIPTORS.put(
					pm.primtive,
					new JavaTypeDescriptor(pm.primtive, "_"
							+ pm.primtive.getName(), pm.unboxed
							.getCanonicalName(), pm.unboxed.getCanonicalName()));

			PRIM_INDEX.put(pm.unboxed.getCanonicalName(), pm.primtive);
			PRIM_INDEX.put(pm.boxed.getCanonicalName(), pm.primtive);
			BOXES.put(pm.unboxed.getCanonicalName(), pm.boxed);
		}
	}

	/**
	 * Determines if Tesla arrays are mapped to Java arrays. If this is {@code true}, Tesla arrays without detailed 
	 * container type information will be mapped to java arrays. Otherwise, they will be mapped to {@code ArrayList}.
	 * 
     * @return  {@code true} if map to Java array;
     *          {@code false} otherwise.
	 */
	public boolean isMapToJavaArray() {
		return mapToJavaArray;
	}

	/**
	 * Configures the default Tesla array mapping when an array type specified without detailed container type 
	 * information. 
	 * <p>
	 * Set to {@code true} will map arrays to Java arrays. Otherwise, they will be mapped to {@code ArrayList}.
	 * 
	 * @param mapToJavaArray if map to Java array;
	 */
	public void setMapToJavaArray(boolean mapToJavaArray) {
		this.mapToJavaArray = mapToJavaArray;
	}

	/**
	 * Obtains Java type descriptor which describes type mapping information for a given Tesla type.
	 *  
	 * @param t
	 * 		The Tesla type.
	 * @return
	 * 		A {@code JavaTypeDescriptor} object that describes the mapped Java types.
	 * @throws TeslaSchemaException
	 * 		On a mapping error.
	 */
	public JavaTypeDescriptor getTypeDescriptor(Type t)
			throws TeslaSchemaException {

		if (t.isPrimitive()) {
			JavaTypeDescriptor td = PRIM_DESCRIPTORS.get(t);
			assert (td != null) : "BUG! missing a primitive type mapping '" + t.getTypeId() + "'";
			return td;
		}

		if (t.isNullable()) {
			Nullable nt = (Nullable) t;
			Type e = nt.getElementType();
			JavaTypeDescriptor etd = getTypeDescriptor(e);

			return new JavaTypeDescriptor(t, symbol(t),
					box(etd.getInterfaceName()), box(etd.getActualTypeName()));
		}

		if (t.isArray()) {
			Array a = (Array) t;
			Type e = a.getElementType();
			JavaTypeDescriptor etd = getTypeDescriptor(e);
			
			String containerInfo = a.getExtraTypeId();
			if (containerInfo == null || containerInfo.isEmpty()) {
				if (!mapToJavaArray) {
					containerInfo = "java.util.List,java.util.ArrayList";
				} else {
					return new JavaTypeDescriptor(t, symbol(t),
							etd.getInterfaceName() + "[]", etd.getInterfaceName()
									+ "[]");
				}
			}
			
			String tokens[] = containerInfo.split(",");
			String interfaceName = null;
			String actualTypeName = null;
			if (tokens.length == 1) {
				interfaceName = actualTypeName = tokens[0];
			} else if (tokens.length == 2) {
				interfaceName = tokens[0];
				actualTypeName = tokens[1];
			} else {
				throw new TeslaSchemaException(String.format(
						"Can't find type mapping for type '%s'.",
						t.getTypeId()));
			}
			interfaceName = String.format(interfaceName + "<%s>",
					box(etd.getInterfaceName()));
			actualTypeName = String.format(actualTypeName + "<%s>",
					box(etd.getInterfaceName()));
			return new JavaTypeDescriptor(t, symbol(t), interfaceName,
					actualTypeName);
		}

		if (t.isMap()) {
			Map m = (Map) t;
			Type keyType = m.getKeyType();
			Type valueType = m.getValueType();
			JavaTypeDescriptor ktd = getTypeDescriptor(keyType);
			JavaTypeDescriptor vtd = getTypeDescriptor(valueType);
			String extraTypeId = m.getExtraTypeId();
			String mi = "java.util.Map<%s, %s>";
			String mt = "java.util.HashMap<%s, %s>";

			if (extraTypeId != null && !extraTypeId.isEmpty()) {
				String tokens[] = extraTypeId.split(",");
				if (tokens.length == 1) {
					mi = tokens[0] + "<%s,%s>";
					mt = mi;
				} else if (tokens.length == 2) {
					mi = tokens[0] + "<%s,%s>";
					mt = tokens[1] + "<%s,%s>";
				} else {
					throw new TeslaSchemaException(String.format(
							"Unable to find type mapping for '%s'",
							t.getTypeId()));
				}
			}

			mi = String.format(mi, box(ktd.getInterfaceName()),
					box(vtd.getInterfaceName()));
			mt = String.format(mt, box(ktd.getInterfaceName()),
					box(vtd.getInterfaceName()));

			return new JavaTypeDescriptor(t, symbol(t), mi, mt);
		}

		if (t.isUserType()) {
			String name = ((UserType) t).getName();
			return new JavaTypeDescriptor(t, symbol(t), name, name);
		}

		if (t.isPoly()) {
			return new JavaTypeDescriptor(t, symbol(t), "java.lang.Object",
					"java.lang.Object");
		}

		if (t.isReference()) {
			JavaTypeDescriptor etd = getTypeDescriptor(((Reference) t)
					.getElementType());
			return new JavaTypeDescriptor(t, symbol(t),
					box(etd.getInterfaceName()), box(etd.getActualTypeName()));
		}

		throw new TeslaSchemaException(String.format("unknown type '%s'", t));
	}

	/**
	 * Create an unique symbol for a Tesla type that can be used in the generated source code.
	 * 
	 * @param t
	 * 		The Tesla type.
	 * @return
	 * 		An unique symbol for a Tesla type that can be used in the generated source code.
	 */
	public String symbol(Type t) {
		return "_" + t.getTypeId().replaceAll("\\.|<|>|,|\\[|\\]", "_");
	}

	/**
	 * Get the boxed type name. If the input type name does't represent a Java primitive type, the returned value will
	 * be the same as input.
	 * 
	 * @param t
	 * 		Java type name.
	 * @return
	 * 		The boxed Java type name if the input is a Java primitive type. Otherwise, it returns the same name as input.
	 */
	public String box(String t) {
		if (BOXES.containsKey(t))
			return BOXES.get(t).getCanonicalName();
		return t;
	}

	/**
	 * Generate Tesla schema from Java class by reflection.
	 * <p>
	 * Tesla can generate schema from existing Java classes that follow the
	 * JavaBeans Spec. Only properties with following attributes will be
	 * included:
	 * <li>public accessible.</li>
	 * <li>writable (has both getter and setter).</li>
	 * <li>has no {@code SkipField} annotation.</li>
	 * <p>
	 * Tesla will map Java type to it's closest Tesla type by default.
	 * Developers can override this by either providing their own
	 * {@code TypeMapper}, or with Tesla annoations.
	 * <p>
	 * Tesla will map all Java object types to nullable types only for class
	 * properties. If you want an property to be not nullable, use annotation
	 * {@code NotNullable}.
	 * 
	 * @param schemaBuilder
	 *            All non-primitive Tesla types must be defined inside a schema.
	 *            This is the schema object into which the Tesla type will be
	 *            generated.
	 * 
	 * @param javaType
	 *            The java class object.
	 * 
	 * @return The Tesla type created from the java class by reflection.
	 * 
	 * @throws TeslaSchemaException
	 */
	public Type fromJavaClass(Schema.SchemaBuilder schemaBuilder, java.lang.Class<?> javaType)
			throws TeslaSchemaException {
		String className = javaType.getCanonicalName(); 
		if (className == null) {
			throw new TeslaSchemaException(String.format(
					"Tesla cannot generate schema for local class '%s'.", javaType.getName()));
		}
		String classTypeId = Class.nameToId(className);
		Class clss = (Class) schemaBuilder.findType(classTypeId);
		if (clss != null) {
			return clss;
		}

		clss = (Class) schemaBuilder.addType(classTypeId);

		Class superClass = null;
		java.lang.Class<?> base = javaType.getSuperclass();
		if (base != null && base != java.lang.Object.class) {
			superClass = (Class) fromJavaClass(schemaBuilder, javaType.getSuperclass());
		}

		List<Field> fields = new ArrayList<>();
		for (PropertyDescriptor propDesc : PropertyUtils.getPropertyDescriptors(javaType)) {
			Type fieldType = null;
			String fieldName = propDesc.getName();
			Method readMethod = propDesc.getReadMethod();
			Method writeMethod = propDesc.getWriteMethod();

			// Ignore the property it missing getter or setter method.
			if (writeMethod == null || readMethod == null) {
				continue;
			}
			if ((superClass != null && superClass.hasField(fieldName)) || clss.hasField(fieldName)) {
				continue;
			}
			// Ignore the property if it is annotated with "SkipField".
			if (readMethod.getAnnotation(com.expedia.tesla.schema.annotation.SkipField.class) != null) {
				continue;
			}
			com.expedia.tesla.schema.annotation.TypeId tidAnnotation = readMethod
					.getAnnotation(com.expedia.tesla.schema.annotation.TypeId.class);

			String typeId = null;
			if (tidAnnotation != null) {
				typeId = tidAnnotation.value();
			}
			if (typeId != null) {
				fieldType = schemaBuilder.addType(typeId);
				System.out.println(typeId);
			} else {
				System.out.println("typeId == null");
				java.lang.reflect.Type propType = readMethod
						.getGenericReturnType();
				fieldType = fromJava(schemaBuilder, propType);
				if (!(propType instanceof java.lang.Class<?> && ((java.lang.Class<?>) propType)
						.isPrimitive())) {
					fieldType = schemaBuilder.addType(String.format("nullable<%s>",
							fieldType.getTypeId()));
				}
				com.expedia.tesla.schema.annotation.NotNullable anntNotNullable = readMethod
						.getAnnotation(com.expedia.tesla.schema.annotation.NotNullable.class);
				com.expedia.tesla.schema.annotation.Nullable anntNullable = readMethod
						.getAnnotation(com.expedia.tesla.schema.annotation.Nullable.class);
				if (anntNotNullable != null && anntNullable != null) {
					throw new TeslaSchemaException(
							String.format(
									"Property '%' of class '%s' has conflict annotations."
											+ "'NotNullable' and 'Nullable'",
									fieldName));
				}
				if (fieldType.isNullable() && anntNotNullable != null) {
					fieldType = ((Nullable) fieldType).getElementType();
				}
				if (!fieldType.isReference()
						&& readMethod.getAnnotation(com.expedia.tesla.schema.annotation.Reference.class) != null) {
					fieldType = schemaBuilder.addType(String.format("reference<%s>",
							fieldType.getTypeId()));
				}
			}

			com.expedia.tesla.schema.annotation.FieldName fnAnnotation = readMethod
					.getAnnotation(com.expedia.tesla.schema.annotation.FieldName.class);
			if (fnAnnotation != null) {
				fieldName = fnAnnotation.value();
			}

			String fieldDisplayName = propDesc.getDisplayName();
			String getter = readMethod.getName();
			String setter = propDesc.getWriteMethod().getName();
			com.expedia.tesla.schema.annotation.DisplayName dnAnnotation = readMethod
					.getAnnotation(com.expedia.tesla.schema.annotation.DisplayName.class);
			if (dnAnnotation != null) {
				fieldDisplayName = dnAnnotation.value();
			}
			java.util.Map<String, String> attributes = new java.util.HashMap<String, String>();
			attributes.put("getter", getter);
			attributes.put("setter", setter);

			fields.add(new Field(fieldName, fieldDisplayName, fieldType, attributes, null));
		}
		
		clss.define(superClass == null ? null : Arrays.asList(new Class[]{superClass}), fields, null);
		return clss;
	}

	private Type fromJavaEnum(Schema.SchemaBuilder schemaBuilder, java.lang.Class<?> t)
			throws TeslaSchemaException {
		if (!t.isEnum()) {
			throw new TeslaSchemaException("Not an enum type.");
		}
		Enum enm = (Enum) schemaBuilder.addType(Enum.nameToId(t.getCanonicalName()));
		List<EnumEntry> entries = new ArrayList<>();
		for (Object v : t.getEnumConstants()) {
			java.lang.Enum<?> e = (java.lang.Enum<?>) v;
			if (!enm.hasEntry(e.name())) {
				entries.add(new EnumEntry(e.name(), e.ordinal(), null));
			}
		}
		enm.define(entries, null);
		return enm;
	}

	private Type fromJavaForward(Schema.SchemaBuilder schemaBuilder, java.lang.Class<?> jt)
			throws TeslaSchemaException {
		// TODO: handle classes derived from Java collections.

		if (PRIM_INDEX.containsKey(jt.getCanonicalName())) {
			Primitive p = PRIM_INDEX.get(jt.getCanonicalName());
			return schemaBuilder.addType(p.getTypeId());
		}

		if (jt.isEnum()) {
			// enum
			return fromJavaEnum(schemaBuilder, jt);
		}

		if (jt.isArray()) {
			// native array int[]
			Type elementType = fromJava(schemaBuilder, jt.getComponentType());
			String tid = String.format("array<%s>", elementType.getTypeId());
			return schemaBuilder.addType(tid);
		}

		// this must be class or interface
		return fromJavaClass(schemaBuilder, jt);
	}

	private Type fromJava(Schema.SchemaBuilder schemaBuilder, java.lang.reflect.Type jt)
			throws TeslaSchemaException {
		if (jt instanceof java.lang.Class) {
			return fromJavaForward(schemaBuilder, (java.lang.Class<?>) jt);
		} else if (jt instanceof java.lang.reflect.WildcardType) {
			// ? extends Interface
			java.lang.reflect.WildcardType wt = (java.lang.reflect.WildcardType) jt;
			return fromJava(schemaBuilder, wt.getUpperBounds()[0]);
		} else if (jt instanceof java.lang.reflect.GenericArrayType) {
			// T[]
			java.lang.reflect.GenericArrayType ga = (java.lang.reflect.GenericArrayType) jt;
			Type elementType = fromJava(schemaBuilder, ga.getGenericComponentType());
			return schemaBuilder.addType(String.format("array<%s>",
					elementType.getTypeId()));
		} else if (jt instanceof TypeVariable) {
			// T
			TypeVariable<?> tv = (TypeVariable<?>) jt;
			return fromJava(schemaBuilder, tv.getBounds()[0]);
		} else if (jt instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) jt;
			java.lang.Class<?> rt = (java.lang.Class<?>) pt.getRawType();
			if (java.util.Map.class.isAssignableFrom(rt)) {
				// Map
				java.lang.reflect.Type kt = (java.lang.reflect.Type) pt
						.getActualTypeArguments()[0];
				java.lang.reflect.Type vt = (java.lang.reflect.Type) pt
						.getActualTypeArguments()[1];
				Type keyType = fromJava(schemaBuilder, kt);
				Type valueType = fromJava(schemaBuilder, vt);
				String fs = null;
				java.lang.Class<?> rawType = (java.lang.Class<?>) pt
						.getRawType();
				if (rawType.isInterface()) {
					fs = "map<%s,%s>";
				} else {
					fs = "map[" + rawType.getCanonicalName() + "]<%s,%s>";
				}
				String tid = String.format(fs, keyType.getTypeId(),
						valueType.getTypeId());
				return schemaBuilder.addType(tid);
			} else if (java.util.Collection.class.isAssignableFrom(rt)) {
				// Collection array (List<?>, Set<?>), use Collection and
				// ArrayList by default
				java.lang.reflect.Type et = (java.lang.reflect.Type) pt
						.getActualTypeArguments()[0];
				Type elementType = fromJava(schemaBuilder, et);
				String fs = null;
				java.lang.Class<?> rawType = (java.lang.Class<?>) pt
						.getRawType();
				if (rawType.isInterface()) {
					fs = "array[java.util.Collection,java.util.ArrayList]<%s>";
					if (java.util.List.class.isAssignableFrom(rt)) {
						fs = "array[java.util.List,java.util.ArrayList]<%s>";
					} else if (java.util.Set.class.isAssignableFrom(rt)) {
						fs = "array[java.util.Set,java.util.HashSet]<%s>";
					}
				} else {
					fs = "array[" + rawType.getCanonicalName() + "]<%s>";
				}
				String tid = String.format(fs, elementType.getTypeId());
				return schemaBuilder.addType(tid);
			}

			return fromJavaForward(schemaBuilder, rt);
		} else {
			throw new TeslaSchemaException("BUG");
		}
	}
}