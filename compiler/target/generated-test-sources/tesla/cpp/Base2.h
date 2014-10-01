

template <typename ReaderType>
void Base2::deserialize(ReaderType& reader) {
    switch (reader.version().hash()) {

        case -4144946394736392407: // version 1, compiler test passcompile full inheritance v1.0
            reader.read(TeslaType_int16(), "Int16Field", Int16Field);
            break;
        
    default:
        break;
    }
}

template <typename WriterType>
void Base2::serialize(WriterType& writer) const {
    switch (writer.version().hash()) {
        case -4144946394736392407: // version 1, compiler test passcompile full inheritance v1.0
            writer.write(TeslaType_int16(), "Int16Field", Int16Field);
            break;
        
    default:
        break;
    }
}
