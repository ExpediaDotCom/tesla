/// <copyright file="StringReference.cs" company="Expedia">
///      Copyright (c) 2013. Expedia. All rights reserved.
/// </copyright>
/// <summary>
///      The file contains the StringReference class. 
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
    /// Implementation of the StringReference class
    /// </summary>
    [Serializable]
    public class StringReference :  ISerializable
    {
        /// <summary>
        /// Class Name.
        /// </summary>
        private const string ClassName = "StringReference";

        /// <summary>
        /// Initializes a new instance of the <see cref="StringReference"/> class.
        /// </summary>
        public StringReference()
        {
        }
        
        /// <summary>
        /// Initializes a new instance of the <see cref="StringReference"/> class.
        /// </summary>
        /// <param name="ReferenceField1">The ReferenceField1 parameter.</param>
        /// <param name="ReferenceField2">The ReferenceField2 parameter.</param>
        public StringReference(
            string ReferenceField1,
            string ReferenceField2)
        {
            this.ReferenceField1 = ReferenceField1;
            this.ReferenceField2 = ReferenceField2;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="StringReference"/> class.
        /// </summary>
        /// <param name="reader">The ITeslaReader implementor.</param>
        public StringReference(ITeslaReader reader)
        {
            this.Deserialize(reader);
        }
    
        /// <summary>
        /// Gets or sets the ReferenceField1 field.
        /// </summary>
        public string ReferenceField1 { get; set; }
        
        /// <summary>
        /// Gets or sets the ReferenceField2 field.
        /// </summary>
        public string ReferenceField2 { get; set; }
        

        /// <summary>
        /// Serializes the object.
        /// </summary>
        /// <param name="writer">The writer parameter.</param>
        public  void Serialize(ITeslaWriter writer)
        {
            writer.WriteObjectBegin("StringReference");
            long schemaHash = writer.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaSerializationException("Schema hash is not set.");
            }
            else if (schemaHash == -8997496319200256941L) // version 1, teslacompiler reference test v1.0
            {
                writer.Write("ReferenceField1", this.ReferenceField1);
                writer.Write("ReferenceField2", this.ReferenceField2);
            }
            else
            {
                throw new TeslaSerializationException("Unsupported schema version " + writer.getSchemaHash());
            }
            writer.WriteObjectEnd("StringReference");
        }

        /// <summary>
        /// Deserializes the object.
        /// </summary>
        /// <param name="reader">The reader parameter.</param>
        public  void Deserialize(ITeslaReader reader)
        {
            reader.ReadObjectBegin("StringReference");
            long schemaHash = reader.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaDeserializationException("Schema hash is not set.");
            }
            else if (schemaHash == -8997496319200256941L) // version 1, teslacompiler reference test v1.0
            {
                this.ReferenceField1 =  reader.ReadObject<string>("ReferenceField1");
                this.ReferenceField2 =  reader.ReadObject<string>("ReferenceField2");
            }
            else
            {
                throw new TeslaDeserializationException("Unsupported schema version " + reader.getSchemaHash());
            }
            reader.ReadObjectEnd("StringReference");
        }
    }
}
