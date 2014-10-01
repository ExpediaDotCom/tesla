/// <copyright file="ArrayTestObject.cs" company="Expedia">
///      Copyright (c) 2013. Expedia. All rights reserved.
/// </copyright>
/// <summary>
///      The file contains the ArrayTestObject class. 
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
    /// Implementation of the ArrayTestObject class
    /// </summary>
    [Serializable]
    public class ArrayTestObject :  ISerializable
    {
        /// <summary>
        /// Class Name.
        /// </summary>
        private const string ClassName = "ArrayTestObject";

        /// <summary>
        /// Initializes a new instance of the <see cref="ArrayTestObject"/> class.
        /// </summary>
        public ArrayTestObject()
        {
        }
        
        /// <summary>
        /// Initializes a new instance of the <see cref="ArrayTestObject"/> class.
        /// </summary>
        /// <param name="ObjectArrayField">The ObjectArrayField parameter.</param>
        /// <param name="EnumArrayField">The EnumArrayField parameter.</param>
        /// <param name="BoolArrayField">The BoolArrayField parameter.</param>
        /// <param name="ByteArrayField">The ByteArrayField parameter.</param>
        /// <param name="Int16ArrayField">The Int16ArrayField parameter.</param>
        /// <param name="UInt16ArrayField">The UInt16ArrayField parameter.</param>
        /// <param name="Int32ArrayField">The Int32ArrayField parameter.</param>
        /// <param name="UInt32ArrayField">The UInt32ArrayField parameter.</param>
        /// <param name="Int64ArrayField">The Int64ArrayField parameter.</param>
        /// <param name="UInt64ArrayField">The UInt64ArrayField parameter.</param>
        /// <param name="FloatArrayField">The FloatArrayField parameter.</param>
        /// <param name="DoubleArrayField">The DoubleArrayField parameter.</param>
        /// <param name="StringArrayField">The StringArrayField parameter.</param>
        public ArrayTestObject(
            List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> ObjectArrayField,
            List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> EnumArrayField,
            List<bool> BoolArrayField,
            List<byte> ByteArrayField,
            List<short> Int16ArrayField,
            List<ushort> UInt16ArrayField,
            List<int> Int32ArrayField,
            List<uint> UInt32ArrayField,
            List<long> Int64ArrayField,
            List<ulong> UInt64ArrayField,
            List<float> FloatArrayField,
            List<double> DoubleArrayField,
            List<string> StringArrayField)
        {
            this.ObjectArrayField = ObjectArrayField;
            this.EnumArrayField = EnumArrayField;
            this.BoolArrayField = BoolArrayField;
            this.ByteArrayField = ByteArrayField;
            this.Int16ArrayField = Int16ArrayField;
            this.UInt16ArrayField = UInt16ArrayField;
            this.Int32ArrayField = Int32ArrayField;
            this.UInt32ArrayField = UInt32ArrayField;
            this.Int64ArrayField = Int64ArrayField;
            this.UInt64ArrayField = UInt64ArrayField;
            this.FloatArrayField = FloatArrayField;
            this.DoubleArrayField = DoubleArrayField;
            this.StringArrayField = StringArrayField;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="ArrayTestObject"/> class.
        /// </summary>
        /// <param name="reader">The ITeslaReader implementor.</param>
        public ArrayTestObject(ITeslaReader reader)
        {
            this.Deserialize(reader);
        }
    
        /// <summary>
        /// Gets or sets the ObjectArrayField field.
        /// </summary>
        public List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject> ObjectArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the EnumArrayField field.
        /// </summary>
        public List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum> EnumArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the BoolArrayField field.
        /// </summary>
        public List<bool> BoolArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the ByteArrayField field.
        /// </summary>
        public List<byte> ByteArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the Int16ArrayField field.
        /// </summary>
        public List<short> Int16ArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the UInt16ArrayField field.
        /// </summary>
        public List<ushort> UInt16ArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the Int32ArrayField field.
        /// </summary>
        public List<int> Int32ArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the UInt32ArrayField field.
        /// </summary>
        public List<uint> UInt32ArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the Int64ArrayField field.
        /// </summary>
        public List<long> Int64ArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the UInt64ArrayField field.
        /// </summary>
        public List<ulong> UInt64ArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the FloatArrayField field.
        /// </summary>
        public List<float> FloatArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the DoubleArrayField field.
        /// </summary>
        public List<double> DoubleArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the StringArrayField field.
        /// </summary>
        public List<string> StringArrayField { get; set; }
        

        /// <summary>
        /// Serializes the object.
        /// </summary>
        /// <param name="writer">The writer parameter.</param>
        public  void Serialize(ITeslaWriter writer)
        {
            writer.WriteObjectBegin("ArrayTestObject");
            long schemaHash = writer.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaSerializationException("Schema hash is not set.");
            }
            else if (schemaHash == 7810441853185379917L) // version 1, teslacompiler all_types v1.0
            {
                writer.WriteObjectArray<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>("ObjectArrayField", this.ObjectArrayField, false, 1);
                writer.WriteObjectArray<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>("EnumArrayField", this.EnumArrayField, false, 1);
                writer.WriteObjectArray<bool>("BoolArrayField", this.BoolArrayField, false, 1);
                writer.WriteObjectArray<byte>("ByteArrayField", this.ByteArrayField, false, 1);
                writer.WriteObjectArray<short>("Int16ArrayField", this.Int16ArrayField, false, 1);
                writer.WriteObjectArray<ushort>("UInt16ArrayField", this.UInt16ArrayField, false, 1);
                writer.WriteObjectArray<int>("Int32ArrayField", this.Int32ArrayField, false, 1);
                writer.WriteObjectArray<uint>("UInt32ArrayField", this.UInt32ArrayField, false, 1);
                writer.WriteObjectArray<long>("Int64ArrayField", this.Int64ArrayField, false, 1);
                writer.WriteObjectArray<ulong>("UInt64ArrayField", this.UInt64ArrayField, false, 1);
                writer.WriteObjectArray<float>("FloatArrayField", this.FloatArrayField, false, 1);
                writer.WriteObjectArray<double>("DoubleArrayField", this.DoubleArrayField, false, 1);
                writer.WriteObjectArray<string>("StringArrayField", this.StringArrayField, false, 1);
            }
            else
            {
                throw new TeslaSerializationException("Unsupported schema version " + writer.getSchemaHash());
            }
            writer.WriteObjectEnd("ArrayTestObject");
        }

        /// <summary>
        /// Deserializes the object.
        /// </summary>
        /// <param name="reader">The reader parameter.</param>
        public  void Deserialize(ITeslaReader reader)
        {
            reader.ReadObjectBegin("ArrayTestObject");
            long schemaHash = reader.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaDeserializationException("Schema hash is not set.");
            }
            else if (schemaHash == 7810441853185379917L) // version 1, teslacompiler all_types v1.0
            {
                this.ObjectArrayField = (List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>) reader.ReadObjectArray<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>("ObjectArrayField", false, 1);
                this.EnumArrayField = (List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>) reader.ReadObjectArray<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>("EnumArrayField", false, 1);
                this.BoolArrayField = (List<bool>) reader.ReadObjectArray<bool>("BoolArrayField", false, 1);
                this.ByteArrayField = (List<byte>) reader.ReadObjectArray<byte>("ByteArrayField", false, 1);
                this.Int16ArrayField = (List<short>) reader.ReadObjectArray<short>("Int16ArrayField", false, 1);
                this.UInt16ArrayField = (List<ushort>) reader.ReadObjectArray<ushort>("UInt16ArrayField", false, 1);
                this.Int32ArrayField = (List<int>) reader.ReadObjectArray<int>("Int32ArrayField", false, 1);
                this.UInt32ArrayField = (List<uint>) reader.ReadObjectArray<uint>("UInt32ArrayField", false, 1);
                this.Int64ArrayField = (List<long>) reader.ReadObjectArray<long>("Int64ArrayField", false, 1);
                this.UInt64ArrayField = (List<ulong>) reader.ReadObjectArray<ulong>("UInt64ArrayField", false, 1);
                this.FloatArrayField = (List<float>) reader.ReadObjectArray<float>("FloatArrayField", false, 1);
                this.DoubleArrayField = (List<double>) reader.ReadObjectArray<double>("DoubleArrayField", false, 1);
                this.StringArrayField = (List<string>) reader.ReadObjectArray<string>("StringArrayField", false, 1);
            }
            else
            {
                throw new TeslaDeserializationException("Unsupported schema version " + reader.getSchemaHash());
            }
            reader.ReadObjectEnd("ArrayTestObject");
        }
    }
}
