Tesla
=========

Tesla is a template based object oriented metaprogramming tool that 
makes it easy to create high performance, serializable, transportable, flexible and 
portable object data models for SOA applications. It frees 
software engineers from manually writing boiler-plate source 
code for object constructors, getters, setters, serialization, 
change detections and notifications, versioning, etc. 

- Customizable template based source code generation
- High performance
- Automatic strong versioning
- Cross-language support
- Supports object reference
- Built in flyweight pattern support
- Supports multiple dimensional array and map
- Supports multiple inheritance and polymorphic objects
- Flexible type mapping
- Serialization with or without data transfer object (DTO)
- Multiple serialization encodings
- Object change detection and incremental updating
- Support annotations and generate schema from existing source 
code

Languages
----------

Built in language support:

- Java
- C++
- CSharp

Quick Start
-----------

Let's build a hello world Tesla application in Java.

### Build Tesla Compiler

The Tesla compiler requires Java 1.7 or newer to run.

Enter the Java project root directory and build using [Apache Maven](http://maven.apache.org/)

```
mvn clean install
```

Try to run Tesla compiler with command
```
java -jar tesla-compiler/target/tesla-compiler-executable-1.0-SNAPSHOT.jar
```

Tesla compiler will give a usage message.

### Create a Maven Project

Create Hello World project with Maven project generator:
```
mvn archetype:generate -DgroupId=com.mycompany.hello -DartifactId=hello -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

### Create Schema

Enter the project root folder. Create a text file with name ```hello.tml```, and copy the following schema into the text file:
```
<?xml version="1.0" encoding="UTF-8"?>
<schema xmlns="urn:expedia:tesla:tml:v2" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <version name="hello v1.0" number="1"/>
  <namespace name="com.mycompany.hello" />
  <types>
    <class name="HelloMessage" >
      <field name="greeting" type="string"/>
    </class>
  </types>
</schema>
```

The above schema defined just one object ```HellowMessage```. It has a string field ```greeting```. The message is put into namespace ```com.mycompany.hello```. Every schema must specify a ```version```. The version name is required while the version number is optional.

### Generate Java Source Code

Run the Tesla compiler
```
java -jar tesla-compiler/target/tesla-compiler-executable-1.0-SNAPSHOT.jar -o src/main/java -s com.mycompany.hello.Serializer hello.tml
```

Tesla compile will generates two Java source files:
```
src/main/java/com/mycompany/hello/HelloMessage.java
src/main/java/com/mycompany/hello/Serializer.java
```


Tesla Schema
------------

A Tesla schema is a user object defintion version. Tesla schemas defined by Tesla Markup Language (TML), which itself is defined in XML. Developers

Each schema can define a default global name space, all user defined types will be put into this global namespace if they are not defined with a full name. 
User objects are defined as class nodes under ```/schema/types```. Each object definition must have a type name and optionally a description attribute. Object type name can be short name or full name. A full name is a dot separated names just like a C# or Java full class name. Objects are put into the global default namespace if short name is used.
Each user object can has one or more fields. Each field has a name, a type attribute, and optionally displayName, rank, nullable, reference and description attributes. The field name must be unique inside the same object. It can be any predefined types or user defined types (object or enum). Array fields are defined by array ranks, it's zero by default, which is not array. A 1-D array is defined with rank = 1, a 2-D array is defined with rank = 2, etc. You can set nullable to true for types that support nullability ( String, Binary, Object and Array ). Object reference is defined by set reference attribute to true.
Enums are defined as enum nodes under  /schema/types. Each enum definition must have a type name and optionally a description attribute. Enum type name can be short name or full name. A full name is a dot separated names just like a C# or Java full enum name. Objects are put into the global default namespace if short name is used. Each object must have one or more enum entries. Each enum entry has a name and a int32 value, and an optional description.
All names can only use letters, digits or underscores, and must start with either letter or underscore (not digit). They are case sensitive except for Tesla predefined types (int32 is the same as Int32). 
Each TML defines an application schema version. Tesla use the TML file hash as the schema version. However, this has is not easy to human. You can give an friendly name to your schema. You can name your schema by defining /schema/version node. It has a name and an optional number attribute.
Following is an example TML a student information service. The request is a student id list and the service returns a list student of student information. If there is duplicated IDs in the request, the student list in the response may refer to the same object.
Data Types
----

###Tesla Primitive Types
Name | Description | Native C++ Type | Native C# Type | Native Java Type
-----|-------------|-----------------|----------------|------------------
Boolean | True or false value | bool | bool | boolean
Byte | Single unsigned byte (8-bit) | uint8_t | Byte | byte
Int16 | Signed 16-bit integer | int16_t | Int16 | short
Int32 | Signed 32-bit integer | int32_t | Int32 | int
Int64 | Signed 32-bit integer | int64_t | Int64 | long
UInt16 | Unsigned 16-bit integer | uint16_t | UInt16 | int
UInt32 | Unsigned 32-bit integer | uint32_t | UInt32 | long
UInt64 | Unsigned 32-bit integer | uint64_t | UInt64 | long
Float | IEEE Standard 754 Floating-Point (32-bits) | float | float | float
Double | IEEE Standard 754 Floating-Point (64-bits) | double | double | double
Binary | Sequence of bytes | std::vector<uint8_t> | Byte[] | byte[]
String | String | std::string | String | String

Tesla Serialization
----

