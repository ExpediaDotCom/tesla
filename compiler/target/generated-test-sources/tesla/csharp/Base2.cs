/// <copyright file="Base2.cs" company="Expedia">
///      Copyright (c) 2013. Expedia. All rights reserved.
/// </copyright>
/// <summary>
///      The file contains the Base2 class. 
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
    /// Implementation of the Base2 class
    /// </summary>
    [Serializable]
    public class Base2 :  ISerializable
    {
        /// <summary>
        /// Class Name.
        /// </summary>
        private const string ClassName = "Base2";

        /// <summary>
        /// Initializes a new instance of the <see cref="Base2"/> class.
        /// </summary>
        public Base2()
        {
        }
        
        /// <summary>
        /// Initializes a new instance of the <see cref="Base2"/> class.
        /// </summary>
        /// <param name="Int16Field">The Int16Field parameter.</param>
        public Base2(
            short Int16Field)
        {
            this.Int16Field = Int16Field;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="Base2"/> class.
        /// </summary>
        /// <param name="reader">The ITeslaReader implementor.</param>
        public Base2(ITeslaReader reader)
        {
            this.Deserialize(reader);
        }
    
        /// <summary>
        /// Gets or sets the Int16Field field.
        /// </summary>
        public short Int16Field { get; set; }
        

        /// <summary>
        /// Serializes the object.
        /// </summary>
        /// <param name="writer">The writer parameter.</param>
        public  void Serialize(ITeslaWriter writer)
        {
            writer.WriteObjectBegin("Base2");
            long schemaHash = writer.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaSerializationException("Schema hash is not set.");
            }
            else if (schemaHash == -4144946394736392407L) // version 1, compiler test passcompile full inheritance v1.0
            {
                writer.Write("Int16Field", this.Int16Field);
            }
            else
            {
                throw new TeslaSerializationException("Unsupported schema version " + writer.getSchemaHash());
            }
            writer.WriteObjectEnd("Base2");
        }

        /// <summary>
        /// Deserializes the object.
        /// </summary>
        /// <param name="reader">The reader parameter.</param>
        public  void Deserialize(ITeslaReader reader)
        {
            reader.ReadObjectBegin("Base2");
            long schemaHash = reader.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaDeserializationException("Schema hash is not set.");
            }
            else if (schemaHash == -4144946394736392407L) // version 1, compiler test passcompile full inheritance v1.0
            {
                this.Int16Field =  reader.Readint16("Int16Field");
            }
            else
            {
                throw new TeslaDeserializationException("Unsupported schema version " + reader.getSchemaHash());
            }
            reader.ReadObjectEnd("Base2");
        }
    }
}
