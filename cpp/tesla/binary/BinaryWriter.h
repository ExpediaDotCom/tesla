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

#ifndef BINARYWRITER_H_
#define BINARYWRITER_H_

// boost
#include <boost/any.hpp>

// stl
#include <map>

// tesla
#include <tesla/tbase.h>
#include <tesla/detail/types.h>
#include <tesla/detail/traits.h>
#include <tesla/detail/Writer.h>

namespace tesla {

struct WriteReferenceCache;

template<class Stream, typename RefPolicy = WriteReferenceCache>
class BasicBinaryWriter: public Writer<Stream> {
public:
    explicit BasicBinaryWriter(Stream* stream, SchemaVersion const& ver =
            SchemaVersion()) :
            Writer(stream, ver) {
    }

    // write a tesla type
    template<typename TeslaType, typename T>
    void write(TeslaType, const char* name, const T& value) {
        TeslaType::write(*this, name, value);
    }

    // write primitive byte
    void write(const char* name, const byte& value) {
        writeByte(value);
    }

    // write primitive signed byte
    void write(const char* name, const sbyte& value) {
        writeByte(static_cast<sbyte>(value));
    }

    // write primitive signed 16-bit int
    void write(const char* name, const int16_t& value) {
        writeVInt(static_cast<uint16_t>((value << 1) ^ (value >> 15)));
    }

    // write primitive signed 32-bit int
    void write(const char* name, const int32_t& value) {
        writeVInt(static_cast<uint32_t>((value << 1) ^ (value >> 31)));
    }

    // write primitive signed 64-bit int
    void write(const char* name, const int64_t& value) {
        writeVInt(static_cast<uint64_t>((value << 1) ^ (value >> 63)));
    }

    // write primitive unsigned 16-bit int
    void write(const char* name, const uint16_t& value) {
        writeVInt(value);
    }

    // write primitive unsigned 32-bit int
    void write(const char* name, const uint32_t& value) {
        writeVInt(value);
    }

    // write primitive unsigned 64-bit int
    void write(const char* name, const uint64_t& value) {
        writeVInt(value);
    }

    // write primitive float
    void write(const char* name, const float& value) {
        writeBytes(&value, sizeof(value));
    }

    // write primitive double
    void write(const char* name, const double& value) {
        writeBytes(&value, sizeof(value));
    }

    // write primitive bool
    void write(const char* name, const bool& value) {
        writeByte(value ? BOOL_TRUE : BOOL_FALSE);
    }

    // write primitive string
    void write(const char* name, const std::string& value) {
        write(name, value.c_str(), value.size());
    }

    // write primitive binary buffer
    void write(const char* name, const Buffer& value) {
        if (value.size() == 0) {
            writeVInt(0);
        } else {
            write(name, &value.front(), value.size());
        }
    }

    // write primitive binary signed buffer
    void write(const char* name, const SBuffer& value) {
        if (value.size() == 0) {
            writeVInt(0);
        } else {
            write(name, &value.front(), value.size());
        }
    }

    //----------------------------
    // string methods
    //----------------------------
    // write c-style string
    void write(const char* name, const char* value) {
        write(name, value, strlen(value));
    }

    // write c-style string subset
    void write(const char* name, const char* value, size_t size) {
        write(name, static_cast<const void*>(value), size);
    }

    // write string core method - writes length prefixed string
    void write(const char* name, const void* value, size_t size) {
        writeVInt(size);
        writeBytes(value, size);
    }

    // write a tesla string
    template<typename T>
    void writeString(const char* name, const T& value) {
        writeString(name, value, typename StringTraits<T>::Category());
    }

    // write a tesla binary buffer
    template<typename T>
    void writeBinary(const char* name, const T& value) {
        writeBinary(name, value, typename BinaryTraits<T>::Category());
    }

    /*
    // write a fixed sized buffer array
    template<typename T, size_t N>
    void writeBinary(const char* name, const T (&value)[N]) {
        writeBinary(name, value, N, BinaryCategory_WriteInplace_FixedSize());
    }
    */

    template<typename T>
    void writeObject(const char* name, const T& value) {
        ObjectTraits<T>::Adapter::serialize(*this, value);
    }

    template<typename T>
    void writeEnum(const char* name, const T& value) {
        int32_t v = EnumTraits<T>::IntCaster::get(value);
        write(name, v);
    }

    // write a tesla array
    template<typename TeslaType, typename T>
    void writeArray(TeslaType, const char* name, const T& value) {
        writeArray(TeslaType(), name, value, typename ArrayTraits<T>::Category());
    }

    // write a fixed sized array
    template<typename TeslaType, typename T, size_t N>
    void writeArray(TeslaType, const char* name, const T (&value)[N]) {
        writeArray(TeslaType(), name, value, N, ArrayCategory_Builtin());
    }

    // write a tesla nullable type - it is bool prefixed
    template<typename TeslaType, typename T>
    void writeNullable(TeslaType, const char* name, const T& value) {
        bool isNull = NullableTraits<T>::Adapter::isNull(value);
        write(TeslaType_Boolean(), name, isNull);
        if (!isNull) {
            write(TeslaType::NotNullableType(), name, NullableTraits<T>::Adapter::get(value));
        }
    }

    // write a tesla reference type
    template<typename TeslaType, typename T>
    void writeReference(TeslaType, const char* name, const T& value) {
        int id = rp_.get<T>(value);
        if (id == 0) {
            id = rp_.put<T>(value);
            write("id", -id);
            write(typename TeslaType::ReferredType(), name, value);
        } else {
            write("ref-id", id);
        }
    }

private:
    // no copy constructor
    BasicBinaryWriter(const BasicBinaryWriter&);
    // no assignment
    BasicBinaryWriter& operator=(const BasicBinaryWriter&);

    template<typename T>
    void writeString(const char* name, const T& value, StringCategory_Castable) {
        std::string s = StringTraits<T>::Caster::get(value);
        write(name, s);
    }

    // private helper for fixed size string
    template<typename T>
    void writeString(const char* name, T& value, StringCategory_WriteInplace_FixedSize) {
        write(name, s);
    }

    // private helper for resizeable string
    template<typename T>
    void writeString(const char* name, T& value, StringCategory_WriteInplace_Resizeable) {
        std::string s = StringTraits<T>::Caster::get(value);
        write(name, s);
    }

    // private helper for castable binary buffer
    template<typename T>
    void writeBinary(const char* name, const T& value, BinaryCategory_Castable) {
        write(name, BinaryTraits<T>::Caster::get(value));
    }

    // private helper for fixed size binary buffer
    template<typename T>
    void writeBinary(const char* name, const T& value, BinaryCategory_WriteInplace_FixedSize) {
        size_t size = BinaryTraits<T>::Adapter::sizeInBytes(value);
        const char* buf = BinaryTraits<T>::Adapter::buffer(const_cast<T&>(value));
        if (size == 0) {
            writeVInt(0);
        } else {
            write(name, buf, size);
        }
    }

    /*
    template<typename T>
    void writeBinary(const char* name, const T& value, size_t N,
            BinaryCategory_WriteInplace_FixedSize) {
        writeVInt(N);
		if (N > 0) {
			writeBytes(value, N);
		}
    }
    */

    // private helper for resizeable binary buffer
    template<typename T>
    void writeBinary(const char* name, const T& value, BinaryCategory_WriteInplace_Resizeable) {
        size_t size = BinaryTraits<T>::Adapter::sizeInBytes(value);
        const char* buf = BinaryTraits<T>::Adapter::buffer(const_cast<T&>(value));
        if (size == 0) {
            writeVInt(0);
        } else {
            write(name, buf, size);
        }
    }

    // private common helper
    template<typename T>
    void writeBinary(const char* name, const T& value, size_t size) {
        if (size == 0) {
            writeVInt(0);
        } else {
            write(name, &value.front(), size);
        }
    }

    // private helper for inplace writable arrays
    template<typename TeslaType, typename T>
    void writeArray(TeslaType, const char* name, const T& value, ArrayCategory_InplaceWritable) {
        typedef typename T::const_reference reference;
        writeElements(TeslaType::ElementType(), name, value.begin(),
                value.end(), value.size());
    }

    // private helper for insertable arrays
    template<typename TeslaType, typename T>
    void writeArray(TeslaType, const char* name, const T& value, ArrayCategory_Insertable) {
        typedef typename T::const_iterator iterator;
        writeElements(TeslaType::ElementType(), name, value.begin(),
                value.end(), value.size());
    }

    // private helper for c-style arrays
    template<typename TeslaType, typename T>
    void writeArray(TeslaType, const char* name, const T& value, size_t N,
            ArrayCategory_Builtin) {
        writeElements(typename TeslaType::ElementType(), name, &value[0],
                &value[N], N);
    }

    // private helper for user defined array types
    template<typename TeslaType, typename T>
    void writeArray(TeslaType, const char* name, const T& value, ArrayCategory_UserDefinedArray) {
        ArrayTraits<T>::Adapter::IndexType max = ArrayTraits<T>::Adapter::size(value);
        writeElements(typename TeslaType::ElementType(), name, value, max);
    }

    // private helper to write elements of an array
    template<typename ElementType, typename Iterator>
    void writeElements(ElementType, const char* name, Iterator begin, Iterator end, size_t size) {
        writeVInt(size);
        if (size != 0) {
            for (; begin != end; begin++) {
                write(ElementType(), name, *begin);
            }
        }
    }

    // private helper to write elements of a user defined array type
    template<typename ElementType, typename IndexType, typename T>
    void writeElements(ElementType, const char* name, const T& value, IndexType size) {
        writeVInt(size);
        if (size != 0) {
            for (IndexType i = 0; i < size; i++) {
                write(ElementType(), name, value[i]);
            }
        }
    }

    // private helper to write a byte
    void writeByte(byte c) {
        if (!((stream_->put(c)).good())) {
            throw SerializationException("Failed to write to stream.");
        }
    }

    // private helper to write a stream of bytes
    void writeBytes(const void* buf, size_t size) {
        if (!((stream_->write(static_cast<const char*>(buf), size)).good())) {
            throw SerializationException("Failed to write to stream.");
        }
    }

    // private helper to write any integer value
    void writeVInt(uint64_t value) {
        int count = 0;
        do {
            uint8_t b = (value & 0x7f);
            value >>= 7;
            b |= (value == 0 ? 0 : 0x80);
            writeByte(b);
            count++;
        } while (value != 0);
    }

    RefPolicy rp_;
};
// class BasicBinaryWriter

struct WriteReferenceCache {
    // trivial ctor
    WriteReferenceCache() :
            id_(0) {
    }
    // put saves next id
    template<typename T>
    int put(const T& value) {
        (*cache<T>())[value] = ++id_;
        return id_;
    }
    // get - returns id if in cache
    template<typename T>
    int get(const T& value) const {
        const std::map<T, int>* tc = cache<T>();
        if (tc == NULL)
            return 0;
        std::map<T, int>::const_iterator iter = tc->find(value);
        return iter != tc->end() ? iter->second : 0;
    }

private:
    // private helper to get cache for type - creates one if needed
    // - for use by put()
    template<typename T>
    std::map<T, int>* cache() {
        if (idCaches_.find(&typeid(T)) == idCaches_.end()) {
            idCaches_[&typeid(T)] = std::map<T, int>();
        }
        return boost::any_cast<std::map<T, int> >(&idCaches_[&typeid(T)]);
    }
    // private helper to get cache for type - does nor create
    // - for use by get()
    template<typename T>
    const std::map<T, int>* cache() const {
        std::map<const type_info*, boost::any, TypeCompare>::const_iterator iter =
                idCaches_.find(&(typeid(T)));
        if (iter == idCaches_.end()) {
            return NULL;
        }
        return boost::any_cast<std::map<T, int> >(&(iter->second));
    }
//TODO: share the code common between {Read|Write}ReferenceCache if possible
    // private struct for compare type information
    struct TypeCompare {
        bool operator()(const type_info* type1, const type_info* type2) const {
#ifdef _MSC_VER
            return type1->before(*type2) != 0;
#else // non-VC
            return type1->before(*type2);
#endif // non-VC
        }
    };
    // private data
    std::map<const type_info*, boost::any, TypeCompare> idCaches_;
    int id_;
};
// class WriteReferenceCache

}// namespace tesla

#endif /* BINARYWRITER_H_ */
