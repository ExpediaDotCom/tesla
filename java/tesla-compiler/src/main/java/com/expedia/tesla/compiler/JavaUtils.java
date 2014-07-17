/**
 *
 * JavaUtils.java
 *
 * Copyright 2013 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.tesla.compiler;

import org.apache.commons.lang.StringEscapeUtils;

import com.expedia.tesla.compiler.plugins.JavaTypeMapper;
import com.expedia.tesla.schema.Enum;
import com.expedia.tesla.schema.Field;
import com.expedia.tesla.schema.Primitive;
import com.expedia.tesla.schema.TeslaSchemaException;

/**
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 * 
 */
@Deprecated
public class JavaUtils extends Util {
	JavaTypeMapper typeMapper = new JavaTypeMapper();

	public String getJavaTypeName(Field field) throws TeslaSchemaException {
		return typeMapper.getTypeDescriptor(field.getType()).getInterfaceName();
	}

	public String getWriteMethod(Field field) {
		String method = "writeObject";
		if (field.getType() instanceof Primitive) {
			method = "write"
					+ firstCharUpperCase(((Primitive) field.getType())
							.getName());
		} else if (field.getType() instanceof Enum) {
			method = "writeEnum";
		}

		if (field.getRank() > 0) {
			method += "Array";
		}
		return method;
	}

	public String getReadMethod(Field field) {
		String method = "readObject";
		if (field.getType() instanceof Primitive) {
			method = "read"
					+ firstCharUpperCase(((Primitive) field.getType())
							.getName());
		} else if (field.getType() instanceof Enum) {
			method = "readEnum";
		}

		if (field.getRank() > 0) {
			method += "Array";
		}
		return method;
	}

	public String escapeStringLiteral(String str) {
		return '\"' + StringEscapeUtils.escapeJava(str) + '\"';
	}

	public String escapeMultiLineStringLiteral(String str) {
		StringBuilder sb = new StringBuilder();
		String[] lines = str.split("\\r?\\n");
		for (String line : lines) {
			if (sb.length() > 0) {
				sb.append(" +\n");
			}
			sb.append(escapeStringLiteral(line));
		}
		return sb.toString();
	}
}
