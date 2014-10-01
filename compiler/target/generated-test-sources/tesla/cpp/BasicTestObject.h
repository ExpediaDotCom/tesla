

template <typename ReaderType>
void BasicTestObject::deserialize(ReaderType& reader) {
    switch (reader.version().hash()) {

        case 7810441853185379917: // version 1, teslacompiler all_types v1.0
            reader.read(TeslaType_Object(), "ObjectField", ObjectField);
            reader.read(TeslaType_Enum(), "EnumField", EnumField);
            reader.read(TeslaType_boolean(), "BoolField", BoolField);
            reader.read(TeslaType_byte(), "ByteField", ByteField);
            reader.read(TeslaType_int16(), "Int16Field", Int16Field);
            reader.read(TeslaType_uint16(), "UInt16Field", UInt16Field);
            reader.read(TeslaType_int32(), "Int32Field", Int32Field);
            reader.read(TeslaType_uint32(), "UInt32Field", UInt32Field);
            reader.read(TeslaType_int64(), "Int64Field", Int64Field);
            reader.read(TeslaType_uint64(), "UInt64Field", UInt64Field);
            reader.read(TeslaType_float(), "FloatField", FloatField);
            reader.read(TeslaType_double(), "DoubleField", DoubleField);
            reader.read(TeslaType_binary(), "BinaryField", BinaryField);
            reader.read(TeslaType_string(), "StringField", StringField);
            break;
        
    default:
        break;
    }
}

template <typename WriterType>
void BasicTestObject::serialize(WriterType& writer) const {
    switch (writer.version().hash()) {
        case 7810441853185379917: // version 1, teslacompiler all_types v1.0
            writer.write(TeslaType_Object(), "ObjectField", ObjectField);
            writer.write(TeslaType_Enum(), "EnumField", EnumField);
            writer.write(TeslaType_boolean(), "BoolField", BoolField);
            writer.write(TeslaType_byte(), "ByteField", ByteField);
            writer.write(TeslaType_int16(), "Int16Field", Int16Field);
            writer.write(TeslaType_uint16(), "UInt16Field", UInt16Field);
            writer.write(TeslaType_int32(), "Int32Field", Int32Field);
            writer.write(TeslaType_uint32(), "UInt32Field", UInt32Field);
            writer.write(TeslaType_int64(), "Int64Field", Int64Field);
            writer.write(TeslaType_uint64(), "UInt64Field", UInt64Field);
            writer.write(TeslaType_float(), "FloatField", FloatField);
            writer.write(TeslaType_double(), "DoubleField", DoubleField);
            writer.write(TeslaType_binary(), "BinaryField", BinaryField);
            writer.write(TeslaType_string(), "StringField", StringField);
            break;
        
    default:
        break;
    }
}
