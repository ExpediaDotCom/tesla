/// <copyright file="OptionalArrayTestObject.cs" company="Expedia">
///      Copyright (c) 2013. Expedia. All rights reserved.
/// </copyright>
/// <summary>
///      The file contains the OptionalArrayTestObject class. 
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
    /// Implementation of the OptionalArrayTestObject class
    /// </summary>
    [Serializable]
    public class OptionalArrayTestObject :  ISerializable
    {
        /// <summary>
        /// Class Name.
        /// </summary>
        private const string ClassName = "OptionalArrayTestObject";

        /// <summary>
        /// Initializes a new instance of the <see cref="OptionalArrayTestObject"/> class.
        /// </summary>
        public OptionalArrayTestObject()
        {
        }
        
        /// <summary>
        /// Initializes a new instance of the <see cref="OptionalArrayTestObject"/> class.
        /// </summary>
        /// <param name="OptionalObjectArrayField">The OptionalObjectArrayField parameter.</param>
        /// <param name="OptionalEnumArrayField">The OptionalEnumArrayField parameter.</param>
        /// <param name="OptionalBoolArrayField">The OptionalBoolArrayField parameter.</param>
        /// <param name="OptionalByteArrayField">The OptionalByteArrayField parameter.</param>
        /// <param name="OptionalInt16ArrayField">The OptionalInt16ArrayField parameter.</param>
        /// <param name="OptionalUInt16ArrayField">The OptionalUInt16ArrayField parameter.</param>
        /// <param name="OptionalInt32ArrayField">The OptionalInt32ArrayField parameter.</param>
        /// <param name="OptionalUInt32ArrayField">The OptionalUInt32ArrayField parameter.</param>
        /// <param name="OptionalInt64ArrayField">The OptionalInt64ArrayField parameter.</param>
        /// <param name="OptionalUInt64ArrayField">The OptionalUInt64ArrayField parameter.</param>
        /// <param name="OptionalFloatArrayField">The OptionalFloatArrayField parameter.</param>
        /// <param name="OptionalDoubleArrayField">The OptionalDoubleArrayField parameter.</param>
        /// <param name="OptionalStringArrayField">The OptionalStringArrayField parameter.</param>
        public OptionalArrayTestObject(
            com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject OptionalObjectArrayField,
            com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum OptionalEnumArrayField,
            bool OptionalBoolArrayField,
            byte OptionalByteArrayField,
            short OptionalInt16ArrayField,
            ushort OptionalUInt16ArrayField,
            int OptionalInt32ArrayField,
            uint OptionalUInt32ArrayField,
            long OptionalInt64ArrayField,
            ulong OptionalUInt64ArrayField,
            float OptionalFloatArrayField,
            double OptionalDoubleArrayField,
            string OptionalStringArrayField)
        {
            this.OptionalObjectArrayField = OptionalObjectArrayField;
            this.OptionalEnumArrayField = OptionalEnumArrayField;
            this.OptionalBoolArrayField = OptionalBoolArrayField;
            this.OptionalByteArrayField = OptionalByteArrayField;
            this.OptionalInt16ArrayField = OptionalInt16ArrayField;
            this.OptionalUInt16ArrayField = OptionalUInt16ArrayField;
            this.OptionalInt32ArrayField = OptionalInt32ArrayField;
            this.OptionalUInt32ArrayField = OptionalUInt32ArrayField;
            this.OptionalInt64ArrayField = OptionalInt64ArrayField;
            this.OptionalUInt64ArrayField = OptionalUInt64ArrayField;
            this.OptionalFloatArrayField = OptionalFloatArrayField;
            this.OptionalDoubleArrayField = OptionalDoubleArrayField;
            this.OptionalStringArrayField = OptionalStringArrayField;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="OptionalArrayTestObject"/> class.
        /// </summary>
        /// <param name="reader">The ITeslaReader implementor.</param>
        public OptionalArrayTestObject(ITeslaReader reader)
        {
            this.Deserialize(reader);
        }
    
        /// <summary>
        /// Gets or sets the OptionalObjectArrayField field.
        /// </summary>
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject OptionalObjectArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalEnumArrayField field.
        /// </summary>
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum OptionalEnumArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalBoolArrayField field.
        /// </summary>
        public bool OptionalBoolArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalByteArrayField field.
        /// </summary>
        public byte OptionalByteArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalInt16ArrayField field.
        /// </summary>
        public short OptionalInt16ArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalUInt16ArrayField field.
        /// </summary>
        public ushort OptionalUInt16ArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalInt32ArrayField field.
        /// </summary>
        public int OptionalInt32ArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalUInt32ArrayField field.
        /// </summary>
        public uint OptionalUInt32ArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalInt64ArrayField field.
        /// </summary>
        public long OptionalInt64ArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalUInt64ArrayField field.
        /// </summary>
        public ulong OptionalUInt64ArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalFloatArrayField field.
        /// </summary>
        public float OptionalFloatArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalDoubleArrayField field.
        /// </summary>
        public double OptionalDoubleArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalStringArrayField field.
        /// </summary>
        public string OptionalStringArrayField { get; set; }
        

        /// <summary>
        /// Serializes the object.
        /// </summary>
        /// <param name="writer">The writer parameter.</param>
        public  void Serialize(ITeslaWriter writer)
        {
            writer.WriteObjectBegin("OptionalArrayTestObject");
            long schemaHash = writer.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaSerializationException("Schema hash is not set.");
            }
            else if (schemaHash == 7810441853185379917L) // version 1, teslacompiler all_types v1.0
            {
                writer.Write("OptionalObjectArrayField", this.OptionalObjectArrayField);
                writer.Write("OptionalEnumArrayField", this.OptionalEnumArrayField);
                writer.Write("OptionalBoolArrayField", this.OptionalBoolArrayField);
                writer.Write("OptionalByteArrayField", this.OptionalByteArrayField);
                writer.Write("OptionalInt16ArrayField", this.OptionalInt16ArrayField);
                writer.Write("OptionalUInt16ArrayField", this.OptionalUInt16ArrayField);
                writer.Write("OptionalInt32ArrayField", this.OptionalInt32ArrayField);
                writer.Write("OptionalUInt32ArrayField", this.OptionalUInt32ArrayField);
                writer.Write("OptionalInt64ArrayField", this.OptionalInt64ArrayField);
                writer.Write("OptionalUInt64ArrayField", this.OptionalUInt64ArrayField);
                writer.Write("OptionalFloatArrayField", this.OptionalFloatArrayField);
                writer.Write("OptionalDoubleArrayField", this.OptionalDoubleArrayField);
                writer.Write("OptionalStringArrayField", this.OptionalStringArrayField);
            }
            else
            {
                throw new TeslaSerializationException("Unsupported schema version " + writer.getSchemaHash());
            }
            writer.WriteObjectEnd("OptionalArrayTestObject");
        }

        /// <summary>
        /// Deserializes the object.
        /// </summary>
        /// <param name="reader">The reader parameter.</param>
        public  void Deserialize(ITeslaReader reader)
        {
            reader.ReadObjectBegin("OptionalArrayTestObject");
            long schemaHash = reader.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaDeserializationException("Schema hash is not set.");
            }
            else if (schemaHash == 7810441853185379917L) // version 1, teslacompiler all_types v1.0
            {
                this.OptionalObjectArrayField =  reader.ReadObject<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>("OptionalObjectArrayField");
                this.OptionalEnumArrayField =  reader.ReadObject<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>("OptionalEnumArrayField");
                this.OptionalBoolArrayField =  reader.ReadObject<bool>("OptionalBoolArrayField");
                this.OptionalByteArrayField =  reader.ReadObject<byte>("OptionalByteArrayField");
                this.OptionalInt16ArrayField =  reader.ReadObject<short>("OptionalInt16ArrayField");
                this.OptionalUInt16ArrayField =  reader.ReadObject<ushort>("OptionalUInt16ArrayField");
                this.OptionalInt32ArrayField =  reader.ReadObject<int>("OptionalInt32ArrayField");
                this.OptionalUInt32ArrayField =  reader.ReadObject<uint>("OptionalUInt32ArrayField");
                this.OptionalInt64ArrayField =  reader.ReadObject<long>("OptionalInt64ArrayField");
                this.OptionalUInt64ArrayField =  reader.ReadObject<ulong>("OptionalUInt64ArrayField");
                this.OptionalFloatArrayField =  reader.ReadObject<float>("OptionalFloatArrayField");
                this.OptionalDoubleArrayField =  reader.ReadObject<double>("OptionalDoubleArrayField");
                this.OptionalStringArrayField =  reader.ReadObject<string>("OptionalStringArrayField");
            }
            else
            {
                throw new TeslaDeserializationException("Unsupported schema version " + reader.getSchemaHash());
            }
            reader.ReadObjectEnd("OptionalArrayTestObject");
        }
    }
}
