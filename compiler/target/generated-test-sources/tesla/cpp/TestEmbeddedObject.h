

template <typename ReaderType>
void TestEmbeddedObject::deserialize(ReaderType& reader) {
    switch (reader.version().hash()) {

        case -8997496319200256941: // version 1, teslacompiler reference test v1.0
            reader.read(TeslaType_int32(), "IntField", IntField);
            break;
        
    default:
        break;
    }
}

template <typename WriterType>
void TestEmbeddedObject::serialize(WriterType& writer) const {
    switch (writer.version().hash()) {
        case -8997496319200256941: // version 1, teslacompiler reference test v1.0
            writer.write(TeslaType_int32(), "IntField", IntField);
            break;
        
    default:
        break;
    }
}
