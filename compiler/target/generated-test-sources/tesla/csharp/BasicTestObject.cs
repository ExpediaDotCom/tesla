/// <copyright file="BasicTestObject.cs" company="Expedia">
///      Copyright (c) 2013. Expedia. All rights reserved.
/// </copyright>
/// <summary>
///      The file contains the BasicTestObject class. 
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
    /// Implementation of the BasicTestObject class
    /// </summary>
    [Serializable]
    public class BasicTestObject :  ISerializable
    {
        /// <summary>
        /// Class Name.
        /// </summary>
        private const string ClassName = "BasicTestObject";

        /// <summary>
        /// Initializes a new instance of the <see cref="BasicTestObject"/> class.
        /// </summary>
        public BasicTestObject()
        {
        }
        
        /// <summary>
        /// Initializes a new instance of the <see cref="BasicTestObject"/> class.
        /// </summary>
        /// <param name="ObjectField">The ObjectField parameter.</param>
        /// <param name="EnumField">The EnumField parameter.</param>
        /// <param name="BoolField">The BoolField parameter.</param>
        /// <param name="ByteField">The ByteField parameter.</param>
        /// <param name="Int16Field">The Int16Field parameter.</param>
        /// <param name="UInt16Field">The UInt16Field parameter.</param>
        /// <param name="Int32Field">The Int32Field parameter.</param>
        /// <param name="UInt32Field">The UInt32Field parameter.</param>
        /// <param name="Int64Field">The Int64Field parameter.</param>
        /// <param name="UInt64Field">The UInt64Field parameter.</param>
        /// <param name="FloatField">The FloatField parameter.</param>
        /// <param name="DoubleField">The DoubleField parameter.</param>
        /// <param name="BinaryField">The BinaryField parameter.</param>
        /// <param name="StringField">The StringField parameter.</param>
        public BasicTestObject(
            com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject ObjectField,
            com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum EnumField,
            bool BoolField,
            byte ByteField,
            short Int16Field,
            ushort UInt16Field,
            int Int32Field,
            uint UInt32Field,
            long Int64Field,
            ulong UInt64Field,
            float FloatField,
            double DoubleField,
            byte[] BinaryField,
            string StringField)
        {
            this.ObjectField = ObjectField;
            this.EnumField = EnumField;
            this.BoolField = BoolField;
            this.ByteField = ByteField;
            this.Int16Field = Int16Field;
            this.UInt16Field = UInt16Field;
            this.Int32Field = Int32Field;
            this.UInt32Field = UInt32Field;
            this.Int64Field = Int64Field;
            this.UInt64Field = UInt64Field;
            this.FloatField = FloatField;
            this.DoubleField = DoubleField;
            this.BinaryField = BinaryField;
            this.StringField = StringField;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="BasicTestObject"/> class.
        /// </summary>
        /// <param name="reader">The ITeslaReader implementor.</param>
        public BasicTestObject(ITeslaReader reader)
        {
            this.Deserialize(reader);
        }
    
        /// <summary>
        /// Gets or sets the ObjectField field.
        /// </summary>
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject ObjectField { get; set; }
        
        /// <summary>
        /// Gets or sets the EnumField field.
        /// </summary>
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum EnumField { get; set; }
        
        /// <summary>
        /// Gets or sets the BoolField field.
        /// </summary>
        public bool BoolField { get; set; }
        
        /// <summary>
        /// Gets or sets the ByteField field.
        /// </summary>
        public byte ByteField { get; set; }
        
        /// <summary>
        /// Gets or sets the Int16Field field.
        /// </summary>
        public short Int16Field { get; set; }
        
        /// <summary>
        /// Gets or sets the UInt16Field field.
        /// </summary>
        public ushort UInt16Field { get; set; }
        
        /// <summary>
        /// Gets or sets the Int32Field field.
        /// </summary>
        public int Int32Field { get; set; }
        
        /// <summary>
        /// Gets or sets the UInt32Field field.
        /// </summary>
        public uint UInt32Field { get; set; }
        
        /// <summary>
        /// Gets or sets the Int64Field field.
        /// </summary>
        public long Int64Field { get; set; }
        
        /// <summary>
        /// Gets or sets the UInt64Field field.
        /// </summary>
        public ulong UInt64Field { get; set; }
        
        /// <summary>
        /// Gets or sets the FloatField field.
        /// </summary>
        public float FloatField { get; set; }
        
        /// <summary>
        /// Gets or sets the DoubleField field.
        /// </summary>
        public double DoubleField { get; set; }
        
        /// <summary>
        /// Gets or sets the BinaryField field.
        /// </summary>
        public byte[] BinaryField { get; set; }
        
        /// <summary>
        /// Gets or sets the StringField field.
        /// </summary>
        public string StringField { get; set; }
        

        /// <summary>
        /// Serializes the object.
        /// </summary>
        /// <param name="writer">The writer parameter.</param>
        public  void Serialize(ITeslaWriter writer)
        {
            writer.WriteObjectBegin("BasicTestObject");
            long schemaHash = writer.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaSerializationException("Schema hash is not set.");
            }
            else if (schemaHash == 7810441853185379917L) // version 1, teslacompiler all_types v1.0
            {
                writer.Write("ObjectField", this.ObjectField);
                writer.Write<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>("EnumField", this.EnumField);
                writer.Write("BoolField", this.BoolField);
                writer.Write("ByteField", this.ByteField);
                writer.Write("Int16Field", this.Int16Field);
                writer.Write("UInt16Field", this.UInt16Field);
                writer.Write("Int32Field", this.Int32Field);
                writer.Write("UInt32Field", this.UInt32Field);
                writer.Write("Int64Field", this.Int64Field);
                writer.Write("UInt64Field", this.UInt64Field);
                writer.Write("FloatField", this.FloatField);
                writer.Write("DoubleField", this.DoubleField);
                writer.Write("BinaryField", this.BinaryField);
                writer.Write("StringField", this.StringField);
            }
            else
            {
                throw new TeslaSerializationException("Unsupported schema version " + writer.getSchemaHash());
            }
            writer.WriteObjectEnd("BasicTestObject");
        }

        /// <summary>
        /// Deserializes the object.
        /// </summary>
        /// <param name="reader">The reader parameter.</param>
        public  void Deserialize(ITeslaReader reader)
        {
            reader.ReadObjectBegin("BasicTestObject");
            long schemaHash = reader.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaDeserializationException("Schema hash is not set.");
            }
            else if (schemaHash == 7810441853185379917L) // version 1, teslacompiler all_types v1.0
            {
                this.ObjectField =  reader.ReadObject<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>("ObjectField");
                this.EnumField =  reader.ReadEnum<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>("EnumField");
                this.BoolField =  reader.Readboolean("BoolField");
                this.ByteField =  reader.Readbyte("ByteField");
                this.Int16Field =  reader.Readint16("Int16Field");
                this.UInt16Field =  reader.Readuint16("UInt16Field");
                this.Int32Field =  reader.Readint32("Int32Field");
                this.UInt32Field =  reader.Readuint32("UInt32Field");
                this.Int64Field =  reader.Readint64("Int64Field");
                this.UInt64Field =  reader.Readuint64("UInt64Field");
                this.FloatField =  reader.Readfloat("FloatField");
                this.DoubleField =  reader.Readdouble("DoubleField");
                this.BinaryField =  reader.Readbinary("BinaryField");
                this.StringField =  reader.Readstring("StringField");
            }
            else
            {
                throw new TeslaDeserializationException("Unsupported schema version " + reader.getSchemaHash());
            }
            reader.ReadObjectEnd("BasicTestObject");
        }
    }
}
