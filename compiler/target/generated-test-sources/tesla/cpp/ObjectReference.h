

template <typename ReaderType>
void ObjectReference::deserialize(ReaderType& reader) {
    switch (reader.version().hash()) {

        case -8997496319200256941: // version 1, teslacompiler reference test v1.0
            reader.read(TeslaType_Reference(), "ReferenceField1", ReferenceField1);
            reader.read(TeslaType_Reference(), "ReferenceField2", ReferenceField2);
            break;
        
    default:
        break;
    }
}

template <typename WriterType>
void ObjectReference::serialize(WriterType& writer) const {
    switch (writer.version().hash()) {
        case -8997496319200256941: // version 1, teslacompiler reference test v1.0
            writer.write(TeslaType_Reference(), "ReferenceField1", ReferenceField1);
            writer.write(TeslaType_Reference(), "ReferenceField2", ReferenceField2);
            break;
        
    default:
        break;
    }
}
