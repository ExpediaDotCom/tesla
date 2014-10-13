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
    /// This is a test class for UInt32DeserializationTest and is intended
    /// to contain all UInt32DeserializationTest Unit Tests.
    /// </summary>
    [TestClass]
    public class UInt32DeserializationTest
    {
        /// <summary>
        /// Read UInt32 values.
        /// </summary>
        [TestMethod]
        public void ReadUInt32Test()
        {
            // Test value        Encoded Bytes 
            //       130         10000010 00000001
            //      16385        10000001 10000000 00000001
            byte[] buffer = { 0x82, 0x01, 0x81, 0x80, 0x01 };
            BinaryReader reader = new BinaryReader(buffer, DeserializationHelper.CannedVersion);
            string name = string.Empty;

            uint actual;
            actual = reader.ReadUInt32(name);
            Assert.AreEqual((uint)130, actual);

            actual = reader.ReadUInt32(name);
            Assert.AreEqual((uint)16385, actual);
        }

        /// <summary>
        /// Reads a too small UInt32 value.
        /// </summary>
        [TestMethod]
        public void ReadTooSmallUInt32Test()
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .Int64(long.MinValue)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    uint foo = reader.ReadUInt32(string.Empty);
                },
                "Bad format UInt32 value. The value was read is outside the range of the UInt32.");
        }

        /// <summary>
        /// Reads a too large UInt32 value.
        /// </summary>
        [TestMethod]
        public void ReadTooLargeUInt32Test()
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .Int64(long.MaxValue)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadUInt32(string.Empty);
                },
                "Bad format UInt32 value. The value was read is outside the range of the UInt32.");
        }

        /// <summary>
        /// Read a 1D array of uints.
        /// </summary>
        [TestMethod]
        public void ReadUInt321DArrayTest()
        {
            List<uint> values = new List<uint>() { 55, 123, 0, uint.MinValue, 5, uint.MaxValue };

            DeserializationHelper.Array1DHelper<uint>(values);
        }

        /// <summary>
        /// Read a 2D array of uints.
        /// </summary>
        [TestMethod]
        public void ReadUInt322DArrayTest()
        {
            List<List<uint>> values = new List<List<uint>>() 
                { 
                    new List<uint>() { 55, 123, 0, uint.MinValue, 5, uint.MaxValue }, 
                    new List<uint>() { 0x00, uint.MinValue, 0x98 },
                };

            DeserializationHelper.Array2DHelper<uint>(values);
        }

        /// <summary>
        /// Read a 3D array of uints.
        /// </summary>
        [TestMethod]
        public void ReadUInt323DArrayTest()
        {
            List<List<List<uint>>> values = new List<List<List<uint>>>() 
                { 
                    new List<List<uint>>() 
                    {
                        new List<uint>() { 55, 123, 0, uint.MinValue, 5, uint.MaxValue }, 
                        new List<uint>() { 0x00, uint.MinValue, 0x98 },
                    },
                    new List<List<uint>>() 
                    {
                        new List<uint>() { 0x02, uint.MinValue, 0x29 }, 
                    },
                };

            DeserializationHelper.Array3DHelper<uint>(values);
        }

        /// <summary>
        /// Read a 4D array of uints.
        /// </summary>
        [TestMethod]
        public void ReadUInt324DArrayTest()
        {
            List<List<List<List<uint>>>> values = new List<List<List<List<uint>>>>() 
                { 
                    new List<List<List<uint>>>() 
                    {
                        new List<List<uint>>() 
                        {
                            new List<uint>() { 55, 123, 0, uint.MinValue, 5, uint.MaxValue }, 
                            new List<uint>() { 0x00, uint.MinValue, 0x98 },
                        },
                        new List<List<uint>>() 
                        {
                            new List<uint>() { 0x02, uint.MinValue, 0x29 }, 
                        },
                    },
                    new List<List<List<uint>>>() 
                    {
                        new List<List<uint>>() 
                        {
                            new List<uint>() { 0x12, 0x23 }, 
                        },
                    },
                };

            DeserializationHelper.Array4DHelper<uint>(values);
        }

        /// <summary>
        /// Read an empty UInt32 array.
        /// </summary>
        [TestMethod]
        public void ReadEmptyUInt32Array()
        {
            DeserializationHelper.EmptyArrayHelper<uint>();
        }
    }    
}
