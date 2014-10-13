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
package com.expedia.tesla.schema;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.SAXException;

public class SchemaTest {

	@Test
	public void schemaSmokeTest() throws URISyntaxException,
			TeslaSchemaException, NoSuchAlgorithmException, SAXException,
			IOException, ParserConfigurationException {
		Schema schema = parseSchema("src/test/resources/smoke.tml");
		Assert.assertNotNull(schema);
		Assert.assertTrue(schema.getVersion().getVersionNumber() == 0);
	}

	@Test
	public void schemaVersionNameTest() throws URISyntaxException,
			TeslaSchemaException, NoSuchAlgorithmException, SAXException,
			IOException, ParserConfigurationException {
		Schema schema = parseSchema("src/test/resources/versionname.tml");
		Assert.assertNotNull(schema);
		Assert.assertTrue(schema.getVersion().getName()
				.contains("#versionname#"));
	}

	@Test
	public void schemaVersionNumberTest() throws URISyntaxException,
			TeslaSchemaException, NoSuchAlgorithmException, SAXException,
			IOException, ParserConfigurationException {
		Schema schema = parseSchema("src/test/resources/versionnumber.tml");
		Assert.assertNotNull(schema);
		Assert.assertTrue(schema.getVersion().getVersionNumber() > 1);
	}

	@Test
	public void schemaNamespaceTest() throws URISyntaxException,
			TeslaSchemaException, NoSuchAlgorithmException, SAXException,
			IOException, ParserConfigurationException {
		Schema schema = parseSchema("src/test/resources/namespace.tml");
		Assert.assertNotNull(schema);
		Assert.assertEquals("My", schema.getUserTypes().iterator().next()
				.getNameSpace());
	}

	@Test
	public void schemaClassTest() throws URISyntaxException,
			TeslaSchemaException, NoSuchAlgorithmException, SAXException,
			IOException, ParserConfigurationException {
		Schema schema = parseSchema("src/test/resources/class.tml");
		UserType[] types = schema.getUserTypes().toArray(new UserType[0]);
		Assert.assertEquals(2, types.length);

		Class teslaClass1 = (Class) schema
				.findType("com.expedia.tesla.automation.component.schema.TeslaClass1");
		Assert.assertNotNull(teslaClass1);
		Assert.assertEquals("com.expedia.tesla.automation.component.schema",
				teslaClass1.getNameSpace());
		Assert.assertTrue(teslaClass1.getName().contains("TeslaClass1"));

		Class teslaClass2 = (Class) schema
				.findType("com.expedia.tesla.automation.component.schema.TeslaClass2");
		Assert.assertNotNull(teslaClass2);
		Assert.assertEquals("com.expedia.tesla.automation.component.schema",
				teslaClass2.getNameSpace());
		Assert.assertTrue(teslaClass2.getName().contains("TeslaClass2"));
	}

	@Test
	public void schemaExtendsClassTest() throws URISyntaxException,
			TeslaSchemaException, NoSuchAlgorithmException, SAXException,
			IOException, ParserConfigurationException {
		Schema schema = parseSchema("src/test/resources/extendsclass.tml");

		com.expedia.tesla.schema.Class extendedClass = (com.expedia.tesla.schema.Class) schema
				.findType("com.expedia.tesla.automation.component.schema.ExtendClass");
		Assert.assertNotNull(extendedClass);
		List<Field> fields = extendedClass.getAllFields();

		Assert.assertEquals(2, fields.size());
	}

	@Test
	public void schemaExtendsMultiClassTest() throws URISyntaxException,
			TeslaSchemaException, NoSuchAlgorithmException, SAXException,
			IOException, ParserConfigurationException {
		Schema schema = parseSchema("src/test/resources/extendsmulticlass.tml");

		com.expedia.tesla.schema.Class extendedClass = (com.expedia.tesla.schema.Class) schema
				.findType("com.expedia.tesla.automation.component.schema.ExtendClass");
		Assert.assertNotNull(extendedClass);
		List<Field> fields = extendedClass.getAllFields();

		Assert.assertEquals(3, fields.size());
	}

	@Test
	public void schemaFieldTest() throws URISyntaxException,
			TeslaSchemaException, NoSuchAlgorithmException, SAXException,
			IOException, ParserConfigurationException {
		Schema schema = parseSchema("src/test/resources/field.tml");
		Collection<UserType> types = schema.getUserTypes();

		String[] expectedFieldNameList = new String[] { "Byte", "Int16",
				"UInt16", "Int32", "UInt32", "Int64", "UInt64", "Boolean",
				"Double", "Binary", "String" };
		Type[] expectedTypeList = new Type[] { Primitive.BYTE, Primitive.INT16,
				Primitive.UINT16, Primitive.INT32, Primitive.UINT32,
				Primitive.INT64, Primitive.UINT64, Primitive.BOOLEAN,
				Primitive.DOUBLE, Primitive.BINARY, Primitive.STRING };
		assert (expectedFieldNameList.length == expectedTypeList.length);

		Assert.assertTrue(types.iterator().next().isClass());
		Class class1 = (Class) types.iterator().next();

		for (int i = 0; i < expectedFieldNameList.length; i++) {
			String fieldName = expectedFieldNameList[i] + "Field";
			Field field = class1.findField(fieldName);
			Assert.assertNotNull(field);
			Assert.assertEquals(fieldName, field.getName());
			Assert.assertEquals(expectedTypeList[i], field.getType());
		}
	}

	@Test
	public void schemaFieldDisplayNameTest() throws URISyntaxException,
			TeslaSchemaException, NoSuchAlgorithmException, SAXException,
			IOException, ParserConfigurationException {
		Schema schema = parseSchema("src/test/resources/fielddisplayname.tml");

		Collection<UserType> types = schema.getUserTypes();

		Assert.assertTrue(types.iterator().next().isClass());
		Class class1 = (Class) types.iterator().next();
		List<Field> fields = class1.getAllFields();
		Assert.assertEquals("FieldDisplayName", fields.get(0).getDisplayName());
	}

	@Test
	public void schemaNullableFieldTest() throws URISyntaxException,
			TeslaSchemaException, NoSuchAlgorithmException, SAXException,
			IOException, ParserConfigurationException {
		Schema schema = parseSchema("src/test/resources/nullablefield.tml");

		Collection<UserType> types = schema.getUserTypes();

		Assert.assertTrue(types.iterator().next().isClass());
		Class class1 = (Class) types.iterator().next();

		Assert.assertTrue(class1.getName().contains("TeslaClass"));

		for (Field field : class1.getAllFields()) {
			Assert.assertTrue(((Field) field).getIsOptional());
		}
	}

	@Test
	public void schemaFieldRankTest() throws URISyntaxException,
			TeslaSchemaException, NoSuchAlgorithmException, SAXException,
			IOException, ParserConfigurationException {
		Schema schema = parseSchema("src/test/resources/fieldrank.tml");

		Collection<UserType> types = schema.getUserTypes();

		Assert.assertTrue(types.iterator().next().isClass());
		Class class1 = (Class) types.iterator().next();
		Assert.assertTrue(class1.getName().contains("TeslaClass"));

		for (Field field : class1.getAllFields()) {
			Assert.assertTrue(((Field) field).getIsArray());
			Assert.assertEquals(2, ((Field) field).getRank());
		}
	}

	@Test
	public void schemaCaseSensitiveClassNameTest() throws URISyntaxException,
			TeslaSchemaException, NoSuchAlgorithmException, SAXException,
			IOException, ParserConfigurationException {
		Schema schema = parseSchema("src/test/resources/casesensitiveclass.tml");
		Assert.assertNotNull(schema);
	}

	@Test
	public void schemaCaseSensitiveFieldsNameTest() throws URISyntaxException,
			TeslaSchemaException, NoSuchAlgorithmException, SAXException,
			IOException, ParserConfigurationException {
		Schema schema = parseSchema("src/test/resources/casesensitivefieldsname.tml");
		Assert.assertNotNull(schema);
	}

	@Test
	public void schemaCaseInsensitiveFieldTypeTest() throws URISyntaxException,
			TeslaSchemaException, NoSuchAlgorithmException, SAXException,
			IOException, ParserConfigurationException {
		Schema schema = parseSchema("src/test/resources/casesinsensitivefieldstype.tml");
		Assert.assertNotNull(schema);
	}

	@Test
	public void schemaSelfRefClassTest() throws URISyntaxException,
			TeslaSchemaException, NoSuchAlgorithmException, SAXException,
			IOException, ParserConfigurationException {
		Schema schema = parseSchema("src/test/resources/selfrefclass.tml");
		Assert.assertNotNull(schema);
	}

	@Test
	public void schemaCircularRefClassTest() throws URISyntaxException,
			TeslaSchemaException, NoSuchAlgorithmException, SAXException,
			IOException, ParserConfigurationException {
		Schema schema = parseSchema("src/test/resources/circularrefclass.tml");
		Assert.assertNotNull(schema);
	}

	@Test
	public void schemaSameFieldNameTypeNameTest() throws URISyntaxException,
			TeslaSchemaException, NoSuchAlgorithmException, SAXException,
			IOException, ParserConfigurationException {
		Schema schema = parseSchema("src/test/resources/samefieldnametypename.tml");
		Assert.assertNotNull(schema);
	}

	@Test
	public void schemaEnumTest() throws Exception {
		Schema schema = parseSchema("src/test/resources/enum.tml");
		Assert.assertNotNull(schema);

		Collection<UserType> types = schema.getUserTypes();

		Assert.assertTrue(types.iterator().next().isEnum());
		Enum enumType = (Enum) types.iterator().next();

		Assert.assertNotNull(enumType);

		List<EnumEntry> enumEntries = enumType.getEntries();
		Assert.assertEquals(3, enumEntries.size());

		for (int i = 0; i < enumEntries.size(); i++) {
			EnumEntry enumEntry = (EnumEntry) enumEntries.get(i);
			Assert.assertTrue(i - 1 == enumEntry.getValue());
		}
	}

	@Test
	public void schemaHashTest() throws Exception {
		// the only difference of these 2 tml is a white space in the end.
		Schema schema = parseSchema("src/test/resources/schemahash1.tml");
		Schema schema2 = parseSchema("src/test/resources/schemahash2.tml");

		Assert.assertNotSame(schema.getVersion().getSchemaHash(), schema2
				.getVersion().getSchemaHash());
	}

	@Test
	public void schemaReferenceTest() throws Exception {
		Schema schema = parseSchema("src/test/resources/reference.tml");
		Assert.assertNotNull(schema);

		Class message = (Class) schema
				.findType("com.expedia.tesla.automation.teslacompiler.reference.Message");
		for (Field member : message.getFields()) {
			Assert.assertTrue(member.getIsReference());
		}
	}

	// Negative Test
	@Test(expected = TeslaSchemaException.class)
	public void schemaVersionNoNameTest() throws Exception {
		Schema schema = parseSchema("src/test/resources/negative/versionnoname.tml");
		Assert.assertNull(schema);
	}

	@Test(expected = TeslaSchemaException.class)
	public void schemaMultipleNamespaceTest() throws Exception {
		Schema schema = parseSchema("src/test/resources/negative/multiplenamespace.tml");
		Assert.assertNull(schema);
	}

	@Test(expected = TeslaSchemaException.class)
	public void schemaUnsupportedFieldTypeTest() throws Exception {
		Schema schema = parseSchema("src/test/resources/negative/unsupportedfieldtype.tml");
		Assert.assertNull(schema);
	}

	@Test(expected = TeslaSchemaException.class)
	public void schemaDuplicateExtendsTest() throws Exception {
		Schema schema = parseSchema("src/test/resources/negative/duplicateextendsclass.tml");
		Assert.assertNull(schema);
	}

	@Test(expected = TeslaSchemaException.class)
	public void schemaNoNamespaceNameTest() throws URISyntaxException,
			TeslaSchemaException, NoSuchAlgorithmException, SAXException,
			IOException, ParserConfigurationException {
		Schema schema = parseSchema("src/test/resources/negative/nonamespacename.tml");
		Assert.assertNull(schema);
	}

	@Test(expected = TeslaSchemaException.class)
	@Ignore("un-supported now")
	public void schemaDiamondExtendsClassTest() throws Exception {
		Schema schema = parseSchema("src/test/resources/diamondextendsclass.tml");
		Assert.assertNull(schema);
	}

	@Test(expected = TeslaSchemaException.class)
	public void schemaDuplicatedEnumValueTest() throws Exception {
		parseSchema("src/test/resources/negative/duplicated_enum_entry.tml");
	}

	@Test(expected = TeslaSchemaException.class)
	public void schemaDuplicatedClassFieldTest() throws Exception {
		parseSchema("src/test/resources/negative/duplicated_class_field.tml");
	}
	
	private Schema parseSchema(String tmlPath) throws TeslaSchemaException,
			IOException {
		return TmlProcessor.build(tmlPath);
	}

}
