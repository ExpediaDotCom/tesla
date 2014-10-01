/// <copyright file="complexttypetest.cs" company="Expedia">
///      Copyright (c) 2013. Expedia. All rights reserved.
/// </copyright>
/// <summary>
///      The file contains the complexttypetest class. 
/// </summary>
/// <remarks>
///      This file is generated code by Tesla compiler. Please don't edit. 
/// </remarks>

 
namespace com.expedia.tesla.compiler.test.passcompile.full 
{
    using System;
    using System.Collections.Generic;
    using Expedia.Tesla.Serialization;

    /// <summary>
    /// Implementation of the complexttypetest class
    /// </summary>
    [Serializable]
    public class complexttypetest :  ISerializable
    {
        /// <summary>
        /// Class Name.
        /// </summary>
        private const string ClassName = "complexttypetest";

        /// <summary>
        /// Initializes a new instance of the <see cref="complexttypetest"/> class.
        /// </summary>
        public complexttypetest()
        {
        }
        
        /// <summary>
        /// Initializes a new instance of the <see cref="complexttypetest"/> class.
        /// </summary>
        /// <param name="Field1">The Field1 parameter.</param>
        /// <param name="Field2">The Field2 parameter.</param>
        /// <param name="Field3">The Field3 parameter.</param>
        /// <param name="Field4">The Field4 parameter.</param>
        /// <param name="Field5">The Field5 parameter.</param>
        public complexttypetest(
            List<string> Field1,
            List<List<string>> Field2,
            List<List<List<string>>> Field3,
            string Field4,
            string Field5)
        {
            this.Field1 = Field1;
            this.Field2 = Field2;
            this.Field3 = Field3;
            this.Field4 = Field4;
            this.Field5 = Field5;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="complexttypetest"/> class.
        /// </summary>
        /// <param name="reader">The ITeslaReader implementor.</param>
        public complexttypetest(ITeslaReader reader)
        {
            this.Deserialize(reader);
        }
    
        /// <summary>
        /// Gets or sets the Field1 field.
        /// </summary>
        public List<string> Field1 { get; set; }
        
        /// <summary>
        /// Gets or sets the Field2 field.
        /// </summary>
        public List<List<string>> Field2 { get; set; }
        
        /// <summary>
        /// Gets or sets the Field3 field.
        /// </summary>
        public List<List<List<string>>> Field3 { get; set; }
        
        /// <summary>
        /// Gets or sets the Field4 field.
        /// </summary>
        public string Field4 { get; set; }
        
        /// <summary>
        /// Gets or sets the Field5 field.
        /// </summary>
        public string Field5 { get; set; }
        

        /// <summary>
        /// Serializes the object.
        /// </summary>
        /// <param name="writer">The writer parameter.</param>
        public  void Serialize(ITeslaWriter writer)
        {
            writer.WriteObjectBegin("complexttypetest");
            long schemaHash = writer.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaSerializationException("Schema hash is not set.");
            }
            else if (schemaHash == -5586303099293846137L) // version 1, compiler test passcompile full complexttypetest
            {
                writer.WriteObjectArray<string>("field1", this.Field1, false, 1);
                writer.WriteObjectArray<string>("field2", this.Field2, false, 2);
                writer.WriteObjectArray<string>("field3", this.Field3, false, 3);
                writer.Write("field4", this.Field4);
                writer.Write("field5", this.Field5);
            }
            else
            {
                throw new TeslaSerializationException("Unsupported schema version " + writer.getSchemaHash());
            }
            writer.WriteObjectEnd("complexttypetest");
        }

        /// <summary>
        /// Deserializes the object.
        /// </summary>
        /// <param name="reader">The reader parameter.</param>
        public  void Deserialize(ITeslaReader reader)
        {
            reader.ReadObjectBegin("complexttypetest");
            long schemaHash = reader.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaDeserializationException("Schema hash is not set.");
            }
            else if (schemaHash == -5586303099293846137L) // version 1, compiler test passcompile full complexttypetest
            {
                this.Field1 = (List<string>) reader.ReadObjectArray<string>("field1", false, 1);
                this.Field2 = (List<List<string>>) reader.ReadObjectArray<string>("field2", false, 2);
                this.Field3 = (List<List<List<string>>>) reader.ReadObjectArray<string>("field3", false, 3);
                this.Field4 =  reader.ReadObject<string>("field4");
                this.Field5 =  reader.ReadObject<string>("field5");
            }
            else
            {
                throw new TeslaDeserializationException("Unsupported schema version " + reader.getSchemaHash());
            }
            reader.ReadObjectEnd("complexttypetest");
        }
    }
}
