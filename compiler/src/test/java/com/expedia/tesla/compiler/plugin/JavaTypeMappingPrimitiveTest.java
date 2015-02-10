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
 * Telsa Java primitive type mapping tests.
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 *
 */
public class JavaTypeMappingPrimitiveTest {
	
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
	public void testByte() throws Exception {
		test("byte", "byte", "byte");
		test("nullable<byte>", "java.lang.Byte", "java.lang.Byte");
	}
	
	@Test
	public void testInt16() throws Exception {
		test("int16", "short", "short");
		test("nullable<int16>", "java.lang.Short", "java.lang.Short");
	}
	
	@Test
	public void testInt32() throws Exception {
		test("int32", "int", "int");
		test("nullable<int32>", "java.lang.Integer", "java.lang.Integer");
	}
	
	@Test
	public void testUInt32() throws Exception {
		test("uint32", "int", "int");
		test("nullable<uint32>", "java.lang.Integer", "java.lang.Integer");
	}
	
	@Test
	public void testInt64() throws Exception {
		test("int64", "long", "long");
		test("nullable<int64>", "java.lang.Long", "java.lang.Long");
	}
	
	@Test
	public void testUInt64() throws Exception {
		test("uint64", "long", "long");
		test("nullable<uint64>", "java.lang.Long", "java.lang.Long");
	}
	
	@Test
	public void testFloat() throws Exception {
		test("float", "float", "float");
		test("nullable<float>", "java.lang.Float", "java.lang.Float");
	}
	
	@Test
	public void testDouble() throws Exception {
		test("double", "double", "double");
		test("nullable<double>", "java.lang.Double", "java.lang.Double");
	}
	
	@Test
	public void testString() throws Exception {
		test("string", "java.lang.String", "java.lang.String");
		test("nullable<string>", "java.lang.String", "java.lang.String");
	}
	
	@Test
	public void testBinary() throws Exception {
		test("binary", "byte[]", "byte[]");
		test("nullable<binary>", "byte[]", "byte[]");
	}
}