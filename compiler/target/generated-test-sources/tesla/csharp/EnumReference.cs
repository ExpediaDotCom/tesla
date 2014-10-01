/// <copyright file="EnumReference.cs" company="Expedia">
///      Copyright (c) 2013. Expedia. All rights reserved.
/// </copyright>
/// <summary>
///      The file contains the EnumReference class. 
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
    /// Implementation of the EnumReference class
    /// </summary>
    [Serializable]
    public class EnumReference :  ISerializable
    {
        /// <summary>
        /// Class Name.
        /// </summary>
        private const string ClassName = "EnumReference";

        /// <summary>
        /// Initializes a new instance of the <see cref="EnumReference"/> class.
        /// </summary>
        public EnumReference()
        {
        }
        
        /// <summary>
        /// Initializes a new instance of the <see cref="EnumReference"/> class.
        /// </summary>
        /// <param name="ReferenceField1">The ReferenceField1 parameter.</param>
        /// <param name="ReferenceField2">The ReferenceField2 parameter.</param>
        public EnumReference(
            com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum ReferenceField1,
            com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum ReferenceField2)
        {
            this.ReferenceField1 = ReferenceField1;
            this.ReferenceField2 = ReferenceField2;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="EnumReference"/> class.
        /// </summary>
        /// <param name="reader">The ITeslaReader implementor.</param>
        public EnumReference(ITeslaReader reader)
        {
            this.Deserialize(reader);
        }
    
        /// <summary>
        /// Gets or sets the ReferenceField1 field.
        /// </summary>
        public com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum ReferenceField1 { get; set; }
        
        /// <summary>
        /// Gets or sets the ReferenceField2 field.
        /// </summary>
        public com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum ReferenceField2 { get; set; }
        

        /// <summary>
        /// Serializes the object.
        /// </summary>
        /// <param name="writer">The writer parameter.</param>
        public  void Serialize(ITeslaWriter writer)
        {
            writer.WriteObjectBegin("EnumReference");
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
            writer.WriteObjectEnd("EnumReference");
        }

        /// <summary>
        /// Deserializes the object.
        /// </summary>
        /// <param name="reader">The reader parameter.</param>
        public  void Deserialize(ITeslaReader reader)
        {
            reader.ReadObjectBegin("EnumReference");
            long schemaHash = reader.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaDeserializationException("Schema hash is not set.");
            }
            else if (schemaHash == -8997496319200256941L) // version 1, teslacompiler reference test v1.0
            {
                this.ReferenceField1 =  reader.ReadObject<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum>("ReferenceField1");
                this.ReferenceField2 =  reader.ReadObject<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEnum>("ReferenceField2");
            }
            else
            {
                throw new TeslaDeserializationException("Unsupported schema version " + reader.getSchemaHash());
            }
            reader.ReadObjectEnd("EnumReference");
        }
    }
}
