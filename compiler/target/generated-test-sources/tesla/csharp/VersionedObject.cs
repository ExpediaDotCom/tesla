/// <copyright file="VersionedObject.cs" company="Expedia">
///      Copyright (c) 2013. Expedia. All rights reserved.
/// </copyright>
/// <summary>
///      The file contains the VersionedObject class. 
/// </summary>
/// <remarks>
///      This file is generated code by Tesla compiler. Please don't edit. 
/// </remarks>

 
namespace com.expedia.tesla.compiler.test.passcompile.full.versioningtest 
{
    using System;
    using System.Collections.Generic;
    using Expedia.Tesla.Serialization;

    /// <summary>
    /// Implementation of the VersionedObject class
    /// </summary>
    [Serializable]
    public class VersionedObject :  ISerializable
    {
        /// <summary>
        /// Class Name.
        /// </summary>
        private const string ClassName = "VersionedObject";

        /// <summary>
        /// Initializes a new instance of the <see cref="VersionedObject"/> class.
        /// </summary>
        public VersionedObject()
        {
        }
        
        /// <summary>
        /// Initializes a new instance of the <see cref="VersionedObject"/> class.
        /// </summary>
        /// <param name="EnumField">The EnumField parameter.</param>
        /// <param name="DepricatedInt32Field">The DepricatedInt32Field parameter.</param>
        /// <param name="NewInt64Field">The NewInt64Field parameter.</param>
        public VersionedObject(
            com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum EnumField,
            int DepricatedInt32Field,
            long NewInt64Field)
        {
            this.EnumField = EnumField;
            this.DepricatedInt32Field = DepricatedInt32Field;
            this.NewInt64Field = NewInt64Field;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="VersionedObject"/> class.
        /// </summary>
        /// <param name="reader">The ITeslaReader implementor.</param>
        public VersionedObject(ITeslaReader reader)
        {
            this.Deserialize(reader);
        }
    
        /// <summary>
        /// Gets or sets the EnumField field.
        /// </summary>
        public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum EnumField { get; set; }
        
        /// <summary>
        /// Gets or sets the DepricatedInt32Field field.
        /// </summary>
        public int DepricatedInt32Field { get; set; }
        
        /// <summary>
        /// Gets or sets the NewInt64Field field.
        /// </summary>
        public long NewInt64Field { get; set; }
        

        /// <summary>
        /// Serializes the object.
        /// </summary>
        /// <param name="writer">The writer parameter.</param>
        public  void Serialize(ITeslaWriter writer)
        {
            writer.WriteObjectBegin("VersionedObject");
            long schemaHash = writer.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaSerializationException("Schema hash is not set.");
            }
            else if (schemaHash == -1533394106668605082L) // version 1, versioning test v1.0
            {
                writer.Write("EnumField", this.EnumField);
                writer.Write("DepricatedInt32Field", this.DepricatedInt32Field);
            }
            else if (schemaHash == 3897695751964630335L) // version 2, versioning test v2.0
            {
                writer.Write("EnumField", this.EnumField);
                writer.Write("NewInt64Field", this.NewInt64Field);
            }
            else
            {
                throw new TeslaSerializationException("Unsupported schema version " + writer.getSchemaHash());
            }
            writer.WriteObjectEnd("VersionedObject");
        }

        /// <summary>
        /// Deserializes the object.
        /// </summary>
        /// <param name="reader">The reader parameter.</param>
        public  void Deserialize(ITeslaReader reader)
        {
            reader.ReadObjectBegin("VersionedObject");
            long schemaHash = reader.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaDeserializationException("Schema hash is not set.");
            }
            else if (schemaHash == -1533394106668605082L) // version 1, versioning test v1.0
            {
                this.EnumField =  reader.ReadObject<com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum>("EnumField");
                this.DepricatedInt32Field =  reader.ReadObject<int>("DepricatedInt32Field");
            }
            else if (schemaHash == 3897695751964630335L) // version 2, versioning test v2.0
            {
                this.EnumField =  reader.ReadObject<com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum>("EnumField");
                this.NewInt64Field =  reader.ReadObject<long>("NewInt64Field");
            }
            else
            {
                throw new TeslaDeserializationException("Unsupported schema version " + reader.getSchemaHash());
            }
            reader.ReadObjectEnd("VersionedObject");
        }
    }
}
