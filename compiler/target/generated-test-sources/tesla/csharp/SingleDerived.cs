/// <copyright file="SingleDerived.cs" company="Expedia">
///      Copyright (c) 2013. Expedia. All rights reserved.
/// </copyright>
/// <summary>
///      The file contains the SingleDerived class. 
/// </summary>
/// <remarks>
///      This file is generated code by Tesla compiler. Please don't edit. 
/// </remarks>

 
namespace com.expedia.tesla.compiler.test.passcompile.full.inheritance 
{
    using System;
    using System.Collections.Generic;
    using Expedia.Tesla.Serialization;

    /// <summary>
    /// Implementation of the SingleDerived class
    /// </summary>
    [Serializable]
    public class SingleDerived :  com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1, ISerializable
    {
        /// <summary>
        /// Class Name.
        /// </summary>
        private const string ClassName = "SingleDerived";

        /// <summary>
        /// Initializes a new instance of the <see cref="SingleDerived"/> class.
        /// </summary>
        public SingleDerived()
        {
        }
        
        /// <summary>
        /// Initializes a new instance of the <see cref="SingleDerived"/> class.
        /// </summary>
        /// <param name="Int32Field">The Int32Field parameter.</param>
        /// <param name="BooleanField">The BooleanField parameter.</param>
        public SingleDerived(
            int Int32Field,
            bool BooleanField)
        {
            this.Int32Field = Int32Field;
            this.BooleanField = BooleanField;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="SingleDerived"/> class.
        /// </summary>
        /// <param name="reader">The ITeslaReader implementor.</param>
        public SingleDerived(ITeslaReader reader)
        {
            this.Deserialize(reader);
        }
    
        /// <summary>
        /// Gets or sets the BooleanField field.
        /// </summary>
        public bool BooleanField { get; set; }
        

        /// <summary>
        /// Serializes the object.
        /// </summary>
        /// <param name="writer">The writer parameter.</param>
        public  new  void Serialize(ITeslaWriter writer)
        {
            writer.WriteObjectBegin("SingleDerived");
            long schemaHash = writer.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaSerializationException("Schema hash is not set.");
            }
            else if (schemaHash == -4144946394736392407L) // version 1, compiler test passcompile full inheritance v1.0
            {
                writer.Write("Int32Field", this.Int32Field);
                writer.Write("BooleanField", this.BooleanField);
            }
            else
            {
                throw new TeslaSerializationException("Unsupported schema version " + writer.getSchemaHash());
            }
            writer.WriteObjectEnd("SingleDerived");
        }

        /// <summary>
        /// Deserializes the object.
        /// </summary>
        /// <param name="reader">The reader parameter.</param>
        public  new  void Deserialize(ITeslaReader reader)
        {
            reader.ReadObjectBegin("SingleDerived");
            long schemaHash = reader.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaDeserializationException("Schema hash is not set.");
            }
            else if (schemaHash == -4144946394736392407L) // version 1, compiler test passcompile full inheritance v1.0
            {
                this.Int32Field =  reader.Readint32("Int32Field");
                this.BooleanField =  reader.Readboolean("BooleanField");
            }
            else
            {
                throw new TeslaDeserializationException("Unsupported schema version " + reader.getSchemaHash());
            }
            reader.ReadObjectEnd("SingleDerived");
        }
    }
}
