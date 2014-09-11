//==========================================================================
// Copyright (C) 2014, Expedia Inc.  All rights reserved.
//
// File:    GenericArrayTest.cpp
//
// Created on: Jan 15, 2014
// Author: Sundeep Bhatia (subhatia@expedia.com)
//
//==========================================================================
#pragma warning(disable: 4305 4800 4503)
// KernelEx
#define NOMINMAX
#define KERNEL_EX_CONSUMER_MAIN_MODULE
#include "KernelExMain.h"
// expedia
#include "servprov.h"
#include "spconfig.h"
#include "GenArray.h"
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
    Object() : val(0) {}
    Object(int v) : val(v) {}
    template<typename ReaderType>
    void deserialize(ReaderType& reader)
    {
        reader.read(tesla::TeslaType_Int32(), "val", val);
    }
    template<typename WriterType>
    void serialize(WriterType& writer) const
    {
        writer.write(tesla::TeslaType_Int32(), "val", val);
    }
    int val;
};

// GenericArray
DeclareGenericArrayBegin(RgArray, Object, 3);
    DeclareGenericArrayAccessors(RgArray, Object);
DeclareGenericArrayEnd;

// ArrayTraits specialized
template<>
struct tesla::ArrayTraits<RgArray>
{
    typedef ArrayCategory_UserDefinedArray Category;
    typedef RgArray Container;
    typedef Object ElementType;
    typedef Object& ElementReference;
    struct Adapter
    {
        typedef long IndexType;
        static long size(const Container& container)
        {
            return container.GetSize();
        }
        static void resize(Container& container, size_t size)
        {
            container.SetSize(static_cast<IndexType>(size));
        }
        static ElementReference at(Container& container, size_t index)
        {
            return container.Element(static_cast<IndexType>(index));
        }
        static void clear(Container& container)
        {
            container.RemoveAll();
        }
        static void insert(Container& container, const ElementType& element)
        {
            container.Append(&element);
        }
    };
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

// GenericArray unit test class
class GenericArrayTest: public CppUnit::TestFixture
{
    CPPUNIT_TEST_SUITE(GenericArrayTest);
        CPPUNIT_TEST(ReadWrite_Success);
    CPPUNIT_TEST_SUITE_END();

public:
    void ReadWrite_Success()
    {
        unsigned char expected[] = { 0x01, 0x04 };
        RgArray rArray;
        BinaryReader reader(expected, sizeof(expected));
        reader.read(tesla::TeslaType_ObjectArray(), "RgArray", rArray);
        BinaryWriter writer;
        writer.write(tesla::TeslaType_ObjectArray(), "RgArray", rArray);
        tesla::Buffer actual = writer.buffer();
        AssertEquals(expected, sizeof(expected), &actual.front(), actual.size());
    }
};

// KernelEx Unit Tests need this
int KExMain(int argc, char* argv[])
{
    CppUnit::TextUi::TestRunner runner;
    runner.addTest(GenericArrayTest::suite());
    // Return error code 1 if the one of the tests failed.
    return runner.run() ? 0 : 1;
}
