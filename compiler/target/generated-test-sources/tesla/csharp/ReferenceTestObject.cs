/// <copyright file="ReferenceTestObject.cs" company="Expedia">
///      Copyright (c) 2013. Expedia. All rights reserved.
/// </copyright>
/// <summary>
///      The file contains the ReferenceTestObject class. 
/// </summary>
/// <remarks>
///      This file is generated code by Tesla compiler. Please don't edit. 
/// </remarks>

 
namespace com.expedia.tesla.compiler.test.passcompile.full.all_types 
{
    using System;
    using System.Collections.Generic;
    using Expedia.Tesla.Serialization;

    /// <summary>
    /// Implementation of the ReferenceTestObject class
    /// </summary>
    [Serializable]
    public class ReferenceTestObject :  ISerializable
    {
        /// <summary>
        /// Class Name.
        /// </summary>
        private const string ClassName = "ReferenceTestObject";

        /// <summary>
        /// Initializes a new instance of the <see cref="ReferenceTestObject"/> class.
        /// </summary>
        public ReferenceTestObject()
        {
        }
        
        /// <summary>
        /// Initializes a new instance of the <see cref="ReferenceTestObject"/> class.
        /// </summary>
        /// <param name="ObjectReferenceField">The ObjectReferenceField parameter.</param>
        /// <param name="EnumReferenceField">The EnumReferenceField parameter.</param>
        /// <param name="BoolReferenceField">The BoolReferenceField parameter.</param>
        /// <param name="ByteReferenceField">The ByteReferenceField parameter.</param>
        /// <param name="Int16ReferenceField">The Int16ReferenceField parameter.</param>
        /// <param name="UInt16ReferenceField">The UInt16ReferenceField parameter.</param>
        /// <param name="Int32ReferenceField">The Int32ReferenceField parameter.</param>
        /// <param name="UInt32ReferenceField">The UInt32ReferenceField parameter.</param>
        /// <param name="Int64ReferenceField">The Int64ReferenceField parameter.</param>
        /// <param name="UInt64ReferenceField">The UInt64ReferenceField parameter.</param>
        /// <param name="FloatReferenceField">The FloatReferenceField parameter.</param>
        /// <param name="DoubleReferenceField">The DoubleReferenceField parameter.</param>
        /// <param name="BinaryReferenceField">The BinaryReferenceField parameter.</param>
        /// <param name="StringReferenceField">The StringReferenceField parameter.</param>
        public ReferenceTestObject(
            com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject ObjectReferenceField,
            com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum EnumReferenceField,
            bool BoolReferenceField,
            byte ByteReferenceField,
            short Int16ReferenceField,
            ushort UInt16ReferenceField,
            int Int32ReferenceField,
            uint UInt32ReferenceField,
            long Int64ReferenceField,
            ulong UInt64ReferenceField,
            float FloatReferenceField,
            double DoubleReferenceField,
            byte[] BinaryReferenceField,
            string StringReferenceField)
        {
            this.ObjectReferenceField = ObjectReferenceField;
            this.EnumReferenceField = EnumReferenceField;
            this.BoolReferenceField = BoolReferenceField;
            this.ByteReferenceField = ByteReferenceField;
            this.Int16ReferenceField = Int16ReferenceField;
            this.UInt16ReferenceField = UInt16ReferenceField;
            this.Int32ReferenceField = Int32ReferenceField;
            this.UInt32ReferenceField = UInt32ReferenceField;
            this.Int64ReferenceField = Int64ReferenceField;
            this.UInt64ReferenceField = UInt64ReferenceField;
            this.FloatReferenceField = FloatReferenceField;
            this.DoubleReferenceField = DoubleReferenceField;
            this.BinaryReferenceField = BinaryReferenceField;
            this.StringReferenceField = StringReferenceField;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="ReferenceTestObject"/> class.
        /// </summary>
        /// <param name="reader">The ITeslaReader implementor.</param>
        public ReferenceTestObject(ITeslaReader reader)
        {
            this.Deserialize(reader);
        }
    
        /// <summary>
        /// Gets or sets the ObjectReferenceField field.
        /// </summary>
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject ObjectReferenceField { get; set; }
        
        /// <summary>
        /// Gets or sets the EnumReferenceField field.
        /// </summary>
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum EnumReferenceField { get; set; }
        
        /// <summary>
        /// Gets or sets the BoolReferenceField field.
        /// </summary>
        public bool BoolReferenceField { get; set; }
        
        /// <summary>
        /// Gets or sets the ByteReferenceField field.
        /// </summary>
        public byte ByteReferenceField { get; set; }
        
        /// <summary>
        /// Gets or sets the Int16ReferenceField field.
        /// </summary>
        public short Int16ReferenceField { get; set; }
        
        /// <summary>
        /// Gets or sets the UInt16ReferenceField field.
        /// </summary>
        public ushort UInt16ReferenceField { get; set; }
        
        /// <summary>
        /// Gets or sets the Int32ReferenceField field.
        /// </summary>
        public int Int32ReferenceField { get; set; }
        
        /// <summary>
        /// Gets or sets the UInt32ReferenceField field.
        /// </summary>
        public uint UInt32ReferenceField { get; set; }
        
        /// <summary>
        /// Gets or sets the Int64ReferenceField field.
        /// </summary>
        public long Int64ReferenceField { get; set; }
        
        /// <summary>
        /// Gets or sets the UInt64ReferenceField field.
        /// </summary>
        public ulong UInt64ReferenceField { get; set; }
        
        /// <summary>
        /// Gets or sets the FloatReferenceField field.
        /// </summary>
        public float FloatReferenceField { get; set; }
        
        /// <summary>
        /// Gets or sets the DoubleReferenceField field.
        /// </summary>
        public double DoubleReferenceField { get; set; }
        
        /// <summary>
        /// Gets or sets the BinaryReferenceField field.
        /// </summary>
        public byte[] BinaryReferenceField { get; set; }
        
        /// <summary>
        /// Gets or sets the StringReferenceField field.
        /// </summary>
        public string StringReferenceField { get; set; }
        

        /// <summary>
        /// Serializes the object.
        /// </summary>
        /// <param name="writer">The writer parameter.</param>
        public  void Serialize(ITeslaWriter writer)
        {
            writer.WriteObjectBegin("ReferenceTestObject");
            long schemaHash = writer.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaSerializationException("Schema hash is not set.");
            }
            else if (schemaHash == 7810441853185379917L) // version 1, teslacompiler all_types v1.0
            {
                writer.Write("ObjectReferenceField", this.ObjectReferenceField);
                writer.Write("EnumReferenceField", this.EnumReferenceField);
                writer.Write("BoolReferenceField", this.BoolReferenceField);
                writer.Write("ByteReferenceField", this.ByteReferenceField);
                writer.Write("Int16ReferenceField", this.Int16ReferenceField);
                writer.Write("UInt16ReferenceField", this.UInt16ReferenceField);
                writer.Write("Int32ReferenceField", this.Int32ReferenceField);
                writer.Write("UInt32ReferenceField", this.UInt32ReferenceField);
                writer.Write("Int64ReferenceField", this.Int64ReferenceField);
                writer.Write("UInt64ReferenceField", this.UInt64ReferenceField);
                writer.Write("FloatReferenceField", this.FloatReferenceField);
                writer.Write("DoubleReferenceField", this.DoubleReferenceField);
                writer.Write("BinaryReferenceField", this.BinaryReferenceField);
                writer.Write("StringReferenceField", this.StringReferenceField);
            }
            else
            {
                throw new TeslaSerializationException("Unsupported schema version " + writer.getSchemaHash());
            }
            writer.WriteObjectEnd("ReferenceTestObject");
        }

        /// <summary>
        /// Deserializes the object.
        /// </summary>
        /// <param name="reader">The reader parameter.</param>
        public  void Deserialize(ITeslaReader reader)
        {
            reader.ReadObjectBegin("ReferenceTestObject");
            long schemaHash = reader.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaDeserializationException("Schema hash is not set.");
            }
            else if (schemaHash == 7810441853185379917L) // version 1, teslacompiler all_types v1.0
            {
                this.ObjectReferenceField =  reader.ReadObject<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>("ObjectReferenceField");
                this.EnumReferenceField =  reader.ReadObject<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>("EnumReferenceField");
                this.BoolReferenceField =  reader.ReadObject<bool>("BoolReferenceField");
                this.ByteReferenceField =  reader.ReadObject<byte>("ByteReferenceField");
                this.Int16ReferenceField =  reader.ReadObject<short>("Int16ReferenceField");
                this.UInt16ReferenceField =  reader.ReadObject<ushort>("UInt16ReferenceField");
                this.Int32ReferenceField =  reader.ReadObject<int>("Int32ReferenceField");
                this.UInt32ReferenceField =  reader.ReadObject<uint>("UInt32ReferenceField");
                this.Int64ReferenceField =  reader.ReadObject<long>("Int64ReferenceField");
                this.UInt64ReferenceField =  reader.ReadObject<ulong>("UInt64ReferenceField");
                this.FloatReferenceField =  reader.ReadObject<float>("FloatReferenceField");
                this.DoubleReferenceField =  reader.ReadObject<double>("DoubleReferenceField");
                this.BinaryReferenceField =  reader.ReadObject<byte[]>("BinaryReferenceField");
                this.StringReferenceField =  reader.ReadObject<string>("StringReferenceField");
            }
            else
            {
                throw new TeslaDeserializationException("Unsupported schema version " + reader.getSchemaHash());
            }
            reader.ReadObjectEnd("ReferenceTestObject");
        }
    }
}
