Tesla Messaging Specification V2
=========

## Goal 

Tesla is a messaging framework that delivers application messages between applications. The following are the goals of Tesla:

- High performance
- High flexibility
- Language and platform independent 

Tesla encodes data efficiently for both speed and size. Unlike most other high performance frameworks, Tesla does not force the user to use generated intermediate objects. The user can serialize and deserialize their objects directly to wired format.

## Data Types

### Tesla Primitive Types

Name | Description | Native C++ Type | Native C# Type | Native Java Type
-----|-------------|-----------------|----------------|------------------
Boolean | True or false value | bool | bool | boolean
Byte | Single unsigned byte (8-bit) | uint8_t | Byte | byte
Int16 | Signed 16-bit integer | int16_t | Int16 | short
Int32 | Signed 32-bit integer | int32_t | Int32 | int
Int64 | Signed 64-bit integer | int64_t | Int64 | long
UInt16 | Unsigned 16-bit integer | uint16_t | UInt16 | int
UInt32 | Unsigned 32-bit integer | uint32_t | UInt32 | long
UInt64 | Unsigned 64-bit integer | uint64_t | UInt64 | long
Float | IEEE Standard 754 Floating-Point (32-bits) | float | float | float
Double | IEEE Standard 754 Floating-Point (64-bits) | double | double | double
Binary | Sequence of bytes | std::vector<uint8_t> | Byte[] | byte[]
String | String | std::string | String | String

### User Types

Name | Description | Native C++ Type | Native C# Type | Native Java Type
-----|-------------|-----------------|----------------|------------------
Enum | Enumeration. Each enum entry must has a name and an signed 32-bit integer value.	| enum | enum | enum
Object | User define composite type with one or more properties. Each property must has a name and a type. Properties can have any Tesla type, include fundamental types, user types or arrays. | class or struct | class | class

### Array

Tesla array is a list of values with the same type. Tesla supports multidimensional arrays. A multidimensional array is defined as a list of lists. For example a 2D int32 array is a list of int32 list. It is std::vector<std::vector<int32_t> > in C++, List<List<int>> in C# or List<List<Integer> in Java respectively.

### Map
Tesla map is a list of key value pairs. 

### Poly
Models a polymorphic object. For example, an object property that holds reference of parent type, but can be assigned with a value of one of the derived types. 

### Nullabilty

Non-numeric data type values can be null, this include String, Binary, Object and Array. Numeric types, including boolean, signed and unsigned integer types, float/double, and enum, can NOT be null. They always have some value.

### Reference

Tesla object reference may reduce the size of serialized objects dramatically if you have many identical objects. Tesla will make sure there is only one copy of the serialized object data included in the encoded binary data, even if you have multiple copies or it was referred at multiple places in the same message context. For example, if you have a list of 10 identical objects, Tesla will only encode the object once.

Tesla Reference can only refer to objects with the same type within the same context (message or session). This is similar to Java or C# reference, but not necessary identical to it. This spec only requires an implementation to serialize multiple identical object values once if they are defined as reference in the schema. The implementations or customer code can decide to use pointers (or references in Java and C#) or make copies in their user code. 

With Tesla reference, you can serialize an object graph with reference loops. If you have two objects A and B, A has a member that holds a reference to B, while B has a member that holds a reference to A. Usually we follow the references and serialize the whole object graph. However, this won't work if there is a reference loop inside the tree. Tesla can break the loop automatically by defining the reference properties as Tesla reference in the Tesla schema.

## Encoding

Tesla officially supports the following encodings. Binary encoding is optimized for performance while JSON and XML are better for human readability and flexibility.

- Binary
- JSON
- XML

### Binary Encoding

Byte is encoded in the same single byte. Unsigned integer types (uint16, uint32 and uint64) are encoded with unsigned LEB128 encoding. Signed integer types (int16, int32 and int64) are encoded with ZigZag LEB128 variant.

Boolean is encoded in one byte with 0x0D for true and 0x05 for false. Enums are encoded the same way as int32 by their corresponding integer values. 

Float values are encoded as 32-bit IEEE 754 floating points, and double values are encoded as 64-bit IEEE 754 floating points.

String, binary and array values are length prefixed. Strings are encoded with an unsigned LEB128 encoded uint64 length prefix followed by that many bytes of UTF-8 encoded characters. Binary values are encoded with an unsigned LEB128 encoded uint64 length prefix followed by that many bytes. Arrays are encoded with an unsigned LEB128 encoded uint64 length prefix followed by that many binary encoded elements. 

Nullable value is encoded as a binary encoded boolean value false (0x05) followed by its binary encoded non-nullable counterpart if the value is not null. Otherwise, it's encoded as binary encoded boolean value true (0x0D).

Each object reference will be assigned a positive integer (>0) reference ID by the Tesla serialization library when it is serialized for the first time. This ID must be unique for each object type in the same context. When an object reference is serialized, Tesla will find if the same object has been serialized.  If the object has not been serialized previously, Tesla will assign a new id n (n>0) to this object and then write a negative ZigZag encoded int64 value -n followed by the serialized object itself to the output stream. Otherwise, Tesla will only write the positive reference id n with ZigZag encoding. A Nullable object reference will be prefixed with a null flag the same way described above. 

Maps are serialized as an array of key value pairs. The key and value are recursively encoded in their binary encoding.

### JSON Encoding

Tesla JSON encoding is target for human readability. Numeric types (byte, integer types and float point types) are encoded with JSON numbers. Boolean values are encoded with JSON booleans. Strings, objects and arrays are encoded with their JSON counterparts. JSON does not support binary value directly. Tesla will encode binary values as BASE64 encoded string values.

## Tesla Schema

A Tesla schema is a user object definition version. A Tesla schema is defined by Tesla Markup Language (TML), which itself is defined in XML. 

Each schema can define a default global name space. All user defined types will be put into this global namespace if they are not defined with a full name. 
User objects are defined as class nodes under ```/schema/types```. Each object definition must have a type name and optionally a description attribute. Object type name can be short name or full name. A full name is a dot separated name just like a C# or Java full class name. Objects are put into the global default namespace if short name is used.
Each user object can have one or more fields. Each field has a name, a type attribute, and optionally ```displayName```, ```rank```, ```nullable```, ```reference``` and ```description``` attributes. The field name must be unique inside the same object. It can be any predefined type or user defined type (object or enum). Array fields are defined by array ```rank```. It is zero by default, which indicates that the field is not an array. A 1-D array is defined with ```rank = 1```, a 2-D array is defined with ```rank = 2```, etc. You can set ```nullable``` to true for types that support nullability ( String, Binary, Object and Array ). Object reference is defined by set reference attribute to true.
Enums are defined as enum nodes under  ```/schema/types```. Each enum definition must have a type name and optionally a description attribute. Enum type name can be short name or full name. A full name is a dot separated name just like a C# or Java full enum name. Objects are put into the global default namespace if short name is used. Each enum  must have one or more enum entries. Each enum entry has a name and an int32 value, and an optional description.
All names can only use letters, digits, or underscores, and must start with either letter or underscore (not digit). They are case sensitive except for Tesla predefined types (int32 is the same as Int32). 
Each TML defines an application schema version. Tesla uses the TML file hash as the schema version. However, this is not easy to humans. You can give a friendly name to your schema. You can name your schema by defining a ```/schema/version``` node. It has a name and an optional number attribute.
Following is an example TML for a student information service. The request is a student id list and the service returns a list student of student information. If there are duplicated IDs in the request, the student list in the response may refer to the same object.

```
<schema xmlns="urn:expedia:tesla:tml:v2" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <version name="Student v1.0" number="1"/>
    <namespace name="com.expedia.student" />
    <types>
        <class name="Person">
            <field name="FirstName" type="string" />
            <field name="LastName" type="string" />
            <field name="Adult" type="boolean" />
            <field name="Sex" type="Sex" />
        </class>
        <class name="Student" extends="Person">
            <field name="Id" type="int32" />
            <field name="Major" type="string" />
        </class>
  
        <class name="FindStudentRequest">
            <field name="Id" type="int32" rank="1"/>
        </class>
        <class name="FindStudentResponse">
            <field name="Students" type="Student" rank="1" nullable="true" reference="true"/>
        </class>
  
        <enum name="Sex">
            <entry name="Male" value="1" />
            <entry name="Female" value="2" />
        </enum>
    </types>
</schema>
```

## Versioning

Each TML defines an application object version in Tesla. This is identified by the Tesla schema hash. Every single change to the Tesla schema defines a new version regardless of whether you change the version number or not. This is called strong versioning. With strong versioning, people won't run into an error when the server and client claim they  have the same version 2, but actually have different definitions. 
With the strong versioning system, you can add, delete, and reorder fields very easily. To create a newer version of an application with backward compatibility, developers just copy the existing TML and add, delete or reorder fields as if they don't need to consider versioning. Once the new TML is finished, both new and old TMLs can be provided to Tesla compiler to validate schemas and generate code (either full or partial). Compiler will merge all user object definitions from all versions, and create a version that can support all input versions. 

For a class, the merged version will contain the union of fields defined in all versions. For an enum, the merged version will have a union of all enum values from all versions. Tesla will verify if the object property types or enum values are compatible. It generates a compile error when there are any compatibility issues. For example, an enum value Male was changed to ```2``` in schema v2 while it was defined as value ```1``` in schema v1.

The golden rule that must be followed for Tesla strong versioning is: never change a released schema. Create a new one for every new release. A schema is locked down once it is release and clients are using it. 

For example, you have a student service with following schema in your first release: ```studend-v1.tml```


```
<schema xmlns="urn:expedia:tesla:tml:v2" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <version name="Student v1.0" number="1"/>
    <namespace name="com.expedia.student" />
    <types>
        <class name="Person">
            <field name="FirstName" type="string" />
            <field name="LastName" type="string" />
            <field name="Adult" type="boolean" />
            <field name="Sex" type="Sex" />
        </class>
        <class name="Student" extends="Person">
            <field name="Id" type="int32" />
            <field name="Major" type="string" />
        </class>
  
        <class name="FindStudentRequest">
            <field name="Id" type="int32" rank="1"/>
        </class>
        <class name="FindStudentResponse">
            <field name="Students" type="Student" rank="1" nullable="true" reference="true"/>
        </class>
  
        <enum name="Sex">
            <entry name="Male" value="1" />
            <entry name="Female" value="2" />
        </enum>
    </types>
</schema>
```

And then, you need to update your Student to do following: 

- Reorder properties: Make LastName the first property.
- Add new properties: Age and MiddleName
- Delete properties: Adult boolean

You will copy ```Student-v1.tml``` to ```Student-v2.tml```, then change its version name and number, and then update class definitions.

```
<schema xmlns="urn:expedia:tesla:tml:v2" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <version name="example v2.0" number="2"/>
    <namespace name="com.expedia.student" />
    <types>
        <class name="Person">
            <field name="LastName" type="string" />
            <field name="MiddleName" type="String"/>
            <field name="FirstName" type="string" />
            <field name="Age" type="byte" />
            <field name="Sex" type="Sex" />
        </class>
        <class name="Student" extends="Person">
            <field name="Id" type="int32" />
            <field name="Major" type="string" />
        </class>
  
        <class name="FindStudentRequest">
            <field name="Id" type="int32" rank="1"/>
        </class>
        <class name="FindStudentResponse">
            <field name="Students" type="Student" rank="1" nullable="true" reference="true"/>
        </class>
  
        <enum name="Sex">
            <entry name="Male" value="1" />
            <entry name="Female" value="2" />
        </enum>
    </types>
</schema>
```

## Schema Version

Tesla schema version has three components: name, number, and hash. The schema name is required in TML V2. The schema name can contains letters, numbers, dots (.), underscores, and spaces. They must be unique. The number is an optional integer. These two components are user friendly components. The version number can be used to sort or index application versions. Schema hash is the SHA-1 TML file hash truncated to a 64-bit integer, which is generated by Tesla compiler from the TML file. Please refer to the Tesla Schema section for version definition inside TML.

Tesla versions application schemas by schema hash internally. The generated code will use schema hash to detect the application schema version. This strong versioning system requires a schema never be changed after it is released. Any future versions will have their own TML files.

## Integrate with Tesla

### Full Code Generation

Tesla compile can generate full class definitions from schemas. The generated classes or enum code will be able to be serialized with all schema versions. Because the source code files are ready to compile, developers can start this way very quickly, especially if there is not existing code. However, if there are a lot of existing user application objects and we just need to send them to another service over the wire, using full code generation will requires hand written mapping code that converts between user objects and the generated objects. This may be wasteful of resource and slow down the application if the objects are large enough. 

### Partial Code Generation

Because Tesla compiler is just a tool that converts schemas into text files, users can customize the generated source code by user templates and plugins. A developer can generate serialization and deserialization code only and use them to serialize and deserialize existing objects. With partial code generation, the application objects that have business logic built in can be serialized directly. This reduces cost for both runtime and development time. 

### Dynamic Code Generation

C# and Java can build and load assembly at runtime. An application can generate byte code or assembly from TML directly, so that whenever there is a change to TML, the application won't need to be recompiled. (Tesla Visualizer tool is implemented in this way). 

### No Code Generation

If versioning is not an issue, the user can write serialize and deserialize methods manually without TML and compiler. 

## Tesla Messaging

Tesla no longer provides a full protocol stack because there are too many different settings on how to manage the transportation, connection, logging, monitoring, proxy and routing, etc. People like to define their own communication protocols based on their requirement and platform. As a common purpose framework, Tesla is only trying to delivery messages between applications and it doesn’t care about the transportation layer. Tesla only defines Tesla message that can help applications to exchange the meta-information used by Tesla serialization. Users will manage connection by themselves.
What is needed by Tesla to serialize and deserialize a message? Schema Version!

### Channel

Schema hash, encoding, compression method and transfer mode can not be changed inside a single channel. The type of encoded object can be change in case multiple message types need to be transferred in the same channel. 

#### Typed Channel

The message channel is bound to a single message type. It can only be used to transfer the same type of messages. The message type must be defined in the current schema of the channel.
Messages can be sent without an extra message header if the channel is typed and streamed. 

#### Untyped Channel

The message channel is not bound to any message type. It can be used to transfer any message type defined in the schema.
Untyped messages will be prefixed with a message header that contains message type name.

### Message Transfer Mode

#### Streamed Transfer

Streamed transfer chains the Tesla streams to the transportation layer stream (e.g. TCP stream) directly. There might be a small buffer inside each stream, but it is not required to hold all message bytes in the memory before the data can be transferred through the transportation layer or deserialized to an object. For large messages, this may save a lot of memory and improve the scalability of your services.

#### Buffered Transfer

Buffered transfer requires a buffer that can hold the whole serialized message. The message object has to be fully serialized into this buffer before it can be transferred, or read into this buffer before it can be deserialized.
Buffered transfer channels will insert a message header in front of every message, with the size of the message in the header.


```
<schema xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="urn:expedia:e3:data:tesla:tml:v2">
    <version name="Tesla Messaging V2" number="2"/>
    <namespace name="com.expedia.tesla.messaging" />
    <types>
        <class name="OpenChannel">
            <field name="schema" type="SchemaVersion" />
            <field name="encoding" type="Encoding" />
            <field name="compression" type="CompressionMethod" />
            <field name="transfer_mode" type="TransferMode" />
            <field name="message_type" type="string" nullable="true" />
            <field name="extension_string" type="string" nullable="true" />
            <field name="extension_binary" type="binary" nullable="true" />
        </class>
        <class name="CloseChannel">
            <field name="error_code" type="int32" />
            <field name="error_message" type="string" nullable="true" />
            <field name="extension_string" type="string" nullable="true" />
            <field name="extension_binary" type="binary" nullable="true" />
        </class>
        <class name="SchemaVersion">
            <field name="hash" type="int64" />
            <field name="name" type="string" nullable="true" />
            <field name="number" type="int32" />
        </class>
        <class name="MessageHeader">
            <field name="message_type" type="string" nullable="true" />
            <field name="size" type="unit64" />
            <field name="extension_string" type="string" nullable="true" />
            <field name="extension_binary" type="binary" nullable="true" />
        </class>
        <enum name="Encoding">
            <entry name="Binary" value="1" />
            <entry name="Json" value="2" />
        </enum>
        <enum name="CompressionMethod">
            <entry name="None" value="0" />
            <entry name="deflate" value="1" />
        </enum>
    </types>
</schema>
```

## Support

Please contact:

- Yunfei Zuo: [yzuo@expedia.com](mailto://yzuo@expedia.com)
- Expedia Tesla Working Group: [tesla@expedia.com](tesla@expedia.com)
