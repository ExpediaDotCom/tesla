//==========================================================================
//
// Copyright (C) 2011, Expedia Inc.  All rights reserved.
//
// File:    TestHelpers.h
//
// Desc:    Test Helper functionality.
//
//==========================================================================

#pragma once

#include <cppunit/extensions/HelperMacros.h>

#include <list>
#include <iomanip>
#include <cmath>
#include <tesla/tbase.h>

#include "SerializedBufferBuilder.h"

// Streams buffer in the form: "[01 23 45 AB CD EF]"
std::ostream& operator<<(std::ostream& s, tesla::Buffer const& buffer) {
    // Format stream
    s.setf(std::ios_base::uppercase);
    s.setf(std::ios_base::hex, std::ios_base::basefield);
    s.fill('0');
    s << '[';
    // Handle empty buffer
    if (!buffer.empty()) {
        // Stream buffer head
        s << std::setw(2) << static_cast<short> (buffer.front());
        typedef tesla::Buffer::const_iterator Iterator;
        // Stream buffer tail
        for (Iterator i = buffer.begin() + 1; i != buffer.end(); ++i) {
            s << ' ' << std::setw(2) << static_cast<short> (*i);
        }
    }
    s << ']';
    return s;
}

namespace boost {
std::ostream& operator<<(std::ostream& s, tesla::Buffer const& buffer) {
    return ::operator <<(s, buffer);
}
}

template<typename T>
std::ostream& operator <<(std::ostream& os, std::vector<T> const& v) {
    typedef typename std::vector<T>::const_iterator Iterator;
    os << '[';
    if (!v.empty()) {
        Iterator i = v.begin();
        os << *i++;
        for (; i != v.end(); ++i) {
            os << ',' << *i;
        }
    }
    os << ']';
    return os;
}

template<typename T>
std::ostream& operator <<(std::ostream& os, std::set<T> const& v) {
    typedef typename std::set<T>::const_iterator Iterator;
    os << '[';
    if (!v.empty()) {
        Iterator i = v.begin();
        os << *i++;
        for (; i != v.end(); ++i) {
            os << ',' << *i;
        }
    }
    os << ']';
    return os;
}

template<typename T>
std::ostream& operator <<(std::ostream& os, std::list<T> const& v) {
    typedef typename std::list<T>::const_iterator Iterator;
    os << '[';
    if (!v.empty()) {
        Iterator i = v.begin();
        os << *i++;
        for (; i != v.end(); ++i) {
            os << ',' << *i;
        }
    }
    os << ']';
    return os;
}

void AssertEquals(const tesla::byte* expected, size_t expectedSize,
        const tesla::byte* actual, size_t actualSize) {
    CPPUNIT_ASSERT_EQUAL(expectedSize, actualSize);

    for (size_t i = 0; i < expectedSize; i++) {
        CPPUNIT_ASSERT_EQUAL(expected[i], actual[i]);
    }
}

void AssertEquals(const tesla::sbyte* expected, size_t expectedSize,
        const tesla::sbyte* actual, size_t actualSize) {
    CPPUNIT_ASSERT_EQUAL(expectedSize, actualSize);

    for (size_t i = 0; i < expectedSize; i++) {
        CPPUNIT_ASSERT_EQUAL(expected[i], actual[i]);
    }
}

void AssertNear(double expected, double actual, double absoluteError) {
    const double diff = fabs(expected - actual);
    if (diff > absoluteError) {
        std::ostringstream errorMessageStream;

        errorMessageStream << "Expected value '" << expected
                << "' does not match actual value '" << actual
                << "' within the error margin '" << absoluteError << "'.";

        CPPUNIT_FAIL(errorMessageStream.str().c_str());
    }
}

void AssertEquals(const tesla::Buffer& expected, const tesla::Buffer& actual) {
    AssertEquals(&expected.front(), expected.size(), &actual.front(),
            actual.size());
}

void AssertEquals(const tesla::byte* expected, size_t expectedSize,
        const tesla::Buffer& actual) {
    AssertEquals(expected, expectedSize, &actual.front(), actual.size());
}

void AssertEquals(const tesla::Buffer& expected, const tesla::byte* actual, size_t actualSize) {
    AssertEquals(&expected.front(), expected.size(), actual, actualSize);
}

// These operators (SetupMockOperators) allow for specializing cases where we want
// to setup a mock buffer (e.g.: single item vs. multiple items, handle Buffer
// in a special way).
template<class T>
void SetupMock(SerializedBufferBuilder& builder, T value) {
    builder.Write(value);
}

template<class T>
void SetupMock(SerializedBufferBuilder& builder, T* values, size_t size) {
    for (size_t i = 0; i < size; i++) {
        builder.Write(values[i]);
    }
}

template<>
void SetupMock(SerializedBufferBuilder& builder, void* values,
        size_t size) {
    builder.Binary(static_cast<tesla::byte*> (values), size);
}
