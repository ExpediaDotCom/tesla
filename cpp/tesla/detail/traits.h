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
#ifndef TESLATRAITS_H_
#define TESLATRAITS_H_
#pragma once

#include <vector>
#include <tesla/tbase.h>

namespace tesla {

// The default caster, user type needs to be convertible to a standard (tesla type)
// type by static_cast and back using operator=. 
template<typename U, typename T>
struct StaticCaster {
    typedef U UserType;
    typedef T TeslaType;
    static TeslaType get(const UserType& val) {
        return static_cast<TeslaType>(val);
    }
    static void set(UserType& lval, const TeslaType& rval) {
        lval = rval;
    }
};

template<typename T>
struct SchemaTraits {
};

#define DEFINE_PRIMITIVE_TESLA_TYPE_TRAITS(tesla_type, c_type)                      \
    struct tesla_type##Category_Castable {};                                        \
    template <typename T>                                                           \
    struct tesla_type##Traits {                                                     \
        typedef tesla_type##Category_Castable Category;                             \
        typedef T Type;                                                             \
        typedef StaticCaster<T, c_type> Caster;                                     \
    };                                                                              \
    struct TeslaType_##tesla_type;                                                  \
    template <>                                                                     \
    struct SchemaTraits<c_type> {                                                   \
        typedef TeslaType_##tesla_type TeslaType;                                   \
    };

DEFINE_PRIMITIVE_TESLA_TYPE_TRAITS(Byte, byte)
DEFINE_PRIMITIVE_TESLA_TYPE_TRAITS(Int8, sbyte)
DEFINE_PRIMITIVE_TESLA_TYPE_TRAITS(Int16, int16)
DEFINE_PRIMITIVE_TESLA_TYPE_TRAITS(Int32, int32)
DEFINE_PRIMITIVE_TESLA_TYPE_TRAITS(Int64, int64)
DEFINE_PRIMITIVE_TESLA_TYPE_TRAITS(UInt16, uint16)
DEFINE_PRIMITIVE_TESLA_TYPE_TRAITS(UInt32, uint32)
DEFINE_PRIMITIVE_TESLA_TYPE_TRAITS(UInt64, uint64)
DEFINE_PRIMITIVE_TESLA_TYPE_TRAITS(Float, float)
DEFINE_PRIMITIVE_TESLA_TYPE_TRAITS(Double, double)
DEFINE_PRIMITIVE_TESLA_TYPE_TRAITS(Boolean, bool)
DEFINE_PRIMITIVE_TESLA_TYPE_TRAITS(String, std::string)
DEFINE_PRIMITIVE_TESLA_TYPE_TRAITS(Binary, Buffer)

#undef DEFINE_PRIMITIVE_TESLA_TYPE_TRAITS

typedef std::vector<bool>::reference BitReference;

template<>
struct StaticCaster<BitReference, bool> {
    static bool get(BitReference val) {
        return static_cast<bool>(val);
    }
    static void set(BitReference lval, bool rval) {
        lval = rval;
    }
};

template<typename T>
struct EnumTraits {
    typedef T Type;
    struct IntCaster {
        typedef T UserType;
        typedef int32 IntType;
        static IntType get(const UserType& val) {
            return static_cast<IntType>(val);
        }
        static void set(UserType& lval, IntType rval) {
            lval = static_cast<UserType>(rval);
        }
    };
    // TODO: this is reserver for JSON and XML encoding, which will write enums as strings.
    // typedef StaticCaster<T, std::string> StringCaster;
};

struct FixedSizeBuffer {
    char* buffer;
    size_t size;
    const size_t capacity;
    FixedSizeBuffer(char* buf, size_t sz, size_t cp) :
            buffer(buf), size(sz), capacity(cp) {
        assert(buf != NULL);
        assert(capacity >= size);
    }
};

template<typename T>
struct FixedSizeBufferAdapter {
};

template<>
struct FixedSizeBufferAdapter<FixedSizeBuffer> {
    typedef FixedSizeBuffer Type;
    static size_t size(Type& value) {
        return value.size;
    }
    static size_t sizeInBytes(Type& value) {
        return value.size;
    }
    static void resize(Type& value, size_t size) {
        assert(size <= value.capacity);
        value.size = size;
    }
    static size_t capacity(Type& value) {
        return value.capacity;
    }
    static size_t capacityInBytes(Type& value) {
        return value.capacity;
    }
    static char* buffer(Type& value) {
        return value.buffer;
    }
};

//TODO: size/capacity needs to be include sizeof(T)
template<typename T, size_t N>
struct FixedSizeBufferAdapter<T[N]> {
    typedef T Type[N];
    static size_t size(Type&) {
        return N;
    }
    static size_t sizeInBytes(Type&) {
        return N * sizeof(T);
    }
    static void resize(Type&, size_t) {
    }  // actual data size is thrown away.
    static size_t capacity(Type& value) {
        return N;
    }
    static size_t capacityInBytes(Type& value) {
        return N * sizeof(T);
    }
    static char* buffer(Type& value) {
        return const_cast<char*>(reinterpret_cast<const char*>(&value));
    }
};

struct StringCategory_WriteInplace_FixedSize {
};
struct StringCategory_WriteInplace_Resizeable {
};

template<>
struct StringTraits<std::string> {
    typedef StringCategory_WriteInplace_Resizeable Category;
    typedef std::string Type;
    struct Adapter {
        static void resize(Type& value, size_t size) {
            value.resize(size);
        }
        static char* buffer(Type& value) {
            return &value[0];
        }
        static const char* buffer(const Type& value) {
            return value.c_str();
        }
    };
};

template<size_t N>
struct StringTraits<char[N]> {
    typedef StringCategory_WriteInplace_FixedSize Category;
    typedef char Type[N];
    typedef FixedSizeBufferAdapter<Type> Adapter;
};

template<>
struct StringTraits<FixedSizeBuffer> {
    typedef StringCategory_WriteInplace_FixedSize Category;
    typedef FixedSizeBuffer Type;
    typedef FixedSizeBufferAdapter<Type> Adapter;
};

struct BinaryCategory_WriteInplace_Resizeable {
};
struct BinaryCategory_WriteInplace_FixedSize {
};

template<typename T>
struct BinaryTraits<std::vector<T> > {
    typedef BinaryCategory_WriteInplace_Resizeable Category;
    typedef std::vector<T> Type;
    struct Adapter {
        static size_t sizeInBytes(const Type& value) {
            return value.size() * sizeof(T);
        }
        static void resize(Type& value, size_t size) {
            value.resize(size);
        }
        static char* buffer(Type& value) {
            return value.empty() ?
                    NULL : reinterpret_cast<char*>(&value.front());
        }
    };
};

template<typename T, size_t N>
struct BinaryTraits<T[N]> {
    typedef BinaryCategory_WriteInplace_FixedSize Category;
    typedef T Type[N];
    typedef FixedSizeBufferAdapter<Type> Adapter;
};

template<>
struct BinaryTraits<FixedSizeBuffer> {
    typedef BinaryCategory_WriteInplace_FixedSize Category;
    typedef FixedSizeBuffer Type;
    typedef FixedSizeBufferAdapter<Type> Adapter;
};

// Object

template<typename T>
struct ObjectTraits {
    typedef T ObjectType;
    struct Adapter {
        template<typename Writer>
        static void serialize(Writer& writer, T const& value) {
            value.serialize(writer);
        }
        template<typename Reader>
        static void deserialize(Reader& reader, T& value) {
            value.deserialize(reader);
        }
    };
};

// Array types
struct ArrayCategory_InplaceWritable {
};
struct ArrayCategory_Insertable {
};
struct ArrayCategory_Builtin {
};
struct ArrayCategory_UserDefinedArray {
};

template<typename T>
struct ArrayTraits {
    typedef ArrayCategory_Insertable Category;
    typedef T Container;
    typedef typename Container::value_type ElementType;
    struct Adapter {
        static void clear(Container& container) {
            container.clear();
        }
        static void insert(Container& container, const ElementType& element) {
            container.insert(container.end(), element);
        }
    };
};

template<typename T>
struct ArrayTraits<std::vector<T> > {
    typedef ArrayCategory_InplaceWritable Category;
    typedef std::vector<T> Container;
    typedef typename Container::const_reference ElementConstReference;
    typedef typename Container::reference ElementReference;
    struct Adapter {
        static void resize(Container& container, size_t size) {
            container.resize(size);
        }
        static ElementReference at(Container& container, size_t index) {
            return container[index];
        }
        static ElementConstReference atC(const Container& container,
                size_t index) {
            return container[index];
        }
    };
};

template<typename T, size_t N>
struct ArrayTraits<T[N]> {
    typedef ArrayCategory_InplaceWritable Category;
    typedef T& ElementReference;
    typedef const T& ElementConstReference;
    struct Adapter {
        static void resize(T container[N], size_t size) {
            if (size > N) {
                throw DeserializationException("Array size overflow.");
            }
        }
        static ElementReference at(T (&container)[N], size_t index) {
            if (index >= N) {
                throw TeslaException("Array access overflow.");
            }
            return container[index];
        }
        static ElementConstReference atC(const T (&container)[N],
                size_t index) {
            if (index >= N) {
                throw TeslaException("Array access overflow.");
            }
            return container[index];
        }
    };
};

//-----------------------------------------------------------------------------
/// a "Template" for a user defined array traits and adapter class
/// - an adapter would need to implement the following function signatures
///
/// \c UDA is a User Defined Array type with an element of type \c E
/// and an index type of \c I. This accomodates array user defined array types
/// that have an index type other than size_t.
///
/// \code
///     typename<>
///     struct ArrayTraits<UDA> {
///         typedef ArrayCategory_UserDefinedArray UDA;
///         typedef UDA Container;
///         typedef E ElementType;
///         typedef E& ElementReference;
///         struct Adapter {
///             typedef I IndexType;
///             static long size(const Container& container);
///             static void resize(Container& container, size_t size);
///             static ElementReference at(Container& container, size_t index);
///             static void clear(Container& container);
///             static void insert(Container& container, const ElementType& element);
///         };
///     };
/// \endcode
/// 
//-----------------------------------------------------------------------------

template<typename T>
struct PointerResetter {
    typedef typename T::element_type ElementType;

    static void reset(T& smrtptr, ElementType* pv = NULL) {
        smrtptr.reset(pv);
    }

    static void resetNew(T& smrtptr) {
        smrtptr.reset(new ElementType());
    }
};

template<typename T>
struct PointerResetter<T*> {
    typedef T ElementType;

    static void reset(ElementType*& ptr, ElementType* pv = NULL) {
        if (ptr != NULL) {
            delete ptr;
        }
        ptr = NULL;
    }

    static void resetNew(ElementType*& ptr) {
        reset(ptr, NULL);
        ptr = new ElementType();
    }
};

template<typename T>
struct NullableTraits {
    typedef typename T::element_type ElementType;
    typedef PointerResetter<T> Resetter;
    struct Adapter {
        static bool isNull(const T& value) {
            return value.get() == NULL;
        }
        static const ElementType& get(const T& value) {
            return *value;
        }
    };
};

// Raw pointer Nullable types
template<typename T>
struct NullableTraits<T*> {
    typedef T ElementType;
    typedef PointerResetter<T*> Resetter;
    struct Adapter {
        static bool isNull(const T* value) {
            return value == NULL;
        }
        static const ElementType& get(const T* value) {
            return *value;
        }
    };
};

} // namespace tesla

#endif // TESLATRAITS_H_
