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

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.expedia.tesla.SchemaVersion;
import com.expedia.tesla.compiler.test.Serializer;
import com.expedia.tesla.compiler.test.Serializer.ObjectReader;
import com.expedia.tesla.compiler.test.Serializer.ObjectWriter;
import com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference;
import com.expedia.tesla.compiler.test.passcompile.full.versioningtest.*;
import com.expedia.tesla.serialization.TeslaDeserializationException;
import com.expedia.tesla.serialization.TeslaSerializationException;

/**
 * Test Tesla serialization versioning.
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 */
public class VersioningTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testBinaryDeserializationNoDefinition() throws Exception {
		thrown.expect(TeslaDeserializationException.class);
		thrown.expectMessage("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference' is not defined in current schema.");

		ObjectReference obj = new ObjectReference();
		InputStream is = new ByteArrayInputStream("{}".getBytes());
		ObjectReader reader = Serializer.newJsonReader(Serializer.VERSION_TESLACOMPILER_ALL_TYPES_V1_0, is);
		reader.read(obj);
	}

	@Test
	public void testJsonDeserializationNoDefinition() throws Exception {
		thrown.expect(TeslaDeserializationException.class);
		thrown.expectMessage("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference' is not defined in current schema.");

		ObjectReference obj = new ObjectReference();
		InputStream is = new ByteArrayInputStream("{}".getBytes());
		ObjectReader reader = Serializer.newJsonReader(
				Serializer.VERSION_TESLACOMPILER_ALL_TYPES_V1_0, is);
		reader.read(obj);
	}

	@Test
	public void testBinarySerializationNoDefinition() throws Exception {
		thrown.expect(TeslaSerializationException.class);
		thrown.expectMessage("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference' is not defined in current schema.");

		ObjectReference obj = new ObjectReference();
		ObjectWriter writer = Serializer.newBinaryWriter(Serializer.VERSION_TESLACOMPILER_ALL_TYPES_V1_0,
				new ByteArrayOutputStream());
		writer.write(obj);
	}

	@Test
	public void testJsonSerializationNoDefinition() throws Exception {
		thrown.expect(TeslaSerializationException.class);
		thrown.expectMessage("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference' is not defined in current schema.");

		ObjectReference obj = new ObjectReference();
		ObjectWriter writer = Serializer.newJsonWriter(Serializer.VERSION_TESLACOMPILER_ALL_TYPES_V1_0,
				new ByteArrayOutputStream());
		writer.write(obj);
	}
	
	private VersionedObject versioningRoundTripSerailization(VersionedObject obj, SchemaVersion ver, String encoding) 
			throws Exception {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		switch (encoding) {
			case "binary": 
				Serializer.newBinaryWriter(ver, os).write(obj);
				return Serializer.newBinaryReader(ver, 
						new ByteArrayInputStream(os.toByteArray())).read((VersionedObject) null);
			case "json":
				Serializer.newJsonWriter(ver, os).write(obj);
				return Serializer.newJsonReader(ver, 
						new ByteArrayInputStream(os.toByteArray())).read((VersionedObject) null);
			default:
				throw new AssertionError("Unexpected encoding.");
		}
	}

	@Test
	public void testBinarySerializationEnumVersionOld() throws Exception {
		VersionedObject obj = new VersionedObject();
		obj.setEnumField(VersionedEnum.Value3);
		assertEquals(obj, versioningRoundTripSerailization(
				obj, Serializer.VERSION_VERSIONING_TEST_V1_0, "binary"));
	}
	
	@Test
	public void testBinarySerializationEnumVersionNew() throws Exception {
		VersionedObject obj = new VersionedObject();
		obj.setEnumField(VersionedEnum.Value4);

		assertEquals(obj, versioningRoundTripSerailization(
				obj, Serializer.VERSION_VERSIONING_TEST_V2_0, "binary"));
	}
	
	@Test
	public void testBinarySerializationEnumVersionUseNewValueInOldVersion() throws Exception {
		thrown.expect(TeslaSerializationException.class);
		thrown.expectMessage("is not allowed");
		
		VersionedObject obj = new VersionedObject();
		obj.setEnumField(VersionedEnum.Value4);

		versioningRoundTripSerailization(obj, Serializer.VERSION_VERSIONING_TEST_V1_0, "binary");
	}
	
	@Test
	public void testBinarySerializationEnumVersionUseRemovedValue() throws Exception {
		thrown.expect(TeslaSerializationException.class);
		thrown.expectMessage("is not allowed");
		
		VersionedObject obj = new VersionedObject();
		obj.setEnumField(VersionedEnum.Value3);

		versioningRoundTripSerailization(obj, Serializer.VERSION_VERSIONING_TEST_V2_0, "binary");
	}

	@Test
	public void testJsonSerializationEnumVersionOld() throws Exception {
		VersionedObject obj = new VersionedObject();
		obj.setEnumField(VersionedEnum.Value3);
		assertEquals(obj, versioningRoundTripSerailization(
				obj, Serializer.VERSION_VERSIONING_TEST_V1_0, "json"));
	}
	
	@Test
	public void testJsonSerializationEnumVersionNew() throws Exception {
		VersionedObject obj = new VersionedObject();
		obj.setEnumField(VersionedEnum.Value4);

		assertEquals(obj, versioningRoundTripSerailization(
				obj, Serializer.VERSION_VERSIONING_TEST_V2_0, "json"));
	}
	
	@Test
	public void testJsonSerializationEnumVersionUseNewValueInOldVersion() throws Exception {
		thrown.expect(TeslaSerializationException.class);
		thrown.expectMessage("is not allowed");
		
		VersionedObject obj = new VersionedObject();
		obj.setEnumField(VersionedEnum.Value4);

		versioningRoundTripSerailization(obj, Serializer.VERSION_VERSIONING_TEST_V1_0, "json");
	}
	
	@Test
	public void testJsonSerializationEnumVersionUseRemovedValue() throws Exception {
		thrown.expect(TeslaSerializationException.class);
		thrown.expectMessage("is not allowed");
		
		VersionedObject obj = new VersionedObject();
		obj.setEnumField(VersionedEnum.Value3);

		versioningRoundTripSerailization(obj, Serializer.VERSION_VERSIONING_TEST_V2_0, "json");
	}
	

	@Test
	public void testBinarySerializationObjectVersionOld() throws Exception {
		VersionedObject obj = new VersionedObject();
		obj.setDepricatedInt32Field(12909);
		assertEquals(obj, versioningRoundTripSerailization(
				obj, Serializer.VERSION_VERSIONING_TEST_V1_0, "binary"));
	}
	
	@Test
	public void testBinarySerializationObjectVersionNew() throws Exception {
		VersionedObject obj = new VersionedObject();
		obj.setNewInt64Field(123421L);

		assertEquals(obj, versioningRoundTripSerailization(
				obj, Serializer.VERSION_VERSIONING_TEST_V2_0, "binary"));
	}
	
	@Test
	public void testBinarySerializationObjectVersionUseNewValueInOldVersion() throws Exception {
		
		VersionedObject obj = new VersionedObject();
		obj.setNewInt64Field(1L);

		assertEquals(null, versioningRoundTripSerailization(obj, 
				Serializer.VERSION_VERSIONING_TEST_V1_0, "binary").getNewInt64Field());
	}
	
	@Test
	public void testBinarySerializationObjectVersionUseRemovedValue() throws Exception {
		VersionedObject obj = new VersionedObject();
		obj.setDepricatedInt32Field(1);

		assertEquals(null, versioningRoundTripSerailization(obj, 
				Serializer.VERSION_VERSIONING_TEST_V2_0, "binary").getDepricatedInt32Field());
	}

	@Test
	public void testJsonSerializationObjectVersionOld() throws Exception {
		VersionedObject obj = new VersionedObject();
		obj.setDepricatedInt32Field(241901);
		assertEquals(obj, versioningRoundTripSerailization(
				obj, Serializer.VERSION_VERSIONING_TEST_V1_0, "json"));
	}
	
	@Test
	public void testJsonSerializationObjectVersionNew() throws Exception {
		VersionedObject obj = new VersionedObject();
		obj.setNewInt64Field(242341223412L);

		assertEquals(obj, versioningRoundTripSerailization(
				obj, Serializer.VERSION_VERSIONING_TEST_V2_0, "json"));
	}
	
	@Test
	public void testJsonSerializationObjectVersionUseNewValueInOldVersion() throws Exception {
		VersionedObject obj = new VersionedObject();
		obj.setNewInt64Field(1L);

		assertEquals(null, versioningRoundTripSerailization(
				obj, Serializer.VERSION_VERSIONING_TEST_V1_0, "json").getNewInt64Field());
	}
	
	@Test
	public void testJsonSerializationObjectVersionUseRemovedValue() throws Exception {
		
		VersionedObject obj = new VersionedObject();
		obj.setDepricatedInt32Field(1);

		assertEquals(null, versioningRoundTripSerailization(
				obj, Serializer.VERSION_VERSIONING_TEST_V2_0, "json").getDepricatedInt32Field());
	}
}
