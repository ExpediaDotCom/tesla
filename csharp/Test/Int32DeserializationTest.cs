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
    /// This is a test class for Int32DeserializationTest and is intended
    /// to contain all Int32DeserializationTest Unit Tests.
    /// </summary>
    [TestClass]
    public class Int32DeserializationTest
    {
        /// <summary>
        /// Read Int32 values.
        /// </summary>
        [TestMethod]
        public void ReadInt32Test()
        {
            // Test value    Encoded As     Encoded Bytes 
            //        -2         3          00000011
            // 2147483647    4294967294     11111110 11111111 11111111 11111111 00001111
            // -2147483648   4294967295     11111111 11111111 11111111 11111111 00001111 
            byte[] buffer = 
                { 
                    0x03,
                    0xFE, 0xFF, 0xFF, 0xFF, 0x0F,
                    0xFF, 0xFF, 0xFF, 0xFF, 0x0F,
                };

            BinaryReader reader = new BinaryReader(buffer, DeserializationHelper.CannedVersion);
            string name = string.Empty;
            int actual;
            int expected = -2;
            actual = reader.ReadInt32(name);
            Assert.AreEqual(expected, actual);

            expected = 2147483647;
            actual = reader.ReadInt32(name);
            Assert.AreEqual(expected, actual);

            expected = -2147483648;
            actual = reader.ReadInt32(name);
            Assert.AreEqual(expected, actual);
        }

        /// <summary>
        /// Reads a too small Int32 value.
        /// </summary>
        [TestMethod]
        public void ReadTooSmallInt32Test()
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .Int64(long.MinValue)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadInt32(string.Empty);
                },
                "Bad format Int32 value. The value was read is outside the range of the Int32.");
        }

        /// <summary>
        /// Reads a too large Int32 value.
        /// </summary>
        [TestMethod]
        public void ReadTooLargeInt32Test()
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .Int64(long.MaxValue)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadInt32(string.Empty);
                },
                "Bad format Int32 value. The value was read is outside the range of the Int32.");
        }

        /// <summary>
        /// Read a 1D array of ints.
        /// </summary>
        [TestMethod]
        public void ReadInt321DArrayTest()
        {
            List<int> values = new List<int>() { int.MaxValue, 10000, 0, -1000, 100, int.MinValue };

            DeserializationHelper.Array1DHelper<int>(values);
        }

        /// <summary>
        /// Read a 2D array of ints.
        /// </summary>
        [TestMethod]
        public void ReadInt322DArrayTest()
        {
            List<List<int>> values = new List<List<int>>() 
                { 
                    new List<int>() { int.MaxValue, 10000, 0, -1000, 100, int.MinValue }, 
                    new List<int>() { 0x00, 0xFD, -12 },
                };

            DeserializationHelper.Array2DHelper<int>(values);
        }

        /// <summary>
        /// Read a 3D array of ints.
        /// </summary>
        [TestMethod]
        public void ReadInt323DArrayTest()
        {
            List<List<List<int>>> values = new List<List<List<int>>>() 
                { 
                    new List<List<int>>() 
                    {
                    new List<int>() { int.MaxValue, 10000, 0, -1000, 100, int.MinValue }, 
                    new List<int>() { 0x00, 0xFD, -12 },
                    },
                    new List<List<int>>() 
                    {
                        new List<int>() { 0x02, 0x13, -29 }, 
                    },
                };

            DeserializationHelper.Array3DHelper<int>(values);
        }

        /// <summary>
        /// Read a 4D array of ints.
        /// </summary>
        [TestMethod]
        public void ReadInt324DArrayTest()
        {
            List<List<List<List<int>>>> values = new List<List<List<List<int>>>>() 
                { 
                    new List<List<List<int>>>() 
                    {
                        new List<List<int>>() 
                        {
                    new List<int>() { int.MaxValue, 10000, 0, -1000, 100, int.MinValue }, 
                    new List<int>() { 0x00, 0xFD, -12 },
                        },
                        new List<List<int>>() 
                        {
                            new List<int>() { 0x02, 0x13, 0x29 }, 
                        },
                    },
                    new List<List<List<int>>>() 
                    {
                        new List<List<int>>() 
                        {
                        new List<int>() { 0x02, 0x13, -29 }, 
                        },
                    },
                };

            DeserializationHelper.Array4DHelper<int>(values);
        }

        /// <summary>
        /// Read an empty Int32 array.
        /// </summary>
        [TestMethod]
        public void ReadEmptyInt32Array()
        {
            DeserializationHelper.EmptyArrayHelper<int>();
        }
    }    
}
