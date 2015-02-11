/**
 * Serializer.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */
package com.expedia.tesla.demo;

public class Serializer {
    public static final com.expedia.tesla.SchemaVersion VERSION_DEMO_V1 = new com.expedia.tesla.SchemaVersion(-7326385967232637868L, (short)1, "demo v1", null);
    
    /**
     * Create a new binary writer instance for a specified schema version. The created writer object will write object
     * follow it's definition in the schema.
     */
    public static ObjectWriter newBinaryWriter(com.expedia.tesla.SchemaVersion version, java.io.OutputStream os) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (version.getSchemaHash() == TeslaBinaryWriter_demo_v1.SCHEMA_HASH) {
            return new TeslaBinaryWriter_demo_v1(os);
        }
        throw new com.expedia.tesla.serialization.TeslaSerializationException("Unsupported schema version " + version.getSchemaHash());
    }
    
    /**
     * Create a new binary reader instance for a specified schema version. The created reader object will read object
     * follow it's definition in the schema.
     */
    public static ObjectReader newBinaryReader(com.expedia.tesla.SchemaVersion version, java.io.InputStream is) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (version.getSchemaHash() == TeslaBinaryReader_demo_v1.SCHEMA_HASH) {
            return new TeslaBinaryReader_demo_v1(is);
        }
        throw new com.expedia.tesla.serialization.TeslaDeserializationException("Unsupported schema version " + version.getSchemaHash());
    }
    
    /**
     * Create a new JSON writer instance for a specified schema version. The created writer object will write object
     * follow it's definition in the schema.
     */
    public static ObjectWriter newJsonWriter(com.expedia.tesla.SchemaVersion version, java.io.OutputStream os) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (version.getSchemaHash() == TeslaJsonWriter_demo_v1.SCHEMA_HASH) {
            return new TeslaJsonWriter_demo_v1(os);
        }
        throw new com.expedia.tesla.serialization.TeslaSerializationException("Unsupported schema version " + version.getSchemaHash());
    }
    
    /**
     * Create a new JSON reader instance for a specified schema version. The created reader object will read object
     * follow it's definition in the schema.
     */
    public static ObjectReader newJsonReader(com.expedia.tesla.SchemaVersion version, java.io.InputStream is) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (version.getSchemaHash() == TeslaJsonReader_demo_v1.SCHEMA_HASH) {
            return new TeslaJsonReader_demo_v1(is);
        }
        throw new com.expedia.tesla.serialization.TeslaDeserializationException("Unsupported schema version " + version.getSchemaHash());
    }
    
    /**
     * Create a new JSON change writer instance for a specified schema version. The created writer object will write object
     * follow it's definition in the schema.
     */
    public static ChangeWriter newJsonChangeWriter(com.expedia.tesla.SchemaVersion version, java.io.OutputStream os) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (version.getSchemaHash() == TeslaJsonChangeWriter_demo_v1.SCHEMA_HASH) {
            return new TeslaJsonChangeWriter_demo_v1(os);
        }
        throw new com.expedia.tesla.serialization.TeslaSerializationException("Unsupported schema version " + version.getSchemaHash());
    }
    
    /**
     * Create a new JSON change reader instance for a specified schema version. The created reader object will read object
     * follow it's definition in the schema.
     */
    public static ChangeReader newJsonChangeReader(com.expedia.tesla.SchemaVersion version, java.io.InputStream is) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (version.getSchemaHash() == TeslaJsonChangeReader_demo_v1.SCHEMA_HASH) {
            return new TeslaJsonChangeReader_demo_v1(is);
        }
        throw new com.expedia.tesla.serialization.TeslaDeserializationException("Unsupported schema version " + version.getSchemaHash());
    }
    
    /**
     * Write object instances of any user defined types in application schema files (TML). To create instance of ObjectWriter,
     * use newBinaryWriter or newJsonWriter method.   
     */
    public static abstract class ObjectWriter {
        public void write(Room v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
            write_class_Room_(null, v);
        }
        public void write(com.expedia.tesla.demo.Hotel v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
            write_class_com_expedia_tesla_demo_Hotel_(null, v);
        }
        public void write(com.expedia.tesla.demo.IdObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
            write_class_com_expedia_tesla_demo_IdObject_(null, v);
        }
        // Following methods will be override by actual serialization class for each schema.
        protected void write_class_Room_(String name, Room v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
            throw new com.expedia.tesla.serialization.TeslaSerializationException("Type 'Room' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_demo_Hotel_(String name, com.expedia.tesla.demo.Hotel v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
            throw new com.expedia.tesla.serialization.TeslaSerializationException("Type 'com.expedia.tesla.demo.Hotel' is not defined in current schema.");
        }
        protected void write_class_com_expedia_tesla_demo_IdObject_(String name, com.expedia.tesla.demo.IdObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
            throw new com.expedia.tesla.serialization.TeslaSerializationException("Type 'com.expedia.tesla.demo.IdObject' is not defined in current schema.");
        }
    }
    
    /**
     * Read object instances of any user defined types in application schema files (TML). To create instance of ObjectReader,
     * use newBinaryReader or newJsonReader method.   
     */
    public static abstract class ObjectReader {
        public Room read(Room v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
            return read_class_Room_(null, v);
        }
        public com.expedia.tesla.demo.Hotel read(com.expedia.tesla.demo.Hotel v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
            return read_class_com_expedia_tesla_demo_Hotel_(null, v);
        }
        public com.expedia.tesla.demo.IdObject read(com.expedia.tesla.demo.IdObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
            return read_class_com_expedia_tesla_demo_IdObject_(null, v);
        }
        // Following methods will be override by actual serialization class for each schema.
        protected Room read_class_Room_(String name, Room v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
            throw new com.expedia.tesla.serialization.TeslaDeserializationException("Type 'Room' is not defined in current schema.");
        }
        protected com.expedia.tesla.demo.Hotel read_class_com_expedia_tesla_demo_Hotel_(String name, com.expedia.tesla.demo.Hotel v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
            throw new com.expedia.tesla.serialization.TeslaDeserializationException("Type 'com.expedia.tesla.demo.Hotel' is not defined in current schema.");
        }
        protected com.expedia.tesla.demo.IdObject read_class_com_expedia_tesla_demo_IdObject_(String name, com.expedia.tesla.demo.IdObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
            throw new com.expedia.tesla.serialization.TeslaDeserializationException("Type 'com.expedia.tesla.demo.IdObject' is not defined in current schema.");
        }
    }
    
    /**
     * Compare two values and write only properties or values which are not equal for any user defined objects in 
     * application schema files (TML). To create instance of ChangeWriter, use newJsonChangeWriter.   
     */
    public static abstract class ChangeWriter {
        public void write(Room oldValue, Room newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
            throw new com.expedia.tesla.serialization.TeslaSerializationException("Type 'Room' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.demo.Hotel oldValue, com.expedia.tesla.demo.Hotel newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
            throw new com.expedia.tesla.serialization.TeslaSerializationException("Type 'com.expedia.tesla.demo.Hotel' is not defined in current schema.");
        }
        public void write(com.expedia.tesla.demo.IdObject oldValue, com.expedia.tesla.demo.IdObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
            throw new com.expedia.tesla.serialization.TeslaSerializationException("Type 'com.expedia.tesla.demo.IdObject' is not defined in current schema.");
        }
    }

    /**
     * Read serialized changes generated by ChangeWriter, and applied them on an existing value. Only the changed values
     * or properties will be updated. All other properties or values will remain the current value.
     */
    public static abstract class ChangeReader {
        public Room read(Room v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
            throw new com.expedia.tesla.serialization.TeslaDeserializationException("Type 'Room' is not defined in current schema.");
        }
        public com.expedia.tesla.demo.Hotel read(com.expedia.tesla.demo.Hotel v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
            throw new com.expedia.tesla.serialization.TeslaDeserializationException("Type 'com.expedia.tesla.demo.Hotel' is not defined in current schema.");
        }
        public com.expedia.tesla.demo.IdObject read(com.expedia.tesla.demo.IdObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
            throw new com.expedia.tesla.serialization.TeslaDeserializationException("Type 'com.expedia.tesla.demo.IdObject' is not defined in current schema.");
        }
    }
}



class TeslaBinaryWriter_demo_v1 extends Serializer.ObjectWriter {


    public static final long SCHEMA_HASH = -7326385967232637868L;
    private com.expedia.tesla.serialization.BinaryWriter writer;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    public TeslaBinaryWriter_demo_v1(java.io.OutputStream stream) {
        writer = new com.expedia.tesla.serialization.BinaryWriter(stream, SCHEMA_HASH);
    }

    public void write_class_Room_(java.lang.String name, Room v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    }

    public void write_class_com_expedia_tesla_demo_IdObject_(java.lang.String name, com.expedia.tesla.demo.IdObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_int32("id", v.getId());
    }

    public void write_class_com_expedia_tesla_demo_Hotel_(java.lang.String name, com.expedia.tesla.demo.Hotel v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_int32("id", v.getId());
        write_string("name", v.getName());
        write_nullable_map_java_util_HashMap__string_string__("attributes", v.getAttributes());
        write_array_java_util_Collection_java_util_HashSet__reference_class_Room___("rooms", v.getRooms());
    }


    public void write_int32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeInt32(name, v);
    }
    
    
    
    public void write_reference_class_Room__(java.lang.String name, Room v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        int id = refPolicy.getOutputReferenceId(v, Room.class);
        write_int32(null, id);
        if (id < 0) {
            write_class_Room_(name, (Room)v);
        }
    }

    
    public void write_nullable_map_java_util_HashMap__string_string__(java.lang.String name, java.util.HashMap<java.lang.String,java.lang.String> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            write_boolean(name, true);
        } else {
            write_boolean(name, false);
            write_map_java_util_HashMap__string_string_(name, v);
        }
    }

    
    
    public void write_string(java.lang.String name, java.lang.String v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeString(name, v);
    }
    
    
    public void write_array_java_util_Collection_java_util_HashSet__reference_class_Room___(java.lang.String name, java.util.Collection<Room> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, com.expedia.tesla.utils.ArrayUtils.size(v));
        for (Room e : v) {
            write_reference_class_Room__(name, e);
        }
    }
    
    
    
    public void write_uint32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeUInt32(name, v);
    }
    
    
    public void write_boolean(java.lang.String name, boolean v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        writer.writeBoolean(name, v);
    }
    
    
    public void write_map_java_util_HashMap__string_string_(java.lang.String name, java.util.HashMap<java.lang.String,java.lang.String> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        write_uint32(name, v.size());
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : v.entrySet()) {
            write_string(name, entry.getKey());
            write_string(name, entry.getValue());
        }
    }
    
    
}

class TeslaBinaryReader_demo_v1 extends Serializer.ObjectReader {


    public static final long SCHEMA_HASH = -7326385967232637868L;
    private com.expedia.tesla.serialization.BinaryReader reader;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
            
    TeslaBinaryReader_demo_v1(java.io.InputStream stream) {
        reader = new com.expedia.tesla.serialization.BinaryReader(stream, SCHEMA_HASH);
    }

    public Room read_class_Room_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_Room_(name, null);
    }

    @Override
    public Room read_class_Room_(java.lang.String name, Room v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new Room();
        return v;
    }
    
    public com.expedia.tesla.demo.IdObject read_class_com_expedia_tesla_demo_IdObject_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_demo_IdObject_(name, null);
    }

    @Override
    public com.expedia.tesla.demo.IdObject read_class_com_expedia_tesla_demo_IdObject_(java.lang.String name, com.expedia.tesla.demo.IdObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.demo.IdObject();
        v.setId(read_int32("id"));
        return v;
    }
    
    public com.expedia.tesla.demo.Hotel read_class_com_expedia_tesla_demo_Hotel_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_demo_Hotel_(name, null);
    }

    @Override
    public com.expedia.tesla.demo.Hotel read_class_com_expedia_tesla_demo_Hotel_(java.lang.String name, com.expedia.tesla.demo.Hotel v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (v == null)
            v = new com.expedia.tesla.demo.Hotel();
        v.setId(read_int32("id"));
        v.setName(read_string("name"));
        v.setAttributes(read_nullable_map_java_util_HashMap__string_string__("attributes"));
        v.setRooms(read_array_java_util_Collection_java_util_HashSet__reference_class_Room___("rooms"));
        return v;
    }
    

    public int read_int32(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readInt32(name);
    }


    public Room read_reference_class_Room__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int id = read_int32(name);
        if (id >= 0) {
            return refPolicy.getInputReference(id, Room.class);
        } else {
            Room v = read_class_Room_(name);
            refPolicy.putInputReference(-id, v, Room.class);
            return v;
        }
    }

    public java.util.HashMap<java.lang.String,java.lang.String> read_nullable_map_java_util_HashMap__string_string__(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!read_boolean(name)) {
            return read_map_java_util_HashMap__string_string_(name);
        } else {
            return null;
        }
    }


    public java.lang.String read_string(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readString(name);
    }

    public java.util.Collection<Room> read_array_java_util_Collection_java_util_HashSet__reference_class_Room___(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.Collection<Room> v = new java.util.HashSet<Room>();
        for (int i = 0; i < size; i++) {
            v.add(read_reference_class_Room__(name));
        }
        return v;
    }


    public int read_uint32(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readUInt32(name);
    }

    public boolean read_boolean(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return reader.readBoolean(name);
    }

    public java.util.HashMap<java.lang.String,java.lang.String> read_map_java_util_HashMap__string_string_(java.lang.String name) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        int size = read_uint32(name);
        java.util.HashMap<java.lang.String,java.lang.String> v = new java.util.HashMap<java.lang.String,java.lang.String>();
        for (int i = 0; i < size; i++) {
            v.put(read_string(name), read_string(name));
        }
        return v;
    }

}



class TeslaJsonWriter_demo_v1 extends Serializer.ObjectWriter {


    public static final long SCHEMA_HASH = -7326385967232637868L;
    private static final com.fasterxml.jackson.core.JsonFactory JSON_FACTORY = new com.fasterxml.jackson.core.JsonFactory();
    private com.fasterxml.jackson.core.JsonGenerator jsonGenerator;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
	
	TeslaJsonWriter_demo_v1(java.io.OutputStream stream) throws java.io.IOException {
        jsonGenerator = JSON_FACTORY.createGenerator(stream);
    }


    public void write_class_Room_(java.lang.String name, Room v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }




    public void write_class_com_expedia_tesla_demo_IdObject_(java.lang.String name, com.expedia.tesla.demo.IdObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("id"); 
        write_int32("id", v.getId());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }




    public void write_class_com_expedia_tesla_demo_Hotel_(java.lang.String name, com.expedia.tesla.demo.Hotel v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
    	jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("id"); 
        write_int32("id", v.getId());
        jsonGenerator.writeFieldName("name"); 
        write_string("name", v.getName());
        jsonGenerator.writeFieldName("attributes"); 
        write_nullable_map_java_util_HashMap__string_string__("attributes", v.getAttributes());
        jsonGenerator.writeFieldName("rooms"); 
        write_array_java_util_Collection_java_util_HashSet__reference_class_Room___("rooms", v.getRooms());
		jsonGenerator.writeEndObject();
		jsonGenerator.flush(); // JsonGenerator requires flush buffer to OutputStream. Otherwise, no content will be written to this stream.
    }






    public void write_int32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }


    public void write_reference_class_Room__(java.lang.String name, Room v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartObject();
        int id = refPolicy.getOutputReferenceId(v, Room.class);
        if (id > 0) {
            jsonGenerator.writeFieldName("@reference"); 
            write_int32("@reference", id);
        } else {
            jsonGenerator.writeFieldName("@id"); 
            write_int32("@id", -id);
            jsonGenerator.writeFieldName("@value"); 
            write_class_Room_(name, (Room)v);
        }
        jsonGenerator.writeEndObject();
    }

    public void write_nullable_map_java_util_HashMap__string_string__(java.lang.String name, java.util.HashMap<java.lang.String,java.lang.String> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (v == null) {
            jsonGenerator.writeNull();
        } else {
            write_map_java_util_HashMap__string_string_(name, v);
        }
    }


    public void write_string(java.lang.String name, java.lang.String v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeString(v);
    }

    public void write_array_java_util_Collection_java_util_HashSet__reference_class_Room___(java.lang.String name, java.util.Collection<Room> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (Room e : v) {
            write_reference_class_Room__(name, e);
        }
        jsonGenerator.writeEndArray();
    }


    public void write_uint32(java.lang.String name, int v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeNumber(v);
    }

    public void write_boolean(java.lang.String name, boolean v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeBoolean(v);
    }

    public void write_map_java_util_HashMap__string_string_(java.lang.String name, java.util.HashMap<java.lang.String,java.lang.String> v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        jsonGenerator.writeStartArray();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : v.entrySet()) {
            write_string(name, entry.getKey());
            write_string(name, entry.getValue());
        }
        jsonGenerator.writeEndArray();
    }


}

class TeslaJsonReader_demo_v1 extends Serializer.ObjectReader {


    public static final long SCHEMA_HASH = -7326385967232637868L;
    private static final com.fasterxml.jackson.databind.ObjectMapper JSON_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private com.fasterxml.jackson.databind.JsonNode root;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    TeslaJsonReader_demo_v1(java.io.InputStream stream) throws java.io.IOException {
        root = JSON_MAPPER.readTree(stream);
    }

    @Override
    protected Room read_class_Room_(String name, Room v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_Room_(name, v, root);
    }

    public Room read_class_Room_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_Room_(name, null, node);
    }
    
    public Room read_class_Room_(java.lang.String name, Room v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new com.expedia.tesla.serialization.TeslaDeserializationException(String.format(
            	"Invalid Tesla JSON object encoding, expect a JSON object. Field: '%s', type: \"class<Room>\"!", name));
        if (v == null) 
            v = new Room();
        com.fasterxml.jackson.databind.JsonNode vn;
        return v;
    }
    
    @Override
    protected com.expedia.tesla.demo.IdObject read_class_com_expedia_tesla_demo_IdObject_(String name, com.expedia.tesla.demo.IdObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_demo_IdObject_(name, v, root);
    }

    public com.expedia.tesla.demo.IdObject read_class_com_expedia_tesla_demo_IdObject_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_demo_IdObject_(name, null, node);
    }
    
    public com.expedia.tesla.demo.IdObject read_class_com_expedia_tesla_demo_IdObject_(java.lang.String name, com.expedia.tesla.demo.IdObject v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new com.expedia.tesla.serialization.TeslaDeserializationException(String.format(
            	"Invalid Tesla JSON object encoding, expect a JSON object. Field: '%s', type: \"class<com.expedia.tesla.demo.IdObject>\"!", name));
        if (v == null) 
            v = new com.expedia.tesla.demo.IdObject();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("id");
        if(vn != null)
            v.setId(read_int32("id", vn));
        return v;
    }
    
    @Override
    protected com.expedia.tesla.demo.Hotel read_class_com_expedia_tesla_demo_Hotel_(String name, com.expedia.tesla.demo.Hotel v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_demo_Hotel_(name, v, root);
    }

    public com.expedia.tesla.demo.Hotel read_class_com_expedia_tesla_demo_Hotel_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_demo_Hotel_(name, null, node);
    }
    
    public com.expedia.tesla.demo.Hotel read_class_com_expedia_tesla_demo_Hotel_(java.lang.String name, com.expedia.tesla.demo.Hotel v, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new com.expedia.tesla.serialization.TeslaDeserializationException(String.format(
            	"Invalid Tesla JSON object encoding, expect a JSON object. Field: '%s', type: \"class<com.expedia.tesla.demo.Hotel>\"!", name));
        if (v == null) 
            v = new com.expedia.tesla.demo.Hotel();
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = node.get("id");
        if(vn != null)
            v.setId(read_int32("id", vn));
        vn = node.get("name");
        if(vn != null)
            v.setName(read_string("name", vn));
        vn = node.get("attributes");
        if(vn != null)
            v.setAttributes(read_nullable_map_java_util_HashMap__string_string__("attributes", vn));
        vn = node.get("rooms");
        if(vn != null)
            v.setRooms(read_array_java_util_Collection_java_util_HashSet__reference_class_Room___("rooms", vn));
        return v;
    }
    

    public int read_int32(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.intValue();
    }


    public Room read_reference_class_Room__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isObject())
            throw new com.expedia.tesla.serialization.TeslaDeserializationException(String.format(
            	"Invalid Tesla JSON reference encoding, expect a JSON object. Field: '%s', type: \"reference<class<Room>>\"!", name));

        if (node.has("@reference")) {
            int id = read_int32(name, node.findValue("@reference"));
            return refPolicy.getInputReference(id, Room.class);
        } else if (node.has("@id")) {
            int id = read_int32(name, node.findValue("@id"));
            Room v = read_class_Room_(name, node.findValue("@value"));
            refPolicy.putInputReference(id, v, Room.class);
            return v;
        }
        throw new com.expedia.tesla.serialization.TeslaDeserializationException(String.format(
        	"Invalid Tesla JSON reference encoding, expect a '@reference' or '@id' property. Field: '%s', type: \"reference<class<Room>>\"!", name));
    }

    public java.util.HashMap<java.lang.String,java.lang.String> read_nullable_map_java_util_HashMap__string_string__(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (node == null || node.isNull()) {
            return null;
        } else {
            return read_map_java_util_HashMap__string_string_(name, node);
        }
    }


    public java.lang.String read_string(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.textValue();
    }

    public java.util.Collection<Room> read_array_java_util_Collection_java_util_HashSet__reference_class_Room___(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.Collection<Room> v = new java.util.HashSet<Room>();
        while (itr.hasNext()) {
            v.add(read_reference_class_Room__(name, itr.next()));
        }
        return v;
    }


    public int read_uint32(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (int)node.longValue();
    }

    public boolean read_boolean(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return node.booleanValue();
    }

    public java.util.HashMap<java.lang.String,java.lang.String> read_map_java_util_HashMap__string_string_(java.lang.String name, com.fasterxml.jackson.databind.JsonNode node) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!node.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = node.elements();
        java.util.HashMap<java.lang.String,java.lang.String> v = new java.util.HashMap<java.lang.String,java.lang.String>();
        while (itr.hasNext()) {
            v.put(read_string(name, itr.next()), read_string(name, itr.next()));
        }
        return v;
    }



}



class TeslaJsonChangeWriter_demo_v1 extends Serializer.ChangeWriter {


    public static final long SCHEMA_HASH = -7326385967232637868L;
    private static final com.fasterxml.jackson.databind.ObjectMapper OBJECT_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private static final com.fasterxml.jackson.databind.node.JsonNodeFactory NODE_FACTORY = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    private java.io.OutputStream stream;
    
    TeslaJsonChangeWriter_demo_v1(java.io.OutputStream stream) throws java.io.IOException {
        this.stream = stream;
    }

    @Override
    public void write(Room oldValue, Room newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_Room_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_Room_(Room oldValue, Room newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        return jn;
    }

    @Override
    public void write(com.expedia.tesla.demo.IdObject oldValue, com.expedia.tesla.demo.IdObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_demo_IdObject_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_demo_IdObject_(com.expedia.tesla.demo.IdObject oldValue, com.expedia.tesla.demo.IdObject newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_int32(oldValue.getId(), newValue.getId())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("id", ejn);
        }
        return jn;
    }

    @Override
    public void write(com.expedia.tesla.demo.Hotel oldValue, com.expedia.tesla.demo.Hotel newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode deltaNode = write_class_com_expedia_tesla_demo_Hotel_(oldValue, newValue);
        if (deltaNode != null) {
            OBJECT_MAPPER.writeValue(stream, deltaNode);
        }
    }

    public com.fasterxml.jackson.databind.JsonNode write_class_com_expedia_tesla_demo_Hotel_(com.expedia.tesla.demo.Hotel oldValue, com.expedia.tesla.demo.Hotel newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;
        
        com.fasterxml.jackson.databind.node.ObjectNode jn = null;
        com.fasterxml.jackson.databind.JsonNode ejn = null;
        if ((ejn = write_int32(oldValue.getId(), newValue.getId())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("id", ejn);
        }
        if ((ejn = write_string(oldValue.getName(), newValue.getName())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("name", ejn);
        }
        if ((ejn = write_nullable_map_java_util_HashMap__string_string__(oldValue.getAttributes(), newValue.getAttributes())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("attributes", ejn);
        }
        if ((ejn = write_array_java_util_Collection_java_util_HashSet__reference_class_Room___(oldValue.getRooms(), newValue.getRooms())) != null) {
            if (jn == null) {
                jn = NODE_FACTORY.objectNode();
            }
            jn.put("rooms", ejn);
        }
        return jn;
    }


    public com.fasterxml.jackson.databind.JsonNode write_int32(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue || oldValue != null ? oldValue.equals(newValue) : newValue.equals(oldValue))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }


    public com.fasterxml.jackson.databind.JsonNode write_reference_class_Room__(Room oldValue, Room newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.JsonNode jne = write_class_Room_((Room)oldValue, (Room)newValue);
        if (jne == null)
            return null;
        com.fasterxml.jackson.databind.node.ObjectNode jn = NODE_FACTORY.objectNode();
        int id = refPolicy.getOutputReferenceId(newValue, Room.class);
        if (id > 0) {
            jn.put("@reference", id);
        } else {
            jn.put("@id", -id);
            jn.put("@value", jne);
        }

        return jn;
    }

    public com.fasterxml.jackson.databind.JsonNode write_nullable_map_java_util_HashMap__string_string__(java.util.HashMap<java.lang.String,java.lang.String> oldValue, java.util.HashMap<java.lang.String,java.lang.String> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue)
            return null;

        if (oldValue != null && newValue == null) {
            return NODE_FACTORY.nullNode();
        } else {
            return write_map_java_util_HashMap__string_string_(oldValue, newValue);
        }
    }


    public com.fasterxml.jackson.databind.JsonNode write_string(java.lang.String oldValue, java.lang.String newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue || oldValue != null ? oldValue.equals(newValue) : newValue.equals(oldValue))
            return null;
            
        return NODE_FACTORY.textNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_array_java_util_Collection_java_util_HashSet__reference_class_Room___(java.util.Collection<Room> oldValue, java.util.Collection<Room> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jan = null;
        for (int i = 0; i < Math.max(com.expedia.tesla.utils.ArrayUtils.size(oldValue), com.expedia.tesla.utils.ArrayUtils.size(newValue)); i++) {
            com.fasterxml.jackson.databind.JsonNode jen = write_reference_class_Room__(com.expedia.tesla.utils.ArrayUtils.get(oldValue, i), com.expedia.tesla.utils.ArrayUtils.get(newValue, i));
            if (jen != null) {
                if (jan == null) 
                    jan = NODE_FACTORY.arrayNode();
                jan.add(i);
                jan.add(jen);
            }
        }
        
        return jan;
    }


    public com.fasterxml.jackson.databind.JsonNode write_uint32(java.lang.Integer oldValue, java.lang.Integer newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue || oldValue != null ? oldValue.equals(newValue) : newValue.equals(oldValue))
            return null;
            
        return NODE_FACTORY.numberNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_boolean(java.lang.Boolean oldValue, java.lang.Boolean newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        if (oldValue == newValue || oldValue != null ? oldValue.equals(newValue) : newValue.equals(oldValue))
            return null;
            
        return NODE_FACTORY.booleanNode(newValue);
    }

    public com.fasterxml.jackson.databind.JsonNode write_map_java_util_HashMap__string_string_(java.util.HashMap<java.lang.String,java.lang.String> oldValue, java.util.HashMap<java.lang.String,java.lang.String> newValue) throws java.io.IOException, com.expedia.tesla.serialization.TeslaSerializationException {
        com.fasterxml.jackson.databind.node.ArrayNode jn = null;
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : newValue.entrySet()) {
            com.fasterxml.jackson.databind.JsonNode jne = write_string(oldValue.get(entry.getKey()), entry.getValue());
            if (jne != null) {
                if (jn == null) 
                    jn = NODE_FACTORY.arrayNode();
                jn.add(write_string((java.lang.String)null, entry.getKey()));
                jn.add(jne);
            }
        }
        return jn;
    }


    }

class TeslaJsonChangeReader_demo_v1 extends Serializer.ChangeReader {


    public static final long SCHEMA_HASH = -7326385967232637868L;
    private static final com.fasterxml.jackson.databind.ObjectMapper JSON_MAPPER = new com.fasterxml.jackson.databind.ObjectMapper();
    private com.fasterxml.jackson.databind.JsonNode root;
    private com.expedia.tesla.serialization.ReferencePolicy refPolicy = new com.expedia.tesla.serialization.ReferencePolicy();
    
    TeslaJsonChangeReader_demo_v1(java.io.InputStream stream) throws java.io.IOException {
        root = JSON_MAPPER.readTree(stream);
    }
 

    @Override
    public Room read(Room v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_Room_(v, root);
    }

    public Room read_class_Room_(Room v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new com.expedia.tesla.serialization.TeslaDeserializationException(String.format(
            	"Invalid Tesla JSON object encoding, expect a JSON object for type \"class<Room>\"!"));
        com.fasterxml.jackson.databind.JsonNode vn;
        return v;
    }



    @Override
    public com.expedia.tesla.demo.IdObject read(com.expedia.tesla.demo.IdObject v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_demo_IdObject_(v, root);
    }

    public com.expedia.tesla.demo.IdObject read_class_com_expedia_tesla_demo_IdObject_(com.expedia.tesla.demo.IdObject v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new com.expedia.tesla.serialization.TeslaDeserializationException(String.format(
            	"Invalid Tesla JSON object encoding, expect a JSON object for type \"class<com.expedia.tesla.demo.IdObject>\"!"));
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("id");
        if(vn != null) {
            v.setId(read_int32(v.getId(), vn));
        }
        return v;
    }



    @Override
    public com.expedia.tesla.demo.Hotel read(com.expedia.tesla.demo.Hotel v) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return read_class_com_expedia_tesla_demo_Hotel_(v, root);
    }

    public com.expedia.tesla.demo.Hotel read_class_com_expedia_tesla_demo_Hotel_(com.expedia.tesla.demo.Hotel v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new com.expedia.tesla.serialization.TeslaDeserializationException(String.format(
            	"Invalid Tesla JSON object encoding, expect a JSON object for type \"class<com.expedia.tesla.demo.Hotel>\"!"));
        com.fasterxml.jackson.databind.JsonNode vn;
        vn = jn.get("id");
        if(vn != null) {
            v.setId(read_int32(v.getId(), vn));
        }
        vn = jn.get("name");
        if(vn != null) {
            v.setName(read_string(v.getName(), vn));
        }
        vn = jn.get("attributes");
        if(vn != null) {
            v.setAttributes(read_nullable_map_java_util_HashMap__string_string__(v.getAttributes(), vn));
        }
        vn = jn.get("rooms");
        if(vn != null) {
            v.setRooms(read_array_java_util_Collection_java_util_HashSet__reference_class_Room___(v.getRooms(), vn));
        }
        return v;
    }





    public int read_int32(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.intValue();
    }


    public Room read_reference_class_Room__(Room v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isObject())
            throw new com.expedia.tesla.serialization.TeslaDeserializationException(String.format(
            	"Invalid Tesla JSON reference encoding, expect a JSON object for type \"reference<class<Room>>\"!"));

        if (jn.has("@reference")) {
            int id = read_int32(0, jn.findValue("@reference"));
            return refPolicy.getInputReference(id, Room.class);
        } else if (jn.has("@id")) {
            int id = read_int32(0, jn.findValue("@id"));
            Room value = read_class_Room_(v, jn.findValue("@value"));
            refPolicy.putInputReference(-id, value, Room.class);
            return value;
        }
        throw new com.expedia.tesla.serialization.TeslaDeserializationException(String.format(
        	"Invalid Tesla JSON reference encoding, expect a '@reference' or '@id' property for type \"reference<class<Room>>\"!"));
    }

    public java.util.HashMap<java.lang.String,java.lang.String> read_nullable_map_java_util_HashMap__string_string__(java.util.HashMap<java.lang.String,java.lang.String> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (jn == null || jn.isNull()) {
            return null;
        } else {
            return read_map_java_util_HashMap__string_string_(v, jn);
        }
    }


    public java.lang.String read_string(java.lang.String v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.textValue();
    }

    public java.util.Collection<Room> read_array_java_util_Collection_java_util_HashSet__reference_class_Room___(java.util.Collection<Room> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        java.util.Map<Integer, Room> nv = new java.util.TreeMap<Integer, Room>();        
        for (int i = 0; i < v.size(); i++) {
            nv.put(i, com.expedia.tesla.utils.ArrayUtils.get(v, i));
        }
        while (itr.hasNext()) {
            int index = itr.next().intValue();
            read_reference_class_Room__(nv.get(index), itr.next());
        }
        v.clear();
        v.addAll(nv.values());
        return v;
    }


    public int read_uint32(java.lang.Integer v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return (int)jn.longValue();
    }

    public boolean read_boolean(java.lang.Boolean v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        return jn.booleanValue();
    }

    public java.util.HashMap<java.lang.String,java.lang.String> read_map_java_util_HashMap__string_string_(java.util.HashMap<java.lang.String,java.lang.String> v, com.fasterxml.jackson.databind.JsonNode jn) throws java.io.IOException, com.expedia.tesla.serialization.TeslaDeserializationException {
        if (!jn.isArray())
            throw new AssertionError("BUG, not a json array value");
        java.util.Iterator<com.fasterxml.jackson.databind.JsonNode> itr = jn.elements();
        while (itr.hasNext()) {
            v.put(read_string((java.lang.String)null, itr.next()), read_string((java.lang.String)null, itr.next()));
        }
        return v;
    }


}




