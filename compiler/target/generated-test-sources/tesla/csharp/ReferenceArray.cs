/// <copyright file="ReferenceArray.cs" company="Expedia">
///      Copyright (c) 2013. Expedia. All rights reserved.
/// </copyright>
/// <summary>
///      The file contains the ReferenceArray class. 
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
    /// Implementation of the ReferenceArray class
    /// </summary>
    [Serializable]
    public class ReferenceArray :  ISerializable
    {
        /// <summary>
        /// Class Name.
        /// </summary>
        private const string ClassName = "ReferenceArray";

        /// <summary>
        /// Initializes a new instance of the <see cref="ReferenceArray"/> class.
        /// </summary>
        public ReferenceArray()
        {
        }
        
        /// <summary>
        /// Initializes a new instance of the <see cref="ReferenceArray"/> class.
        /// </summary>
        /// <param name="ReferenceArrayField">The ReferenceArrayField parameter.</param>
        public ReferenceArray(
            List<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject> ReferenceArrayField)
        {
            this.ReferenceArrayField = ReferenceArrayField;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="ReferenceArray"/> class.
        /// </summary>
        /// <param name="reader">The ITeslaReader implementor.</param>
        public ReferenceArray(ITeslaReader reader)
        {
            this.Deserialize(reader);
        }
    
        /// <summary>
        /// Gets or sets the ReferenceArrayField field.
        /// </summary>
        public List<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject> ReferenceArrayField { get; set; }
        

        /// <summary>
        /// Serializes the object.
        /// </summary>
        /// <param name="writer">The writer parameter.</param>
        public  void Serialize(ITeslaWriter writer)
        {
            writer.WriteObjectBegin("ReferenceArray");
            long schemaHash = writer.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaSerializationException("Schema hash is not set.");
            }
            else if (schemaHash == -8997496319200256941L) // version 1, teslacompiler reference test v1.0
            {
                writer.WriteObjectArray<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject>("ReferenceArrayField", this.ReferenceArrayField, false, 1);
            }
            else
            {
                throw new TeslaSerializationException("Unsupported schema version " + writer.getSchemaHash());
            }
            writer.WriteObjectEnd("ReferenceArray");
        }

        /// <summary>
        /// Deserializes the object.
        /// </summary>
        /// <param name="reader">The reader parameter.</param>
        public  void Deserialize(ITeslaReader reader)
        {
            reader.ReadObjectBegin("ReferenceArray");
            long schemaHash = reader.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaDeserializationException("Schema hash is not set.");
            }
            else if (schemaHash == -8997496319200256941L) // version 1, teslacompiler reference test v1.0
            {
                this.ReferenceArrayField = (List<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject>) reader.ReadObjectArray<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject>("ReferenceArrayField", false, 1);
            }
            else
            {
                throw new TeslaDeserializationException("Unsupported schema version " + reader.getSchemaHash());
            }
            reader.ReadObjectEnd("ReferenceArray");
        }
    }
}
