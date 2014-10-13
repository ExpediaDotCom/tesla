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

package com.expedia.tesla.compiler.serialization;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.junit.Test;

import com.expedia.tesla.compiler.test.Serializer;
import com.expedia.tesla.compiler.test.Serializer.ObjectReader;
import com.expedia.tesla.compiler.test.Serializer.ObjectWriter;
import com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject;
import com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject;
import com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject;
import com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject;
import com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject;
import com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject;

/**
 * Test binary serialization of basic and composite types.
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 */
public class AllTypesTest {

	@Test
	public void testBasicTestObjectRoundTrip() throws Exception {
		BasicTestObject obj = createTestObject().getBasicTestObjectField();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		createBinaryWriter(os).write(obj);
		BasicTestObject objCopy = createBinaryReader(os.toByteArray()).read((BasicTestObject)null);
		
		assertTrue(obj.equals(objCopy));
	}
	
	@Test
	public void testBinaryBasicReferenceRoundTrip() throws Exception {
		ReferenceTestObject obj = createTestObject().getReferenceTestObjectField();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		createBinaryWriter(os).write(obj);
		ReferenceTestObject objCopy = createBinaryReader(os.toByteArray()).read((ReferenceTestObject)null);
		
		assertTrue(obj.equals(objCopy));
	}

	@Test
	public void testBinaryOptionalRoundTrip() throws Exception {
		OptionalBasicTestObject obj = createTestObject().getOptionalBasicTestObjectField();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		createBinaryWriter(os).write(obj);
		OptionalBasicTestObject objCopy = createBinaryReader(os.toByteArray()).read((OptionalBasicTestObject)null);
		
		assertTrue(obj.equals(objCopy));
	}
	
	@Test
	public void testArrayRoundTrip() throws Exception {
		ArrayTestObject obj = createTestObject().getArrayTestObjectField();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		createBinaryWriter(os).write(obj);
		ArrayTestObject objCopy = createBinaryReader(os.toByteArray()).read((ArrayTestObject)null);
		
		assertTrue(obj.equals(objCopy));
	}
	
	@Test
	public void test2DArrayRoundTrip() throws Exception {
		Array2DTestObject obj = createTestObject().getArray2DTestObjectField();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		createBinaryWriter(os).write(obj);
		Array2DTestObject objCopy = createBinaryReader(os.toByteArray()).read((Array2DTestObject)null);
		
		assertTrue(obj.equals(objCopy));
	}

	private ObjectWriter createBinaryWriter(ByteArrayOutputStream os) throws Exception {
		ObjectWriter writer = Serializer.newBinaryWriter(Serializer.VERSION_TESLACOMPILER_ALL_TYPES_V1_0, os);
		return writer;
	}
	
	private ObjectReader createBinaryReader(byte[] buffer) throws Exception {
		InputStream is = new ByteArrayInputStream(buffer);
		ObjectReader reader = Serializer.newBinaryReader(Serializer.VERSION_TESLACOMPILER_ALL_TYPES_V1_0, is);
		return reader;
	}

	@Test
	public void testBinaryAllRoundTrip() throws Exception {
		TestObject obj = createTestObject();
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ObjectWriter writer = Serializer.newBinaryWriter(Serializer.VERSION_TESLACOMPILER_ALL_TYPES_V1_0, os);
		writer.write(obj);
		
		InputStream is = new ByteArrayInputStream(os.toByteArray());
		ObjectReader reader = Serializer.newBinaryReader(Serializer.VERSION_TESLACOMPILER_ALL_TYPES_V1_0, is);
		TestObject objCopy = null;
		objCopy = reader.read(objCopy);
		
		assertTrue(obj.equals(objCopy));
	}

	@Test
	public void testJsonRoundTrip() throws Exception {
		TestObject obj = createTestObject();
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ObjectWriter writer = Serializer.newJsonWriter(Serializer.VERSION_TESLACOMPILER_ALL_TYPES_V1_0, os);
		writer.write(obj);
		
		InputStream is = new ByteArrayInputStream(os.toByteArray());
		ObjectReader reader = Serializer.newJsonReader(Serializer.VERSION_TESLACOMPILER_ALL_TYPES_V1_0, is);
		TestObject objCopy = null;
		objCopy = reader.read(objCopy);
		
		assertTrue(obj.equals(objCopy));
	}
	
	private TestObject createTestObject() throws Exception {
		TestObject obj = new TestObject();
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(
				"passcompile/full/all_types_test_object.json");
		ObjectReader reader = Serializer.newJsonReader(Serializer.VERSION_TESLACOMPILER_ALL_TYPES_V1_0, is);
		reader.read(obj);
		return obj;
	}
	
}
