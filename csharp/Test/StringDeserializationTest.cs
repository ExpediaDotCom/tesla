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

    /// <summary>
    /// This is a test class for StringDeserializationTest and is intended
    /// to contain all StringDeserializationTest Unit Tests.
    /// </summary>
    [TestClass]
    public class StringDeserializationTest
    {
        /// <summary>
        /// Read string values.
        /// </summary>
        [TestMethod]
        public void ReadStringTest()
        {
            string[] testStrings = new string[] 
            { 
                string.Empty,
                "9*!)!)^&*AD*ADAS0898`3101`;'saf213\t\\}{]qwrw", 
                "098hr c012842\r\n\\@*)",
                new string('x', 10000000)
            };

            // prepare test buffer
            UTF8Encoding utf8 = new UTF8Encoding();
            System.IO.MemoryStream ms = new System.IO.MemoryStream();
            System.IO.BinaryWriter bw = new System.IO.BinaryWriter(ms, utf8);
            foreach (string s in testStrings)
            {
                bw.Write(s);
            }

            ms.Seek(0, System.IO.SeekOrigin.Begin);
            BinaryReader reader = new BinaryReader(ms, DeserializationHelper.CannedVersion);
            string name = string.Empty;
            string actual;
            foreach (string s in testStrings)
            {
                actual = reader.ReadString(name, false);
                Assert.AreEqual(s, actual);
            }
        }

        /// <summary>
        /// Read a nullable string.
        /// </summary>
        [TestMethod]
        public void ReadNullableStringTest()
        {
            const string Expected = "foo";

            System.IO.Stream stream = new SerializedStreamBuilder()
                .String(Expected, false)
                .String(null, true)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            string actual;

            actual = reader.ReadString(string.Empty, true);
            Assert.AreEqual<string>(Expected, actual);

            actual = reader.ReadString(string.Empty, true);
            Assert.IsNull(actual);
        }

        /// <summary>
        /// Read a 1D array of strings.
        /// </summary>
        [TestMethod]
        public void ReadString1DArrayTest()
        {
            List<string> values = new List<string>() { "foo", "bar" };

            DeserializationHelper.Array1DHelper<string>(values);
        }

        /// <summary>
        /// Read a 2D array of strings.
        /// </summary>
        [TestMethod]
        public void ReadString2DArrayTest()
        {
            List<List<string>> values = new List<List<string>>() 
                {                     
                    new List<string>() { "foo", "bar" }, 
                    new List<string>() { "no", "no", "and no" },
                };

            DeserializationHelper.Array2DHelper<string>(values);
        }

        /// <summary>
        /// Read a 3D array of strings.
        /// </summary>
        [TestMethod]
        public void ReadString3DArrayTest()
        {
            List<List<List<string>>> values = new List<List<List<string>>>() 
                {                     
                    new List<List<string>>() 
                    {
                        new List<string>() { "foo", "bar" }, 
                        new List<string>() { "no", "no", "and no" },
                    },
                    new List<List<string>>() 
                    {
                        new List<string>() { "what?", "where?", "who?" }, 
                    },                    
                };

            DeserializationHelper.Array3DHelper<string>(values);
        }

        /// <summary>
        /// Read a 4D array of strings.
        /// </summary>
        [TestMethod]
        public void ReadString4DArrayTest()
        {
            List<List<List<List<string>>>> values = new List<List<List<List<string>>>>() 
                { 
                    new List<List<List<string>>>() 
                    {
                        new List<List<string>>() 
                        {
                            new List<string>() { "foo", "bar" }, 
                            new List<string>() { "no", "no", "and no" },
                        },
                        new List<List<string>>() 
                        {
                            new List<string>() { "what?", "where?", "who?" }, 
                        },
                    },
                    new List<List<List<string>>>() 
                    {
                        new List<List<string>>() 
                        {
                            new List<string>() { "no ways !!!111one", "sigh." }, 
                        },
                    },
                };

            DeserializationHelper.Array4DHelper<string>(values);
        }

        /// <summary>
        /// Read an empty string array.
        /// </summary>
        [TestMethod]
        public void ReadEmptyStringArray()
        {
            DeserializationHelper.EmptyArrayHelper<string>();
        }

        /// <summary>
        /// Reads a string with an invalid size.
        /// </summary>
        [TestMethod]
        public void ReadStringWithInvalidSize()
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                  .Int64(long.MaxValue)
                  .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadString(string.Empty, false);
                },
                "Invalid data was encountered in the stream. The stream is corrupted.");
        }
    }
}
