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
    using System.Text;
    using Expedia.Tesla.Serialization;
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using System;

    /// <summary>
    /// This is a test class for EnumDeserializationTest and is intended
    /// to contain all EnumDeserializationTest Un   it Tests.
    /// </summary>
    [TestClass]
    public class EnumDeserializationTest
    {
        enum TestStatus { Late = 1, OnTime = 2, Early = 3 };
        enum TestEquality { LessThan = -1, EqualTo = 0, GreaterThan = 1 };

        /// <summary>
        /// Read two different enum values Enum values - Simple ones, with negative values as well.
        /// </summary>
        [TestMethod]
        public void BasicReadEnumTest()
        {
            // Test Enum               Test value    Encoded As     Encoded Bytes 
            // TestStatus.Late            1           2              00000010
            // TestStatus.OnTime          2           4              00000100
            // TestStatus.early           3           6              00000110 

            // TestEquality.LessThan      -1          1              00000001
            // TestEquality.EqualTo       0           0              00000000
            // TestEquality.GreaterThan   1           2              00000010 
            byte[] buffer = 
                { 
                    0x02,
                    0x04,
                    0x06,

                    0x01,
                    0x00,
                    0x02
                };

            BinaryReader reader = new BinaryReader(buffer, DeserializationHelper.CannedVersion);
            string name = string.Empty;
            TestStatus actual;

            TestStatus expected = TestStatus.Late;
            actual = reader.ReadEnum<TestStatus>(name);
            Assert.AreEqual(expected, actual);

            expected = TestStatus.OnTime;
            actual = reader.ReadEnum<TestStatus>(name);
            Assert.AreEqual(expected, actual);

            expected = TestStatus.Early;
            actual = reader.ReadEnum<TestStatus>(name);
            Assert.AreEqual(expected, actual);

            TestEquality actual1;
            TestEquality expected1 = TestEquality.LessThan;
            actual1 = reader.ReadEnum<TestEquality>(name);
            Assert.AreEqual(expected1, actual1);

            expected1 = TestEquality.EqualTo;
            actual1 = reader.ReadEnum<TestEquality>(name);
            Assert.AreEqual(expected1, actual1);

            expected1 = TestEquality.GreaterThan;
            actual1 = reader.ReadEnum<TestEquality>(name);
            Assert.AreEqual(expected1, actual1);
        }

        /// <summary>
        /// Read out of bounds enum values.
        /// </summary>
        [TestMethod]
        public void ReadOutofBoundsEnumTest()
        {
            // Test Enum      Test value    Encoded As     Encoded Bytes 
            // Invalid value    4            8              00001000 
            byte[] buffer = 
                { 
                    0x08
                };

            //Write an invalid value
            BinaryReader reader = new BinaryReader(buffer, DeserializationHelper.CannedVersion);
            string name = string.Empty;
            Exception expectedExcetpion = null;
            TestStatus actual;
            try
            {
                actual = reader.ReadEnum<TestStatus>(name);
            }
            catch (Exception ex)
            {
                expectedExcetpion = ex;
            }

            Assert.IsNotNull(expectedExcetpion);
            Assert.IsInstanceOfType(expectedExcetpion, typeof(TeslaDeserializationException));
        }

        /// <summary>
        /// Read a 1D array of Enums.
        /// </summary>
        [TestMethod]
        public void ReadEnum1DArrayTest()
        {
            List<TestStatus> values = new List<TestStatus>() { TestStatus.Late, TestStatus.OnTime, TestStatus.Early, TestStatus.OnTime, TestStatus.Late};

            DeserializationHelper.Array1DHelper<TestStatus>(values);
        }

        /// <summary>
        /// Read a 2D array of Enums.
        /// </summary>
        [TestMethod]
        public void ReadEnum2DArrayTest()
        {
            List<List<TestStatus>> values = new List<List<TestStatus>>() 
                { 
                    new List<TestStatus>() { TestStatus.Late, TestStatus.Late, TestStatus.Early, TestStatus.OnTime, TestStatus.Early }, 
                    new List<TestStatus>() { TestStatus.Early, TestStatus.Late, TestStatus.Late,  TestStatus.OnTime},
                };

            DeserializationHelper.Array2DHelper<TestStatus>(values);
        }

        /// <summary>
        /// Read a 3D array of Enums.
        /// </summary>
        [TestMethod]
        public void ReadEnum3DArrayTest()
        {
            List<List<List<TestStatus>>> values = new List<List<List<TestStatus>>>() 
                { 
                    new List<List<TestStatus>>() 
                    {
                        new List<TestStatus>() { TestStatus.Late, TestStatus.Late, TestStatus.Early, TestStatus.OnTime, TestStatus.Early }, 
                        new List<TestStatus>() { TestStatus.Early, TestStatus.Late, TestStatus.Late,  TestStatus.OnTime},
                    },
                    new List<List<TestStatus>>() 
                    {
                        new List<TestStatus>() { TestStatus.OnTime, TestStatus.Early, TestStatus.Late }, 
                    },
                };

            DeserializationHelper.Array3DHelper<TestStatus>(values);
        }

        /// <summary>
        /// Read a 4D array of Enums.
        /// </summary>
        [TestMethod]
        public void ReadEnum4DArrayTest()
        {
            List<List<List<List<TestStatus>>>> values = new List<List<List<List<TestStatus>>>>() 
                { 
                    new List<List<List<TestStatus>>>() 
                    {
                        new List<List<TestStatus>>() 
                        {
                            new List<TestStatus>() { TestStatus.Late, TestStatus.Late, TestStatus.Early, TestStatus.OnTime, TestStatus.Early }, 
                            new List<TestStatus>() { TestStatus.Early, TestStatus.Late, TestStatus.Late,  TestStatus.OnTime},
                        },
                        new List<List<TestStatus>>() 
                        {
                             new List<TestStatus>() { TestStatus.OnTime, TestStatus.Early, TestStatus.Late }, 
                        },
                    },
                    new List<List<List<TestStatus>>>() 
                    {
                        new List<List<TestStatus>>() 
                        {
                            new List<TestStatus>() {  TestStatus.Late, TestStatus.Early, TestStatus.OnTime }, 
                        },
                    },
                };

            DeserializationHelper.Array4DHelper<TestStatus>(values);
        }

        /// <summary>
        /// Read an empty Enum array.
        /// </summary>
        [TestMethod]
        public void ReadEmptyEnumArray()
        {
            DeserializationHelper.EmptyArrayHelper<TestStatus>();
        }

    }
}
