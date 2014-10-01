

template <typename ReaderType>
void complexttypetest::deserialize(ReaderType& reader) {
    switch (reader.version().hash()) {

        case -5586303099293846137: // version 1, compiler test passcompile full complexttypetest
            reader.read(TeslaType_Array(), "field1", field1);
            reader.read(TeslaType_Array2D(), "field2", field2);
            reader.read(TeslaType_Array3D(), "field3", field3);
            reader.read(TeslaType_Reference(), "field4", field4);
            reader.read(TeslaType_Reference(), "field5", field5);
            break;
        
    default:
        break;
    }
}

template <typename WriterType>
void complexttypetest::serialize(WriterType& writer) const {
    switch (writer.version().hash()) {
        case -5586303099293846137: // version 1, compiler test passcompile full complexttypetest
            writer.write(TeslaType_Array(), "field1", field1);
            writer.write(TeslaType_Array2D(), "field2", field2);
            writer.write(TeslaType_Array3D(), "field3", field3);
            writer.write(TeslaType_Reference(), "field4", field4);
            writer.write(TeslaType_Reference(), "field5", field5);
            break;
        
    default:
        break;
    }
}
