/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * BinaryReaderTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization.binary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.expedia.tesla.serialization.BinaryReader;

/**
 * Unit tests for the Tesla BinaryReader.
 * 
 * @author dheld
 */
public class BinaryReaderTest extends BaseFixture {
	@Test(expected = java.lang.NullPointerException.class)
	public void BinaryReader_Null_Throws() throws Exception {
		new BinaryReader((byte[]) null, SCHEMA_VERSION).close();
	}

	@Test
	public void BinaryReader_NonNull_Succeeds() throws Exception {
		assertNotNull(new BinaryReader(BINARY_FALSE, SCHEMA_VERSION));
	}

	@Test
	public void getVersion__Succeeds() throws Exception {
		assertEquals(SCHEMA_VERSION.getSchemaHash(),
				this.getReader(BINARY_FALSE).getVersion().getSchemaHash());
	}

}
