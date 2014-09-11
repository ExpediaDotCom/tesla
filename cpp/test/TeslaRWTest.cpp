//==========================================================================
// Copyright (C) 2014, Expedia Inc.  All rights reserved.
//
// File:    TeslaRWTest.cpp
//
// Created on: Jan 15, 2014
// Author: Sundeep Bhatia (subhatia@expedia.com)
//
//==========================================================================
// windows
#ifdef _MSC_VER
#pragma warning(disable: 4305 4800 4503)
#endif
#include <windows.h>
// cppunit
#include <cppunit/ui/text/TestRunner.h>
#include <cppunit/extensions/HelperMacros.h>
// tesla
#include <tesla/tbase.h>
#include <tesla/detail/types.h>
#include <tesla/MemoryBinaryReader.h>
#include <tesla/MemoryBinaryWriter.h>

// Note: It may be worthwhile to make this work with other writers and readers
typedef tesla::MemoryBinaryReader BinaryReader;
typedef tesla::MemoryBinaryWriter BinaryWriter;

// Element
struct Object
{
    Object() : ver(0) {}
    template<typename ReaderType>
    void deserialize(ReaderType& reader)
    {
        reader.read(tesla::TeslaType_Int32(), "ver", ver);
        reader.read(tesla::TeslaType_Binary(), "data", data);
    }
    template<typename WriterType>
    void serialize(WriterType& writer) const
    {
        writer.write(tesla::TeslaType_Int32(), "ver", ver);
        writer.write(tesla::TeslaType_Binary(), "data", data);
    }
    DWORD ver;
    BYTE data[8];
};

// helper function
void AssertEquals(const tesla::byte* expected, size_t expectedSize,
        const tesla::byte* actual, size_t actualSize)
{
    CPPUNIT_ASSERT_EQUAL(expectedSize, actualSize);
    for (size_t i = 0; i < expectedSize; i++)
    {
        CPPUNIT_ASSERT_EQUAL(expected[i], actual[i]);
    }
}


// Binary RW unit test class
class BinaryRWTest: public CppUnit::TestFixture
{
    CPPUNIT_TEST_SUITE(BinaryRWTest);
        CPPUNIT_TEST(ReadWrite_Object_Success);
        CPPUNIT_TEST(ReadWrite_Plain_Success);
    CPPUNIT_TEST_SUITE_END();

public:
    void ReadWrite_Object_Success()
    {
        unsigned char expected[] = { 0x01, 0x08, 0x07, 0x05, 0x03, 0x01, 0x02, 0x04, 0x06, 0x08 };
        Object obj;
        BinaryReader reader(expected, sizeof(expected));
        reader.read(tesla::TeslaType_Object(), "object", obj);
        BinaryWriter writer;
        writer.write(tesla::TeslaType_Object(), "object", obj);
        tesla::Buffer actual = writer.buffer();
        AssertEquals(expected, sizeof(expected), &actual.front(), actual.size());
    }
    void ReadWrite_Plain_Success()
    {
        unsigned char expected[] = { 0x08, 0x07, 0x05, 0x03, 0x01, 0x02, 0x04, 0x06, 0x08 };
        BYTE data[8];
        BinaryReader reader(expected, sizeof(expected));
        reader.read(tesla::TeslaType_Binary(), "plain", data);
        BinaryWriter writer;
        writer.write(tesla::TeslaType_Binary(), "plain", data);
        tesla::Buffer actual = writer.buffer();
        AssertEquals(expected, sizeof(expected), &actual.front(), actual.size());
    }
};

#ifdef _MSC_VER
int __cdecl main()
#else
int main()
#endif
{
    CppUnit::TextUi::TestRunner runner;
    runner.addTest(BinaryRWTest::suite());
    // Return error code 1 if the one of the tests failed.
    return runner.run() ? 0 : 1;
}
