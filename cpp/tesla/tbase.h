/*
 * tbase.h
 *
 *  Created on: Aug 20, 2013
 *      Author: Yunfei Zuo (yzuo@expedia.com)
 */

#ifndef TBASE_H_
#define TBASE_H_
#pragma once

#include <string>
#include <vector>
#include <memory>
#include <cassert>
#include <stdexcept>

#include <ios>

namespace tesla {

///////////////////////////////////////////////////////////////////////////////
// Basic Types
///////////////////////////////////////////////////////////////////////////////

typedef unsigned char byte;
typedef unsigned char uint8_t;
typedef char sbyte;
typedef char int8_t;
typedef unsigned short uint16_t;
typedef short int16_t;
typedef unsigned int uint32_t;
typedef int int32_t;
typedef long long int64_t;
typedef unsigned long long uint64_t;

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
