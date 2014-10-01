

template <typename ReaderType>
void Array2DTestObject::deserialize(ReaderType& reader) {
    switch (reader.version().hash()) {

        case 7810441853185379917: // version 1, teslacompiler all_types v1.0
            reader.read(TeslaType_Array2D(), "Object2DArrayField", Object2DArrayField);
            reader.read(TeslaType_Array2D(), "Enum2DArrayField", Enum2DArrayField);
            reader.read(TeslaType_Array2D(), "Bool2DArrayField", Bool2DArrayField);
            reader.read(TeslaType_Array2D(), "Byte2DArrayField", Byte2DArrayField);
            reader.read(TeslaType_Array2D(), "Int162DArrayField", Int162DArrayField);
            reader.read(TeslaType_Array2D(), "UInt162DArrayField", UInt162DArrayField);
            reader.read(TeslaType_Array2D(), "Int322DArrayField", Int322DArrayField);
            reader.read(TeslaType_Array2D(), "UInt322DArrayField", UInt322DArrayField);
            reader.read(TeslaType_Array2D(), "Int642DArrayField", Int642DArrayField);
            reader.read(TeslaType_Array2D(), "UInt642DArrayField", UInt642DArrayField);
            reader.read(TeslaType_Array2D(), "Float2DArrayField", Float2DArrayField);
            reader.read(TeslaType_Array2D(), "Double2DArrayField", Double2DArrayField);
            reader.read(TeslaType_Array2D(), "String2DArrayField", String2DArrayField);
            break;
        
    default:
        break;
    }
}

template <typename WriterType>
void Array2DTestObject::serialize(WriterType& writer) const {
    switch (writer.version().hash()) {
        case 7810441853185379917: // version 1, teslacompiler all_types v1.0
            writer.write(TeslaType_Array2D(), "Object2DArrayField", Object2DArrayField);
            writer.write(TeslaType_Array2D(), "Enum2DArrayField", Enum2DArrayField);
            writer.write(TeslaType_Array2D(), "Bool2DArrayField", Bool2DArrayField);
            writer.write(TeslaType_Array2D(), "Byte2DArrayField", Byte2DArrayField);
            writer.write(TeslaType_Array2D(), "Int162DArrayField", Int162DArrayField);
            writer.write(TeslaType_Array2D(), "UInt162DArrayField", UInt162DArrayField);
            writer.write(TeslaType_Array2D(), "Int322DArrayField", Int322DArrayField);
            writer.write(TeslaType_Array2D(), "UInt322DArrayField", UInt322DArrayField);
            writer.write(TeslaType_Array2D(), "Int642DArrayField", Int642DArrayField);
            writer.write(TeslaType_Array2D(), "UInt642DArrayField", UInt642DArrayField);
            writer.write(TeslaType_Array2D(), "Float2DArrayField", Float2DArrayField);
            writer.write(TeslaType_Array2D(), "Double2DArrayField", Double2DArrayField);
            writer.write(TeslaType_Array2D(), "String2DArrayField", String2DArrayField);
            break;
        
    default:
        break;
    }
}
