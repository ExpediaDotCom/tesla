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
import java.io.InputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.expedia.tesla.compiler.test.Serializer;
import com.expedia.tesla.compiler.test.Serializer.ObjectReader;
import com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference;
import com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference;
import com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference;
import com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference;
import com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray;
import com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference;
import com.expedia.tesla.serialization.TeslaDeserializationException;

/**
 * Test reference serialization of basic and composite types.
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 */
public class ReferenceTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testNoDefinition() throws Exception {
		thrown.expect(TeslaDeserializationException.class);
		thrown.expectMessage("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference' is not defined in current schema.");

		ObjectReference obj = new ObjectReference();
		InputStream is = new ByteArrayInputStream("{}".getBytes());
		ObjectReader reader = Serializer.newJsonReader(
				Serializer.VERSION_TESLACOMPILER_ALL_TYPES_V1_0, is);
		reader.read(obj);
	}

	private ObjectReader createReader(String valueJson) throws Exception {
		InputStream is = new ByteArrayInputStream(
				String.format(
						"{\"ReferenceField1\": {\"@id\": 1, \"@value\": %s},\"ReferenceField2\": {\"@reference\": 1}}",
						valueJson).getBytes());
		return Serializer.newJsonReader(
				Serializer.VERSION_TESLACOMPILER_REFERENCE_TEST_V1_0, is);
	}

	@Test
	public void testObjectReference() throws Exception {
		ObjectReference obj = createReader("{ \"IntField\": 123 }").read(
				(ObjectReference) null);
		assertTrue(obj.getReferenceField1() == obj.getReferenceField2());
	}

	@Test
	public void testEnumReference() throws Exception {
		EnumReference obj = createReader("\"Info\"").read((EnumReference) null);
		assertTrue(obj.getReferenceField1() == obj.getReferenceField2());
	}

	@Test
	public void testInt32Reference() throws Exception {
		Int32Reference obj = createReader("12345").read((Int32Reference) null);
		assertTrue(obj.getReferenceField1().equals(obj.getReferenceField2()));
	}

	@Test
	public void testStringReference() throws Exception {
		StringReference obj = createReader("\"test string\"").read(
				(StringReference) null);
		assertTrue(obj.getReferenceField1() == obj.getReferenceField2());
	}

	@Test
	public void testBinaryReference() throws Exception {
		BinaryReference obj = createReader("\"T\"")
				.read((BinaryReference) null);
		assertTrue(obj.getReferenceField1() == obj.getReferenceField2());
	}

	@Test
	public void testReferenceArray() throws Exception {
		String json = "{\"ReferenceArrayField\": [{\"@id\": 1, \"@value\": { \"IntField\": 123 }},{\"@reference\": 1}]}";
		InputStream is = new ByteArrayInputStream(json.getBytes());
		ReferenceArray obj = Serializer.newJsonReader(
				Serializer.VERSION_TESLACOMPILER_REFERENCE_TEST_V1_0, is).read(
				(ReferenceArray) null);
		assertTrue(obj.getReferenceArrayField().get(0) == obj
				.getReferenceArrayField().get(1));
	}

}
