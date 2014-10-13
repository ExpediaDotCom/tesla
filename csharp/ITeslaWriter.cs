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

using System;
using Expedia.Tesla.Schema;

namespace Expedia.Tesla.Serialization
{
    /// <summary>
    /// This interface defines basic Tesla serialization operations. Each
    /// Tesla encoding will has its implementation of this interface.
    /// </summary>
    public interface ITeslaWriter : ISchemaVersion
    {
        /// <summary>
        /// Gets the Tesla schema version.
        /// </summary>
        SchemaVersion Version { get; }

        /// <summary>
        /// Write a byte value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        void Write(string name, byte value);

        /// <summary>
        /// Write a 16-bit int value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        void Write(string name, short value);

        /// <summary>
        /// Write a 32-bit int value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        void Write(string name, int value);

        /// <summary>
        /// Write a 64-bit int value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        void Write(string name, long value);

        /// <summary>
        /// Write a 16-bit unsigned int value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        void Write(string name, ushort value);

        /// <summary>
        /// Write a 32-bit unsigned int value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        void Write(string name, uint value);

        /// <summary>
        /// Write a 64-bit unsigned int value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        void Write(string name, ulong value);

        /// <summary>
        /// Write a boolean value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        void Write(string name, bool value);

        /// <summary>
        /// Write a float value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        void Write(string name, float value);

        /// <summary>
        /// Write a double value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        void Write(string name, double value);

        /// <summary>
        /// Write a string value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        void Write(string name, string value, bool nullable);

        /// <summary>
        /// Write a binary value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        void Write(string name, byte[] value, bool nullable);

        /// <summary>
        /// Write an object value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        void Write(string name, ISerializable value, bool nullable);

        /// <summary>
        /// Write an Enum value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// The where conditions are the best way to restrict to enum types 
        /// See http://stackoverflow.com/a/7516220/308383 for an explanation on how to restrict to Enum type
        void Write<T>(string name, T value) where T : struct, IComparable, IFormattable, IConvertible;

        /// <summary>
        /// Write beginning of an object. 
        /// </summary>
        /// <param name="name">Name of object.</param>
        void WriteObjectBegin(string name);

        /// <summary>
        /// Write end of an object. Binary encoding does not have an object ending data. 
        /// This function does nothing.
        /// </summary>
        /// <param name="name">Name of object</param>
        void WriteObjectEnd(string name);

        /// <summary>
        /// Write byte array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        void WriteByteArray(string name, object value, bool nullable, uint rank);

        /// <summary>
        /// Write 16-bit int array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        void WriteInt16Array(string name, object value, bool nullable, uint rank);

        /// <summary>
        /// Write 32-bit int array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        void WriteInt32Array(string name, object value, bool nullable, uint rank);

        /// <summary>
        /// Write 64-bit int array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        void WriteInt64Array(string name, object value, bool nullable, uint rank);

        /// <summary>
        /// Write 16-bit unsigned int array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        void WriteUInt16Array(string name, object value, bool nullable, uint rank);

        /// <summary>
        /// Write 32-bit unsigned int array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        void WriteUInt32Array(string name, object value, bool nullable, uint rank);

        /// <summary>
        /// Write 64-bit unsigned int array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        void WriteUInt64Array(string name, object value, bool nullable, uint rank);

        /// <summary>
        /// Write bool array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        void WriteBooleanArray(string name, object value, bool nullable, uint rank);

        /// <summary>
        /// Write float array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        void WriteFloatArray(string name, object value, bool nullable, uint rank);

        /// <summary>
        /// Write double array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        void WriteDoubleArray(string name, object value, bool nullable, uint rank);

        /// <summary>
        /// Write string array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        void WriteStringArray(string name, object value, bool nullable, uint rank);

        /// <summary>
        /// Write binary array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        void WriteBinaryArray(string name, object value, bool nullable, uint rank);

        /// <summary>
        /// Write object array value.
        /// </summary>
        /// <typeparam name="T">Type of the entry of the array.</typeparam>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        void WriteObjectArray<T>(string name, object value, bool nullable, uint rank) where T : ISerializable;

        /// <summary>
        /// Write an Enum array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        void WriteEnumArray<T>(string name, object value, bool nullable) where T : struct, IComparable, IFormattable, IConvertible;

        /// <summary>
        /// Write an Enum array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        void WriteEnumArray<T>(string name, object value, bool nullable, uint rank) where T : struct, IComparable, IFormattable, IConvertible;
    }
}