//--------------------------------------------------------------------------------------------------
// <copyright file="BinaryReader.cs" company="Expedia">
//        Copyright (c) 2013 Expedia Inc.  All rights reserved.
// </copyright>
// <summary>
//        Tesla serialization library binary encoding reader.
// </summary>
//--------------------------------------------------------------------------------------------------
namespace Expedia.Tesla.Serialization
{
    using System;
    using System.Linq;
    using System.Collections.Generic;
    using Expedia.Tesla.Schema;

    /// <summary>
    /// Binary encoding reader.
    /// </summary>
    public class BinaryReader : SchemaVersion, ITeslaReader
    {
        /// <summary>
        /// Out of buffer range error message.
        /// </summary>
        private readonly string endOfStreamErrorMsg = "The end of the stream is reached during deserialization.";

        /// <summary>
        /// Common error message.
        /// </summary>
        private readonly string ioErrorMsg = "An IO error happened during deserialization.";

        /// <summary>
        /// Stream closed error message.
        /// </summary>
        private readonly string streamClosedErrorMsg = "Stream was closed during deserialization.";

        /// <summary>
        /// Corrupt stream error message.
        /// </summary>
        private readonly string corruptStreamErrorMsg = "Invalid data was encountered in the stream. The stream is corrupted.";

        /// <summary>
        /// Invalid Enum Argument error message.
        /// </summary>
        private readonly string argumentInvalidEnumErrorMsg = "Non-Enum Type data encountered in the stream.";

        /// <summary>
        /// Argument out of bounds error message.
        /// </summary>
        private readonly string argumentOverflowErrorMsg = "Data out of bounds was encountered in the stream.";

        /// <summary>
        /// Internal raw binary reader.
        /// </summary>
        private System.IO.BinaryReader internalReader;

        /// <summary>
        /// Initializes a new instance of the BinaryReader class.
        /// </summary>
        /// <param name="input">The input stream.</param>
        /// <param name="version">The version.</param>
        public BinaryReader(System.IO.Stream input, SchemaVersion version)
            : base(version)
        {
            this.internalReader = new System.IO.BinaryReader(input);
            this.Version = version;
        }

        /// <summary>
        /// Initializes a new instance of the BinaryReader class.
        /// </summary>
        /// <param name="buffer">The input buffer.</param>
        /// <param name="version">The version.</param>
        public BinaryReader(byte[] buffer, SchemaVersion version)
            : this(new System.IO.MemoryStream(buffer), version)
        {
        }

        /// <summary>
        /// Element reader delegate, ReadArray needs a method to read array elements.
        /// </summary>
        /// <typeparam name="T">Element type.</typeparam>
        /// <param name="name">Element name.</param>
        /// <returns>Element value that was read.</returns>
        private delegate T ElementReader<T>(string name);

        /// <summary>
        /// Gets the schema version of the serialized data that is reading.
        /// </summary>
        public SchemaVersion Version { get; private set; }

        /// <summary>
        /// Read a single byte.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>
        /// The value of current member.
        /// </returns>
        public byte ReadByte(string name)
        {
            try
            {
                return this.internalReader.ReadByte();
            }
            catch (System.IO.EndOfStreamException ex)
            {
                throw new TeslaDeserializationException(this.endOfStreamErrorMsg, ex);
            }
            catch (System.IO.IOException ex)
            {
                throw new TeslaDeserializationException(this.ioErrorMsg, ex);
            }
            catch (System.ObjectDisposedException ex)
            {
                throw new TeslaDeserializationException(this.streamClosedErrorMsg, ex);
            }
        }

        /// <summary>
        /// Read a 16-bit integer value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>The value of current member.</returns>
        public short ReadInt16(string name)
        {
            try
            {
                return Convert.ToInt16(this.ReadZigZag());
            }
            catch (OverflowException ex)
            {
                throw new TeslaDeserializationException("Bad format Int16 value. The value was read is outside the range of the Int16.", ex);
            }
        }

        /// <summary>
        /// Read a 32-bit integer value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>The value of current member.</returns>
        public int ReadInt32(string name)
        {
            try
            {
                return Convert.ToInt32(this.ReadZigZag());
            }
            catch (System.OverflowException ex)
            {
                throw new TeslaDeserializationException("Bad format Int32 value. The value was read is outside the range of the Int32.", ex);
            }
        }

        /// <summary>
        /// Read a 64-bit integer value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>The value of current member.</returns>
        public long ReadInt64(string name)
        {
            return this.ReadZigZag();
        }

        /// <summary>
        /// Read a 16-bit unsigned integer value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>The value of current member.</returns>
        public ushort ReadUInt16(string name)
        {
            try
            {
                return Convert.ToUInt16(this.ReadVInt());
            }
            catch (System.OverflowException ex)
            {
                throw new TeslaDeserializationException("Bad format UInt16 value. The value was read is outside the range of the UInt16.", ex);
            }
        }

        /// <summary>
        /// Read a 32-bit unsigned integer value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>The value of current member.</returns>
        public uint ReadUInt32(string name)
        {
            try
            {
                return Convert.ToUInt32(this.ReadVInt());
            }
            catch (System.OverflowException ex)
            {
                throw new TeslaDeserializationException("Bad format UInt32 value. The value was read is outside the range of the UInt32.", ex);
            }
        }

        /// <summary>
        /// Read a 64-bit unsigned integer value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>The value of current member.</returns>
        public ulong ReadUInt64(string name)
        {
            return this.ReadVInt();
        }

        /// <summary>
        /// Read a boolean value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>The value of current member.</returns>
        public bool ReadBoolean(string name)
        {
            var b = this.ReadByte(null);

            switch (b)
            {
                case TeslaConstants.BinaryEncodedBooleanFalse:
                    return false;
            
                case TeslaConstants.BinaryEncodedBooleanTrue:
                    return true;
            
                default:
                    throw new TeslaDeserializationException(string.Format("Invalid boolean value: {0}.", b));
            }
        }

        /// <summary>
        /// Read a float value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>The value of current member.</returns>
        public float ReadFloat(string name)
        {
            try
            {
                return this.internalReader.ReadSingle();
            }
            catch (System.IO.EndOfStreamException ex)
            {
                throw new TeslaDeserializationException(this.endOfStreamErrorMsg, ex);
            }
            catch (System.IO.IOException ex)
            {
                throw new TeslaDeserializationException(this.ioErrorMsg, ex);
            }
            catch (System.ObjectDisposedException ex)
            {
                throw new TeslaDeserializationException(this.streamClosedErrorMsg, ex);
            }
        }

        /// <summary>
        /// Read a float value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>The value of current member.</returns>
        public double ReadDouble(string name)
        {
            try
            {
                return this.internalReader.ReadDouble();
            }
            catch (System.IO.EndOfStreamException ex)
            {
                throw new TeslaDeserializationException(this.endOfStreamErrorMsg, ex);
            }
            catch (System.IO.IOException ex)
            {
                throw new TeslaDeserializationException(this.ioErrorMsg, ex);
            }
            catch (System.ObjectDisposedException ex)
            {
                throw new TeslaDeserializationException(this.streamClosedErrorMsg, ex);
            }
        }

        /// <summary>
        /// Read a string value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <returns>The value of current member.</returns>
        public string ReadString(string name, bool nullable)
        {
            if (nullable && this.ReadBoolean(null))
            {
                return null;
            }

            try
            {
                return this.internalReader.ReadString();
            }
            catch (System.FormatException ex)
            {
                throw new TeslaDeserializationException(this.corruptStreamErrorMsg, ex);
            }
            catch (System.IO.EndOfStreamException ex)
            {
                throw new TeslaDeserializationException(this.endOfStreamErrorMsg, ex);
            }
            catch (System.IO.IOException ex)
            {
                throw new TeslaDeserializationException(this.ioErrorMsg, ex);
            }
            catch (System.ObjectDisposedException ex)
            {
                throw new TeslaDeserializationException(this.streamClosedErrorMsg, ex);
            }
        }

        /// <summary>
        /// Read a binary value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <returns>The value of current member.</returns>
        public byte[] ReadBinary(string name, bool nullable)
        {
            if (nullable && this.ReadBoolean(null))
            {
                return null;
            }

            try
            {
                ulong size = this.ReadVInt();
                return this.internalReader.ReadBytes((int)size);
            }
            catch (System.IO.EndOfStreamException ex)
            {
                throw new TeslaDeserializationException(this.endOfStreamErrorMsg, ex);
            }
            catch (System.IO.IOException ex)
            {
                throw new TeslaDeserializationException(this.ioErrorMsg, ex);
            }
            catch (System.ObjectDisposedException ex)
            {
                throw new TeslaDeserializationException(this.streamClosedErrorMsg, ex);
            }
            catch (System.ArgumentOutOfRangeException ex)
            {
                throw new TeslaDeserializationException(this.corruptStreamErrorMsg, ex);
            }
        }

        /// <summary>
        /// Read a object field value.
        /// </summary>
        /// <typeparam name="T">Type of element.</typeparam>
        /// <param name="name">Name of the member.</param>
        /// <param name="nullable">If this field can be null.</param>
        /// <returns>The value of current member.</returns>
        public T ReadObject<T>(string name, bool nullable) where T : class, ISerializable, new()
        {
            if (nullable && this.ReadBoolean(null))
            {
                return null;
            }

            T v = new T();
            ISerializable o = v;
            o.Deserialize(this);

            return v;
        }

        /// <summary>
        /// Read a enum value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <returns>
        /// The value of current member.
        /// </returns>
        public T ReadEnum<T>(string name) where T : struct, IComparable, IFormattable, IConvertible
        {
            try
            {               
                int enumIntValue = this.ReadInt32(name);

                /*
                 * Do not use IsDefined Per http://msdn.microsoft.com/en-us/library/ms229025(VS.90).aspx, 
                 */ 
                //if (Enum.IsDefined(typeof(T), enumIntValue)) 

                /*
                 * Caution : Exception will NOT be raised here, instead the out of bound value will simply be returned
                 * It may cause an error in the calling App.
                 */ 
                T enumValue = (T)Enum.ToObject(typeof(T), enumIntValue);

                /*
                 * Instead perform a manual check and raise an exception
                 * This could introduce a slight latency due to the additional check.
                 */ 
                var isValidEnum = Enum.GetValues(typeof(T)).Cast<T>().Contains(enumValue);
                if (!isValidEnum)
                {
                    throw new TeslaDeserializationException(this.argumentInvalidEnumErrorMsg);
                }

                return enumValue;
            }
            catch (System.ArgumentException ex)
            {
                throw new TeslaDeserializationException(this.argumentInvalidEnumErrorMsg, ex);
            }
            catch (System.OverflowException ex)
            {
                throw new TeslaDeserializationException(this.argumentOverflowErrorMsg, ex);
            }                
            catch (System.FormatException ex)
            {
                throw new TeslaDeserializationException(this.corruptStreamErrorMsg, ex);
            }
            catch (System.IO.EndOfStreamException ex)
            {
                throw new TeslaDeserializationException(this.endOfStreamErrorMsg, ex);
            }
            catch (System.IO.IOException ex)
            {
                throw new TeslaDeserializationException(this.ioErrorMsg, ex);
            }
            catch (System.ObjectDisposedException ex)
            {
                throw new TeslaDeserializationException(this.streamClosedErrorMsg, ex);
            }
        }

        /// <summary>
        /// Read a byte array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        /// <returns>
        /// A List &lt; byte &gt; value of the array.
        /// </returns>
        public object ReadByteArray(string name, bool nullable, uint rank)
        {
            return ReadArray<byte>(name, nullable, rank, this.ReadByte);
        }

        /// <summary>
        /// Read a 16-bit int array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        /// <returns>
        /// A List value of the array.
        /// </returns>
        public object ReadInt16Array(string name, bool nullable, uint rank)
        {
            return ReadArray<short>(name, nullable, rank, this.ReadInt16);
        }

        /// <summary>
        /// Read a 32-bit int array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        /// <returns>
        /// A List value of the array.
        /// </returns>
        public object ReadInt32Array(string name, bool nullable, uint rank)
        {
            return ReadArray<int>(name, nullable, rank, this.ReadInt32);
        }

        /// <summary>
        /// Read a 64-bit int array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        /// <returns>
        /// A List value of the array.
        /// </returns>
        public object ReadInt64Array(string name, bool nullable, uint rank)
        {
            return ReadArray<long>(name, nullable, rank, this.ReadInt64);
        }

        /// <summary>
        /// Read a 16-bit unsigned int array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank.</param>
        /// <returns>
        /// A List value of the array.
        /// </returns>
        public object ReadUInt16Array(string name, bool nullable, uint rank)
        {
            return ReadArray<ushort>(name, nullable, rank, this.ReadUInt16);
        }

        /// <summary>
        /// Read a 32-bit unsigned int array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank. </param>
        /// <returns>A List value of the array.</returns>
        public object ReadUInt32Array(string name, bool nullable, uint rank)
        {
            return ReadArray<uint>(name, nullable, rank, this.ReadUInt32);
        }

        /// <summary>
        /// Read a 64-bit unsigned int array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank. </param>
        /// <returns>A List value of the array.</returns>
        public object ReadUInt64Array(string name, bool nullable, uint rank)
        {
            return ReadArray<ulong>(name, nullable, rank, this.ReadUInt64);
        }

        /// <summary>
        /// Read a bool array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank. </param>
        /// <returns>A List value of the array.</returns>
        public object ReadBooleanArray(string name, bool nullable, uint rank)
        {
            return ReadArray<bool>(name, nullable, rank, this.ReadBoolean);
        }

        /// <summary>
        /// Read a float array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank. </param>
        /// <returns>A List value of the array.</returns>
        public object ReadFloatArray(string name, bool nullable, uint rank)
        {
            return ReadArray<float>(name, nullable, rank, this.ReadFloat);
        }

        /// <summary>
        /// Read a double array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank. </param>
        /// <returns>A List value of the array.</returns>
        public object ReadDoubleArray(string name, bool nullable, uint rank)
        {
            return ReadArray<double>(name, nullable, rank, this.ReadDouble);
        }

        /// <summary>
        /// Read a string array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank. </param>
        /// <returns>A List value of the array.</returns>
        public object ReadStringArray(string name, bool nullable, uint rank)
        {
            return ReadArray<string>(name, nullable, rank, this.ReadString);
        }

        /// <summary>
        /// Read a binary array.
        /// </summary>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank. </param>
        /// <returns>A List value of the array.</returns>
        public object ReadBinaryArray(string name, bool nullable, uint rank)
        {
            return ReadArray<byte[]>(name, nullable, rank, this.ReadBinary);
        }

        /// <summary>
        /// Read an object array.
        /// </summary>
        /// <typeparam name="T">Type of element.</typeparam>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank. </param>
        /// <returns>A List value of the array.</returns>
        public object ReadObjectArray<T>(string name, bool nullable, uint rank) where T : class, ISerializable, new()
        {
            return ReadArray<T>(name, nullable, rank, ReadObject<T>);
        }

        /// <summary>
        /// Read a enum array.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <returns>
        /// A List value of the array
        /// </returns>
        public object ReadEnumArray<T>(string name, bool nullable) where T : struct, IComparable, IFormattable, IConvertible
        {
            return ReadEnumArray<T>(name, nullable, 1);
        }
        
        /// <summary>
        /// Read an object array.
        /// </summary>
        /// <typeparam name="T">Type of element.</typeparam>
        /// <param name="name">Array name.</param>
        /// <param name="nullable">If this member can be null.</param>
        /// <param name="rank">Array rank. </param>
        /// <returns>A List value of the array.</returns>
        public object ReadEnumArray<T>(string name, bool nullable, uint rank) where T : struct, IComparable, IFormattable, IConvertible
        {           
            return ReadArray<T>(name, nullable, rank, ReadEnum<T>);
        }

        /// <summary>
        /// Read beginning of an object. Binary encoding doesn't have an object beginning format. 
        /// This function does nothing.
        /// </summary>
        /// <param name="name">Name of the object.</param>
        public void ReadObjectBegin(string name)
        {
        }

        /// <summary>
        /// Read end of an object. Binary encoding doesn't have an object ending format. 
        /// This function does nothing.
        /// </summary>
        /// <param name="name">Name of the object.</param>
        public void ReadObjectEnd(string name)
        {
        }

        /// <summary>
        /// Read a variable-length 7 bit encoded integer.
        /// </summary>
        /// <returns>Integer value was read.</returns>
        private ulong ReadVInt()
        {
            ulong value = 0;
            byte b = 0;
            byte offset = 0;
            do
            {
                if (offset >= 64)
                {
                    throw new TeslaDeserializationException("Bad format integer was encounted. The data may be corrupted.");
                }

                b = this.ReadByte(null);
                value |= ((ulong)b & 0x7f) << offset;
                offset += 7;
            }
            while ((b & 0x80) != 0);

            return value;
        }

        /// <summary>
        /// Read a variable-length zig-zag encoded integer value.
        /// </summary>
        /// <returns>Integer value was read.</returns>
        private long ReadZigZag()
        {
            ulong n = this.ReadVInt();
            return (long)(n >> 1) ^ -((long)n & 1);
        }

        /// <summary>
        /// Creat a List object for multi-dimensional array.
        /// To avoid the performance issue of Activator, Tesla library use new operator directly to
        /// create array list objects dynamically.
        /// </summary>
        /// <typeparam name="T">Type of element.</typeparam>
        /// <param name="rank">Array rank</param>
        /// <param name="capacity">The capacity.</param>
        /// <returns>
        /// The List object for multi-dimensional array.
        /// </returns>
        /// <remarks>
        /// To avoid the performance issue of Activator, this function uses new operator
        /// directly to create array list objects if the rank is smaller than 3. If the array rank
        /// is larger than 3, it uses reflection. This may affect the performance.
        /// </remarks>
        private object CreateArrayList<T>(uint rank, int capacity)
        {
            switch (rank)
            {
                case 1:
                    return new List<T>(capacity);
                case 2:
                    return new List<List<T>>(capacity);
                case 3:
                    return new List<List<List<T>>>(capacity);
                default:
                    Type type = typeof(T);
                    uint n = rank;
                    while (n-- > 0)
                    {
                        type = typeof(List<>).MakeGenericType(new Type[] { type });
                    }

                    return Activator.CreateInstance(type, new object[] { });
            }
        }

        /// <summary>
        /// Read an generic array. It use an element reader to read all array elements.
        /// </summary>
        /// <typeparam name="T">The element type.</typeparam>
        /// <param name="name">The name of array.</param>
        /// <param name="nullable">if set to <c>true</c> [nullable].</param>
        /// <param name="rank">Array rank.</param>
        /// <param name="elemReader">Element reader which was used to read elements.</param>
        /// <returns>
        /// A List of elements.
        /// </returns>
        private object ReadArray<T>(string name, bool nullable, uint rank, ElementReader<T> elemReader)
        {
            if (rank == 0)
            {
                throw new ArgumentException("rank");
            }

            if (nullable)
            {
                if (this.ReadBoolean(null))
                {
                    return null;
                }
            }

            ulong size = this.ReadVInt();
            if (size > int.MaxValue)
            {
                throw new TeslaDeserializationException(this.corruptStreamErrorMsg);
            }

            object value = this.CreateArrayList<T>(rank, (int)size);
            for (ulong i = 0; i < size; i++)
            {
                if (rank == 1)
                {
                    // T may be value type, use generic interface to avoid boxing/unboxing.
                    ((List<T>)value).Add(elemReader(null));
                }
                else
                {
                    ((System.Collections.IList)value).Add(this.ReadArray<T>(null, false, rank - 1, elemReader));
                }
            }

            return value;
        }
        
        /// <summary>
        /// Read a object field value.
        /// </summary>
        /// <typeparam name="T">Type of element.</typeparam>
        /// <param name="name">Name of the member.</param>
        /// <returns>The value of current member.</returns>
        private T ReadObject<T>(string name) where T : class, ISerializable, new()
        {
            return ReadObject<T>(name, false);
        }

        /// <summary>
        /// Read a string value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>The value of current member.</returns>
        private string ReadString(string name)
        {
            return this.ReadString(name, false);
        }
        
        /// <summary>
        /// Read a binary value.
        /// </summary>
        /// <param name="name">Name of the member.</param>
        /// <returns>The value of current member.</returns>
        private byte[] ReadBinary(string name)
        {
            return this.ReadBinary(name, false);
        }

    }
}
