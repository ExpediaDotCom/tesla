/**
 * 
 */
package com.expedia.tesla.compiler.plugins;

import java.util.ArrayList;
import java.util.List;

import com.expedia.tesla.compiler.Util;
import com.expedia.tesla.schema.Array;
import com.expedia.tesla.schema.Map;
import com.expedia.tesla.schema.Nullable;
import com.expedia.tesla.schema.Poly;
import com.expedia.tesla.schema.Primitive;
import com.expedia.tesla.schema.Reference;
import com.expedia.tesla.schema.TeslaSchemaException;
import com.expedia.tesla.schema.Type;
import com.expedia.tesla.schema.UserType;

/**
 * @author yzuo
 * 
 */
public class CppTypeMapper {
	private static final java.util.Map<Primitive, CppTypeDescriptor> PRIM_DESCRIPTORS = new java.util.HashMap<Primitive, CppTypeDescriptor>();

	static {
		PRIM_DESCRIPTORS.put(Primitive.BYTE, new CppTypeDescriptor(
				Primitive.BYTE, "Byte", "unsigned char"));
		PRIM_DESCRIPTORS.put(Primitive.UINT16, new CppTypeDescriptor(
				Primitive.UINT16, "UInt16", "unsigned short"));
		PRIM_DESCRIPTORS.put(Primitive.UINT32, new CppTypeDescriptor(
				Primitive.UINT32, "UInt32", "unsigned int"));
		PRIM_DESCRIPTORS.put(Primitive.UINT64, new CppTypeDescriptor(
				Primitive.UINT64, "UInt64", "unsigned long long"));
		PRIM_DESCRIPTORS.put(Primitive.INT16, new CppTypeDescriptor(
				Primitive.INT16, "Int16", "short"));
		PRIM_DESCRIPTORS.put(Primitive.INT32, new CppTypeDescriptor(
				Primitive.INT32, "Int32", "int"));
		PRIM_DESCRIPTORS.put(Primitive.INT64, new CppTypeDescriptor(
				Primitive.INT64, "Int64", "long long"));
		PRIM_DESCRIPTORS.put(Primitive.BOOLEAN, new CppTypeDescriptor(
				Primitive.BOOLEAN, "Boolean", "bool"));
		PRIM_DESCRIPTORS.put(Primitive.FLOAT, new CppTypeDescriptor(
				Primitive.FLOAT, "Float", "float"));
		PRIM_DESCRIPTORS.put(Primitive.DOUBLE, new CppTypeDescriptor(
				Primitive.DOUBLE, "Double", "double"));
		PRIM_DESCRIPTORS.put(Primitive.STRING, new CppTypeDescriptor(
				Primitive.STRING, "String", "std::string"));
		PRIM_DESCRIPTORS.put(Primitive.BINARY, new CppTypeDescriptor(
				Primitive.BINARY, "Binary", "std::vector<char>"));
	}

	public CppTypeDescriptor getDescriptor(Type t) throws TeslaSchemaException {

		if (t.isPrimitive()) {
			CppTypeDescriptor td = PRIM_DESCRIPTORS.get(t);
			if (td == null)
				throw new AssertionError(
						"BUG! missing a primitive type mapping '"
								+ t.getTypeId() + "'");
			return td;
		}

		if (t.isNullable()) {
			Nullable nt = (Nullable) t;
			Type e = nt.getElementType();
			CppTypeDescriptor etd = getDescriptor(e);

			return new CppTypeDescriptor(t, symbol(t), String.format(
					"boost::shared_ptr<%s >", etd.getCppTypeName()));
		}

		if (t.isReference()) {
			Reference nt = (Reference) t;
			Type e = nt.getElementType();
			CppTypeDescriptor etd = getDescriptor(e);

			return new CppTypeDescriptor(t, symbol(t), String.format(
					"boost::shared_ptr<%s >", etd.getCppTypeName()));
		}

		if (t.isArray()) {
			Array a = (Array) t;
			Type e = a.getElementType();
			CppTypeDescriptor etd = getDescriptor(e);

			String typeName = String.format("std::vector<%s >",
					etd.getCppTypeName());
			return new CppTypeDescriptor(t, symbol(t), typeName);
		}

		if (t.isMap()) {
			Map m = (Map) t;
			Type keyType = m.getKeyType();
			Type valueType = m.getValueType();
			CppTypeDescriptor ktd = getDescriptor(keyType);
			CppTypeDescriptor vtd = getDescriptor(valueType);
			String cppTypeName = String.format("std::map<%s, %s >",
					ktd.getCppTypeName(), vtd.getCppTypeName());

			return new CppTypeDescriptor(t, symbol(t), cppTypeName);
		}

		if (t.isUserType()) {
			String name = ((UserType) t).getShortName();
			return new CppTypeDescriptor(t, symbol(t), name);
		}

		if (t.isPoly()) {
			Poly pt = (Poly) t;
			List<String> elementCppTypeNames = new ArrayList<String>();
			for (Type elementType : pt.getElementTypes()) {
				elementCppTypeNames.add(getDescriptor(elementType)
						.getCppTypeName());
			}

			return new CppTypeDescriptor(t, symbol(t), String.format(
					"boost::variant<%s >",
					new Util().commaSeparate(elementCppTypeNames)));
		}

		throw new AssertionError(String.format("unkonw type '%s'", t));
	}

	public String symbol(Type t) {
		return "_" + t.getTypeId().replaceAll("\\.|<|>|,|\\[|\\]", "_");
	}
}
