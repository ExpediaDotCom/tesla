Tesla
=========

Tesla is a template based object oriented metaprogramming tool that 
makes it easy to create high performance, serializable, transportable, flexible and 
portable object data models for SOA applications. It frees 
software engineers from manually writing boiler-plate source 
code for object constructors, getters, setters, serialization, 
change detections and notifications, versioning, etc. 

Features
=========

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
mvn archetype:generate -DgroupId=com.mycompany.hello -DartifactId=hello -DarchetypeArtifactId=tesla-quickstart -DinteractiveMode=false
```

### Create Schema

Enter the project root folder. Create a text file with name ```hello.tml```, and copy the following schema into the text file:

```
<schema xmlns="urn:expedia:tesla:tml:v2" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <version name="hello v1.0" number="1"/>
  <namespace name="com.mycompany.hello" />
  <types>
    <class name="HelloMessage" >
      <field name="Greeting" type="string"/>
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

### Build Project

Add following dependencies to the ```pom.xml``` of the project.

```
   <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.4.2</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>2.4.2</version>
    </dependency>
    <dependency>
      <groupId>com.expedia.tesla</groupId>
      <artifactId>tesla-core</artifactId>
      <version>1.0-SNAPSHOT</version>
    </dependency>
    <dependency>
      <groupId>org.apache.commons</groupId>
      <artifactId>commons-lang3</artifactId>
      <version>3.3</version>
    </dependency>
    <dependency>
      <groupId>org.eclipse.jetty.aggregate</groupId>
      <artifactId>jetty-all</artifactId>
      <version>9.2.3.v20140905</version>
   </dependency>
```

### Say "Hello"

Put following source code into ```src/main/java/com/mycompany/hello/HelloTesla.javad```.

```
package com.mycompany.hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
 
public class HelloTesla extends AbstractHandler {
 
    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        HelloMessage msg = new HelloMessage();
        msg.setGreeting("Hello Tesla!");
        Serializer.newJsonWriter(Serializer.VERSION_HELLO_V1_0, response.getOutputStream()).write(msg);
    }
 
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new HelloTesla());
        server.start();
        server.join();
    }
}
```

Build and run the project with following commands: 

```
mvn clean install
mvn exec:java -Dexec.mainClass="com.mycompany.hello.HelloTesla"
```

If everything goes well, the hello world service should be ready. Now we can try to access the hello world service with web browser. Open URL http://localhost:8080/ in browser, you will get following JSON message.

```
{
Greeting: "Hello Tesla!"
}
```

Switch To Binary Encoding
-------------------------

So far e have tested our service with JSON encoding. Now let's switch to Tesla binary encoding. Binary encoding will improve service performance dramatically in a real world application.

We called method ```Serializer.newJsonWriter()``` to create a JSON writer object that serializes ```HelloMessage``` object into JSON. Now we replace it with method ```Serializer.newBinaryWriter()```. This method will create a binary writer that can serialize objects in Tesla binary encoding. Now the file ```HelloTesla.java``` will looks like following

```
package com.mycompany.hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class HelloTesla extends AbstractHandler {

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("application/tesla;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        HelloMessage msg = new HelloMessage();
        msg.setGreeting("Hello Tesla!");
        Serializer.newBinaryWriter(Serializer.VERSION_HELLO_V1_0, response.getOutputStream()).write(msg);
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new HelloTesla());
        server.start();
        server.join();
    }
}
```

Now let's compile and run our hello service again. After the service starts. We use ```wget``` tool to download the binary message and save to a file ```greeting.tesla```. Run following command line in a terminal window. Or use a brower to open URL http://localhost:8080 and save the downloaded file into ```greeting.tesla```.

```
wget --output-document=greeting.tesla http://localhost:8080
```

Now we can inspect the binary message by a hex dumper. Run ```hexdump -v greeting.tesla```, we will get following hex dump.

```
0000000 0c 48 65 6c 6c 6f 20 54 65 73 6c 61 21         
000000d
```

As you can see, the first byte is ```0x0C``` (12). It follows 12 bytes. 

Because we are using binary format. Our client generally will create a client application to decode the binary message. Before a client can decode a binary message, he will need to know the format of the message. In Tesla, we just share the schema file (TML) to our client. Client can run Tesla compiler generate their own code, possibly another programming language, to parse the binary messages. 

Now, let's build a client application to parse this binary message. In stead of creating a client application, we just add another class to our ```hello``` project so that the jar can be used as both client and server.

Creaet file ```src/main/java/com/mycompany/hello/HelloTesla.java``` with follwoing source code.

```

package com.mycompany.hello;

import java.io.ByteArrayInputStream;

import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.HttpClient;

class HelloClient {

	public static void main(String... args) throws Exception {
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		
		ContentResponse response = httpClient.GET("http://localhost:8080");
		HelloMessage msg = Serializer.newBinaryReader(
				Serializer.VERSION_HELLO_V1_0, 
				new ByteArrayInputStream(response.getContent())
			).read((HelloMessage)null);
			
		System.out.println("Greeting from Tesla server: " + msg.getGreeting());
			
		httpClient.stop();
	}

}
```

This client will call our greeting server and download a Tesla binary message. And then we decode it to a ```HelloMessage``` object. 

Let's recompile our project and start server again.

```
mvn clean install
mvn exec:java -Dexec.mainClass="com.mycompany.hello.HelloTesla"
```

In another terminal window, we ran our client by following commmand.

```
mvn exec:java -Dexec.mainClass="com.mycompany.hello.HelloClient"
```

If things are going well, you will see following output.

```
BELC02KK1L0FFT3:hello yzuo$ mvn exec:java -Dexec.mainClass="com.mycompany.hello.HelloClient"
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building hello 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:1.3.2:java (default-cli) @ hello ---
[WARNING] Warning: killAfter is now deprecated. Do you need it ? Please comment on MEXEC-6.
2014-09-25 16:30:56.841:INFO::com.mycompany.hello.HelloClient.main(): Logging initialized @2177ms
Greeting from Tesla server: Hello Tesla!
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.144 s
[INFO] Finished at: 2014-09-25T16:30:56-07:00
[INFO] Final Memory: 10M/245M
[INFO] ------------------------------------------------------------------------
```

See, we got the greeting.

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

Support
-------

Please contact:

- Yunfei Zuo: [yzuo@expedia.com](mailto://yzuo@expedia.com)
- Expedia Tesla Working Group: [tesla@expedia.com](tesla@expedia.com)
