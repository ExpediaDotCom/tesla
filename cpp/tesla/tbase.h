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
