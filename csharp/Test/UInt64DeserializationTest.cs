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
    /// This is a test class for UInt64DeserializationTest and is intended
    /// to contain all UInt64DeserializationTest Unit Tests.
    /// </summary>
    [TestClass]
    public class UInt64DeserializationTest
    {
        /// <summary>
        /// Read UInt64 values.
        /// </summary>
        [TestMethod]
        public void ReadUInt64Test()
        {
            // Test value        Encoded Bytes 
            //       130         10000010 00000001
            //      16385        10000001 10000000 00000001
            byte[] buffer = { 0x82, 0x01, 0x81, 0x80, 0x01 };
            BinaryReader reader = new BinaryReader(buffer, DeserializationHelper.CannedVersion);
            string name = string.Empty;

            ulong actual;
            actual = reader.ReadUInt64(name);
            Assert.AreEqual((ulong)130, actual);

            actual = reader.ReadUInt64(name);
            Assert.AreEqual((ulong)16385, actual);
        }

        /// <summary>
        /// Read a 1D array of ulongs.
        /// </summary>
        [TestMethod]
        public void ReadUInt641DArrayTest()
        {
            List<ulong> values = new List<ulong>() { 1000, 100, 0, ulong.MinValue, 666, ulong.MaxValue };

            DeserializationHelper.Array1DHelper<ulong>(values);
        }

        /// <summary>
        /// Read a 2D array of ulongs.
        /// </summary>
        [TestMethod]
        public void ReadUInt642DArrayTest()
        {
            List<List<ulong>> values = new List<List<ulong>>() 
                { 
                    new List<ulong>() { 1000, 100, 0, ulong.MinValue, 666, ulong.MaxValue }, 
                    new List<ulong>() { 0x00, ulong.MaxValue, 0x98 },
                };

            DeserializationHelper.Array2DHelper<ulong>(values);
        }

        /// <summary>
        /// Read a 3D array of ulongs.
        /// </summary>
        [TestMethod]
        public void ReadUInt643DArrayTest()
        {
            List<List<List<ulong>>> values = new List<List<List<ulong>>>() 
                { 
                    new List<List<ulong>>() 
                    {
                        new List<ulong>() { 1000, 100, 0, ulong.MinValue, 666, ulong.MaxValue }, 
                        new List<ulong>() { 0x00, ulong.MaxValue, 0x98 },
                    },
                    new List<List<ulong>>() 
                    {
                        new List<ulong>() { 0x02, 0x13, ulong.MaxValue }, 
                    },
                };

            DeserializationHelper.Array3DHelper<ulong>(values);
        }

        /// <summary>
        /// Read a 4D array of ulongs.
        /// </summary>
        [TestMethod]
        public void ReadUInt644DArrayTest()
        {
            List<List<List<List<ulong>>>> values = new List<List<List<List<ulong>>>>() 
                { 
                    new List<List<List<ulong>>>() 
                    {
                        new List<List<ulong>>() 
                        {
                            new List<ulong>() { 1000, 100, 0, ulong.MinValue, 666, ulong.MaxValue }, 
                            new List<ulong>() { 0x00, ulong.MaxValue, 0x98 },
                        },
                        new List<List<ulong>>() 
                        {
                            new List<ulong>() { 0x02, 0x13, ulong.MaxValue },
                        },
                    },
                    new List<List<List<ulong>>>() 
                    {
                        new List<List<ulong>>() 
                        {
                            new List<ulong>() { 0x12, 0x23 }, 
                        },
                    },
                };

            DeserializationHelper.Array4DHelper<ulong>(values);
        }

        /// <summary>
        /// Read an empty UInt64 array.
        /// </summary>
        [TestMethod]
        public void ReadEmptyUInt64Array()
        {
            DeserializationHelper.EmptyArrayHelper<ulong>();
        }
    }
}
