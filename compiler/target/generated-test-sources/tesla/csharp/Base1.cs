/// <copyright file="Base1.cs" company="Expedia">
///      Copyright (c) 2013. Expedia. All rights reserved.
/// </copyright>
/// <summary>
///      The file contains the Base1 class. 
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
    /// Implementation of the Base1 class
    /// </summary>
    [Serializable]
    public class Base1 :  ISerializable
    {
        /// <summary>
        /// Class Name.
        /// </summary>
        private const string ClassName = "Base1";

        /// <summary>
        /// Initializes a new instance of the <see cref="Base1"/> class.
        /// </summary>
        public Base1()
        {
        }
        
        /// <summary>
        /// Initializes a new instance of the <see cref="Base1"/> class.
        /// </summary>
        /// <param name="Int32Field">The Int32Field parameter.</param>
        public Base1(
            int Int32Field)
        {
            this.Int32Field = Int32Field;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="Base1"/> class.
        /// </summary>
        /// <param name="reader">The ITeslaReader implementor.</param>
        public Base1(ITeslaReader reader)
        {
            this.Deserialize(reader);
        }
    
        /// <summary>
        /// Gets or sets the Int32Field field.
        /// </summary>
        public int Int32Field { get; set; }
        

        /// <summary>
        /// Serializes the object.
        /// </summary>
        /// <param name="writer">The writer parameter.</param>
        public  void Serialize(ITeslaWriter writer)
        {
            writer.WriteObjectBegin("Base1");
            long schemaHash = writer.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaSerializationException("Schema hash is not set.");
            }
            else if (schemaHash == -4144946394736392407L) // version 1, compiler test passcompile full inheritance v1.0
            {
                writer.Write("Int32Field", this.Int32Field);
            }
            else
            {
                throw new TeslaSerializationException("Unsupported schema version " + writer.getSchemaHash());
            }
            writer.WriteObjectEnd("Base1");
        }

        /// <summary>
        /// Deserializes the object.
        /// </summary>
        /// <param name="reader">The reader parameter.</param>
        public  void Deserialize(ITeslaReader reader)
        {
            reader.ReadObjectBegin("Base1");
            long schemaHash = reader.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaDeserializationException("Schema hash is not set.");
            }
            else if (schemaHash == -4144946394736392407L) // version 1, compiler test passcompile full inheritance v1.0
            {
                this.Int32Field =  reader.Readint32("Int32Field");
            }
            else
            {
                throw new TeslaDeserializationException("Unsupported schema version " + reader.getSchemaHash());
            }
            reader.ReadObjectEnd("Base1");
        }
    }
}
