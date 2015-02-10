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

package com.expedia.tesla.compiler;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.expedia.tesla.SchemaVersion;
import com.expedia.tesla.compiler.plugins.JavaTypeMapper;
import com.expedia.tesla.schema.Array;
import com.expedia.tesla.schema.Class;
import com.expedia.tesla.schema.Enum;
import com.expedia.tesla.schema.Nullable;
import com.expedia.tesla.schema.Primitive;
import com.expedia.tesla.schema.Schema;
import com.expedia.tesla.schema.TeslaSchemaException;
import com.expedia.tesla.schema.Type;
import com.expedia.tesla.schema.annotation.DisplayName;
import com.expedia.tesla.schema.annotation.NotNullable;
import com.expedia.tesla.schema.annotation.SkipField;
import com.expedia.tesla.schema.annotation.Reference;
import com.expedia.tesla.schema.annotation.TypeId;

/**
 * Telsa schema generator tests.
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 *
 */
public class SchemaGeneratorTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private SchemaVersion schemaVersion;
	private Schema.SchemaBuilder schemaBuilder;
	private JavaTypeMapper mapper;

	@Before
	public void setUp() {
		schemaVersion = new SchemaVersion(1234567890L, 121, "Test Object Version 121", null);
		schemaBuilder = new Schema.SchemaBuilder();
		schemaBuilder.setVersion(schemaVersion);
		mapper = new JavaTypeMapper();
	}
	
	private Type map(java.lang.Class<?> clss) throws Exception {
		return mapper.fromJavaClass(schemaBuilder, clss);
	}
	
	private Class mapClass(java.lang.Class<?> clss) throws Exception {
		return (Class)map(clss);
	}
	
	private Class findClass(String name) throws Exception {
		return (Class)(schemaBuilder.findType(name));
	}
	
	@Test
	public void testClassName() throws Exception {
		assertEquals(Empty.class.getName(), mapClass(Empty.class).getName());
	}

	@Test
	public void testEmptyClass() throws Exception {
		assertTrue(mapClass(Empty.class).getFields().isEmpty());
	}

	@Test
	public void testInheritance() throws Exception {
		Class type = mapClass(TestClass.class);
		assertArrayEquals(type.getBases().toArray(), 
				new Object[] {findClass(Base.class.getCanonicalName())});
	}

	@Test
	public void testLocalClass() throws Exception {
		thrown.expect(TeslaSchemaException.class);
		thrown.expectMessage("Tesla cannot generate schema for local class");
		
		class LocalClass {}; 
		new JavaTypeMapper().fromJavaClass(schemaBuilder, LocalClass.class);
	}
	
	@Test
	public void repeat() throws Exception {
		// mapper.fromJavaClass should not reproduce the same class again in the same schema builder.
		assertTrue(map(TestClass.class) == map(TestClass.class));
	}
	
	@Test
	public void testNoGetter() throws Exception {
		assertFalse(mapClass(TestClass.class).hasField("noGetterField"));
	}

	@Test
	public void testNoSetter() throws Exception {
		assertFalse(mapClass(TestClass.class).hasField("noSetterField"));
	}
	
	@Test
	public void testSkipProperty() throws Exception {
		assertFalse(mapClass(TestClass.class).hasField("transientField"));
	}
	
	@Test
	public void testTypeIdAnnotation() throws Exception {
		assertEquals("poly<int32,double,string>", 
				mapClass(TestClass.class).findField("magicField").getType().getTypeId());
	}
	
	@Test
	public void testStringReference() throws Exception {
		assertEquals("reference<string>", 
				mapClass(TestClass.class).findField("stringReferenceField").getType().getTypeId());
	}
	
	@Test
	public void testJavaPrimitive() throws Exception {
		assertTrue(mapClass(TestClass.class).findField("int32Field").getType() == Primitive.INT32);
	}
	
	@Test
	public void testBoxedPrimitive() throws Exception {
		assertTrue(((Nullable)mapClass(TestClass.class).findField("nullableInt32Field").getType()).getElementType()
				== Primitive.INT32);
	}
	
	@Test
	public void testNotNullableBoxedPrimitive() throws Exception {
		assertTrue(mapClass(TestClass.class).findField("notNullableInt32Field").getType() == Primitive.INT32);
	}

	@Test
	public void testString() throws Exception {
		assertTrue(((Nullable)mapClass(TestClass.class).findField("stringField").getType()).getElementType()
				== Primitive.STRING);
	}
	
	@Test
	public void testInterface() throws Exception {
		assertTrue((mapClass(TestInterface.class).findField("int32Field").getType()) == Primitive.INT32);
	}
	
	@Test
	public void testArray() throws Exception {
		assertEquals("array<int32>", 
				mapClass(TestClass.class).findField("int32ArrayField").getType().getTypeId());
	}
	
	@Test
	public void testCollectionType() throws Exception {
		assertEquals("array[java.util.Collection,java.util.ArrayList]<int32>", 
				mapClass(TestClass.class).findField("collectionField").getType().getTypeId());
	}
	
	@Test
	public void testList() throws Exception {
		assertEquals("array[java.util.List,java.util.ArrayList]<int32>", 
				mapClass(TestClass.class).findField("listField").getType().getTypeId());
	}
	
	@Test
	public void testArrayList() throws Exception {
		assertEquals("array[java.util.ArrayList]<int32>", 
				mapClass(TestClass.class).findField("arrayListField").getType().getTypeId());
	}
	
	@Test
	public void testSet() throws Exception {
		assertEquals("nullable<array[java.util.Set,java.util.HashSet]<int32>>", 
				mapClass(TestClass.class).findField("setField").getType().getTypeId());
	}
	
	@Test
	public void testHashSet() throws Exception {
		assertEquals("nullable<array[java.util.HashSet]<int32>>", 
				mapClass(TestClass.class).findField("hashSetField").getType().getTypeId());
	}
	
	@Test
	public void testTreeSet() throws Exception {
		assertEquals("nullable<array[java.util.TreeSet]<int32>>", 
				mapClass(TestClass.class).findField("treeSetField").getType().getTypeId());
	}
	
	@Test
	public void testMap() throws Exception {
		assertEquals("nullable<map<int32,string>>", 
				mapClass(TestClass.class).findField("mapField").getType().getTypeId());
	}
	
	@Test
	public void testHashMap() throws Exception {
		assertEquals("nullable<map[java.util.HashMap]<int32,string>>", 
				mapClass(TestClass.class).findField("hashMapField").getType().getTypeId());
	}
	
	@Test
	public void testTreeMap() throws Exception {
		assertEquals("nullable<map[java.util.TreeMap]<int32,string>>", 
				mapClass(TestClass.class).findField("treeMapField").getType().getTypeId());
	}
	
	@Test
	public void testWildcardType() throws Exception {
		assertTrue(((Array)mapClass(TestClass.class).findField("wildcardTypeField").getType()).getElementType()
				== findClass(TestInterface.class.getCanonicalName()));
	}
	
	@Test
	public void testGenericArrayType() throws Exception {
		assertTrue(((Array)mapClass(TestClass.class).findField("genericArrayTypeField").getType()).getElementType()
				== findClass(TestInterface.class.getCanonicalName()));
	}

	@Test
	public void testComplicated() throws Exception {
		// List<Map<Base,HashSet<Derived>[]>>
		assertEquals("nullable<array[java.util.List,java.util.ArrayList]<map<class<com.expedia.tesla.compiler.Base>,array<array[java.util.HashSet]<class<com.expedia.tesla.compiler.TestClass>>>>>>", 
				mapClass(TestClass.class).findField("complicated").getType().getTypeId());
	}
	
	@Test
	public void testEnum() throws Exception {
		Enum e = (Enum)mapClass(TestClass.class).findField("sex").getType();
		assertEquals("com.expedia.tesla.compiler.Sex", e.getName());
		assertEquals(0, e.findEntry("Male").getValue());
		assertEquals(1, e.findEntry("Female").getValue());
	}
	
	@Test
	public void testGetterName() throws Exception {
		assertEquals("getSex", mapClass(TestClass.class).findField("sex").getGetterName());
	}
	
	@Test
	public void testSetterName() throws Exception {
		assertEquals("setSex", mapClass(TestClass.class).findField("sex").getSetterName());
	}
	
	@Test
	public void testDisplayName() throws Exception {
		assertEquals("alias", mapClass(TestClass.class).findField("displayNameField").getDisplayName());
	}
	
	@Test
	public void testGenerateTml() throws Exception {
		File tmlFile = File.createTempFile("TestObjectSchema", ".tml");
		try (FileOutputStream output = new FileOutputStream(tmlFile)) {
			SchemaGenerator.genTml(Arrays.asList(TestClass.class.getCanonicalName()), schemaVersion, output, null);
		} 
		// Load the generated schema file and do the checks.
		Schema schema = Schema.build(tmlFile.getAbsolutePath());
		tmlFile.deleteOnExit();
		assertEquals(this.schemaVersion.getName(), schema.getVersion().getName());
		assertEquals(this.schemaVersion.getVersionNumber(), schema.getVersion().getVersionNumber());
		assertNotNull(schema.findType("com.expedia.tesla.compiler.Empty"));
		assertNotNull(schema.findType("com.expedia.tesla.compiler.TestInterface"));
		assertNotNull(schema.findType("com.expedia.tesla.compiler.Base"));
		assertNotNull(schema.findType("com.expedia.tesla.compiler.Sex"));
		assertNotNull(schema.findType("com.expedia.tesla.compiler.TestClass"));
	}
}

class Empty {
}

interface TestInterface {
	public int getInt32Field();
	public void setInt32Field(int v);
}

class Base extends Empty implements TestInterface {
	@Override
	public int getInt32Field() {
		return 0;
	}
	@Override
	public void setInt32Field(int int32Field) {
	}
}

enum Sex {
	Male,
	Female
}

class TestClass extends Base {
	
	@NotNullable
	public Sex getSex() {
		return null;
	}
	public void setSex(Sex sex){
	}
	
	public void setNoGetterField(int noGetterField) {
	}
	
	public int getNoSetterField() {
		return 0;
	}
	
	@SkipField
	public int getTransientField() {
		return 0;
	}
	public void setTransientField(int transientField) {
	}
	
	@DisplayName("alias")
	public int getDisplayNameField() {
		return 0;
	}
	public void setDisplayNameField(int displayNameField) {
	}	
	
	@TypeId("poly<int32,double,string>")
	public Object getMagicField() {
		return 0;
	}
	public void setMagicField(Object v) {
	}
	
	public String getStringField() {
		return null;
	}
	public void setStringField(String int32Field) {
	}
	
	@NotNullable
	@Reference
	public String getStringReferenceField() {
		return null;
	}
	public void setStringReferenceField(String stringReferenceField) {
	}
	
	public Integer getNullableInt32Field() {
		return null;
	}
	public void setNullableInt32Field(Integer nullableInt32Field) {
	}
	
	@NotNullable
	public Integer getNotNullableInt32Field() {
		return null;
	}
	public void setNotNullableInt32Field(Integer notNullableInt32Field) {
	}
	
	@NotNullable
	public int[] getInt32ArrayField() {
		return null;
	}
	public void setInt32ArrayField(int[] int32ArrayField) {
	}
	
	@NotNullable
	public Collection<Integer> getCollectionField() {
		return null;
	}
	public void setCollectionField(Collection<Integer> collectionField) {
	}
	
	@NotNullable
	public List<Integer> getListField() {
		return null;
	}
	public void setListField(List<Integer> listField) {
	}
	
	@NotNullable
	public ArrayList<Integer> getArrayListField() {
		return null;
	}
	public void setArrayListField(ArrayList<Integer> arrListField) {
	}
	
	public Set<Integer> getSetField() {
		return null;
	}
	public void setSetField(Set<Integer> setField) {
	}
	
	public HashSet<Integer> getHashSetField() {
		return null;
	}
	public void setHashSetField(HashSet<Integer> hashSetField) {
	}

	public TreeSet<Integer> getTreeSetField() {
		return null;
	}
	public void setTreeSetField(TreeSet<Integer> treeSetField) {
	}
	
	public Map<Integer, String> getMapField() {
		return null;
	}
	public void setMapField(Map<Integer, String> mapField) {
	}
	
	public HashMap<Integer, String> getHashMapField() {
		return null;
	}
	public void setHashMapField(HashMap<Integer, String> hashMapField) {
	}

	public TreeMap<Integer, String> getTreeMapField() {
		return null;
	}
	public void setTreeMapField(TreeMap<Integer, String> treeMapField) {
	}

	@NotNullable
	public List<? extends TestInterface> getWildcardTypeField() {
		return null;
	}
	public void setWildcardTypeField(List<? extends TestInterface> wildcardTypeField) {
	}
	
	@NotNullable
	public <T extends TestInterface> T[] getGenericArrayTypeField() {
		return null;
	}
	public <T extends TestInterface> void setGenericArrayTypeField(T[] genericArrayTypeField) {
	}
	
	public List<Map<Base,HashSet<TestClass>[]>> getComplicated() {
		return null;
	}
	public void setComplicated(List<Map<Base,HashSet<TestClass>[]>> complicated) {		
	}
}