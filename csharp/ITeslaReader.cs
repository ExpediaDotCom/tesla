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
    /// This interface defines basic Tesla deserialization operations. Each 
    /// Tesla encoding will has its implementation of this interface.
    /// </summary>
    public interface ITeslaReader : ISchemaVersion
    {
        /// <summary>
        /// Gets the Tesla schema version.
        /// </summary>
        SchemaVersion Version { get; }

        /// <summary>
        /// Read a single byte.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>
        /// The value of current member.
        /// </returns>
        byte ReadByte(string name);

        /// <summary>
        /// Read a 16-bit integer value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>
        /// The value of current member.
        /// </returns>
        short ReadInt16(string name);

        /// <summary>
        /// Read a 32-bit integer value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>
        /// The value of current member.
        /// </returns>
        int ReadInt32(string name);

        /// <summary>
        /// Read a 64-bit integer value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>
        /// The value of current member.
        /// </returns>
        long ReadInt64(string name);

        /// <summary>
        /// Read a 16-bit unsigned integer value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>The value of current member.</returns>
        ushort ReadUInt16(string name);

        /// <summary>
        /// Read a 32-bit unsigned integer value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>
        /// The value of current member.
        /// </returns>
        uint ReadUInt32(string name);

        /// <summary>
        /// Read a 64-bit unsigned integer value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>
        /// The value of current member.
        /// </returns>
        ulong ReadUInt64(string name);

        /// <summary>
        /// Read a boolean value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>The value of current member.</returns>
        bool ReadBoolean(string name);

        /// <summary>
        /// Read a float value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>
        /// The value of current member.
        /// </returns>
        float ReadFloat(string name);

        /// <summary>
        /// Read a float value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>The value of current member.</returns>
        double ReadDouble(string name);

        /// <summary>
        /// Read a string value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <returns>
        /// The value of current member.
        /// </returns>
        string ReadString(string name, bool nullable);

        /// <summary>
        /// Read a binary value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <returns>
        /// The value of current member.
        /// </returns>
        byte[] ReadBinary(string name, bool nullable);

        /// <summary>
        /// Read a enum value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>
        /// The value of current member.
        /// </returns>
        /// The where conditions are the best way to restrict to enum types 
        /// See http://stackoverflow.com/a/7516220/308383 for an explanation on how to restrict to Enum type
        T ReadEnum<T>(string name) where T : struct, IComparable, IFormattable, IConvertible;

        /// <summary>
        /// Read beginning of an object. 
        /// </summary>
        /// <param name="name">Name of the object.</param>
        void ReadObjectBegin(string name);

        /// <summary>
        /// Read end of an object. 
        /// </summary>
        /// <param name="name">Name of the object.</param>
        void ReadObjectEnd(string name);

        /// <summary>
        /// Read a object field value.
        /// </summary>
        /// <typeparam name="T">Type of element.</typeparam>
        /// <param name="name">Name of the member.</param>
        /// <param name="nullable">If this field can be null.</param>
        /// <returns>
        /// The value of current member.
        /// </returns>
        T ReadObject<T>(string name, bool nullable) where T : class, ISerializable, new();

        /// <summary>
        /// Read a byte array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        /// <returns>
        /// A List &lt; byte &gt; value of the array.
        /// </returns>
        object ReadByteArray(string name, bool nullable, uint rank);

        /// <summary>
        /// Read a 16-bit int array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        /// <returns>
        /// A List value of the array.
        /// </returns>
        object ReadInt16Array(string name, bool nullable, uint rank);

        /// <summary>
        /// Read a 32-bit int array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        /// <returns>
        /// A List value of the array.
        /// </returns>
        object ReadInt32Array(string name, bool nullable, uint rank);

        /// <summary>
        /// Read a 64-bit int array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        /// <returns>
        /// A List value of the array.
        /// </returns>
        object ReadInt64Array(string name, bool nullable, uint rank);

        /// <summary>
        /// Read a 16-bit unsigned int array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        /// <returns>
        /// A List value of the array.
        /// </returns>
        object ReadUInt16Array(string name, bool nullable, uint rank);

        /// <summary>
        /// Read a 32-bit unsigned int array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        /// <returns>
        /// A List value of the array.
        /// </returns>
        object ReadUInt32Array(string name, bool nullable, uint rank);

        /// <summary>
        /// Read a 64-bit unsigned int array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        /// <returns>
        /// A List value of the array.
        /// </returns>
        object ReadUInt64Array(string name, bool nullable, uint rank);

        /// <summary>
        /// Read a bool array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank. </param>
        /// <returns>A List value of the array.</returns>
        object ReadBooleanArray(string name, bool nullable, uint rank);

        /// <summary>
        /// Read a float array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        /// <returns>
        /// A List value of the array.
        /// </returns>
        object ReadFloatArray(string name, bool nullable, uint rank);

        /// <summary>
        /// Read a double array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        /// <returns>
        /// A List value of the array.
        /// </returns>
        object ReadDoubleArray(string name, bool nullable, uint rank);

        /// <summary>
        /// Read a string array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank. </param>
        /// <returns>A List value of the array.</returns>
        object ReadStringArray(string name, bool nullable, uint rank);

        /// <summary>
        /// Read a binary array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        /// <returns>
        /// A List value of the array.
        /// </returns>
        object ReadBinaryArray(string name, bool nullable, uint rank);

        /// <summary>
        /// Read an object array.
        /// </summary>
        /// <typeparam name="T">Type of element.</typeparam>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        /// <returns>
        /// A List value of the array.
        /// </returns>
        object ReadObjectArray<T>(string name, bool nullable, uint rank) where T : class, ISerializable, new();

       /// <summary>
        /// Read a enum array.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <returns>
        /// A List value of the array
        /// </returns>
        object ReadEnumArray<T>(string name, bool nullable) where T : struct, IComparable, IFormattable, IConvertible;
 
        /// <summary>
        /// Read a enum array.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        /// <returns>
        /// A List value of the array
        /// </returns>
        object ReadEnumArray<T>(string name, bool nullable, uint rank)  where T : struct, IComparable, IFormattable, IConvertible;
    }
}