/*
 * BinaryReader.h
 *
 *  Created on: Aug 19, 2013
 *      Author: Yunfei Zuo (yzuo@expedia.com)
 */

#ifndef BINARYREADER_H_
#define BINARYREADER_H_

#pragma once

#include <tesla/tbase.h>
#include <tesla/detail/types.h>
#include <tesla/detail/traits.h>
#include <tesla/detail/Reader.h>

#include <boost/any.hpp>
#include <map>
#include <limits>

namespace tesla {

class ReadReferenceCache;

template<typename Stream, typename RefPolicy = ReadReferenceCache>
class BasicBinaryReader: public Reader<Stream> {
public:
    explicit BasicBinaryReader(Stream* stream, SchemaVersion const& ver =
            SchemaVersion()) :
            Reader<Stream>(stream, ver) {
    }

    template<typename TeslaType, typename T>
    void read(TeslaType, const char* name, T& value) {
        TeslaType::read(*this, name, value);
    }

    void read(TeslaType_Boolean, const char* name, BitReference value) {
        TeslaType_Boolean::read(*this, name, value);
    }

    void read(const char* name, byte& value) {
        value = static_cast<byte>(readByte());
    }

    void read(const char* name, sbyte& value) {
        value = static_cast<sbyte>(readByte());
    }

    void read(const char* name, int16_t& value) {
        value = castValue<int16_t>(readZigZag());
    }

    void read(const char* name, int32_t& value) {
        value = castValue<int32_t>(readZigZag());
    }

    void read(const char* name, int64_t& value) {
        value = readZigZag();
    }

    void read(const char* name, uint16_t& value) {
        value = castValue<uint16_t>(readVInt());
    }

    void read(const char* name, uint32_t& value) {
        value = castValue<uint32_t>(readVInt());
    }

    void read(const char* name, uint64_t& value) {
        value = readVInt();
    }

    void read(const char* name, bool& value) {
        switch (readByte()) {
        case BOOL_TRUE:
            value = true;
            break;
        case BOOL_FALSE:
            value = false;
            break;
        default:
            throw DeserializationException("Invalid or corrupt serialized "
                    "stream detected: invalid encoded boolean value.");
        }
    }

    void read(const char* name, float& value) {
        readBytes(reinterpret_cast<char*>(&value), sizeof(value));
    }

    void read(const char* name, double& value) {
        readBytes(reinterpret_cast<char*>(&value), sizeof(value));
    }

    void read(const char* name, std::string& value) {
        readString(name, value);
    }

    void read(const char* name, char* value, size_t& size) {
        FixedSizeBuffer buf(value, 0, size);
        readString(name, buf);
        size = buf.size;
    }

    void read(const char* name, Buffer& value) {
        readBinary(name, value);
    }

    void read(const char* name, SBuffer& value) {
        readBinary(name, value);
    }

    void read(const char* name, void* value, size_t& size) {
        FixedSizeBuffer buf((char*) value, 0, size);
        readBinary(name, buf);
        size = buf.size;
    }

    template<typename T>
    T read(const char* name) {
        T v;
        read(name, v);
        return v;
    }

    template<typename T>
    void readString(const char* name, T& value) {
        readString(name, value, typename StringTraits<T>::Category());
    }

    template<typename T>
    void readBinary(const char* name, T& value) {
        readBinary(name, value, typename BinaryTraits<T>::Category());
    }

    template<typename T>
    void readObject(const char* name, T& value) {
        ObjectTraits<T>::Adapter::deserialize(*this, value);
    }

    template<typename TeslaType, typename T>
    void readArray(TeslaType, const char* name, T& value) {
        readArray(TeslaType(), name, value, typename ArrayTraits<T>::Category());
    }

    template<typename T>
    void readEnum(const char* name, T& value) {
        EnumTraits<T>::IntCaster::set(value, read<int32_t>(name));
    }

    template<typename TeslaType, typename T>
    void readNullable(TeslaType, const char* name, T& value) {
        bool isNull = read<bool>(NULL);
        if (isNull) {
            NullableTraits<T>::Resetter::reset(value);
        } else {
            NullableTraits<T>::Resetter::resetNew(value);
            read(typename TeslaType::NotNullableType(), name, *value);
        }
    }

    template<typename TeslaType, typename T>
    void readReference(TeslaType, const char* name, T& value) {
        int id = read<int>(name);
        if (id < 0) {
            read(typename TeslaType::ReferredType(), name, value);
            rp_.template put<T>(-id, value);
        } else {
            rp_.template get<T>(id, value);
        }
    }

private:
    BasicBinaryReader(const BasicBinaryReader&);
    BasicBinaryReader& operator=(const BasicBinaryReader&);

    template<typename T>
    void readString(const char* name, T& value, StringCategory_Castable) {
        std::string s;
        readString(name, s);
        StringTraits<T>::Caster::set(value, s);
    }

    template<typename T>
    void readString(const char* name, T& value, StringCategory_WriteInplace_FixedSize) {
        size_t size = read<uint32_t>(name);
        size_t capacity = StringTraits<T>::Adapter::capacity(value);
        if (capacity < size + 1) {
            std::stringstream ss;
            ss << "Buffer overflow when Tesla reads field \"" << name
                    << "\": the actual value size (" << size
                    << ") is larger than the buffer size (" << capacity
                    << "). This may caused by either invalid or corrupt data "
                            "stream, or the user allocated buffer is not larger enough.";
            throw DeserializationException(ss.str().c_str());
        }

        StringTraits<T>::Adapter::resize(value, size); // set actual data size.
        char* buf = StringTraits<T>::Adapter::buffer(value);
        readBytes(buf, size);
        buf[size] = '\0';
    }

    template<typename T>
    void readString(const char* name, T& value, StringCategory_WriteInplace_Resizeable) {
        size_t size = read<uint32_t>(name);
        StringTraits<T>::Adapter::resize(value, size);
        char* buf = StringTraits<T>::Adapter::buffer(value);
        readBytes(buf, size);
    }

    template<typename T>
    void readBinary(const char* name, T& value, BinaryCategory_WriteInplace_Resizeable) {
        size_t size = read<uint32_t>(name);
        BinaryTraits<T>::Adapter::resize(value, size);
        readBytes(BinaryTraits<T>::Adapter::buffer(value), size);
    }

    template<typename T>
    void readBinary(const char* name, T& value, BinaryCategory_WriteInplace_FixedSize) {
        size_t size = read<uint32_t>(name);
        size_t capacity = BinaryTraits<T>::Adapter::capacityInBytes(value);
        if (size > capacity) {
            std::stringstream ss;
            ss << "Buffer overflow when Tesla reads field \"" << name
                    << "\": the actual value size (" << size
                    << ") is larger than the buffer size (" << capacity
                    << "). This may caused by either invalid or corrupt data "
                            "stream, or the user allocated buffer is not larger enough.";
            throw DeserializationException(ss.str().c_str());
        }

        BinaryTraits<T>::Adapter::resize(value, size); // set actual data size.
        if (size > 0) {
            readBytes(BinaryTraits<T>::Adapter::buffer(value), size);
        }
    }

    template<typename T>
    void readBinary(const char* name, T& value, BinaryCategory_Castable) {
        Buffer buf;
        read(name, buf);
        BinaryTraits<T>::Caster::set(value, buf);
    }

    template<typename TeslaType, typename T>
    void readArray(TeslaType, const char* name, T& value, ArrayCategory_InplaceWritable) {
        size_t size = read<uint32_t>(name);
        ArrayTraits<T>::Adapter::resize(value, size);
        for (size_t i = 0; i < size; i++) {
            read(typename TeslaType::ElementType(), NULL,
                    ArrayTraits<T>::Adapter::at(value, i));
        }
    }

    template<typename TeslaType, typename T>
    void readArray(TeslaType, const char* name, T& value, ArrayCategory_Insertable) {
        size_t size = read<uint32_t>(name);
        ArrayTraits<T>::Adapter::clear(value);
        for (size_t i = 0; i < size; i++) {
            typename ArrayTraits<T>::ElementType element;
            read(typename TeslaType::ElementType(), NULL, element);
            ArrayTraits<T>::Adapter::insert(value, element);
        }
    }

    template<typename TeslaType, typename T>
    void readArray(TeslaType, const char* name, T& value, ArrayCategory_UserDefinedArray) {
        size_t size = read<uint32_t>(name);
        ArrayTraits<T>::Adapter::clear(value);
        for (size_t i = 0; i < size; i++) {
            typename ArrayTraits<T>::ElementType element;
            read(typename TeslaType::ElementType(), NULL, element);
            ArrayTraits<T>::Adapter::insert(value, element);
        }
    }

    char readByte() {
        char c;
        if (!(this->stream_->get(c)).good()) {
            throw DeserializationException("failed to read Tesla binary data, "
                    "stream is in bad state.");
        }
        return c;
    }

    void readBytes(char* buf, size_t size) {
        if (size <= 0)
            return;
        if (!(this->stream_->read(buf, size)).good()) {
            throw DeserializationException("failed to read Tesla binary data, "
                    "stream is in bad state.");
        }
    }

    uint64_t readVInt() {
        uint64_t nVal = 0;
        byte b = 0, noBits = 0;
        do {
            if (noBits >= sizeof(uint64_t) * 8) // No more than 64 bits.
                    {
                throw DeserializationException(
                        "Invalid or corrupt serialized stream detected: invalid LEB128 value.");
            }

            b = static_cast<byte>(readByte());
            nVal |= static_cast<uint64_t>((b & 0x7f)) << noBits;
            noBits += 7;
        } while (b & 0x80);
        return nVal;
    }

    int64_t readZigZag() {
        uint64_t n = readVInt();
        return ((n >> 1) ^ -static_cast<int64_t>(n & 1));
    }

    template<typename U, typename T>
    U castValue(T value) {
        if ((value < (std::numeric_limits<U>::min)())
                || (value > (std::numeric_limits<U>::max)())) {
            throw DeserializationException(
                    "Invalid or corrupt serialized stream detected: "
                            "overflow/underflow when reading an int16_t value.");
        }
        return static_cast<U>(value);
    }

    RefPolicy rp_;
};

class ReadReferenceCache {
public:

    template<typename T>
    void put(int id, T& v) {
        (*cache<T>())[id] = &v;
    }

    template<typename T>
    void get(int id, T &v) const {
        typename std::map<int, const T*>::const_iterator i;
        const std::map<int, const T*>* c = cache<T>();
        if (c != NULL && (i = c->find(id)) != c->end()) {
            v = *(i->second);
        } else {
            std::stringstream ss;
            ss << "Invalid or corrupt serialized stream detected: Invalid "
                    "reference id: " << id;
            throw DeserializationException(ss.str());
        }
    }

private:
    template<typename T>
    std::map<int, const T*>* cache() {
        if (idCaches_.find(&(typeid(T))) == idCaches_.end()) {
            idCaches_[&(typeid(T))] = std::map<int, const T*>();
        }
        return boost::any_cast<std::map<int, const T*> >(
                &(idCaches_[&(typeid(T))]));
    }

    template<typename T>
    const std::map<int, const T*>* cache() const {
        std::map<const type_info*, boost::any, TypeCompare>::const_iterator i =
                idCaches_.find(&(typeid(T)));
        if (i == idCaches_.end()) {
            return NULL;
        }
        return boost::any_cast<std::map<int, const T*> >(&(i->second));
    }

    struct TypeCompare {
        bool operator ()(const type_info* t1, const type_info* t2) const {
#ifdef _MSC_VER
            return t1->before(*t2) != 0;
#else // non-VC
            return t1->before(*t2);
#endif // non-VC
        }
    };

    std::map<const type_info*, boost::any, TypeCompare> idCaches_;
};

}

#endif /* BINARYREADER_H_ */
