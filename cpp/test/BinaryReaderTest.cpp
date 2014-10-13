/*******************************************************************************
 * Copyright (c) 2014 Expedia Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
// windows
#ifdef _MSC_VER
#pragma warning(disable : 4305 4800 4503)
#else
#ifndef _countof
#define _countof(a) (sizeof(a)/sizeof(a[0]))
#endif
#endif // _MSC_VER

// stl
#include <algorithm>
#include <iostream>
#include <limits>
#include <sstream>
#include <fstream>
#include <vector>
#include <set>
#include <list>

#include <cppunit/ui/text/TestRunner.h>
#include <cppunit/extensions/HelperMacros.h>

#include "TestHelpers.h"
#include "cases.h"

using namespace std;
using tesla::DeserializationException;
using tesla::TeslaException;

#ifdef USE_FILE_STREAM

#include <tesla/FileBinaryReader.h>

static const char* FILE_NAME = "test.data.tmp";

using tesla::BasicFileBinaryReader;

class BinaryReader : public BasicFileBinaryReader<fstream>
{
public:

    BinaryReader(const Buffer& buf) : BasicFileBinaryReader<fstream>(FILE_NAME, SchemaVersion(),
            Stream::trunc | Stream::in | Stream::out | Stream::binary)
    {
        setup(&buf[0], buf.size());
    }

    BinaryReader(const void* buf, size_t size) : BasicFileBinaryReader<fstream>(FILE_NAME, SchemaVersion(),
            Stream::trunc | Stream::in | Stream::out | Stream::binary)
    {
        setup(buf, size);
    }

private:
    void setup(const void* buf, size_t size)
    {
        stream_.write(reinterpret_cast<const char*>(buf), size);
        stream_.seekg(0);
    }
};

#elif defined(USE_GZIP_FILE_STREAM)

#include <tesla/GZipFileBinaryReader.h>

static const char* FILE_NAME = "test.data.tmp";

using tesla::GZipFileBinaryReader;

class BinaryReader : public GZipFileBinaryReader
{
public:
    BinaryReader(const Buffer& buf) : GZipFileBinaryReader(
            (setup(&buf[0], buf.size()), FILE_NAME)) {}

    BinaryReader(const void* buf, size_t size) : GZipFileBinaryReader(
            (setup(buf, size), FILE_NAME)) {}

private:
    static void setup(const void* buf, size_t size)
    {
        boost::iostreams::filtering_ostream out;
        out.push(boost::iostreams::gzip_compressor());
        out.push(boost::iostreams::file_sink(FILE_NAME,
                        Stream::trunc | Stream::out | Stream::binary));
        out.write(reinterpret_cast<const char*>(buf), size);
    }
};

#else // USE_MEMORY_STREAM

#include <tesla/MemoryBinaryReader.h>

typedef tesla::MemoryBinaryReader BinaryReader;

#endif // USE_MEMORY_STREAM


template<typename T>
void testRead_ByValue(const T& expected, const void* buf, size_t size) {
    BinaryReader reader(buf, size);
    CPPUNIT_ASSERT_EQUAL(expected, reader.read<T> (NULL));
}

// Enum type use traits version only.
template<>
void testRead_ByValue<Day>(const Day& expected, const void* buf, size_t size) {
}

template<typename T>
void testRead_ByValue(Case<T> const& cs) {
    testRead_ByValue(cs.value, &(cs.binary.front()), cs.binary.size());
}

template<typename T>
void testRead_ByReference(const T& expected, const void* buf, size_t size) {
    BinaryReader reader(buf, size);
    T actual;
    reader.read(NULL, actual);
    CPPUNIT_ASSERT_EQUAL(expected, actual);
}
// Enum type use traits version only.
template<>
void testRead_ByReference<Day>(const Day& expected, const void* buf, size_t size) {
}

template<>
void testRead_ByReference<TestObject> (const TestObject& expected,
        const void* buf, size_t size) {
    BinaryReader reader(buf, size);
    TestObject actual;
    actual.deserialize(reader);
    CPPUNIT_ASSERT_EQUAL(expected, actual);
}

template<typename T>
void testRead_ByReference(Case<T> const& cs) {
    testRead_ByReference(cs.value, &(cs.binary.front()), cs.binary.size());
}

template<typename T, typename U>
void testRead_ByTraits(Case<U> const& cs) {
    BinaryReader reader(&(cs.binary.front()), cs.binary.size());
    U expected = cs.value;
    U actual;
    reader.read(typename SchemaTraits<T>::TeslaType(), NULL, actual);
    CPPUNIT_ASSERT_EQUAL(expected, actual);
}

template<typename T, typename U, size_t N>
void testRead_CArray(U value[N], size_t len, const void* buf, size_t size) {
    BinaryReader reader(buf, size);
    U actual[N];
    reader.read(typename SchemaTraits<T>::TeslaType::Array(), NULL, actual);
    bool eq = std::equal(value, value + len, actual);
    CPPUNIT_ASSERT(eq);
}

template<typename T, typename U>
void testRead_Array(U const& value, const void* buf, size_t size) {
    BinaryReader reader(buf, size);
    U const& expected = value;
    U actual;
    reader.read(typename SchemaTraits<T>::TeslaType::Array(), NULL, actual);
    U const& tmp = actual;
    CPPUNIT_ASSERT_EQUAL(expected, tmp);
}

template<typename T, typename U>
void testRead_Array(Case<U> const& cs) {
    testRead_Array<T, U> (cs.value, &(cs.binary.front()), cs.binary.size());
}

template<typename T, typename U>
void testRead_Array2D(Case<U> const& cs) {
    BinaryReader reader(&(cs.binary.front()), cs.binary.size());
    U expected = cs.value;
    U actual;
    reader.read(typename SchemaTraits<T>::TeslaType::Array2D(), NULL, actual);
    CPPUNIT_ASSERT_EQUAL(expected, actual);
}

template<typename T>
class ReaderTest: public CppUnit::TestFixture {
    CPPUNIT_TEST_SUITE( ReaderTest);
    CPPUNIT_TEST( testRead_Min_ByValue);
    CPPUNIT_TEST( testRead_Max_ByValue);
    CPPUNIT_TEST( testRead_Rand_ByValue);
    CPPUNIT_TEST( testRead_Min_ByReference);
    CPPUNIT_TEST( testRead_Max_ByReference);
    CPPUNIT_TEST( testRead_Rand_ByReference);
    CPPUNIT_TEST( testRead_Min_ByTraits);
    CPPUNIT_TEST( testRead_Max_ByTraits);
    CPPUNIT_TEST( testRead_Rand_ByTraits);
    CPPUNIT_TEST( testRead_Min_Cast_ByTraits);
    CPPUNIT_TEST( testRead_Max_Cast_ByTraits);
    CPPUNIT_TEST( testRead_Rand_Cast_ByTraits);
    CPPUNIT_TEST( testRead_Array_Vector);
    CPPUNIT_TEST( testRead_Array_Set);
    CPPUNIT_TEST( testRead_Array_List);
    CPPUNIT_TEST( testRead_Array_CArray);
    CPPUNIT_TEST( testRead_ArrayNullable_AutoPtrNull_Vector);
    CPPUNIT_TEST( testRead_ArrayNullable_AutoPtrNotNull_Vector);
    CPPUNIT_TEST( testRead_Array_Cast_Vector);
    CPPUNIT_TEST( testRead_Array_Cast_Set);
    CPPUNIT_TEST( testRead_Array_Cast_List);
    CPPUNIT_TEST( testRead_Array_Cast_CArray);
    CPPUNIT_TEST( testRead_Array2D_Vector);
    CPPUNIT_TEST( testRead_Array2D_Set);
    CPPUNIT_TEST( testRead_Array2D_List);
    CPPUNIT_TEST( testRead_Array2D_Cast_Vector);
    CPPUNIT_TEST( testRead_Array2D_Cast_Set);
    CPPUNIT_TEST( testRead_Array2D_Cast_List);CPPUNIT_TEST_SUITE_END();

    void testRead_Min_ByValue() {
        testRead_ByValue(CaseGenerator<T> ().getMin());
    }

    void testRead_Max_ByValue() {
        testRead_ByValue(CaseGenerator<T> ().getMax());
    }

    void testRead_Rand_ByValue() {
        testRead_ByValue(CaseGenerator<T> ().getRand());
    }

    void testRead_Min_ByReference() {
        testRead_ByReference(CaseGenerator<T> ().getMin());
    }

    void testRead_Max_ByReference() {
        testRead_ByReference(CaseGenerator<T> ().getMax());
    }

    void testRead_Rand_ByReference() {
        testRead_ByReference(CaseGenerator<T> ().getRand());
    }

    void testRead_Min_ByTraits() {
        testRead_ByTraits<T, T> (CaseGenerator<T> ().getMin());
    }

    void testRead_Max_ByTraits() {
        testRead_ByTraits<T, T> (CaseGenerator<T> ().getMax());
    }

    void testRead_Rand_ByTraits() {
        testRead_ByTraits<T, T> (CaseGenerator<T> ().getRand());
    }

    void testRead_Min_Cast_ByTraits() {
        testRead_ByTraits<T, variant> (CaseGenerator<T, variant> ().getMin());
    }

    void testRead_Max_Cast_ByTraits() {
        testRead_ByTraits<T, variant> (CaseGenerator<T, variant> ().getMax());
    }

    void testRead_Rand_Cast_ByTraits() {
        testRead_ByTraits<T, variant> (CaseGenerator<T, variant> ().getRand());
    }

    void testRead_Array_Vector() {
        typedef typename CaseGenerator<T>::Vector Container;
        testRead_Array<T, Container> (
                CaseGenerator<T> ().template getArray<Container> ());
    }

    void testRead_ArrayNullable_AutoPtrNull_Vector() {
        typedef typename CaseGenerator<T>::Vector Container;
        typedef auto_ptr<Container> ArrayPtr;
        SerializedBufferBuilder builder;
        builder.Boolean(true);
        Buffer buffer = builder.Build();

        BinaryReader reader(&(buffer.front()), buffer.size());
        ArrayPtr actual(new Container()); // set to some value not null.
        reader.read(typename SchemaTraits<T>::TeslaType::ArrayNullable(), NULL,
                actual);
        CPPUNIT_ASSERT_EQUAL((Container*) NULL, actual.get());
    }

    void testRead_ArrayNullable_AutoPtrNotNull_Vector() {
        typedef typename CaseGenerator<T>::Vector Container;
        typedef auto_ptr<Container> ArrayPtr;
        Case<Container> cs = CaseGenerator<T> ().template getArray<Container> ();
        SerializedBufferBuilder builder;
        builder.Boolean(false);
        Buffer buffer = builder.Build();

        buffer.insert(buffer.end(), cs.binary.begin(), cs.binary.end());

        BinaryReader reader(&(buffer.front()), buffer.size());
        ArrayPtr actual(new Container()); // set to some value not null.
        reader.read(typename SchemaTraits<T>::TeslaType::ArrayNullable(), NULL,
                actual);
        CPPUNIT_ASSERT_EQUAL(cs.value, *actual);
    }

    void testRead_Array_CArray() {
        typedef typename CaseGenerator<T>::Vector Container;
        Case<Container> vv = CaseGenerator<T> ().template getArray<Container> ();
        T values[CaseGenerator<T>::MAX_ARRAY_SIZE];
        for (size_t i = 0; i < vv.value.size(); i++)
            values[i] = vv.value[i];
        testRead_CArray<T, T, CaseGenerator<T>::MAX_ARRAY_SIZE> (values,
                vv.value.size(), &(vv.binary.front()), vv.binary.size());
    }

    void testRead_Array_Set() {
        typedef typename CaseGenerator<T>::Set Container;
        testRead_Array<T, Container> (
                CaseGenerator<T> ().template getArray<Container> ());
    }

    void testRead_Array_List() {
        typedef typename CaseGenerator<T>::List Container;
        testRead_Array<T, Container> (
                CaseGenerator<T> ().template getArray<Container> ());
    }

    void testRead_Array_Cast_Vector() {
        typedef typename CaseGenerator<T, variant>::Vector Container;
        testRead_Array<T, Container> (CaseGenerator<T, variant> ().template getArray<
                Container> ());
    }

    void testRead_Array_Cast_Set() {
        typedef typename CaseGenerator<T, variant>::Set Container;
        testRead_Array<T, Container> (
                CaseGenerator<T>().template getArray<Container> ());
    }

    void testRead_Array_Cast_CArray() {
        typedef typename CaseGenerator<T>::Vector Container;
        Case<Container> vv = CaseGenerator<T> ().template getArray<Container> ();
        variant values[CaseGenerator<T>::MAX_ARRAY_SIZE];
        for (size_t i = 0; i < vv.value.size(); i++)
            values[i] = vv.value[i];
        testRead_CArray<T, variant, CaseGenerator<T>::MAX_ARRAY_SIZE> (values,
                vv.value.size(), &(vv.binary.front()), vv.binary.size());
    }

    void testRead_Array_Cast_List() {
        typedef typename CaseGenerator<T, variant>::List Container;
        testRead_Array<T, Container> (
                CaseGenerator<T> ().template getArray<Container> ());
    }

    void testRead_Array2D_Vector() {
        typedef vector<vector<T> > Container;
        testRead_Array2D<T, Container> (CaseGenerator<T> ().template getArray2D<
                Container> ());
    }

    void testRead_Array2D_Set() {
        typedef set<set<T> > Container;
        testRead_Array2D<T, Container> (CaseGenerator<T> ().template getArray2D<
                Container> ());
    }

    void testRead_Array2D_List() {
        typedef list<list<T> > Container;
        testRead_Array2D<T, Container> (CaseGenerator<T> ().template getArray2D<
                Container> ());
    }

    void testRead_Array2D_Cast_Vector() {
        typedef vector<vector<variant> > Container;
        testRead_Array2D<T, Container> (CaseGenerator<T> ().template getArray2D<
                Container> ());
    }

    void testRead_Array2D_Cast_Set() {
        typedef set<set<variant> > Container;
        testRead_Array2D<T, Container> (CaseGenerator<T> ().template getArray2D<
                Container> ());
    }

    void testRead_Array2D_Cast_List() {
        typedef list<list<variant> > Container;
        testRead_Array2D<T, Container> (CaseGenerator<T> ().template getArray2D<
                Container> ());
    }
};

// These operators allow for deserialization of data for BinaryReader Read_Deserializes.
template<class T>
void Deserialize(Buffer& buffer, T value) {
    BinaryReader reader(buffer);

    T actual;

    reader.read("name", actual);

    CPPUNIT_ASSERT_EQUAL(value, actual);
}

template<class T>
void Deserialize(Buffer& buffer, T* values, size_t size) {
    BinaryReader reader(buffer);

    for (size_t i = 0; i < size; i++) {
        T actual;

        reader.read("name", actual);

        CPPUNIT_ASSERT_EQUAL(values[i], actual);
    }
}

template<class T>
void CheckDeserialization(T* values, size_t size) {
    SerializedBufferBuilder builder;

    SetupMock(builder, values, size);

    Buffer buffer = builder.Build();

    Deserialize(buffer, values, size);
}

void CheckDeserialization(Buffer value) {
    SerializedBufferBuilder builder;

    SetupMock(builder, value);

    Buffer buffer = builder.Build();

    Deserialize<Buffer> (buffer, value);
}

class BinaryReaderTest: public CppUnit::TestFixture {
    CPPUNIT_TEST_SUITE( BinaryReaderTest);
    CPPUNIT_TEST( Read_DeserializeReadByte_Success);
    CPPUNIT_TEST( Read_DeserializeReadUInt16_Success);
    CPPUNIT_TEST( Read_DeserializeTooLargeUInt16_Throw);
    CPPUNIT_TEST( Read_DeserializeReadUInt32_Success);
    CPPUNIT_TEST( Read_DeserializeTooLargeUInt32_Throw);
    CPPUNIT_TEST( Read_DeserializeReadUInt64_Success);
    CPPUNIT_TEST( Read_DeserializeTooLargeUInt64_Throw);
    CPPUNIT_TEST( Read_DeserializeReadInt16_Success);
    CPPUNIT_TEST( Read_DeserializeTooSmallInt16_Throw);
    CPPUNIT_TEST( Read_DeserializeSingleUint16_Success);
    CPPUNIT_TEST( Read_DeserializeReadInt32_Success);
    CPPUNIT_TEST( Read_DeserializeTooSmallInt32_Throw);
    CPPUNIT_TEST( Read_DeserializeTooLargeInt32_Throw);
    CPPUNIT_TEST( Read_DeserializeReadInt64_Success);
    CPPUNIT_TEST( Read_DeserializeTooLargeInt64_Throw);
    CPPUNIT_TEST( Read_DeserializeReadBool_Success);
    CPPUNIT_TEST( Read_DeserializeReadFloat_Success);
    CPPUNIT_TEST( Read_DeserializeTooSmallFloat_NaNValue);
    CPPUNIT_TEST( Read_DeserializeTooLargeFloat_NaNValue);
    CPPUNIT_TEST( Read_DeserializeReadDouble_Success);
    CPPUNIT_TEST( Read_DeserializeReadStdString_Success);
    CPPUNIT_TEST( Read_DeserializeReadString_Success);
    CPPUNIT_TEST( Read_DeserializeTooLargeString_Throw);
    CPPUNIT_TEST( Read_DeserializeInvalidSizedString_Throw);
    CPPUNIT_TEST( Read_DeserializeReadBinaryBuffer_Success);
    CPPUNIT_TEST( Read_DeserializeReadBinary_Success);
    CPPUNIT_TEST( Read_DeserializeTooLargeBinary_Throw);
    CPPUNIT_TEST( Read_DeserializeBadFormat_Throw);
    CPPUNIT_TEST( Read_DeserializeReadTooMuchData_Throw);

    CPPUNIT_TEST( Read_BOOL_Success);
    CPPUNIT_TEST( Read_BoolArray_Success);

    CPPUNIT_TEST( Read_Object_Success);
    CPPUNIT_TEST( Read_ObjectReference_Success);
    CPPUNIT_TEST( Read_ObjectReference_InvalidReferenceId_IdNotFound);
    CPPUNIT_TEST( Read_ObjectReference_InvalidReferenceId_EmptyIdCache);
    CPPUNIT_TEST( Read_NullableObject_Null_Success);
    CPPUNIT_TEST( Read_NullableObject_NotNull_Success);
    CPPUNIT_TEST( Read_NullableObject_InvalidNullFlag);
    CPPUNIT_TEST( Read_ObjectArray_Success);
    CPPUNIT_TEST( Read_ObjectReferenceArray_Success);
    CPPUNIT_TEST( Read_ObjectArray_Overflow);
    CPPUNIT_TEST( Read_NullableObjectArray_NotNull_Success);
    CPPUNIT_TEST( Read_NullableObjectArray_Null_Success);
    CPPUNIT_TEST( Read_NullableObjectArray_InvalidNullFlag_Success);

CPPUNIT_TEST_SUITE_END();

public:

    void Read_DeserializeReadByte_Success() {
        byte expected[128];
        for (size_t i = 0; i < _countof(expected); i++) {
            expected[i] = static_cast<byte> (i);
        }

        CheckDeserialization(expected, _countof(expected));
    }

    void Read_DeserializeReadUInt16_Success() {
        // Read_Deserialize value        Encoded Bytes
        //       130         10000010 00000001
        //      16385        10000001 10000000 00000001
        unsigned char buf[] = { 0x82, 0x01, 0x81, 0x80, 0x01 };
        BinaryReader reader(buf, sizeof(buf));

        uint16_t actual = 0;
        reader.read("name", actual);
        CPPUNIT_ASSERT_EQUAL(static_cast<uint16_t> (130), actual);

        reader.read("aoie", actual);
        CPPUNIT_ASSERT_EQUAL(static_cast<uint16_t> (16385), actual);
    }

    void Read_DeserializeTooLargeUInt16_Throw() {
        SerializedBufferBuilder builder;

        const Buffer buffer = builder .Int64_t(
                std::numeric_limits<int64_t>::max()) .Build();

        BinaryReader reader(&buffer.front(), buffer.size());

        uint16_t value;
        CPPUNIT_ASSERT_THROW(reader.read("foo", value),
                DeserializationException);
    }

    void Read_DeserializeReadUInt32_Success() {
        // Read_Deserialize value        Encoded Bytes
        //       130         10000010 00000001
        //      16385        10000001 10000000 00000001
        unsigned char buf[] = { 0x82, 0x01, 0x81, 0x80, 0x01 };
        BinaryReader reader(buf, sizeof(buf));

        uint32_t actual = 0;
        reader.read("name", actual);
        CPPUNIT_ASSERT_EQUAL(static_cast<uint32_t> (130), actual);

        reader.read("aoie", actual);
        CPPUNIT_ASSERT_EQUAL(static_cast<uint32_t> (16385), actual);
    }

    void Read_DeserializeTooLargeUInt32_Throw() {
        SerializedBufferBuilder builder;

        const Buffer buffer = builder .Int64_t(
                std::numeric_limits<int64_t>::max()) .Build();

        BinaryReader reader(&buffer.front(), buffer.size());

        uint32_t value;
        CPPUNIT_ASSERT_THROW(reader.read("foo", value),
                DeserializationException);
    }

    void Read_DeserializeReadUInt64_Success() {
        // Read_Deserialize value        Encoded Bytes
        //       130         10000010 00000001
        //      16385        10000001 10000000 00000001
        unsigned char buf[] = { 0x82, 0x01, 0x81, 0x80, 0x01 };
        BinaryReader reader(buf, sizeof(buf));

        uint64_t actual = 0;
        reader.read("name", actual);
        CPPUNIT_ASSERT_EQUAL(static_cast<uint64_t> (130), actual);

        reader.read("aoie", actual);
        CPPUNIT_ASSERT_EQUAL(static_cast<uint64_t> (16385), actual);
    }

    void Read_DeserializeTooLargeUInt64_Throw() {
        SerializedBufferBuilder builder;

        const Buffer buffer = builder .UInt8_t(0xFF, 10) .Build();

        BinaryReader reader(&buffer.front(), buffer.size());

        uint64_t value;
        CPPUNIT_ASSERT_THROW(reader.read("foo", value),
                DeserializationException);
    }

    void Read_DeserializeReadInt16_Success() {
        // Read_Deserialize value   Encoded As     Encoded Bytes
        //        1         2          00000010
        //       -2         3          00000011
        unsigned char buf[] = { 0x02, 0x03 };
        BinaryReader reader(buf, sizeof(buf));

        int16_t actual = 0;
        reader.read("", actual);
        CPPUNIT_ASSERT_EQUAL(static_cast<int16_t> (1), actual);

        reader.read("", actual);
        CPPUNIT_ASSERT_EQUAL(static_cast<int16_t> (-2), actual);
    }

    void Read_DeserializeTooSmallInt16_Throw() {
        SerializedBufferBuilder builder;

        const Buffer buffer = builder .Int64_t(
                std::numeric_limits<int64_t>::min()) .Build();

        BinaryReader reader(&buffer.front(), buffer.size());

        int16_t value;
        CPPUNIT_ASSERT_THROW(reader.read("foo", value),
                DeserializationException);
    }

    void Read_DeserializeSingleUint16_Success() {
        SerializedBufferBuilder builder;

        const Buffer buffer = builder .Int64_t(
                std::numeric_limits<int64_t>::max()) .Build();

        BinaryReader reader(&buffer.front(), buffer.size());

        int16_t value;
        CPPUNIT_ASSERT_THROW(reader.read("foo", value),
                DeserializationException);
    }

    void Read_DeserializeReadInt32_Success() {
        // Read_Deserialize value   Encoded As     Encoded Bytes
        //       -2         3          00000011
        // 2147483647   4294967294     11111110 11111111 11111111 11111111 00001111
        //-2147483648   4294967295     11111111 11111111 11111111 11111111 00001111
        unsigned char buf[] = { 0x03, 0xFE, 0xFF, 0xFF, 0xFF, 0x0F, 0xFF, 0xFF,
                0xFF, 0xFF, 0x0F };

        BinaryReader reader(buf, sizeof(buf));
        int32_t actual = 0;
        reader.read("", actual);
        CPPUNIT_ASSERT_EQUAL(-2, actual);

        reader.read("", actual);
        CPPUNIT_ASSERT_EQUAL(2147483647, actual);

        reader.read("", actual);
        CPPUNIT_ASSERT_EQUAL(INT_MIN, actual);
    }

    void Read_DeserializeTooSmallInt32_Throw() {
        SerializedBufferBuilder builder;

        const Buffer buffer = builder .Int64_t(
                std::numeric_limits<int64_t>::min()) .Build();

        BinaryReader reader(&buffer.front(), buffer.size());

        int32_t value;
        CPPUNIT_ASSERT_THROW(reader.read("foo", value),
                DeserializationException);
    }

    void Read_DeserializeTooLargeInt32_Throw() {
        SerializedBufferBuilder builder;

        const Buffer buffer = builder .Int64_t(
                std::numeric_limits<int64_t>::max()) .Build();

        BinaryReader reader(&buffer.front(), buffer.size());

        int32_t value;
        CPPUNIT_ASSERT_THROW(reader.read("foo", value),
                DeserializationException);
    }

    void Read_DeserializeReadInt64_Success() {
        // Read_Deserialize value   Encoded As     Encoded Bytes
        //       -2         3          00000011
        // 2147483647   4294967294     11111110 11111111 11111111 11111111 00001111
        //-2147483648   4294967295     11111111 11111111 11111111 11111111 00001111
        // INT64_MAX    0xFFFFFFFE     11111110 11111111 11111111 11111111 11111111 11111111 11111111 11111111 11111111 00000001
        // INT64_MIN    0xFFFFFFFF     11111111 11111111 11111111 11111111 11111111 11111111 11111111 11111111 11111111 00000001
        unsigned char buf[] = { 0x03, 0xFE, 0xFF, 0xFF, 0xFF, 0x0F, 0xFF, 0xFF,
                0xFF, 0xFF, 0x0F, 0xFE, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF,
                0xFF, 0xFF, 0x01, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF,
                0xFF, 0xFF, 0x01 };

        BinaryReader reader(buf, sizeof(buf));
        int64_t actual = 0;
        reader.read("", actual);
        CPPUNIT_ASSERT_EQUAL((int64_t) -2, actual);

        reader.read("", actual);
        CPPUNIT_ASSERT_EQUAL((int64_t) 2147483647, actual);

        reader.read("", actual);
        CPPUNIT_ASSERT_EQUAL((int64_t) INT_MIN, actual);

        reader.read("", actual);
        CPPUNIT_ASSERT_EQUAL(+9223372036854775807LL, actual);

        reader.read("", actual);
        CPPUNIT_ASSERT_EQUAL((-9223372036854775807LL - 1LL), actual);
    }

    void Read_DeserializeTooLargeInt64_Throw() {
        SerializedBufferBuilder builder;

        const Buffer buffer = builder .UInt8_t(0xFF, 10) .Build();

        BinaryReader reader(&buffer.front(), buffer.size());

        int64_t value;
        CPPUNIT_ASSERT_THROW(reader.read("foo", value),
                DeserializationException);
    }

    void Read_DeserializeReadBool_Success() {
        unsigned char buf[] = { 0x0D, 0x05, 0x01 };
        BinaryReader reader(buf, sizeof(buf));

        bool actual = false;
        reader.read("", actual);
        CPPUNIT_ASSERT_EQUAL(true, actual);

        reader.read("", actual);
        CPPUNIT_ASSERT_EQUAL(false, actual);

        CPPUNIT_ASSERT_THROW(reader.read("", actual), DeserializationException);
    }

    void Read_DeserializeReadFloat_Success() {
        float expected[2] = { -89171.12f, 1.783421e31f };

        CheckDeserialization(expected, _countof(expected));
    }

    void Read_DeserializeTooSmallFloat_NaNValue() {
        SerializedBufferBuilder builder;

        const Buffer buffer = builder .Double(-DBL_MAX) // DBL_MIN is the smallest *absolute* value (1e-999). -DBL_MAX is the smallest negative value.
                .Build();

        BinaryReader reader(&buffer.front(), buffer.size());

        float value;
        reader.read("foo", value);
        CPPUNIT_ASSERT(isnan(value));
    }

    void Read_DeserializeTooLargeFloat_NaNValue() {
        SerializedBufferBuilder builder;
        const Buffer buffer = builder .Double(DBL_MAX) .Build();

        BinaryReader reader(&buffer.front(), buffer.size());

        float value;
        reader.read("foo", value);
        CPPUNIT_ASSERT(isnan(value));
    }

    void Read_DeserializeReadDouble_Success() {
        double expected[] = { 103801738.120123, -0.0000212384134 };

        CheckDeserialization(expected, _countof(expected));
    }

    void Read_DeserializeReadStdString_Success() {
        std::string expected[] = {
                "9*!)!)^&*AD*ADAS0898`3101`;'saf213\t\\}{]qwrw",
                "098hr c012842\r\n\\@*)", "", "Large string." };

        expected[3].resize(100000, 'x'); // A large string.

        CheckDeserialization(expected, _countof(expected));
    }

    void Read_DeserializeReadString_Success() {
        const char * expected[] = { "9*!)!)^&*AD*ADAS0898`3101`;'saf213\t\\}{]qwrw",
                "098hr c012842\r\n\\@*)", "", "Large string." };

        SerializedBufferBuilder builder;

        Buffer buffer =
                builder .String(expected[0], strlen(expected[0])) .String(
                        expected[1], strlen(expected[1])) .String(expected[2],
                        strlen(expected[2])) .String(expected[3], strlen(
                        expected[3])) .Build();

        BinaryReader reader(&buffer.front(), buffer.size());

        for (size_t i = 0; i < _countof(expected); i++) {
            char actual[256];
            size_t size = sizeof(actual);
            reader.read("", actual, size);

            CPPUNIT_ASSERT(0 == strcmp(expected[i], actual));
        }
    }

    void Read_DeserializeTooLargeString_Throw() {
        SerializedBufferBuilder builder;

        Buffer buffer = builder .Size(1024) .Build();

        BinaryReader reader(&buffer.front(), buffer.size());

        char actual[256];
        size_t size = sizeof(actual);

        CPPUNIT_ASSERT_THROW(reader.read("", actual, size),
                DeserializationException);
    }

    void Read_DeserializeInvalidSizedString_Throw() {
        SerializedBufferBuilder builder;

        Buffer buffer = builder .Size(-10) .Build();

        BinaryReader reader(&buffer.front(), buffer.size());

        char actual[256];
        size_t size = sizeof(actual);

        CPPUNIT_ASSERT_THROW(reader.read("", actual, size),
                DeserializationException);
    }

    void Read_DeserializeReadBinaryBuffer_Success() {
        uint8_t values[] = { 0x1, 0x2, 0x3,
                std::numeric_limits<uint8_t>::min(), 0x0, std::numeric_limits<
                        uint32_t>::max() };

        Buffer expected;
        for (size_t i = 0; i < sizeof(values); i++) {
            expected.push_back(values[i]);
        }

        CheckDeserialization(expected);
    }

    void Read_DeserializeTooLargeBinary_Throw() {
        uint8_t values[] = { 0x1, 0x2, 0x3,
                std::numeric_limits<uint8_t>::min(), 0x0, std::numeric_limits<
                        uint32_t>::max() };

        SerializedBufferBuilder builder;

        Buffer expected;
        for (size_t i = 0; i < sizeof(values); i++) {
            expected.push_back(values[i]);
        }

        Buffer buffer = builder .Binary(expected) .Build();

        BinaryReader reader(&buffer.front(), buffer.size());

        uint8_t actual[2];
        size_t size = sizeof(actual);

        CPPUNIT_ASSERT_THROW(reader.read("", actual, size),
                DeserializationException);
    }

    void Read_DeserializeReadTooMuchData_Throw() {
        SerializedBufferBuilder builder;

        Buffer buffer = builder .Size(10) .Build();

        BinaryReader reader(&buffer.front(), buffer.size());

        uint8_t actual[20];
        size_t size = 15;

        CPPUNIT_ASSERT_THROW(reader.read("", actual, size),
                DeserializationException);
    }

    void Read_DeserializeReadBinary_Success() {
        uint8_t values[] = { 0x1, 0x2, 0x3,
                std::numeric_limits<uint8_t>::min(), 0x0, std::numeric_limits<
                        uint32_t>::max() };

        Buffer expected;
        for (size_t i = 0; i < _countof(values); i++) {
            expected.push_back(values[i]);
        }

        SerializedBufferBuilder builder;
        Buffer buffer = builder .Binary(expected) .Build();

        {
            BinaryReader reader(&buffer.front(), buffer.size());
            size_t size = _countof(values);
            uint8_t * actual = new uint8_t[size];
            reader.read("name", static_cast<void *> (actual), size);
            AssertEquals(expected, actual, size);
            delete[] actual;
        }

        {
            BinaryReader reader(&buffer.front(), buffer.size());
            byte actual[_countof(values)];
            reader.read(TeslaType_Binary(), NULL, actual);
            CPPUNIT_ASSERT_EQUAL(expected, Buffer(actual, actual
                    + sizeof(actual)));
        }

        {
            BinaryReader reader(&buffer.front(), buffer.size());
            Buffer actual;
            reader.read(NULL, actual);
            CPPUNIT_ASSERT_EQUAL(expected, actual);
        }

        {
            BinaryReader reader(&buffer.front(), buffer.size());
            Buffer actual;
            reader.read(TeslaType_Binary(), NULL, actual);
            CPPUNIT_ASSERT_EQUAL(expected, actual);
        }
    }

    void Read_DeserializeBadFormat_Throw() {
        {
            unsigned char buf[] = { 0x88, 0x80 };
            BinaryReader reader(buf, sizeof(buf));
            uint64_t actual;
            CPPUNIT_ASSERT_THROW(reader.read("", actual),
                    DeserializationException);
        }

        {
            unsigned char buf[] = { 0x88, 0x80, 0x88, 0x80, 0x88, 0x80, 0x88,
                    0x80, 0x88, 0x80, 0x88, 0x80, 0x88, 0x01 };
            BinaryReader reader(buf, sizeof(buf));
            uint64_t actual;
            CPPUNIT_ASSERT_THROW(reader.read("", actual),
                    DeserializationException);
        }
    }

    void Read_BOOL_Success() {
        typedef int BOOLEAN;
        unsigned char buf[] = { 0x0D, 0x05 };
        BinaryReader reader(buf, sizeof(buf));
        BOOLEAN b = 0x77;
        reader.read(TeslaType_Boolean(), NULL, b);
        CPPUNIT_ASSERT_EQUAL(1, b);
        reader.read(TeslaType_Boolean(), NULL, b);
        CPPUNIT_ASSERT_EQUAL(0, b);
    }

    void Read_BOOL_InvalidBool() {
        typedef int BOOLEAN;
        unsigned char buf[] = { 0x77 };
        BinaryReader reader(buf, sizeof(buf));
        BOOLEAN b;
        CPPUNIT_ASSERT_THROW(reader.read(TeslaType_Boolean(), NULL, b),
                DeserializationException);
    }

    void Read_BoolArray_Success() {
        {
            // vector<bool>
            typedef vector<bool> BoolArray;
            BoolArray expected(2, true);
            unsigned char buf[] = { 0x02, 0x0D, 0x0D };
            BinaryReader reader(buf, sizeof(buf));
            BoolArray actual;
            reader.read(TeslaType_BooleanArray(), NULL, actual);
            CPPUNIT_ASSERT_EQUAL(expected, actual);
        }

        {
            // vector<BOOLEAN>
            typedef int BOOLEAN;
            typedef vector<BOOLEAN> BoolArray;
            BoolArray expected(2, 1);
            unsigned char buf[] = { 0x02, 0x0D, 0x0D };
            BinaryReader reader(buf, sizeof(buf));
            BoolArray actual;
            reader.read(TeslaType_BooleanArray(), NULL, actual);
            CPPUNIT_ASSERT_EQUAL(expected, actual);
        }

        {
            // bool[]
            bool expected[] = { false, true };
            unsigned char buf[] = { 0x02, 0x05, 0x0D };
            BinaryReader reader(buf, sizeof(buf));
            bool actual[2];
            reader.read(TeslaType_BooleanArray(), NULL, actual);
            CPPUNIT_ASSERT_EQUAL(expected[0], actual[0]);
            CPPUNIT_ASSERT_EQUAL(expected[1], actual[1]);
        }

        {
            // BOOLEAN[]
            typedef int BOOLEAN;
            BOOLEAN expected[] = { false, true };
            unsigned char buf[] = { 0x02, 0x05, 0x0D };
            BinaryReader reader(buf, sizeof(buf));
            BOOLEAN actual[2];
            reader.read(TeslaType_BooleanArray(), NULL, actual);
            CPPUNIT_ASSERT_EQUAL(expected[0], actual[0]);
            CPPUNIT_ASSERT_EQUAL(expected[1], actual[1]);
        }

        {
            // list<bool>
            typedef list<bool> BoolArray;
            BoolArray expected(2, true);
            unsigned char buf[] = { 0x02, 0x0D, 0x0D };
            BinaryReader reader(buf, sizeof(buf));
            BoolArray actual;
            reader.read(TeslaType_BooleanArray(), NULL, actual);
            CPPUNIT_ASSERT_EQUAL(expected, actual);
        }

        {
            // list<BOOLEAN>
            typedef int BOOLEAN;
            typedef list<BOOLEAN> BoolArray;
            BoolArray expected(2, 1);
            unsigned char buf[] = { 0x02, 0x0D, 0x0D };
            BinaryReader reader(buf, sizeof(buf));
            BoolArray actual;
            reader.read(TeslaType_BooleanArray(), NULL, actual);
            CPPUNIT_ASSERT_EQUAL(expected, actual);
        }
    }

    void Read_Object_Success() {
        unsigned char buf[] = { 0x03 };

        {
            TestObject to;
            BinaryReader reader(buf, sizeof(buf));
            to.deserialize(reader); // call deserialize() directly
            CPPUNIT_ASSERT_EQUAL(-2, to.m);
        }

        {
            TestObject to;
            BinaryReader reader(buf, sizeof(buf));
            reader.read(TeslaType_Object(), NULL, to); // another syntax
            CPPUNIT_ASSERT_EQUAL(-2, to.m);
        }

        {
            unsigned char buf[] = { 0x03, 0x03 };
            TestObject* to = NULL;
            BinaryReader reader(buf, sizeof(buf));
            reader.read(TeslaType_ObjectReference(), NULL, to); // object pointer
            CPPUNIT_ASSERT_EQUAL(-2, to->m);
            delete to;
        }
    }

    void Read_ObjectReference_Success() {
        unsigned char buf[] = { 0x01, 0x03, 0x02 };

        {
            TestObject to1, to2;
            BinaryReader reader(buf, sizeof(buf));
            reader.read(TeslaType_ObjectReference(), NULL, to1);
            reader.read(TeslaType_ObjectReference(), NULL, to2);
            CPPUNIT_ASSERT_EQUAL(-2, to1.m);
            CPPUNIT_ASSERT_EQUAL(to1, to2); // two identical copies
        }
        {
            TestObject *to1 = NULL, *to2 = NULL;
            BinaryReader reader(buf, sizeof(buf));
            reader.read(TeslaType_ObjectReference(), NULL, to1);
            reader.read(TeslaType_ObjectReference(), NULL, to2);
            CPPUNIT_ASSERT_EQUAL(-2, to1->m);
            CPPUNIT_ASSERT_EQUAL(to1, to2); // point to the same object
            delete to1;
        }
    }

    void Read_ObjectReference_InvalidReferenceId_IdNotFound() {
        unsigned char buf[] = { 0x01, 0x03, 0x04 }; // second reference doesn't equals to 1.
        // -1,       2
        {
            TestObject to1, to2;
            BinaryReader reader(buf, sizeof(buf));
            reader.read(TeslaType_ObjectReference(), NULL, to1);
            CPPUNIT_ASSERT_EQUAL(-2, to1.m);
            CPPUNIT_ASSERT_THROW(reader.read(TeslaType_ObjectReference(), NULL,
                    to2), DeserializationException);
        }

        {
            TestObject *to1 = NULL, *to2 = NULL;
            BinaryReader reader(buf, sizeof(buf));
            reader.read(TeslaType_ObjectReference(), NULL, to1);
            CPPUNIT_ASSERT_EQUAL(-2, to1->m);
            CPPUNIT_ASSERT_THROW(reader.read(TeslaType_ObjectReference(), NULL,
                    to2), DeserializationException);
            delete to1;
        }
    }

    void Read_ObjectReference_InvalidReferenceId_EmptyIdCache() {
        unsigned char buf[] = { 0x02, 0x03 }; // refid = 1

        {
            TestObject to;
            BinaryReader reader(buf, sizeof(buf));
            CPPUNIT_ASSERT_THROW(reader.read(TeslaType_ObjectReference(), NULL,
                    to), DeserializationException);
        }

        {
            TestObject *to = NULL;
            BinaryReader reader(buf, sizeof(buf));
            CPPUNIT_ASSERT_THROW(reader.read(TeslaType_ObjectReference(), NULL,
                    to), DeserializationException);
        }
    }

    void Read_NullableObject_Null_Success() {
        {
            // smart pointer version
            typedef auto_ptr<TestObject> TestObjectPtr;
            TestObjectPtr to;
            unsigned char buf[] = { 0x0D };
            BinaryReader reader(buf, sizeof(buf));
            reader.read(TeslaType_ObjectNullable(), NULL, to);
            CPPUNIT_ASSERT_EQUAL((TestObject*) NULL, to.get());
        }

        {
            // native pointer version
            TestObject* to = NULL;
            unsigned char buf[] = { 0x0D };
            BinaryReader reader(buf, sizeof(buf));
            reader.read(TeslaType_ObjectNullable(), NULL, to);
            CPPUNIT_ASSERT_EQUAL((TestObject*) NULL, to);
            delete to;
        }
    }

    void Read_NullableObject_NotNull_Success() {
        {
            // smart pointer version
            typedef auto_ptr<TestObject> TestObjectPtr;
            TestObjectPtr to;
            unsigned char buf[] = { 0x05, 0x03 };
            BinaryReader reader(buf, sizeof(buf));
            reader.read(TeslaType_ObjectNullable(), NULL, to);
            CPPUNIT_ASSERT_EQUAL(TestObject(-2), *to);
        }

        {
            // native pointer version
            TestObject* to = NULL;
            unsigned char buf[] = { 0x05, 0x03 };
            BinaryReader reader(buf, sizeof(buf));
            reader.read(TeslaType_ObjectNullable(), NULL, to);
            CPPUNIT_ASSERT_EQUAL(TestObject(-2), *to);
            delete to;
        }
    }

    void Read_NullableObject_InvalidNullFlag() {
        typedef auto_ptr<TestObject> TestObjectPtr;
        TestObjectPtr to;
        unsigned char buf[] = { 0x01, 0x03 };
        BinaryReader reader(buf, sizeof(buf));
        CPPUNIT_ASSERT_THROW(reader.read(TeslaType_ObjectNullable(), NULL, to),
                DeserializationException);
    }

    void Read_ObjectArray_Success() {
        {
            // vector<TestObject>
            typedef vector<TestObject> TestObjectArray;
            TestObjectArray expected(2, TestObject(-2));
            unsigned char buf[] = { 0x02, 0x03, 0x03 };
            BinaryReader reader(buf, sizeof(buf));
            TestObjectArray actual;
            reader.read(TeslaType_ObjectArray(), NULL, actual);
            CPPUNIT_ASSERT_EQUAL(expected, actual);
        }

        {
            // TestObject[]
            TestObject expected[] = { TestObject(-2), TestObject(-2) };
            unsigned char buf[] = { 0x02, 0x03, 0x03 };
            BinaryReader reader(buf, sizeof(buf));
            TestObject actual[2];
            reader.read(TeslaType_ObjectArray(), NULL, actual);
            CPPUNIT_ASSERT_EQUAL(expected[0], actual[0]);
            CPPUNIT_ASSERT_EQUAL(expected[1], actual[1]);
        }

        {
            // set<TestObject>
            typedef set<TestObject> TestObjectArray;
            TestObjectArray expected;
            expected.insert(TestObject(-2));
            expected.insert(TestObject(3));
            unsigned char buf[] = { 0x02, 0x03, 0x06 };
            BinaryReader reader(buf, sizeof(buf));
            TestObjectArray actual;
            reader.read(TeslaType_ObjectArray(), NULL, actual);
            CPPUNIT_ASSERT_EQUAL(expected, actual);
        }
    }

    void Read_ObjectReferenceArray_Success() {
        {
            // vector<TestObject>
            typedef vector<TestObject> TestObjectArray;
            TestObjectArray expected(2, TestObject(-2));
            unsigned char buf[] = { 0x02, 0x01, 0x03, 0x02 };
            BinaryReader reader(buf, sizeof(buf));
            TestObjectArray actual;
            reader.read(TeslaType_ObjectReferenceArray(), NULL, actual);
            CPPUNIT_ASSERT_EQUAL(expected, actual);
        }

        {
            // TestObject[]
            TestObject expected[] = { TestObject(-2), TestObject(-2) };
            unsigned char buf[] = { 0x02, 0x01, 0x03, 0x02 };
            BinaryReader reader(buf, sizeof(buf));
            TestObject actual[2];
            reader.read(TeslaType_ObjectReferenceArray(), NULL, actual);
            CPPUNIT_ASSERT_EQUAL(expected[0], actual[0]);
            CPPUNIT_ASSERT_EQUAL(expected[1], actual[1]);
        }

        {
            // set<TestObject>
            typedef set<TestObject> TestObjectArray;
            TestObjectArray expected;
            expected.insert(TestObject(-2));
            expected.insert(TestObject(3));
            unsigned char buf[] = { 0x02, 0x01, 0x03, 0x03, 0x06 };
            BinaryReader reader(buf, sizeof(buf));
            TestObjectArray actual;
            reader.read(TeslaType_ObjectReferenceArray(), NULL, actual);
            CPPUNIT_ASSERT_EQUAL(expected, actual);
        }
    }

    void Read_ObjectArray_Overflow() {
        // TestObject[3] => TestObject[2]
        unsigned char buf[] = { 0x03, 0x03, 0x03, 0x03 };
        BinaryReader reader(buf, sizeof(buf));
        TestObject actual[2];
        CPPUNIT_ASSERT_THROW(
                reader.read(TeslaType_ObjectArray(), NULL, actual),
                TeslaException);
    }

    void Read_NullableObjectArray_NotNull_Success() {
        {
            // vector<TestObject>
            typedef vector<TestObject> TestObjectArray;
            typedef auto_ptr<TestObjectArray> TestObjectArrayPtr;
            TestObjectArray expected(2, TestObject(-2));
            unsigned char buf[] = { 0x05, 0x02, 0x03, 0x03 };
            BinaryReader reader(buf, sizeof(buf));
            TestObjectArrayPtr actual;
            reader.read(TeslaType_ObjectArrayNullable(), NULL, actual);
            CPPUNIT_ASSERT_EQUAL(expected, *actual);
        }

        {
            // set<TestObject>
            typedef set<TestObject> TestObjectArray;
            typedef TestObjectArray* TestObjectArrayPtr;
            TestObjectArray expected;
            expected.insert(TestObject(-2));
            expected.insert(TestObject(3));
            unsigned char buf[] = { 0x05, 0x02, 0x03, 0x06 };
            BinaryReader reader(buf, sizeof(buf));
            TestObjectArrayPtr actual = NULL;
            reader.read(TeslaType_ObjectArrayNullable(), NULL, actual);
            CPPUNIT_ASSERT(&expected != actual);
            CPPUNIT_ASSERT_EQUAL(expected, *actual);
        }
    }

    void Read_NullableObjectArray_Null_Success() {
        {
            // vector<TestObject>
            typedef vector<TestObject> TestObjectArray;
            typedef auto_ptr<TestObjectArray> TestObjectArrayPtr;
            unsigned char buf[] = { 0x0D };
            BinaryReader reader(buf, sizeof(buf));
            TestObjectArrayPtr actual;
            reader.read(TeslaType_ObjectArrayNullable(), NULL, actual);
            CPPUNIT_ASSERT_EQUAL((TestObjectArray*) NULL, actual.get());
        }

        {
            // set<TestObject>
            typedef set<TestObject> TestObjectArray;
            typedef TestObjectArray* TestObjectArrayPtr;
            TestObjectArray expected;
            expected.insert(TestObject(-2));
            expected.insert(TestObject(3));
            unsigned char buf[] = { 0x0D };
            BinaryReader reader(buf, sizeof(buf));
            TestObjectArrayPtr actual = NULL;
            reader.read(TeslaType_ObjectArrayNullable(), NULL, actual);
            CPPUNIT_ASSERT_EQUAL((TestObjectArray*) NULL, actual);
        }
    }

    void Read_NullableObjectArray_InvalidNullFlag_Success() {
        {
            // vector<TestObject>
            typedef vector<TestObject> TestObjectArray;
            typedef auto_ptr<TestObjectArray> TestObjectArrayPtr;
            unsigned char buf[] = { 0x1D, 0x13 };
            BinaryReader reader(buf, sizeof(buf));
            TestObjectArrayPtr actual;
            CPPUNIT_ASSERT_THROW(reader.read(TeslaType_ObjectArrayNullable(),
                    NULL, actual), DeserializationException);
        }

        {
            // set<TestObject>
            typedef set<TestObject> TestObjectArray;
            typedef TestObjectArray* TestObjectArrayPtr;
            unsigned char buf[] = { 0x1D, 0x13 };
            BinaryReader reader(buf, sizeof(buf));
            TestObjectArrayPtr actual = NULL;
            CPPUNIT_ASSERT_THROW(reader.read(TeslaType_ObjectArrayNullable(),
                    NULL, actual), DeserializationException);
        }
    }

};


#ifdef _MSC_VER
int __cdecl main()
#else
int main()
#endif
{
    // Adds the test to the list of test to run
    CppUnit::TextUi::TestRunner runner;
    runner.addTest(BinaryReaderTest::suite());
    runner.addTest(ReaderTest<byte>::suite());
    runner.addTest(ReaderTest<sbyte>::suite());
    runner.addTest(ReaderTest<int16_t>::suite());
    runner.addTest(ReaderTest<int32_t>::suite());
    runner.addTest(ReaderTest<int64_t>::suite());
    runner.addTest(ReaderTest<uint16_t>::suite());
    runner.addTest(ReaderTest<uint32_t>::suite());
    runner.addTest(ReaderTest<uint64_t>::suite());
    runner.addTest(ReaderTest<float>::suite());
    runner.addTest(ReaderTest<double>::suite());
    runner.addTest(ReaderTest<bool>::suite());
    runner.addTest(ReaderTest<std::string>::suite());
    runner.addTest(ReaderTest<Buffer>::suite());
    runner.addTest(ReaderTest<Day>::suite());

    // Return error code 1 if the one of the tests failed.
    return runner.run() ? 0 : 1;
}
