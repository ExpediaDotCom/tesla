/// <copyright file="MultiDerived.cs" company="Expedia">
///      Copyright (c) 2013. Expedia. All rights reserved.
/// </copyright>
/// <summary>
///      The file contains the MultiDerived class. 
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
    /// Implementation of the MultiDerived class
    /// </summary>
    [Serializable]
    public class MultiDerived :  ISerializable
    {
        /// <summary>
        /// Class Name.
        /// </summary>
        private const string ClassName = "MultiDerived";

        /// <summary>
        /// Initializes a new instance of the <see cref="MultiDerived"/> class.
        /// </summary>
        public MultiDerived()
        {
        }
        
        /// <summary>
        /// Initializes a new instance of the <see cref="MultiDerived"/> class.
        /// </summary>
        /// <param name="Int32Field">The Int32Field parameter.</param>
        /// <param name="Int16Field">The Int16Field parameter.</param>
        /// <param name="ByteField">The ByteField parameter.</param>
        public MultiDerived(
            int Int32Field,
            short Int16Field,
            byte ByteField)
        {
            this.Int32Field = Int32Field;
            this.Int16Field = Int16Field;
            this.ByteField = ByteField;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="MultiDerived"/> class.
        /// </summary>
        /// <param name="reader">The ITeslaReader implementor.</param>
        public MultiDerived(ITeslaReader reader)
        {
            this.Deserialize(reader);
        }
    
        /// <summary>
        /// Gets or sets the Int32Field field.
        /// </summary>
        public int Int32Field { get; set; }
        
        /// <summary>
        /// Gets or sets the Int16Field field.
        /// </summary>
        public short Int16Field { get; set; }
        
        /// <summary>
        /// Gets or sets the ByteField field.
        /// </summary>
        public byte ByteField { get; set; }
        

        /// <summary>
        /// Serializes the object.
        /// </summary>
        /// <param name="writer">The writer parameter.</param>
        public  void Serialize(ITeslaWriter writer)
        {
            writer.WriteObjectBegin("MultiDerived");
            long schemaHash = writer.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaSerializationException("Schema hash is not set.");
            }
            else if (schemaHash == -4144946394736392407L) // version 1, compiler test passcompile full inheritance v1.0
            {
                writer.Write("Int32Field", this.Int32Field);
                writer.Write("Int16Field", this.Int16Field);
                writer.Write("ByteField", this.ByteField);
            }
            else
            {
                throw new TeslaSerializationException("Unsupported schema version " + writer.getSchemaHash());
            }
            writer.WriteObjectEnd("MultiDerived");
        }

        /// <summary>
        /// Deserializes the object.
        /// </summary>
        /// <param name="reader">The reader parameter.</param>
        public  void Deserialize(ITeslaReader reader)
        {
            reader.ReadObjectBegin("MultiDerived");
            long schemaHash = reader.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaDeserializationException("Schema hash is not set.");
            }
            else if (schemaHash == -4144946394736392407L) // version 1, compiler test passcompile full inheritance v1.0
            {
                this.Int32Field =  reader.Readint32("Int32Field");
                this.Int16Field =  reader.Readint16("Int16Field");
                this.ByteField =  reader.Readbyte("ByteField");
            }
            else
            {
                throw new TeslaDeserializationException("Unsupported schema version " + reader.getSchemaHash());
            }
            reader.ReadObjectEnd("MultiDerived");
        }
    }
}
