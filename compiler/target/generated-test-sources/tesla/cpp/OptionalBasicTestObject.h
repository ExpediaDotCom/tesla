

template <typename ReaderType>
void OptionalBasicTestObject::deserialize(ReaderType& reader) {
    switch (reader.version().hash()) {

        case 7810441853185379917: // version 1, teslacompiler all_types v1.0
            reader.read(TeslaType_Nullable(), "OptionalObjectField", OptionalObjectField);
            reader.read(TeslaType_Nullable(), "OptionalEnumField", OptionalEnumField);
            reader.read(TeslaType_Nullable(), "OptionalBoolField", OptionalBoolField);
            reader.read(TeslaType_Nullable(), "OptionalByteField", OptionalByteField);
            reader.read(TeslaType_Nullable(), "OptionalInt16Field", OptionalInt16Field);
            reader.read(TeslaType_Nullable(), "OptionalUInt16Field", OptionalUInt16Field);
            reader.read(TeslaType_Nullable(), "OptionalInt32Field", OptionalInt32Field);
            reader.read(TeslaType_Nullable(), "OptionalUInt32Field", OptionalUInt32Field);
            reader.read(TeslaType_Nullable(), "OptionalInt64Field", OptionalInt64Field);
            reader.read(TeslaType_Nullable(), "OptionalUInt64Field", OptionalUInt64Field);
            reader.read(TeslaType_Nullable(), "OptionalFloatField", OptionalFloatField);
            reader.read(TeslaType_Nullable(), "OptionalDoubleField", OptionalDoubleField);
            reader.read(TeslaType_Nullable(), "OptionalBinaryField", OptionalBinaryField);
            reader.read(TeslaType_Nullable(), "OptionalStringField", OptionalStringField);
            break;
        
    default:
        break;
    }
}

template <typename WriterType>
void OptionalBasicTestObject::serialize(WriterType& writer) const {
    switch (writer.version().hash()) {
        case 7810441853185379917: // version 1, teslacompiler all_types v1.0
            writer.write(TeslaType_Nullable(), "OptionalObjectField", OptionalObjectField);
            writer.write(TeslaType_Nullable(), "OptionalEnumField", OptionalEnumField);
            writer.write(TeslaType_Nullable(), "OptionalBoolField", OptionalBoolField);
            writer.write(TeslaType_Nullable(), "OptionalByteField", OptionalByteField);
            writer.write(TeslaType_Nullable(), "OptionalInt16Field", OptionalInt16Field);
            writer.write(TeslaType_Nullable(), "OptionalUInt16Field", OptionalUInt16Field);
            writer.write(TeslaType_Nullable(), "OptionalInt32Field", OptionalInt32Field);
            writer.write(TeslaType_Nullable(), "OptionalUInt32Field", OptionalUInt32Field);
            writer.write(TeslaType_Nullable(), "OptionalInt64Field", OptionalInt64Field);
            writer.write(TeslaType_Nullable(), "OptionalUInt64Field", OptionalUInt64Field);
            writer.write(TeslaType_Nullable(), "OptionalFloatField", OptionalFloatField);
            writer.write(TeslaType_Nullable(), "OptionalDoubleField", OptionalDoubleField);
            writer.write(TeslaType_Nullable(), "OptionalBinaryField", OptionalBinaryField);
            writer.write(TeslaType_Nullable(), "OptionalStringField", OptionalStringField);
            break;
        
    default:
        break;
    }
}
