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

import com.expedia.tesla.compiler.Util;
import com.expedia.tesla.schema.Class;
import com.expedia.tesla.schema.Enum;
import com.expedia.tesla.schema.Field;
import com.expedia.tesla.schema.Primitive;
import com.expedia.tesla.schema.Type;

/**
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 * 
 */
public class CppUtils extends Util {
	
	
	public String getTeslaTypeTag(Field field) {
		StringBuilder tagBuilder = new StringBuilder("TeslaType_");
		Type type = field.getType();
		if (type instanceof Primitive) {
			tagBuilder.append(((Primitive) type).getName());
		} else if (type instanceof Class) {
			tagBuilder.append("Object");
		} else if (type instanceof Enum) {
			tagBuilder.append("Enum");
		}

		if (field.getIsReference()) {
			tagBuilder.append("Reference");
		}

		if (field.getIsArray()) {
			tagBuilder.append("Array");
			if (field.getRank() > 1) {
				tagBuilder.append(field.getRank());
				tagBuilder.append("D");
			}
		}

		if (field.getIsOptional()) {
			tagBuilder.append("Nullable");
		}

		return tagBuilder.toString();
	}
}
