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


#pragma once

#include <tesla/tbase.h>
#include "TestObject.h"

class SerializedBufferBuilder {
public:

    SerializedBufferBuilder() {
        m_buffer.reserve(64 * 1024 * 1024);
    }

    SerializedBufferBuilder& Size(size_t size) {
        WriteVInt(size);

        return *this;
    }

    SerializedBufferBuilder& UInt8_t(tesla::byte value, size_t count) {
        for (size_t i = 0; i < count; i++) {
            m_buffer.push_back(value);
        }

        return *this;
    }

    SerializedBufferBuilder& UInt8_t(tesla::byte value) {
        return UInt8_t(value, 1);
    }

    SerializedBufferBuilder& UInt16_t(tesla::uint16 value) {
        WriteVInt(value);

        return *this;
    }

    SerializedBufferBuilder& UInt32_t(tesla::uint32 value) {
        WriteVInt(value);

        return *this;
    }

    SerializedBufferBuilder& UInt64_t(tesla::uint64 value) {
        WriteVInt(value);

        return *this;
    }

    SerializedBufferBuilder& Int8_t(tesla::sbyte value, size_t count) {
        return UInt8_t((tesla::byte)value, count);
    }

    SerializedBufferBuilder& Int8_t(tesla::sbyte value) {
        return Int8_t(value, 1);
    }

    SerializedBufferBuilder& Int16_t(tesla::int16 value) {
        WriteVInt(static_cast<tesla::uint16> ((value << 1) ^ (value >> 15)));

        return *this;
    }

    SerializedBufferBuilder& Int32_t(tesla::int32 value) {
        WriteVInt(static_cast<tesla::uint32> ((value << 1) ^ (value >> 31)));

        return *this;
    }

    SerializedBufferBuilder& Int64_t(tesla::int64 value) {
        WriteVInt(static_cast<tesla::uint64> ((value << 1) ^ (value >> 63)));

        return *this;
    }

    SerializedBufferBuilder& Boolean(bool value) {
        m_buffer.push_back(value ? 0x0D : 0x05);

        return *this;
    }

    SerializedBufferBuilder& Float(float value) {
        tesla::byte* data = reinterpret_cast<tesla::byte*> (&value);
        m_buffer.insert(m_buffer.end(), data, data + sizeof(value));

        return *this;
    }

    SerializedBufferBuilder& Double(double value) {
        tesla::byte* data = reinterpret_cast<tesla::byte*> (&value);
        m_buffer.insert(m_buffer.end(), data, data + sizeof(value));

        return *this;
    }

    SerializedBufferBuilder& String(const char* value, size_t size) {
        WriteVInt(size);

        if (size > 0) {
            m_buffer.insert(m_buffer.end(),
                    reinterpret_cast<const tesla::byte*> (value),
                    reinterpret_cast<const tesla::byte*> (value) + size);
        }

        return *this;
    }

    SerializedBufferBuilder& String(const std::string& value) {
        return String(value.c_str(), value.size());
    }

    SerializedBufferBuilder& Binary(const tesla::Buffer& value) {
        return Binary(value.empty() ? NULL
                : reinterpret_cast<const tesla::byte*> (&value.front()), value.size());
    }

    SerializedBufferBuilder& Binary(const tesla::byte * value, size_t size) {
        if (size == 0) {
            WriteVInt(0);

            return *this;
        }

        WriteVInt(size);
        m_buffer.insert(m_buffer.end(), value, value + size);

        return *this;
    }

    SerializedBufferBuilder& Write(tesla::byte value) {
        return UInt8_t(value);
    }

    SerializedBufferBuilder& Write(tesla::sbyte value) {
        return Int8_t(value);
    }

    SerializedBufferBuilder& Write(tesla::int16 value) {
        return Int16_t(value);
    }

    SerializedBufferBuilder& Write(tesla::int32 value) {
        return Int32_t(value);
    }

    SerializedBufferBuilder& Write(tesla::int64 value) {
        return Int64_t(value);
    }

    SerializedBufferBuilder& Write(tesla::uint16 value) {
        return UInt16_t(value);
    }

    SerializedBufferBuilder& Write(tesla::uint32 value) {
        return UInt32_t(value);
    }

    SerializedBufferBuilder& Write(tesla::uint64 value) {
        return UInt64_t(value);
    }

    SerializedBufferBuilder& Write(bool value) {
        return Boolean(value);
    }

    SerializedBufferBuilder& Write(float value) {
        return Float(value);
    }

    SerializedBufferBuilder& Write(double value) {
        return Double(value);
    }

    SerializedBufferBuilder& Write(const std::string& value) {
        return String(value);
    }

    SerializedBufferBuilder& Write(const tesla::Buffer& value) {
        return Binary(value);
    }

    SerializedBufferBuilder& Write(const TestObject& value) {
        return Int32_t(value.m);
    }

    SerializedBufferBuilder& Write(const Day& value) {
        return Int32_t(value);
    }

    const tesla::Buffer& Build() const {
        return m_buffer;
    }

private:
    void WriteVInt(tesla::uint64 value) {
        int count = 0;

        do {
            tesla::byte theByte = (value & 0x7f);
            value >>= 7;
            theByte |= (value == 0 ? 0 : 0x80);

            m_buffer.push_back(theByte);

            count++;
        } while (value != 0);
    }

    tesla::Buffer m_buffer;
};


