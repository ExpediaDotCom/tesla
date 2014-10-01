/**
 *
 * InheritanceTest.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.tesla.compiler.serialization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.expedia.tesla.compiler.test.Serializer;
import com.expedia.tesla.compiler.test.Serializer.ObjectReader;
import com.expedia.tesla.compiler.test.Serializer.ObjectWriter;
import com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1;
import com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived;
import com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived;

/**
 * Test class inheritance.
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 */
public class InheritanceTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testSingleInheritanceBinarySerialization() throws Exception {
		SingleDerived obj = new SingleDerived();
		((Base1)obj).setInt32Field(1);
		obj.setBooleanField(true);
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ObjectWriter writer = Serializer.newBinaryWriter(
				Serializer.VERSION_COMPILER_TEST_PASSCOMPILE_FULL_INHERITANCE_V1_0, os);
		writer.write(obj);
		assertTrue(Arrays.equals(os.toByteArray(), new byte[]{0x02, 0x0D}));		
	}

	@Test
	public void testSingleInheritanceBinaryDeserialization() throws Exception {
		SingleDerived obj = new SingleDerived();
		
		ByteArrayInputStream is = new ByteArrayInputStream(new byte[]{0x02, 0x0D});
		ObjectReader reader = Serializer.newBinaryReader(
				Serializer.VERSION_COMPILER_TEST_PASSCOMPILE_FULL_INHERITANCE_V1_0, is);
		reader.read(obj);
		assertEquals(1, obj.getInt32Field());
		assertEquals(true, obj.getBooleanField());
	}
	
	@Test
	public void testMultiInheritanceBinarySerialization() throws Exception {
		MultiDerived obj = new MultiDerived();
		obj.setInt32Field(1);
		obj.setInt16Field((short)2);
		obj.setByteField((byte)0xEF);
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ObjectWriter writer = Serializer.newBinaryWriter(
				Serializer.VERSION_COMPILER_TEST_PASSCOMPILE_FULL_INHERITANCE_V1_0, os);
		writer.write(obj);
		assertTrue(Arrays.equals(os.toByteArray(), new byte[]{0x02, 0x04, (byte)0xEF}));		
	}

	@Test
	public void testMultiInheritanceBinaryDeserialization() throws Exception {
		MultiDerived obj = new MultiDerived();
		
		ByteArrayInputStream is = new ByteArrayInputStream(new byte[]{0x02, 0x04, (byte)0xEF});
		ObjectReader reader = Serializer.newBinaryReader(
				Serializer.VERSION_COMPILER_TEST_PASSCOMPILE_FULL_INHERITANCE_V1_0, is);
		reader.read(obj);
		assertEquals(1, obj.getInt32Field());
		assertEquals((short)2, obj.getInt16Field());
		assertEquals((byte)0xEF, obj.getByteField());
	}
	
	@Test
	public void testSingleInheritanceJsonSerialization() throws Exception {
		SingleDerived obj = new SingleDerived();
		((Base1)obj).setInt32Field(1);
		obj.setBooleanField(true);
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ObjectWriter writer = Serializer.newJsonWriter(
				Serializer.VERSION_COMPILER_TEST_PASSCOMPILE_FULL_INHERITANCE_V1_0, os);
		writer.write(obj);
		assertEquals("{\"Int32Field\":1,\"BooleanField\":true}", new String(os.toByteArray()));		
	}

	@Test
	public void testSingleInheritanceJsonDeserialization() throws Exception {
		SingleDerived obj = new SingleDerived();
		
		ByteArrayInputStream is = new ByteArrayInputStream("{\"Int32Field\":1,\"BooleanField\":true}".getBytes());
		ObjectReader reader = Serializer.newJsonReader(
				Serializer.VERSION_COMPILER_TEST_PASSCOMPILE_FULL_INHERITANCE_V1_0, is);
		reader.read(obj);
		assertEquals(1, obj.getInt32Field());
		assertEquals(true, obj.getBooleanField());
	}
	
	@Test
	public void testMultiInheritanceJsonSerialization() throws Exception {
		MultiDerived obj = new MultiDerived();
		obj.setInt32Field(1);
		obj.setInt16Field((short)2);
		obj.setByteField((byte)3);
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ObjectWriter writer = Serializer.newJsonWriter(
				Serializer.VERSION_COMPILER_TEST_PASSCOMPILE_FULL_INHERITANCE_V1_0, os);
		writer.write(obj);
		assertEquals("{\"Int32Field\":1,\"Int16Field\":2,\"ByteField\":3}", new String(os.toByteArray()));		
	}

	@Test
	public void testMultiInheritanceJsonDeserialization() throws Exception {
		MultiDerived obj = new MultiDerived();
		
		ByteArrayInputStream is = new ByteArrayInputStream("{\"Int32Field\":1,\"Int16Field\":2,\"ByteField\":3}".getBytes());
		ObjectReader reader = Serializer.newJsonReader(
				Serializer.VERSION_COMPILER_TEST_PASSCOMPILE_FULL_INHERITANCE_V1_0, is);
		obj = reader.read(obj);
		assertEquals(1, obj.getInt32Field());
		assertEquals((short)2, obj.getInt16Field());
		assertEquals((byte)3, obj.getByteField());
	}

}
