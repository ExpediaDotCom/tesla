/// <copyright file="Array2DTestObject.cs" company="Expedia">
///      Copyright (c) 2013. Expedia. All rights reserved.
/// </copyright>
/// <summary>
///      The file contains the Array2DTestObject class. 
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
    /// Implementation of the Array2DTestObject class
    /// </summary>
    [Serializable]
    public class Array2DTestObject :  ISerializable
    {
        /// <summary>
        /// Class Name.
        /// </summary>
        private const string ClassName = "Array2DTestObject";

        /// <summary>
        /// Initializes a new instance of the <see cref="Array2DTestObject"/> class.
        /// </summary>
        public Array2DTestObject()
        {
        }
        
        /// <summary>
        /// Initializes a new instance of the <see cref="Array2DTestObject"/> class.
        /// </summary>
        /// <param name="Object2DArrayField">The Object2DArrayField parameter.</param>
        /// <param name="Enum2DArrayField">The Enum2DArrayField parameter.</param>
        /// <param name="Bool2DArrayField">The Bool2DArrayField parameter.</param>
        /// <param name="Byte2DArrayField">The Byte2DArrayField parameter.</param>
        /// <param name="Int162DArrayField">The Int162DArrayField parameter.</param>
        /// <param name="UInt162DArrayField">The UInt162DArrayField parameter.</param>
        /// <param name="Int322DArrayField">The Int322DArrayField parameter.</param>
        /// <param name="UInt322DArrayField">The UInt322DArrayField parameter.</param>
        /// <param name="Int642DArrayField">The Int642DArrayField parameter.</param>
        /// <param name="UInt642DArrayField">The UInt642DArrayField parameter.</param>
        /// <param name="Float2DArrayField">The Float2DArrayField parameter.</param>
        /// <param name="Double2DArrayField">The Double2DArrayField parameter.</param>
        /// <param name="String2DArrayField">The String2DArrayField parameter.</param>
        public Array2DTestObject(
            List<List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>> Object2DArrayField,
            List<List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>> Enum2DArrayField,
            List<List<bool>> Bool2DArrayField,
            List<List<byte>> Byte2DArrayField,
            List<List<short>> Int162DArrayField,
            List<List<ushort>> UInt162DArrayField,
            List<List<int>> Int322DArrayField,
            List<List<uint>> UInt322DArrayField,
            List<List<long>> Int642DArrayField,
            List<List<ulong>> UInt642DArrayField,
            List<List<float>> Float2DArrayField,
            List<List<double>> Double2DArrayField,
            List<List<string>> String2DArrayField)
        {
            this.Object2DArrayField = Object2DArrayField;
            this.Enum2DArrayField = Enum2DArrayField;
            this.Bool2DArrayField = Bool2DArrayField;
            this.Byte2DArrayField = Byte2DArrayField;
            this.Int162DArrayField = Int162DArrayField;
            this.UInt162DArrayField = UInt162DArrayField;
            this.Int322DArrayField = Int322DArrayField;
            this.UInt322DArrayField = UInt322DArrayField;
            this.Int642DArrayField = Int642DArrayField;
            this.UInt642DArrayField = UInt642DArrayField;
            this.Float2DArrayField = Float2DArrayField;
            this.Double2DArrayField = Double2DArrayField;
            this.String2DArrayField = String2DArrayField;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="Array2DTestObject"/> class.
        /// </summary>
        /// <param name="reader">The ITeslaReader implementor.</param>
        public Array2DTestObject(ITeslaReader reader)
        {
            this.Deserialize(reader);
        }
    
        /// <summary>
        /// Gets or sets the Object2DArrayField field.
        /// </summary>
        public List<List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>> Object2DArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the Enum2DArrayField field.
        /// </summary>
        public List<List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>> Enum2DArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the Bool2DArrayField field.
        /// </summary>
        public List<List<bool>> Bool2DArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the Byte2DArrayField field.
        /// </summary>
        public List<List<byte>> Byte2DArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the Int162DArrayField field.
        /// </summary>
        public List<List<short>> Int162DArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the UInt162DArrayField field.
        /// </summary>
        public List<List<ushort>> UInt162DArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the Int322DArrayField field.
        /// </summary>
        public List<List<int>> Int322DArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the UInt322DArrayField field.
        /// </summary>
        public List<List<uint>> UInt322DArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the Int642DArrayField field.
        /// </summary>
        public List<List<long>> Int642DArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the UInt642DArrayField field.
        /// </summary>
        public List<List<ulong>> UInt642DArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the Float2DArrayField field.
        /// </summary>
        public List<List<float>> Float2DArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the Double2DArrayField field.
        /// </summary>
        public List<List<double>> Double2DArrayField { get; set; }
        
        /// <summary>
        /// Gets or sets the String2DArrayField field.
        /// </summary>
        public List<List<string>> String2DArrayField { get; set; }
        

        /// <summary>
        /// Serializes the object.
        /// </summary>
        /// <param name="writer">The writer parameter.</param>
        public  void Serialize(ITeslaWriter writer)
        {
            writer.WriteObjectBegin("Array2DTestObject");
            long schemaHash = writer.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaSerializationException("Schema hash is not set.");
            }
            else if (schemaHash == 7810441853185379917L) // version 1, teslacompiler all_types v1.0
            {
                writer.WriteObjectArray<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>("Object2DArrayField", this.Object2DArrayField, false, 2);
                writer.WriteObjectArray<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>("Enum2DArrayField", this.Enum2DArrayField, false, 2);
                writer.WriteObjectArray<bool>("Bool2DArrayField", this.Bool2DArrayField, false, 2);
                writer.WriteObjectArray<byte>("Byte2DArrayField", this.Byte2DArrayField, false, 2);
                writer.WriteObjectArray<short>("Int162DArrayField", this.Int162DArrayField, false, 2);
                writer.WriteObjectArray<ushort>("UInt162DArrayField", this.UInt162DArrayField, false, 2);
                writer.WriteObjectArray<int>("Int322DArrayField", this.Int322DArrayField, false, 2);
                writer.WriteObjectArray<uint>("UInt322DArrayField", this.UInt322DArrayField, false, 2);
                writer.WriteObjectArray<long>("Int642DArrayField", this.Int642DArrayField, false, 2);
                writer.WriteObjectArray<ulong>("UInt642DArrayField", this.UInt642DArrayField, false, 2);
                writer.WriteObjectArray<float>("Float2DArrayField", this.Float2DArrayField, false, 2);
                writer.WriteObjectArray<double>("Double2DArrayField", this.Double2DArrayField, false, 2);
                writer.WriteObjectArray<string>("String2DArrayField", this.String2DArrayField, false, 2);
            }
            else
            {
                throw new TeslaSerializationException("Unsupported schema version " + writer.getSchemaHash());
            }
            writer.WriteObjectEnd("Array2DTestObject");
        }

        /// <summary>
        /// Deserializes the object.
        /// </summary>
        /// <param name="reader">The reader parameter.</param>
        public  void Deserialize(ITeslaReader reader)
        {
            reader.ReadObjectBegin("Array2DTestObject");
            long schemaHash = reader.getSchemaHash();
            if (schemaHash == 0)
            {
                throw new TeslaDeserializationException("Schema hash is not set.");
            }
            else if (schemaHash == 7810441853185379917L) // version 1, teslacompiler all_types v1.0
            {
                this.Object2DArrayField = (List<List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>>) reader.ReadObjectArray<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject>("Object2DArrayField", false, 2);
                this.Enum2DArrayField = (List<List<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>>) reader.ReadObjectArray<com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum>("Enum2DArrayField", false, 2);
                this.Bool2DArrayField = (List<List<bool>>) reader.ReadObjectArray<bool>("Bool2DArrayField", false, 2);
                this.Byte2DArrayField = (List<List<byte>>) reader.ReadObjectArray<byte>("Byte2DArrayField", false, 2);
                this.Int162DArrayField = (List<List<short>>) reader.ReadObjectArray<short>("Int162DArrayField", false, 2);
                this.UInt162DArrayField = (List<List<ushort>>) reader.ReadObjectArray<ushort>("UInt162DArrayField", false, 2);
                this.Int322DArrayField = (List<List<int>>) reader.ReadObjectArray<int>("Int322DArrayField", false, 2);
                this.UInt322DArrayField = (List<List<uint>>) reader.ReadObjectArray<uint>("UInt322DArrayField", false, 2);
                this.Int642DArrayField = (List<List<long>>) reader.ReadObjectArray<long>("Int642DArrayField", false, 2);
                this.UInt642DArrayField = (List<List<ulong>>) reader.ReadObjectArray<ulong>("UInt642DArrayField", false, 2);
                this.Float2DArrayField = (List<List<float>>) reader.ReadObjectArray<float>("Float2DArrayField", false, 2);
                this.Double2DArrayField = (List<List<double>>) reader.ReadObjectArray<double>("Double2DArrayField", false, 2);
                this.String2DArrayField = (List<List<string>>) reader.ReadObjectArray<string>("String2DArrayField", false, 2);
            }
            else
            {
                throw new TeslaDeserializationException("Unsupported schema version " + reader.getSchemaHash());
            }
            reader.ReadObjectEnd("Array2DTestObject");
        }
    }
}
