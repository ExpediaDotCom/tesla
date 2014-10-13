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
namespace TeslaTest
{
    using System.Collections.Generic;
    using Expedia.Tesla.Serialization;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    /// <summary>
    /// This is a test class for Int64DeserializationTest and is intended
    /// to contain all Int64DeserializationTest Unit Tests.
    /// </summary>
    [TestClass]
    public class Int64DeserializationTest
    {
        /// <summary>
        /// Read Int64 values.
        /// </summary>
        [TestMethod]
        public void ReadInt64Test()
        {
            // Test value    Encoded As     Encoded Bytes 
            //        -2         3          00000011
            // 2147483647    4294967294     11111110 11111111 11111111 11111111 00001111
            // -2147483648   4294967295     11111111 11111111 11111111 11111111 00001111 
            // INT64_MAX     0xFFFFFFFE     11111110 11111111 11111111 11111111 11111111 11111111 11111111 11111111 11111111 00000001
            // INT64_MIN     0xFFFFFFFF     11111111 11111111 11111111 11111111 11111111 11111111 11111111 11111111 11111111 00000001
            byte[] buffer = 
                { 
                    0x03,
                    0xFE, 0xFF, 0xFF, 0xFF, 0x0F,
                    0xFF, 0xFF, 0xFF, 0xFF, 0x0F,
                    0xFE, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x01,
                    0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x01 
                };

            BinaryReader reader = new BinaryReader(buffer, DeserializationHelper.CannedVersion);
            string name = string.Empty;
            long actual;
            long expected = -2;
            actual = reader.ReadInt64(name);
            Assert.AreEqual(expected, actual);

            expected = 2147483647;
            actual = reader.ReadInt64(name);
            Assert.AreEqual(expected, actual);

            expected = -2147483648;
            actual = reader.ReadInt64(name);
            Assert.AreEqual(expected, actual);

            expected = +9223372036854775807;
            actual = reader.ReadInt64(name);
            Assert.AreEqual(expected, actual);

            expected = -9223372036854775808;
            actual = reader.ReadInt64(name);
            Assert.AreEqual(expected, actual);
        }

        /// <summary>
        /// Read a too-large Int64 value.
        /// </summary>
        [TestMethod]
        public void ReadTooLargeInt64Test()
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .RawByte(0xFF, 10)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadInt64(string.Empty);
                },
                "Bad format integer was encounted. The data may be corrupted.");
        }

        /// <summary>
        /// Read an Int64 from an empty stream.
        /// </summary>
        [TestMethod]
        public void ReadEmptyInt64Test()
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                  () =>
                  {
                      reader.ReadInt64(string.Empty);
                  },
                  "The end of the stream is reached during deserialization.");
        }

        /// <summary>
        /// Read a 1D array of longs.
        /// </summary>
        [TestMethod]
        public void ReadInt641DArrayTest()
        {
            List<long> values = new List<long>() { 0, 50, -100, long.MinValue, -10000, long.MaxValue };

            DeserializationHelper.Array1DHelper<long>(values);
        }

        /// <summary>
        /// Read a 2D array of longs.
        /// </summary>
        [TestMethod]
        public void ReadInt642DArrayTest()
        {
            List<List<long>> values = new List<List<long>>() 
                { 
                    new List<long>() { 0, 50, -100, long.MinValue, -10000, long.MaxValue }, 
                    new List<long>() { 0x10, long.MinValue, 0x98 },
                };

            DeserializationHelper.Array2DHelper<long>(values);
        }

        /// <summary>
        /// Read a 3D array of longs.
        /// </summary>
        [TestMethod]
        public void ReadInt643DArrayTest()
        {
            List<List<List<long>>> values = new List<List<List<long>>>() 
                { 
                    new List<List<long>>() 
                    {
                        new List<long>() { 0, 50, -100, long.MinValue, -10000, long.MaxValue }, 
                        new List<long>() { 0x10, long.MinValue, 0x98 },
                    },
                    new List<List<long>>() 
                    {
                        new List<long>() { long.MinValue, 0x13, 0x29 }, 
                    },
                };

            DeserializationHelper.Array3DHelper<long>(values);
        }

        /// <summary>
        /// Read a 4D array of longs.
        /// </summary>
        [TestMethod]
        public void ReadInt644DArrayTest()
        {
            List<List<List<List<long>>>> values = new List<List<List<List<long>>>>() 
                { 
                    new List<List<List<long>>>() 
                    {
                        new List<List<long>>() 
                        {
                            new List<long>() { 0, 50, -100, long.MinValue, -10000, long.MaxValue }, 
                            new List<long>() { 0x10, long.MinValue, 0x98 },
                        },
                        new List<List<long>>() 
                        {
                            new List<long>() { long.MinValue, 0x13, 0x29 },
                        },
                    },
                    new List<List<List<long>>>() 
                    {
                        new List<List<long>>() 
                        {
                            new List<long>() { 0x12, 0x23 }, 
                        },
                    },
                };

            DeserializationHelper.Array4DHelper<long>(values);
        }

        /// <summary>
        /// Read an empty Int64 array.
        /// </summary>
        [TestMethod]
        public void ReadEmptyInt64Array()
        {
            DeserializationHelper.EmptyArrayHelper<long>();
        }
    }    
}
