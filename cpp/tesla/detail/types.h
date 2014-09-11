/*
 * Copyright (C) 2013, Expedia Inc.  All rights reserved.
 *
 * types.h
 *
 *  Created on: Oct 23, 2013
 *      Author: Yunfei Zuo (yzuo@expedia.com)
 */
#ifndef TESLATYPES_H_
#define TESLATYPES_H_
#pragma once

#include <tesla/tbase.h>
#include <tesla/detail/traits.h>

namespace tesla {

#define FORWARD_DECLARE_TESLA_PRIMITIVE_TYPES(type_name)                            \
    struct TeslaType_##type_name;                                                   \
    struct TeslaType_##type_name##Array;                                            \
    struct TeslaType_##type_name##ArrayNullable;                                    \
    struct TeslaType_##type_name##Array2D;                                          \
    struct TeslaType_##type_name##Array2DNullable;                                  \
    struct TeslaType_##type_name##Array3D;                                          \
    struct TeslaType_##type_name##Array3DNullable;

#define TYPEDEF_ARRAYS(tesla_type)                                                  \
    typedef TeslaType_##tesla_type##Array Array;                                    \
    typedef TeslaType_##tesla_type##ArrayNullable ArrayNullable;                    \
    typedef TeslaType_##tesla_type##Array2D Array2D;                                \
    typedef TeslaType_##tesla_type##Array2DNullable Array2DNullable;                \
    typedef TeslaType_##tesla_type##Array3D Array3D;                                \
    typedef TeslaType_##tesla_type##Array3DNullable Array3DNullable;                \


#define DEFINE_TESLA_PRIMITIVE_TYPE(tesla_type, c_type)                             \
    FORWARD_DECLARE_TESLA_PRIMITIVE_TYPES(tesla_type)                               \
    struct TeslaType_##tesla_type {                                                 \
        template <typename ReaderType, typename T>                                  \
        static void read(ReaderType& reader, const char* name, T& value) {          \
            tesla_type##Traits<T>::Caster::set(value,                               \
                reader.template read<c_type>(name));                                \
        }                                                                           \
        template <typename WriterType, typename T>                                  \
        static void write(WriterType& writer, const char* name, const T& value) {   \
            writer.write(name, tesla_type##Traits<T>::Caster::get(value));          \
        }                                                                           \
        TYPEDEF_ARRAYS(tesla_type)                                                  \
    };

// Basic primitive types
DEFINE_TESLA_PRIMITIVE_TYPE(Byte, byte)
DEFINE_TESLA_PRIMITIVE_TYPE(Int8, sbyte)
DEFINE_TESLA_PRIMITIVE_TYPE(Int16, int16_t)
DEFINE_TESLA_PRIMITIVE_TYPE(Int32, int32_t)
DEFINE_TESLA_PRIMITIVE_TYPE(Int64, int64_t)
DEFINE_TESLA_PRIMITIVE_TYPE(UInt16, uint16_t)
DEFINE_TESLA_PRIMITIVE_TYPE(UInt32, uint32_t)
DEFINE_TESLA_PRIMITIVE_TYPE(UInt64, uint64_t)
DEFINE_TESLA_PRIMITIVE_TYPE(Boolean, bool)
DEFINE_TESLA_PRIMITIVE_TYPE(Float, float)
DEFINE_TESLA_PRIMITIVE_TYPE(Double, double)

#define DEFINE_TESLA_PRIMITIVE_TYPE_OVERLOAD(type_name)                             \
    FORWARD_DECLARE_TESLA_PRIMITIVE_TYPES(type_name)                                \
    struct TeslaType_##type_name {                                                  \
        template <typename ReaderType, typename T>                                  \
        static void read(ReaderType& reader, const char* name, T& value) {          \
            reader.read##type_name(name, value);                                    \
        }                                                                           \
        template <typename ReaderType, typename T>                                  \
        static void read(ReaderType& reader, const char* name, T*& value) {         \
            PointerResetter<T*>::resetNew(value);                                   \
            reader.read##type_name(name, *value);                                   \
        }                                                                           \
        template <typename WriterType, typename T>                                  \
        static void write(WriterType& writer, const char* name, const T& value) {   \
            writer.write##type_name(name, value);                                   \
        }                                                                           \
		template <typename WriterType, typename T, size_t N>                        \
        static void write(WriterType& writer, const char* name,                     \
                const T (&value)[N]) {                                              \
            writer.write##type_name(name, value);                                   \
        }                                                                           \
        TYPEDEF_ARRAYS(type_name)                                                   \
    };

DEFINE_TESLA_PRIMITIVE_TYPE_OVERLOAD(String)
DEFINE_TESLA_PRIMITIVE_TYPE_OVERLOAD(Binary)
DEFINE_TESLA_PRIMITIVE_TYPE_OVERLOAD(Object)
DEFINE_TESLA_PRIMITIVE_TYPE_OVERLOAD(Enum)

// Nullable types, must be wrapped with pointer or smart pointers.

template<typename ElementType>
struct TeslaType_Nullable {
    template<typename ReaderType, typename T>
    static void read(ReaderType& reader, const char* name, T& value) {
        reader.readNullable(ElementType(), name, value);
    }
    template<typename WriterType, typename T>
    static void write(WriterType& writer, const char* name, const T& value) {
        writer.writeNullable(ElementType(), name, value);
    }
};

#define DEFINE_TESLA_NULLABLE_TYPE(tesla_type)                                      \
    struct TeslaType_##tesla_type##Nullable :                                       \
        TeslaType_Nullable<TeslaType_##tesla_type##Nullable> {                      \
        typedef TeslaType_##tesla_type NotNullableType;                             \
    };

struct TeslaType_ObjectReference {
    typedef TeslaType_Object ReferredType;
    template<typename ReaderType, typename T>
    static void read(ReaderType& reader, const char* name, T& value) {
        reader.readReference(TeslaType_ObjectReference(), name, value);
    }
    template<typename WriterType, typename T>
    static void write(WriterType& writer, const char* name, const T& value) {
        writer.writeReference(TeslaType_ObjectReference(), name, value);
    }
};

// Following primitive types are nullable
DEFINE_TESLA_NULLABLE_TYPE(String)
DEFINE_TESLA_NULLABLE_TYPE(Binary)
DEFINE_TESLA_NULLABLE_TYPE(Object)

// Array types, all array types are nullable
template<typename ArrayType>
struct TeslaType_Array {
    template<typename ReaderType, typename T>
    static void read(ReaderType& reader, const char* name, T& value) {
        reader.readArray(ArrayType(), name, value);
    }
    template<typename WriterType, typename T>
    static void write(WriterType& writer, const char* name, const T& value) {
        writer.writeArray(ArrayType(), name, value);
    }
};

#define DEFINE_TESLA_ARRAY_TYPE(array_type, element_type)                           \
    struct TeslaType_##array_type : TeslaType_Array<TeslaType_##array_type> {       \
        typedef TeslaType_##element_type ElementType;                               \
    };                                                                              \
    DEFINE_TESLA_NULLABLE_TYPE(array_type)

#define DEFINE_TESLA_MULTIDIMENSIONAL_ARRAY(tesla_type)                             \
    DEFINE_TESLA_ARRAY_TYPE(tesla_type##Array, tesla_type)                          \
    DEFINE_TESLA_ARRAY_TYPE(tesla_type##Array2D, tesla_type##Array)                 \
    DEFINE_TESLA_ARRAY_TYPE(tesla_type##Array3D, tesla_type##Array2D)

DEFINE_TESLA_MULTIDIMENSIONAL_ARRAY(Byte);
DEFINE_TESLA_MULTIDIMENSIONAL_ARRAY(Int8);
DEFINE_TESLA_MULTIDIMENSIONAL_ARRAY(Int16);
DEFINE_TESLA_MULTIDIMENSIONAL_ARRAY(Int32);
DEFINE_TESLA_MULTIDIMENSIONAL_ARRAY(Int64);
DEFINE_TESLA_MULTIDIMENSIONAL_ARRAY(UInt16);
DEFINE_TESLA_MULTIDIMENSIONAL_ARRAY(UInt32);
DEFINE_TESLA_MULTIDIMENSIONAL_ARRAY(UInt64);
DEFINE_TESLA_MULTIDIMENSIONAL_ARRAY(Float);
DEFINE_TESLA_MULTIDIMENSIONAL_ARRAY(Double);
DEFINE_TESLA_MULTIDIMENSIONAL_ARRAY(Boolean);
DEFINE_TESLA_MULTIDIMENSIONAL_ARRAY(String);
DEFINE_TESLA_MULTIDIMENSIONAL_ARRAY(Binary);
DEFINE_TESLA_MULTIDIMENSIONAL_ARRAY(Object);
DEFINE_TESLA_MULTIDIMENSIONAL_ARRAY(Enum);

struct TeslaType_ObjectReferenceArray: TeslaType_Array<
        TeslaType_ObjectReferenceArray> {
    typedef TeslaType_ObjectReference ElementType;
};

#undef DEFINE_TESLA_PRIMITIVE_TYPE
#undef DEFINE_TESLA_NULLABLE_TYPE
#undef DEFINE_TESLA_ARRAY_TYPE
#undef DEFINE_TESLA_MULTIDIMENSIONAL_ARRAY

} // namespace tesla

#endif // TESLATYPES_H_
