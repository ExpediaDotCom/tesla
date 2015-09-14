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

import java.util.Map;
import java.util.TreeMap;

import com.expedia.tesla.compiler.Util;
import com.expedia.tesla.schema.Array;
import com.expedia.tesla.schema.Field;
import com.expedia.tesla.schema.Nullable;
import com.expedia.tesla.schema.Primitive;
import com.expedia.tesla.schema.Reference;
import com.expedia.tesla.schema.Type;
import com.expedia.tesla.schema.UserType;

/**
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 * 
 */
public class CSharpUtils extends Util {

	private static Map<String, String> typeMap = new TreeMap<String, String>();

	static {
		typeMap.put(Primitive.BYTE.getName(), "byte");
		typeMap.put(Primitive.INT16.getName(), "short");
		typeMap.put(Primitive.INT32.getName(), "int");
		typeMap.put(Primitive.INT64.getName(), "long");
		typeMap.put(Primitive.UINT16.getName(), "ushort");
		typeMap.put(Primitive.UINT32.getName(), "uint");
		typeMap.put(Primitive.UINT64.getName(), "ulong");
		typeMap.put(Primitive.BOOLEAN.getName(), "bool");
		typeMap.put(Primitive.FLOAT.getName(), "float");
		typeMap.put(Primitive.DOUBLE.getName(), "double");
		typeMap.put(Primitive.STRING.getName(), "string");
		typeMap.put(Primitive.BINARY.getName(), "byte[]");
	}

	private String getCSharpFieldTypeName(Field field) {
		Type type = field.getType();
		return getTypeName(type);
	}

	private String getTypeName(Type type) {
		if (type.isPrimitive()) {
			return typeMap.get(((Primitive) type).getName());
		} else if (type.isUserType()) {
			return ((UserType) type).getName();
		} else if (type.isArray()) {
			return getTypeName(((Array) type).getElementType());
		} else if (type.isNullable()) {
			return getTypeName(((Nullable) type).getElementType());
		} else if (type.isReference()) {
			return getTypeName(((Reference) type).getElementType());
		} else {
			throw new RuntimeException("Unable to map type " + type.getTypeId());
		}
	}

	public String getCSharpTypeName(Field field) {
		String elementType = getCSharpFieldTypeName(field);

		return getCSharpListType(elementType, field.getRank());
	}

	public String getCSharpListType(String typeName, int rank) {
		if (rank < 1) {
			return typeName;
		} else if (rank == 1) {
			return String.format("List<%s>", typeName);
		} else {
			return String.format("List<%s>", getCSharpListType(typeName, rank - 1));
		}
	}
	
	public String getWriteMethod(Field field) {
		Type fieldType = field.getType();
		Type elementType = getElementType(fieldType);
		String genericType = "<" + getCSharpFieldTypeName(field) + ">";
		
		// C# runtime library doesn't have poly, map and reference support yet.
		if (!fieldType.isArray()) {
			return "Write" + (fieldType.isEnum() ? genericType : "");
		} else {
			if (elementType.isPrimitive()) {
				return "Write" + camelize((Primitive)elementType) + "Array";
			} else if (elementType.isEnum()) {
				return "WriteEnumArray" + genericType;
			} else if (elementType.isClass()){
				return "WriteObjectArray" + genericType;
			} else {
				return "WriteUnsupportedTypeArray";
			}
		}
	}

	public String getReadMethod(Field field) {
		String method = "Read";
		
		Type fieldType = field.getType();
		Type elementType = getElementType(fieldType);

		// C# runtime library doesn't have poly, map and reference support yet.
		if (elementType.isPrimitive()) {
			method += camelize((Primitive)elementType);
		} else if (elementType.isEnum()) {
			method += "Enum";
		} else if (elementType.isClass()) {
			method += "Object"; 
		} else {
			method += "UnsupportedType";
		}

		if (fieldType.isArray()) {
			method += "Array";
		}

		if (elementType.isEnum() || elementType.isClass()) {
			method += "<" + getCSharpFieldTypeName(field) + ">";
		}
		return method;
	}

	private String camelize(Primitive type) {
		String tn = type.getName();
		int cc = tn.startsWith("u", 0) ? 2 : 1;
		return tn.substring(0, cc).toUpperCase() + tn.substring(cc); 
	}
	
	public Type getElementType(Type type) {
		if (type.isArray()) return getElementType(((Array)type).getElementType());
		if (type.isNullable()) return getElementType(((Nullable)type).getElementType());
		if (type.isReference()) return getElementType(((Reference)type).getElementType());
		return type;
	}

}
