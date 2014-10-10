/*
 * tbase.h
 *
 *  Created on: Aug 20, 2013
 *      Author: Yunfei Zuo (yzuo@expedia.com)
 */

#ifndef TBASE_H_
#define TBASE_H_
#pragma once

#ifdef HAVE_CONFIG_H
#include <config.h>
#endif

#include <string>
#include <vector>
#include <memory>
#include <cassert>
#include <stdexcept>

#include <ios>

#ifdef HAVE_STDINT_H
#include <stdint.h>
#endif

namespace tesla {

///////////////////////////////////////////////////////////////////////////////
// Basic Types
///////////////////////////////////////////////////////////////////////////////

typedef unsigned char byte;
typedef signed char sbyte;

#ifdef HAVE_STDINT_H
typedef uint8_t uint8;
typedef int8_t int8;
typedef uint16_t uint16;
typedef int16_t int16;
typedef uint32_t uint32;
typedef int32_t int32;
typedef int64_t int64;
typedef uint64_t uint64;
#else
typedef signed char sbyte;
typedef signed char int8;
typedef unsigned char uint8;
typedef unsigned short uint16;
typedef short int16;
typedef unsigned int uint32;
typedef int int32;
typedef long long int64;
typedef unsigned long long uint64;
#endif

typedef std::vector<byte> Buffer;
typedef std::vector<sbyte> SBuffer;

const byte BOOL_TRUE = 0x0D;
const byte BOOL_FALSE = 0x05;

///////////////////////////////////////////////////////////////////////////////
// Exceptions
///////////////////////////////////////////////////////////////////////////////

class TeslaException: public std::runtime_error {
public:
    TeslaException(const std::string& msg) :
        std::runtime_error(msg) {
    }
};

class SerializationException: public TeslaException {
public:
    SerializationException(const std::string& msg) :
        TeslaException(msg) {
    }
};

class DeserializationException: public TeslaException {
public:
    DeserializationException(const std::string& msg) :
        TeslaException(msg) {
    }
};

class SchemaException: public TeslaException {
public:
    SchemaException(const std::string& msg) :
        TeslaException(msg) {
    }
};

///////////////////////////////////////////////////////////////////////////////
// Helpers
///////////////////////////////////////////////////////////////////////////////

template<typename T, class TeslaReader>
T read(TeslaReader& reader, char const* name) {
    T value;
    reader.read(name, value);
    return value;
}

}

#endif /* TBASE_H_ */
