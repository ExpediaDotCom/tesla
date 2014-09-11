//==========================================================================
//
// Copyright (C) 2011-2012, Expedia Inc.  All rights reserved.
//
// File:    BinaryWriterTest.cpp
//
// Desc:    Tesla binary writer unit test cases.
//
//==========================================================================
// windows
#define WIN32_LEAN_AND_MEAN
#define NOMINMAX
#include <windows.h>

#pragma warning(disable : 4305 4800 4503)

// stl
#include <algorithm>
#include <iostream>
#include <limits>
#include <sstream>
#include <vector>

// cppunit
#include <cppunit/ui/text/TestRunner.h>
#include <cppunit/extensions/HelperMacros.h>

#include "TestHelpers.h"
#include "cases.h"

using namespace std;

static const char* FILE_NAME = "test.data.tmp";

#ifdef USE_FILE_STREAM

#include <tesla/FileBinaryWriter.h>

using tesla::BasicFileBinaryWriter;

class BinaryWriter : public BasicFileBinaryWriter<fstream>
{
public:

    BinaryWriter() : BasicFileBinaryWriter(FILE_NAME, SchemaVersion(),
        Stream::trunc | Stream::in | Stream::out | Stream::binary)
    {}

    const Buffer& buffer()
    {
        stream_.clear();
        stream_.seekg(0);
        char c;
        while (stream_.get(c).good())
        {
            buffer_.push_back(static_cast<Buffer::value_type>(c));
        }
        return buffer_;
    }

private:
    Buffer buffer_;
};

#elif defined(USE_GZIP_FILE_STREAM)

#include <tesla/GZipFileBinaryWriter.h>

using tesla::GZipFileBinaryWriter;

class BinaryWriter : public GZipFileBinaryWriter
{
public:

    BinaryWriter() : GZipFileBinaryWriter(FILE_NAME)
    {}

    const Buffer& buffer()
    {
        boost::iostreams::close(stream_);

        std::ifstream file(FILE_NAME, std::ios_base::in | std::ios_base::binary);
        boost::iostreams::filtering_istream in;
        in.push(boost::iostreams::gzip_decompressor());
        in.push(file);

        char c;
        while (in.get(c).good())
        {
            buffer_.push_back(static_cast<Buffer::value_type>(c));
        }
        return buffer_;
    }

private:
    Buffer buffer_;
};

#else // USE_MEMORY_STREAM

#include <tesla/MemoryBinaryWriter.h>

typedef tesla::MemoryBinaryWriter BinaryWriter;

#endif // USE_MEMORY_STREAM

namespace tesla
{
    template <typename T>
    struct StaticCaster<variant, T>
    {
        static T get(const variant& val) { return boost::get<T>(val); }
        static void set(variant& lval, const T& rval) { lval = rval; }
    };
}

template<typename T>
void testWrite_ByValue(const Buffer& expected, const T& actual)
{
    BinaryWriter writer;
    writer.write(NULL, actual);
    AssertEquals(expected, writer.buffer());
}

// Enum type use traits version only.
template<>
void testWrite_ByValue<Day>(const Buffer& expected, const Day& actual)
{
}

template<typename T, typename U>
void testWrite_Container(const Buffer& expected, const U& actual)
{
    BinaryWriter writer;
    writer.writeArray(SchemaTraits<T>::TeslaType::Array(), NULL, actual);
    AssertEquals(expected, writer.buffer());
}

//template<typename T, typename U>
//void testWrite_NullAbleContainer(const Buffer& expected, const U& actual)
//{
//    BinaryWriter writer;
//    writer.writeArray(SchemaTraits<T>::TeslaType::ArrayNullable(), NULL, actual);
//    AssertEquals(expected, writer.buffer());
//}

template<typename T, typename U>
void testWrite_Array2D(const Buffer& expected, const U& actual)
{
    BinaryWriter writer;
    writer.writeArray(SchemaTraits<T>::TeslaType::Array2D(), NULL, actual);
    AssertEquals(expected, writer.buffer());
}

template<typename T>
void testWrite_ByValue(Case<T> const& cs) 
{
    testWrite_ByValue(cs.binary, cs.value);
}

template<typename T, typename U>
void testWrite_ByTraits(Case<U> const& cs)
{
    BinaryWriter writer;
    writer.write(SchemaTraits<T>::TeslaType(), NULL, cs.value);
    AssertEquals(cs.binary, writer.buffer());
}

template<typename T>
void testWrite_CastByTraits(Case<variant> const& cs)
{
    BinaryWriter writer;
    writer.write(SchemaTraits<T>::TeslaType(), NULL, boost::get<T>(cs.value)); 
    AssertEquals(cs.binary, writer.buffer());
}

template<typename T, typename Container>
void testWrite_Container(Case<Container> const& cs)
{
    testWrite_Container<T, Container>(cs.binary, cs.value);
}

//template<typename T, typename Container>
//void testWrite_NullAbleContainer(Case<Container> const& cs)
//{
//    testWrite_NullAbleContainer<T, Container>(cs.binary, cs.value);
//}

template<typename T, typename Container>
void testWrite_Container_Cast(Case<Container> const& cs)
{
    testWrite_Container<T, Container>(cs.binary, boost::get<T>(cs.value));
}

template<typename T, typename U>
void testWrite_Array2D(Case<U> const& cs)
{
    testWrite_Array2D<T, U>(cs.binary, cs.value);
}

template<typename T>
class WriterTest: public CppUnit::TestFixture
{
    CPPUNIT_TEST_SUITE(WriterTest);
        CPPUNIT_TEST(testWrite_Min_ByValue);
        CPPUNIT_TEST(testWrite_Max_ByValue);
        CPPUNIT_TEST(testWrite_Rand_ByValue);
        CPPUNIT_TEST(testWrite_Min_ByTraits);
        CPPUNIT_TEST(testWrite_Max_ByTraits);
        CPPUNIT_TEST(testWrite_Rand_ByTraits);
        CPPUNIT_TEST(testWrite_Min_Cast_ByTraits);
        CPPUNIT_TEST(testWrite_Max_Cast_ByTraits);
        CPPUNIT_TEST(testWrite_Rand_Cast_ByTraits);
        CPPUNIT_TEST(testWrite_Array_Vector);
        CPPUNIT_TEST(testWrite_Array_Set);
        CPPUNIT_TEST(testWrite_Array_List);
        CPPUNIT_TEST(testWrite_Array_CArray);
        CPPUNIT_TEST(testWrite_Array_Cast_Vector);
        CPPUNIT_TEST(testWrite_Array_Cast_Set);
        CPPUNIT_TEST(testWrite_Array_Cast_List);
        CPPUNIT_TEST(testWrite_Array_Cast_CArray);
        CPPUNIT_TEST(testWrite_Array2D_Vector);
        CPPUNIT_TEST(testWrite_Array2D_Set);
        CPPUNIT_TEST(testWrite_Array2D_List);
        CPPUNIT_TEST(testWrite_Array2D_Cast_Vector);
        CPPUNIT_TEST(testWrite_Array2D_Cast_Set);
        CPPUNIT_TEST(testWrite_Array2D_Cast_List);
        CPPUNIT_TEST(testWrite_ArrayNullable_AutoPtr_Null);
        CPPUNIT_TEST(testWrite_ArrayNullable_AutoPtr_NotNull);
    CPPUNIT_TEST_SUITE_END();

    void testWrite_Min_ByValue()
    {
        testWrite_ByValue(CaseGenerator<T>().getMin());
    }

    void testWrite_Max_ByValue()
    {
        testWrite_ByValue(CaseGenerator<T>().getMax());
    }

    void testWrite_Rand_ByValue()
    {
        testWrite_ByValue(CaseGenerator<T>().getRand());
    }

    void testWrite_Min_ByTraits()
    {
        testWrite_ByTraits<T, T>(CaseGenerator<T>().getMin());
    }

    void testWrite_Max_ByTraits()
    {
        testWrite_ByTraits<T, T>(CaseGenerator<T>().getMax());
    }

    void testWrite_Rand_ByTraits()
    {
        testWrite_ByTraits<T, T>(CaseGenerator<T>().getRand());
    }

    void testWrite_Min_Cast_ByTraits()
    {
        testWrite_CastByTraits<T>(CaseGenerator<T, variant>().getMin());
    }

    void testWrite_Max_Cast_ByTraits()
    {
        testWrite_CastByTraits<T>(CaseGenerator<T, variant>().getMax());
    }

    void testWrite_Rand_Cast_ByTraits()
    {
        testWrite_CastByTraits<T>(CaseGenerator<T, variant>().getRand());
    }

    void testWrite_Array_Vector()
    {
        typedef typename CaseGenerator<T>::Vector Container;
        testWrite_Container<T, Container>(CaseGenerator<T>().getArray<Container>());
    }

    void testWrite_Array_Set()
    {
        typedef typename CaseGenerator<T>::Set Container;
        testWrite_Container<T, Container>(CaseGenerator<T>().getArray<Container>());
    }

    void testWrite_Array_List()
    {
        typedef typename CaseGenerator<T>::List Container;
        testWrite_Container<T, Container>(CaseGenerator<T>().getArray<Container>());
    }

    void testWrite_Array_CArray()
    {
        typedef typename CaseGenerator<T>::Vector Container;
        const size_t SIZE = 7;
        Case<Container> cs = CaseGenerator<T>().getArray<Container>(SIZE);
        T values[SIZE];
        for (int i = 0; i < cs.value.size(); i++)
            values[i] = cs.value[i];
        BinaryWriter writer;
        writer.write(typename SchemaTraits<T>::TeslaType::Array(), NULL, values);
        AssertEquals(cs.binary, writer.buffer());
    }

    void testWrite_Array_Cast_Vector()
    {
        typedef typename CaseGenerator<T, variant>::Vector Container;
        testWrite_Container<T, Container>(CaseGenerator<T, variant>().getArray<Container>());
    }

    void testWrite_Array_Cast_Set()
    {
        typedef typename CaseGenerator<T, variant>::Set Container;
        testWrite_Container<T>(CaseGenerator<T, variant>().getArray<Container>());
    }

    void testWrite_Array_Cast_List()
    {
        typedef typename CaseGenerator<T, variant>::List Container;
        testWrite_Container<T>(CaseGenerator<T, variant>().getArray<Container>());
    }

    void testWrite_Array_Cast_CArray()
    {
        typedef typename CaseGenerator<T, variant>::Vector Container;
        const size_t SIZE = 7;
        Case<Container> cs = CaseGenerator<T, variant>().getArray<Container>(SIZE);
        variant values[SIZE];
        for (int i = 0; i < cs.value.size(); i++)
            values[i] = cs.value[i];
        BinaryWriter writer;
        writer.write(typename SchemaTraits<T>::TeslaType::Array(), NULL, values);
        AssertEquals(cs.binary, writer.buffer());
    }

    void testWrite_Array2D_Vector()
    {
        typedef typename vector<vector<T> > Container;
        testWrite_Array2D<T, Container>(CaseGenerator<T>().getArray2D<Container>());
    }

    void testWrite_Array2D_Set()
    {
        typedef typename set<set<T> > Container;
        testWrite_Array2D<T, Container>(CaseGenerator<T>().getArray2D<Container>());
    }

    void testWrite_Array2D_List()
    {
        typedef typename list<list<T> > Container;
        testWrite_Array2D<T, Container>(CaseGenerator<T>().getArray2D<Container>());
    }

    void testWrite_Array2D_Cast_Vector()
    {
        typedef typename vector<vector<variant> > Container;
        testWrite_Array2D<T, Container>(CaseGenerator<T>().getArray2D<Container>());
    }

    void testWrite_Array2D_Cast_Set()
    {
        typedef typename set<set<variant> > Container;
        testWrite_Array2D<T, Container>(CaseGenerator<T>().getArray2D<Container>());
    }

    void testWrite_Array2D_Cast_List()
    {
        typedef typename list<list<variant> > Container;
        testWrite_Array2D<T, Container>(CaseGenerator<T>().getArray2D<Container>());
    }

    void testWrite_ArrayNullable_AutoPtr_Null()
    {
        typedef typename CaseGenerator<T>::Vector Container;
        auto_ptr<Container> actual;
        BinaryWriter writer;
        writer.write(SchemaTraits<T>::TeslaType::ArrayNullable(),  "null array", actual);
        SerializedBufferBuilder builder;
        AssertEquals(builder.Boolean(true).Build(), writer.buffer());
    }

    void testWrite_ArrayNullable_AutoPtr_NotNull()
    {
        typedef typename CaseGenerator<T>::Vector Container;
        Case<Container> cs = CaseGenerator<T>().getArray<Container>();
        auto_ptr<Container> aArray(new Container(cs.value));
        BinaryWriter writer;
        writer.write(SchemaTraits<T>::TeslaType::ArrayNullable(), "array", aArray);
        SerializedBufferBuilder builder;
        Buffer buffer = builder.Boolean(false).Build();
        buffer.insert(buffer.end(), cs.binary.begin(), cs.binary.end());
        AssertEquals(buffer, writer.buffer());
    }
}; // class WriterTest

// These operators allow for serialization of data for BinaryWriter tests.
template<class T>
void Serialize(BinaryWriter& writer, T value)
{
    writer.write("name", value);
}

template<class T>
void Serialize(BinaryWriter& writer, T* values, size_t size)
{
    for (size_t i = 0; i < size; i++)
    {
        writer.write("name", values[i]);
    }
}

template<>
void Serialize(BinaryWriter& writer, const std::string* values, size_t size)
{
    for (size_t i = 0; i < size; i++) {
        writer.write("name", values[i]);
    }
}

template<>
void Serialize(BinaryWriter& writer, const char* values, size_t size)
{
    writer.write("name", values);
}

template<>
void Serialize(BinaryWriter& writer, void* values, size_t size)
{
    writer.write("name", values, size);
}

template<class T>
void CheckSerialization(T* values, size_t size)
{
    BinaryWriter writer;
    Serialize(writer, values, size);
    SerializedBufferBuilder builder;
    SetupMock(builder, values, size);
    Buffer expected = builder.Build();
    AssertEquals(expected, writer.buffer());
}

void CheckSerialization(Buffer value)
{
    BinaryWriter writer;
    Serialize(writer, value);
    SerializedBufferBuilder builder;
    SetupMock(builder, value);
    Buffer expected = builder.Build();
    AssertEquals(expected, writer.buffer());
}

class BinaryWriterTest: public CppUnit::TestFixture
{
    CPPUNIT_TEST_SUITE(BinaryWriterTest);
        // Tesla v1
        CPPUNIT_TEST(Write_SerializeSingleByte_Success);
        CPPUNIT_TEST(Write_SerializeSingleUInt16_Success);
        CPPUNIT_TEST(Write_SerializeSingleUInt32_Success);
        CPPUNIT_TEST(Write_SerializeSingleUInt64_Success);
        CPPUNIT_TEST(Write_SerializeSingleInt16_Success);
        CPPUNIT_TEST(Write_SerializeSingleInt32_Success);
        CPPUNIT_TEST(Write_SerializeSingleInt64_Success);
        CPPUNIT_TEST(Write_SerializeSingleBool_Success);
        CPPUNIT_TEST(Write_SerializeSingleFloat_Success);
        CPPUNIT_TEST(Write_SerializeSingleDouble_Success);
        CPPUNIT_TEST(Write_SerializeSingleStdString_Success);
        CPPUNIT_TEST(Write_SerializeSingleString_Success);
        CPPUNIT_TEST(Write_SerializeBinary_Success);
        CPPUNIT_TEST(Write_SerializeBinaryBuffer_Success);

        // Tesla v2 Object
        CPPUNIT_TEST(WriteObject_Fields_Success);
        CPPUNIT_TEST(WriteObject_Success);
        CPPUNIT_TEST(WriteObjectNullable_AutoPtr_Null_Success);
        CPPUNIT_TEST(WriteObjectNullable_Pointer_Null_Success);
        CPPUNIT_TEST(WriteObjectNullable_AutoPtr_NotNull_Success);
        CPPUNIT_TEST(WriteObjectNullable_Pointer_NotNull_Success);
        CPPUNIT_TEST(WriteObjectArray_elements_Success);
        CPPUNIT_TEST(WriteObjectArray_carray_Success);
        CPPUNIT_TEST(WriteObjectArray_vector_Success);
        CPPUNIT_TEST(WriteObjectArray_list_Success);
        CPPUNIT_TEST(WriteObjectArray_set_Success);
        CPPUNIT_TEST(WriteObjectArrayNullable_AutoPtr_Null_Success);
        CPPUNIT_TEST(WriteObjectArrayNullable_Pointer_Null_Success);
        CPPUNIT_TEST(WriteObjectArrayNullable_AutoPtr_NotNull_Success);
        CPPUNIT_TEST(WriteObjectArrayNullable_Pointer_NotNull_Success);

        // Tesla v2 String
        CPPUNIT_TEST(WriteString_cstring_Success);
        CPPUNIT_TEST(WriteString_stdstring_Success);
        CPPUNIT_TEST(WriteStringNullable_cstring_AutoPtr_Null_Success);
        CPPUNIT_TEST(WriteStringNullable_cstring_Pointer_Null_Success);
        CPPUNIT_TEST(WriteStringNullable_cstring_AutoPtr_NotNull_Success);
        CPPUNIT_TEST(WriteStringNullable_cstring_Pointer_NotNull_Success);
        CPPUNIT_TEST(WriteStringNullable_stdstring_AutoPtr_Null_Success);
        CPPUNIT_TEST(WriteStringNullable_stdstring_Pointer_Null_Success);
        CPPUNIT_TEST(WriteStringNullable_stdstring_AutoPtr_NotNull_Success);
        CPPUNIT_TEST(WriteStringNullable_stdstring_Pointer_NotNull_Success);

        // Tesla v2 Reference
        CPPUNIT_TEST(WriteObjectReference_OneObject_Success);
        CPPUNIT_TEST(WriteObjectReference_OneObject_Twice_Success);
        CPPUNIT_TEST(WriteObjectReference_TwoObjects_Twice_Success);
        CPPUNIT_TEST(WriteObjectReferenceArray_OneArray_Success);
        CPPUNIT_TEST(WriteObjectReferenceArray_TwoArrays_Success);
    CPPUNIT_TEST_SUITE_END();

public:

    // Tesla v1

    void Write_SerializeSingleByte_Success()
    {
        uint8_t expected[] = { 0x1, 0x2, 0x3, std::numeric_limits<uint8_t>::min(), 0x0,
            std::numeric_limits<uint32_t>::max() };
        CheckSerialization(expected, _countof(expected));
    }

    // Test value        Encoded Bytes
    //       130         10000010 00000001
    //      16385        10000001 10000000 00000001
    void Write_SerializeSingleUInt16_Success()
    {
        unsigned char expected[] = { 0x82, 0x01, 0x81, 0x80, 0x01 };
        BinaryWriter writer;
        writer.write("name", static_cast<uint16_t> (130));
        writer.write("name", static_cast<uint16_t> (16385));
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test value        Encoded Bytes
    //       130         10000010 00000001
    //      16385        10000001 10000000 00000001
    void Write_SerializeSingleUInt32_Success()
    {
        unsigned char expected[] = { 0x82, 0x01, 0x81, 0x80, 0x01 };
        BinaryWriter writer;
        writer.write("name", static_cast<uint32_t> (130));
        writer.write("name", static_cast<uint32_t> (16385));
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test value        Encoded Bytes
    //       130         10000010 00000001
    //      16385        10000001 10000000 00000001
    void Write_SerializeSingleUInt64_Success()
    {
        unsigned char expected[] = { 0x82, 0x01, 0x81, 0x80, 0x01 };
        BinaryWriter writer;
        writer.write("name", static_cast<uint64_t> (130));
        writer.write("name", static_cast<uint64_t> (16385));
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test value   Encoded As     Encoded Bytes
    //        1         2          00000010
    //       -2         3          00000011
    void Write_SerializeSingleInt16_Success()
    {
        unsigned char expected[] = { 0x02, 0x03 };
        BinaryWriter writer;
        writer.write("name", static_cast<int16_t> (1));
        writer.write("name", static_cast<int16_t> (-2));
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test value   Encoded As     Encoded Bytes
    //       -2         3          00000011
    // 2147483647   4294967294     11111110 11111111 11111111 11111111 00001111
    //-2147483648   4294967295     11111111 11111111 11111111 11111111 00001111
    void Write_SerializeSingleInt32_Success()
    {
        unsigned char expected[] = { 0x03, 0xFE, 0xFF, 0xFF, 0xFF, 0x0F, 0xFF,
                0xFF, 0xFF, 0xFF, 0x0F };
        BinaryWriter writer;
        writer.write("name", static_cast<int32_t> (-2));
        writer.write("name", static_cast<int32_t> (2147483647));
        writer.write("name", static_cast<int32_t> (INT_MIN));
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test value   Encoded As     Encoded Bytes
    //       -2         3          00000011
    // 2147483647   4294967294     11111110 11111111 11111111 11111111 00001111
    //-2147483648   4294967295     11111111 11111111 11111111 11111111 00001111
    // INT64_MAX    0xFFFFFFFE     11111110 11111111 11111111 11111111 11111111 11111111 11111111 11111111 11111111 00000001
    // INT64_MIN    0xFFFFFFFF     11111111 11111111 11111111 11111111 11111111 11111111 11111111 11111111 11111111 00000001
    void Write_SerializeSingleInt64_Success()
    {
        unsigned char expected[] = { 0x03, 0xFE, 0xFF, 0xFF, 0xFF, 0x0F, 0xFF,
                0xFF, 0xFF, 0xFF, 0x0F, 0xFE, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF,
                0xFF, 0xFF, 0xFF, 0x01, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF,
                0xFF, 0xFF, 0xFF, 0x01 };
        BinaryWriter writer;
        writer.write("name", static_cast<int64_t> (-2));
        writer.write("name", static_cast<int64_t> (2147483647));
        writer.write("name", static_cast<int64_t> (INT_MIN));
        writer.write("name", static_cast<int64_t> (+9223372036854775807LL));
        writer.write("name", static_cast<int64_t> (-9223372036854775807LL - 1LL));
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test value   Encoded As     Encoded Bytes
    //   true          0x0D         00001101
    //  false          0x05         00000101
    void Write_SerializeSingleBool_Success()
    {
        unsigned char expected[] = { 0x0D, 0x05 };
        BinaryWriter writer;
        writer.write("name", true);
        writer.write("name", false);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    void Write_SerializeSingleFloat_Success()
    {
        float expected[] = { -89171.12f, 1.783421e31f };
        CheckSerialization(expected, _countof(expected));
    }

    void Write_SerializeSingleDouble_Success()
    {
        double expected[] = { 103801738.120123, -0.0000212384134 };
        CheckSerialization(expected, _countof(expected));
    }

    void Write_SerializeSingleStdString_Success()
    {
        std::string expected[] = {
            "9*!)!)^&*AD*ADAS0898`3101`;'saf213\t\\}{]qwrw",
            "098hr c012842\r\n\\@*)", "", "Large string." };
        expected[3].resize(100000, 'x'); // A large string.
        CheckSerialization(expected, _countof(expected));
    }

    void Write_SerializeSingleString_Success()
    {
        const char* values[] = { "9*!)!)^&*AD*ADAS0898`3101`;'saf213\t\\}{]qwrw",
            "098hr c012842\r\n\\@*)", "", "Large string." };
        SerializedBufferBuilder builder;
        Buffer
            expected =
                builder .String(values[0], strlen(values[0])) .String(
                    values[1], strlen(values[1])) .String(
                    values[2], strlen(values[2])) .String(
                    values[3], strlen(values[3])) .Build();
        BinaryWriter writer;
        writer.write("name", values[0]);
        writer.write("name", values[1]);
        writer.write("name", values[2]);
        writer.write("name", values[3]);
        AssertEquals(expected, writer.buffer());
    }

    void Write_SerializeBinary_Success()
    {
        uint8_t values[] = { 0x1, 0x2, 0x3, std::numeric_limits<uint8_t>::min(), 0x0,
            std::numeric_limits<uint32_t>::max() };
        CheckSerialization(static_cast<void*>(values), _countof(values));
    }

    void Write_SerializeBinaryBuffer_Success()
    {
        uint8_t values[] = { 0x1, 0x2, 0x3, std::numeric_limits<uint8_t>::min(), 0x0,
            std::numeric_limits<uint32_t>::max() };
        Buffer expected(values, values + _countof(values));
        CheckSerialization(expected);
    }

    // Tesla v2 - Unit Tests for TeslaType_Object*
    // i.e. Object, ObjectNullable, ObjectArray, ObjectArrayNullable

    // Test value   Encoded As     Encoded Bytes
    //        7         14          00001110
    void WriteObject_Fields_Success()
    {
        unsigned char expected[] = { 0x0e };
        TestObject to(7);
        BinaryWriter writer;
        to.serialize(writer); // call serialize() directly 
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test value   Encoded As     Encoded Bytes
    //       36         72          01001000
    void WriteObject_Success()
    {
        unsigned char expected[] = { 0x48 };
        TestObject to(36);
        BinaryWriter writer;
        writer.write(TeslaType_Object(), "to", to);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test value   Encoded As     Encoded Bytes
    //    false         13          00001101
    void WriteObjectNullable_AutoPtr_Null_Success()
    {
        unsigned char expected[] = { 0x0D };
        auto_ptr<TestObject> to;
        BinaryWriter writer;
        writer.write(TeslaType_ObjectNullable(), "nullable-to", to);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test value   Encoded As     Encoded Bytes
    //    false         13          00001101
    void WriteObjectNullable_Pointer_Null_Success()
    {
        unsigned char expected[] = { 0x0D };
        TestObject *to = NULL;
        BinaryWriter writer;
        writer.write(TeslaType_ObjectNullable(), "nullable-to", to);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test value   Encoded As     Encoded Bytes
    //     true          5          00000101
    //       42         84          01010100
    void WriteObjectNullable_AutoPtr_NotNull_Success()
    {
        unsigned char expected[] = { 0x05, 0x54 };
        auto_ptr<TestObject> to(new TestObject(42));
        BinaryWriter writer;
        writer.write(TeslaType_ObjectNullable(), "nullable-to", to);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test value   Encoded As     Encoded Bytes
    //     true          5          00000101
    //       23         46          00101110
    void WriteObjectNullable_Pointer_NotNull_Success()
    {
        unsigned char expected[] = { 0x05, 0x2e };
        TestObject *to = new TestObject(23);
        BinaryWriter writer;
        writer.write(TeslaType_ObjectNullable(), "nullable-to", to);
        AssertEquals(expected, sizeof(expected), writer.buffer());
        delete to;
    }

    // Unsigned int used by object array tests is encoded using
    // zig-zag encoding i.e. z(n) = 2n-1, n is odd
    //                            = 2n, n is even

    // Test values   Encoded As
    //   size=4         4
    //   -1|2|-2|1   1|4|3|2
    void WriteObjectArray_elements_Success()
    {
        unsigned char expected[] = { 0x4, 0x1, 0x4, 0x3, 0x2 };
        TestObject to[4] = { TestObject(-1), TestObject(2), TestObject(-2), TestObject(1) };
        BinaryWriter writer;
        writer.write("array size", _countof(to));
        for (size_t i = 0; i < 4; i++) to[i].serialize(writer);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test values   Encoded As
    //   size=4         4
    //   -1|1|-2|2   1|2|3|4
    void WriteObjectArray_carray_Success()
    {
        unsigned char expected[] = { 0x4, 0x1, 0x2, 0x3, 0x4 };
        TestObject to[4] = { TestObject(-1), TestObject(1), TestObject(-2), TestObject(2) };
        BinaryWriter writer;
        writer.write(TeslaType_ObjectArray(), "to[]", to);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test values   Encoded As
    //   size=4         4
    //   2|-2|1|-1   4|3|2|1
    void WriteObjectArray_vector_Success()
    {
        unsigned char expected[] = { 0x4, 0x4, 0x3, 0x2, 0x1 };
        TestObject to[4] = { TestObject(2), TestObject(-2), TestObject(1), TestObject(-1) };
        std::vector<TestObject> actual;
        for (size_t i = 0; i < 4; i++) actual.push_back(to[i]);
        BinaryWriter writer;
        writer.write(TeslaType_ObjectArray(), "to[]", actual);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test values   Encoded As
    //   size=4         4
    //   -1|-2|2|1   1|3|4|2
    void WriteObjectArray_list_Success()
    {
        unsigned char expected[] = { 0x4, 0x1, 0x3, 0x4, 0x2 };
        TestObject to[4] = { TestObject(-1), TestObject(-2), TestObject(2), TestObject(1) };
        std::list<TestObject> actual;
        for (size_t i = 0; i < 4; i++) actual.push_back(to[i]);
        BinaryWriter writer;
        writer.write(TeslaType_ObjectArray(), "to[]", actual);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Elements in set are in ascending order
    // Test values   Encoded As
    //   size=4         4
    //   -2|-1|1|2   3|1|2|4     in ascending order
    void WriteObjectArray_set_Success()
    {
        TestObject to[4] = { TestObject(-1), TestObject(1), TestObject(-2), TestObject(2) };
        unsigned char expected[] = { 0x4, 0x3, 0x1, 0x2, 0x4 };
        std::set<TestObject> actual;
        for (size_t i = 0; i < 4; i++) actual.insert(to[i]);
        BinaryWriter writer;
        writer.write(TeslaType_ObjectArray(), "to[]", actual);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test value   Encoded As     Encoded Bytes
    //    false         13          00001101
    void WriteObjectArrayNullable_AutoPtr_Null_Success()
    {
        unsigned char expected[] = { 0x0D };
        auto_ptr<vector<TestObject> > to;
        BinaryWriter writer;
        writer.write(TeslaType_ObjectArrayNullable(), "nullVector", to);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test value   Encoded As     Encoded Bytes
    //    false         13          00001101
    void WriteObjectArrayNullable_Pointer_Null_Success()
    {
        unsigned char expected[] = { 0x0D };
        set<TestObject>* to = NULL;
        BinaryWriter writer;
        writer.write(TeslaType_ObjectArrayNullable(), "nullSet", to);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test value   Encoded As
    //     true          5
    //     size=3        3
    //   5|1|-5       10|2|9
    void WriteObjectArrayNullable_AutoPtr_NotNull_Success()
    {
        unsigned char expected[] = { 0x05, 0x3, 0xa, 0x2, 0x9 };
        TestObject to[3] = { TestObject(5), TestObject(1), TestObject(-5) };
        auto_ptr<std::list<TestObject> > aList(new std::list<TestObject>);
        for (size_t i = 0; i < 3; i++) aList->push_back(to[i]);
        BinaryWriter writer;
        writer.write(TeslaType_ObjectArrayNullable(), "nullVector", aList);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test value   Encoded As
    //     true          5
    //     size=3        3
    //   -5|2|3       9|4|6      in ascending order
    void WriteObjectArrayNullable_Pointer_NotNull_Success()
    {
        unsigned char expected[] = { 0x05, 0x3, 0x9, 0x4, 0x6 };
        TestObject to[3] = { TestObject(3), TestObject(2), TestObject(-5) };
        std::set<TestObject>* aSet = new std::set<TestObject>();
        for (size_t i = 0; i < 3; i++) aSet->insert(to[i]);
        BinaryWriter writer;
        writer.write(TeslaType_ObjectArrayNullable(), "nullSet", aSet);
        AssertEquals(expected, sizeof(expected), writer.buffer());
        delete aSet;
    }
//TODO: nullable {String, Binary, Array} types

    // Tesla v2 - Unit Tests for TeslaType_String*
    // i.e. String, StringNullable, StringArray, StringArrayNullable

    void WriteString_cstring_Success()
    {
        const char* actual = "Hello, World\n";
        SerializedBufferBuilder builder;
        Buffer expected = builder.String(actual).Build();
        BinaryWriter writer;
        writer.write(TeslaType_String(), "string", actual);
        AssertEquals(expected, writer.buffer());
    }

    void WriteString_stdstring_Success()
    {
        std::string actual = "Hello, World\n";
        SerializedBufferBuilder builder;
        Buffer expected = builder.String(actual).Build();
        BinaryWriter writer;
        writer.write(TeslaType_String(), "string", actual);
        AssertEquals(expected, writer.buffer());
    }

    // Test value   Encoded As     Encoded Bytes
    //    false         13          00001101
    void WriteStringNullable_cstring_AutoPtr_Null_Success()
    {
        unsigned char expected[] = { 0x0D };
        auto_ptr<const char *> aString;
        BinaryWriter writer;
        writer.write(TeslaType_StringNullable(), "string", aString);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test value   Encoded As     Encoded Bytes
    //    false         13          00001101
    void WriteStringNullable_cstring_Pointer_Null_Success()
    {
        unsigned char expected[] = { 0x0D };
        const char** aString = NULL;
        BinaryWriter writer;
        writer.write(TeslaType_StringNullable(), "string", aString);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test value   Encoded As     Encoded Bytes
    //    false         13          00001101
    void WriteStringNullable_stdstring_AutoPtr_Null_Success()
    {
        unsigned char expected[] = { 0x0D };
        auto_ptr<std::string> aString;
        BinaryWriter writer;
        writer.write(TeslaType_StringNullable(), "string", aString);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Test value   Encoded As     Encoded Bytes
    //    false         13          00001101
    void WriteStringNullable_stdstring_Pointer_Null_Success()
    {
        unsigned char expected[] = { 0x0D };
        std::string* aString = NULL;
        BinaryWriter writer;
        writer.write(TeslaType_StringNullable(), "string", aString);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // auto_ptr to a cstring is a bad idea - use std::string.
    // ... because ~auto_ptr calls delete instead of delete[]
    // ... However, tesla write handles it as proved by this test
    void WriteStringNullable_cstring_AutoPtr_NotNull_Success()
    {
        const char* actual = "Hello, World\n";
        auto_ptr<const char*> aString(&actual);
        SerializedBufferBuilder builder;
        Buffer expected = builder.Boolean(false).String(actual).Build();
        BinaryWriter writer;
        writer.write(TeslaType_StringNullable(), "string", aString);
        AssertEquals(expected, writer.buffer());
        aString.release();  // dirty, but works for unit test!
    }

    void WriteStringNullable_cstring_Pointer_NotNull_Success()
    {
        const char* actual = "Hello, World\n";
        SerializedBufferBuilder builder;
        Buffer expected = builder.Boolean(false).String(actual).Build();
        BinaryWriter writer;
        writer.write(TeslaType_StringNullable(), "string", &actual);
        AssertEquals(expected, writer.buffer());
    }

    void WriteStringNullable_stdstring_AutoPtr_NotNull_Success()
    {
        const char* actual = "Hello, World\n";
        auto_ptr<std::string> aString(new std::string(actual));
        SerializedBufferBuilder builder;
        Buffer expected = builder.Boolean(false).String(actual).Build();
        BinaryWriter writer;
        writer.write(TeslaType_StringNullable(), "string", aString);
        AssertEquals(expected, writer.buffer());
    }

    void WriteStringNullable_stdstring_Pointer_NotNull_Success()
    {
        const char* actual = "Hello, World\n";
        std::string* aString = new std::string(actual);
        SerializedBufferBuilder builder;
        Buffer expected = builder.Boolean(false).String(actual).Build();
        BinaryWriter writer;
        writer.write(TeslaType_StringNullable(), "string", aString);
        AssertEquals(expected, writer.buffer());
    }

    // Tesla v2 - Unit Tests for TeslaType_ObjectReference*
    // i.e. ObjectReference, ObjectReferenceArray

    // Description  value   Encoded As
    //  id          -1          1
    //  value       -2          3
    void WriteObjectReference_OneObject_Success()
    {
        unsigned char expected[] = { 0x01, 0x03 };
        TestObject to(-2);
        BinaryWriter writer;
        writer.write(TeslaType_ObjectReference(), NULL, to);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Description  value   Encoded As
    //    id        -1          1
    // value        -5          9
    // refid         1          2
    void WriteObjectReference_OneObject_Twice_Success()
    {
        unsigned char expected[] = { 0x01, 0x09, 0x02 };
        TestObject to(-5);
        BinaryWriter writer;
        writer.write(TeslaType_ObjectReference(), NULL, to);
        writer.write(TeslaType_ObjectReference(), NULL, to);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Description  value   Encoded As
    //  id          -1          1
    //  value       -6          0xb
    //  id          -2          3
    //  value       -7          0xd
    //  refid's     2|1         4|2
    void WriteObjectReference_TwoObjects_Twice_Success()
    {
        unsigned char expected[] = { 0x01, 0x0b, 0x03, 0x0d, 0x04, 0x02 };
        TestObject to1(-6);
        TestObject to2(-7);
        BinaryWriter writer;
        writer.write(TeslaType_ObjectReference(), NULL, to1);
        writer.write(TeslaType_ObjectReference(), NULL, to2);
        writer.write(TeslaType_ObjectReference(), NULL, to2);
        writer.write(TeslaType_ObjectReference(), NULL, to1);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Description  value   Encoded As
    //  length       4          4
    //  id          -1          1
    //  value       -4          7
    //  refid's      1|1|1      2|2|2
    void WriteObjectReferenceArray_OneArray_Success()
    {
        unsigned char expected[] = { 0x4, 0x1, 0x7, 0x2, 0x2, 0x2 };
        std::vector<TestObject> to(4, TestObject(-4));
        BinaryWriter writer;
        writer.write(TeslaType_ObjectReferenceArray(), "to[] ref", to);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }

    // Description  value   Encoded As
    //  length       4          4
    //  id          -1          1
    //  value        4          8
    //  id          -2          3
    //  value       -4          7
    //  refid's      2|2        4|4
    //  length       4          4
    //  refid's      2|2|2|2    4|4|4|4
    void WriteObjectReferenceArray_TwoArrays_Success()
    {
        unsigned char expected[] = {
            0x4, 0x1, 0x8, 0x3, 0x7, 0x4, 0x4, 0x4, 0x4, 0x4, 0x4, 0x4
        };
        TestObject to1[4] = { TestObject(4), TestObject(-4), TestObject(-4), TestObject(-4) };
        TestObject to2[4] = { TestObject(-4), TestObject(-4), TestObject(-4), TestObject(-4) };
        BinaryWriter writer;
        writer.write(TeslaType_ObjectReferenceArray(), "to[] ref", to1);
        writer.write(TeslaType_ObjectReferenceArray(), "to[] ref", to2);
        AssertEquals(expected, sizeof(expected), writer.buffer());
    }
}; // class BinaryWriterTest

int __cdecl main()
{
    CppUnit::TextUi::TestRunner runner;

    // unit tests for specific types - non template
    runner.addTest(BinaryWriterTest::suite());

    // Tesla v2 - unit tests template parametrized for each type
    runner.addTest(WriterTest<byte>::suite());
    runner.addTest(WriterTest<sbyte>::suite());
    runner.addTest(WriterTest<int16_t>::suite());
    runner.addTest(WriterTest<int32_t>::suite());
    runner.addTest(WriterTest<int64_t>::suite());
    runner.addTest(WriterTest<uint16_t>::suite());
    runner.addTest(WriterTest<uint32_t>::suite());
    runner.addTest(WriterTest<uint64_t>::suite());
    runner.addTest(WriterTest<float>::suite());
    runner.addTest(WriterTest<double>::suite());
    runner.addTest(WriterTest<bool>::suite());
    runner.addTest(WriterTest<std::string>::suite());
    runner.addTest(WriterTest<Buffer>::suite());
    runner.addTest(WriterTest<Day>::suite());

    // Return error code 1 if the one of tests failed.
    return runner.run() ? 0 : 1;
}
