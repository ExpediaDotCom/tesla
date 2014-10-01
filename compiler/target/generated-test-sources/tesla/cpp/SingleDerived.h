

template <typename ReaderType>
void SingleDerived::deserialize(ReaderType& reader) {
    switch (reader.version().hash()) {

        case -4144946394736392407: // version 1, compiler test passcompile full inheritance v1.0
            reader.read(TeslaType_boolean(), "BooleanField", BooleanField);
            break;
        
    default:
        break;
    }
}

template <typename WriterType>
void SingleDerived::serialize(WriterType& writer) const {
    switch (writer.version().hash()) {
        case -4144946394736392407: // version 1, compiler test passcompile full inheritance v1.0
            writer.write(TeslaType_boolean(), "BooleanField", BooleanField);
            break;
        
    default:
        break;
    }
}
