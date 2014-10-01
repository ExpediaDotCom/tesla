/// <copyright file="OptionalBasicTestObject.cs" company="Expedia">
///      Copyright (c) 2013. Expedia. All rights reserved.
/// </copyright>
/// <summary>
///      The file contains the OptionalBasicTestObject class. 
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
    /// Implementation of the OptionalBasicTestObject class
    /// </summary>
    [Serializable]
    public class OptionalBasicTestObject :  ISerializable
    {
        /// <summary>
        /// Class Name.
        /// </summary>
        private const string ClassName = "OptionalBasicTestObject";

        /// <summary>
        /// Initializes a new instance of the <see cref="OptionalBasicTestObject"/> class.
        /// </summary>
        public OptionalBasicTestObject()
        {
        }
        
        /// <summary>
        /// Initializes a new instance of the <see cref="OptionalBasicTestObject"/> class.
        /// </summary>
        /// <param name="OptionalObjectField">The OptionalObjectField parameter.</param>
        /// <param name="OptionalEnumField">The OptionalEnumField parameter.</param>
        /// <param name="OptionalBoolField">The OptionalBoolField parameter.</param>
        /// <param name="OptionalByteField">The OptionalByteField parameter.</param>
        /// <param name="OptionalInt16Field">The OptionalInt16Field parameter.</param>
        /// <param name="OptionalUInt16Field">The OptionalUInt16Field parameter.</param>
        /// <param name="OptionalInt32Field">The OptionalInt32Field parameter.</param>
        /// <param name="OptionalUInt32Field">The OptionalUInt32Field parameter.</param>
        /// <param name="OptionalInt64Field">The OptionalInt64Field parameter.</param>
        /// <param name="OptionalUInt64Field">The OptionalUInt64Field parameter.</param>
        /// <param name="OptionalFloatField">The OptionalFloatField parameter.</param>
        /// <param name="OptionalDoubleField">The OptionalDoubleField parameter.</param>
        /// <param name="OptionalBinaryField">The OptionalBinaryField parameter.</param>
        /// <param name="OptionalStringField">The OptionalStringField parameter.</param>
        public OptionalBasicTestObject(
            com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject OptionalObjectField,
            com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum OptionalEnumField,
            bool OptionalBoolField,
            byte OptionalByteField,
            short OptionalInt16Field,
            ushort OptionalUInt16Field,
            int OptionalInt32Field,
            uint OptionalUInt32Field,
            long OptionalInt64Field,
            ulong OptionalUInt64Field,
            float OptionalFloatField,
            double OptionalDoubleField,
            byte[] OptionalBinaryField,
            string OptionalStringField)
        {
            this.OptionalObjectField = OptionalObjectField;
            this.OptionalEnumField = OptionalEnumField;
            this.OptionalBoolField = OptionalBoolField;
            this.OptionalByteField = OptionalByteField;
            this.OptionalInt16Field = OptionalInt16Field;
            this.OptionalUInt16Field = OptionalUInt16Field;
            this.OptionalInt32Field = OptionalInt32Field;
            this.OptionalUInt32Field = OptionalUInt32Field;
            this.OptionalInt64Field = OptionalInt64Field;
            this.OptionalUInt64Field = OptionalUInt64Field;
            this.OptionalFloatField = OptionalFloatField;
            this.OptionalDoubleField = OptionalDoubleField;
            this.OptionalBinaryField = OptionalBinaryField;
            this.OptionalStringField = OptionalStringField;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="OptionalBasicTestObject"/> class.
        /// </summary>
        /// <param name="reader">The ITeslaReader implementor.</param>
        public OptionalBasicTestObject(ITeslaReader reader)
        {
            this.Deserialize(reader);
        }
    
        /// <summary>
        /// Gets or sets the OptionalObjectField field.
        /// </summary>
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject OptionalObjectField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalEnumField field.
        /// </summary>
        public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum OptionalEnumField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalBoolField field.
        /// </summary>
        public bool OptionalBoolField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalByteField field.
        /// </summary>
        public byte OptionalByteField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalInt16Field field.
        /// </summary>
        public short OptionalInt16Field { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalUInt16Field field.
        /// </summary>
        public ushort OptionalUInt16Field { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalInt32Field field.
        /// </summary>
        public int OptionalInt32Field { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalUInt32Field field.
        /// </summary>
        public uint OptionalUInt32Field { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalInt64Field field.
        /// </summary>
        public long OptionalInt64Field { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalUInt64Field field.
        /// </summary>
        public ulong OptionalUInt64Field { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalFloatField field.
        /// </summary>
        public float OptionalFloatField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalDoubleField field.
        /// </summary>
        public double OptionalDoubleField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalBinaryField field.
        /// </summary>
        public byte[] OptionalBinaryField { get; set; }
        
        /// <summary>
        /// Gets or sets the OptionalStringField field.
        /// </summary>
        public string OptionalStringField { get; set; }
        

        /// <summary>
        /// Serializes the object.
        /// </summary>
        /// <param name="writer">The writer parameter.</param>
        public  void Serialize(ITeslaWriter writer)
        {
            writer.WriteObjectBegin("OptionalBasicTestObject");
            long schemaHash = writer.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaSerializationException("Schema hash is not set.");
            }
            else if (schemaHash == 7810441853185379917L) // version 1, teslacompiler all_types v1.0
            {
                writer.Write("OptionalObjectField", this.OptionalObjectField);
                writer.Write("OptionalEnumField", this.OptionalEnumField);
                writer.Write("OptionalBoolField", this.OptionalBoolField);
                writer.Write("OptionalByteField", this.OptionalByteField);
                writer.Write("OptionalInt16Field", this.OptionalInt16Field);
                writer.Write("OptionalUInt16Field", this.OptionalUInt16Field);
                writer.Write("OptionalInt32Field", this.OptionalInt32Field);
                writer.Write("OptionalUInt32Field", this.OptionalUInt32Field);
                writer.Write("OptionalInt64Field", this.OptionalInt64Field);
                writer.Write("OptionalUInt64Field", this.OptionalUInt64Field);
                writer.Write("OptionalFloatField", this.OptionalFloatField);
                writer.Write("OptionalDoubleField", this.OptionalDoubleField);
                writer.Write("OptionalBinaryField", this.OptionalBinaryField);
                writer.Write("OptionalStringField", this.OptionalStringField);
            }
            else
            {
                throw new TeslaSerializationException("Unsupported schema version " + writer.getSchemaHash());
            }
            writer.WriteObjectEnd("OptionalBasicTestObject");
        }

        /// <summary>
        /// Deserializes the object.
        /// </summary>
        /// <param name="reader">The reader parameter.</param>
        public  void Deserialize(ITeslaReader reader)
        {
            reader.ReadObjectBegin("OptionalBasicTestObject");
            long schemaHash = reader.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaDeserializationException("Schema hash is not set.");
            }
            else if (schemaHash == 7810441853185379917L) // version 1, teslacompiler all_types v1.0
            {
                this.OptionalObjectField =  reader.ReadObject<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>("OptionalObjectField");
                this.OptionalEnumField =  reader.ReadObject<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>("OptionalEnumField");
                this.OptionalBoolField =  reader.ReadObject<bool>("OptionalBoolField");
                this.OptionalByteField =  reader.ReadObject<byte>("OptionalByteField");
                this.OptionalInt16Field =  reader.ReadObject<short>("OptionalInt16Field");
                this.OptionalUInt16Field =  reader.ReadObject<ushort>("OptionalUInt16Field");
                this.OptionalInt32Field =  reader.ReadObject<int>("OptionalInt32Field");
                this.OptionalUInt32Field =  reader.ReadObject<uint>("OptionalUInt32Field");
                this.OptionalInt64Field =  reader.ReadObject<long>("OptionalInt64Field");
                this.OptionalUInt64Field =  reader.ReadObject<ulong>("OptionalUInt64Field");
                this.OptionalFloatField =  reader.ReadObject<float>("OptionalFloatField");
                this.OptionalDoubleField =  reader.ReadObject<double>("OptionalDoubleField");
                this.OptionalBinaryField =  reader.ReadObject<byte[]>("OptionalBinaryField");
                this.OptionalStringField =  reader.ReadObject<string>("OptionalStringField");
            }
            else
            {
                throw new TeslaDeserializationException("Unsupported schema version " + reader.getSchemaHash());
            }
            reader.ReadObjectEnd("OptionalBasicTestObject");
        }
    }
}
