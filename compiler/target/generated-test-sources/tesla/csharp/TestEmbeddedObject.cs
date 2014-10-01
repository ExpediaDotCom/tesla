/// <copyright file="TestEmbeddedObject.cs" company="Expedia">
///      Copyright (c) 2013. Expedia. All rights reserved.
/// </copyright>
/// <summary>
///      The file contains the TestEmbeddedObject class. 
/// </summary>
/// <remarks>
///      This file is generated code by Tesla compiler. Please don't edit. 
/// </remarks>

 
namespace com.expedia.tesla.compiler.test.passcompile.full.referencetest 
{
    using System;
    using System.Collections.Generic;
    using Expedia.Tesla.Serialization;

    /// <summary>
    /// Implementation of the TestEmbeddedObject class
    /// </summary>
    [Serializable]
    public class TestEmbeddedObject :  ISerializable
    {
        /// <summary>
        /// Class Name.
        /// </summary>
        private const string ClassName = "TestEmbeddedObject";

        /// <summary>
        /// Initializes a new instance of the <see cref="TestEmbeddedObject"/> class.
        /// </summary>
        public TestEmbeddedObject()
        {
        }
        
        /// <summary>
        /// Initializes a new instance of the <see cref="TestEmbeddedObject"/> class.
        /// </summary>
        /// <param name="IntField">The IntField parameter.</param>
        public TestEmbeddedObject(
            int IntField)
        {
            this.IntField = IntField;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="TestEmbeddedObject"/> class.
        /// </summary>
        /// <param name="reader">The ITeslaReader implementor.</param>
        public TestEmbeddedObject(ITeslaReader reader)
        {
            this.Deserialize(reader);
        }
    
        /// <summary>
        /// Gets or sets the IntField field.
        /// </summary>
        public int IntField { get; set; }
        

        /// <summary>
        /// Serializes the object.
        /// </summary>
        /// <param name="writer">The writer parameter.</param>
        public  void Serialize(ITeslaWriter writer)
        {
            writer.WriteObjectBegin("TestEmbeddedObject");
            long schemaHash = writer.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaSerializationException("Schema hash is not set.");
            }
            else if (schemaHash == -8997496319200256941L) // version 1, teslacompiler reference test v1.0
            {
                writer.Write("IntField", this.IntField);
            }
            else
            {
                throw new TeslaSerializationException("Unsupported schema version " + writer.getSchemaHash());
            }
            writer.WriteObjectEnd("TestEmbeddedObject");
        }

        /// <summary>
        /// Deserializes the object.
        /// </summary>
        /// <param name="reader">The reader parameter.</param>
        public  void Deserialize(ITeslaReader reader)
        {
            reader.ReadObjectBegin("TestEmbeddedObject");
            long schemaHash = reader.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaDeserializationException("Schema hash is not set.");
            }
            else if (schemaHash == -8997496319200256941L) // version 1, teslacompiler reference test v1.0
            {
                this.IntField =  reader.Readint32("IntField");
            }
            else
            {
                throw new TeslaDeserializationException("Unsupported schema version " + reader.getSchemaHash());
            }
            reader.ReadObjectEnd("TestEmbeddedObject");
        }
    }
}
