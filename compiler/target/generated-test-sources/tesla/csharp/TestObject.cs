/// <copyright file="TestObject.cs" company="Expedia">
///      Copyright (c) 2013. Expedia. All rights reserved.
/// </copyright>
/// <summary>
///      The file contains the TestObject class. 
/// </summary>
/// <remarks>
///      This file is generated code by Tesla compiler. Please don't edit. 
/// </remarks>

 
namespace com.expedia.tesla.compiler.test.passcompile.full.all_types 
{
    using System;
    using System.Collections.Generic;
    using Expedia.Tesla.Serialization;

    /// <summary>
    /// Implementation of the TestObject class
    /// </summary>
    [Serializable]
    public class TestObject :  ISerializable
    {
        /// <summary>
        /// Class Name.
        /// </summary>
        private const string ClassName = "TestObject";

        /// <summary>
        /// Initializes a new instance of the <see cref="TestObject"/> class.
        /// </summary>
        public TestObject()
        {
        }
        
        /// <summary>
        /// Initializes a new instance of the <see cref="TestObject"/> class.
        /// </summary>
        /// <param name="BasicTestObjectField">The BasicTestObjectField parameter.</param>
        /// <param name="ReferenceTestObjectField">The ReferenceTestObjectField parameter.</param>
        /// <param name="OptionalBasicTestObjectField">The OptionalBasicTestObjectField parameter.</param>
        /// <param name="ArrayTestObjectField">The ArrayTestObjectField parameter.</param>
        /// <param name="Array2DTestObjectField">The Array2DTestObjectField parameter.</param>
        /// <param name="OptionalArrayTestObjectField">The OptionalArrayTestObjectField parameter.</param>
        public TestObject(
            com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject BasicTestObjectField,
            com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject ReferenceTestObjectField,
            com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject OptionalBasicTestObjectField,
            com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject ArrayTestObjectField,
            com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject Array2DTestObjectField,
            com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject OptionalArrayTestObjectField)
        {
            this.BasicTestObjectField = BasicTestObjectField;
            this.ReferenceTestObjectField = ReferenceTestObjectField;
            this.OptionalBasicTestObjectField = OptionalBasicTestObjectField;
            this.ArrayTestObjectField = ArrayTestObjectField;
            this.Array2DTestObjectField = Array2DTestObjectField;
            this.OptionalArrayTestObjectField = OptionalArrayTestObjectField;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="TestObject"/> class.
        /// </summary>
        /// <param name="reader">The ITeslaReader implementor.</param>
        public TestObject(ITeslaReader reader)
        {
            this.Deserialize(reader);
        }
    
        /// <summary>
        /// Gets or sets the BasicTestObjectField field.
        /// </summary>
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject BasicTestObjectField { get; set; }
        
        /// <summary>
        /// Gets or sets the ReferenceTestObjectField field.
        /// </summary>
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject ReferenceTestObjectField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalBasicTestObjectField field.
        /// </summary>
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject OptionalBasicTestObjectField { get; set; }
        
        /// <summary>
        /// Gets or sets the ArrayTestObjectField field.
        /// </summary>
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject ArrayTestObjectField { get; set; }
        
        /// <summary>
        /// Gets or sets the Array2DTestObjectField field.
        /// </summary>
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject Array2DTestObjectField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalArrayTestObjectField field.
        /// </summary>
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject OptionalArrayTestObjectField { get; set; }
        

        /// <summary>
        /// Serializes the object.
        /// </summary>
        /// <param name="writer">The writer parameter.</param>
        public  void Serialize(ITeslaWriter writer)
        {
            writer.WriteObjectBegin("TestObject");
            long schemaHash = writer.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaSerializationException("Schema hash is not set.");
            }
            else if (schemaHash == 7810441853185379917L) // version 1, teslacompiler all_types v1.0
            {
                writer.Write("BasicTestObjectField", this.BasicTestObjectField);
                writer.Write("ReferenceTestObjectField", this.ReferenceTestObjectField);
                writer.Write("OptionalBasicTestObjectField", this.OptionalBasicTestObjectField);
                writer.Write("ArrayTestObjectField", this.ArrayTestObjectField);
                writer.Write("Array2DTestObjectField", this.Array2DTestObjectField);
                writer.Write("OptionalArrayTestObjectField", this.OptionalArrayTestObjectField);
            }
            else
            {
                throw new TeslaSerializationException("Unsupported schema version " + writer.getSchemaHash());
            }
            writer.WriteObjectEnd("TestObject");
        }

        /// <summary>
        /// Deserializes the object.
        /// </summary>
        /// <param name="reader">The reader parameter.</param>
        public  void Deserialize(ITeslaReader reader)
        {
            reader.ReadObjectBegin("TestObject");
            long schemaHash = reader.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaDeserializationException("Schema hash is not set.");
            }
            else if (schemaHash == 7810441853185379917L) // version 1, teslacompiler all_types v1.0
            {
                this.BasicTestObjectField =  reader.ReadObject<com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject>("BasicTestObjectField");
                this.ReferenceTestObjectField =  reader.ReadObject<com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject>("ReferenceTestObjectField");
                this.OptionalBasicTestObjectField =  reader.ReadObject<com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject>("OptionalBasicTestObjectField");
                this.ArrayTestObjectField =  reader.ReadObject<com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject>("ArrayTestObjectField");
                this.Array2DTestObjectField =  reader.ReadObject<com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject>("Array2DTestObjectField");
                this.OptionalArrayTestObjectField =  reader.ReadObject<com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject>("OptionalArrayTestObjectField");
            }
            else
            {
                throw new TeslaDeserializationException("Unsupported schema version " + reader.getSchemaHash());
            }
            reader.ReadObjectEnd("TestObject");
        }
    }
}
