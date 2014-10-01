

template <typename ReaderType>
void OptionalArrayTestObject::deserialize(ReaderType& reader) {
    switch (reader.version().hash()) {

        case 7810441853185379917: // version 1, teslacompiler all_types v1.0
            reader.read(TeslaType_Nullable(), "OptionalObjectArrayField", OptionalObjectArrayField);
            reader.read(TeslaType_Nullable(), "OptionalEnumArrayField", OptionalEnumArrayField);
            reader.read(TeslaType_Nullable(), "OptionalBoolArrayField", OptionalBoolArrayField);
            reader.read(TeslaType_Nullable(), "OptionalByteArrayField", OptionalByteArrayField);
            reader.read(TeslaType_Nullable(), "OptionalInt16ArrayField", OptionalInt16ArrayField);
            reader.read(TeslaType_Nullable(), "OptionalUInt16ArrayField", OptionalUInt16ArrayField);
            reader.read(TeslaType_Nullable(), "OptionalInt32ArrayField", OptionalInt32ArrayField);
            reader.read(TeslaType_Nullable(), "OptionalUInt32ArrayField", OptionalUInt32ArrayField);
            reader.read(TeslaType_Nullable(), "OptionalInt64ArrayField", OptionalInt64ArrayField);
            reader.read(TeslaType_Nullable(), "OptionalUInt64ArrayField", OptionalUInt64ArrayField);
            reader.read(TeslaType_Nullable(), "OptionalFloatArrayField", OptionalFloatArrayField);
            reader.read(TeslaType_Nullable(), "OptionalDoubleArrayField", OptionalDoubleArrayField);
            reader.read(TeslaType_Nullable(), "OptionalStringArrayField", OptionalStringArrayField);
            break;
        
    default:
        break;
    }
}

template <typename WriterType>
void OptionalArrayTestObject::serialize(WriterType& writer) const {
    switch (writer.version().hash()) {
        case 7810441853185379917: // version 1, teslacompiler all_types v1.0
            writer.write(TeslaType_Nullable(), "OptionalObjectArrayField", OptionalObjectArrayField);
            writer.write(TeslaType_Nullable(), "OptionalEnumArrayField", OptionalEnumArrayField);
            writer.write(TeslaType_Nullable(), "OptionalBoolArrayField", OptionalBoolArrayField);
            writer.write(TeslaType_Nullable(), "OptionalByteArrayField", OptionalByteArrayField);
            writer.write(TeslaType_Nullable(), "OptionalInt16ArrayField", OptionalInt16ArrayField);
            writer.write(TeslaType_Nullable(), "OptionalUInt16ArrayField", OptionalUInt16ArrayField);
            writer.write(TeslaType_Nullable(), "OptionalInt32ArrayField", OptionalInt32ArrayField);
            writer.write(TeslaType_Nullable(), "OptionalUInt32ArrayField", OptionalUInt32ArrayField);
            writer.write(TeslaType_Nullable(), "OptionalInt64ArrayField", OptionalInt64ArrayField);
            writer.write(TeslaType_Nullable(), "OptionalUInt64ArrayField", OptionalUInt64ArrayField);
            writer.write(TeslaType_Nullable(), "OptionalFloatArrayField", OptionalFloatArrayField);
            writer.write(TeslaType_Nullable(), "OptionalDoubleArrayField", OptionalDoubleArrayField);
            writer.write(TeslaType_Nullable(), "OptionalStringArrayField", OptionalStringArrayField);
            break;
        
    default:
        break;
    }
}
