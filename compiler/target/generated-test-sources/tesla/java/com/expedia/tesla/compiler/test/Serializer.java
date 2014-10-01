/**
 * Serializer.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */
package com.expedia.tesla.compiler.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

import com.expedia.tesla.serialization.TeslaSerializationException;
import com.expedia.tesla.serialization.TeslaDeserializationException;
import com.expedia.tesla.SchemaVersion;

public class Serializer {
    public static final com.expedia.tesla.SchemaVersion VERSION_TESLACOMPILER_ALL_TYPES_V1_0 = new com.expedia.tesla.SchemaVersion(7810441853185379917L, (short)1, "teslacompiler all_types v1.0", null);
    public static final com.expedia.tesla.SchemaVersion VERSION_COMPILER_TEST_PASSCOMPILE_FULL_COMPLEXTTYPETEST = new com.expedia.tesla.SchemaVersion(-5586303099293846137L, (short)1, "compiler test passcompile full complexttypetest", null);
    public static final com.expedia.tesla.SchemaVersion VERSION_COMPILER_TEST_PASSCOMPILE_FULL_INHERITANCE_V1_0 = new com.expedia.tesla.SchemaVersion(-4144946394736392407L, (short)1, "compiler test passcompile full inheritance v1.0", null);
    public static final com.expedia.tesla.SchemaVersion VERSION_TESLACOMPILER_REFERENCE_TEST_V1_0 = new com.expedia.tesla.SchemaVersion(-8997496319200256941L, (short)1, "teslacompiler reference test v1.0", null);
    public static final com.expedia.tesla.SchemaVersion VERSION_VERSIONING_TEST_V1_0 = new com.expedia.tesla.SchemaVersion(-1533394106668605082L, (short)1, "versioning test v1.0", null);
    public static final com.expedia.tesla.SchemaVersion VERSION_VERSIONING_TEST_V2_0 = new com.expedia.tesla.SchemaVersion(3897695751964630335L, (short)2, "versioning test v2.0", null);
    
    /**
     * Create a new binary writer instance for a specified schema version. The created writer object will write object
     * follow it's definition in the schema.
     */
    public static ObjectWriter newBinaryWriter(com.expedia.tesla.SchemaVersion version, OutputStream os) throws IOException, TeslaSerializationException {
        if (version.getSchemaHash() == TeslaBinaryWriter_teslacompiler_all_types_v1_0.SCHEMA_HASH) {
            return new TeslaBinaryWriter_teslacompiler_all_types_v1_0(os);
        }
        if (version.getSchemaHash() == TeslaBinaryWriter_compiler_test_passcompile_full_complexttypetest.SCHEMA_HASH) {
            return new TeslaBinaryWriter_compiler_test_passcompile_full_complexttypetest(os);
        }
        if (version.getSchemaHash() == TeslaBinaryWriter_compiler_test_passcompile_full_inheritance_v1_0.SCHEMA_HASH) {
            return new TeslaBinaryWriter_compiler_test_passcompile_full_inheritance_v1_0(os);
        }
        if (version.getSchemaHash() == TeslaBinaryWriter_teslacompiler_reference_test_v1_0.SCHEMA_HASH) {
            return new TeslaBinaryWriter_teslacompiler_reference_test_v1_0(os);
        }
        if (version.getSchemaHash() == TeslaBinaryWriter_versioning_test_v1_0.SCHEMA_HASH) {
            return new TeslaBinaryWriter_versioning_test_v1_0(os);
        }
        if (version.getSchemaHash() == TeslaBinaryWriter_versioning_test_v2_0.SCHEMA_HASH) {
            return new TeslaBinaryWriter_versioning_test_v2_0(os);
        }
        throw new TeslaSerializationException("Unsupported schema version " + version.getSchemaHash());
    }
    
    /**
     * Create a new binary reader instance for a specified schema version. The created reader object will read object
     * follow it's definition in the schema.
     */
    public static ObjectReader newBinaryReader(com.expedia.tesla.SchemaVersion version, InputStream is) throws IOException, TeslaDeserializationException {
        if (version.getSchemaHash() == TeslaBinaryReader_teslacompiler_all_types_v1_0.SCHEMA_HASH) {
            return new TeslaBinaryReader_teslacompiler_all_types_v1_0(is);
        }
        if (version.getSchemaHash() == TeslaBinaryReader_compiler_test_passcompile_full_complexttypetest.SCHEMA_HASH) {
            return new TeslaBinaryReader_compiler_test_passcompile_full_complexttypetest(is);
        }
        if (version.getSchemaHash() == TeslaBinaryReader_compiler_test_passcompile_full_inheritance_v1_0.SCHEMA_HASH) {
            return new TeslaBinaryReader_compiler_test_passcompile_full_inheritance_v1_0(is);
        }
        if (version.getSchemaHash() == TeslaBinaryReader_teslacompiler_reference_test_v1_0.SCHEMA_HASH) {
            return new TeslaBinaryReader_teslacompiler_reference_test_v1_0(is);
        }
        if (version.getSchemaHash() == TeslaBinaryReader_versioning_test_v1_0.SCHEMA_HASH) {
            return new TeslaBinaryReader_versioning_test_v1_0(is);
        }
        if (version.getSchemaHash() == TeslaBinaryReader_versioning_test_v2_0.SCHEMA_HASH) {
            return new TeslaBinaryReader_versioning_test_v2_0(is);
        }
        throw new TeslaDeserializationException("Unsupported schema version " + version.getSchemaHash());
    }
    
    /**
     * Create a new JSON writer instance for a specified schema version. The created writer object will write object
     * follow it's definition in the schema.
     */
    public static ObjectWriter newJsonWriter(com.expedia.tesla.SchemaVersion version, OutputStream os) throws IOException, TeslaSerializationException {
        if (version.getSchemaHash() == TeslaJsonWriter_teslacompiler_all_types_v1_0.SCHEMA_HASH) {
            return new TeslaJsonWriter_teslacompiler_all_types_v1_0(os);
        }
        if (version.getSchemaHash() == TeslaJsonWriter_compiler_test_passcompile_full_complexttypetest.SCHEMA_HASH) {
            return new TeslaJsonWriter_compiler_test_passcompile_full_complexttypetest(os);
        }
        if (version.getSchemaHash() == TeslaJsonWriter_compiler_test_passcompile_full_inheritance_v1_0.SCHEMA_HASH) {
            return new TeslaJsonWriter_compiler_test_passcompile_full_inheritance_v1_0(os);
        }
        if (version.getSchemaHash() == TeslaJsonWriter_teslacompiler_reference_test_v1_0.SCHEMA_HASH) {
            return new TeslaJsonWriter_teslacompiler_reference_test_v1_0(os);
        }
        if (version.getSchemaHash() == TeslaJsonWriter_versioning_test_v1_0.SCHEMA_HASH) {
            return new TeslaJsonWriter_versioning_test_v1_0(os);
        }
        if (version.getSchemaHash() == TeslaJsonWriter_versioning_test_v2_0.SCHEMA_HASH) {
            return new TeslaJsonWriter_versioning_test_v2_0(os);
        }
        throw new TeslaSerializationException("Unsupported schema version " + version.getSchemaHash());
    }
    
    /**
     * Create a new JSON reader instance for a specified schema version. The created reader object will read object
     * follow it's definition in the schema.
     */
    public static ObjectReader newJsonReader(com.expedia.tesla.SchemaVersion version, InputStream is) throws IOException, TeslaDeserializationException {
        if (version.getSchemaHash() == TeslaJsonReader_teslacompiler_all_types_v1_0.SCHEMA_HASH) {
            return new TeslaJsonReader_teslacompiler_all_types_v1_0(is);
        }
        if (version.getSchemaHash() == TeslaJsonReader_compiler_test_passcompile_full_complexttypetest.SCHEMA_HASH) {
            return new TeslaJsonReader_compiler_test_passcompile_full_complexttypetest(is);
        }
        if (version.getSchemaHash() == TeslaJsonReader_compiler_test_passcompile_full_inheritance_v1_0.SCHEMA_HASH) {
            return new TeslaJsonReader_compiler_test_passcompile_full_inheritance_v1_0(is);
        }
        if (version.getSchemaHash() == TeslaJsonReader_teslacompiler_reference_test_v1_0.SCHEMA_HASH) {
            return new TeslaJsonReader_teslacompiler_reference_test_v1_0(is);
        }
        if (version.getSchemaHash() == TeslaJsonReader_versioning_test_v1_0.SCHEMA_HASH) {
            return new TeslaJsonReader_versioning_test_v1_0(is);
        }
        if (version.getSchemaHash() == TeslaJsonReader_versioning_test_v2_0.SCHEMA_HASH) {
            return new TeslaJsonReader_versioning_test_v2_0(is);
        }
        throw new TeslaDeserializationException("Unsupported schema version " + version.getSchemaHash());
    }
    
    /**
     * Create a new JSON change writer instance for a specified schema version. The created writer object will write object
     * follow it's definition in the schema.
     */
    public static ChangeWriter newJsonChangeWriter(com.expedia.tesla.SchemaVersion version, OutputStream os) throws IOException, TeslaSerializationException {
        if (version.getSchemaHash() == TeslaJsonChangeWriter_teslacompiler_all_types_v1_0.SCHEMA_HASH) {
            return new TeslaJsonChangeWriter_teslacompiler_all_types_v1_0(os);
        }
        if (version.getSchemaHash() == TeslaJsonChangeWriter_compiler_test_passcompile_full_complexttypetest.SCHEMA_HASH) {
            return new TeslaJsonChangeWriter_compiler_test_passcompile_full_complexttypetest(os);
        }
        if (version.getSchemaHash() == TeslaJsonChangeWriter_compiler_test_passcompile_full_inheritance_v1_0.SCHEMA_HASH) {
            return new TeslaJsonChangeWriter_compiler_test_passcompile_full_inheritance_v1_0(os);
        }
        if (version.getSchemaHash() == TeslaJsonChangeWriter_teslacompiler_reference_test_v1_0.SCHEMA_HASH) {
            return new TeslaJsonChangeWriter_teslacompiler_reference_test_v1_0(os);
        }
        if (version.getSchemaHash() == TeslaJsonChangeWriter_versioning_test_v1_0.SCHEMA_HASH) {
            return new TeslaJsonChangeWriter_versioning_test_v1_0(os);
        }
        if (version.getSchemaHash() == TeslaJsonChangeWriter_versioning_test_v2_0.SCHEMA_HASH) {
            return new TeslaJsonChangeWriter_versioning_test_v2_0(os);
        }
        throw new TeslaSerializationException("Unsupported schema version " + version.getSchemaHash());
    }
    
    /**
     * Create a new JSON change reader instance for a specified schema version. The created reader object will read object
     * follow it's definition in the schema.
     */
    public static ChangeReader newJsonChangeReader(com.expedia.tesla.SchemaVersion version, InputStream is) throws IOException, TeslaDeserializationException {
        if (version.getSchemaHash() == TeslaJsonChangeReader_teslacompiler_all_types_v1_0.SCHEMA_HASH) {
            return new TeslaJsonChangeReader_teslacompiler_all_types_v1_0(is);
        }
        if (version.getSchemaHash() == TeslaJsonChangeReader_compiler_test_passcompile_full_complexttypetest.SCHEMA_HASH) {
            return new TeslaJsonChangeReader_compiler_test_passcompile_full_complexttypetest(is);
        }
        if (version.getSchemaHash() == TeslaJsonChangeReader_compiler_test_passcompile_full_inheritance_v1_0.SCHEMA_HASH) {
            return new TeslaJsonChangeReader_compiler_test_passcompile_full_inheritance_v1_0(is);
        }
        if (version.getSchemaHash() == TeslaJsonChangeReader_teslacompiler_reference_test_v1_0.SCHEMA_HASH) {
            return new TeslaJsonChangeReader_teslacompiler_reference_test_v1_0(is);
        }
        if (version.getSchemaHash() == TeslaJsonChangeReader_versioning_test_v1_0.SCHEMA_HASH) {
            return new TeslaJsonChangeReader_versioning_test_v1_0(is);
        }
        if (version.getSchemaHash() == TeslaJsonChangeReader_versioning_test_v2_0.SCHEMA_HASH) {
            return new TeslaJsonChangeReader_versioning_test_v2_0(is);
        }
        throw new TeslaDeserializationException("Unsupported schema version " + version.getSchemaHash());
    }
    
    /**
     * Write object instances of any user defined types in application schema files (TML). To create instance of ObjectWriter,
     * use newBinaryWriter or newJsonWriter method.   
     */
    public static abstract class ObjectWriter {
        public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestObject_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.complexttypetest v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_complexttypetest_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base1_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base2_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_MultiDerived_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_SingleDerived_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ArrayReference_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_BinaryReference_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_EnumReference_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_Int32Reference_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ObjectReference_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ReferenceArray_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_StringReference_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(null, v);
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject v) throws IOException, TeslaSerializationException {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(null, v);
        }
        // Following methods will be override by actual serialization class for each schema.
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_complexttypetest_(String name, com.expedia.tesla.compiler.test.passcompile.full.complexttypetest v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.complexttypetest' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base1_(String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base2_(String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_MultiDerived_(String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_SingleDerived_(String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ArrayReference_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_BinaryReference_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_EnumReference_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_Int32Reference_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ObjectReference_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ReferenceArray_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_StringReference_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject v) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject' is not defined in current schema.");
        }
    }
    
    /**
     * Read object instances of any user defined types in application schema files (TML). To create instance of ObjectReader,
     * use newBinaryReader or newJsonReader method.   
     */
    public static abstract class ObjectReader {
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestObject_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.complexttypetest read(com.expedia.tesla.compiler.test.passcompile.full.complexttypetest v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_complexttypetest_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 read(com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base1_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 read(com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base2_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived read(com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_MultiDerived_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived read(com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_SingleDerived_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ArrayReference_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_BinaryReference_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_EnumReference_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_Int32Reference_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ObjectReference_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ReferenceArray_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_StringReference_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(null, v);
        }
        public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject read(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject v) throws IOException, TeslaDeserializationException {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(null, v);
        }
        // Following methods will be override by actual serialization class for each schema.
        protected com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.complexttypetest read_class_com_expedia_tesla_compiler_test_passcompile_full_complexttypetest_(String name, com.expedia.tesla.compiler.test.passcompile.full.complexttypetest v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.complexttypetest' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base1_(String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base2_(String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_MultiDerived_(String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_SingleDerived_(String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ArrayReference_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_BinaryReference_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_EnumReference_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_Int32Reference_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ObjectReference_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ReferenceArray_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_StringReference_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject' is not defined in current schema.");
        }
        protected com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject' is not defined in current schema.");
        }
    }
    
    /**
     * Compare two values and write only properties or values which are not equal for any user defined objects in 
     * application schema files (TML). To create instance of ChangeWriter, use newJsonChangeWriter.   
     */
    public static abstract class ChangeWriter {
        public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.complexttypetest oldValue, com.expedia.tesla.compiler.test.passcompile.full.complexttypetest newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.complexttypetest' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 oldValue, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 oldValue, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived oldValue, com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived oldValue, com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject newValue) throws IOException, TeslaSerializationException {
            throw new TeslaSerializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject' is not defined in current schema.");
        }
    }

    /**
     * Read serialized changes generated by ChangeWriter, and applied them on an existing value. Only the changed values
     * or properties will be updated. All other properties or values will remain the current value.
     */
    public static abstract class ChangeReader {
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.complexttypetest read(com.expedia.tesla.compiler.test.passcompile.full.complexttypetest v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.complexttypetest' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 read(com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 read(com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived read(com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived read(com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject' is not defined in current schema.");
        }
        public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject read(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject v) throws IOException, TeslaDeserializationException {
            throw new TeslaDeserializationException("Type 'com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject' is not defined in current schema.");
        }
    }

}



class TeslaBinaryWriter_teslacompiler_all_types_v1_0 extends Serializer.ObjectWriter {


    public static final long SCHEMA_HASH = 7810441853185379917L;
    private com.expedia.tesla.serialization.BinaryWriter writer;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    public TeslaBinaryWriter_teslacompiler_all_types_v1_0(OutputStream stream) {
        writer = new com.expedia.tesla.serialization.BinaryWriter(stream, SCHEMA_HASH);
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_nullable_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___("OptionalObjectArrayField", v.getOptionalObjectArrayField());
        write_nullable_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___("OptionalEnumArrayField", v.getOptionalEnumArrayField());
        write_nullable_array_boolean__("OptionalBoolArrayField", v.getOptionalBoolArrayField());
        write_nullable_array_byte__("OptionalByteArrayField", v.getOptionalByteArrayField());
        write_nullable_array_int16__("OptionalInt16ArrayField", v.getOptionalInt16ArrayField());
        write_nullable_array_uint16__("OptionalUInt16ArrayField", v.getOptionalUInt16ArrayField());
        write_nullable_array_int32__("OptionalInt32ArrayField", v.getOptionalInt32ArrayField());
        write_nullable_array_uint32__("OptionalUInt32ArrayField", v.getOptionalUInt32ArrayField());
        write_nullable_array_int64__("OptionalInt64ArrayField", v.getOptionalInt64ArrayField());
        write_nullable_array_uint64__("OptionalUInt64ArrayField", v.getOptionalUInt64ArrayField());
        write_nullable_array_float__("OptionalFloatArrayField", v.getOptionalFloatArrayField());
        write_nullable_array_double__("OptionalDoubleArrayField", v.getOptionalDoubleArrayField());
        write_nullable_array_string__("OptionalStringArrayField", v.getOptionalStringArrayField());
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_int32("IntField", v.getIntField());
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_array_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___("Object2DArrayField", v.getObject2DArrayField());
        write_array_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___("Enum2DArrayField", v.getEnum2DArrayField());
        write_array_array_boolean__("Bool2DArrayField", v.getBool2DArrayField());
        write_array_array_byte__("Byte2DArrayField", v.getByte2DArrayField());
        write_array_array_int16__("Int162DArrayField", v.getInt162DArrayField());
        write_array_array_uint16__("UInt162DArrayField", v.getUInt162DArrayField());
        write_array_array_int32__("Int322DArrayField", v.getInt322DArrayField());
        write_array_array_uint32__("UInt322DArrayField", v.getUInt322DArrayField());
        write_array_array_int64__("Int642DArrayField", v.getInt642DArrayField());
        write_array_array_uint64__("UInt642DArrayField", v.getUInt642DArrayField());
        write_array_array_float__("Float2DArrayField", v.getFloat2DArrayField());
        write_array_array_double__("Double2DArrayField", v.getDouble2DArrayField());
        write_array_array_string__("String2DArrayField", v.getString2DArrayField());
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_nullable_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__("OptionalObjectField", v.getOptionalObjectField());
        write_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__("OptionalEnumField", v.getOptionalEnumField());
        write_nullable_boolean_("OptionalBoolField", v.getOptionalBoolField());
        write_nullable_byte_("OptionalByteField", v.getOptionalByteField());
        write_nullable_int16_("OptionalInt16Field", v.getOptionalInt16Field());
        write_nullable_uint16_("OptionalUInt16Field", v.getOptionalUInt16Field());
        write_nullable_int32_("OptionalInt32Field", v.getOptionalInt32Field());
        write_nullable_uint32_("OptionalUInt32Field", v.getOptionalUInt32Field());
        write_nullable_int64_("OptionalInt64Field", v.getOptionalInt64Field());
        write_nullable_uint64_("OptionalUInt64Field", v.getOptionalUInt64Field());
        write_nullable_float_("OptionalFloatField", v.getOptionalFloatField());
        write_nullable_double_("OptionalDoubleField", v.getOptionalDoubleField());
        write_nullable_binary_("OptionalBinaryField", v.getOptionalBinaryField());
        write_nullable_string_("OptionalStringField", v.getOptionalStringField());
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__("ObjectArrayField", v.getObjectArrayField());
        write_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__("EnumArrayField", v.getEnumArrayField());
        write_array_boolean_("BoolArrayField", v.getBoolArrayField());
        write_array_byte_("ByteArrayField", v.getByteArrayField());
        write_array_int16_("Int16ArrayField", v.getInt16ArrayField());
        write_array_uint16_("UInt16ArrayField", v.getUInt16ArrayField());
        write_array_int32_("Int32ArrayField", v.getInt32ArrayField());
        write_array_uint32_("UInt32ArrayField", v.getUInt32ArrayField());
        write_array_int64_("Int64ArrayField", v.getInt64ArrayField());
        write_array_uint64_("UInt64ArrayField", v.getUInt64ArrayField());
        write_array_float_("FloatArrayField", v.getFloatArrayField());
        write_array_double_("DoubleArrayField", v.getDoubleArrayField());
        write_array_string_("StringArrayField", v.getStringArrayField());
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_("ObjectField", v.getObjectField());
        write_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_("EnumField", v.getEnumField());
        write_boolean("BoolField", v.getBoolField());
        write_byte("ByteField", v.getByteField());
        write_int16("Int16Field", v.getInt16Field());
        write_uint16("UInt16Field", v.getUInt16Field());
        write_int32("Int32Field", v.getInt32Field());
        write_uint32("UInt32Field", v.getUInt32Field());
        write_int64("Int64Field", v.getInt64Field());
        write_uint64("UInt64Field", v.getUInt64Field());
        write_float("FloatField", v.getFloatField());
        write_double("DoubleField", v.getDoubleField());
        write_binary("BinaryField", v.getBinaryField());
        write_string("StringField", v.getStringField());
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_reference_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__("ObjectReferenceField", v.getObjectReferenceField());
        write_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__("EnumReferenceField", v.getEnumReferenceField());
        write_reference_boolean_("BoolReferenceField", v.getBoolReferenceField());
        write_reference_byte_("ByteReferenceField", v.getByteReferenceField());
        write_reference_int16_("Int16ReferenceField", v.getInt16ReferenceField());
        write_reference_uint16_("UInt16ReferenceField", v.getUInt16ReferenceField());
        write_reference_int32_("Int32ReferenceField", v.getInt32ReferenceField());
        write_reference_uint32_("UInt32ReferenceField", v.getUInt32ReferenceField());
        write_reference_int64_("Int64ReferenceField", v.getInt64ReferenceField());
        write_reference_uint64_("UInt64ReferenceField", v.getUInt64ReferenceField());
        write_reference_float_("FloatReferenceField", v.getFloatReferenceField());
        write_reference_double_("DoubleReferenceField", v.getDoubleReferenceField());
        write_reference_binary_("BinaryReferenceField", v.getBinaryReferenceField());
        write_reference_string_("StringReferenceField", v.getStringReferenceField());
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_("BasicTestObjectField", v.getBasicTestObjectField());
        write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_("ReferenceTestObjectField", v.getReferenceTestObjectField());
        write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_("OptionalBasicTestObjectField", v.getOptionalBasicTestObjectField());
        write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_("ArrayTestObjectField", v.getArrayTestObjectField());
        write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_("Array2DTestObjectField", v.getArray2DTestObjectField());
        write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_("OptionalArrayTestObjectField", v.getOptionalArrayTestObjectField());
    }


    public void write_array_array_uint16__(java.lang.String name, java.util.List<java.util.List<java.lang.Short>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (java.util.List<java.lang.Short> e : v) {
            write_array_uint16_(name, e);
        }
    }
    
    
    public void write_array_array_boolean__(java.lang.String name, java.util.List<java.util.List<java.lang.Boolean>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (java.util.List<java.lang.Boolean> e : v) {
            write_array_boolean_(name, e);
        }
    }
    
    
    public void write_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(java.lang.String name, java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum e : v) {
            write_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(name, e);
        }
    }
    
    
    public void write_reference_byte_(java.lang.String name, java.lang.Byte v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, java.lang.Byte.class);
        write_int32(null, id);
        if (id < 0) {
            write_byte(name, (java.lang.Byte)v);
        }
    }

    
    public void write_nullable_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___(java.lang.String name, java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(name, v);
        }
    }

    
    
    public void write_nullable_int16_(java.lang.String name, java.lang.Short v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_int16(name, v);
        }
    }

    
    public void write_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(java.lang.String name, java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject e : v) {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(name, e);
        }
    }
    
    
    public void write_array_byte_(java.lang.String name, java.util.List<java.lang.Byte> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (byte e : v) {
            write_byte(name, e);
        }
    }
    
    
    public void write_nullable_int32_(java.lang.String name, java.lang.Integer v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_int32(name, v);
        }
    }

    
    public void write_nullable_array_boolean__(java.lang.String name, java.util.List<java.lang.Boolean> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_array_boolean_(name, v);
        }
    }

    
    public void write_array_array_int16__(java.lang.String name, java.util.List<java.util.List<java.lang.Short>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (java.util.List<java.lang.Short> e : v) {
            write_array_int16_(name, e);
        }
    }
    
    
    public void write_float(java.lang.String name, float v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeFloat(name, v);
    }
    
    
    public void write_reference_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject.class);
        write_int32(null, id);
        if (id < 0) {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(name, (com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject)v);
        }
    }

    
    public void write_array_array_string__(java.lang.String name, java.util.List<java.util.List<java.lang.String>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (java.util.List<java.lang.String> e : v) {
            write_array_string_(name, e);
        }
    }
    
    
    public void write_array_boolean_(java.lang.String name, java.util.List<java.lang.Boolean> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (boolean e : v) {
            write_boolean(name, e);
        }
    }
    
    
    public void write_array_array_byte__(java.lang.String name, java.util.List<java.util.List<java.lang.Byte>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (java.util.List<java.lang.Byte> e : v) {
            write_array_byte_(name, e);
        }
    }
    
    
    public void write_uint16(java.lang.String name, short v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeUInt16(name, v);
    }
    
    
    public void write_reference_uint16_(java.lang.String name, java.lang.Short v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, java.lang.Short.class);
        write_int32(null, id);
        if (id < 0) {
            write_uint16(name, (java.lang.Short)v);
        }
    }

    
    public void write_reference_int16_(java.lang.String name, java.lang.Short v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, java.lang.Short.class);
        write_int32(null, id);
        if (id < 0) {
            write_int16(name, (java.lang.Short)v);
        }
    }

    
    public void write_array_uint32_(java.lang.String name, java.util.List<java.lang.Integer> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (int e : v) {
            write_uint32(name, e);
        }
    }
    
    
    public void write_int64(java.lang.String name, long v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeInt64(name, v);
    }
    
    
    public void write_byte(java.lang.String name, byte v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeByte(name, v);
    }
    
    
    
    public void write_nullable_double_(java.lang.String name, java.lang.Double v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_double(name, v);
        }
    }

    
    public void write_array_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___(java.lang.String name, java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> e : v) {
            write_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(name, e);
        }
    }
    
    
    public void write_boolean(java.lang.String name, boolean v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeBoolean(name, v);
    }
    
    
    public void write_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(name, v);
        }
    }

    
    public void write_nullable_uint64_(java.lang.String name, java.lang.Long v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_uint64(name, v);
        }
    }

    
    public void write_nullable_uint16_(java.lang.String name, java.lang.Short v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_uint16(name, v);
        }
    }

    
    public void write_array_string_(java.lang.String name, java.util.List<java.lang.String> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (java.lang.String e : v) {
            write_string(name, e);
        }
    }
    
    
    public void write_int16(java.lang.String name, short v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeInt16(name, v);
    }
    
    
    public void write_array_int64_(java.lang.String name, java.util.List<java.lang.Long> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (long e : v) {
            write_int64(name, e);
        }
    }
    
    
    public void write_reference_uint32_(java.lang.String name, java.lang.Integer v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, java.lang.Integer.class);
        write_int32(null, id);
        if (id < 0) {
            write_uint32(name, (java.lang.Integer)v);
        }
    }

    
    public void write_array_array_uint32__(java.lang.String name, java.util.List<java.util.List<java.lang.Integer>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (java.util.List<java.lang.Integer> e : v) {
            write_array_uint32_(name, e);
        }
    }
    
    
    public void write_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum.class);
        write_int32(null, id);
        if (id < 0) {
            write_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(name, (com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum)v);
        }
    }

    
    public void write_double(java.lang.String name, double v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeDouble(name, v);
    }
    
    
    public void write_nullable_uint32_(java.lang.String name, java.lang.Integer v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_uint32(name, v);
        }
    }

    
    public void write_array_int16_(java.lang.String name, java.util.List<java.lang.Short> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (short e : v) {
            write_int16(name, e);
        }
    }
    
    
    public void write_reference_binary_(java.lang.String name, byte[] v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, byte[].class);
        write_int32(null, id);
        if (id < 0) {
            write_binary(name, (byte[])v);
        }
    }

    
    
    public void write_array_int32_(java.lang.String name, java.util.List<java.lang.Integer> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (int e : v) {
            write_int32(name, e);
        }
    }
    
    
    public void write_array_double_(java.lang.String name, java.util.List<java.lang.Double> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (double e : v) {
            write_double(name, e);
        }
    }
    
    
    public void write_array_uint64_(java.lang.String name, java.util.List<java.lang.Long> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (long e : v) {
            write_uint64(name, e);
        }
    }
    
    
    public void write_reference_string_(java.lang.String name, java.lang.String v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, java.lang.String.class);
        write_int32(null, id);
        if (id < 0) {
            write_string(name, (java.lang.String)v);
        }
    }

    
    public void write_nullable_array_uint16__(java.lang.String name, java.util.List<java.lang.Short> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_array_uint16_(name, v);
        }
    }

    
    public void write_reference_boolean_(java.lang.String name, java.lang.Boolean v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, java.lang.Boolean.class);
        write_int32(null, id);
        if (id < 0) {
            write_boolean(name, (java.lang.Boolean)v);
        }
    }

    
    public void write_nullable_array_int64__(java.lang.String name, java.util.List<java.lang.Long> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_array_int64_(name, v);
        }
    }

    
    public void write_binary(java.lang.String name, byte[] v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeBinary(name, v);
    }
    
    
    
    public void write_nullable_byte_(java.lang.String name, java.lang.Byte v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_byte(name, v);
        }
    }

    
    public void write_nullable_int64_(java.lang.String name, java.lang.Long v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_int64(name, v);
        }
    }

    
    public void write_reference_int64_(java.lang.String name, java.lang.Long v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, java.lang.Long.class);
        write_int32(null, id);
        if (id < 0) {
            write_int64(name, (java.lang.Long)v);
        }
    }

    
    public void write_uint32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeUInt32(name, v);
    }
    
    
    public void write_nullable_float_(java.lang.String name, java.lang.Float v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_float(name, v);
        }
    }

    
    public void write_array_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___(java.lang.String name, java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> e : v) {
            write_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(name, e);
        }
    }
    
    
    public void write_array_array_int32__(java.lang.String name, java.util.List<java.util.List<java.lang.Integer>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (java.util.List<java.lang.Integer> e : v) {
            write_array_int32_(name, e);
        }
    }
    
    
    public void write_nullable_array_uint64__(java.lang.String name, java.util.List<java.lang.Long> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_array_uint64_(name, v);
        }
    }

    
    
    public void write_nullable_string_(java.lang.String name, java.lang.String v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_string(name, v);
        }
    }

    
    public void write_nullable_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(name, v);
        }
    }

    
    public void write_nullable_array_float__(java.lang.String name, java.util.List<java.lang.Float> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_array_float_(name, v);
        }
    }

    
    public void write_array_array_double__(java.lang.String name, java.util.List<java.util.List<java.lang.Double>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (java.util.List<java.lang.Double> e : v) {
            write_array_double_(name, e);
        }
    }
    
    
    public void write_reference_float_(java.lang.String name, java.lang.Float v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, java.lang.Float.class);
        write_int32(null, id);
        if (id < 0) {
            write_float(name, (java.lang.Float)v);
        }
    }

    
    public void write_nullable_array_uint32__(java.lang.String name, java.util.List<java.lang.Integer> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_array_uint32_(name, v);
        }
    }

    
    public void write_nullable_binary_(java.lang.String name, byte[] v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_binary(name, v);
        }
    }

    
    public void write_nullable_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___(java.lang.String name, java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(name, v);
        }
    }

    
    public void write_nullable_boolean_(java.lang.String name, java.lang.Boolean v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_boolean(name, v);
        }
    }

    
    
    public void write_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        switch (v) {
        case Info:
            write_int32(name, 1);
            break;
        case Warning:
            write_int32(name, 2);
            break;
        case Error:
            write_int32(name, 3);
            break;
        default:
            throw new com.expedia.tesla.serialization.TeslaSerializationException(String.format(
                "Enum value %s is not allowed on field %s (type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>')", 
                v.toString(), name));
        }
    }
    
    
    public void write_uint64(java.lang.String name, long v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeUInt64(name, v);
    }
    
    
    public void write_array_uint16_(java.lang.String name, java.util.List<java.lang.Short> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (short e : v) {
            write_uint16(name, e);
        }
    }
    
    
    public void write_int32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeInt32(name, v);
    }
    
    
    public void write_nullable_array_string__(java.lang.String name, java.util.List<java.lang.String> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_array_string_(name, v);
        }
    }

    
    public void write_nullable_array_int32__(java.lang.String name, java.util.List<java.lang.Integer> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_array_int32_(name, v);
        }
    }

    
    public void write_reference_double_(java.lang.String name, java.lang.Double v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, java.lang.Double.class);
        write_int32(null, id);
        if (id < 0) {
            write_double(name, (java.lang.Double)v);
        }
    }

    
    public void write_array_float_(java.lang.String name, java.util.List<java.lang.Float> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (float e : v) {
            write_float(name, e);
        }
    }
    
    
    public void write_reference_int32_(java.lang.String name, java.lang.Integer v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, java.lang.Integer.class);
        write_int32(null, id);
        if (id < 0) {
            write_int32(name, (java.lang.Integer)v);
        }
    }

    
    public void write_string(java.lang.String name, java.lang.String v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeString(name, v);
    }
    
    
    public void write_array_array_float__(java.lang.String name, java.util.List<java.util.List<java.lang.Float>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (java.util.List<java.lang.Float> e : v) {
            write_array_float_(name, e);
        }
    }
    
    
    public void write_reference_uint64_(java.lang.String name, java.lang.Long v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, java.lang.Long.class);
        write_int32(null, id);
        if (id < 0) {
            write_uint64(name, (java.lang.Long)v);
        }
    }

    
    public void write_array_array_int64__(java.lang.String name, java.util.List<java.util.List<java.lang.Long>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (java.util.List<java.lang.Long> e : v) {
            write_array_int64_(name, e);
        }
    }
    
    
    
    public void write_nullable_array_double__(java.lang.String name, java.util.List<java.lang.Double> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_array_double_(name, v);
        }
    }

    
    public void write_array_array_uint64__(java.lang.String name, java.util.List<java.util.List<java.lang.Long>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (java.util.List<java.lang.Long> e : v) {
            write_array_uint64_(name, e);
        }
    }
    
    
    
    public void write_nullable_array_byte__(java.lang.String name, java.util.List<java.lang.Byte> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_array_byte_(name, v);
        }
    }

    
    public void write_nullable_array_int16__(java.lang.String name, java.util.List<java.lang.Short> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_array_int16_(name, v);
        }
    }

    
}

class TeslaBinaryReader_teslacompiler_all_types_v1_0 extends Serializer.ObjectReader {


    public static final long SCHEMA_HASH = 7810441853185379917L;
    private com.expedia.tesla.serialization.BinaryReader reader;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
            
    TeslaBinaryReader_teslacompiler_all_types_v1_0(InputStream stream) {
        reader = new com.expedia.tesla.serialization.BinaryReader(stream, SCHEMA_HASH);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject();
        v.setOptionalObjectArrayField(read_nullable_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___("OptionalObjectArrayField"));
        v.setOptionalEnumArrayField(read_nullable_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___("OptionalEnumArrayField"));
        v.setOptionalBoolArrayField(read_nullable_array_boolean__("OptionalBoolArrayField"));
        v.setOptionalByteArrayField(read_nullable_array_byte__("OptionalByteArrayField"));
        v.setOptionalInt16ArrayField(read_nullable_array_int16__("OptionalInt16ArrayField"));
        v.setOptionalUInt16ArrayField(read_nullable_array_uint16__("OptionalUInt16ArrayField"));
        v.setOptionalInt32ArrayField(read_nullable_array_int32__("OptionalInt32ArrayField"));
        v.setOptionalUInt32ArrayField(read_nullable_array_uint32__("OptionalUInt32ArrayField"));
        v.setOptionalInt64ArrayField(read_nullable_array_int64__("OptionalInt64ArrayField"));
        v.setOptionalUInt64ArrayField(read_nullable_array_uint64__("OptionalUInt64ArrayField"));
        v.setOptionalFloatArrayField(read_nullable_array_float__("OptionalFloatArrayField"));
        v.setOptionalDoubleArrayField(read_nullable_array_double__("OptionalDoubleArrayField"));
        v.setOptionalStringArrayField(read_nullable_array_string__("OptionalStringArrayField"));
        return v;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject();
        v.setIntField(read_int32("IntField"));
        return v;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject();
        v.setObject2DArrayField(read_array_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___("Object2DArrayField"));
        v.setEnum2DArrayField(read_array_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___("Enum2DArrayField"));
        v.setBool2DArrayField(read_array_array_boolean__("Bool2DArrayField"));
        v.setByte2DArrayField(read_array_array_byte__("Byte2DArrayField"));
        v.setInt162DArrayField(read_array_array_int16__("Int162DArrayField"));
        v.setUInt162DArrayField(read_array_array_uint16__("UInt162DArrayField"));
        v.setInt322DArrayField(read_array_array_int32__("Int322DArrayField"));
        v.setUInt322DArrayField(read_array_array_uint32__("UInt322DArrayField"));
        v.setInt642DArrayField(read_array_array_int64__("Int642DArrayField"));
        v.setUInt642DArrayField(read_array_array_uint64__("UInt642DArrayField"));
        v.setFloat2DArrayField(read_array_array_float__("Float2DArrayField"));
        v.setDouble2DArrayField(read_array_array_double__("Double2DArrayField"));
        v.setString2DArrayField(read_array_array_string__("String2DArrayField"));
        return v;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject();
        v.setOptionalObjectField(read_nullable_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__("OptionalObjectField"));
        v.setOptionalEnumField(read_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__("OptionalEnumField"));
        v.setOptionalBoolField(read_nullable_boolean_("OptionalBoolField"));
        v.setOptionalByteField(read_nullable_byte_("OptionalByteField"));
        v.setOptionalInt16Field(read_nullable_int16_("OptionalInt16Field"));
        v.setOptionalUInt16Field(read_nullable_uint16_("OptionalUInt16Field"));
        v.setOptionalInt32Field(read_nullable_int32_("OptionalInt32Field"));
        v.setOptionalUInt32Field(read_nullable_uint32_("OptionalUInt32Field"));
        v.setOptionalInt64Field(read_nullable_int64_("OptionalInt64Field"));
        v.setOptionalUInt64Field(read_nullable_uint64_("OptionalUInt64Field"));
        v.setOptionalFloatField(read_nullable_float_("OptionalFloatField"));
        v.setOptionalDoubleField(read_nullable_double_("OptionalDoubleField"));
        v.setOptionalBinaryField(read_nullable_binary_("OptionalBinaryField"));
        v.setOptionalStringField(read_nullable_string_("OptionalStringField"));
        return v;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject();
        v.setObjectArrayField(read_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__("ObjectArrayField"));
        v.setEnumArrayField(read_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__("EnumArrayField"));
        v.setBoolArrayField(read_array_boolean_("BoolArrayField"));
        v.setByteArrayField(read_array_byte_("ByteArrayField"));
        v.setInt16ArrayField(read_array_int16_("Int16ArrayField"));
        v.setUInt16ArrayField(read_array_uint16_("UInt16ArrayField"));
        v.setInt32ArrayField(read_array_int32_("Int32ArrayField"));
        v.setUInt32ArrayField(read_array_uint32_("UInt32ArrayField"));
        v.setInt64ArrayField(read_array_int64_("Int64ArrayField"));
        v.setUInt64ArrayField(read_array_uint64_("UInt64ArrayField"));
        v.setFloatArrayField(read_array_float_("FloatArrayField"));
        v.setDoubleArrayField(read_array_double_("DoubleArrayField"));
        v.setStringArrayField(read_array_string_("StringArrayField"));
        return v;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject();
        v.setObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_("ObjectField"));
        v.setEnumField(read_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_("EnumField"));
        v.setBoolField(read_boolean("BoolField"));
        v.setByteField(read_byte("ByteField"));
        v.setInt16Field(read_int16("Int16Field"));
        v.setUInt16Field(read_uint16("UInt16Field"));
        v.setInt32Field(read_int32("Int32Field"));
        v.setUInt32Field(read_uint32("UInt32Field"));
        v.setInt64Field(read_int64("Int64Field"));
        v.setUInt64Field(read_uint64("UInt64Field"));
        v.setFloatField(read_float("FloatField"));
        v.setDoubleField(read_double("DoubleField"));
        v.setBinaryField(read_binary("BinaryField"));
        v.setStringField(read_string("StringField"));
        return v;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject();
        v.setObjectReferenceField(read_reference_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__("ObjectReferenceField"));
        v.setEnumReferenceField(read_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__("EnumReferenceField"));
        v.setBoolReferenceField(read_reference_boolean_("BoolReferenceField"));
        v.setByteReferenceField(read_reference_byte_("ByteReferenceField"));
        v.setInt16ReferenceField(read_reference_int16_("Int16ReferenceField"));
        v.setUInt16ReferenceField(read_reference_uint16_("UInt16ReferenceField"));
        v.setInt32ReferenceField(read_reference_int32_("Int32ReferenceField"));
        v.setUInt32ReferenceField(read_reference_uint32_("UInt32ReferenceField"));
        v.setInt64ReferenceField(read_reference_int64_("Int64ReferenceField"));
        v.setUInt64ReferenceField(read_reference_uint64_("UInt64ReferenceField"));
        v.setFloatReferenceField(read_reference_float_("FloatReferenceField"));
        v.setDoubleReferenceField(read_reference_double_("DoubleReferenceField"));
        v.setBinaryReferenceField(read_reference_binary_("BinaryReferenceField"));
        v.setStringReferenceField(read_reference_string_("StringReferenceField"));
        return v;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestObject_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestObject_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject();
        v.setBasicTestObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_("BasicTestObjectField"));
        v.setReferenceTestObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_("ReferenceTestObjectField"));
        v.setOptionalBasicTestObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_("OptionalBasicTestObjectField"));
        v.setArrayTestObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_("ArrayTestObjectField"));
        v.setArray2DTestObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_("Array2DTestObjectField"));
        v.setOptionalArrayTestObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_("OptionalArrayTestObjectField"));
        return v;
    }
    

    public java.util.List<java.util.List<java.lang.Short>> read_array_array_uint16__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.util.List<java.lang.Short>> v = new java.util.ArrayList<java.util.List<java.lang.Short>>();
        for (int i = 0; i < size; i++) {
            v.add(read_array_uint16_(name));
        }
        return v;
    }

    public java.util.List<java.util.List<java.lang.Boolean>> read_array_array_boolean__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.util.List<java.lang.Boolean>> v = new java.util.ArrayList<java.util.List<java.lang.Boolean>>();
        for (int i = 0; i < size; i++) {
            v.add(read_array_boolean_(name));
        }
        return v;
    }

    public java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> read_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> v = new java.util.ArrayList<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>();
        for (int i = 0; i < size; i++) {
            v.add(read_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(name));
        }
        return v;
    }

    public java.lang.Byte read_reference_byte_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, java.lang.Byte.class);
        } else {
            byte v = read_byte(name);
            refPolicy.putInputReference(-id, v, java.lang.Byte.class);
            return v;
        }
    }

    public java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> read_nullable_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(name);
        } else {
            return null;
        }
    }


    public java.lang.Short read_nullable_int16_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_int16(name);
        } else {
            return null;
        }
    }

    public java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> read_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> v = new java.util.ArrayList<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>();
        for (int i = 0; i < size; i++) {
            v.add(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(name));
        }
        return v;
    }

    public java.util.List<java.lang.Byte> read_array_byte_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.lang.Byte> v = new java.util.ArrayList<java.lang.Byte>();
        for (int i = 0; i < size; i++) {
            v.add(read_byte(name));
        }
        return v;
    }

    public java.lang.Integer read_nullable_int32_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_int32(name);
        } else {
            return null;
        }
    }

    public java.util.List<java.lang.Boolean> read_nullable_array_boolean__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_array_boolean_(name);
        } else {
            return null;
        }
    }

    public java.util.List<java.util.List<java.lang.Short>> read_array_array_int16__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.util.List<java.lang.Short>> v = new java.util.ArrayList<java.util.List<java.lang.Short>>();
        for (int i = 0; i < size; i++) {
            v.add(read_array_int16_(name));
        }
        return v;
    }

    public float read_float(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readFloat(name);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject read_reference_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject.class);
        } else {
            com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v = read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(name);
            refPolicy.putInputReference(-id, v, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject.class);
            return v;
        }
    }

    public java.util.List<java.util.List<java.lang.String>> read_array_array_string__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.util.List<java.lang.String>> v = new java.util.ArrayList<java.util.List<java.lang.String>>();
        for (int i = 0; i < size; i++) {
            v.add(read_array_string_(name));
        }
        return v;
    }

    public java.util.List<java.lang.Boolean> read_array_boolean_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.lang.Boolean> v = new java.util.ArrayList<java.lang.Boolean>();
        for (int i = 0; i < size; i++) {
            v.add(read_boolean(name));
        }
        return v;
    }

    public java.util.List<java.util.List<java.lang.Byte>> read_array_array_byte__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.util.List<java.lang.Byte>> v = new java.util.ArrayList<java.util.List<java.lang.Byte>>();
        for (int i = 0; i < size; i++) {
            v.add(read_array_byte_(name));
        }
        return v;
    }

    public short read_uint16(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readUInt16(name);
    }

    public java.lang.Short read_reference_uint16_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, java.lang.Short.class);
        } else {
            short v = read_uint16(name);
            refPolicy.putInputReference(-id, v, java.lang.Short.class);
            return v;
        }
    }

    public java.lang.Short read_reference_int16_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, java.lang.Short.class);
        } else {
            short v = read_int16(name);
            refPolicy.putInputReference(-id, v, java.lang.Short.class);
            return v;
        }
    }

    public java.util.List<java.lang.Integer> read_array_uint32_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.lang.Integer> v = new java.util.ArrayList<java.lang.Integer>();
        for (int i = 0; i < size; i++) {
            v.add(read_uint32(name));
        }
        return v;
    }

    public long read_int64(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readInt64(name);
    }

    public byte read_byte(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readByte(name);
    }


    public java.lang.Double read_nullable_double_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_double(name);
        } else {
            return null;
        }
    }

    public java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>> read_array_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>> v = new java.util.ArrayList<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>>();
        for (int i = 0; i < size; i++) {
            v.add(read_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(name));
        }
        return v;
    }

    public boolean read_boolean(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readBoolean(name);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum read_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(name);
        } else {
            return null;
        }
    }

    public java.lang.Long read_nullable_uint64_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_uint64(name);
        } else {
            return null;
        }
    }

    public java.lang.Short read_nullable_uint16_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_uint16(name);
        } else {
            return null;
        }
    }

    public java.util.List<java.lang.String> read_array_string_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.lang.String> v = new java.util.ArrayList<java.lang.String>();
        for (int i = 0; i < size; i++) {
            v.add(read_string(name));
        }
        return v;
    }

    public short read_int16(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readInt16(name);
    }

    public java.util.List<java.lang.Long> read_array_int64_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.lang.Long> v = new java.util.ArrayList<java.lang.Long>();
        for (int i = 0; i < size; i++) {
            v.add(read_int64(name));
        }
        return v;
    }

    public java.lang.Integer read_reference_uint32_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, java.lang.Integer.class);
        } else {
            int v = read_uint32(name);
            refPolicy.putInputReference(-id, v, java.lang.Integer.class);
            return v;
        }
    }

    public java.util.List<java.util.List<java.lang.Integer>> read_array_array_uint32__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.util.List<java.lang.Integer>> v = new java.util.ArrayList<java.util.List<java.lang.Integer>>();
        for (int i = 0; i < size; i++) {
            v.add(read_array_uint32_(name));
        }
        return v;
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum read_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum.class);
        } else {
            com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum v = read_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(name);
            refPolicy.putInputReference(-id, v, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum.class);
            return v;
        }
    }

    public double read_double(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readDouble(name);
    }

    public java.lang.Integer read_nullable_uint32_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_uint32(name);
        } else {
            return null;
        }
    }

    public java.util.List<java.lang.Short> read_array_int16_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.lang.Short> v = new java.util.ArrayList<java.lang.Short>();
        for (int i = 0; i < size; i++) {
            v.add(read_int16(name));
        }
        return v;
    }

    public byte[] read_reference_binary_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, byte[].class);
        } else {
            byte[] v = read_binary(name);
            refPolicy.putInputReference(-id, v, byte[].class);
            return v;
        }
    }


    public java.util.List<java.lang.Integer> read_array_int32_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.lang.Integer> v = new java.util.ArrayList<java.lang.Integer>();
        for (int i = 0; i < size; i++) {
            v.add(read_int32(name));
        }
        return v;
    }

    public java.util.List<java.lang.Double> read_array_double_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.lang.Double> v = new java.util.ArrayList<java.lang.Double>();
        for (int i = 0; i < size; i++) {
            v.add(read_double(name));
        }
        return v;
    }

    public java.util.List<java.lang.Long> read_array_uint64_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.lang.Long> v = new java.util.ArrayList<java.lang.Long>();
        for (int i = 0; i < size; i++) {
            v.add(read_uint64(name));
        }
        return v;
    }

    public java.lang.String read_reference_string_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, java.lang.String.class);
        } else {
            java.lang.String v = read_string(name);
            refPolicy.putInputReference(-id, v, java.lang.String.class);
            return v;
        }
    }

    public java.util.List<java.lang.Short> read_nullable_array_uint16__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_array_uint16_(name);
        } else {
            return null;
        }
    }

    public java.lang.Boolean read_reference_boolean_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, java.lang.Boolean.class);
        } else {
            boolean v = read_boolean(name);
            refPolicy.putInputReference(-id, v, java.lang.Boolean.class);
            return v;
        }
    }

    public java.util.List<java.lang.Long> read_nullable_array_int64__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_array_int64_(name);
        } else {
            return null;
        }
    }

    public byte[] read_binary(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readBinary(name);
    }


    public java.lang.Byte read_nullable_byte_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_byte(name);
        } else {
            return null;
        }
    }

    public java.lang.Long read_nullable_int64_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_int64(name);
        } else {
            return null;
        }
    }

    public java.lang.Long read_reference_int64_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, java.lang.Long.class);
        } else {
            long v = read_int64(name);
            refPolicy.putInputReference(-id, v, java.lang.Long.class);
            return v;
        }
    }

    public int read_uint32(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readUInt32(name);
    }

    public java.lang.Float read_nullable_float_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_float(name);
        } else {
            return null;
        }
    }

    public java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>> read_array_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>> v = new java.util.ArrayList<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>>();
        for (int i = 0; i < size; i++) {
            v.add(read_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(name));
        }
        return v;
    }

    public java.util.List<java.util.List<java.lang.Integer>> read_array_array_int32__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.util.List<java.lang.Integer>> v = new java.util.ArrayList<java.util.List<java.lang.Integer>>();
        for (int i = 0; i < size; i++) {
            v.add(read_array_int32_(name));
        }
        return v;
    }

    public java.util.List<java.lang.Long> read_nullable_array_uint64__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_array_uint64_(name);
        } else {
            return null;
        }
    }


    public java.lang.String read_nullable_string_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_string(name);
        } else {
            return null;
        }
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject read_nullable_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(name);
        } else {
            return null;
        }
    }

    public java.util.List<java.lang.Float> read_nullable_array_float__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_array_float_(name);
        } else {
            return null;
        }
    }

    public java.util.List<java.util.List<java.lang.Double>> read_array_array_double__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.util.List<java.lang.Double>> v = new java.util.ArrayList<java.util.List<java.lang.Double>>();
        for (int i = 0; i < size; i++) {
            v.add(read_array_double_(name));
        }
        return v;
    }

    public java.lang.Float read_reference_float_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, java.lang.Float.class);
        } else {
            float v = read_float(name);
            refPolicy.putInputReference(-id, v, java.lang.Float.class);
            return v;
        }
    }

    public java.util.List<java.lang.Integer> read_nullable_array_uint32__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_array_uint32_(name);
        } else {
            return null;
        }
    }

    public byte[] read_nullable_binary_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_binary(name);
        } else {
            return null;
        }
    }

    public java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> read_nullable_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(name);
        } else {
            return null;
        }
    }

    public java.lang.Boolean read_nullable_boolean_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_boolean(name);
        } else {
            return null;
        }
    }


    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum read_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int v = read_int32(name);
        switch (v) {
        case 1:
            return com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum.Info;
        case 2:
            return com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum.Warning;
        case 3:
            return com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum.Error;
        default:
            throw new java.io.IOException(String.format(
                "Invalid Enum value '%d' encountered when reading field %s (type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>')", 
                v, name));
        }
    }

    public long read_uint64(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readUInt64(name);
    }

    public java.util.List<java.lang.Short> read_array_uint16_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.lang.Short> v = new java.util.ArrayList<java.lang.Short>();
        for (int i = 0; i < size; i++) {
            v.add(read_uint16(name));
        }
        return v;
    }

    public int read_int32(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readInt32(name);
    }

    public java.util.List<java.lang.String> read_nullable_array_string__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_array_string_(name);
        } else {
            return null;
        }
    }

    public java.util.List<java.lang.Integer> read_nullable_array_int32__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_array_int32_(name);
        } else {
            return null;
        }
    }

    public java.lang.Double read_reference_double_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, java.lang.Double.class);
        } else {
            double v = read_double(name);
            refPolicy.putInputReference(-id, v, java.lang.Double.class);
            return v;
        }
    }

    public java.util.List<java.lang.Float> read_array_float_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.lang.Float> v = new java.util.ArrayList<java.lang.Float>();
        for (int i = 0; i < size; i++) {
            v.add(read_float(name));
        }
        return v;
    }

    public java.lang.Integer read_reference_int32_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, java.lang.Integer.class);
        } else {
            int v = read_int32(name);
            refPolicy.putInputReference(-id, v, java.lang.Integer.class);
            return v;
        }
    }

    public java.lang.String read_string(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readString(name);
    }

    public java.util.List<java.util.List<java.lang.Float>> read_array_array_float__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.util.List<java.lang.Float>> v = new java.util.ArrayList<java.util.List<java.lang.Float>>();
        for (int i = 0; i < size; i++) {
            v.add(read_array_float_(name));
        }
        return v;
    }

    public java.lang.Long read_reference_uint64_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, java.lang.Long.class);
        } else {
            long v = read_uint64(name);
            refPolicy.putInputReference(-id, v, java.lang.Long.class);
            return v;
        }
    }

    public java.util.List<java.util.List<java.lang.Long>> read_array_array_int64__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.util.List<java.lang.Long>> v = new java.util.ArrayList<java.util.List<java.lang.Long>>();
        for (int i = 0; i < size; i++) {
            v.add(read_array_int64_(name));
        }
        return v;
    }


    public java.util.List<java.lang.Double> read_nullable_array_double__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_array_double_(name);
        } else {
            return null;
        }
    }

    public java.util.List<java.util.List<java.lang.Long>> read_array_array_uint64__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.util.List<java.lang.Long>> v = new java.util.ArrayList<java.util.List<java.lang.Long>>();
        for (int i = 0; i < size; i++) {
            v.add(read_array_uint64_(name));
        }
        return v;
    }


    public java.util.List<java.lang.Byte> read_nullable_array_byte__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_array_byte_(name);
        } else {
            return null;
        }
    }

    public java.util.List<java.lang.Short> read_nullable_array_int16__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_array_int16_(name);
        } else {
            return null;
        }
    }

}


class TeslaBinaryWriter_compiler_test_passcompile_full_complexttypetest extends Serializer.ObjectWriter {


    public static final long SCHEMA_HASH = -5586303099293846137L;
    private com.expedia.tesla.serialization.BinaryWriter writer;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    public TeslaBinaryWriter_compiler_test_passcompile_full_complexttypetest(OutputStream stream) {
        writer = new com.expedia.tesla.serialization.BinaryWriter(stream, SCHEMA_HASH);
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_complexttypetest_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.complexttypetest v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_array_reference_string__("field1", v.getField1());
        write_array_array_reference_string___("field2", v.getField2());
        write_array_array_array_reference_string____("field3", v.getField3());
        write_reference_array_string__("field4", v.getField4());
        write_reference_array_reference_string___("field5", v.getField5());
    }


    public void write_int32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeInt32(name, v);
    }
    
    
    public void write_array_reference_string__(java.lang.String name, java.util.List<java.lang.String> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (java.lang.String e : v) {
            write_reference_string_(name, e);
        }
    }
    
    
    public void write_array_string_(java.lang.String name, java.util.List<java.lang.String> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (java.lang.String e : v) {
            write_string(name, e);
        }
    }
    
    
    public void write_string(java.lang.String name, java.lang.String v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeString(name, v);
    }
    
    
    public void write_reference_string_(java.lang.String name, java.lang.String v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, java.lang.String.class);
        write_int32(null, id);
        if (id < 0) {
            write_string(name, (java.lang.String)v);
        }
    }

    
    public void write_uint32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeUInt32(name, v);
    }
    
    
    public void write_boolean(java.lang.String name, boolean v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeBoolean(name, v);
    }
    
    
    public void write_array_array_array_reference_string____(java.lang.String name, java.util.List<java.util.List<java.util.List<java.lang.String>>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (java.util.List<java.util.List<java.lang.String>> e : v) {
            write_array_array_reference_string___(name, e);
        }
    }
    
    
    public void write_reference_array_reference_string___(java.lang.String name, java.util.List<java.lang.String> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, java.util.ArrayList.class);
        write_int32(null, id);
        if (id < 0) {
            write_array_reference_string__(name, (java.util.List<java.lang.String>)v);
        }
    }

    
    
    public void write_reference_array_string__(java.lang.String name, java.util.List<java.lang.String> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, java.util.ArrayList.class);
        write_int32(null, id);
        if (id < 0) {
            write_array_string_(name, (java.util.List<java.lang.String>)v);
        }
    }

    
    public void write_array_array_reference_string___(java.lang.String name, java.util.List<java.util.List<java.lang.String>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (java.util.List<java.lang.String> e : v) {
            write_array_reference_string__(name, e);
        }
    }
    
    
}

class TeslaBinaryReader_compiler_test_passcompile_full_complexttypetest extends Serializer.ObjectReader {


    public static final long SCHEMA_HASH = -5586303099293846137L;
    private com.expedia.tesla.serialization.BinaryReader reader;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
            
    TeslaBinaryReader_compiler_test_passcompile_full_complexttypetest(InputStream stream) {
        reader = new com.expedia.tesla.serialization.BinaryReader(stream, SCHEMA_HASH);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.complexttypetest read_class_com_expedia_tesla_compiler_test_passcompile_full_complexttypetest_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_complexttypetest_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.complexttypetest read_class_com_expedia_tesla_compiler_test_passcompile_full_complexttypetest_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.complexttypetest v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.complexttypetest();
        v.getField1(read_array_reference_string__("field1"));
        v.getField2(read_array_array_reference_string___("field2"));
        v.getField3(read_array_array_array_reference_string____("field3"));
        v.getField4(read_reference_array_string__("field4"));
        v.getField5(read_reference_array_reference_string___("field5"));
        return v;
    }
    

    public int read_int32(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readInt32(name);
    }

    public java.util.List<java.lang.String> read_array_reference_string__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.lang.String> v = new java.util.ArrayList<java.lang.String>();
        for (int i = 0; i < size; i++) {
            v.add(read_reference_string_(name));
        }
        return v;
    }

    public java.util.List<java.lang.String> read_array_string_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.lang.String> v = new java.util.ArrayList<java.lang.String>();
        for (int i = 0; i < size; i++) {
            v.add(read_string(name));
        }
        return v;
    }

    public java.lang.String read_string(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readString(name);
    }

    public java.lang.String read_reference_string_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, java.lang.String.class);
        } else {
            java.lang.String v = read_string(name);
            refPolicy.putInputReference(-id, v, java.lang.String.class);
            return v;
        }
    }

    public int read_uint32(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readUInt32(name);
    }

    public boolean read_boolean(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readBoolean(name);
    }

    public java.util.List<java.util.List<java.util.List<java.lang.String>>> read_array_array_array_reference_string____(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.util.List<java.util.List<java.lang.String>>> v = new java.util.ArrayList<java.util.List<java.util.List<java.lang.String>>>();
        for (int i = 0; i < size; i++) {
            v.add(read_array_array_reference_string___(name));
        }
        return v;
    }

    public java.util.List<java.lang.String> read_reference_array_reference_string___(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, java.util.ArrayList.class);
        } else {
            java.util.List<java.lang.String> v = read_array_reference_string__(name);
            refPolicy.putInputReference(-id, v, java.util.ArrayList.class);
            return v;
        }
    }


    public java.util.List<java.lang.String> read_reference_array_string__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, java.util.ArrayList.class);
        } else {
            java.util.List<java.lang.String> v = read_array_string_(name);
            refPolicy.putInputReference(-id, v, java.util.ArrayList.class);
            return v;
        }
    }

    public java.util.List<java.util.List<java.lang.String>> read_array_array_reference_string___(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.util.List<java.lang.String>> v = new java.util.ArrayList<java.util.List<java.lang.String>>();
        for (int i = 0; i < size; i++) {
            v.add(read_array_reference_string__(name));
        }
        return v;
    }

}


class TeslaBinaryWriter_compiler_test_passcompile_full_inheritance_v1_0 extends Serializer.ObjectWriter {


    public static final long SCHEMA_HASH = -4144946394736392407L;
    private com.expedia.tesla.serialization.BinaryWriter writer;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    public TeslaBinaryWriter_compiler_test_passcompile_full_inheritance_v1_0(OutputStream stream) {
        writer = new com.expedia.tesla.serialization.BinaryWriter(stream, SCHEMA_HASH);
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_SingleDerived_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_int32("Int32Field", v.getInt32Field());
        write_boolean("BooleanField", v.getBooleanField());
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base2_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_int16("Int16Field", v.getInt16Field());
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base1_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_int32("Int32Field", v.getInt32Field());
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_MultiDerived_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_int32("Int32Field", v.getInt32Field());
        write_int16("Int16Field", v.getInt16Field());
        write_byte("ByteField", v.getByteField());
    }


    public void write_int32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeInt32(name, v);
    }
    
    
    
    
    public void write_byte(java.lang.String name, byte v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeByte(name, v);
    }
    
    
    
    public void write_int16(java.lang.String name, short v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeInt16(name, v);
    }
    
    
    public void write_uint32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeUInt32(name, v);
    }
    
    
    public void write_boolean(java.lang.String name, boolean v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeBoolean(name, v);
    }
    
    
    
}

class TeslaBinaryReader_compiler_test_passcompile_full_inheritance_v1_0 extends Serializer.ObjectReader {


    public static final long SCHEMA_HASH = -4144946394736392407L;
    private com.expedia.tesla.serialization.BinaryReader reader;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
            
    TeslaBinaryReader_compiler_test_passcompile_full_inheritance_v1_0(InputStream stream) {
        reader = new com.expedia.tesla.serialization.BinaryReader(stream, SCHEMA_HASH);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_SingleDerived_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_SingleDerived_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_SingleDerived_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived();
        v.setInt32Field(read_int32("Int32Field"));
        v.setBooleanField(read_boolean("BooleanField"));
        return v;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base2_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base2_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base2_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2();
        v.setInt16Field(read_int16("Int16Field"));
        return v;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base1_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base1_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base1_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1();
        v.setInt32Field(read_int32("Int32Field"));
        return v;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_MultiDerived_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_MultiDerived_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_MultiDerived_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived();
        v.setInt32Field(read_int32("Int32Field"));
        v.setInt16Field(read_int16("Int16Field"));
        v.setByteField(read_byte("ByteField"));
        return v;
    }
    

    public int read_int32(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readInt32(name);
    }



    public byte read_byte(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readByte(name);
    }


    public short read_int16(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readInt16(name);
    }

    public int read_uint32(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readUInt32(name);
    }

    public boolean read_boolean(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readBoolean(name);
    }


}


class TeslaBinaryWriter_teslacompiler_reference_test_v1_0 extends Serializer.ObjectWriter {


    public static final long SCHEMA_HASH = -8997496319200256941L;
    private com.expedia.tesla.serialization.BinaryWriter writer;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    public TeslaBinaryWriter_teslacompiler_reference_test_v1_0(OutputStream stream) {
        writer = new com.expedia.tesla.serialization.BinaryWriter(stream, SCHEMA_HASH);
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_EnumReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum__("ReferenceField1", v.getReferenceField1());
        write_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum__("ReferenceField2", v.getReferenceField2());
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_StringReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_reference_string_("ReferenceField1", v.getReferenceField1());
        write_reference_string_("ReferenceField2", v.getReferenceField2());
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_int32("IntField", v.getIntField());
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_Int32Reference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_reference_int32_("ReferenceField1", v.getReferenceField1());
        write_reference_int32_("ReferenceField2", v.getReferenceField2());
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ObjectReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__("ReferenceField1", v.getReferenceField1());
        write_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__("ReferenceField2", v.getReferenceField2());
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ArrayReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_reference_array_int32__("ReferenceField1", v.getReferenceField1());
        write_reference_array_int32__("ReferenceField2", v.getReferenceField2());
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ReferenceArray_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_array_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject___("ReferenceArrayField", v.getReferenceArrayField());
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_BinaryReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_reference_binary_("ReferenceField1", v.getReferenceField1());
        write_reference_binary_("ReferenceField2", v.getReferenceField2());
    }


    public void write_binary(java.lang.String name, byte[] v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeBinary(name, v);
    }
    
    
    public void write_array_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject___(java.lang.String name, java.util.List<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject e : v) {
            write_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__(name, e);
        }
    }
    
    
    
    
    
    public void write_uint32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeUInt32(name, v);
    }
    
    
    public void write_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum__(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum.class);
        write_int32(null, id);
        if (id < 0) {
            write_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum_(name, (com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum)v);
        }
    }

    
    public void write_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        switch (v) {
        case Info:
            write_int32(name, 1);
            break;
        case Warning:
            write_int32(name, 2);
            break;
        case Error:
            write_int32(name, 3);
            break;
        default:
            throw new com.expedia.tesla.serialization.TeslaSerializationException(String.format(
                "Enum value %s is not allowed on field %s (type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum>')", 
                v.toString(), name));
        }
    }
    
    
    
    public void write_reference_binary_(java.lang.String name, byte[] v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, byte[].class);
        write_int32(null, id);
        if (id < 0) {
            write_binary(name, (byte[])v);
        }
    }

    
    
    public void write_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject.class);
        write_int32(null, id);
        if (id < 0) {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(name, (com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject)v);
        }
    }

    
    public void write_array_int32_(java.lang.String name, java.util.List<java.lang.Integer> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (int e : v) {
            write_int32(name, e);
        }
    }
    
    
    public void write_int32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeInt32(name, v);
    }
    
    
    
    public void write_reference_array_int32__(java.lang.String name, java.util.List<java.lang.Integer> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, java.util.ArrayList.class);
        write_int32(null, id);
        if (id < 0) {
            write_array_int32_(name, (java.util.List<java.lang.Integer>)v);
        }
    }

    
    public void write_reference_int32_(java.lang.String name, java.lang.Integer v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, java.lang.Integer.class);
        write_int32(null, id);
        if (id < 0) {
            write_int32(name, (java.lang.Integer)v);
        }
    }

    
    
    public void write_string(java.lang.String name, java.lang.String v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeString(name, v);
    }
    
    
    public void write_reference_string_(java.lang.String name, java.lang.String v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, java.lang.String.class);
        write_int32(null, id);
        if (id < 0) {
            write_string(name, (java.lang.String)v);
        }
    }

    
    public void write_boolean(java.lang.String name, boolean v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeBoolean(name, v);
    }
    
    
    
}

class TeslaBinaryReader_teslacompiler_reference_test_v1_0 extends Serializer.ObjectReader {


    public static final long SCHEMA_HASH = -8997496319200256941L;
    private com.expedia.tesla.serialization.BinaryReader reader;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
            
    TeslaBinaryReader_teslacompiler_reference_test_v1_0(InputStream stream) {
        reader = new com.expedia.tesla.serialization.BinaryReader(stream, SCHEMA_HASH);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_EnumReference_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_EnumReference_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_EnumReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference();
        v.setReferenceField1(read_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum__("ReferenceField1"));
        v.setReferenceField2(read_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum__("ReferenceField2"));
        return v;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_StringReference_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_StringReference_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_StringReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference();
        v.setReferenceField1(read_reference_string_("ReferenceField1"));
        v.setReferenceField2(read_reference_string_("ReferenceField2"));
        return v;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject();
        v.setIntField(read_int32("IntField"));
        return v;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_Int32Reference_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_Int32Reference_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_Int32Reference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference();
        v.setReferenceField1(read_reference_int32_("ReferenceField1"));
        v.setReferenceField2(read_reference_int32_("ReferenceField2"));
        return v;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ObjectReference_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ObjectReference_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ObjectReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference();
        v.setReferenceField1(read_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__("ReferenceField1"));
        v.setReferenceField2(read_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__("ReferenceField2"));
        return v;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ArrayReference_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ArrayReference_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ArrayReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference();
        v.setReferenceField1(read_reference_array_int32__("ReferenceField1"));
        v.setReferenceField2(read_reference_array_int32__("ReferenceField2"));
        return v;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ReferenceArray_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ReferenceArray_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ReferenceArray_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray();
        v.setReferenceArrayField(read_array_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject___("ReferenceArrayField"));
        return v;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_BinaryReference_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_BinaryReference_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_BinaryReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference();
        v.setReferenceField1(read_reference_binary_("ReferenceField1"));
        v.setReferenceField2(read_reference_binary_("ReferenceField2"));
        return v;
    }
    

    public byte[] read_binary(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readBinary(name);
    }

    public java.util.List<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject> read_array_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject___(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject> v = new java.util.ArrayList<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject>();
        for (int i = 0; i < size; i++) {
            v.add(read_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__(name));
        }
        return v;
    }




    public int read_uint32(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readUInt32(name);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum read_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum.class);
        } else {
            com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum v = read_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum_(name);
            refPolicy.putInputReference(-id, v, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum.class);
            return v;
        }
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum read_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int v = read_int32(name);
        switch (v) {
        case 1:
            return com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum.Info;
        case 2:
            return com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum.Warning;
        case 3:
            return com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum.Error;
        default:
            throw new java.io.IOException(String.format(
                "Invalid Enum value '%d' encountered when reading field %s (type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum>')", 
                v, name));
        }
    }


    public byte[] read_reference_binary_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, byte[].class);
        } else {
            byte[] v = read_binary(name);
            refPolicy.putInputReference(-id, v, byte[].class);
            return v;
        }
    }


    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject read_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject.class);
        } else {
            com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject v = read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(name);
            refPolicy.putInputReference(-id, v, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject.class);
            return v;
        }
    }

    public java.util.List<java.lang.Integer> read_array_int32_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.List<java.lang.Integer> v = new java.util.ArrayList<java.lang.Integer>();
        for (int i = 0; i < size; i++) {
            v.add(read_int32(name));
        }
        return v;
    }

    public int read_int32(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readInt32(name);
    }


    public java.util.List<java.lang.Integer> read_reference_array_int32__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, java.util.ArrayList.class);
        } else {
            java.util.List<java.lang.Integer> v = read_array_int32_(name);
            refPolicy.putInputReference(-id, v, java.util.ArrayList.class);
            return v;
        }
    }

    public java.lang.Integer read_reference_int32_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, java.lang.Integer.class);
        } else {
            int v = read_int32(name);
            refPolicy.putInputReference(-id, v, java.lang.Integer.class);
            return v;
        }
    }


    public java.lang.String read_string(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readString(name);
    }

    public java.lang.String read_reference_string_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, java.lang.String.class);
        } else {
            java.lang.String v = read_string(name);
            refPolicy.putInputReference(-id, v, java.lang.String.class);
            return v;
        }
    }

    public boolean read_boolean(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readBoolean(name);
    }


}


class TeslaBinaryWriter_versioning_test_v1_0 extends Serializer.ObjectWriter {


    public static final long SCHEMA_HASH = -1533394106668605082L;
    private com.expedia.tesla.serialization.BinaryWriter writer;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    public TeslaBinaryWriter_versioning_test_v1_0(OutputStream stream) {
        writer = new com.expedia.tesla.serialization.BinaryWriter(stream, SCHEMA_HASH);
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__("EnumField", v.getEnumField());
        write_nullable_int32_("DepricatedInt32Field", v.getDepricatedInt32Field());
    }


    public void write_int32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeInt32(name, v);
    }
    
    
    public void write_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(name, v);
        }
    }

    
    public void write_uint32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeUInt32(name, v);
    }
    
    
    public void write_boolean(java.lang.String name, boolean v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeBoolean(name, v);
    }
    
    
    public void write_nullable_int32_(java.lang.String name, java.lang.Integer v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_int32(name, v);
        }
    }

    
    
    public void write_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        switch (v) {
        case Value1:
            write_int32(name, 1);
            break;
        case Value2:
            write_int32(name, 2);
            break;
        case Value3:
            write_int32(name, 3);
            break;
        default:
            throw new com.expedia.tesla.serialization.TeslaSerializationException(String.format(
                "Enum value %s is not allowed on field %s (type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum>')", 
                v.toString(), name));
        }
    }
    
    
}

class TeslaBinaryReader_versioning_test_v1_0 extends Serializer.ObjectReader {


    public static final long SCHEMA_HASH = -1533394106668605082L;
    private com.expedia.tesla.serialization.BinaryReader reader;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
            
    TeslaBinaryReader_versioning_test_v1_0(InputStream stream) {
        reader = new com.expedia.tesla.serialization.BinaryReader(stream, SCHEMA_HASH);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject();
        v.setEnumField(read_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__("EnumField"));
        v.setDepricatedInt32Field(read_nullable_int32_("DepricatedInt32Field"));
        return v;
    }
    

    public int read_int32(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readInt32(name);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum read_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(name);
        } else {
            return null;
        }
    }

    public int read_uint32(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readUInt32(name);
    }

    public boolean read_boolean(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readBoolean(name);
    }

    public java.lang.Integer read_nullable_int32_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_int32(name);
        } else {
            return null;
        }
    }


    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum read_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int v = read_int32(name);
        switch (v) {
        case 1:
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value1;
        case 2:
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value2;
        case 3:
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value3;
        default:
            throw new java.io.IOException(String.format(
                "Invalid Enum value '%d' encountered when reading field %s (type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum>')", 
                v, name));
        }
    }

}


class TeslaBinaryWriter_versioning_test_v2_0 extends Serializer.ObjectWriter {


    public static final long SCHEMA_HASH = 3897695751964630335L;
    private com.expedia.tesla.serialization.BinaryWriter writer;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    public TeslaBinaryWriter_versioning_test_v2_0(OutputStream stream) {
        writer = new com.expedia.tesla.serialization.BinaryWriter(stream, SCHEMA_HASH);
    }

    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__("EnumField", v.getEnumField());
        write_nullable_int64_("NewInt64Field", v.getNewInt64Field());
    }


    public void write_int32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeInt32(name, v);
    }
    
    
    public void write_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(name, v);
        }
    }

    
    public void write_nullable_int64_(java.lang.String name, java.lang.Long v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_int64(name, v);
        }
    }

    
    public void write_int64(java.lang.String name, long v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeInt64(name, v);
    }
    
    
    public void write_uint32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeUInt32(name, v);
    }
    
    
    public void write_boolean(java.lang.String name, boolean v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeBoolean(name, v);
    }
    
    
    
    public void write_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        switch (v) {
        case Value1:
            write_int32(name, 1);
            break;
        case Value5:
            write_int32(name, 5);
            break;
        case Value2:
            write_int32(name, 2);
            break;
        case Value4:
            write_int32(name, 4);
            break;
        default:
            throw new com.expedia.tesla.serialization.TeslaSerializationException(String.format(
                "Enum value %s is not allowed on field %s (type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum>')", 
                v.toString(), name));
        }
    }
    
    
}

class TeslaBinaryReader_versioning_test_v2_0 extends Serializer.ObjectReader {


    public static final long SCHEMA_HASH = 3897695751964630335L;
    private com.expedia.tesla.serialization.BinaryReader reader;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
            
    TeslaBinaryReader_versioning_test_v2_0(InputStream stream) {
        reader = new com.expedia.tesla.serialization.BinaryReader(stream, SCHEMA_HASH);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(name, null);
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject();
        v.setEnumField(read_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__("EnumField"));
        v.setNewInt64Field(read_nullable_int64_("NewInt64Field"));
        return v;
    }
    

    public int read_int32(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readInt32(name);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum read_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(name);
        } else {
            return null;
        }
    }

    public java.lang.Long read_nullable_int64_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_int64(name);
        } else {
            return null;
        }
    }

    public long read_int64(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readInt64(name);
    }

    public int read_uint32(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readUInt32(name);
    }

    public boolean read_boolean(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readBoolean(name);
    }


    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum read_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int v = read_int32(name);
        switch (v) {
        case 1:
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value1;
        case 5:
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value5;
        case 2:
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value2;
        case 4:
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value4;
        default:
            throw new java.io.IOException(String.format(
                "Invalid Enum value '%d' encountered when reading field %s (type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum>')", 
                v, name));
        }
    }

}



class TeslaJsonWriter_teslacompiler_all_types_v1_0 extends Serializer.ObjectWriter {


    public static final long SCHEMA_HASH = 7810441853185379917L;
    private static final com.fasterxml.jackson.core.JsonFactory JSON_FACTORY = new com.fasterxml.jackson.core.JsonFactory();
    private com.fasterxml.jackson.core.JsonGenerator jsonGenerator;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
	
	TeslaJsonWriter_teslacompiler_all_types_v1_0(java.io.OutputStream stream) throws java.io.IOException {
        jsonGenerator = JSON_FACTORY.createGenerator(stream);
    }






    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("OptionalObjectArrayField"); 
        write_nullable_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___("OptionalObjectArrayField", v.getOptionalObjectArrayField());
        jsonGenerator.writeFieldName("OptionalEnumArrayField"); 
        write_nullable_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___("OptionalEnumArrayField", v.getOptionalEnumArrayField());
        jsonGenerator.writeFieldName("OptionalBoolArrayField"); 
        write_nullable_array_boolean__("OptionalBoolArrayField", v.getOptionalBoolArrayField());
        jsonGenerator.writeFieldName("OptionalByteArrayField"); 
        write_nullable_array_byte__("OptionalByteArrayField", v.getOptionalByteArrayField());
        jsonGenerator.writeFieldName("OptionalInt16ArrayField"); 
        write_nullable_array_int16__("OptionalInt16ArrayField", v.getOptionalInt16ArrayField());
        jsonGenerator.writeFieldName("OptionalUInt16ArrayField"); 
        write_nullable_array_uint16__("OptionalUInt16ArrayField", v.getOptionalUInt16ArrayField());
        jsonGenerator.writeFieldName("OptionalInt32ArrayField"); 
        write_nullable_array_int32__("OptionalInt32ArrayField", v.getOptionalInt32ArrayField());
        jsonGenerator.writeFieldName("OptionalUInt32ArrayField"); 
        write_nullable_array_uint32__("OptionalUInt32ArrayField", v.getOptionalUInt32ArrayField());
        jsonGenerator.writeFieldName("OptionalInt64ArrayField"); 
        write_nullable_array_int64__("OptionalInt64ArrayField", v.getOptionalInt64ArrayField());
        jsonGenerator.writeFieldName("OptionalUInt64ArrayField"); 
        write_nullable_array_uint64__("OptionalUInt64ArrayField", v.getOptionalUInt64ArrayField());
        jsonGenerator.writeFieldName("OptionalFloatArrayField"); 
        write_nullable_array_float__("OptionalFloatArrayField", v.getOptionalFloatArrayField());
        jsonGenerator.writeFieldName("OptionalDoubleArrayField"); 
        write_nullable_array_double__("OptionalDoubleArrayField", v.getOptionalDoubleArrayField());
        jsonGenerator.writeFieldName("OptionalStringArrayField"); 
        write_nullable_array_string__("OptionalStringArrayField", v.getOptionalStringArrayField());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }



















    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("IntField"); 
        write_int32("IntField", v.getIntField());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }


















    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("Object2DArrayField"); 
        write_array_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___("Object2DArrayField", v.getObject2DArrayField());
        jsonGenerator.writeFieldName("Enum2DArrayField"); 
        write_array_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___("Enum2DArrayField", v.getEnum2DArrayField());
        jsonGenerator.writeFieldName("Bool2DArrayField"); 
        write_array_array_boolean__("Bool2DArrayField", v.getBool2DArrayField());
        jsonGenerator.writeFieldName("Byte2DArrayField"); 
        write_array_array_byte__("Byte2DArrayField", v.getByte2DArrayField());
        jsonGenerator.writeFieldName("Int162DArrayField"); 
        write_array_array_int16__("Int162DArrayField", v.getInt162DArrayField());
        jsonGenerator.writeFieldName("UInt162DArrayField"); 
        write_array_array_uint16__("UInt162DArrayField", v.getUInt162DArrayField());
        jsonGenerator.writeFieldName("Int322DArrayField"); 
        write_array_array_int32__("Int322DArrayField", v.getInt322DArrayField());
        jsonGenerator.writeFieldName("UInt322DArrayField"); 
        write_array_array_uint32__("UInt322DArrayField", v.getUInt322DArrayField());
        jsonGenerator.writeFieldName("Int642DArrayField"); 
        write_array_array_int64__("Int642DArrayField", v.getInt642DArrayField());
        jsonGenerator.writeFieldName("UInt642DArrayField"); 
        write_array_array_uint64__("UInt642DArrayField", v.getUInt642DArrayField());
        jsonGenerator.writeFieldName("Float2DArrayField"); 
        write_array_array_float__("Float2DArrayField", v.getFloat2DArrayField());
        jsonGenerator.writeFieldName("Double2DArrayField"); 
        write_array_array_double__("Double2DArrayField", v.getDouble2DArrayField());
        jsonGenerator.writeFieldName("String2DArrayField"); 
        write_array_array_string__("String2DArrayField", v.getString2DArrayField());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }










    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("OptionalObjectField"); 
        write_nullable_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__("OptionalObjectField", v.getOptionalObjectField());
        jsonGenerator.writeFieldName("OptionalEnumField"); 
        write_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__("OptionalEnumField", v.getOptionalEnumField());
        jsonGenerator.writeFieldName("OptionalBoolField"); 
        write_nullable_boolean_("OptionalBoolField", v.getOptionalBoolField());
        jsonGenerator.writeFieldName("OptionalByteField"); 
        write_nullable_byte_("OptionalByteField", v.getOptionalByteField());
        jsonGenerator.writeFieldName("OptionalInt16Field"); 
        write_nullable_int16_("OptionalInt16Field", v.getOptionalInt16Field());
        jsonGenerator.writeFieldName("OptionalUInt16Field"); 
        write_nullable_uint16_("OptionalUInt16Field", v.getOptionalUInt16Field());
        jsonGenerator.writeFieldName("OptionalInt32Field"); 
        write_nullable_int32_("OptionalInt32Field", v.getOptionalInt32Field());
        jsonGenerator.writeFieldName("OptionalUInt32Field"); 
        write_nullable_uint32_("OptionalUInt32Field", v.getOptionalUInt32Field());
        jsonGenerator.writeFieldName("OptionalInt64Field"); 
        write_nullable_int64_("OptionalInt64Field", v.getOptionalInt64Field());
        jsonGenerator.writeFieldName("OptionalUInt64Field"); 
        write_nullable_uint64_("OptionalUInt64Field", v.getOptionalUInt64Field());
        jsonGenerator.writeFieldName("OptionalFloatField"); 
        write_nullable_float_("OptionalFloatField", v.getOptionalFloatField());
        jsonGenerator.writeFieldName("OptionalDoubleField"); 
        write_nullable_double_("OptionalDoubleField", v.getOptionalDoubleField());
        jsonGenerator.writeFieldName("OptionalBinaryField"); 
        write_nullable_binary_("OptionalBinaryField", v.getOptionalBinaryField());
        jsonGenerator.writeFieldName("OptionalStringField"); 
        write_nullable_string_("OptionalStringField", v.getOptionalStringField());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }










    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("ObjectArrayField"); 
        write_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__("ObjectArrayField", v.getObjectArrayField());
        jsonGenerator.writeFieldName("EnumArrayField"); 
        write_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__("EnumArrayField", v.getEnumArrayField());
        jsonGenerator.writeFieldName("BoolArrayField"); 
        write_array_boolean_("BoolArrayField", v.getBoolArrayField());
        jsonGenerator.writeFieldName("ByteArrayField"); 
        write_array_byte_("ByteArrayField", v.getByteArrayField());
        jsonGenerator.writeFieldName("Int16ArrayField"); 
        write_array_int16_("Int16ArrayField", v.getInt16ArrayField());
        jsonGenerator.writeFieldName("UInt16ArrayField"); 
        write_array_uint16_("UInt16ArrayField", v.getUInt16ArrayField());
        jsonGenerator.writeFieldName("Int32ArrayField"); 
        write_array_int32_("Int32ArrayField", v.getInt32ArrayField());
        jsonGenerator.writeFieldName("UInt32ArrayField"); 
        write_array_uint32_("UInt32ArrayField", v.getUInt32ArrayField());
        jsonGenerator.writeFieldName("Int64ArrayField"); 
        write_array_int64_("Int64ArrayField", v.getInt64ArrayField());
        jsonGenerator.writeFieldName("UInt64ArrayField"); 
        write_array_uint64_("UInt64ArrayField", v.getUInt64ArrayField());
        jsonGenerator.writeFieldName("FloatArrayField"); 
        write_array_float_("FloatArrayField", v.getFloatArrayField());
        jsonGenerator.writeFieldName("DoubleArrayField"); 
        write_array_double_("DoubleArrayField", v.getDoubleArrayField());
        jsonGenerator.writeFieldName("StringArrayField"); 
        write_array_string_("StringArrayField", v.getStringArrayField());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }











    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("ObjectField"); 
        write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_("ObjectField", v.getObjectField());
        jsonGenerator.writeFieldName("EnumField"); 
        write_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_("EnumField", v.getEnumField());
        jsonGenerator.writeFieldName("BoolField"); 
        write_boolean("BoolField", v.getBoolField());
        jsonGenerator.writeFieldName("ByteField"); 
        write_byte("ByteField", v.getByteField());
        jsonGenerator.writeFieldName("Int16Field"); 
        write_int16("Int16Field", v.getInt16Field());
        jsonGenerator.writeFieldName("UInt16Field"); 
        write_uint16("UInt16Field", v.getUInt16Field());
        jsonGenerator.writeFieldName("Int32Field"); 
        write_int32("Int32Field", v.getInt32Field());
        jsonGenerator.writeFieldName("UInt32Field"); 
        write_uint32("UInt32Field", v.getUInt32Field());
        jsonGenerator.writeFieldName("Int64Field"); 
        write_int64("Int64Field", v.getInt64Field());
        jsonGenerator.writeFieldName("UInt64Field"); 
        write_uint64("UInt64Field", v.getUInt64Field());
        jsonGenerator.writeFieldName("FloatField"); 
        write_float("FloatField", v.getFloatField());
        jsonGenerator.writeFieldName("DoubleField"); 
        write_double("DoubleField", v.getDoubleField());
        jsonGenerator.writeFieldName("BinaryField"); 
        write_binary("BinaryField", v.getBinaryField());
        jsonGenerator.writeFieldName("StringField"); 
        write_string("StringField", v.getStringField());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }















    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("ObjectReferenceField"); 
        write_reference_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__("ObjectReferenceField", v.getObjectReferenceField());
        jsonGenerator.writeFieldName("EnumReferenceField"); 
        write_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__("EnumReferenceField", v.getEnumReferenceField());
        jsonGenerator.writeFieldName("BoolReferenceField"); 
        write_reference_boolean_("BoolReferenceField", v.getBoolReferenceField());
        jsonGenerator.writeFieldName("ByteReferenceField"); 
        write_reference_byte_("ByteReferenceField", v.getByteReferenceField());
        jsonGenerator.writeFieldName("Int16ReferenceField"); 
        write_reference_int16_("Int16ReferenceField", v.getInt16ReferenceField());
        jsonGenerator.writeFieldName("UInt16ReferenceField"); 
        write_reference_uint16_("UInt16ReferenceField", v.getUInt16ReferenceField());
        jsonGenerator.writeFieldName("Int32ReferenceField"); 
        write_reference_int32_("Int32ReferenceField", v.getInt32ReferenceField());
        jsonGenerator.writeFieldName("UInt32ReferenceField"); 
        write_reference_uint32_("UInt32ReferenceField", v.getUInt32ReferenceField());
        jsonGenerator.writeFieldName("Int64ReferenceField"); 
        write_reference_int64_("Int64ReferenceField", v.getInt64ReferenceField());
        jsonGenerator.writeFieldName("UInt64ReferenceField"); 
        write_reference_uint64_("UInt64ReferenceField", v.getUInt64ReferenceField());
        jsonGenerator.writeFieldName("FloatReferenceField"); 
        write_reference_float_("FloatReferenceField", v.getFloatReferenceField());
        jsonGenerator.writeFieldName("DoubleReferenceField"); 
        write_reference_double_("DoubleReferenceField", v.getDoubleReferenceField());
        jsonGenerator.writeFieldName("BinaryReferenceField"); 
        write_reference_binary_("BinaryReferenceField", v.getBinaryReferenceField());
        jsonGenerator.writeFieldName("StringReferenceField"); 
        write_reference_string_("StringReferenceField", v.getStringReferenceField());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }




    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("BasicTestObjectField"); 
        write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_("BasicTestObjectField", v.getBasicTestObjectField());
        jsonGenerator.writeFieldName("ReferenceTestObjectField"); 
        write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_("ReferenceTestObjectField", v.getReferenceTestObjectField());
        jsonGenerator.writeFieldName("OptionalBasicTestObjectField"); 
        write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_("OptionalBasicTestObjectField", v.getOptionalBasicTestObjectField());
        jsonGenerator.writeFieldName("ArrayTestObjectField"); 
        write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_("ArrayTestObjectField", v.getArrayTestObjectField());
        jsonGenerator.writeFieldName("Array2DTestObjectField"); 
        write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_("Array2DTestObjectField", v.getArray2DTestObjectField());
        jsonGenerator.writeFieldName("OptionalArrayTestObjectField"); 
        write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_("OptionalArrayTestObjectField", v.getOptionalArrayTestObjectField());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }





    public void write_array_array_uint16__(java.lang.String name, java.util.List<java.util.List<java.lang.Short>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (java.util.List<java.lang.Short> e : v) {
            write_array_uint16_(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_array_array_boolean__(java.lang.String name, java.util.List<java.util.List<java.lang.Boolean>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (java.util.List<java.lang.Boolean> e : v) {
            write_array_boolean_(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(java.lang.String name, java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum e : v) {
            write_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_reference_byte_(java.lang.String name, java.lang.Byte v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, java.lang.Byte.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_byte(name, (java.lang.Byte)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_nullable_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___(java.lang.String name, java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(name, v);
        }
    }


    public void write_nullable_int16_(java.lang.String name, java.lang.Short v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_int16(name, v);
        }
    }

    public void write_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(java.lang.String name, java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject e : v) {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_array_byte_(java.lang.String name, java.util.List<java.lang.Byte> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (byte e : v) {
            write_byte(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_nullable_int32_(java.lang.String name, java.lang.Integer v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_int32(name, v);
        }
    }

    public void write_nullable_array_boolean__(java.lang.String name, java.util.List<java.lang.Boolean> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_array_boolean_(name, v);
        }
    }

    public void write_array_array_int16__(java.lang.String name, java.util.List<java.util.List<java.lang.Short>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (java.util.List<java.lang.Short> e : v) {
            write_array_int16_(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_float(java.lang.String name, float v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }

    public void write_reference_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(name, (com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_array_array_string__(java.lang.String name, java.util.List<java.util.List<java.lang.String>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (java.util.List<java.lang.String> e : v) {
            write_array_string_(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_array_boolean_(java.lang.String name, java.util.List<java.lang.Boolean> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (boolean e : v) {
            write_boolean(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_array_array_byte__(java.lang.String name, java.util.List<java.util.List<java.lang.Byte>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (java.util.List<java.lang.Byte> e : v) {
            write_array_byte_(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_uint16(java.lang.String name, short v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }

    public void write_reference_uint16_(java.lang.String name, java.lang.Short v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, java.lang.Short.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_uint16(name, (java.lang.Short)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_reference_int16_(java.lang.String name, java.lang.Short v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, java.lang.Short.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_int16(name, (java.lang.Short)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_array_uint32_(java.lang.String name, java.util.List<java.lang.Integer> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (int e : v) {
            write_uint32(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_int64(java.lang.String name, long v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }

    public void write_byte(java.lang.String name, byte v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }


    public void write_nullable_double_(java.lang.String name, java.lang.Double v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_double(name, v);
        }
    }

    public void write_array_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___(java.lang.String name, java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> e : v) {
            write_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_boolean(java.lang.String name, boolean v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeBoolean(v);
    }

    public void write_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(name, v);
        }
    }

    public void write_nullable_uint64_(java.lang.String name, java.lang.Long v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_uint64(name, v);
        }
    }

    public void write_nullable_uint16_(java.lang.String name, java.lang.Short v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_uint16(name, v);
        }
    }

    public void write_array_string_(java.lang.String name, java.util.List<java.lang.String> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (java.lang.String e : v) {
            write_string(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_int16(java.lang.String name, short v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }

    public void write_array_int64_(java.lang.String name, java.util.List<java.lang.Long> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (long e : v) {
            write_int64(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_reference_uint32_(java.lang.String name, java.lang.Integer v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, java.lang.Integer.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_uint32(name, (java.lang.Integer)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_array_array_uint32__(java.lang.String name, java.util.List<java.util.List<java.lang.Integer>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (java.util.List<java.lang.Integer> e : v) {
            write_array_uint32_(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(name, (com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_double(java.lang.String name, double v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }

    public void write_nullable_uint32_(java.lang.String name, java.lang.Integer v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_uint32(name, v);
        }
    }

    public void write_array_int16_(java.lang.String name, java.util.List<java.lang.Short> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (short e : v) {
            write_int16(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_reference_binary_(java.lang.String name, byte[] v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, byte[].class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_binary(name, (byte[])v);
        }
        jsonGenerator.writeEndObject();
    }


    public void write_array_int32_(java.lang.String name, java.util.List<java.lang.Integer> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (int e : v) {
            write_int32(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_array_double_(java.lang.String name, java.util.List<java.lang.Double> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (double e : v) {
            write_double(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_array_uint64_(java.lang.String name, java.util.List<java.lang.Long> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (long e : v) {
            write_uint64(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_reference_string_(java.lang.String name, java.lang.String v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, java.lang.String.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_string(name, (java.lang.String)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_nullable_array_uint16__(java.lang.String name, java.util.List<java.lang.Short> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_array_uint16_(name, v);
        }
    }

    public void write_reference_boolean_(java.lang.String name, java.lang.Boolean v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, java.lang.Boolean.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_boolean(name, (java.lang.Boolean)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_nullable_array_int64__(java.lang.String name, java.util.List<java.lang.Long> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_array_int64_(name, v);
        }
    }

    public void write_binary(java.lang.String name, byte[] v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeBinary(v);
    }


    public void write_nullable_byte_(java.lang.String name, java.lang.Byte v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_byte(name, v);
        }
    }

    public void write_nullable_int64_(java.lang.String name, java.lang.Long v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_int64(name, v);
        }
    }

    public void write_reference_int64_(java.lang.String name, java.lang.Long v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, java.lang.Long.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_int64(name, (java.lang.Long)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_uint32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }

    public void write_nullable_float_(java.lang.String name, java.lang.Float v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_float(name, v);
        }
    }

    public void write_array_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___(java.lang.String name, java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> e : v) {
            write_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_array_array_int32__(java.lang.String name, java.util.List<java.util.List<java.lang.Integer>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (java.util.List<java.lang.Integer> e : v) {
            write_array_int32_(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_nullable_array_uint64__(java.lang.String name, java.util.List<java.lang.Long> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_array_uint64_(name, v);
        }
    }


    public void write_nullable_string_(java.lang.String name, java.lang.String v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_string(name, v);
        }
    }

    public void write_nullable_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(name, v);
        }
    }

    public void write_nullable_array_float__(java.lang.String name, java.util.List<java.lang.Float> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_array_float_(name, v);
        }
    }

    public void write_array_array_double__(java.lang.String name, java.util.List<java.util.List<java.lang.Double>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (java.util.List<java.lang.Double> e : v) {
            write_array_double_(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_reference_float_(java.lang.String name, java.lang.Float v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, java.lang.Float.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_float(name, (java.lang.Float)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_nullable_array_uint32__(java.lang.String name, java.util.List<java.lang.Integer> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_array_uint32_(name, v);
        }
    }

    public void write_nullable_binary_(java.lang.String name, byte[] v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_binary(name, v);
        }
    }

    public void write_nullable_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___(java.lang.String name, java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(name, v);
        }
    }

    public void write_nullable_boolean_(java.lang.String name, java.lang.Boolean v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_boolean(name, v);
        }
    }


    public void write_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        switch (v) {
        case Info:
            write_string(name, "Info");
            break;
        case Warning:
            write_string(name, "Warning");
            break;
        case Error:
            write_string(name, "Error");
            break;
        default:
            throw new com.expedia.tesla.serialization.TeslaSerializationException(String.format(
                "Enum value %s is not allowed on field %s (type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>')", 
                v.toString(), name));
        }
    }

    public void write_uint64(java.lang.String name, long v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }

    public void write_array_uint16_(java.lang.String name, java.util.List<java.lang.Short> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (short e : v) {
            write_uint16(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_int32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }

    public void write_nullable_array_string__(java.lang.String name, java.util.List<java.lang.String> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_array_string_(name, v);
        }
    }

    public void write_nullable_array_int32__(java.lang.String name, java.util.List<java.lang.Integer> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_array_int32_(name, v);
        }
    }

    public void write_reference_double_(java.lang.String name, java.lang.Double v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, java.lang.Double.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_double(name, (java.lang.Double)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_array_float_(java.lang.String name, java.util.List<java.lang.Float> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (float e : v) {
            write_float(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_reference_int32_(java.lang.String name, java.lang.Integer v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, java.lang.Integer.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_int32(name, (java.lang.Integer)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_string(java.lang.String name, java.lang.String v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeString(v);
    }

    public void write_array_array_float__(java.lang.String name, java.util.List<java.util.List<java.lang.Float>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (java.util.List<java.lang.Float> e : v) {
            write_array_float_(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_reference_uint64_(java.lang.String name, java.lang.Long v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, java.lang.Long.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_uint64(name, (java.lang.Long)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_array_array_int64__(java.lang.String name, java.util.List<java.util.List<java.lang.Long>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (java.util.List<java.lang.Long> e : v) {
            write_array_int64_(name, e);
        }
        jsonGenerator.writeEndArray();
    }


    public void write_nullable_array_double__(java.lang.String name, java.util.List<java.lang.Double> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_array_double_(name, v);
        }
    }

    public void write_array_array_uint64__(java.lang.String name, java.util.List<java.util.List<java.lang.Long>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (java.util.List<java.lang.Long> e : v) {
            write_array_uint64_(name, e);
        }
        jsonGenerator.writeEndArray();
    }


    public void write_nullable_array_byte__(java.lang.String name, java.util.List<java.lang.Byte> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_array_byte_(name, v);
        }
    }

    public void write_nullable_array_int16__(java.lang.String name, java.util.List<java.lang.Short> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_array_int16_(name, v);
        }
    }


}

class TeslaJsonReader_teslacompiler_all_types_v1_0 extends Serializer.ObjectReader {


    public static final long SCHEMA_HASH = 7810441853185379917L;
    private static final com.fasterxml.jackson.databind.ObjectMapper JSON_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private com.fasterxml.jackson.databind.JsonNode root;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    TeslaJsonReader_teslacompiler_all_types_v1_0(java.io.InputStream stream) throws java.io.IOException {
        root = JSON_MAPPER.readTree(stream);
    }

    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("OptionalObjectArrayField");
        if(vn != null)
            v.setOptionalObjectArrayField(read_nullable_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___("OptionalObjectArrayField", vn));
        vn = node.get("OptionalEnumArrayField");
        if(vn != null)
            v.setOptionalEnumArrayField(read_nullable_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___("OptionalEnumArrayField", vn));
        vn = node.get("OptionalBoolArrayField");
        if(vn != null)
            v.setOptionalBoolArrayField(read_nullable_array_boolean__("OptionalBoolArrayField", vn));
        vn = node.get("OptionalByteArrayField");
        if(vn != null)
            v.setOptionalByteArrayField(read_nullable_array_byte__("OptionalByteArrayField", vn));
        vn = node.get("OptionalInt16ArrayField");
        if(vn != null)
            v.setOptionalInt16ArrayField(read_nullable_array_int16__("OptionalInt16ArrayField", vn));
        vn = node.get("OptionalUInt16ArrayField");
        if(vn != null)
            v.setOptionalUInt16ArrayField(read_nullable_array_uint16__("OptionalUInt16ArrayField", vn));
        vn = node.get("OptionalInt32ArrayField");
        if(vn != null)
            v.setOptionalInt32ArrayField(read_nullable_array_int32__("OptionalInt32ArrayField", vn));
        vn = node.get("OptionalUInt32ArrayField");
        if(vn != null)
            v.setOptionalUInt32ArrayField(read_nullable_array_uint32__("OptionalUInt32ArrayField", vn));
        vn = node.get("OptionalInt64ArrayField");
        if(vn != null)
            v.setOptionalInt64ArrayField(read_nullable_array_int64__("OptionalInt64ArrayField", vn));
        vn = node.get("OptionalUInt64ArrayField");
        if(vn != null)
            v.setOptionalUInt64ArrayField(read_nullable_array_uint64__("OptionalUInt64ArrayField", vn));
        vn = node.get("OptionalFloatArrayField");
        if(vn != null)
            v.setOptionalFloatArrayField(read_nullable_array_float__("OptionalFloatArrayField", vn));
        vn = node.get("OptionalDoubleArrayField");
        if(vn != null)
            v.setOptionalDoubleArrayField(read_nullable_array_double__("OptionalDoubleArrayField", vn));
        vn = node.get("OptionalStringArrayField");
        if(vn != null)
            v.setOptionalStringArrayField(read_nullable_array_string__("OptionalStringArrayField", vn));
        return v;
    }
    
    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("IntField");
        if(vn != null)
            v.setIntField(read_int32("IntField", vn));
        return v;
    }
    
    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("Object2DArrayField");
        if(vn != null)
            v.setObject2DArrayField(read_array_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___("Object2DArrayField", vn));
        vn = node.get("Enum2DArrayField");
        if(vn != null)
            v.setEnum2DArrayField(read_array_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___("Enum2DArrayField", vn));
        vn = node.get("Bool2DArrayField");
        if(vn != null)
            v.setBool2DArrayField(read_array_array_boolean__("Bool2DArrayField", vn));
        vn = node.get("Byte2DArrayField");
        if(vn != null)
            v.setByte2DArrayField(read_array_array_byte__("Byte2DArrayField", vn));
        vn = node.get("Int162DArrayField");
        if(vn != null)
            v.setInt162DArrayField(read_array_array_int16__("Int162DArrayField", vn));
        vn = node.get("UInt162DArrayField");
        if(vn != null)
            v.setUInt162DArrayField(read_array_array_uint16__("UInt162DArrayField", vn));
        vn = node.get("Int322DArrayField");
        if(vn != null)
            v.setInt322DArrayField(read_array_array_int32__("Int322DArrayField", vn));
        vn = node.get("UInt322DArrayField");
        if(vn != null)
            v.setUInt322DArrayField(read_array_array_uint32__("UInt322DArrayField", vn));
        vn = node.get("Int642DArrayField");
        if(vn != null)
            v.setInt642DArrayField(read_array_array_int64__("Int642DArrayField", vn));
        vn = node.get("UInt642DArrayField");
        if(vn != null)
            v.setUInt642DArrayField(read_array_array_uint64__("UInt642DArrayField", vn));
        vn = node.get("Float2DArrayField");
        if(vn != null)
            v.setFloat2DArrayField(read_array_array_float__("Float2DArrayField", vn));
        vn = node.get("Double2DArrayField");
        if(vn != null)
            v.setDouble2DArrayField(read_array_array_double__("Double2DArrayField", vn));
        vn = node.get("String2DArrayField");
        if(vn != null)
            v.setString2DArrayField(read_array_array_string__("String2DArrayField", vn));
        return v;
    }
    
    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("OptionalObjectField");
        if(vn != null)
            v.setOptionalObjectField(read_nullable_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__("OptionalObjectField", vn));
        vn = node.get("OptionalEnumField");
        if(vn != null)
            v.setOptionalEnumField(read_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__("OptionalEnumField", vn));
        vn = node.get("OptionalBoolField");
        if(vn != null)
            v.setOptionalBoolField(read_nullable_boolean_("OptionalBoolField", vn));
        vn = node.get("OptionalByteField");
        if(vn != null)
            v.setOptionalByteField(read_nullable_byte_("OptionalByteField", vn));
        vn = node.get("OptionalInt16Field");
        if(vn != null)
            v.setOptionalInt16Field(read_nullable_int16_("OptionalInt16Field", vn));
        vn = node.get("OptionalUInt16Field");
        if(vn != null)
            v.setOptionalUInt16Field(read_nullable_uint16_("OptionalUInt16Field", vn));
        vn = node.get("OptionalInt32Field");
        if(vn != null)
            v.setOptionalInt32Field(read_nullable_int32_("OptionalInt32Field", vn));
        vn = node.get("OptionalUInt32Field");
        if(vn != null)
            v.setOptionalUInt32Field(read_nullable_uint32_("OptionalUInt32Field", vn));
        vn = node.get("OptionalInt64Field");
        if(vn != null)
            v.setOptionalInt64Field(read_nullable_int64_("OptionalInt64Field", vn));
        vn = node.get("OptionalUInt64Field");
        if(vn != null)
            v.setOptionalUInt64Field(read_nullable_uint64_("OptionalUInt64Field", vn));
        vn = node.get("OptionalFloatField");
        if(vn != null)
            v.setOptionalFloatField(read_nullable_float_("OptionalFloatField", vn));
        vn = node.get("OptionalDoubleField");
        if(vn != null)
            v.setOptionalDoubleField(read_nullable_double_("OptionalDoubleField", vn));
        vn = node.get("OptionalBinaryField");
        if(vn != null)
            v.setOptionalBinaryField(read_nullable_binary_("OptionalBinaryField", vn));
        vn = node.get("OptionalStringField");
        if(vn != null)
            v.setOptionalStringField(read_nullable_string_("OptionalStringField", vn));
        return v;
    }
    
    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("ObjectArrayField");
        if(vn != null)
            v.setObjectArrayField(read_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__("ObjectArrayField", vn));
        vn = node.get("EnumArrayField");
        if(vn != null)
            v.setEnumArrayField(read_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__("EnumArrayField", vn));
        vn = node.get("BoolArrayField");
        if(vn != null)
            v.setBoolArrayField(read_array_boolean_("BoolArrayField", vn));
        vn = node.get("ByteArrayField");
        if(vn != null)
            v.setByteArrayField(read_array_byte_("ByteArrayField", vn));
        vn = node.get("Int16ArrayField");
        if(vn != null)
            v.setInt16ArrayField(read_array_int16_("Int16ArrayField", vn));
        vn = node.get("UInt16ArrayField");
        if(vn != null)
            v.setUInt16ArrayField(read_array_uint16_("UInt16ArrayField", vn));
        vn = node.get("Int32ArrayField");
        if(vn != null)
            v.setInt32ArrayField(read_array_int32_("Int32ArrayField", vn));
        vn = node.get("UInt32ArrayField");
        if(vn != null)
            v.setUInt32ArrayField(read_array_uint32_("UInt32ArrayField", vn));
        vn = node.get("Int64ArrayField");
        if(vn != null)
            v.setInt64ArrayField(read_array_int64_("Int64ArrayField", vn));
        vn = node.get("UInt64ArrayField");
        if(vn != null)
            v.setUInt64ArrayField(read_array_uint64_("UInt64ArrayField", vn));
        vn = node.get("FloatArrayField");
        if(vn != null)
            v.setFloatArrayField(read_array_float_("FloatArrayField", vn));
        vn = node.get("DoubleArrayField");
        if(vn != null)
            v.setDoubleArrayField(read_array_double_("DoubleArrayField", vn));
        vn = node.get("StringArrayField");
        if(vn != null)
            v.setStringArrayField(read_array_string_("StringArrayField", vn));
        return v;
    }
    
    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("ObjectField");
        if(vn != null)
            v.setObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_("ObjectField", vn));
        vn = node.get("EnumField");
        if(vn != null)
            v.setEnumField(read_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_("EnumField", vn));
        vn = node.get("BoolField");
        if(vn != null)
            v.setBoolField(read_boolean("BoolField", vn));
        vn = node.get("ByteField");
        if(vn != null)
            v.setByteField(read_byte("ByteField", vn));
        vn = node.get("Int16Field");
        if(vn != null)
            v.setInt16Field(read_int16("Int16Field", vn));
        vn = node.get("UInt16Field");
        if(vn != null)
            v.setUInt16Field(read_uint16("UInt16Field", vn));
        vn = node.get("Int32Field");
        if(vn != null)
            v.setInt32Field(read_int32("Int32Field", vn));
        vn = node.get("UInt32Field");
        if(vn != null)
            v.setUInt32Field(read_uint32("UInt32Field", vn));
        vn = node.get("Int64Field");
        if(vn != null)
            v.setInt64Field(read_int64("Int64Field", vn));
        vn = node.get("UInt64Field");
        if(vn != null)
            v.setUInt64Field(read_uint64("UInt64Field", vn));
        vn = node.get("FloatField");
        if(vn != null)
            v.setFloatField(read_float("FloatField", vn));
        vn = node.get("DoubleField");
        if(vn != null)
            v.setDoubleField(read_double("DoubleField", vn));
        vn = node.get("BinaryField");
        if(vn != null)
            v.setBinaryField(read_binary("BinaryField", vn));
        vn = node.get("StringField");
        if(vn != null)
            v.setStringField(read_string("StringField", vn));
        return v;
    }
    
    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("ObjectReferenceField");
        if(vn != null)
            v.setObjectReferenceField(read_reference_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__("ObjectReferenceField", vn));
        vn = node.get("EnumReferenceField");
        if(vn != null)
            v.setEnumReferenceField(read_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__("EnumReferenceField", vn));
        vn = node.get("BoolReferenceField");
        if(vn != null)
            v.setBoolReferenceField(read_reference_boolean_("BoolReferenceField", vn));
        vn = node.get("ByteReferenceField");
        if(vn != null)
            v.setByteReferenceField(read_reference_byte_("ByteReferenceField", vn));
        vn = node.get("Int16ReferenceField");
        if(vn != null)
            v.setInt16ReferenceField(read_reference_int16_("Int16ReferenceField", vn));
        vn = node.get("UInt16ReferenceField");
        if(vn != null)
            v.setUInt16ReferenceField(read_reference_uint16_("UInt16ReferenceField", vn));
        vn = node.get("Int32ReferenceField");
        if(vn != null)
            v.setInt32ReferenceField(read_reference_int32_("Int32ReferenceField", vn));
        vn = node.get("UInt32ReferenceField");
        if(vn != null)
            v.setUInt32ReferenceField(read_reference_uint32_("UInt32ReferenceField", vn));
        vn = node.get("Int64ReferenceField");
        if(vn != null)
            v.setInt64ReferenceField(read_reference_int64_("Int64ReferenceField", vn));
        vn = node.get("UInt64ReferenceField");
        if(vn != null)
            v.setUInt64ReferenceField(read_reference_uint64_("UInt64ReferenceField", vn));
        vn = node.get("FloatReferenceField");
        if(vn != null)
            v.setFloatReferenceField(read_reference_float_("FloatReferenceField", vn));
        vn = node.get("DoubleReferenceField");
        if(vn != null)
            v.setDoubleReferenceField(read_reference_double_("DoubleReferenceField", vn));
        vn = node.get("BinaryReferenceField");
        if(vn != null)
            v.setBinaryReferenceField(read_reference_binary_("BinaryReferenceField", vn));
        vn = node.get("StringReferenceField");
        if(vn != null)
            v.setStringReferenceField(read_reference_string_("StringReferenceField", vn));
        return v;
    }
    
    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestObject_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestObject_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestObject_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("BasicTestObjectField");
        if(vn != null)
            v.setBasicTestObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_("BasicTestObjectField", vn));
        vn = node.get("ReferenceTestObjectField");
        if(vn != null)
            v.setReferenceTestObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_("ReferenceTestObjectField", vn));
        vn = node.get("OptionalBasicTestObjectField");
        if(vn != null)
            v.setOptionalBasicTestObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_("OptionalBasicTestObjectField", vn));
        vn = node.get("ArrayTestObjectField");
        if(vn != null)
            v.setArrayTestObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_("ArrayTestObjectField", vn));
        vn = node.get("Array2DTestObjectField");
        if(vn != null)
            v.setArray2DTestObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_("Array2DTestObjectField", vn));
        vn = node.get("OptionalArrayTestObjectField");
        if(vn != null)
            v.setOptionalArrayTestObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_("OptionalArrayTestObjectField", vn));
        return v;
    }
    

    public java.util.List<java.util.List<java.lang.Short>> read_array_array_uint16__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.util.List<java.lang.Short>> v = new java.util.ArrayList<java.util.List<java.lang.Short>>();
        while (itr.hasNext()) {
            v.add(read_array_uint16_(name, itr.next()));
        }
        return v;
    }

    public java.util.List<java.util.List<java.lang.Boolean>> read_array_array_boolean__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.util.List<java.lang.Boolean>> v = new java.util.ArrayList<java.util.List<java.lang.Boolean>>();
        while (itr.hasNext()) {
            v.add(read_array_boolean_(name, itr.next()));
        }
        return v;
    }

    public java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> read_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> v = new java.util.ArrayList<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>();
        while (itr.hasNext()) {
            v.add(read_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(name, itr.next()));
        }
        return v;
    }

    public java.lang.Byte read_reference_byte_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Byte.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            byte v = read_byte(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, java.lang.Byte.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> read_nullable_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(name, node);
        }
    }


    public java.lang.Short read_nullable_int16_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_int16(name, node);
        }
    }

    public java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> read_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> v = new java.util.ArrayList<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>();
        while (itr.hasNext()) {
            v.add(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(name, itr.next()));
        }
        return v;
    }

    public java.util.List<java.lang.Byte> read_array_byte_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.lang.Byte> v = new java.util.ArrayList<java.lang.Byte>();
        while (itr.hasNext()) {
            v.add(read_byte(name, itr.next()));
        }
        return v;
    }

    public java.lang.Integer read_nullable_int32_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_int32(name, node);
        }
    }

    public java.util.List<java.lang.Boolean> read_nullable_array_boolean__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_array_boolean_(name, node);
        }
    }

    public java.util.List<java.util.List<java.lang.Short>> read_array_array_int16__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.util.List<java.lang.Short>> v = new java.util.ArrayList<java.util.List<java.lang.Short>>();
        while (itr.hasNext()) {
            v.add(read_array_int16_(name, itr.next()));
        }
        return v;
    }

    public float read_float(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (float)node.doubleValue();
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject read_reference_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v = read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.util.List<java.lang.String>> read_array_array_string__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.util.List<java.lang.String>> v = new java.util.ArrayList<java.util.List<java.lang.String>>();
        while (itr.hasNext()) {
            v.add(read_array_string_(name, itr.next()));
        }
        return v;
    }

    public java.util.List<java.lang.Boolean> read_array_boolean_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.lang.Boolean> v = new java.util.ArrayList<java.lang.Boolean>();
        while (itr.hasNext()) {
            v.add(read_boolean(name, itr.next()));
        }
        return v;
    }

    public java.util.List<java.util.List<java.lang.Byte>> read_array_array_byte__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.util.List<java.lang.Byte>> v = new java.util.ArrayList<java.util.List<java.lang.Byte>>();
        while (itr.hasNext()) {
            v.add(read_array_byte_(name, itr.next()));
        }
        return v;
    }

    public short read_uint16(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (short)node.intValue();
    }

    public java.lang.Short read_reference_uint16_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Short.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            short v = read_uint16(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, java.lang.Short.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.lang.Short read_reference_int16_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Short.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            short v = read_int16(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, java.lang.Short.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.lang.Integer> read_array_uint32_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.lang.Integer> v = new java.util.ArrayList<java.lang.Integer>();
        while (itr.hasNext()) {
            v.add(read_uint32(name, itr.next()));
        }
        return v;
    }

    public long read_int64(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.longValue();
    }

    public byte read_byte(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (byte)node.intValue();
    }


    public java.lang.Double read_nullable_double_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_double(name, node);
        }
    }

    public java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>> read_array_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>> v = new java.util.ArrayList<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>>();
        while (itr.hasNext()) {
            v.add(read_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(name, itr.next()));
        }
        return v;
    }

    public boolean read_boolean(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.booleanValue();
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum read_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(name, node);
        }
    }

    public java.lang.Long read_nullable_uint64_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_uint64(name, node);
        }
    }

    public java.lang.Short read_nullable_uint16_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_uint16(name, node);
        }
    }

    public java.util.List<java.lang.String> read_array_string_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.lang.String> v = new java.util.ArrayList<java.lang.String>();
        while (itr.hasNext()) {
            v.add(read_string(name, itr.next()));
        }
        return v;
    }

    public short read_int16(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (short)node.intValue();
    }

    public java.util.List<java.lang.Long> read_array_int64_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.lang.Long> v = new java.util.ArrayList<java.lang.Long>();
        while (itr.hasNext()) {
            v.add(read_int64(name, itr.next()));
        }
        return v;
    }

    public java.lang.Integer read_reference_uint32_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Integer.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            int v = read_uint32(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, java.lang.Integer.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.util.List<java.lang.Integer>> read_array_array_uint32__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.util.List<java.lang.Integer>> v = new java.util.ArrayList<java.util.List<java.lang.Integer>>();
        while (itr.hasNext()) {
            v.add(read_array_uint32_(name, itr.next()));
        }
        return v;
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum read_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum v = read_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public double read_double(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.doubleValue();
    }

    public java.lang.Integer read_nullable_uint32_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_uint32(name, node);
        }
    }

    public java.util.List<java.lang.Short> read_array_int16_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.lang.Short> v = new java.util.ArrayList<java.lang.Short>();
        while (itr.hasNext()) {
            v.add(read_int16(name, itr.next()));
        }
        return v;
    }

    public byte[] read_reference_binary_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, byte[].class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            byte[] v = read_binary(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, byte[].class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }


    public java.util.List<java.lang.Integer> read_array_int32_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.lang.Integer> v = new java.util.ArrayList<java.lang.Integer>();
        while (itr.hasNext()) {
            v.add(read_int32(name, itr.next()));
        }
        return v;
    }

    public java.util.List<java.lang.Double> read_array_double_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.lang.Double> v = new java.util.ArrayList<java.lang.Double>();
        while (itr.hasNext()) {
            v.add(read_double(name, itr.next()));
        }
        return v;
    }

    public java.util.List<java.lang.Long> read_array_uint64_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.lang.Long> v = new java.util.ArrayList<java.lang.Long>();
        while (itr.hasNext()) {
            v.add(read_uint64(name, itr.next()));
        }
        return v;
    }

    public java.lang.String read_reference_string_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.String.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            java.lang.String v = read_string(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, java.lang.String.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.lang.Short> read_nullable_array_uint16__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_array_uint16_(name, node);
        }
    }

    public java.lang.Boolean read_reference_boolean_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Boolean.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            boolean v = read_boolean(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, java.lang.Boolean.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.lang.Long> read_nullable_array_int64__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_array_int64_(name, node);
        }
    }

    public byte[] read_binary(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.binaryValue();
    }


    public java.lang.Byte read_nullable_byte_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_byte(name, node);
        }
    }

    public java.lang.Long read_nullable_int64_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_int64(name, node);
        }
    }

    public java.lang.Long read_reference_int64_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Long.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            long v = read_int64(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, java.lang.Long.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public int read_uint32(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (int)node.longValue();
    }

    public java.lang.Float read_nullable_float_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_float(name, node);
        }
    }

    public java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>> read_array_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>> v = new java.util.ArrayList<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>>();
        while (itr.hasNext()) {
            v.add(read_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(name, itr.next()));
        }
        return v;
    }

    public java.util.List<java.util.List<java.lang.Integer>> read_array_array_int32__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.util.List<java.lang.Integer>> v = new java.util.ArrayList<java.util.List<java.lang.Integer>>();
        while (itr.hasNext()) {
            v.add(read_array_int32_(name, itr.next()));
        }
        return v;
    }

    public java.util.List<java.lang.Long> read_nullable_array_uint64__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_array_uint64_(name, node);
        }
    }


    public java.lang.String read_nullable_string_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_string(name, node);
        }
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject read_nullable_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(name, node);
        }
    }

    public java.util.List<java.lang.Float> read_nullable_array_float__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_array_float_(name, node);
        }
    }

    public java.util.List<java.util.List<java.lang.Double>> read_array_array_double__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.util.List<java.lang.Double>> v = new java.util.ArrayList<java.util.List<java.lang.Double>>();
        while (itr.hasNext()) {
            v.add(read_array_double_(name, itr.next()));
        }
        return v;
    }

    public java.lang.Float read_reference_float_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Float.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            float v = read_float(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, java.lang.Float.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.lang.Integer> read_nullable_array_uint32__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_array_uint32_(name, node);
        }
    }

    public byte[] read_nullable_binary_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_binary(name, node);
        }
    }

    public java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> read_nullable_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(name, node);
        }
    }

    public java.lang.Boolean read_nullable_boolean_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_boolean(name, node);
        }
    }


    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum read_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        java.lang.String v = node.textValue();
        if (v.equals("Info")) {
            return com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum.Info;
        }
        if (v.equals("Warning")) {
            return com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum.Warning;
        }
        if (v.equals("Error")) {
            return com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum.Error;
        }
        throw new java.io.IOException(String.format(
            "Invalid Enum value '%s' encountered when reading field %s (type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>')", 
            v, name));
    }

    public long read_uint64(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.longValue();
    }

    public java.util.List<java.lang.Short> read_array_uint16_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.lang.Short> v = new java.util.ArrayList<java.lang.Short>();
        while (itr.hasNext()) {
            v.add(read_uint16(name, itr.next()));
        }
        return v;
    }

    public int read_int32(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.intValue();
    }

    public java.util.List<java.lang.String> read_nullable_array_string__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_array_string_(name, node);
        }
    }

    public java.util.List<java.lang.Integer> read_nullable_array_int32__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_array_int32_(name, node);
        }
    }

    public java.lang.Double read_reference_double_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Double.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            double v = read_double(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, java.lang.Double.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.lang.Float> read_array_float_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.lang.Float> v = new java.util.ArrayList<java.lang.Float>();
        while (itr.hasNext()) {
            v.add(read_float(name, itr.next()));
        }
        return v;
    }

    public java.lang.Integer read_reference_int32_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Integer.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            int v = read_int32(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, java.lang.Integer.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.lang.String read_string(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.textValue();
    }

    public java.util.List<java.util.List<java.lang.Float>> read_array_array_float__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.util.List<java.lang.Float>> v = new java.util.ArrayList<java.util.List<java.lang.Float>>();
        while (itr.hasNext()) {
            v.add(read_array_float_(name, itr.next()));
        }
        return v;
    }

    public java.lang.Long read_reference_uint64_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Long.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            long v = read_uint64(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, java.lang.Long.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.util.List<java.lang.Long>> read_array_array_int64__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.util.List<java.lang.Long>> v = new java.util.ArrayList<java.util.List<java.lang.Long>>();
        while (itr.hasNext()) {
            v.add(read_array_int64_(name, itr.next()));
        }
        return v;
    }


    public java.util.List<java.lang.Double> read_nullable_array_double__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_array_double_(name, node);
        }
    }

    public java.util.List<java.util.List<java.lang.Long>> read_array_array_uint64__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.util.List<java.lang.Long>> v = new java.util.ArrayList<java.util.List<java.lang.Long>>();
        while (itr.hasNext()) {
            v.add(read_array_uint64_(name, itr.next()));
        }
        return v;
    }


    public java.util.List<java.lang.Byte> read_nullable_array_byte__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_array_byte_(name, node);
        }
    }

    public java.util.List<java.lang.Short> read_nullable_array_int16__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_array_int16_(name, node);
        }
    }



}


class TeslaJsonWriter_compiler_test_passcompile_full_complexttypetest extends Serializer.ObjectWriter {


    public static final long SCHEMA_HASH = -5586303099293846137L;
    private static final com.fasterxml.jackson.core.JsonFactory JSON_FACTORY = new com.fasterxml.jackson.core.JsonFactory();
    private com.fasterxml.jackson.core.JsonGenerator jsonGenerator;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
	
	TeslaJsonWriter_compiler_test_passcompile_full_complexttypetest(java.io.OutputStream stream) throws java.io.IOException {
        jsonGenerator = JSON_FACTORY.createGenerator(stream);
    }










    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_complexttypetest_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.complexttypetest v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("field1"); 
        write_array_reference_string__("field1", v.getField1());
        jsonGenerator.writeFieldName("field2"); 
        write_array_array_reference_string___("field2", v.getField2());
        jsonGenerator.writeFieldName("field3"); 
        write_array_array_array_reference_string____("field3", v.getField3());
        jsonGenerator.writeFieldName("field4"); 
        write_reference_array_string__("field4", v.getField4());
        jsonGenerator.writeFieldName("field5"); 
        write_reference_array_reference_string___("field5", v.getField5());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }





    public void write_int32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }

    public void write_array_reference_string__(java.lang.String name, java.util.List<java.lang.String> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (java.lang.String e : v) {
            write_reference_string_(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_array_string_(java.lang.String name, java.util.List<java.lang.String> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (java.lang.String e : v) {
            write_string(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_string(java.lang.String name, java.lang.String v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeString(v);
    }

    public void write_reference_string_(java.lang.String name, java.lang.String v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, java.lang.String.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_string(name, (java.lang.String)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_uint32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }

    public void write_boolean(java.lang.String name, boolean v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeBoolean(v);
    }

    public void write_array_array_array_reference_string____(java.lang.String name, java.util.List<java.util.List<java.util.List<java.lang.String>>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (java.util.List<java.util.List<java.lang.String>> e : v) {
            write_array_array_reference_string___(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_reference_array_reference_string___(java.lang.String name, java.util.List<java.lang.String> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, java.util.ArrayList.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_array_reference_string__(name, (java.util.List<java.lang.String>)v);
        }
        jsonGenerator.writeEndObject();
    }


    public void write_reference_array_string__(java.lang.String name, java.util.List<java.lang.String> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, java.util.ArrayList.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_array_string_(name, (java.util.List<java.lang.String>)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_array_array_reference_string___(java.lang.String name, java.util.List<java.util.List<java.lang.String>> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (java.util.List<java.lang.String> e : v) {
            write_array_reference_string__(name, e);
        }
        jsonGenerator.writeEndArray();
    }


}

class TeslaJsonReader_compiler_test_passcompile_full_complexttypetest extends Serializer.ObjectReader {


    public static final long SCHEMA_HASH = -5586303099293846137L;
    private static final com.fasterxml.jackson.databind.ObjectMapper JSON_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private com.fasterxml.jackson.databind.JsonNode root;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    TeslaJsonReader_compiler_test_passcompile_full_complexttypetest(java.io.InputStream stream) throws java.io.IOException {
        root = JSON_MAPPER.readTree(stream);
    }

    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.complexttypetest read_class_com_expedia_tesla_compiler_test_passcompile_full_complexttypetest_(String name, com.expedia.tesla.compiler.test.passcompile.full.complexttypetest v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_complexttypetest_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.complexttypetest read_class_com_expedia_tesla_compiler_test_passcompile_full_complexttypetest_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_complexttypetest_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.complexttypetest read_class_com_expedia_tesla_compiler_test_passcompile_full_complexttypetest_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.complexttypetest v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.complexttypetest();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("field1");
        if(vn != null)
            v.getField1(read_array_reference_string__("field1", vn));
        vn = node.get("field2");
        if(vn != null)
            v.getField2(read_array_array_reference_string___("field2", vn));
        vn = node.get("field3");
        if(vn != null)
            v.getField3(read_array_array_array_reference_string____("field3", vn));
        vn = node.get("field4");
        if(vn != null)
            v.getField4(read_reference_array_string__("field4", vn));
        vn = node.get("field5");
        if(vn != null)
            v.getField5(read_reference_array_reference_string___("field5", vn));
        return v;
    }
    

    public int read_int32(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.intValue();
    }

    public java.util.List<java.lang.String> read_array_reference_string__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.lang.String> v = new java.util.ArrayList<java.lang.String>();
        while (itr.hasNext()) {
            v.add(read_reference_string_(name, itr.next()));
        }
        return v;
    }

    public java.util.List<java.lang.String> read_array_string_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.lang.String> v = new java.util.ArrayList<java.lang.String>();
        while (itr.hasNext()) {
            v.add(read_string(name, itr.next()));
        }
        return v;
    }

    public java.lang.String read_string(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.textValue();
    }

    public java.lang.String read_reference_string_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.String.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            java.lang.String v = read_string(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, java.lang.String.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public int read_uint32(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (int)node.longValue();
    }

    public boolean read_boolean(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.booleanValue();
    }

    public java.util.List<java.util.List<java.util.List<java.lang.String>>> read_array_array_array_reference_string____(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.util.List<java.util.List<java.lang.String>>> v = new java.util.ArrayList<java.util.List<java.util.List<java.lang.String>>>();
        while (itr.hasNext()) {
            v.add(read_array_array_reference_string___(name, itr.next()));
        }
        return v;
    }

    public java.util.List<java.lang.String> read_reference_array_reference_string___(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, java.util.ArrayList.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            java.util.List<java.lang.String> v = read_array_reference_string__(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, java.util.ArrayList.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }


    public java.util.List<java.lang.String> read_reference_array_string__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, java.util.ArrayList.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            java.util.List<java.lang.String> v = read_array_string_(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, java.util.ArrayList.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.util.List<java.lang.String>> read_array_array_reference_string___(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.util.List<java.lang.String>> v = new java.util.ArrayList<java.util.List<java.lang.String>>();
        while (itr.hasNext()) {
            v.add(read_array_reference_string__(name, itr.next()));
        }
        return v;
    }



}


class TeslaJsonWriter_compiler_test_passcompile_full_inheritance_v1_0 extends Serializer.ObjectWriter {


    public static final long SCHEMA_HASH = -4144946394736392407L;
    private static final com.fasterxml.jackson.core.JsonFactory JSON_FACTORY = new com.fasterxml.jackson.core.JsonFactory();
    private com.fasterxml.jackson.core.JsonGenerator jsonGenerator;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
	
	TeslaJsonWriter_compiler_test_passcompile_full_inheritance_v1_0(java.io.OutputStream stream) throws java.io.IOException {
        jsonGenerator = JSON_FACTORY.createGenerator(stream);
    }


    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_SingleDerived_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("Int32Field"); 
        write_int32("Int32Field", v.getInt32Field());
        jsonGenerator.writeFieldName("BooleanField"); 
        write_boolean("BooleanField", v.getBooleanField());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }


    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base2_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("Int16Field"); 
        write_int16("Int16Field", v.getInt16Field());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }



    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base1_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("Int32Field"); 
        write_int32("Int32Field", v.getInt32Field());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }






    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_MultiDerived_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("Int32Field"); 
        write_int32("Int32Field", v.getInt32Field());
        jsonGenerator.writeFieldName("Int16Field"); 
        write_int16("Int16Field", v.getInt16Field());
        jsonGenerator.writeFieldName("ByteField"); 
        write_byte("ByteField", v.getByteField());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }



    public void write_int32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }



    public void write_byte(java.lang.String name, byte v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }


    public void write_int16(java.lang.String name, short v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }

    public void write_string(java.lang.String name, java.lang.String v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeString(v);
    }

    public void write_uint32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }

    public void write_boolean(java.lang.String name, boolean v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeBoolean(v);
    }



}

class TeslaJsonReader_compiler_test_passcompile_full_inheritance_v1_0 extends Serializer.ObjectReader {


    public static final long SCHEMA_HASH = -4144946394736392407L;
    private static final com.fasterxml.jackson.databind.ObjectMapper JSON_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private com.fasterxml.jackson.databind.JsonNode root;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    TeslaJsonReader_compiler_test_passcompile_full_inheritance_v1_0(java.io.InputStream stream) throws java.io.IOException {
        root = JSON_MAPPER.readTree(stream);
    }

    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_SingleDerived_(String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_SingleDerived_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_SingleDerived_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_SingleDerived_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_SingleDerived_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("Int32Field");
        if(vn != null)
            v.setInt32Field(read_int32("Int32Field", vn));
        vn = node.get("BooleanField");
        if(vn != null)
            v.setBooleanField(read_boolean("BooleanField", vn));
        return v;
    }
    
    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base2_(String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base2_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base2_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base2_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base2_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("Int16Field");
        if(vn != null)
            v.setInt16Field(read_int16("Int16Field", vn));
        return v;
    }
    
    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base1_(String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base1_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base1_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base1_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base1_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("Int32Field");
        if(vn != null)
            v.setInt32Field(read_int32("Int32Field", vn));
        return v;
    }
    
    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_MultiDerived_(String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_MultiDerived_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_MultiDerived_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_MultiDerived_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_MultiDerived_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("Int32Field");
        if(vn != null)
            v.setInt32Field(read_int32("Int32Field", vn));
        vn = node.get("Int16Field");
        if(vn != null)
            v.setInt16Field(read_int16("Int16Field", vn));
        vn = node.get("ByteField");
        if(vn != null)
            v.setByteField(read_byte("ByteField", vn));
        return v;
    }
    

    public int read_int32(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.intValue();
    }



    public byte read_byte(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (byte)node.intValue();
    }


    public short read_int16(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (short)node.intValue();
    }

    public java.lang.String read_string(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.textValue();
    }

    public int read_uint32(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (int)node.longValue();
    }

    public boolean read_boolean(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.booleanValue();
    }




}


class TeslaJsonWriter_teslacompiler_reference_test_v1_0 extends Serializer.ObjectWriter {


    public static final long SCHEMA_HASH = -8997496319200256941L;
    private static final com.fasterxml.jackson.core.JsonFactory JSON_FACTORY = new com.fasterxml.jackson.core.JsonFactory();
    private com.fasterxml.jackson.core.JsonGenerator jsonGenerator;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
	
	TeslaJsonWriter_teslacompiler_reference_test_v1_0(java.io.OutputStream stream) throws java.io.IOException {
        jsonGenerator = JSON_FACTORY.createGenerator(stream);
    }



    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_EnumReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("ReferenceField1"); 
        write_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum__("ReferenceField1", v.getReferenceField1());
        jsonGenerator.writeFieldName("ReferenceField2"); 
        write_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum__("ReferenceField2", v.getReferenceField2());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }


    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_StringReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("ReferenceField1"); 
        write_reference_string_("ReferenceField1", v.getReferenceField1());
        jsonGenerator.writeFieldName("ReferenceField2"); 
        write_reference_string_("ReferenceField2", v.getReferenceField2());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }


    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("IntField"); 
        write_int32("IntField", v.getIntField());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }





    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_Int32Reference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("ReferenceField1"); 
        write_reference_int32_("ReferenceField1", v.getReferenceField1());
        jsonGenerator.writeFieldName("ReferenceField2"); 
        write_reference_int32_("ReferenceField2", v.getReferenceField2());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }



    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ObjectReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("ReferenceField1"); 
        write_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__("ReferenceField1", v.getReferenceField1());
        jsonGenerator.writeFieldName("ReferenceField2"); 
        write_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__("ReferenceField2", v.getReferenceField2());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }





    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ArrayReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("ReferenceField1"); 
        write_reference_array_int32__("ReferenceField1", v.getReferenceField1());
        jsonGenerator.writeFieldName("ReferenceField2"); 
        write_reference_array_int32__("ReferenceField2", v.getReferenceField2());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }




    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ReferenceArray_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("ReferenceArrayField"); 
        write_array_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject___("ReferenceArrayField", v.getReferenceArrayField());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }





    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_BinaryReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("ReferenceField1"); 
        write_reference_binary_("ReferenceField1", v.getReferenceField1());
        jsonGenerator.writeFieldName("ReferenceField2"); 
        write_reference_binary_("ReferenceField2", v.getReferenceField2());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }



    public void write_binary(java.lang.String name, byte[] v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeBinary(v);
    }

    public void write_array_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject___(java.lang.String name, java.util.List<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject e : v) {
            write_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__(name, e);
        }
        jsonGenerator.writeEndArray();
    }




    public void write_uint32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }

    public void write_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum__(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum_(name, (com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        switch (v) {
        case Info:
            write_string(name, "Info");
            break;
        case Warning:
            write_string(name, "Warning");
            break;
        case Error:
            write_string(name, "Error");
            break;
        default:
            throw new com.expedia.tesla.serialization.TeslaSerializationException(String.format(
                "Enum value %s is not allowed on field %s (type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum>')", 
                v.toString(), name));
        }
    }


    public void write_reference_binary_(java.lang.String name, byte[] v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, byte[].class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_binary(name, (byte[])v);
        }
        jsonGenerator.writeEndObject();
    }


    public void write_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(name, (com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_array_int32_(java.lang.String name, java.util.List<java.lang.Integer> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (int e : v) {
            write_int32(name, e);
        }
        jsonGenerator.writeEndArray();
    }

    public void write_int32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }


    public void write_reference_array_int32__(java.lang.String name, java.util.List<java.lang.Integer> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, java.util.ArrayList.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_array_int32_(name, (java.util.List<java.lang.Integer>)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_reference_int32_(java.lang.String name, java.lang.Integer v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, java.lang.Integer.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_int32(name, (java.lang.Integer)v);
        }
        jsonGenerator.writeEndObject();
    }


    public void write_string(java.lang.String name, java.lang.String v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeString(v);
    }

    public void write_reference_string_(java.lang.String name, java.lang.String v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, java.lang.String.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_string(name, (java.lang.String)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_boolean(java.lang.String name, boolean v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeBoolean(v);
    }



}

class TeslaJsonReader_teslacompiler_reference_test_v1_0 extends Serializer.ObjectReader {


    public static final long SCHEMA_HASH = -8997496319200256941L;
    private static final com.fasterxml.jackson.databind.ObjectMapper JSON_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private com.fasterxml.jackson.databind.JsonNode root;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    TeslaJsonReader_teslacompiler_reference_test_v1_0(java.io.InputStream stream) throws java.io.IOException {
        root = JSON_MAPPER.readTree(stream);
    }

    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_EnumReference_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_EnumReference_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_EnumReference_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_EnumReference_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_EnumReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("ReferenceField1");
        if(vn != null)
            v.setReferenceField1(read_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum__("ReferenceField1", vn));
        vn = node.get("ReferenceField2");
        if(vn != null)
            v.setReferenceField2(read_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum__("ReferenceField2", vn));
        return v;
    }
    
    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_StringReference_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_StringReference_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_StringReference_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_StringReference_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_StringReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("ReferenceField1");
        if(vn != null)
            v.setReferenceField1(read_reference_string_("ReferenceField1", vn));
        vn = node.get("ReferenceField2");
        if(vn != null)
            v.setReferenceField2(read_reference_string_("ReferenceField2", vn));
        return v;
    }
    
    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("IntField");
        if(vn != null)
            v.setIntField(read_int32("IntField", vn));
        return v;
    }
    
    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_Int32Reference_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_Int32Reference_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_Int32Reference_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_Int32Reference_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_Int32Reference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("ReferenceField1");
        if(vn != null)
            v.setReferenceField1(read_reference_int32_("ReferenceField1", vn));
        vn = node.get("ReferenceField2");
        if(vn != null)
            v.setReferenceField2(read_reference_int32_("ReferenceField2", vn));
        return v;
    }
    
    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ObjectReference_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ObjectReference_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ObjectReference_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ObjectReference_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ObjectReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("ReferenceField1");
        if(vn != null)
            v.setReferenceField1(read_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__("ReferenceField1", vn));
        vn = node.get("ReferenceField2");
        if(vn != null)
            v.setReferenceField2(read_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__("ReferenceField2", vn));
        return v;
    }
    
    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ArrayReference_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ArrayReference_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ArrayReference_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ArrayReference_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ArrayReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("ReferenceField1");
        if(vn != null)
            v.setReferenceField1(read_reference_array_int32__("ReferenceField1", vn));
        vn = node.get("ReferenceField2");
        if(vn != null)
            v.setReferenceField2(read_reference_array_int32__("ReferenceField2", vn));
        return v;
    }
    
    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ReferenceArray_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ReferenceArray_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ReferenceArray_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ReferenceArray_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ReferenceArray_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("ReferenceArrayField");
        if(vn != null)
            v.setReferenceArrayField(read_array_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject___("ReferenceArrayField", vn));
        return v;
    }
    
    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_BinaryReference_(String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_BinaryReference_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_BinaryReference_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_BinaryReference_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_BinaryReference_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("ReferenceField1");
        if(vn != null)
            v.setReferenceField1(read_reference_binary_("ReferenceField1", vn));
        vn = node.get("ReferenceField2");
        if(vn != null)
            v.setReferenceField2(read_reference_binary_("ReferenceField2", vn));
        return v;
    }
    

    public byte[] read_binary(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.binaryValue();
    }

    public java.util.List<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject> read_array_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject___(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject> v = new java.util.ArrayList<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject>();
        while (itr.hasNext()) {
            v.add(read_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__(name, itr.next()));
        }
        return v;
    }




    public int read_uint32(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (int)node.longValue();
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum read_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum v = read_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum_(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum read_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        java.lang.String v = node.textValue();
        if (v.equals("Info")) {
            return com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum.Info;
        }
        if (v.equals("Warning")) {
            return com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum.Warning;
        }
        if (v.equals("Error")) {
            return com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum.Error;
        }
        throw new java.io.IOException(String.format(
            "Invalid Enum value '%s' encountered when reading field %s (type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum>')", 
            v, name));
    }


    public byte[] read_reference_binary_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, byte[].class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            byte[] v = read_binary(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, byte[].class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }


    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject read_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject v = read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.lang.Integer> read_array_int32_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.List<java.lang.Integer> v = new java.util.ArrayList<java.lang.Integer>();
        while (itr.hasNext()) {
            v.add(read_int32(name, itr.next()));
        }
        return v;
    }

    public int read_int32(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.intValue();
    }


    public java.util.List<java.lang.Integer> read_reference_array_int32__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, java.util.ArrayList.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            java.util.List<java.lang.Integer> v = read_array_int32_(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, java.util.ArrayList.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.lang.Integer read_reference_int32_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Integer.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            int v = read_int32(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, java.lang.Integer.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }


    public java.lang.String read_string(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.textValue();
    }

    public java.lang.String read_reference_string_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.String.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            java.lang.String v = read_string(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, java.lang.String.class);
            return v;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public boolean read_boolean(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.booleanValue();
    }




}


class TeslaJsonWriter_versioning_test_v1_0 extends Serializer.ObjectWriter {


    public static final long SCHEMA_HASH = -1533394106668605082L;
    private static final com.fasterxml.jackson.core.JsonFactory JSON_FACTORY = new com.fasterxml.jackson.core.JsonFactory();
    private com.fasterxml.jackson.core.JsonGenerator jsonGenerator;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
	
	TeslaJsonWriter_versioning_test_v1_0(java.io.OutputStream stream) throws java.io.IOException {
        jsonGenerator = JSON_FACTORY.createGenerator(stream);
    }







    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("EnumField"); 
        write_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__("EnumField", v.getEnumField());
        jsonGenerator.writeFieldName("DepricatedInt32Field"); 
        write_nullable_int32_("DepricatedInt32Field", v.getDepricatedInt32Field());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }




    public void write_int32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }

    public void write_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(name, v);
        }
    }

    public void write_string(java.lang.String name, java.lang.String v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeString(v);
    }

    public void write_uint32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }

    public void write_boolean(java.lang.String name, boolean v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeBoolean(v);
    }

    public void write_nullable_int32_(java.lang.String name, java.lang.Integer v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_int32(name, v);
        }
    }


    public void write_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        switch (v) {
        case Value1:
            write_string(name, "Value1");
            break;
        case Value2:
            write_string(name, "Value2");
            break;
        case Value3:
            write_string(name, "Value3");
            break;
        default:
            throw new com.expedia.tesla.serialization.TeslaSerializationException(String.format(
                "Enum value %s is not allowed on field %s (type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum>')", 
                v.toString(), name));
        }
    }


}

class TeslaJsonReader_versioning_test_v1_0 extends Serializer.ObjectReader {


    public static final long SCHEMA_HASH = -1533394106668605082L;
    private static final com.fasterxml.jackson.databind.ObjectMapper JSON_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private com.fasterxml.jackson.databind.JsonNode root;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    TeslaJsonReader_versioning_test_v1_0(java.io.InputStream stream) throws java.io.IOException {
        root = JSON_MAPPER.readTree(stream);
    }

    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("EnumField");
        if(vn != null)
            v.setEnumField(read_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__("EnumField", vn));
        vn = node.get("DepricatedInt32Field");
        if(vn != null)
            v.setDepricatedInt32Field(read_nullable_int32_("DepricatedInt32Field", vn));
        return v;
    }
    

    public int read_int32(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.intValue();
    }

    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum read_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(name, node);
        }
    }

    public java.lang.String read_string(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.textValue();
    }

    public int read_uint32(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (int)node.longValue();
    }

    public boolean read_boolean(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.booleanValue();
    }

    public java.lang.Integer read_nullable_int32_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_int32(name, node);
        }
    }


    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum read_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        java.lang.String v = node.textValue();
        if (v.equals("Value1")) {
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value1;
        }
        if (v.equals("Value2")) {
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value2;
        }
        if (v.equals("Value3")) {
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value3;
        }
        throw new java.io.IOException(String.format(
            "Invalid Enum value '%s' encountered when reading field %s (type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum>')", 
            v, name));
    }



}


class TeslaJsonWriter_versioning_test_v2_0 extends Serializer.ObjectWriter {


    public static final long SCHEMA_HASH = 3897695751964630335L;
    private static final com.fasterxml.jackson.core.JsonFactory JSON_FACTORY = new com.fasterxml.jackson.core.JsonFactory();
    private com.fasterxml.jackson.core.JsonGenerator jsonGenerator;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
	
	TeslaJsonWriter_versioning_test_v2_0(java.io.OutputStream stream) throws java.io.IOException {
        jsonGenerator = JSON_FACTORY.createGenerator(stream);
    }








    public void write_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("EnumField"); 
        write_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__("EnumField", v.getEnumField());
        jsonGenerator.writeFieldName("NewInt64Field"); 
        write_nullable_int64_("NewInt64Field", v.getNewInt64Field());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }




    public void write_int32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }

    public void write_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(name, v);
        }
    }

    public void write_nullable_int64_(java.lang.String name, java.lang.Long v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_int64(name, v);
        }
    }

    public void write_int64(java.lang.String name, long v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }

    public void write_string(java.lang.String name, java.lang.String v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeString(v);
    }

    public void write_uint32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }

    public void write_boolean(java.lang.String name, boolean v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeBoolean(v);
    }


    public void write_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        switch (v) {
        case Value1:
            write_string(name, "Value1");
            break;
        case Value5:
            write_string(name, "Value5");
            break;
        case Value2:
            write_string(name, "Value2");
            break;
        case Value4:
            write_string(name, "Value4");
            break;
        default:
            throw new com.expedia.tesla.serialization.TeslaSerializationException(String.format(
                "Enum value %s is not allowed on field %s (type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum>')", 
                v.toString(), name));
        }
    }


}

class TeslaJsonReader_versioning_test_v2_0 extends Serializer.ObjectReader {


    public static final long SCHEMA_HASH = 3897695751964630335L;
    private static final com.fasterxml.jackson.databind.ObjectMapper JSON_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private com.fasterxml.jackson.databind.JsonNode root;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    TeslaJsonReader_versioning_test_v2_0(java.io.InputStream stream) throws java.io.IOException {
        root = JSON_MAPPER.readTree(stream);
    }

    @Override
    protected com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(name, v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(name, null, node);
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(java.lang.String name, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new AssertionError("BUG, not an object!");
        if (v == null) 
            v = new com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("EnumField");
        if(vn != null)
            v.setEnumField(read_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__("EnumField", vn));
        vn = node.get("NewInt64Field");
        if(vn != null)
            v.setNewInt64Field(read_nullable_int64_("NewInt64Field", vn));
        return v;
    }
    

    public int read_int32(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.intValue();
    }

    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum read_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(name, node);
        }
    }

    public java.lang.Long read_nullable_int64_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_int64(name, node);
        }
    }

    public long read_int64(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.longValue();
    }

    public java.lang.String read_string(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.textValue();
    }

    public int read_uint32(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (int)node.longValue();
    }

    public boolean read_boolean(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.booleanValue();
    }


    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum read_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        java.lang.String v = node.textValue();
        if (v.equals("Value1")) {
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value1;
        }
        if (v.equals("Value5")) {
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value5;
        }
        if (v.equals("Value2")) {
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value2;
        }
        if (v.equals("Value4")) {
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value4;
        }
        throw new java.io.IOException(String.format(
            "Invalid Enum value '%s' encountered when reading field %s (type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum>')", 
            v, name));
    }



}



class TeslaJsonChangeWriter_teslacompiler_all_types_v1_0 extends Serializer.ChangeWriter {


    public static final long SCHEMA_HASH = 7810441853185379917L;
    private static final com.fasterxml.jackson.databind.ObjectMapper OBJECT_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private static final com.fasterxml.jackson.databind.node.JsonNodeFactory NODE_FACTORY = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    private java.io.OutputStream stream;
    
    TeslaJsonChangeWriter_teslacompiler_all_types_v1_0(java.io.OutputStream stream) throws java.io.IOException {
        this.stream = stream;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_nullable_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___(oldValue.getOptionalObjectArrayField(), newValue.getOptionalObjectArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalObjectArrayField", ejn);
        }
        if ((ejn = write_nullable_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___(oldValue.getOptionalEnumArrayField(), newValue.getOptionalEnumArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalEnumArrayField", ejn);
        }
        if ((ejn = write_nullable_array_boolean__(oldValue.getOptionalBoolArrayField(), newValue.getOptionalBoolArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalBoolArrayField", ejn);
        }
        if ((ejn = write_nullable_array_byte__(oldValue.getOptionalByteArrayField(), newValue.getOptionalByteArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalByteArrayField", ejn);
        }
        if ((ejn = write_nullable_array_int16__(oldValue.getOptionalInt16ArrayField(), newValue.getOptionalInt16ArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalInt16ArrayField", ejn);
        }
        if ((ejn = write_nullable_array_uint16__(oldValue.getOptionalUInt16ArrayField(), newValue.getOptionalUInt16ArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalUInt16ArrayField", ejn);
        }
        if ((ejn = write_nullable_array_int32__(oldValue.getOptionalInt32ArrayField(), newValue.getOptionalInt32ArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalInt32ArrayField", ejn);
        }
        if ((ejn = write_nullable_array_uint32__(oldValue.getOptionalUInt32ArrayField(), newValue.getOptionalUInt32ArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalUInt32ArrayField", ejn);
        }
        if ((ejn = write_nullable_array_int64__(oldValue.getOptionalInt64ArrayField(), newValue.getOptionalInt64ArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalInt64ArrayField", ejn);
        }
        if ((ejn = write_nullable_array_uint64__(oldValue.getOptionalUInt64ArrayField(), newValue.getOptionalUInt64ArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalUInt64ArrayField", ejn);
        }
        if ((ejn = write_nullable_array_float__(oldValue.getOptionalFloatArrayField(), newValue.getOptionalFloatArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalFloatArrayField", ejn);
        }
        if ((ejn = write_nullable_array_double__(oldValue.getOptionalDoubleArrayField(), newValue.getOptionalDoubleArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalDoubleArrayField", ejn);
        }
        if ((ejn = write_nullable_array_string__(oldValue.getOptionalStringArrayField(), newValue.getOptionalStringArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalStringArrayField", ejn);
        }
        return jn;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_int32(oldValue.getIntField(), newValue.getIntField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("IntField", ejn);
        }
        return jn;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_array_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___(oldValue.getObject2DArrayField(), newValue.getObject2DArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Object2DArrayField", ejn);
        }
        if ((ejn = write_array_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___(oldValue.getEnum2DArrayField(), newValue.getEnum2DArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Enum2DArrayField", ejn);
        }
        if ((ejn = write_array_array_boolean__(oldValue.getBool2DArrayField(), newValue.getBool2DArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Bool2DArrayField", ejn);
        }
        if ((ejn = write_array_array_byte__(oldValue.getByte2DArrayField(), newValue.getByte2DArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Byte2DArrayField", ejn);
        }
        if ((ejn = write_array_array_int16__(oldValue.getInt162DArrayField(), newValue.getInt162DArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Int162DArrayField", ejn);
        }
        if ((ejn = write_array_array_uint16__(oldValue.getUInt162DArrayField(), newValue.getUInt162DArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("UInt162DArrayField", ejn);
        }
        if ((ejn = write_array_array_int32__(oldValue.getInt322DArrayField(), newValue.getInt322DArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Int322DArrayField", ejn);
        }
        if ((ejn = write_array_array_uint32__(oldValue.getUInt322DArrayField(), newValue.getUInt322DArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("UInt322DArrayField", ejn);
        }
        if ((ejn = write_array_array_int64__(oldValue.getInt642DArrayField(), newValue.getInt642DArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Int642DArrayField", ejn);
        }
        if ((ejn = write_array_array_uint64__(oldValue.getUInt642DArrayField(), newValue.getUInt642DArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("UInt642DArrayField", ejn);
        }
        if ((ejn = write_array_array_float__(oldValue.getFloat2DArrayField(), newValue.getFloat2DArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Float2DArrayField", ejn);
        }
        if ((ejn = write_array_array_double__(oldValue.getDouble2DArrayField(), newValue.getDouble2DArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Double2DArrayField", ejn);
        }
        if ((ejn = write_array_array_string__(oldValue.getString2DArrayField(), newValue.getString2DArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("String2DArrayField", ejn);
        }
        return jn;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_nullable_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(oldValue.getOptionalObjectField(), newValue.getOptionalObjectField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalObjectField", ejn);
        }
        if ((ejn = write_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(oldValue.getOptionalEnumField(), newValue.getOptionalEnumField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalEnumField", ejn);
        }
        if ((ejn = write_nullable_boolean_(oldValue.getOptionalBoolField(), newValue.getOptionalBoolField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalBoolField", ejn);
        }
        if ((ejn = write_nullable_byte_(oldValue.getOptionalByteField(), newValue.getOptionalByteField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalByteField", ejn);
        }
        if ((ejn = write_nullable_int16_(oldValue.getOptionalInt16Field(), newValue.getOptionalInt16Field())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalInt16Field", ejn);
        }
        if ((ejn = write_nullable_uint16_(oldValue.getOptionalUInt16Field(), newValue.getOptionalUInt16Field())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalUInt16Field", ejn);
        }
        if ((ejn = write_nullable_int32_(oldValue.getOptionalInt32Field(), newValue.getOptionalInt32Field())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalInt32Field", ejn);
        }
        if ((ejn = write_nullable_uint32_(oldValue.getOptionalUInt32Field(), newValue.getOptionalUInt32Field())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalUInt32Field", ejn);
        }
        if ((ejn = write_nullable_int64_(oldValue.getOptionalInt64Field(), newValue.getOptionalInt64Field())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalInt64Field", ejn);
        }
        if ((ejn = write_nullable_uint64_(oldValue.getOptionalUInt64Field(), newValue.getOptionalUInt64Field())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalUInt64Field", ejn);
        }
        if ((ejn = write_nullable_float_(oldValue.getOptionalFloatField(), newValue.getOptionalFloatField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalFloatField", ejn);
        }
        if ((ejn = write_nullable_double_(oldValue.getOptionalDoubleField(), newValue.getOptionalDoubleField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalDoubleField", ejn);
        }
        if ((ejn = write_nullable_binary_(oldValue.getOptionalBinaryField(), newValue.getOptionalBinaryField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalBinaryField", ejn);
        }
        if ((ejn = write_nullable_string_(oldValue.getOptionalStringField(), newValue.getOptionalStringField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalStringField", ejn);
        }
        return jn;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(oldValue.getObjectArrayField(), newValue.getObjectArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ObjectArrayField", ejn);
        }
        if ((ejn = write_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(oldValue.getEnumArrayField(), newValue.getEnumArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("EnumArrayField", ejn);
        }
        if ((ejn = write_array_boolean_(oldValue.getBoolArrayField(), newValue.getBoolArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("BoolArrayField", ejn);
        }
        if ((ejn = write_array_byte_(oldValue.getByteArrayField(), newValue.getByteArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ByteArrayField", ejn);
        }
        if ((ejn = write_array_int16_(oldValue.getInt16ArrayField(), newValue.getInt16ArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Int16ArrayField", ejn);
        }
        if ((ejn = write_array_uint16_(oldValue.getUInt16ArrayField(), newValue.getUInt16ArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("UInt16ArrayField", ejn);
        }
        if ((ejn = write_array_int32_(oldValue.getInt32ArrayField(), newValue.getInt32ArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Int32ArrayField", ejn);
        }
        if ((ejn = write_array_uint32_(oldValue.getUInt32ArrayField(), newValue.getUInt32ArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("UInt32ArrayField", ejn);
        }
        if ((ejn = write_array_int64_(oldValue.getInt64ArrayField(), newValue.getInt64ArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Int64ArrayField", ejn);
        }
        if ((ejn = write_array_uint64_(oldValue.getUInt64ArrayField(), newValue.getUInt64ArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("UInt64ArrayField", ejn);
        }
        if ((ejn = write_array_float_(oldValue.getFloatArrayField(), newValue.getFloatArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("FloatArrayField", ejn);
        }
        if ((ejn = write_array_double_(oldValue.getDoubleArrayField(), newValue.getDoubleArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("DoubleArrayField", ejn);
        }
        if ((ejn = write_array_string_(oldValue.getStringArrayField(), newValue.getStringArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("StringArrayField", ejn);
        }
        return jn;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(oldValue.getObjectField(), newValue.getObjectField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ObjectField", ejn);
        }
        if ((ejn = write_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(oldValue.getEnumField(), newValue.getEnumField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("EnumField", ejn);
        }
        if ((ejn = write_boolean(oldValue.getBoolField(), newValue.getBoolField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("BoolField", ejn);
        }
        if ((ejn = write_byte(oldValue.getByteField(), newValue.getByteField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ByteField", ejn);
        }
        if ((ejn = write_int16(oldValue.getInt16Field(), newValue.getInt16Field())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Int16Field", ejn);
        }
        if ((ejn = write_uint16(oldValue.getUInt16Field(), newValue.getUInt16Field())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("UInt16Field", ejn);
        }
        if ((ejn = write_int32(oldValue.getInt32Field(), newValue.getInt32Field())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Int32Field", ejn);
        }
        if ((ejn = write_uint32(oldValue.getUInt32Field(), newValue.getUInt32Field())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("UInt32Field", ejn);
        }
        if ((ejn = write_int64(oldValue.getInt64Field(), newValue.getInt64Field())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Int64Field", ejn);
        }
        if ((ejn = write_uint64(oldValue.getUInt64Field(), newValue.getUInt64Field())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("UInt64Field", ejn);
        }
        if ((ejn = write_float(oldValue.getFloatField(), newValue.getFloatField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("FloatField", ejn);
        }
        if ((ejn = write_double(oldValue.getDoubleField(), newValue.getDoubleField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("DoubleField", ejn);
        }
        if ((ejn = write_binary(oldValue.getBinaryField(), newValue.getBinaryField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("BinaryField", ejn);
        }
        if ((ejn = write_string(oldValue.getStringField(), newValue.getStringField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("StringField", ejn);
        }
        return jn;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_reference_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(oldValue.getObjectReferenceField(), newValue.getObjectReferenceField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ObjectReferenceField", ejn);
        }
        if ((ejn = write_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(oldValue.getEnumReferenceField(), newValue.getEnumReferenceField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("EnumReferenceField", ejn);
        }
        if ((ejn = write_reference_boolean_(oldValue.getBoolReferenceField(), newValue.getBoolReferenceField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("BoolReferenceField", ejn);
        }
        if ((ejn = write_reference_byte_(oldValue.getByteReferenceField(), newValue.getByteReferenceField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ByteReferenceField", ejn);
        }
        if ((ejn = write_reference_int16_(oldValue.getInt16ReferenceField(), newValue.getInt16ReferenceField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Int16ReferenceField", ejn);
        }
        if ((ejn = write_reference_uint16_(oldValue.getUInt16ReferenceField(), newValue.getUInt16ReferenceField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("UInt16ReferenceField", ejn);
        }
        if ((ejn = write_reference_int32_(oldValue.getInt32ReferenceField(), newValue.getInt32ReferenceField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Int32ReferenceField", ejn);
        }
        if ((ejn = write_reference_uint32_(oldValue.getUInt32ReferenceField(), newValue.getUInt32ReferenceField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("UInt32ReferenceField", ejn);
        }
        if ((ejn = write_reference_int64_(oldValue.getInt64ReferenceField(), newValue.getInt64ReferenceField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Int64ReferenceField", ejn);
        }
        if ((ejn = write_reference_uint64_(oldValue.getUInt64ReferenceField(), newValue.getUInt64ReferenceField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("UInt64ReferenceField", ejn);
        }
        if ((ejn = write_reference_float_(oldValue.getFloatReferenceField(), newValue.getFloatReferenceField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("FloatReferenceField", ejn);
        }
        if ((ejn = write_reference_double_(oldValue.getDoubleReferenceField(), newValue.getDoubleReferenceField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("DoubleReferenceField", ejn);
        }
        if ((ejn = write_reference_binary_(oldValue.getBinaryReferenceField(), newValue.getBinaryReferenceField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("BinaryReferenceField", ejn);
        }
        if ((ejn = write_reference_string_(oldValue.getStringReferenceField(), newValue.getStringReferenceField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("StringReferenceField", ejn);
        }
        return jn;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestObject_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestObject_(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(oldValue.getBasicTestObjectField(), newValue.getBasicTestObjectField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("BasicTestObjectField", ejn);
        }
        if ((ejn = write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(oldValue.getReferenceTestObjectField(), newValue.getReferenceTestObjectField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ReferenceTestObjectField", ejn);
        }
        if ((ejn = write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(oldValue.getOptionalBasicTestObjectField(), newValue.getOptionalBasicTestObjectField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalBasicTestObjectField", ejn);
        }
        if ((ejn = write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(oldValue.getArrayTestObjectField(), newValue.getArrayTestObjectField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ArrayTestObjectField", ejn);
        }
        if ((ejn = write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(oldValue.getArray2DTestObjectField(), newValue.getArray2DTestObjectField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Array2DTestObjectField", ejn);
        }
        if ((ejn = write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(oldValue.getOptionalArrayTestObjectField(), newValue.getOptionalArrayTestObjectField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("OptionalArrayTestObjectField", ejn);
        }
        return jn;
    }


    public com.fasterxml.jackson.databind.JsonNode write_array_array_uint16__(java.util.List<java.util.List<java.lang.Short>> oldValue, java.util.List<java.util.List<java.lang.Short>> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_array_uint16_(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_array_boolean__(java.util.List<java.util.List<java.lang.Boolean>> oldValue, java.util.List<java.util.List<java.lang.Boolean>> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_array_boolean_(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> oldValue, java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_reference_byte_(java.lang.Byte oldValue, java.lang.Byte newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_byte((java.lang.Byte)oldValue, (java.lang.Byte)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, java.lang.Byte.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___(java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> oldValue, java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(oldValue, newValue);
        }
    }


    public com.fasterxml.jackson.databind.JsonNode write_nullable_int16_(java.lang.Short oldValue, java.lang.Short newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_int16(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> oldValue, java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_byte_(java.util.List<java.lang.Byte> oldValue, java.util.List<java.lang.Byte> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_byte(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_int32_(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_int32(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_array_boolean__(java.util.List<java.lang.Boolean> oldValue, java.util.List<java.lang.Boolean> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_array_boolean_(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_array_int16__(java.util.List<java.util.List<java.lang.Short>> oldValue, java.util.List<java.util.List<java.lang.Short>> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_array_int16_(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_float(java.lang.Float oldValue, java.lang.Float newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_reference_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_((com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject)oldValue, (com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_array_string__(java.util.List<java.util.List<java.lang.String>> oldValue, java.util.List<java.util.List<java.lang.String>> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_array_string_(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_boolean_(java.util.List<java.lang.Boolean> oldValue, java.util.List<java.lang.Boolean> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_boolean(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_array_byte__(java.util.List<java.util.List<java.lang.Byte>> oldValue, java.util.List<java.util.List<java.lang.Byte>> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_array_byte_(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_uint16(java.lang.Short oldValue, java.lang.Short newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_reference_uint16_(java.lang.Short oldValue, java.lang.Short newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_uint16((java.lang.Short)oldValue, (java.lang.Short)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, java.lang.Short.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_reference_int16_(java.lang.Short oldValue, java.lang.Short newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_int16((java.lang.Short)oldValue, (java.lang.Short)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, java.lang.Short.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_uint32_(java.util.List<java.lang.Integer> oldValue, java.util.List<java.lang.Integer> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_uint32(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_int64(java.lang.Long oldValue, java.lang.Long newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_byte(java.lang.Byte oldValue, java.lang.Byte newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }


    public com.fasterxml.jackson.databind.JsonNode write_nullable_double_(java.lang.Double oldValue, java.lang.Double newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_double(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___(java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>> oldValue, java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_boolean(java.lang.Boolean oldValue, java.lang.Boolean newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.booleanNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_uint64_(java.lang.Long oldValue, java.lang.Long newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_uint64(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_uint16_(java.lang.Short oldValue, java.lang.Short newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_uint16(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_string_(java.util.List<java.lang.String> oldValue, java.util.List<java.lang.String> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_string(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_int16(java.lang.Short oldValue, java.lang.Short newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_int64_(java.util.List<java.lang.Long> oldValue, java.util.List<java.lang.Long> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_int64(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_reference_uint32_(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_uint32((java.lang.Integer)oldValue, (java.lang.Integer)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, java.lang.Integer.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_array_uint32__(java.util.List<java.util.List<java.lang.Integer>> oldValue, java.util.List<java.util.List<java.lang.Integer>> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_array_uint32_(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_((com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum)oldValue, (com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_double(java.lang.Double oldValue, java.lang.Double newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_uint32_(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_uint32(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_int16_(java.util.List<java.lang.Short> oldValue, java.util.List<java.lang.Short> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_int16(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_reference_binary_(byte[] oldValue, byte[] newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_binary((byte[])oldValue, (byte[])newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, byte[].class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }


    public com.fasterxml.jackson.databind.JsonNode write_array_int32_(java.util.List<java.lang.Integer> oldValue, java.util.List<java.lang.Integer> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_int32(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_double_(java.util.List<java.lang.Double> oldValue, java.util.List<java.lang.Double> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_double(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_uint64_(java.util.List<java.lang.Long> oldValue, java.util.List<java.lang.Long> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_uint64(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_reference_string_(java.lang.String oldValue, java.lang.String newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_string((java.lang.String)oldValue, (java.lang.String)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, java.lang.String.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_array_uint16__(java.util.List<java.lang.Short> oldValue, java.util.List<java.lang.Short> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_array_uint16_(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_reference_boolean_(java.lang.Boolean oldValue, java.lang.Boolean newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_boolean((java.lang.Boolean)oldValue, (java.lang.Boolean)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, java.lang.Boolean.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_array_int64__(java.util.List<java.lang.Long> oldValue, java.util.List<java.lang.Long> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_array_int64_(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_binary(byte[] oldValue, byte[] newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.binaryNode(newValue);
    }


    public com.fasterxml.jackson.databind.JsonNode write_nullable_byte_(java.lang.Byte oldValue, java.lang.Byte newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_byte(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_int64_(java.lang.Long oldValue, java.lang.Long newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_int64(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_reference_int64_(java.lang.Long oldValue, java.lang.Long newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_int64((java.lang.Long)oldValue, (java.lang.Long)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, java.lang.Long.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_uint32(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_float_(java.lang.Float oldValue, java.lang.Float newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_float(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___(java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>> oldValue, java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_array_int32__(java.util.List<java.util.List<java.lang.Integer>> oldValue, java.util.List<java.util.List<java.lang.Integer>> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_array_int32_(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_array_uint64__(java.util.List<java.lang.Long> oldValue, java.util.List<java.lang.Long> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_array_uint64_(oldValue, newValue);
        }
    }


    public com.fasterxml.jackson.databind.JsonNode write_nullable_string_(java.lang.String oldValue, java.lang.String newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_string(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_array_float__(java.util.List<java.lang.Float> oldValue, java.util.List<java.lang.Float> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_array_float_(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_array_double__(java.util.List<java.util.List<java.lang.Double>> oldValue, java.util.List<java.util.List<java.lang.Double>> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_array_double_(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_reference_float_(java.lang.Float oldValue, java.lang.Float newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_float((java.lang.Float)oldValue, (java.lang.Float)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, java.lang.Float.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_array_uint32__(java.util.List<java.lang.Integer> oldValue, java.util.List<java.lang.Integer> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_array_uint32_(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_binary_(byte[] oldValue, byte[] newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_binary(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___(java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> oldValue, java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_boolean_(java.lang.Boolean oldValue, java.lang.Boolean newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_boolean(oldValue, newValue);
        }
    }


    public com.fasterxml.jackson.databind.JsonNode write_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum oldValue, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        else
            return write_string(oldValue.toString(), newValue.toString());
    }

    public com.fasterxml.jackson.databind.JsonNode write_uint64(java.lang.Long oldValue, java.lang.Long newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_uint16_(java.util.List<java.lang.Short> oldValue, java.util.List<java.lang.Short> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_uint16(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_int32(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_array_string__(java.util.List<java.lang.String> oldValue, java.util.List<java.lang.String> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_array_string_(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_array_int32__(java.util.List<java.lang.Integer> oldValue, java.util.List<java.lang.Integer> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_array_int32_(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_reference_double_(java.lang.Double oldValue, java.lang.Double newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_double((java.lang.Double)oldValue, (java.lang.Double)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, java.lang.Double.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_float_(java.util.List<java.lang.Float> oldValue, java.util.List<java.lang.Float> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_float(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_reference_int32_(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_int32((java.lang.Integer)oldValue, (java.lang.Integer)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, java.lang.Integer.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_string(java.lang.String oldValue, java.lang.String newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.textNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_array_float__(java.util.List<java.util.List<java.lang.Float>> oldValue, java.util.List<java.util.List<java.lang.Float>> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_array_float_(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_reference_uint64_(java.lang.Long oldValue, java.lang.Long newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_uint64((java.lang.Long)oldValue, (java.lang.Long)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, java.lang.Long.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_array_int64__(java.util.List<java.util.List<java.lang.Long>> oldValue, java.util.List<java.util.List<java.lang.Long>> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_array_int64_(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }


    public com.fasterxml.jackson.databind.JsonNode write_nullable_array_double__(java.util.List<java.lang.Double> oldValue, java.util.List<java.lang.Double> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_array_double_(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_array_uint64__(java.util.List<java.util.List<java.lang.Long>> oldValue, java.util.List<java.util.List<java.lang.Long>> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_array_uint64_(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }


    public com.fasterxml.jackson.databind.JsonNode write_nullable_array_byte__(java.util.List<java.lang.Byte> oldValue, java.util.List<java.lang.Byte> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_array_byte_(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_array_int16__(java.util.List<java.lang.Short> oldValue, java.util.List<java.lang.Short> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_array_int16_(oldValue, newValue);
        }
    }


    private static <T> T get(java.util.List<T> v, int i) {
        return v.get(i);
    }
    
    private static <T> T get(T[] v, int i) {
        return v[i];
    }
    
    private static byte get(byte[] v, int i) {
        return v[i];
    }
    private static short get(short[] v, int i) {
        return v[i];
    }
    private static int get(int[] v, int i) {
        return v[i];
    }
    private static long get(long[] v, int i) {
        return v[i];
    }
    private static float get(float[] v, int i) {
        return v[i];
    }
    private static double get(double[] v, int i) {
        return v[i];
    }
    private static boolean get(boolean[] v, int i) {
        return v[i];
    }

    private static <T> int size(java.util.List<T> v) {
        return v.size();
    }

    private static <T> int size(T[] v) {
        return v.length;
    }
    private static int size(byte[] v) {
        return v.length;
    }
    private static int size(short[] v) {
        return v.length;
    }
    private static int size(int[] v) {
        return v.length;
    }
    private static int size(long[] v) {
        return v.length;
    }
    private static int size(float[] v) {
        return v.length;
    }
    private static int size(double[] v) {
        return v.length;
    }
    private static int size(boolean[] v) {
        return v.length;
    }
    }

class TeslaJsonChangeReader_teslacompiler_all_types_v1_0 extends Serializer.ChangeReader {


    public static final long SCHEMA_HASH = 7810441853185379917L;
    private static final com.fasterxml.jackson.databind.ObjectMapper JSON_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private com.fasterxml.jackson.databind.JsonNode root;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    TeslaJsonChangeReader_teslacompiler_all_types_v1_0(java.io.InputStream stream) throws java.io.IOException {
        root = JSON_MAPPER.readTree(stream);
    }
 





    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("OptionalObjectArrayField");
        if(vn != null) {
            v.setOptionalObjectArrayField(read_nullable_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___(v.getOptionalObjectArrayField(), vn));
        }
        vn = jn.get("OptionalEnumArrayField");
        if(vn != null) {
            v.setOptionalEnumArrayField(read_nullable_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___(v.getOptionalEnumArrayField(), vn));
        }
        vn = jn.get("OptionalBoolArrayField");
        if(vn != null) {
            v.setOptionalBoolArrayField(read_nullable_array_boolean__(v.getOptionalBoolArrayField(), vn));
        }
        vn = jn.get("OptionalByteArrayField");
        if(vn != null) {
            v.setOptionalByteArrayField(read_nullable_array_byte__(v.getOptionalByteArrayField(), vn));
        }
        vn = jn.get("OptionalInt16ArrayField");
        if(vn != null) {
            v.setOptionalInt16ArrayField(read_nullable_array_int16__(v.getOptionalInt16ArrayField(), vn));
        }
        vn = jn.get("OptionalUInt16ArrayField");
        if(vn != null) {
            v.setOptionalUInt16ArrayField(read_nullable_array_uint16__(v.getOptionalUInt16ArrayField(), vn));
        }
        vn = jn.get("OptionalInt32ArrayField");
        if(vn != null) {
            v.setOptionalInt32ArrayField(read_nullable_array_int32__(v.getOptionalInt32ArrayField(), vn));
        }
        vn = jn.get("OptionalUInt32ArrayField");
        if(vn != null) {
            v.setOptionalUInt32ArrayField(read_nullable_array_uint32__(v.getOptionalUInt32ArrayField(), vn));
        }
        vn = jn.get("OptionalInt64ArrayField");
        if(vn != null) {
            v.setOptionalInt64ArrayField(read_nullable_array_int64__(v.getOptionalInt64ArrayField(), vn));
        }
        vn = jn.get("OptionalUInt64ArrayField");
        if(vn != null) {
            v.setOptionalUInt64ArrayField(read_nullable_array_uint64__(v.getOptionalUInt64ArrayField(), vn));
        }
        vn = jn.get("OptionalFloatArrayField");
        if(vn != null) {
            v.setOptionalFloatArrayField(read_nullable_array_float__(v.getOptionalFloatArrayField(), vn));
        }
        vn = jn.get("OptionalDoubleArrayField");
        if(vn != null) {
            v.setOptionalDoubleArrayField(read_nullable_array_double__(v.getOptionalDoubleArrayField(), vn));
        }
        vn = jn.get("OptionalStringArrayField");
        if(vn != null) {
            v.setOptionalStringArrayField(read_nullable_array_string__(v.getOptionalStringArrayField(), vn));
        }
        return v;
    }


















    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("IntField");
        if(vn != null) {
            v.setIntField(read_int32(v.getIntField(), vn));
        }
        return v;
    }

















    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("Object2DArrayField");
        if(vn != null) {
            v.setObject2DArrayField(read_array_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___(v.getObject2DArrayField(), vn));
        }
        vn = jn.get("Enum2DArrayField");
        if(vn != null) {
            v.setEnum2DArrayField(read_array_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___(v.getEnum2DArrayField(), vn));
        }
        vn = jn.get("Bool2DArrayField");
        if(vn != null) {
            v.setBool2DArrayField(read_array_array_boolean__(v.getBool2DArrayField(), vn));
        }
        vn = jn.get("Byte2DArrayField");
        if(vn != null) {
            v.setByte2DArrayField(read_array_array_byte__(v.getByte2DArrayField(), vn));
        }
        vn = jn.get("Int162DArrayField");
        if(vn != null) {
            v.setInt162DArrayField(read_array_array_int16__(v.getInt162DArrayField(), vn));
        }
        vn = jn.get("UInt162DArrayField");
        if(vn != null) {
            v.setUInt162DArrayField(read_array_array_uint16__(v.getUInt162DArrayField(), vn));
        }
        vn = jn.get("Int322DArrayField");
        if(vn != null) {
            v.setInt322DArrayField(read_array_array_int32__(v.getInt322DArrayField(), vn));
        }
        vn = jn.get("UInt322DArrayField");
        if(vn != null) {
            v.setUInt322DArrayField(read_array_array_uint32__(v.getUInt322DArrayField(), vn));
        }
        vn = jn.get("Int642DArrayField");
        if(vn != null) {
            v.setInt642DArrayField(read_array_array_int64__(v.getInt642DArrayField(), vn));
        }
        vn = jn.get("UInt642DArrayField");
        if(vn != null) {
            v.setUInt642DArrayField(read_array_array_uint64__(v.getUInt642DArrayField(), vn));
        }
        vn = jn.get("Float2DArrayField");
        if(vn != null) {
            v.setFloat2DArrayField(read_array_array_float__(v.getFloat2DArrayField(), vn));
        }
        vn = jn.get("Double2DArrayField");
        if(vn != null) {
            v.setDouble2DArrayField(read_array_array_double__(v.getDouble2DArrayField(), vn));
        }
        vn = jn.get("String2DArrayField");
        if(vn != null) {
            v.setString2DArrayField(read_array_array_string__(v.getString2DArrayField(), vn));
        }
        return v;
    }









    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("OptionalObjectField");
        if(vn != null) {
            v.setOptionalObjectField(read_nullable_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(v.getOptionalObjectField(), vn));
        }
        vn = jn.get("OptionalEnumField");
        if(vn != null) {
            v.setOptionalEnumField(read_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(v.getOptionalEnumField(), vn));
        }
        vn = jn.get("OptionalBoolField");
        if(vn != null) {
            v.setOptionalBoolField(read_nullable_boolean_(v.getOptionalBoolField(), vn));
        }
        vn = jn.get("OptionalByteField");
        if(vn != null) {
            v.setOptionalByteField(read_nullable_byte_(v.getOptionalByteField(), vn));
        }
        vn = jn.get("OptionalInt16Field");
        if(vn != null) {
            v.setOptionalInt16Field(read_nullable_int16_(v.getOptionalInt16Field(), vn));
        }
        vn = jn.get("OptionalUInt16Field");
        if(vn != null) {
            v.setOptionalUInt16Field(read_nullable_uint16_(v.getOptionalUInt16Field(), vn));
        }
        vn = jn.get("OptionalInt32Field");
        if(vn != null) {
            v.setOptionalInt32Field(read_nullable_int32_(v.getOptionalInt32Field(), vn));
        }
        vn = jn.get("OptionalUInt32Field");
        if(vn != null) {
            v.setOptionalUInt32Field(read_nullable_uint32_(v.getOptionalUInt32Field(), vn));
        }
        vn = jn.get("OptionalInt64Field");
        if(vn != null) {
            v.setOptionalInt64Field(read_nullable_int64_(v.getOptionalInt64Field(), vn));
        }
        vn = jn.get("OptionalUInt64Field");
        if(vn != null) {
            v.setOptionalUInt64Field(read_nullable_uint64_(v.getOptionalUInt64Field(), vn));
        }
        vn = jn.get("OptionalFloatField");
        if(vn != null) {
            v.setOptionalFloatField(read_nullable_float_(v.getOptionalFloatField(), vn));
        }
        vn = jn.get("OptionalDoubleField");
        if(vn != null) {
            v.setOptionalDoubleField(read_nullable_double_(v.getOptionalDoubleField(), vn));
        }
        vn = jn.get("OptionalBinaryField");
        if(vn != null) {
            v.setOptionalBinaryField(read_nullable_binary_(v.getOptionalBinaryField(), vn));
        }
        vn = jn.get("OptionalStringField");
        if(vn != null) {
            v.setOptionalStringField(read_nullable_string_(v.getOptionalStringField(), vn));
        }
        return v;
    }









    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("ObjectArrayField");
        if(vn != null) {
            v.setObjectArrayField(read_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(v.getObjectArrayField(), vn));
        }
        vn = jn.get("EnumArrayField");
        if(vn != null) {
            v.setEnumArrayField(read_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(v.getEnumArrayField(), vn));
        }
        vn = jn.get("BoolArrayField");
        if(vn != null) {
            v.setBoolArrayField(read_array_boolean_(v.getBoolArrayField(), vn));
        }
        vn = jn.get("ByteArrayField");
        if(vn != null) {
            v.setByteArrayField(read_array_byte_(v.getByteArrayField(), vn));
        }
        vn = jn.get("Int16ArrayField");
        if(vn != null) {
            v.setInt16ArrayField(read_array_int16_(v.getInt16ArrayField(), vn));
        }
        vn = jn.get("UInt16ArrayField");
        if(vn != null) {
            v.setUInt16ArrayField(read_array_uint16_(v.getUInt16ArrayField(), vn));
        }
        vn = jn.get("Int32ArrayField");
        if(vn != null) {
            v.setInt32ArrayField(read_array_int32_(v.getInt32ArrayField(), vn));
        }
        vn = jn.get("UInt32ArrayField");
        if(vn != null) {
            v.setUInt32ArrayField(read_array_uint32_(v.getUInt32ArrayField(), vn));
        }
        vn = jn.get("Int64ArrayField");
        if(vn != null) {
            v.setInt64ArrayField(read_array_int64_(v.getInt64ArrayField(), vn));
        }
        vn = jn.get("UInt64ArrayField");
        if(vn != null) {
            v.setUInt64ArrayField(read_array_uint64_(v.getUInt64ArrayField(), vn));
        }
        vn = jn.get("FloatArrayField");
        if(vn != null) {
            v.setFloatArrayField(read_array_float_(v.getFloatArrayField(), vn));
        }
        vn = jn.get("DoubleArrayField");
        if(vn != null) {
            v.setDoubleArrayField(read_array_double_(v.getDoubleArrayField(), vn));
        }
        vn = jn.get("StringArrayField");
        if(vn != null) {
            v.setStringArrayField(read_array_string_(v.getStringArrayField(), vn));
        }
        return v;
    }










    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("ObjectField");
        if(vn != null) {
            v.setObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(v.getObjectField(), vn));
        }
        vn = jn.get("EnumField");
        if(vn != null) {
            v.setEnumField(read_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(v.getEnumField(), vn));
        }
        vn = jn.get("BoolField");
        if(vn != null) {
            v.setBoolField(read_boolean(v.getBoolField(), vn));
        }
        vn = jn.get("ByteField");
        if(vn != null) {
            v.setByteField(read_byte(v.getByteField(), vn));
        }
        vn = jn.get("Int16Field");
        if(vn != null) {
            v.setInt16Field(read_int16(v.getInt16Field(), vn));
        }
        vn = jn.get("UInt16Field");
        if(vn != null) {
            v.setUInt16Field(read_uint16(v.getUInt16Field(), vn));
        }
        vn = jn.get("Int32Field");
        if(vn != null) {
            v.setInt32Field(read_int32(v.getInt32Field(), vn));
        }
        vn = jn.get("UInt32Field");
        if(vn != null) {
            v.setUInt32Field(read_uint32(v.getUInt32Field(), vn));
        }
        vn = jn.get("Int64Field");
        if(vn != null) {
            v.setInt64Field(read_int64(v.getInt64Field(), vn));
        }
        vn = jn.get("UInt64Field");
        if(vn != null) {
            v.setUInt64Field(read_uint64(v.getUInt64Field(), vn));
        }
        vn = jn.get("FloatField");
        if(vn != null) {
            v.setFloatField(read_float(v.getFloatField(), vn));
        }
        vn = jn.get("DoubleField");
        if(vn != null) {
            v.setDoubleField(read_double(v.getDoubleField(), vn));
        }
        vn = jn.get("BinaryField");
        if(vn != null) {
            v.setBinaryField(read_binary(v.getBinaryField(), vn));
        }
        vn = jn.get("StringField");
        if(vn != null) {
            v.setStringField(read_string(v.getStringField(), vn));
        }
        return v;
    }














    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("ObjectReferenceField");
        if(vn != null) {
            v.setObjectReferenceField(read_reference_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(v.getObjectReferenceField(), vn));
        }
        vn = jn.get("EnumReferenceField");
        if(vn != null) {
            v.setEnumReferenceField(read_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(v.getEnumReferenceField(), vn));
        }
        vn = jn.get("BoolReferenceField");
        if(vn != null) {
            v.setBoolReferenceField(read_reference_boolean_(v.getBoolReferenceField(), vn));
        }
        vn = jn.get("ByteReferenceField");
        if(vn != null) {
            v.setByteReferenceField(read_reference_byte_(v.getByteReferenceField(), vn));
        }
        vn = jn.get("Int16ReferenceField");
        if(vn != null) {
            v.setInt16ReferenceField(read_reference_int16_(v.getInt16ReferenceField(), vn));
        }
        vn = jn.get("UInt16ReferenceField");
        if(vn != null) {
            v.setUInt16ReferenceField(read_reference_uint16_(v.getUInt16ReferenceField(), vn));
        }
        vn = jn.get("Int32ReferenceField");
        if(vn != null) {
            v.setInt32ReferenceField(read_reference_int32_(v.getInt32ReferenceField(), vn));
        }
        vn = jn.get("UInt32ReferenceField");
        if(vn != null) {
            v.setUInt32ReferenceField(read_reference_uint32_(v.getUInt32ReferenceField(), vn));
        }
        vn = jn.get("Int64ReferenceField");
        if(vn != null) {
            v.setInt64ReferenceField(read_reference_int64_(v.getInt64ReferenceField(), vn));
        }
        vn = jn.get("UInt64ReferenceField");
        if(vn != null) {
            v.setUInt64ReferenceField(read_reference_uint64_(v.getUInt64ReferenceField(), vn));
        }
        vn = jn.get("FloatReferenceField");
        if(vn != null) {
            v.setFloatReferenceField(read_reference_float_(v.getFloatReferenceField(), vn));
        }
        vn = jn.get("DoubleReferenceField");
        if(vn != null) {
            v.setDoubleReferenceField(read_reference_double_(v.getDoubleReferenceField(), vn));
        }
        vn = jn.get("BinaryReferenceField");
        if(vn != null) {
            v.setBinaryReferenceField(read_reference_binary_(v.getBinaryReferenceField(), vn));
        }
        vn = jn.get("StringReferenceField");
        if(vn != null) {
            v.setStringReferenceField(read_reference_string_(v.getStringReferenceField(), vn));
        }
        return v;
    }



    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject read(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestObject_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestObject_(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestObject v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("BasicTestObjectField");
        if(vn != null) {
            v.setBasicTestObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_BasicTestObject_(v.getBasicTestObjectField(), vn));
        }
        vn = jn.get("ReferenceTestObjectField");
        if(vn != null) {
            v.setReferenceTestObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ReferenceTestObject_(v.getReferenceTestObjectField(), vn));
        }
        vn = jn.get("OptionalBasicTestObjectField");
        if(vn != null) {
            v.setOptionalBasicTestObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalBasicTestObject_(v.getOptionalBasicTestObjectField(), vn));
        }
        vn = jn.get("ArrayTestObjectField");
        if(vn != null) {
            v.setArrayTestObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_ArrayTestObject_(v.getArrayTestObjectField(), vn));
        }
        vn = jn.get("Array2DTestObjectField");
        if(vn != null) {
            v.setArray2DTestObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_Array2DTestObject_(v.getArray2DTestObjectField(), vn));
        }
        vn = jn.get("OptionalArrayTestObjectField");
        if(vn != null) {
            v.setOptionalArrayTestObjectField(read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_OptionalArrayTestObject_(v.getOptionalArrayTestObjectField(), vn));
        }
        return v;
    }




    public java.util.List<java.util.List<java.lang.Short>> read_array_array_uint16__(java.util.List<java.util.List<java.lang.Short>> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.util.List<java.lang.Short>> nv = new java.util.TreeMap<Integer, java.util.List<java.lang.Short>>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_array_uint16_(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public java.util.List<java.util.List<java.lang.Boolean>> read_array_array_boolean__(java.util.List<java.util.List<java.lang.Boolean>> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.util.List<java.lang.Boolean>> nv = new java.util.TreeMap<Integer, java.util.List<java.lang.Boolean>>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_array_boolean_(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> read_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> nv = new java.util.TreeMap<Integer, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public java.lang.Byte read_reference_byte_(java.lang.Byte v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Byte.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            byte value = read_byte(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, java.lang.Byte.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> read_nullable_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___(java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(v, jn);
        }
    }


    public java.lang.Short read_nullable_int16_(java.lang.Short v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_int16(v, jn);
        }
    }

    public java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> read_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> nv = new java.util.TreeMap<Integer, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public java.util.List<java.lang.Byte> read_array_byte_(java.util.List<java.lang.Byte> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.lang.Byte> nv = new java.util.TreeMap<Integer, java.lang.Byte>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_byte(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public java.lang.Integer read_nullable_int32_(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_int32(v, jn);
        }
    }

    public java.util.List<java.lang.Boolean> read_nullable_array_boolean__(java.util.List<java.lang.Boolean> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_array_boolean_(v, jn);
        }
    }

    public java.util.List<java.util.List<java.lang.Short>> read_array_array_int16__(java.util.List<java.util.List<java.lang.Short>> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.util.List<java.lang.Short>> nv = new java.util.TreeMap<Integer, java.util.List<java.lang.Short>>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_array_int16_(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public float read_float(java.lang.Float v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (float)jn.doubleValue();
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject read_reference_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject value = read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.util.List<java.lang.String>> read_array_array_string__(java.util.List<java.util.List<java.lang.String>> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.util.List<java.lang.String>> nv = new java.util.TreeMap<Integer, java.util.List<java.lang.String>>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_array_string_(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public java.util.List<java.lang.Boolean> read_array_boolean_(java.util.List<java.lang.Boolean> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.lang.Boolean> nv = new java.util.TreeMap<Integer, java.lang.Boolean>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_boolean(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public java.util.List<java.util.List<java.lang.Byte>> read_array_array_byte__(java.util.List<java.util.List<java.lang.Byte>> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.util.List<java.lang.Byte>> nv = new java.util.TreeMap<Integer, java.util.List<java.lang.Byte>>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_array_byte_(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public short read_uint16(java.lang.Short v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (short)jn.intValue();
    }

    public java.lang.Short read_reference_uint16_(java.lang.Short v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Short.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            short value = read_uint16(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, java.lang.Short.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.lang.Short read_reference_int16_(java.lang.Short v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Short.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            short value = read_int16(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, java.lang.Short.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.lang.Integer> read_array_uint32_(java.util.List<java.lang.Integer> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.lang.Integer> nv = new java.util.TreeMap<Integer, java.lang.Integer>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_uint32(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public long read_int64(java.lang.Long v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.longValue();
    }

    public byte read_byte(java.lang.Byte v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (byte)jn.intValue();
    }


    public java.lang.Double read_nullable_double_(java.lang.Double v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_double(v, jn);
        }
    }

    public java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>> read_array_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject___(java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>> nv = new java.util.TreeMap<Integer, java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_array_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public boolean read_boolean(java.lang.Boolean v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.booleanValue();
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum read_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(v, jn);
        }
    }

    public java.lang.Long read_nullable_uint64_(java.lang.Long v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_uint64(v, jn);
        }
    }

    public java.lang.Short read_nullable_uint16_(java.lang.Short v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_uint16(v, jn);
        }
    }

    public java.util.List<java.lang.String> read_array_string_(java.util.List<java.lang.String> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.lang.String> nv = new java.util.TreeMap<Integer, java.lang.String>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_string(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public short read_int16(java.lang.Short v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (short)jn.intValue();
    }

    public java.util.List<java.lang.Long> read_array_int64_(java.util.List<java.lang.Long> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.lang.Long> nv = new java.util.TreeMap<Integer, java.lang.Long>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_int64(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public java.lang.Integer read_reference_uint32_(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Integer.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            int value = read_uint32(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, java.lang.Integer.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.util.List<java.lang.Integer>> read_array_array_uint32__(java.util.List<java.util.List<java.lang.Integer>> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.util.List<java.lang.Integer>> nv = new java.util.TreeMap<Integer, java.util.List<java.lang.Integer>>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_array_uint32_(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum read_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum value = read_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public double read_double(java.lang.Double v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.doubleValue();
    }

    public java.lang.Integer read_nullable_uint32_(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_uint32(v, jn);
        }
    }

    public java.util.List<java.lang.Short> read_array_int16_(java.util.List<java.lang.Short> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.lang.Short> nv = new java.util.TreeMap<Integer, java.lang.Short>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_int16(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public byte[] read_reference_binary_(byte[] v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, byte[].class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            byte[] value = read_binary(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, byte[].class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }


    public java.util.List<java.lang.Integer> read_array_int32_(java.util.List<java.lang.Integer> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.lang.Integer> nv = new java.util.TreeMap<Integer, java.lang.Integer>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_int32(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public java.util.List<java.lang.Double> read_array_double_(java.util.List<java.lang.Double> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.lang.Double> nv = new java.util.TreeMap<Integer, java.lang.Double>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_double(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public java.util.List<java.lang.Long> read_array_uint64_(java.util.List<java.lang.Long> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.lang.Long> nv = new java.util.TreeMap<Integer, java.lang.Long>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_uint64(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public java.lang.String read_reference_string_(java.lang.String v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.String.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            java.lang.String value = read_string(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, java.lang.String.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.lang.Short> read_nullable_array_uint16__(java.util.List<java.lang.Short> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_array_uint16_(v, jn);
        }
    }

    public java.lang.Boolean read_reference_boolean_(java.lang.Boolean v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Boolean.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            boolean value = read_boolean(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, java.lang.Boolean.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.lang.Long> read_nullable_array_int64__(java.util.List<java.lang.Long> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_array_int64_(v, jn);
        }
    }

    public byte[] read_binary(byte[] v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.binaryValue();
    }


    public java.lang.Byte read_nullable_byte_(java.lang.Byte v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_byte(v, jn);
        }
    }

    public java.lang.Long read_nullable_int64_(java.lang.Long v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_int64(v, jn);
        }
    }

    public java.lang.Long read_reference_int64_(java.lang.Long v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Long.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            long value = read_int64(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, java.lang.Long.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public int read_uint32(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (int)jn.longValue();
    }

    public java.lang.Float read_nullable_float_(java.lang.Float v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_float(v, jn);
        }
    }

    public java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>> read_array_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___(java.util.List<java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>> nv = new java.util.TreeMap<Integer, java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public java.util.List<java.util.List<java.lang.Integer>> read_array_array_int32__(java.util.List<java.util.List<java.lang.Integer>> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.util.List<java.lang.Integer>> nv = new java.util.TreeMap<Integer, java.util.List<java.lang.Integer>>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_array_int32_(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public java.util.List<java.lang.Long> read_nullable_array_uint64__(java.util.List<java.lang.Long> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_array_uint64_(v, jn);
        }
    }


    public java.lang.String read_nullable_string_(java.lang.String v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_string(v, jn);
        }
    }

    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject read_nullable_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject__(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_class_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEmbeddedObject_(v, jn);
        }
    }

    public java.util.List<java.lang.Float> read_nullable_array_float__(java.util.List<java.lang.Float> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_array_float_(v, jn);
        }
    }

    public java.util.List<java.util.List<java.lang.Double>> read_array_array_double__(java.util.List<java.util.List<java.lang.Double>> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.util.List<java.lang.Double>> nv = new java.util.TreeMap<Integer, java.util.List<java.lang.Double>>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_array_double_(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public java.lang.Float read_reference_float_(java.lang.Float v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Float.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            float value = read_float(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, java.lang.Float.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.lang.Integer> read_nullable_array_uint32__(java.util.List<java.lang.Integer> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_array_uint32_(v, jn);
        }
    }

    public byte[] read_nullable_binary_(byte[] v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_binary(v, jn);
        }
    }

    public java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> read_nullable_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum___(java.util.List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_array_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum__(v, jn);
        }
    }

    public java.lang.Boolean read_nullable_boolean_(java.lang.Boolean v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_boolean(v, jn);
        }
    }


    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum read_enum_com_expedia_tesla_compiler_test_passcompile_full_all_types_TestEnum_(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        java.lang.String value = jn.textValue();
        if (value.equals("Info")) {
            return com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum.Info;
        }
        if (value.equals("Warning")) {
            return com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum.Warning;
        }
        if (value.equals("Error")) {
            return com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum.Error;
        }
        throw new java.io.IOException(String.format(
            "Invalid Enum value '%s' encountered when reading type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>'", 
            value));
    }

    public long read_uint64(java.lang.Long v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.longValue();
    }

    public java.util.List<java.lang.Short> read_array_uint16_(java.util.List<java.lang.Short> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.lang.Short> nv = new java.util.TreeMap<Integer, java.lang.Short>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_uint16(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public int read_int32(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.intValue();
    }

    public java.util.List<java.lang.String> read_nullable_array_string__(java.util.List<java.lang.String> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_array_string_(v, jn);
        }
    }

    public java.util.List<java.lang.Integer> read_nullable_array_int32__(java.util.List<java.lang.Integer> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_array_int32_(v, jn);
        }
    }

    public java.lang.Double read_reference_double_(java.lang.Double v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Double.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            double value = read_double(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, java.lang.Double.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.lang.Float> read_array_float_(java.util.List<java.lang.Float> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.lang.Float> nv = new java.util.TreeMap<Integer, java.lang.Float>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_float(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public java.lang.Integer read_reference_int32_(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Integer.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            int value = read_int32(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, java.lang.Integer.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.lang.String read_string(java.lang.String v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.textValue();
    }

    public java.util.List<java.util.List<java.lang.Float>> read_array_array_float__(java.util.List<java.util.List<java.lang.Float>> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.util.List<java.lang.Float>> nv = new java.util.TreeMap<Integer, java.util.List<java.lang.Float>>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_array_float_(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public java.lang.Long read_reference_uint64_(java.lang.Long v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Long.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            long value = read_uint64(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, java.lang.Long.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.util.List<java.lang.Long>> read_array_array_int64__(java.util.List<java.util.List<java.lang.Long>> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.util.List<java.lang.Long>> nv = new java.util.TreeMap<Integer, java.util.List<java.lang.Long>>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_array_int64_(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }


    public java.util.List<java.lang.Double> read_nullable_array_double__(java.util.List<java.lang.Double> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_array_double_(v, jn);
        }
    }

    public java.util.List<java.util.List<java.lang.Long>> read_array_array_uint64__(java.util.List<java.util.List<java.lang.Long>> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.util.List<java.lang.Long>> nv = new java.util.TreeMap<Integer, java.util.List<java.lang.Long>>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_array_uint64_(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }


    public java.util.List<java.lang.Byte> read_nullable_array_byte__(java.util.List<java.lang.Byte> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_array_byte_(v, jn);
        }
    }

    public java.util.List<java.lang.Short> read_nullable_array_int16__(java.util.List<java.lang.Short> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_array_int16_(v, jn);
        }
    }


}


class TeslaJsonChangeWriter_compiler_test_passcompile_full_complexttypetest extends Serializer.ChangeWriter {


    public static final long SCHEMA_HASH = -5586303099293846137L;
    private static final com.fasterxml.jackson.databind.ObjectMapper OBJECT_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private static final com.fasterxml.jackson.databind.node.JsonNodeFactory NODE_FACTORY = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    private java.io.OutputStream stream;
    
    TeslaJsonChangeWriter_compiler_test_passcompile_full_complexttypetest(java.io.OutputStream stream) throws java.io.IOException {
        this.stream = stream;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.complexttypetest oldValue, com.expedia.tesla.compiler.test.passcompile.full.complexttypetest newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_complexttypetest_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_complexttypetest_(com.expedia.tesla.compiler.test.passcompile.full.complexttypetest oldValue, com.expedia.tesla.compiler.test.passcompile.full.complexttypetest newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_array_reference_string__(oldValue.getField1(), newValue.getField1())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("field1", ejn);
        }
        if ((ejn = write_array_array_reference_string___(oldValue.getField2(), newValue.getField2())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("field2", ejn);
        }
        if ((ejn = write_array_array_array_reference_string____(oldValue.getField3(), newValue.getField3())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("field3", ejn);
        }
        if ((ejn = write_reference_array_string__(oldValue.getField4(), newValue.getField4())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("field4", ejn);
        }
        if ((ejn = write_reference_array_reference_string___(oldValue.getField5(), newValue.getField5())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("field5", ejn);
        }
        return jn;
    }


    public com.fasterxml.jackson.databind.JsonNode write_int32(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_reference_string__(java.util.List<java.lang.String> oldValue, java.util.List<java.lang.String> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_reference_string_(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_string_(java.util.List<java.lang.String> oldValue, java.util.List<java.lang.String> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_string(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_string(java.lang.String oldValue, java.lang.String newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.textNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_reference_string_(java.lang.String oldValue, java.lang.String newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_string((java.lang.String)oldValue, (java.lang.String)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, java.lang.String.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_uint32(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_boolean(java.lang.Boolean oldValue, java.lang.Boolean newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.booleanNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_array_array_reference_string____(java.util.List<java.util.List<java.util.List<java.lang.String>>> oldValue, java.util.List<java.util.List<java.util.List<java.lang.String>>> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_array_array_reference_string___(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_reference_array_reference_string___(java.util.List<java.lang.String> oldValue, java.util.List<java.lang.String> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_array_reference_string__((java.util.List<java.lang.String>)oldValue, (java.util.List<java.lang.String>)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, java.util.ArrayList.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }


    public com.fasterxml.jackson.databind.JsonNode write_reference_array_string__(java.util.List<java.lang.String> oldValue, java.util.List<java.lang.String> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_array_string_((java.util.List<java.lang.String>)oldValue, (java.util.List<java.lang.String>)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, java.util.ArrayList.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_array_reference_string___(java.util.List<java.util.List<java.lang.String>> oldValue, java.util.List<java.util.List<java.lang.String>> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_array_reference_string__(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }


    private static <T> T get(java.util.List<T> v, int i) {
        return v.get(i);
    }
    
    private static <T> T get(T[] v, int i) {
        return v[i];
    }
    
    private static byte get(byte[] v, int i) {
        return v[i];
    }
    private static short get(short[] v, int i) {
        return v[i];
    }
    private static int get(int[] v, int i) {
        return v[i];
    }
    private static long get(long[] v, int i) {
        return v[i];
    }
    private static float get(float[] v, int i) {
        return v[i];
    }
    private static double get(double[] v, int i) {
        return v[i];
    }
    private static boolean get(boolean[] v, int i) {
        return v[i];
    }

    private static <T> int size(java.util.List<T> v) {
        return v.size();
    }

    private static <T> int size(T[] v) {
        return v.length;
    }
    private static int size(byte[] v) {
        return v.length;
    }
    private static int size(short[] v) {
        return v.length;
    }
    private static int size(int[] v) {
        return v.length;
    }
    private static int size(long[] v) {
        return v.length;
    }
    private static int size(float[] v) {
        return v.length;
    }
    private static int size(double[] v) {
        return v.length;
    }
    private static int size(boolean[] v) {
        return v.length;
    }
    }

class TeslaJsonChangeReader_compiler_test_passcompile_full_complexttypetest extends Serializer.ChangeReader {


    public static final long SCHEMA_HASH = -5586303099293846137L;
    private static final com.fasterxml.jackson.databind.ObjectMapper JSON_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private com.fasterxml.jackson.databind.JsonNode root;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    TeslaJsonChangeReader_compiler_test_passcompile_full_complexttypetest(java.io.InputStream stream) throws java.io.IOException {
        root = JSON_MAPPER.readTree(stream);
    }
 









    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.complexttypetest read(com.expedia.tesla.compiler.test.passcompile.full.complexttypetest v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_complexttypetest_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.complexttypetest read_class_com_expedia_tesla_compiler_test_passcompile_full_complexttypetest_(com.expedia.tesla.compiler.test.passcompile.full.complexttypetest v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("field1");
        if(vn != null) {
            v.getField1(read_array_reference_string__(v.getField1(), vn));
        }
        vn = jn.get("field2");
        if(vn != null) {
            v.getField2(read_array_array_reference_string___(v.getField2(), vn));
        }
        vn = jn.get("field3");
        if(vn != null) {
            v.getField3(read_array_array_array_reference_string____(v.getField3(), vn));
        }
        vn = jn.get("field4");
        if(vn != null) {
            v.getField4(read_reference_array_string__(v.getField4(), vn));
        }
        vn = jn.get("field5");
        if(vn != null) {
            v.getField5(read_reference_array_reference_string___(v.getField5(), vn));
        }
        return v;
    }




    public int read_int32(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.intValue();
    }

    public java.util.List<java.lang.String> read_array_reference_string__(java.util.List<java.lang.String> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.lang.String> nv = new java.util.TreeMap<Integer, java.lang.String>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_reference_string_(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public java.util.List<java.lang.String> read_array_string_(java.util.List<java.lang.String> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.lang.String> nv = new java.util.TreeMap<Integer, java.lang.String>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_string(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public java.lang.String read_string(java.lang.String v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.textValue();
    }

    public java.lang.String read_reference_string_(java.lang.String v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.String.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            java.lang.String value = read_string(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, java.lang.String.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public int read_uint32(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (int)jn.longValue();
    }

    public boolean read_boolean(java.lang.Boolean v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.booleanValue();
    }

    public java.util.List<java.util.List<java.util.List<java.lang.String>>> read_array_array_array_reference_string____(java.util.List<java.util.List<java.util.List<java.lang.String>>> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.util.List<java.util.List<java.lang.String>>> nv = new java.util.TreeMap<Integer, java.util.List<java.util.List<java.lang.String>>>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_array_array_reference_string___(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public java.util.List<java.lang.String> read_reference_array_reference_string___(java.util.List<java.lang.String> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, java.util.ArrayList.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            java.util.List<java.lang.String> value = read_array_reference_string__(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, java.util.ArrayList.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }


    public java.util.List<java.lang.String> read_reference_array_string__(java.util.List<java.lang.String> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, java.util.ArrayList.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            java.util.List<java.lang.String> value = read_array_string_(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, java.util.ArrayList.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.util.List<java.lang.String>> read_array_array_reference_string___(java.util.List<java.util.List<java.lang.String>> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.util.List<java.lang.String>> nv = new java.util.TreeMap<Integer, java.util.List<java.lang.String>>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_array_reference_string__(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }


}


class TeslaJsonChangeWriter_compiler_test_passcompile_full_inheritance_v1_0 extends Serializer.ChangeWriter {


    public static final long SCHEMA_HASH = -4144946394736392407L;
    private static final com.fasterxml.jackson.databind.ObjectMapper OBJECT_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private static final com.fasterxml.jackson.databind.node.JsonNodeFactory NODE_FACTORY = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    private java.io.OutputStream stream;
    
    TeslaJsonChangeWriter_compiler_test_passcompile_full_inheritance_v1_0(java.io.OutputStream stream) throws java.io.IOException {
        this.stream = stream;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived oldValue, com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_SingleDerived_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_SingleDerived_(com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived oldValue, com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_int32(oldValue.getInt32Field(), newValue.getInt32Field())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Int32Field", ejn);
        }
        if ((ejn = write_boolean(oldValue.getBooleanField(), newValue.getBooleanField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("BooleanField", ejn);
        }
        return jn;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 oldValue, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base2_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base2_(com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 oldValue, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_int16(oldValue.getInt16Field(), newValue.getInt16Field())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Int16Field", ejn);
        }
        return jn;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 oldValue, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base1_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base1_(com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 oldValue, com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_int32(oldValue.getInt32Field(), newValue.getInt32Field())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Int32Field", ejn);
        }
        return jn;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived oldValue, com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_MultiDerived_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_MultiDerived_(com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived oldValue, com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_int32(oldValue.getInt32Field(), newValue.getInt32Field())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Int32Field", ejn);
        }
        if ((ejn = write_int16(oldValue.getInt16Field(), newValue.getInt16Field())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("Int16Field", ejn);
        }
        if ((ejn = write_byte(oldValue.getByteField(), newValue.getByteField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ByteField", ejn);
        }
        return jn;
    }


    public com.fasterxml.jackson.databind.JsonNode write_int32(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }



    public com.fasterxml.jackson.databind.JsonNode write_byte(java.lang.Byte oldValue, java.lang.Byte newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }


    public com.fasterxml.jackson.databind.JsonNode write_int16(java.lang.Short oldValue, java.lang.Short newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_string(java.lang.String oldValue, java.lang.String newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.textNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_uint32(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_boolean(java.lang.Boolean oldValue, java.lang.Boolean newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.booleanNode(newValue);
    }



    private static <T> T get(java.util.List<T> v, int i) {
        return v.get(i);
    }
    
    private static <T> T get(T[] v, int i) {
        return v[i];
    }
    
    private static byte get(byte[] v, int i) {
        return v[i];
    }
    private static short get(short[] v, int i) {
        return v[i];
    }
    private static int get(int[] v, int i) {
        return v[i];
    }
    private static long get(long[] v, int i) {
        return v[i];
    }
    private static float get(float[] v, int i) {
        return v[i];
    }
    private static double get(double[] v, int i) {
        return v[i];
    }
    private static boolean get(boolean[] v, int i) {
        return v[i];
    }

    private static <T> int size(java.util.List<T> v) {
        return v.size();
    }

    private static <T> int size(T[] v) {
        return v.length;
    }
    private static int size(byte[] v) {
        return v.length;
    }
    private static int size(short[] v) {
        return v.length;
    }
    private static int size(int[] v) {
        return v.length;
    }
    private static int size(long[] v) {
        return v.length;
    }
    private static int size(float[] v) {
        return v.length;
    }
    private static int size(double[] v) {
        return v.length;
    }
    private static int size(boolean[] v) {
        return v.length;
    }
    }

class TeslaJsonChangeReader_compiler_test_passcompile_full_inheritance_v1_0 extends Serializer.ChangeReader {


    public static final long SCHEMA_HASH = -4144946394736392407L;
    private static final com.fasterxml.jackson.databind.ObjectMapper JSON_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private com.fasterxml.jackson.databind.JsonNode root;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    TeslaJsonChangeReader_compiler_test_passcompile_full_inheritance_v1_0(java.io.InputStream stream) throws java.io.IOException {
        root = JSON_MAPPER.readTree(stream);
    }
 

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived read(com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_SingleDerived_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_SingleDerived_(com.expedia.tesla.compiler.test.passcompile.full.inheritance.SingleDerived v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("Int32Field");
        if(vn != null) {
            v.setInt32Field(read_int32(v.getInt32Field(), vn));
        }
        vn = jn.get("BooleanField");
        if(vn != null) {
            v.setBooleanField(read_boolean(v.getBooleanField(), vn));
        }
        return v;
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 read(com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base2_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base2_(com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base2 v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("Int16Field");
        if(vn != null) {
            v.setInt16Field(read_int16(v.getInt16Field(), vn));
        }
        return v;
    }


    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 read(com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base1_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_Base1_(com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("Int32Field");
        if(vn != null) {
            v.setInt32Field(read_int32(v.getInt32Field(), vn));
        }
        return v;
    }





    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived read(com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_MultiDerived_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived read_class_com_expedia_tesla_compiler_test_passcompile_full_inheritance_MultiDerived_(com.expedia.tesla.compiler.test.passcompile.full.inheritance.MultiDerived v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("Int32Field");
        if(vn != null) {
            v.setInt32Field(read_int32(v.getInt32Field(), vn));
        }
        vn = jn.get("Int16Field");
        if(vn != null) {
            v.setInt16Field(read_int16(v.getInt16Field(), vn));
        }
        vn = jn.get("ByteField");
        if(vn != null) {
            v.setByteField(read_byte(v.getByteField(), vn));
        }
        return v;
    }


    public int read_int32(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.intValue();
    }



    public byte read_byte(java.lang.Byte v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (byte)jn.intValue();
    }


    public short read_int16(java.lang.Short v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (short)jn.intValue();
    }

    public java.lang.String read_string(java.lang.String v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.textValue();
    }

    public int read_uint32(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (int)jn.longValue();
    }

    public boolean read_boolean(java.lang.Boolean v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.booleanValue();
    }



}


class TeslaJsonChangeWriter_teslacompiler_reference_test_v1_0 extends Serializer.ChangeWriter {


    public static final long SCHEMA_HASH = -8997496319200256941L;
    private static final com.fasterxml.jackson.databind.ObjectMapper OBJECT_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private static final com.fasterxml.jackson.databind.node.JsonNodeFactory NODE_FACTORY = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    private java.io.OutputStream stream;
    
    TeslaJsonChangeWriter_teslacompiler_reference_test_v1_0(java.io.OutputStream stream) throws java.io.IOException {
        this.stream = stream;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_EnumReference_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_EnumReference_(com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum__(oldValue.getReferenceField1(), newValue.getReferenceField1())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ReferenceField1", ejn);
        }
        if ((ejn = write_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum__(oldValue.getReferenceField2(), newValue.getReferenceField2())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ReferenceField2", ejn);
        }
        return jn;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_StringReference_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_StringReference_(com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_reference_string_(oldValue.getReferenceField1(), newValue.getReferenceField1())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ReferenceField1", ejn);
        }
        if ((ejn = write_reference_string_(oldValue.getReferenceField2(), newValue.getReferenceField2())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ReferenceField2", ejn);
        }
        return jn;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_int32(oldValue.getIntField(), newValue.getIntField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("IntField", ejn);
        }
        return jn;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_Int32Reference_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_Int32Reference_(com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_reference_int32_(oldValue.getReferenceField1(), newValue.getReferenceField1())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ReferenceField1", ejn);
        }
        if ((ejn = write_reference_int32_(oldValue.getReferenceField2(), newValue.getReferenceField2())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ReferenceField2", ejn);
        }
        return jn;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ObjectReference_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ObjectReference_(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__(oldValue.getReferenceField1(), newValue.getReferenceField1())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ReferenceField1", ejn);
        }
        if ((ejn = write_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__(oldValue.getReferenceField2(), newValue.getReferenceField2())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ReferenceField2", ejn);
        }
        return jn;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ArrayReference_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ArrayReference_(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_reference_array_int32__(oldValue.getReferenceField1(), newValue.getReferenceField1())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ReferenceField1", ejn);
        }
        if ((ejn = write_reference_array_int32__(oldValue.getReferenceField2(), newValue.getReferenceField2())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ReferenceField2", ejn);
        }
        return jn;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ReferenceArray_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ReferenceArray_(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_array_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject___(oldValue.getReferenceArrayField(), newValue.getReferenceArrayField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ReferenceArrayField", ejn);
        }
        return jn;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_BinaryReference_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_BinaryReference_(com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_reference_binary_(oldValue.getReferenceField1(), newValue.getReferenceField1())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ReferenceField1", ejn);
        }
        if ((ejn = write_reference_binary_(oldValue.getReferenceField2(), newValue.getReferenceField2())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("ReferenceField2", ejn);
        }
        return jn;
    }


    public com.fasterxml.jackson.databind.JsonNode write_binary(byte[] oldValue, byte[] newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.binaryNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject___(java.util.List<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject> oldValue, java.util.List<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }




    public com.fasterxml.jackson.databind.JsonNode write_uint32(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum__(com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum_((com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum)oldValue, (com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum_(com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        else
            return write_string(oldValue.toString(), newValue.toString());
    }


    public com.fasterxml.jackson.databind.JsonNode write_reference_binary_(byte[] oldValue, byte[] newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_binary((byte[])oldValue, (byte[])newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, byte[].class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }


    public com.fasterxml.jackson.databind.JsonNode write_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__(com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_((com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject)oldValue, (com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_int32_(java.util.List<java.lang.Integer> oldValue, java.util.List<java.lang.Integer> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(size(oldValue), size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_int32(get(oldValue, i), get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }

    public com.fasterxml.jackson.databind.JsonNode write_int32(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }


    public com.fasterxml.jackson.databind.JsonNode write_reference_array_int32__(java.util.List<java.lang.Integer> oldValue, java.util.List<java.lang.Integer> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_array_int32_((java.util.List<java.lang.Integer>)oldValue, (java.util.List<java.lang.Integer>)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, java.util.ArrayList.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_reference_int32_(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_int32((java.lang.Integer)oldValue, (java.lang.Integer)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, java.lang.Integer.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }


    public com.fasterxml.jackson.databind.JsonNode write_string(java.lang.String oldValue, java.lang.String newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.textNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_reference_string_(java.lang.String oldValue, java.lang.String newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_string((java.lang.String)oldValue, (java.lang.String)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, java.lang.String.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_boolean(java.lang.Boolean oldValue, java.lang.Boolean newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.booleanNode(newValue);
    }



    private static <T> T get(java.util.List<T> v, int i) {
        return v.get(i);
    }
    
    private static <T> T get(T[] v, int i) {
        return v[i];
    }
    
    private static byte get(byte[] v, int i) {
        return v[i];
    }
    private static short get(short[] v, int i) {
        return v[i];
    }
    private static int get(int[] v, int i) {
        return v[i];
    }
    private static long get(long[] v, int i) {
        return v[i];
    }
    private static float get(float[] v, int i) {
        return v[i];
    }
    private static double get(double[] v, int i) {
        return v[i];
    }
    private static boolean get(boolean[] v, int i) {
        return v[i];
    }

    private static <T> int size(java.util.List<T> v) {
        return v.size();
    }

    private static <T> int size(T[] v) {
        return v.length;
    }
    private static int size(byte[] v) {
        return v.length;
    }
    private static int size(short[] v) {
        return v.length;
    }
    private static int size(int[] v) {
        return v.length;
    }
    private static int size(long[] v) {
        return v.length;
    }
    private static int size(float[] v) {
        return v.length;
    }
    private static int size(double[] v) {
        return v.length;
    }
    private static int size(boolean[] v) {
        return v.length;
    }
    }

class TeslaJsonChangeReader_teslacompiler_reference_test_v1_0 extends Serializer.ChangeReader {


    public static final long SCHEMA_HASH = -8997496319200256941L;
    private static final com.fasterxml.jackson.databind.ObjectMapper JSON_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private com.fasterxml.jackson.databind.JsonNode root;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    TeslaJsonChangeReader_teslacompiler_reference_test_v1_0(java.io.InputStream stream) throws java.io.IOException {
        root = JSON_MAPPER.readTree(stream);
    }
 


    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_EnumReference_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_EnumReference_(com.expedia.tesla.compiler.test.passcompile.full.referencetest.EnumReference v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("ReferenceField1");
        if(vn != null) {
            v.setReferenceField1(read_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum__(v.getReferenceField1(), vn));
        }
        vn = jn.get("ReferenceField2");
        if(vn != null) {
            v.setReferenceField2(read_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum__(v.getReferenceField2(), vn));
        }
        return v;
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_StringReference_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_StringReference_(com.expedia.tesla.compiler.test.passcompile.full.referencetest.StringReference v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("ReferenceField1");
        if(vn != null) {
            v.setReferenceField1(read_reference_string_(v.getReferenceField1(), vn));
        }
        vn = jn.get("ReferenceField2");
        if(vn != null) {
            v.setReferenceField2(read_reference_string_(v.getReferenceField2(), vn));
        }
        return v;
    }

    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("IntField");
        if(vn != null) {
            v.setIntField(read_int32(v.getIntField(), vn));
        }
        return v;
    }




    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_Int32Reference_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_Int32Reference_(com.expedia.tesla.compiler.test.passcompile.full.referencetest.Int32Reference v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("ReferenceField1");
        if(vn != null) {
            v.setReferenceField1(read_reference_int32_(v.getReferenceField1(), vn));
        }
        vn = jn.get("ReferenceField2");
        if(vn != null) {
            v.setReferenceField2(read_reference_int32_(v.getReferenceField2(), vn));
        }
        return v;
    }


    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ObjectReference_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ObjectReference_(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ObjectReference v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("ReferenceField1");
        if(vn != null) {
            v.setReferenceField1(read_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__(v.getReferenceField1(), vn));
        }
        vn = jn.get("ReferenceField2");
        if(vn != null) {
            v.setReferenceField2(read_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__(v.getReferenceField2(), vn));
        }
        return v;
    }




    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ArrayReference_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ArrayReference_(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ArrayReference v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("ReferenceField1");
        if(vn != null) {
            v.setReferenceField1(read_reference_array_int32__(v.getReferenceField1(), vn));
        }
        vn = jn.get("ReferenceField2");
        if(vn != null) {
            v.setReferenceField2(read_reference_array_int32__(v.getReferenceField2(), vn));
        }
        return v;
    }



    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ReferenceArray_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_ReferenceArray_(com.expedia.tesla.compiler.test.passcompile.full.referencetest.ReferenceArray v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("ReferenceArrayField");
        if(vn != null) {
            v.setReferenceArrayField(read_array_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject___(v.getReferenceArrayField(), vn));
        }
        return v;
    }




    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference read(com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_BinaryReference_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_BinaryReference_(com.expedia.tesla.compiler.test.passcompile.full.referencetest.BinaryReference v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("ReferenceField1");
        if(vn != null) {
            v.setReferenceField1(read_reference_binary_(v.getReferenceField1(), vn));
        }
        vn = jn.get("ReferenceField2");
        if(vn != null) {
            v.setReferenceField2(read_reference_binary_(v.getReferenceField2(), vn));
        }
        return v;
    }


    public byte[] read_binary(byte[] v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.binaryValue();
    }

    public java.util.List<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject> read_array_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject___(java.util.List<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject> nv = new java.util.TreeMap<Integer, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }




    public int read_uint32(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (int)jn.longValue();
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum read_reference_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum__(com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum value = read_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum_(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum read_enum_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEnum_(com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        java.lang.String value = jn.textValue();
        if (value.equals("Info")) {
            return com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum.Info;
        }
        if (value.equals("Warning")) {
            return com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum.Warning;
        }
        if (value.equals("Error")) {
            return com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum.Error;
        }
        throw new java.io.IOException(String.format(
            "Invalid Enum value '%s' encountered when reading type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum>'", 
            value));
    }


    public byte[] read_reference_binary_(byte[] v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, byte[].class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            byte[] value = read_binary(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, byte[].class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }


    public com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject read_reference_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject__(com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject value = read_class_com_expedia_tesla_compiler_test_passcompile_full_referencetest_TestEmbeddedObject_(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.util.List<java.lang.Integer> read_array_int32_(java.util.List<java.lang.Integer> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, java.lang.Integer> nv = new java.util.TreeMap<Integer, java.lang.Integer>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, v.get(i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_int32(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }

    public int read_int32(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.intValue();
    }


    public java.util.List<java.lang.Integer> read_reference_array_int32__(java.util.List<java.lang.Integer> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, java.util.ArrayList.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            java.util.List<java.lang.Integer> value = read_array_int32_(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, java.util.ArrayList.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public java.lang.Integer read_reference_int32_(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.Integer.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            int value = read_int32(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, java.lang.Integer.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }


    public java.lang.String read_string(java.lang.String v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.textValue();
    }

    public java.lang.String read_reference_string_(java.lang.String v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not a reference object!");

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, java.lang.String.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            java.lang.String value = read_string(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, java.lang.String.class);
            return value;
        }
        throw new AssertionError("BUG, not a reference object!");
    }

    public boolean read_boolean(java.lang.Boolean v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.booleanValue();
    }



}


class TeslaJsonChangeWriter_versioning_test_v1_0 extends Serializer.ChangeWriter {


    public static final long SCHEMA_HASH = -1533394106668605082L;
    private static final com.fasterxml.jackson.databind.ObjectMapper OBJECT_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private static final com.fasterxml.jackson.databind.node.JsonNodeFactory NODE_FACTORY = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    private java.io.OutputStream stream;
    
    TeslaJsonChangeWriter_versioning_test_v1_0(java.io.OutputStream stream) throws java.io.IOException {
        this.stream = stream;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__(oldValue.getEnumField(), newValue.getEnumField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("EnumField", ejn);
        }
        if ((ejn = write_nullable_int32_(oldValue.getDepricatedInt32Field(), newValue.getDepricatedInt32Field())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("DepricatedInt32Field", ejn);
        }
        return jn;
    }


    public com.fasterxml.jackson.databind.JsonNode write_int32(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum oldValue, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_string(java.lang.String oldValue, java.lang.String newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.textNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_uint32(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_boolean(java.lang.Boolean oldValue, java.lang.Boolean newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.booleanNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_int32_(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_int32(oldValue, newValue);
        }
    }


    public com.fasterxml.jackson.databind.JsonNode write_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum oldValue, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        else
            return write_string(oldValue.toString(), newValue.toString());
    }


    private static <T> T get(java.util.List<T> v, int i) {
        return v.get(i);
    }
    
    private static <T> T get(T[] v, int i) {
        return v[i];
    }
    
    private static byte get(byte[] v, int i) {
        return v[i];
    }
    private static short get(short[] v, int i) {
        return v[i];
    }
    private static int get(int[] v, int i) {
        return v[i];
    }
    private static long get(long[] v, int i) {
        return v[i];
    }
    private static float get(float[] v, int i) {
        return v[i];
    }
    private static double get(double[] v, int i) {
        return v[i];
    }
    private static boolean get(boolean[] v, int i) {
        return v[i];
    }

    private static <T> int size(java.util.List<T> v) {
        return v.size();
    }

    private static <T> int size(T[] v) {
        return v.length;
    }
    private static int size(byte[] v) {
        return v.length;
    }
    private static int size(short[] v) {
        return v.length;
    }
    private static int size(int[] v) {
        return v.length;
    }
    private static int size(long[] v) {
        return v.length;
    }
    private static int size(float[] v) {
        return v.length;
    }
    private static int size(double[] v) {
        return v.length;
    }
    private static int size(boolean[] v) {
        return v.length;
    }
    }

class TeslaJsonChangeReader_versioning_test_v1_0 extends Serializer.ChangeReader {


    public static final long SCHEMA_HASH = -1533394106668605082L;
    private static final com.fasterxml.jackson.databind.ObjectMapper JSON_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private com.fasterxml.jackson.databind.JsonNode root;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    TeslaJsonChangeReader_versioning_test_v1_0(java.io.InputStream stream) throws java.io.IOException {
        root = JSON_MAPPER.readTree(stream);
    }
 






    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject read(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("EnumField");
        if(vn != null) {
            v.setEnumField(read_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__(v.getEnumField(), vn));
        }
        vn = jn.get("DepricatedInt32Field");
        if(vn != null) {
            v.setDepricatedInt32Field(read_nullable_int32_(v.getDepricatedInt32Field(), vn));
        }
        return v;
    }



    public int read_int32(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.intValue();
    }

    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum read_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(v, jn);
        }
    }

    public java.lang.String read_string(java.lang.String v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.textValue();
    }

    public int read_uint32(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (int)jn.longValue();
    }

    public boolean read_boolean(java.lang.Boolean v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.booleanValue();
    }

    public java.lang.Integer read_nullable_int32_(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_int32(v, jn);
        }
    }


    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum read_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        java.lang.String value = jn.textValue();
        if (value.equals("Value1")) {
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value1;
        }
        if (value.equals("Value2")) {
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value2;
        }
        if (value.equals("Value3")) {
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value3;
        }
        throw new java.io.IOException(String.format(
            "Invalid Enum value '%s' encountered when reading type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum>'", 
            value));
    }


}


class TeslaJsonChangeWriter_versioning_test_v2_0 extends Serializer.ChangeWriter {


    public static final long SCHEMA_HASH = 3897695751964630335L;
    private static final com.fasterxml.jackson.databind.ObjectMapper OBJECT_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private static final com.fasterxml.jackson.databind.node.JsonNodeFactory NODE_FACTORY = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    private java.io.OutputStream stream;
    
    TeslaJsonChangeWriter_versioning_test_v2_0(java.io.OutputStream stream) throws java.io.IOException {
        this.stream = stream;
    }

    @Override
    public void write(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject oldValue, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__(oldValue.getEnumField(), newValue.getEnumField())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("EnumField", ejn);
        }
        if ((ejn = write_nullable_int64_(oldValue.getNewInt64Field(), newValue.getNewInt64Field())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("NewInt64Field", ejn);
        }
        return jn;
    }


    public com.fasterxml.jackson.databind.JsonNode write_int32(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum oldValue, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_int64_(java.lang.Long oldValue, java.lang.Long newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_int64(oldValue, newValue);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_int64(java.lang.Long oldValue, java.lang.Long newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_string(java.lang.String oldValue, java.lang.String newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.textNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_uint32(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_boolean(java.lang.Boolean oldValue, java.lang.Boolean newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue 
            || (oldValue != null && oldValue.equals(newValue)) 
            || (newValue != null && newValue.equals(oldValue)))
            return null;
            
        return NODE_FACTORY.booleanNode(newValue);
    }


    public com.fasterxml.jackson.databind.JsonNode write_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum oldValue, com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        else
            return write_string(oldValue.toString(), newValue.toString());
    }


    private static <T> T get(java.util.List<T> v, int i) {
        return v.get(i);
    }
    
    private static <T> T get(T[] v, int i) {
        return v[i];
    }
    
    private static byte get(byte[] v, int i) {
        return v[i];
    }
    private static short get(short[] v, int i) {
        return v[i];
    }
    private static int get(int[] v, int i) {
        return v[i];
    }
    private static long get(long[] v, int i) {
        return v[i];
    }
    private static float get(float[] v, int i) {
        return v[i];
    }
    private static double get(double[] v, int i) {
        return v[i];
    }
    private static boolean get(boolean[] v, int i) {
        return v[i];
    }

    private static <T> int size(java.util.List<T> v) {
        return v.size();
    }

    private static <T> int size(T[] v) {
        return v.length;
    }
    private static int size(byte[] v) {
        return v.length;
    }
    private static int size(short[] v) {
        return v.length;
    }
    private static int size(int[] v) {
        return v.length;
    }
    private static int size(long[] v) {
        return v.length;
    }
    private static int size(float[] v) {
        return v.length;
    }
    private static int size(double[] v) {
        return v.length;
    }
    private static int size(boolean[] v) {
        return v.length;
    }
    }

class TeslaJsonChangeReader_versioning_test_v2_0 extends Serializer.ChangeReader {


    public static final long SCHEMA_HASH = 3897695751964630335L;
    private static final com.fasterxml.jackson.databind.ObjectMapper JSON_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private com.fasterxml.jackson.databind.JsonNode root;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    TeslaJsonChangeReader_versioning_test_v2_0(java.io.InputStream stream) throws java.io.IOException {
        root = JSON_MAPPER.readTree(stream);
    }
 







    @Override
    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject read(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(v, root);
    }

    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject read_class_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedObject_(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedObject v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new AssertionError("BUG, not an object!");
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("EnumField");
        if(vn != null) {
            v.setEnumField(read_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__(v.getEnumField(), vn));
        }
        vn = jn.get("NewInt64Field");
        if(vn != null) {
            v.setNewInt64Field(read_nullable_int64_(v.getNewInt64Field(), vn));
        }
        return v;
    }



    public int read_int32(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.intValue();
    }

    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum read_nullable_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum__(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(v, jn);
        }
    }

    public java.lang.Long read_nullable_int64_(java.lang.Long v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_int64(v, jn);
        }
    }

    public long read_int64(java.lang.Long v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.longValue();
    }

    public java.lang.String read_string(java.lang.String v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.textValue();
    }

    public int read_uint32(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (int)jn.longValue();
    }

    public boolean read_boolean(java.lang.Boolean v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.booleanValue();
    }


    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum read_enum_com_expedia_tesla_compiler_test_passcompile_full_versioningtest_VersionedEnum_(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        java.lang.String value = jn.textValue();
        if (value.equals("Value1")) {
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value1;
        }
        if (value.equals("Value5")) {
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value5;
        }
        if (value.equals("Value2")) {
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value2;
        }
        if (value.equals("Value4")) {
            return com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum.Value4;
        }
        throw new java.io.IOException(String.format(
            "Invalid Enum value '%s' encountered when reading type id 'enum<com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum>'", 
            value));
    }


}




