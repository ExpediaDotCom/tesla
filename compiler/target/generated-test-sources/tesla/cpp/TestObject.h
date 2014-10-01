

template <typename ReaderType>
void TestObject::deserialize(ReaderType& reader) {
    switch (reader.version().hash()) {

        case 7810441853185379917: // version 1, teslacompiler all_types v1.0
            reader.read(TeslaType_Object(), "BasicTestObjectField", BasicTestObjectField);
            reader.read(TeslaType_Object(), "ReferenceTestObjectField", ReferenceTestObjectField);
            reader.read(TeslaType_Object(), "OptionalBasicTestObjectField", OptionalBasicTestObjectField);
            reader.read(TeslaType_Object(), "ArrayTestObjectField", ArrayTestObjectField);
            reader.read(TeslaType_Object(), "Array2DTestObjectField", Array2DTestObjectField);
            reader.read(TeslaType_Object(), "OptionalArrayTestObjectField", OptionalArrayTestObjectField);
            break;
        
    default:
        break;
    }
}

template <typename WriterType>
void TestObject::serialize(WriterType& writer) const {
    switch (writer.version().hash()) {
        case 7810441853185379917: // version 1, teslacompiler all_types v1.0
            writer.write(TeslaType_Object(), "BasicTestObjectField", BasicTestObjectField);
            writer.write(TeslaType_Object(), "ReferenceTestObjectField", ReferenceTestObjectField);
            writer.write(TeslaType_Object(), "OptionalBasicTestObjectField", OptionalBasicTestObjectField);
            writer.write(TeslaType_Object(), "ArrayTestObjectField", ArrayTestObjectField);
            writer.write(TeslaType_Object(), "Array2DTestObjectField", Array2DTestObjectField);
            writer.write(TeslaType_Object(), "OptionalArrayTestObjectField", OptionalArrayTestObjectField);
            break;
        
    default:
        break;
    }
}
