package com.expedia.tesla.compiler.plugins;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

import org.apache.commons.beanutils.PropertyUtils;

import com.expedia.tesla.schema.Array;
import com.expedia.tesla.schema.Class;
import com.expedia.tesla.schema.Enum;
import com.expedia.tesla.schema.Map;
import com.expedia.tesla.schema.Nullable;
import com.expedia.tesla.schema.Primitive;
import com.expedia.tesla.schema.Schema;
import com.expedia.tesla.schema.TeslaSchemaException;
import com.expedia.tesla.schema.Reference;
import com.expedia.tesla.schema.Type;
import com.expedia.tesla.schema.UserType;

public class JavaTypeMapper {

	private static final java.util.Map<Primitive, JavaTypeDescriptor> PRIM_DESCRIPTORS = new java.util.HashMap<Primitive, JavaTypeDescriptor>();
	private static final java.util.Map<String, java.lang.Class<?>> BOXES = new java.util.TreeMap<String, java.lang.Class<?>>();
	private static final java.util.Map<String, Primitive> PRIM_INDEX = new java.util.TreeMap<String, Primitive>();

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
							.getCanonicalName(), pm.boxed.getCanonicalName()));

			PRIM_INDEX.put(pm.unboxed.getCanonicalName(), pm.primtive);
			PRIM_INDEX.put(pm.boxed.getCanonicalName(), pm.primtive);
			BOXES.put(pm.unboxed.getCanonicalName(), pm.boxed);
		}
	}

	public JavaTypeDescriptor getTypeDescriptor(Type t)
			throws TeslaSchemaException {

		if (t.isPrimitive()) {
			JavaTypeDescriptor td = PRIM_DESCRIPTORS.get(t);
			if (td == null)
				throw new AssertionError(
						"BUG! missing a primitive type mapping '"
								+ t.getTypeId() + "'");
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

			if (a.getExtraTypeId() == null || a.getExtraTypeId().isEmpty()) {
				return new JavaTypeDescriptor(t, symbol(t),
						etd.getInterfaceName() + "[]", etd.getInterfaceName()
								+ "[]");
			} else {
				String tokens[] = a.getExtraTypeId().split(",");
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

		throw new AssertionError(String.format("unkonw type '%s'", t));
	}

	public String symbol(Type t) {
		return "_" + t.getTypeId().replaceAll("\\.|<|>|,|\\[|\\]", "_");
	}

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
	 * @param schema
	 *            All non-primitive Tesla types must be defined inside a schema.
	 *            This is the schema object into which the Tesla type will be
	 *            generated.
	 * 
	 * @param t
	 *            The java class object.
	 * 
	 * @return The Tesla type created from the java class by reflection.
	 * 
	 * @throws TeslaSchemaException
	 */
	public Type fromJavaClass(Schema schema, java.lang.Class<?> t)
			throws TeslaSchemaException {
		String classTypeId = Class.nameToId(t.getCanonicalName());
		Class clss = (Class) schema.findType(classTypeId);
		if (clss != null) {
			return clss;
		}

		clss = (Class) schema.addType(classTypeId);
		java.lang.Class<?> base = t.getSuperclass();
		if (base != null && base != java.lang.Object.class) {
			Class superClass = (Class) fromJavaClass(schema, t.getSuperclass());
			clss.setBases(Arrays.asList(new Class[] { superClass }));
		}

		for (PropertyDescriptor propDesc : PropertyUtils
				.getPropertyDescriptors(t)) {
			Type fieldType = null;
			String fieldName = propDesc.getName();
			Method readMethod = propDesc.getReadMethod();
			Method writeMethod = propDesc.getWriteMethod();

			if (writeMethod == null || readMethod == null) {
				continue;
			}
			if (clss.hasField(propDesc.getName())) {
				continue;
			}
			if (readMethod
					.getAnnotation(com.expedia.tesla.schema.annotation.SkipField.class) != null) {
				continue;
			}
			com.expedia.tesla.schema.annotation.TypeId tidAnnotation = readMethod
					.getAnnotation(com.expedia.tesla.schema.annotation.TypeId.class);

			String typeId = null;
			if (tidAnnotation != null) {
				typeId = tidAnnotation.value();
			}
			if (typeId != null) {
				fieldType = schema.addType(typeId);
			} else {
				java.lang.reflect.Type propType = readMethod
						.getGenericReturnType();
				readMethod.getReturnType();
				fieldType = fromJava(schema, propType);
				if (!(propType instanceof java.lang.Class<?> && ((java.lang.Class<?>) propType)
						.isPrimitive())) {
					fieldType = schema.addType(String.format("nullable<%s>",
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
				if (fieldType.isNullable() && anntNullable != null) {
					fieldType = ((Nullable) fieldType).getElementType();
				}
				if (!fieldType.isReference()
						&& readMethod
								.getAnnotation(com.expedia.tesla.schema.annotation.Reference.class) != null) {
					fieldType = schema.addType(String.format("reference<%s>",
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

			clss.addField(fieldName, fieldDisplayName, fieldType, attributes,
					null);
		}
		return clss;
	}

	private Type fromJavaEnum(Schema schema, java.lang.Class<?> t)
			throws TeslaSchemaException {
		if (!t.isEnum()) {
			throw new TeslaSchemaException("Not an enum type.");
		}
		Enum enm = (Enum) schema.addType(Enum.nameToId(t.getCanonicalName()));
		for (Object v : t.getEnumConstants()) {
			java.lang.Enum<?> e = (java.lang.Enum<?>) v;
			if (!enm.hasValue(e.name())) {
				enm.addValue(e.name(), e.ordinal(), null);
			}
		}
		return enm;
	}

	private Type fromJavaForward(Schema schema, java.lang.Class<?> jt)
			throws TeslaSchemaException {
		// TODO: handle classes derived from Java collections.

		if (jt.isPrimitive() || jt == String.class || jt == byte[].class
				|| PRIM_INDEX.containsKey(jt.getCanonicalName())) {
			Primitive p = PRIM_INDEX.get(jt.getCanonicalName());
			return schema.addType(p.getTypeId());
		}

		if (jt.isEnum()) {
			// enum
			return fromJavaEnum(schema, jt);
		}

		if (jt.isArray()) {
			// native array int[]
			Type elementType = fromJava(schema, jt.getComponentType());
			String tid = String.format("array<%s>", elementType.getTypeId());
			return schema.addType(tid);
		}

		// this must be class or interface
		return fromJavaClass(schema, jt);
	}

	private Type fromJava(Schema schema, java.lang.reflect.Type jt)
			throws TeslaSchemaException {
		if (jt instanceof java.lang.Class) {
			return fromJavaForward(schema, (java.lang.Class<?>) jt);
		} else if (jt instanceof java.lang.reflect.WildcardType) {
			// ? extends Interface
			java.lang.reflect.WildcardType wt = (java.lang.reflect.WildcardType) jt;
			return fromJava(schema, wt.getUpperBounds()[0]);
		} else if (jt instanceof java.lang.reflect.GenericArrayType) {
			// T[]
			java.lang.reflect.GenericArrayType ga = (java.lang.reflect.GenericArrayType) jt;
			Type elementType = fromJava(schema, ga.getGenericComponentType());
			return schema.addType(String.format("array<%s>",
					elementType.getTypeId()));
		} else if (jt instanceof TypeVariable) {
			// T
			TypeVariable<?> tv = (TypeVariable<?>) jt;
			return fromJava(schema, tv.getBounds()[0]);
		} else if (jt instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) jt;
			java.lang.Class<?> rt = (java.lang.Class<?>) pt.getRawType();
			if (java.util.Map.class.isAssignableFrom(rt)) {
				// Map
				java.lang.reflect.Type kt = (java.lang.reflect.Type) pt
						.getActualTypeArguments()[0];
				java.lang.reflect.Type vt = (java.lang.reflect.Type) pt
						.getActualTypeArguments()[1];
				Type keyType = fromJava(schema, kt);
				Type valueType = fromJava(schema, vt);
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
				return schema.addType(tid);
			} else if (java.util.Collection.class.isAssignableFrom(rt)) {
				// Collection array (List<?>, Set<?>), use Collection and
				// ArrayList by default
				java.lang.reflect.Type et = (java.lang.reflect.Type) pt
						.getActualTypeArguments()[0];
				Type elementType = fromJava(schema, et);
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
				return schema.addType(tid);
			}

			return fromJavaForward(schema, rt);
		} else {
			throw new AssertionError("BUG");
		}
	}
}