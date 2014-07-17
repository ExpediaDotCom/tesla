package com.expedia.tesla.schema.tml.v2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.expedia.tesla.SchemaVersion;
import com.expedia.tesla.schema.Array;
import com.expedia.tesla.schema.Class;
import com.expedia.tesla.schema.Enum;
import com.expedia.tesla.schema.EnumEntry;
import com.expedia.tesla.schema.Map;
import com.expedia.tesla.schema.Nullable;
import com.expedia.tesla.schema.Poly;
import com.expedia.tesla.schema.Primitive;
import com.expedia.tesla.schema.Reference;
import com.expedia.tesla.schema.Schema;
import com.expedia.tesla.schema.TeslaSchemaException;
import com.expedia.tesla.schema.Type;

public class TmlProcessorTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void parseSuccess() throws Exception {
		List<Object> types = TmlProcessor
				.load("src/test/resources/example-v2.tml");
		Schema schema = TmlProcessor.build(types, new SchemaVersion(0));

		Class person = (Class) schema
				.findType("class<com.expedia.tesla.example.Person>");
		assertNotNull(person);

		assertEquals(Primitive.STRING, person.findField("Name").getType());

		Primitive pbyte = (Primitive) schema.findType("byte");
		assertEquals(Primitive.BYTE, pbyte);
		Nullable nullableByte = (Nullable) schema.findType("nullable<byte>");
		assertEquals(pbyte, nullableByte.getElementType());

		assertEquals(nullableByte, person.findField("Age").getType());

		Enum sex = (Enum) schema.findType("enum<org.tesla.example.Sex>");
		assertNotNull(sex);

		assertEquals(sex, person.findField("Sex").getType());

		Class contact = (Class) schema
				.findType("class<com.expedia.tesla.example.Contact>");
		assertNotNull(contact);
		Array contactArray = (Array) schema
				.findType("array<class<com.expedia.tesla.example.Contact>>");
		assertNotNull(contactArray);
		assertEquals(contact, contactArray.getElementType());

		assertEquals(contactArray, person.findField("Contacts").getType());

		List<EnumEntry> sexValues = sex.getEntries();
		assertEquals(2, sexValues.size());
		assertEquals("Male", sexValues.get(0).getName());
		assertEquals("Female", sexValues.get(1).getName());
		assertEquals(1, sexValues.get(0).getValue());
		assertEquals(2, sexValues.get(1).getValue());

		Class employee = (Class) schema
				.findType("class<com.expedia.tesla.example.Employee>");
		assertNotNull(employee);
		assertEquals(person, employee.getBases().get(0));

		assertEquals(Primitive.STRING, employee.findField("Title").getType());
	}

	private Class loadBasicWrapperClass() throws Exception {
		List<Object> types = TmlProcessor
				.load("src/test/resources/basic_types.tml");
		Schema schema = TmlProcessor.build(types, new SchemaVersion(0));
		Class clss = (Class) schema
				.findType("class<com.expedia.tesla.example.WrapperClass>");
		assertNotNull(clss);
		return clss;
	}

	@Test
	public void primitiveTypes() throws Exception {
		Class clss = loadBasicWrapperClass();
		assertEquals("byte", clss.findField("byteField").getType().getTypeId());
		assertEquals("int16", clss.findField("int16Field").getType()
				.getTypeId());
		assertEquals("int32", clss.findField("int32Field").getType()
				.getTypeId());
		assertEquals("int64", clss.findField("int64Field").getType()
				.getTypeId());
		assertEquals("uint16", clss.findField("uint16Field").getType()
				.getTypeId());
		assertEquals("uint32", clss.findField("uint32Field").getType()
				.getTypeId());
		assertEquals("uint64", clss.findField("uint64Field").getType()
				.getTypeId());
		assertEquals("boolean", clss.findField("booleanFeild").getType()
				.getTypeId());
		assertEquals("float", clss.findField("floatField").getType()
				.getTypeId());
		assertEquals("double", clss.findField("doubleField").getType()
				.getTypeId());
		assertEquals("string", clss.findField("stringField").getType()
				.getTypeId());
		assertEquals("binary", clss.findField("binaryField").getType()
				.getTypeId());
	}

	@Test
	public void arrayTypes() throws Exception {
		Class clss = loadBasicWrapperClass();
		assertEquals("array<int32>", clss.findField("intArray1").getType()
				.getTypeId());
		assertEquals("array<int32>", clss.findField("intArray2").getType()
				.getTypeId());
		assertEquals("array<array<int32>>", clss.findField("int2DArray1")
				.getType().getTypeId());
		assertEquals("array<array<int32>>", clss.findField("int2DArray2")
				.getType().getTypeId());
	}

	@Test
	public void mapTypes() throws Exception {
		Class clss = loadBasicWrapperClass();
		assertEquals("map<string,double>", clss.findField("mapStringDouble")
				.getType().getTypeId());
		assertEquals(
				"map<string,class<com.expedia.tesla.example.WrapperClass>>",
				clss.findField("mapStringWrapperClass").getType().getTypeId());
	}

	@Test
	public void reference() throws Exception {
		Class clss = loadBasicWrapperClass();
		assertEquals("reference<binary>", clss.findField("bianryReference")
				.getType().getTypeId());
	}

	@Test
	public void nestedTypes() throws Exception {
		Class clss = loadBasicWrapperClass();
		Nullable type1 = (Nullable) clss.findField("nested").getType();
		assertEquals(
				"nullable<reference<array[java.util.List,java.util.ArrayList]<map<class<com.expedia.tesla.example.WrapperClass>,reference<poly<class<com.expedia.tesla.example.WrapperClass>,int32,double,string,binary>>>>>>",
				type1.getTypeId());
		Reference type2 = (Reference) type1.getElementType();
		Array type3 = (Array) type2.getElementType();
		assertEquals("java.util.List,java.util.ArrayList",
				type3.getExtraTypeId());
		Map type4 = (Map) type3.getElementType();
		Class type5 = (Class) type4.getKeyType();
		assertEquals("class<com.expedia.tesla.example.WrapperClass>",
				type5.getTypeId());
		Reference type6 = (Reference) type4.getValueType();
		Poly type7 = (Poly) type6.getElementType();
		assertEquals(type5, type7.getElementTypes().get(0));
		assertEquals(Primitive.INT32, type7.getElementTypes().get(1));
		assertEquals(Primitive.DOUBLE, type7.getElementTypes().get(2));
	}

	@Test
	public void nullableTypes() throws Exception {
		Class clss = loadBasicWrapperClass();
		assertEquals("nullable<string>", clss.findField("nullableString1")
				.getType().getTypeId());
		assertEquals("nullable<string>", clss.findField("nullableString2")
				.getType().getTypeId());
	}

	@Test
	public void invalidTml() throws Exception {
		thrown.expect(TeslaSchemaException.class);
		thrown.expectMessage("Invalid TML");
		TmlProcessor.load("src/test/resources/invalid.tml");
	}

	@Test
	public void resolveFailure() throws Exception {
		thrown.expect(TeslaSchemaException.class);
		thrown.expectMessage("is not defined");
		TmlProcessor.build(
				TmlProcessor.load("src/test/resources/resolve_failure.tml"),
				new SchemaVersion(0));
	}
}