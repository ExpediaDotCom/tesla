

template <typename ReaderType>
void VersionedObject::deserialize(ReaderType& reader) {
    switch (reader.version().hash()) {

        case -1533394106668605082: // version 1, versioning test v1.0
            reader.read(TeslaType_Nullable(), "EnumField", EnumField);
            reader.read(TeslaType_Nullable(), "DepricatedInt32Field", DepricatedInt32Field);
            break;
        case 3897695751964630335: // version 2, versioning test v2.0
            reader.read(TeslaType_Nullable(), "EnumField", EnumField);
            reader.read(TeslaType_Nullable(), "NewInt64Field", NewInt64Field);
            break;
        
    default:
        break;
    }
}

template <typename WriterType>
void VersionedObject::serialize(WriterType& writer) const {
    switch (writer.version().hash()) {
        case -1533394106668605082: // version 1, versioning test v1.0
            writer.write(TeslaType_Nullable(), "EnumField", EnumField);
            writer.write(TeslaType_Nullable(), "DepricatedInt32Field", DepricatedInt32Field);
            break;
        case 3897695751964630335: // version 2, versioning test v2.0
            writer.write(TeslaType_Nullable(), "EnumField", EnumField);
            writer.write(TeslaType_Nullable(), "NewInt64Field", NewInt64Field);
            break;
        
    default:
        break;
    }
}
