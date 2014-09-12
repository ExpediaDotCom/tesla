namespace TeslaTest
{
    using System;
    using System.Collections;
    using System.Collections.Generic;
    using System.Text;

    /// <summary>
    /// Builds a Tesla serialized stream for testing purposes.
    /// </summary>
    public class SerializedStreamBuilder
    {
        /// <summary>
        /// Memory stream used to back the serialized stream.
        /// </summary>
        private System.IO.MemoryStream stream;
        
        /// <summary>
        /// Initializes a new instance of the <see cref="SerializedStreamBuilder"/> class.
        /// </summary>
        public SerializedStreamBuilder()
        {
            this.stream = new System.IO.MemoryStream();
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="SerializedStreamBuilder"/> class. This is
        /// the copy constructor used during building of the object.
        /// </summary>
        /// <param name="otherBuilder">The other builder.</param>
        private SerializedStreamBuilder(SerializedStreamBuilder otherBuilder)
        {
            this.stream = otherBuilder.stream;
        }

        /// <summary>
        /// Append binary-typed data to the stream.
        /// </summary>
        /// <param name="data">The data.</param>
        /// <returns>The serialized stream builder.</returns>
        public SerializedStreamBuilder Binary(byte[] data)
        {
            return this
                .Size((ulong)data.Length)
                .RawBytes(data);
        }

        /// <summary>
        /// Append size information of forthcoming data to the stream.
        /// </summary>
        /// <param name="size">The size.</param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        public SerializedStreamBuilder Size(ulong size)
        {
            return this.VarInt(size);
        }

        /// <summary>
        /// Append information if the forthcoming data is null or not to the stream.
        /// </summary>
        /// <param name="isNull">If set to <c>true</c> [is null].</param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        public SerializedStreamBuilder NullableFlag(bool isNull)
        {
            this.Boolean(isNull);

            return this;
        }

        /// <summary>
        /// Append string-typed data to the stream.
        /// </summary>
        /// <param name="value">The value.</param>
        /// <param name="isNull">
        /// If set to null, it is not nullable. If set to true, it is null and if set to false it is nullable but not null.
        /// </param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        public SerializedStreamBuilder String(string value, bool? isNull)
        {
            if (isNull.HasValue)
            {
                this.NullableFlag(isNull.Value);

                if (value == null)
                {
                    return this;
                }
            }

            this.Size((ulong)value.Length);

            foreach (byte byteValue in Encoding.UTF8.GetBytes(value))
            {
                this.stream.WriteByte(byteValue);
            }
            
            return this;
        }

        /// <summary>
        /// Append enum-typed data to the stream.
        /// </summary>
        /// <param name="value">The value.</param>
        /// </param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        public SerializedStreamBuilder Enum(Enum value)
        {
            int enumValue = (int)(ValueType)value;
            return this.Int32(enumValue);
        }

        /// <summary>
        /// Append raw bytes to the stream.
        /// </summary>
        /// <param name="bytes">The bytes.</param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        public SerializedStreamBuilder RawBytes(ICollection<byte> bytes)
        {
            foreach (byte value in bytes)
            {
                this.stream.WriteByte(value);
            }

            return this;
        }

        /// <summary>
        /// Append a raw byte to the stream.
        /// </summary>
        /// <param name="value">The value.</param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        public SerializedStreamBuilder RawByte(byte value)
        {
            return this.RawByte(value, 1);
        }

        /// <summary>
        /// Appends a raw byte n-times to the stream.
        /// </summary>
        /// <param name="value">The value.</param>
        /// <param name="repeat">The number of times it should be appended.</param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        public SerializedStreamBuilder RawByte(byte value, ulong repeat)
        {
            for (ulong i = 0; i < repeat; i++)
            {
                this.stream.WriteByte(value);
            }

            return this;
        }

        /// <summary>
        /// Append double-typed data to the stream.
        /// </summary>
        /// <param name="value">The value.</param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        public SerializedStreamBuilder Double(double value)
        {
            byte[] byteValues = BitConverter.GetBytes(value);

            if (!BitConverter.IsLittleEndian)
            {
                System.Array.Reverse(byteValues);
            }

            this.RawBytes(byteValues);

            return this;
        }

        /// <summary>
        /// Append float-typed data to the stream.
        /// </summary>
        /// <param name="value">The value.</param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        public SerializedStreamBuilder Float(float value)
        {
            byte[] byteValues = BitConverter.GetBytes(value);

            if (!BitConverter.IsLittleEndian)
            {
                System.Array.Reverse(byteValues);
            }

            this.RawBytes(byteValues);

            return this;
        }

        /// <summary>
        /// Append boolean-typed data to the stream.
        /// </summary>
        /// <param name="value">The value.</param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        public SerializedStreamBuilder Boolean(bool value)
        {
            this.RawByte((byte)(value ? 0xD : 0x5));

            return this;
        }

        /// <summary>
        /// Append Int16-typed data to the stream.
        /// </summary>
        /// <param name="value">The value.</param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        public SerializedStreamBuilder Int16(short value)
        {
            this.ZigZag(value);

            return this;
        }

        /// <summary>
        /// Append Int32-typed data to the stream.
        /// </summary>
        /// <param name="value">The value.</param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        public SerializedStreamBuilder Int32(int value)
        {
            this.ZigZag(value);

            return this;
        }

        /// <summary>
        /// Append Int64-typed data to the stream.
        /// </summary>
        /// <param name="value">The value.</param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        public SerializedStreamBuilder Int64(long value)
        {
            this.ZigZag(value);

            return this;
        }

        /// <summary>
        /// Append UInt16-typed data to the stream.
        /// </summary>
        /// <param name="value">The value.</param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        public SerializedStreamBuilder UInt16(ushort value)
        {
            this.VarInt(value);

            return this;
        }

        /// <summary>
        /// Append UInt32-typed data to the stream.
        /// </summary>
        /// <param name="value">The value.</param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        public SerializedStreamBuilder UInt32(uint value)
        {
            this.VarInt(value);

            return this;
        }

        /// <summary>
        /// Append UInt64-typed data to the stream.
        /// </summary>
        /// <param name="value">The value.</param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        public SerializedStreamBuilder UInt64(ulong value)
        {
            this.VarInt(value);

            return this;
        }

        /// <summary>
        /// Append an array of values to the stream.
        /// </summary>
        /// <typeparam name="T">Type of the underlying value of the array.</typeparam>
        /// <param name="values">The values.</param>
        /// <param name="nullable">If set to <c>true</c> [nullable].</param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        public SerializedStreamBuilder Array<T>(ICollection values, bool nullable)
        {
            if (nullable)
            {
                this.NullableFlag(values == null);

                if (values == null)
                {
                    return this;
                }
            }

            return this.SubArray<T>(values, nullable);
        }

        /// <summary>
        /// Generates a <see cref="System.IO.Stream"/> from the builder contents.
        /// </summary>
        /// <returns>Stream object.</returns>
        public System.IO.Stream ToStream()
        {
            this.RewindStreamToBeginning();

            return this.stream;
        }

        /// <summary>
        /// Generates a <see cref="byte[]"/> from the builder contents.
        /// </summary>
        /// <returns>Byte array.</returns>
        public byte[] ToArray()
        {
            this.RewindStreamToBeginning();

            return this.stream.ToArray();
        }

        /// <summary>
        /// Encodes the value using zig-zag.
        /// </summary>
        /// <param name="value">The value.</param>
        private void ZigZag(long value)
        {
            this.VarInt((ulong)((value << 1) ^ (value >> 63)));
        }

        /// <summary>
        /// Encodes the value using zig-zag.
        /// </summary>
        /// <param name="value">The value.</param>
        private void ZigZag(int value)
        {
            this.VarInt((uint)((value << 1) ^ (value >> 31)));
        }

        /// <summary>
        /// Encodes the value using zig-zag.
        /// </summary>
        /// <param name="value">The value.</param>
        private void ZigZag(short value)
        {
            this.VarInt((ushort)((value << 1) ^ (value >> 15)));
        }

        /// <summary>
        /// Encodes the value as a variable int.
        /// </summary>
        /// <param name="value">The value.</param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        private SerializedStreamBuilder VarInt(ulong value)
        {
            if ((value & 0xFFFFFF80) == 0)
            {
                this.stream.WriteByte((byte)(value & 0xFF));

                return this;
            }

            this.stream.WriteByte((byte)(0x80 | (value & 0x7F)));

            return this.VarInt(value >> 7);
        }

        /// <summary>
        /// Handles serializing a sub-array.
        /// </summary>
        /// <typeparam name="T">Underlying type of the array.</typeparam>
        /// <param name="values">The values.</param>
        /// <param name="nullable">If set to <c>true</c> [nullable].</param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        private SerializedStreamBuilder SubArray<T>(ICollection values, bool nullable)
        {
            ICollection<T> array = values as ICollection<T>;

            if (array != null)
            {
                return this.BaseArray(values, false);
            }

            if (values != null)
            {
                this.Size((ulong)values.Count);

                foreach (ICollection value in values)
                {
                    this.SubArray<T>(value, false);
                }
            }

            return this;
        }

        /// <summary>
        /// Handles the base array (rank = 0) serialization case.
        /// </summary>
        /// <typeparam name="T">Underlying type of the array.</typeparam>
        /// <param name="values">The values.</param>
        /// <param name="nullable">If set to <c>true</c> [nullable].</param>
        /// <returns>
        /// The serialized stream builder.
        /// </returns>
        private SerializedStreamBuilder BaseArray(ICollection values, bool nullable)
        {
            this.Size((byte)values.Count);

            foreach (object obj in values)
            {
                if (obj == null)
                {
                    if (nullable)
                    {
                        this.NullableFlag(true);
                    }
                    else
                    {
                        throw new InvalidOperationException("We don't expect to have a null for non-nullable during testing.");
                    }

                    continue;
                }

                if (obj.GetType().IsEnum)
                {
                    this.Enum((Enum)obj);
                }
                else
                {
                    switch (obj.GetType().ToString())
                    {
                        case "System.Byte":

                            this.RawByte((byte)obj);
                            break;

                        case "System.Byte[]":

                            this.Binary((byte[])obj);
                            break;

                        case "System.Int16":

                            this.Int16((short)obj);
                            break;

                        case "System.Int32":

                            this.Int32((int)obj);
                            break;

                        case "System.Int64":

                            this.Int64((long)obj);
                            break;

                        case "System.UInt16":

                            this.UInt16((ushort)obj);
                            break;

                        case "System.UInt32":

                            this.UInt32((uint)obj);
                            break;

                        case "System.UInt64":

                            this.UInt64((ulong)obj);
                            break;

                        case "System.Boolean":

                            this.Boolean((bool)obj);
                            break;

                        case "System.Single":

                            this.Float((float)obj);
                            break;

                        case "System.Double":

                            this.Double((double)obj);
                            break;

                        case "System.String":

                            if (nullable)
                            {
                                this.String((string)obj, false);
                            }
                            else
                            {
                                this.String((string)obj, null);
                            }

                            break;

                        default:

                            throw new NotImplementedException();
                    }
                }
            }

            return this;
        }

        /// <summary>
        /// Rewinds the stream to beginning.
        /// </summary>
        private void RewindStreamToBeginning()
        {
            this.stream.Seek(0L, System.IO.SeekOrigin.Begin);
        }
    }
}
