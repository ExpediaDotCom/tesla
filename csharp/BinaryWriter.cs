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
namespace Expedia.Tesla.Serialization
{
    using System;
    using System.Collections;
    using System.Collections.Generic;
    using System.ComponentModel;
    using Expedia.Tesla.Schema;

    /// <summary>
    /// Tesla binary encoding writer.
    /// </summary>
    public class BinaryWriter : SchemaVersion, ITeslaWriter
    {
        #region Fields
        /// <summary>
        /// Common error message.
        /// </summary>
        private readonly string ioErrorMsg = "An IO error happened during serialization.";

        /// <summary>
        /// Stream closed error message.
        /// </summary>
        private readonly string streamClosedErrorMsg = "Stream was closed during serialization.";

        /// <summary>
        /// Internal binary writer.
        /// </summary>
        private System.IO.BinaryWriter internalWriter;
        #endregion        
        
        #region Constructor       
        /// <summary>
        /// Initializes a new instance of the BinaryWriter class.
        /// </summary>
        /// <param name="output">The output stream.</param>
        /// <param name="version">Schema version.</param>
        public BinaryWriter(System.IO.Stream output, SchemaVersion version) : base (version)
        {
            this.internalWriter = new System.IO.BinaryWriter(output);
            this.Version = version;
        }
        #endregion

        /// <summary>
        /// Element Writer Delegate.
        /// </summary>
        /// <typeparam name="T">Type of the item to be written.</typeparam>
        /// <param name="name">The name.</param>
        /// <param name="value">The value.</param>
        private delegate void ElementWriter<T>(string name, T value);

        #region ITeslaWriter Implementation
        /// <summary>
        /// Gets the Tesla schema version. 
        /// </summary>
        public SchemaVersion Version { get; private set; }

        /// <summary>
        /// Write a byte value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        public void Write(string name, byte value)
        {
            try
            {
                this.internalWriter.Write(value);
            }
            catch (System.IO.IOException ex)
            {
                throw new TeslaSerializationException(this.ioErrorMsg, ex);
            }
            catch (System.ObjectDisposedException ex)
            {
                throw new TeslaSerializationException(this.streamClosedErrorMsg, ex);
            }
        }

        /// <summary>
        /// Write a 16-bit int value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        public void Write(string name, short value)
        {
            this.WriteVInt((ushort)((value << 1) ^ (value >> 15)));
        }

        /// <summary>
        /// Write a 32-bit int value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        public void Write(string name, int value)
        {
            this.WriteVInt((uint)((value << 1) ^ (value >> 31)));
        }

        /// <summary>
        /// Write a 64-bit int value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        public void Write(string name, long value)
        {
            this.WriteVInt((ulong)((value << 1) ^ (value >> 63)));
        }

        /// <summary>
        /// Write a 16-bit unsigned int value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        public void Write(string name, ushort value)
        {
            this.WriteVInt(value);
        }

        /// <summary>
        /// Write a 32-bit unsigned int value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        public void Write(string name, uint value)
        {
            this.WriteVInt(value);
        }

        /// <summary>
        /// Write a 64-bit unsigned int value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        public void Write(string name, ulong value)
        {
            this.WriteVInt(value);
        }

        /// <summary>
        /// Write a boolean value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        public void Write(string name, bool value)
        {
            try
            {
                this.internalWriter.Write((byte)(value ? TeslaConstants.BinaryEncodedBooleanTrue : TeslaConstants.BinaryEncodedBooleanFalse));
            }
            catch (System.IO.IOException ex)
            {
                throw new TeslaSerializationException(this.ioErrorMsg, ex);
            }
            catch (System.ObjectDisposedException ex)
            {
                throw new TeslaSerializationException(this.streamClosedErrorMsg, ex);
            }
        }

        /// <summary>
        /// Write a float value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        public void Write(string name, float value)
        {
            try
            {
                this.internalWriter.Write(value);
            }
            catch (System.IO.IOException ex)
            {
                throw new TeslaSerializationException(this.ioErrorMsg, ex);
            }
            catch (System.ObjectDisposedException ex)
            {
                throw new TeslaSerializationException(this.streamClosedErrorMsg, ex);
            }
        }

        /// <summary>
        /// Write a double value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        public void Write(string name, double value)
        {
            try
            {
                this.internalWriter.Write(value);
            }
            catch (System.IO.IOException ex)
            {
                throw new TeslaSerializationException(this.ioErrorMsg, ex);
            }
            catch (System.ObjectDisposedException ex)
            {
                throw new TeslaSerializationException(this.streamClosedErrorMsg, ex);
            }
        }

        /// <summary>
        /// Write a string value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        public void Write(string name, string value, bool nullable)
        {
            this.WriteNullableFlag(value, nullable);
            if (value != null)
            {
                try
                {
                    this.internalWriter.Write(value);
                }
                catch (System.IO.IOException ex)
                {
                    throw new TeslaSerializationException(this.ioErrorMsg, ex);
                }
                catch (System.ObjectDisposedException ex)
                {
                    throw new TeslaSerializationException(this.streamClosedErrorMsg, ex);
                }
            }
        }

        /// <summary>
        /// Write a binary value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        public void Write(string name, byte[] value, bool nullable)
        {
            this.WriteNullableFlag(value, nullable);

            if (value != null)
            {
                this.WriteVInt((ulong)value.Length);

                try
                {
                    this.internalWriter.Write(value);
                }
                catch (System.IO.IOException ex)
                {
                    throw new TeslaSerializationException(this.ioErrorMsg, ex);
                }
                catch (ObjectDisposedException ex)
                {
                    throw new TeslaSerializationException(this.streamClosedErrorMsg, ex);
                }
            }
        }

        /// <summary>
        /// Write an object value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        public void Write(string name, ISerializable value, bool nullable)
        {
            this.WriteNullableFlag(value, nullable);

            if (value != null)
            {
                value.Serialize(this);
            }
        }


        /// <summary>
        /// Write a Enum value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        public void Write<T>(string name, T value) where T : struct, IComparable, IFormattable, IConvertible
        {
            this.Write(name, (int)(ValueType)value);
        }

        /// <summary>
        /// Write beginning of an object. Binary encoding does not have an object beginning data. 
        /// This function does nothing.
        /// </summary>
        /// <param name="name">Name of object.</param>
        public void WriteObjectBegin(string name)
        {

        }

        /// <summary>
        /// Write end of an object. Binary encoding does not have an object ending data. 
        /// This function does nothing.
        /// </summary>
        /// <param name="name">Name of object</param>
        public void WriteObjectEnd(string name)
        {

        }

        /// <summary>
        /// Write byte array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        public void WriteByteArray(string name, object value, bool nullable, uint rank)
        {
            this.WriteArray<byte>(name, value, nullable, rank, this.Write);
        }

        /// <summary>
        /// Write 16-bit int array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        public void WriteInt16Array(string name, object value, bool nullable, uint rank)
        {
            this.WriteArray<short>(name, value, nullable, rank, this.Write);
        }

        /// <summary>
        /// Write 32-bit int array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        public void WriteInt32Array(string name, object value, bool nullable, uint rank)
        {
            this.WriteArray<int>(name, value, nullable, rank, this.Write);
        }

        /// <summary>
        /// Write 64-bit int array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        public void WriteInt64Array(string name, object value, bool nullable, uint rank)
        {
            this.WriteArray<long>(name, value, nullable, rank, this.Write);
        }

        /// <summary>
        /// Write 16-bit unsigned int array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        public void WriteUInt16Array(string name, object value, bool nullable, uint rank)
        {
            this.WriteArray<ushort>(name, value, nullable, rank, this.Write);
        }

        /// <summary>
        /// Write 32-bit unsigned int array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        public void WriteUInt32Array(string name, object value, bool nullable, uint rank)
        {
            this.WriteArray<uint>(name, value, nullable, rank, this.Write);
        }

        /// <summary>
        /// Write 64-bit unsigned int array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        public void WriteUInt64Array(string name, object value, bool nullable, uint rank)
        {
            this.WriteArray<ulong>(name, value, nullable, rank, this.Write);
        }

        /// <summary>
        /// Write bool array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        public void WriteBooleanArray(string name, object value, bool nullable, uint rank)
        {
            this.WriteArray<bool>(name, value, nullable, rank, this.Write);
        }

        /// <summary>
        /// Write float array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        public void WriteFloatArray(string name, object value, bool nullable, uint rank)
        {
            this.WriteArray<float>(name, value, nullable, rank, this.Write);
        }

        /// <summary>
        /// Write double array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        public void WriteDoubleArray(string name, object value, bool nullable, uint rank)
        {
            this.WriteArray<double>(name, value, nullable, rank, this.Write);
        }

        /// <summary>
        /// Write string array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        public void WriteStringArray(string name, object value, bool nullable, uint rank)
        {
            this.WriteArray<string>(name, value, nullable, rank, this.Write);
        }

        /// <summary>
        /// Write binary array value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        public void WriteBinaryArray(string name, object value, bool nullable, uint rank)
        {
            this.WriteArray<byte[]>(name, value, nullable, rank, this.Write);
        }

        /// <summary>
        /// Write object array value.
        /// </summary>
        /// <typeparam name="T">Type of the entry of the array.</typeparam>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        public void WriteObjectArray<T>(string name, object value, bool nullable, uint rank) where T : ISerializable
        {
            this.WriteArray<T>(name, value, nullable, rank, null);
        }

        /// <summary>
        /// Write enum array value.
        /// </summary>
        /// <typeparam name="T">Type of the entry of the array.</typeparam>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        public void WriteEnumArray<T>(string name, object value, bool nullable) where T : struct, IComparable, IFormattable, IConvertible
        {
            this.WriteEnumArray<T>(name, value, nullable, 1);
        }

        /// <summary>
        /// Write enum array value.
        /// </summary>
        /// <typeparam name="T">Type of the entry of the array.</typeparam>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        public void WriteEnumArray<T>(string name, object value, bool nullable, uint rank) where T : struct, IComparable, IFormattable, IConvertible
        {
            this.WriteArray<T>(name, value, nullable, rank, this.Write<T>);
        }

        #endregion

        #region Helper methods
        /// <summary>
        /// Write an unsigned integer in variable-length 7 bit encoding.
        /// </summary>
        /// <param name="value">The value to write.</param>
        private void WriteVInt(ulong value)
        {
            do
            {
                byte b = (byte)(value & 0x7f);
                value >>= 7;
                b |= (byte)(value == 0 ? 0 : 0x80);
                this.Write(null, b);
            }
            while (value != 0);
        }

        /// <summary>
        /// Write an array.
        /// </summary>
        /// <typeparam name="T">Array element type.</typeparam>
        /// <param name="name">Array name.</param>
        /// <param name="value">The array to write.</param>
        /// <param name="nullable">if set to <c>true</c> [nullable].</param>
        /// <param name="rank">The rank (dimension) of array.</param>
        /// <param name="elementWriter">A callback function that writes the primitive type elements.
        /// If this is null, the elements will be written as object using function void Write(string name, bool nullable, ISerializable value).</param>
        private void WriteArray<T>(string name, object value, bool nullable, uint rank, ElementWriter<T> elementWriter)
        {
            if (rank == 0)
            {
                throw new ArgumentException("rank");
            }

            this.WriteNullableFlag(value, nullable);
            if (value == null)
            {
                return;
            }

            if (rank == 1)
            {
                var arr = value as ICollection<T>;
                if (arr == null)
                {
                    throw new TeslaSerializationException("A non-sequence value is serialized as array. Sequence type must implement ICollection and ICollection<T>. The actual type is " + value.GetType().FullName + " T: " + typeof(T).FullName + ", rank: 1");
                }

                // Write number of elements.
                this.WriteVInt((ulong)arr.Count);

                if (elementWriter == null)
                {
                    // Write object elements.
                    foreach (var element in arr)
                    {
                        if (element is ISerializable)
                        {
                            Write(null, (ISerializable)element, false);
                        }
                        else
                        {
                            throw new TeslaSerializationException("An object that doesn't implement ISerializable was found in array.");
                        }
                    }
                }
                else
                {
                    // Write primitive type elements.
                    foreach (var element in arr)
                    {
                        elementWriter(null, element);
                    }
                }
            }
            else
            {
                // Multiple dimensional arrays.
                var arr = value as ICollection;
                if (arr == null)
                {
                    throw new TeslaSerializationException("A non-sequence value is serialized as multiple dimensional array. Sequence type must implement ICollection and ICollection<T>");
                }

                // Write number of elements.
                this.WriteVInt((ulong)arr.Count);

                foreach (var subArr in arr)
                {
                    this.WriteArray(null, subArr, false, rank - 1, elementWriter);
                }
            }
        }
        
        /// <summary>
        /// Write a binary value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        private void Write(string name, byte[] value)
        {
            this.Write(name, value, false);
        }

        /// <summary>
        /// Write a string value.
        /// </summary>
        /// <param name="name">Name of member.</param>
        /// <param name="value">Value of member.</param>
        private void Write(string name, string value)
        {
            this.Write(name, value, false);
        }

        /// <summary>
        /// Write a bool value that indicates if a member is null. This is only done on nullable members. If nullable is true, 
        /// this function do nothing.
        /// </summary>
        /// <param name="value">The member value.</param>
        /// <param name="nullable">If this memeber nullable.</param>
        private void WriteNullableFlag(object value, bool nullable)
        {
            if (nullable)
            {
                this.Write(null, value == null);
            }
            else if (value == null)
            {
                throw new TeslaSerializationException("Null value was written as a non-nullable member.");
            }
        }
        #endregion
    }
}
