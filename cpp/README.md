Tesla C++ API
=========

##Summary

This documentation contains only C++ implementation specific information. For general information about Tesla and Tesla compiler, please refer [Tesla Specification](../specification.md) and [Telsa General Documentation](../README.md).


### Header only library

Tesla V2 C++ library was redesigned to provide better flexibility and performance. It's now a head file only library, just like STL. You don't need to link to a .lib file. You just simply include the head file you needed. Tesla V2 library use C++ templates intensively. You can customize the behavior of Tesla by specialize templates. C++ V2 library is also a lot faster than V1 because the compiler can optimize the code better with templates and inline. 

However, like all other template libraries, there is a drawback with C++ templates: it slows down the compiling and makes the compile error harder to read.

### Type mapping

Unlike other managed languages such as Java and C#, C++ doesn't have stable type mapping between Tesla and user types. Users usually can define many different classes to handle the same information. Tesla doesn't force user to use a set of predefined types. For example, you don't have to use ```int``` for your ```int32``` fields, you can define your own Integer class and map it to ```int32```. Tesla will handle the type casting automatically in most case if they are compatible with the default type or you overload type casting and ```operator =``` for your class. If these are not true, you can still make it work with Tesla by provide traits (specialize Tesla Traits templates) for your type.
A good sample of type mapping is Array. You can map STL containers, C arrays or pointers to Tesla Array types. If you are not using these standard data structures and want to keep customer types like ```GenericArray```s, you can easily traits your type by specializing ```ArrayTraits``` template. 

### Code generation

Tesla was designed for performance and flexibility. We tried our best to provide more flexibility to make it easier to integrate with Tesla. Most other popular high performance serialization frameworks require user to use generated temporary objects. Using generated objects makes it easier to write the serialization library. However, it usually requires more work to write code copy data from your business objects to the generated temporary objects, and it affects performance because you are doing an extra step.

With Tesla you can still do the same thing, but you don't have to pay this cost. You can serialize your object directly. Tesla comes with a powerful code generator that can generate only serialization code for your classes. It's more efficient and easier than using the generated temporary objects. You can also easily insert any customer code to do whatever you like in the generated code. For example, you can add log, callback or performance metrics to generated serialization and deserialization code. You can add attributes to generated Java or C# classes and members. You achieve all these by simply editing the code template.

### Compression

Tesla is optimized for both speed and size. The serialized object size is already small. However, the size may be further reduced by general compression algorithms on top of it if the size object is too large. Compression can be added to Tesla easily by adding ZIP stream filters to the stream object. 

### Portability

Tesla V2 C++ library only depends on STL (and boost/zlib if gzip is used). Following compilers have been proved working successfully. You will also need boost to build the unit tests because unit test code use boost.

- Visual C++ 2008
- GCC 4.2

Type Compatibility and Type Mapping
------------------------------------


Tesla C++ API is very flexible. Most other serialization frameworks require user to use generated temporary objects. Generally, you will have to write mapping code to map your objects to/from these temporary objects. It's not only complex, but also affects performance because these temporary objects and mapping take CPU and memory resources. Tesla can serialize and deserialize C++, STL and user types directly without using generated intermediate objects. It can convert the user objects directly into Tesla format, or construct objects directly from serialized Tesla data. 

### Tesla Type and User Type

In order to avoid the intermediate serialization steps, Tesla must know how to serialize and deserialize all data types in user objects. Tesla defines a set of basic data types, including numeric types, boolean, objects, arrays. However, each data type can be declared in many different C++ types. For example, a boolean value can be declared as ```bool```, ```BOOL```, or user defined ```Bist``` class (bi-state). Following example code shows how Tesla deserialize all those values.


```
typedef int BOOLEAN;
#define TRUE 1;
 
class Bist {
public:
    Bist& operator= (bool b) { ... }
    bool operator bool() const { ... }
};
 
bool a = true;
reader.read("bool_field", a);
a = reader.read<bool>("bool_field");
reader.read(TeslaType_Bool(), "bool_field", a);
 
BOOLEAN b = TRUE;
reader.read(TeslaType_Bool(), "bool_field", b);
 
Bist c ...;
reader.read(TeslaType_Bool(), "bool_field", c);
```

Each Tesla built-in data type has a default C++ type. Tesla knows how to serialize and deserialize the values if the values are declared in these default types. For example, Tesla maps boolean type to C++ type ```bool``` by default. Line 11 (by reference), 12 (by return value) and 13 (by traits) shows 3 different ways to deserialize a boolean value to a value declared as C++ built-in type ```bool```. In Tesla, we will use terms "Tesla Type" and "User Type". Tesla Types are the predefined data types listed in Tesla Spec. We may use "Tesla Type" for both the primitive type name (e.g. ```int32```), or the default C++ type it mapped (.e.g ```int```). User type is the actual type used in the field declaration in user object. Most likely, it will be the same as the default mapped C++ type, however, it can be a different compatible type as we described blow. 

For a list of the basic Tesla types and their default type mapping in C++, please refer [Tesla Specification](../specification.md)

## Type Compatibility

**An user type is compatible with Tesla type if the user type can be statically casted (```static_cast```) to AND be assigned (```operator=```) by the default Tesla type.** 

Everything should works fine if all fields use the default mapped Tesla type for all user object fields. Tesla doesn't need to anything special other than encode/decode the predefined values. However, when you are using a type that doesn't match the default Tesla type, Tesla has to convert the user types to Tesla types or vice versa. By default, Tesla will try to do static type casting if the declared value type doesn't match the schema type exactly. For example, if you serialize a C++ ```int``` type field as Tesla float type (```TeslaType_Float```), tesla will try to use ```static_cast``` to cast the ```int``` value to ```float```. This is because Tesla use template ```StaticCaster``` to cast user types to Tesla types by default. Following is the ```StaticCaster``` template where ```U``` the user type and ```T``` is Tesla default type. 

```
namespace tesla {
 
template <typename U, typename T>
struct StaticCaster {
    typedef U UserType;
    typedef T TeslaType;
    static TeslaType get(const UserType& v) {
        return static_cast<TeslaType>(v);
    }
    static void set(UserType& u, const TeslaType& v) {
        u = v;
    }
};

}
```

### Map your type to Tesla Type

There are three ways to make your type compatible with Tesla types. 

1. Overload typecast operator and operator=

	You can also do the type casting between Tesla types and user defined objects if your object overloads the cast operator and operator = for the Tesla type. For example, you can serialize an Address type as Tesla String if Address class overloads typecast operator and operator= for the default Tesla type std::string.

	```
	class Address {
	private:
	    std::string street_;
    	std::string city_;
    	std::string state_;
    	int zipcode_;
	public:
	    operator std::string() const; {
    	    return toString();
    	}
	 
    	Address& operator=(const std::string& str) {
        	parse(str);
        	return *this;
    	}
	};
	```

2. Specialize ```StaticCaster``` template

	If you are not allowed to change the class definition of your object to overload typecast operator and ```operator=``` for the Tesla type. You can specialize the ```StaticCaster``` template for your class. For example, you can map Address class to Tesla String with following ```StaticCaster``` template specialization.

	```
	class Address {
	private:
        std::string street_;
      	std::string city_;
      	std::string state_;
      	int zipcode_;
	public:
      	operator std::string() const; {
          	return toString();
      	}
	
      	Address& operator=(const std::string& str) {
			parse(str);
			return *this;
      	}
	};
	```

3. Trait your type

	Sometimes it's not easy or doesn't make sense to cast user type to Tesla type. Tesla provides another way to make a user type compatible with Tesla type. Tesla defines following Traits templates can be specialized for user types. With these traits, Tesla can access the user type directly. This may improve performance significantly if the object is very large. 
    
    For example, ```GenericArray``` is an Expedia container that may maps to Tesla Array. The default Tesla array type is ```std::vector```. Conversion between ```RgXYZ``` and ```std::vector<XYZ>``` may become extremely expensive on large arrays. Specializing ```ArrayTraits``` template for ```RgXYZ``` can make Tesla access ```RgXYZ``` directly without intermediate conversion cost. 

	```
    namespace {
	
	template <>
	struct ArrayTraits<RgXYZ > {
		typedef ArrayCategory_InplaceWritable Category;
		typedef RgXYZ Container;
		typedef XYZ& ElementReference;
		struct Adapter {
			static void resize(Container& cntnr, size_t size) {
				cntnr.SetSize(size);
			}
			static ElementReference at(Container& cntnr, size_t index) {
				return Element(index);
			}
		};
	};
	}
	```

	Following is a list of all Tesla traits you can specialize for your types.

	- ```ByteTraits```
	- ```In16Traits```
	- ```Int32Traits```
	- ```Int64Traits```
	- ```UIn16Traits```
	- ```UInt32Traits```
	- ```UInt64Traits```
	- ```FloatTraits```
	- ```DoubleTraits```
	- ```BoolTraits```
	- ```StringTraits```
	- ```BinaryTraits```
	- ```ArrayTraits```
	- ```NullableTraits```
	- ```ObjectTraits```
	- ```EnumTraits```


Support
-------

Please contact:

- Yunfei Zuo: [yzuo@expedia.com](mailto://yzuo@expedia.com)
- Expedia Tesla Working Group: [tesla@expedia.com](tesla@expedia.com)
