

template <typename ReaderType>
void ArrayTestObject::deserialize(ReaderType& reader) {
    switch (reader.version().hash()) {

        case 7810441853185379917: // version 1, teslacompiler all_types v1.0
            reader.read(TeslaType_Array(), "ObjectArrayField", ObjectArrayField);
            reader.read(TeslaType_Array(), "EnumArrayField", EnumArrayField);
            reader.read(TeslaType_Array(), "BoolArrayField", BoolArrayField);
            reader.read(TeslaType_Array(), "ByteArrayField", ByteArrayField);
            reader.read(TeslaType_Array(), "Int16ArrayField", Int16ArrayField);
            reader.read(TeslaType_Array(), "UInt16ArrayField", UInt16ArrayField);
            reader.read(TeslaType_Array(), "Int32ArrayField", Int32ArrayField);
            reader.read(TeslaType_Array(), "UInt32ArrayField", UInt32ArrayField);
            reader.read(TeslaType_Array(), "Int64ArrayField", Int64ArrayField);
            reader.read(TeslaType_Array(), "UInt64ArrayField", UInt64ArrayField);
            reader.read(TeslaType_Array(), "FloatArrayField", FloatArrayField);
            reader.read(TeslaType_Array(), "DoubleArrayField", DoubleArrayField);
            reader.read(TeslaType_Array(), "StringArrayField", StringArrayField);
            break;
        
    default:
        break;
    }
}

template <typename WriterType>
void ArrayTestObject::serialize(WriterType& writer) const {
    switch (writer.version().hash()) {
        case 7810441853185379917: // version 1, teslacompiler all_types v1.0
            writer.write(TeslaType_Array(), "ObjectArrayField", ObjectArrayField);
            writer.write(TeslaType_Array(), "EnumArrayField", EnumArrayField);
            writer.write(TeslaType_Array(), "BoolArrayField", BoolArrayField);
            writer.write(TeslaType_Array(), "ByteArrayField", ByteArrayField);
            writer.write(TeslaType_Array(), "Int16ArrayField", Int16ArrayField);
            writer.write(TeslaType_Array(), "UInt16ArrayField", UInt16ArrayField);
            writer.write(TeslaType_Array(), "Int32ArrayField", Int32ArrayField);
            writer.write(TeslaType_Array(), "UInt32ArrayField", UInt32ArrayField);
            writer.write(TeslaType_Array(), "Int64ArrayField", Int64ArrayField);
            writer.write(TeslaType_Array(), "UInt64ArrayField", UInt64ArrayField);
            writer.write(TeslaType_Array(), "FloatArrayField", FloatArrayField);
            writer.write(TeslaType_Array(), "DoubleArrayField", DoubleArrayField);
            writer.write(TeslaType_Array(), "StringArrayField", StringArrayField);
            break;
        
    default:
        break;
    }
}
