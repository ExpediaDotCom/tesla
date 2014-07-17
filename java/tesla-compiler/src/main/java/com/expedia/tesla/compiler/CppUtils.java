/**
 *
 * CppUtils.javas
 *
 * Copyright 2013 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.tesla.compiler;

import com.expedia.tesla.schema.Field;
import com.expedia.tesla.schema.Primitive;
import com.expedia.tesla.schema.Type;
import com.expedia.tesla.schema.Class;
import com.expedia.tesla.schema.Enum;

/**
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 * 
 */
public class CppUtils extends Util {
	public String getTeslaTypeTag(Field field) {
		String tag = "TeslaType_";
		Type type = field.getType();
		if (type instanceof Primitive) {
			tag += ((Primitive) type).getName();
		} else if (type instanceof Class) {
			tag += "Object";
		} else if (type instanceof Enum) {
			tag += "Enum";
		}

		if (field.getIsReference()) {
			tag += "Reference";
		}

		if (field.getIsArray()) {
			tag += "Array";
			if (field.getRank() > 1) {
				tag += field.getRank() + "D";
			}
		}

		if (field.getIsOptional()) {
			tag += "Nullable";
		}

		return tag;
	}
}
