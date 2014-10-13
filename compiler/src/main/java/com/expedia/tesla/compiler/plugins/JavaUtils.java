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

import org.apache.commons.lang.StringEscapeUtils;

import com.expedia.tesla.compiler.Util;
import com.expedia.tesla.schema.Enum;
import com.expedia.tesla.schema.Field;
import com.expedia.tesla.schema.Primitive;
import com.expedia.tesla.schema.TeslaSchemaException;

/**
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 * 
 */
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
