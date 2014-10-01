

template <typename ReaderType>
void ReferenceArray::deserialize(ReaderType& reader) {
    switch (reader.version().hash()) {

        case -8997496319200256941: // version 1, teslacompiler reference test v1.0
            reader.read(TeslaType_Array(), "ReferenceArrayField", ReferenceArrayField);
            break;
        
    default:
        break;
    }
}

template <typename WriterType>
void ReferenceArray::serialize(WriterType& writer) const {
    switch (writer.version().hash()) {
        case -8997496319200256941: // version 1, teslacompiler reference test v1.0
            writer.write(TeslaType_Array(), "ReferenceArrayField", ReferenceArrayField);
            break;
        
    default:
        break;
    }
}
