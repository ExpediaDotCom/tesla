

template <typename ReaderType>
void ReferenceTestObject::deserialize(ReaderType& reader) {
    switch (reader.version().hash()) {

        case 7810441853185379917: // version 1, teslacompiler all_types v1.0
            reader.read(TeslaType_Reference(), "ObjectReferenceField", ObjectReferenceField);
            reader.read(TeslaType_Reference(), "EnumReferenceField", EnumReferenceField);
            reader.read(TeslaType_Reference(), "BoolReferenceField", BoolReferenceField);
            reader.read(TeslaType_Reference(), "ByteReferenceField", ByteReferenceField);
            reader.read(TeslaType_Reference(), "Int16ReferenceField", Int16ReferenceField);
            reader.read(TeslaType_Reference(), "UInt16ReferenceField", UInt16ReferenceField);
            reader.read(TeslaType_Reference(), "Int32ReferenceField", Int32ReferenceField);
            reader.read(TeslaType_Reference(), "UInt32ReferenceField", UInt32ReferenceField);
            reader.read(TeslaType_Reference(), "Int64ReferenceField", Int64ReferenceField);
            reader.read(TeslaType_Reference(), "UInt64ReferenceField", UInt64ReferenceField);
            reader.read(TeslaType_Reference(), "FloatReferenceField", FloatReferenceField);
            reader.read(TeslaType_Reference(), "DoubleReferenceField", DoubleReferenceField);
            reader.read(TeslaType_Reference(), "BinaryReferenceField", BinaryReferenceField);
            reader.read(TeslaType_Reference(), "StringReferenceField", StringReferenceField);
            break;
        
    default:
        break;
    }
}

template <typename WriterType>
void ReferenceTestObject::serialize(WriterType& writer) const {
    switch (writer.version().hash()) {
        case 7810441853185379917: // version 1, teslacompiler all_types v1.0
            writer.write(TeslaType_Reference(), "ObjectReferenceField", ObjectReferenceField);
            writer.write(TeslaType_Reference(), "EnumReferenceField", EnumReferenceField);
            writer.write(TeslaType_Reference(), "BoolReferenceField", BoolReferenceField);
            writer.write(TeslaType_Reference(), "ByteReferenceField", ByteReferenceField);
            writer.write(TeslaType_Reference(), "Int16ReferenceField", Int16ReferenceField);
            writer.write(TeslaType_Reference(), "UInt16ReferenceField", UInt16ReferenceField);
            writer.write(TeslaType_Reference(), "Int32ReferenceField", Int32ReferenceField);
            writer.write(TeslaType_Reference(), "UInt32ReferenceField", UInt32ReferenceField);
            writer.write(TeslaType_Reference(), "Int64ReferenceField", Int64ReferenceField);
            writer.write(TeslaType_Reference(), "UInt64ReferenceField", UInt64ReferenceField);
            writer.write(TeslaType_Reference(), "FloatReferenceField", FloatReferenceField);
            writer.write(TeslaType_Reference(), "DoubleReferenceField", DoubleReferenceField);
            writer.write(TeslaType_Reference(), "BinaryReferenceField", BinaryReferenceField);
            writer.write(TeslaType_Reference(), "StringReferenceField", StringReferenceField);
            break;
        
    default:
        break;
    }
}
