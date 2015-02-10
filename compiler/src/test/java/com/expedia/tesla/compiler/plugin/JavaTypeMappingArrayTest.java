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

package com.expedia.tesla.compiler.plugin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.expedia.tesla.compiler.plugins.JavaTypeDescriptor;
import com.expedia.tesla.compiler.plugins.JavaTypeMapper;
import com.expedia.tesla.schema.Schema.SchemaBuilder;
import com.expedia.tesla.schema.TeslaSchemaException;
import com.expedia.tesla.schema.Type;


/**
 * Telsa Java array/collection type mapping tests.
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 *
 */
public class JavaTypeMappingArrayTest {
	
	JavaTypeMapper mapper;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() {
		mapper = new JavaTypeMapper();
	}
	
	private Type simpleTypeFromId(String id) throws TeslaSchemaException {
		SchemaBuilder sb = new SchemaBuilder();
		return sb.addType(id);
	}
	
	private void test(String id, String expectedInterfaceName, String expectedActualTypeName) throws Exception {
		JavaTypeDescriptor desc = mapper.getTypeDescriptor(simpleTypeFromId(id));
		assertEquals(expectedInterfaceName, desc.getInterfaceName());
		assertEquals(expectedActualTypeName, desc.getActualTypeName());
	}
	
	@Test
	public void testArray() throws Exception {
		test("array<byte>", "java.util.List<java.lang.Byte>", "java.util.ArrayList<java.lang.Byte>");
	}
	
	@Test
	public void testArrayList() throws Exception {
		test("array[java.util.ArrayList]<int16>", 
				"java.util.ArrayList<java.lang.Short>", "java.util.ArrayList<java.lang.Short>");
	}
	
	@Test
	public void testListLinkedList() throws Exception {
		test("array[java.util.List,java.util.LinkedList]<int32>", 
				"java.util.List<java.lang.Integer>", "java.util.LinkedList<java.lang.Integer>");
	}
	
	@Test
	public void testCollectionArrayList() throws Exception {
		test("array[java.util.Collection,java.util.ArrayList]<int32>", 
				"java.util.Collection<java.lang.Integer>", "java.util.ArrayList<java.lang.Integer>");
	}
	
	
}