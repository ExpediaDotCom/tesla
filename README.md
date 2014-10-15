Tesla
=========

Tesla is a source code generation based binary object serialization framework built for high performance service messaging. It is similar to Protobuf, but has ability to serialize user objects directly into binary buffer without copying data between user objects and generated temporary objects. Unlike similar frameworks, Tesla use a template based source code generator to generate source code for all languages and platforms Tesla supports, includes Java, C++ and C# on Windows, Linux and Mac OS. The template based source code generation allows users to customize their generated source code by simply editing a template. It also make it easy to extend Tesla to serialize object in other formats (such as JSON, XML and BSON) and do other property wise operations (such as comparing objects, ```toString()```, ```hashCode()```, coping objects, generating and applying changes, etc). Extending Tesla to a new programming language is also simplied, because the same code generator can generates source code in a different language easily via a different source code template. 


Features
-----------------------------------------------------------------

1. High performance

	Tesla serialization is very efficient because the generated code is compiled. Generally, it’s about tens to hundreds of times faster than its reflection based counterparts. Tesla serialization defines a binary encoding which is similar to Google’s Protobuf but without field ids. This binary message format is about 30% less than Protobuf in size. 

	Tesla's built-in flyweight reference may dramatically reduce the size of serialized objects if there are identical objects. 

2. Automatic strong versioning

	It is extremely easy to create backwards-compatible service in Tesla. Tesla defines each application schema version in its own schema file. You can change the application schemas without worrying about backwards compatibility very much when you are working on the next version of your service application. Tesla will resolve the schema difference and generate code that is compatible with all previous versions.
 
3. Cross-language support

	Tesla schema is language neutral. The same schema can be translated into source code of any object oriented programming languages by Tesla compiler. Tesla compiler currently has built-in templates that generate serialization and change detection code for C++, Java and C#, and we will keep adding more. It is easy to extend Tesla to another language. For example, you can simply alter the Java templates to use JavaScript syntax to generate JavaScript source code, which is able to deserialize an object serialized by a C++ service in binary format.

4. Object reference and flyweight pattern

	Tesla object reference may reduce the size of serialized objects dramatically if you have many identical objects. Tesla will make sure there is only one copy of the serialized object data included in the encoded binary data, even if you have multiple copies or it was referred at multiple places in the same message context. For example, if you have a list of 10 identical objects, Tesla will only encode the object once.

5. Serialize objects with reference loop

	With Tesla reference, you can serialize an object graph with reference loops. If you have two objects A and B, A has a member that holds a reference to B, while B has a member holds a reference to A. Usually; we just follow the references and serialize the whole object graph. However, this won't work if there is a reference loop inside the object graph. Tesla can break the loop automatically by defining the reference properties as Tesla reference in the Tesla schema.

6. Serialization with or without data transfer object (DTO)

	Tesla was originally built for a project that has hundreds of complicated objects. Most other binary protocols require us to use generated pure data transfer objects. We found that copying data between our business objects and generated data transfer objects is very expensive in a large scale service. We need to write a lot of code to copy data at development time. More importantly, the data copying between business objects and data transfer object wasted a lot of compute resources for a large scale service like ours. The goal of Tesla is make it easier to adopt for a real world application.

	Tesla can generate source code for classes and enums from schemas. This is very useful when you start from scratch. However, when you already have some source code, or you don't like separate your data (properties) from behavior (methods), you can use partial code generation, which generates serialization code only.

7. Multiple serialization encodings

	Tesla compiler comes with built-in templates for generating objects that can be serialized in binary and JSON format. You can extend Tesla to serialize objects in other formats like XML or BSON. Tesla supports different encoding method by providing different source code templates.

8. Object change detection and incremental updating

	Tesla comes with Velocity templates that can be used to generate source code to calculate and encode object changes. The generated code recursively compares object properties, and only serialize the properties that are not the same. This makes it easy to push data changes incrementally from data source to subscribers.

9. Support annotations and generate schema from existing source code

	You can generate Tesla schema from existing Java classes and enums. You can deliver this schema to your service clients after your service is released. (We will add this feature to C# in the future).

10. Flexible type mapping

	Tesla allows you to choose concrete types used in your source code. For example, you can choose between ```ArrayList<Integer>``` and ```int[]``` in Java, or betweeen ```vector<int>``` and ```list<int>``` in C++. There are more advanced type mappings in C++ API which allows you to map any type to Tesla types. 

11. Customize generated source code 

	Tesla allows developers control the generated source code. For example, developers can insert Java annotations or .Net attributes in the generated classes or properties to support XML formatting. You can add performance logs into the serialization methods to measure the runtime performance. You can also add helper methods into generated classes to feed your needs.

12. Multiple dimensional array

	Tesla has built-in support for multiple dimensional arrays. 

13. Multiple inheritance and polymorphic objects

	You can use inheritance in Tesla. A user object can extend another user object. Tesla even allows you to use multiple inheritances. However, the inheritance hierarchy may not retained in a programming language doesn’t support multiple inheritance, for example, Java and C#.

Languages
----------

Built in language support:

- Java
- C++
- CSharp

All programming languages use the same compiler to generate source code. The Tesla compiler itself is written in Java.

Quick Start
-----------

Let's build a hello world Tesla application in Java. 

### Build Tesla Compiler

Tesla compiler is a command line tool that generates serialization source code for all languages Tesla supports. We will use it to generate Java source code in this Java tutorial. However, the same build can be used to generate C++ and C# source code as well. The Tesla compiler requires Java 1.7 or newer to run.

Enter Tesla root directory and build it using [Apache Maven](http://maven.apache.org/)

```
mvn clean install
```

Try to run Tesla compiler with command

```
java -jar compiler/target/tesla-compiler-executable-1.0-SNAPSHOT.jar
```

Tesla compiler will give a usage message. Now we have build Tesla compiler successfully. Let's move on to create a Hello World application in Java. 

### Create a Maven Project

To make it easier, let's create our Hello World project with Maven project generator. Change your current directory to where you would like to place the project, and then run the following command line:

```
mvn archetype:generate -DgroupId=com.mycompany.hello -DartifactId=hello -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

Maven project generator will create a directory ```hello``` with a file ```pom.xml``` and ```src``` subdirectory.

### Create Schema

Enter the project root directory ```hello```. Create a text file with name ```hello.tml```, and copy the following schema into the text file:

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

The above schema defined just one object ```HellowMessage```. It has a string field ```greeting```. The message is put into a default namespace ```com.mycompany.hello```. Every schema must specify a ```version```. The version name is required while the version number is optional. 

You can also use full name on the ```name``` attribute of the ```class``` element, which allows you to put your objects into different namespaces.

### Generate Java Source Code

Run the Tesla compiler to generate Java source code. Please replace the ```<tesla-root>``` with your Tesla source code directory where you built Tesla compiler.

```
java -jar <tesla-root>/compiler/target/tesla-compiler-executable-1.0-SNAPSHOT.jar -o src/main/java -s com.mycompany.hello.Serializer hello.tml
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

In this example, we need Jackson as our generated JSON serialization code uses it as the JSON formatter. Apache ```commons-lang3``` is used to implement ```equals()``` and ```hash()``` method. 

### Say "Hello"

Put following source code into ```src/main/java/com/mycompany/hello/HelloTesla.java```.

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

So far we have tested our service with JSON encoding. Now let's switch to Tesla binary encoding. Binary encoding will improve service performance dramatically in a real world application.

We called method ```Serializer.newJsonWriter()``` to create a JSON writer object that serializes ```HelloMessage``` object into JSON. Now we replace it with method ```Serializer.newBinaryWriter()```. This method will create a binary writer that can serialize objects in Tesla binary encoding. Now the file ```HelloTesla.java``` will looks like following:

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

Now let's compile and run our hello service again. After the service is started, we use ```wget``` tool to download the binary message and save it to a file ```greeting.tesla```. Run following command line in a terminal window. Or use a browser to open URL http://localhost:8080 and save the downloaded file into ```greeting.tesla```.

```
wget --output-document=greeting.tesla http://localhost:8080
```

Now we can inspect the binary message by a hex dumper. Run ```hexdump -v greeting.tesla```, we will get following hex dump.

```
0000000 0c 48 65 6c 6c 6f 20 54 65 73 6c 61 21         
000000d
```

As you can see, the first byte is ```0x0C``` (12). It follows 12 bytes. 

Our clients generally will write some source code to decode a binary message. Before a client can decode a binary message, he will need to know the format of the message. In Tesla, we just share the schema file (TML) to our client. Client can run Tesla compiler generate their own code, possibly another programming language, to parse the binary messages. 

Now, let's build a client application to parse this binary message. Instead of creating a client application, we just add another class to our ```hello``` project so that the jar can be used as both client and server.

Create file ```src/main/java/com/mycompany/hello/HelloTesla.java``` with following source code.

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

Tesla Specification
------------

Please refer Tesla specification [here](specification.md).

Support
-------

Please contact:

- Yunfei Zuo: [yzuo@expedia.com](mailto://yzuo@expedia.com)
- Expedia Tesla Working Group: [tesla@expedia.com](tesla@expedia.com)
