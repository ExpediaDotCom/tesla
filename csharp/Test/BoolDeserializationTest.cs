namespace TeslaTest
{
    using System.Collections.Generic;
    using Expedia.Tesla.Serialization;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    /// <summary>
    /// This is a test class for BoolDeserializationTest and is intended
    /// to contain all BoolDeserializationTest Unit Tests.
    /// </summary>
    [TestClass]
    public class BoolDeserializationTest
    {
        /// <summary>
        /// Read boolean values.
        /// </summary>
        [TestMethod]
        public void ReadBoolTest()
        {
            BinaryReader reader = new BinaryReader(new byte[] { 0xD, 0x5 }, DeserializationHelper.CannedVersion);

            bool actual;

            actual = reader.ReadBoolean(string.Empty);
            Assert.AreEqual(true, actual);
            actual = reader.ReadBoolean(string.Empty);
            Assert.AreEqual(false, actual);
        }

        /// <summary>
        /// Reads an invalid boolean value.
        /// </summary>
        [TestMethod]
        public void ReadInvalidBoolTest()
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .RawByte(0xFF)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadBoolean(string.Empty);
                },
                "Invalid boolean value: 255.");
        }

        /// <summary>
        /// Read a 1D array of bools.
        /// </summary>
        [TestMethod]
        public void ReadBoolean1DArrayTest()
        {
            List<bool> values = new List<bool>() { false, true };

            DeserializationHelper.Array1DHelper<bool>(values);
        }

        /// <summary>
        /// Read a 2D array of bools.
        /// </summary>
        [TestMethod]
        public void ReadBoolean2DArrayTest()
        {
            List<List<bool>> values = new List<List<bool>>() 
                { 
                    new List<bool>() { false, true }, 
                    new List<bool>() { true },
                };

            DeserializationHelper.Array2DHelper<bool>(values);
        }

        /// <summary>
        /// Read a 3D array of bools.
        /// </summary>
        [TestMethod]
        public void ReadBoolean3DArrayTest()
        {
            List<List<List<bool>>> values = new List<List<List<bool>>>() 
                { 
                    new List<List<bool>>() 
                    {
                        new List<bool>() { false, true }, 
                        new List<bool>() { true },
                    },
                    new List<List<bool>>() 
                    {
                        new List<bool>() { false }, 
                    },
                };

            DeserializationHelper.Array3DHelper<bool>(values);
        }

        /// <summary>
        /// Read a 4D array of bools.
        /// </summary>
        [TestMethod]
        public void ReadBoolean4DArrayTest()
        {
            List<List<List<List<bool>>>> values = new List<List<List<List<bool>>>>() 
                { 
                    new List<List<List<bool>>>() 
                    {
                        new List<List<bool>>() 
                        {
                            new List<bool>() { false, true }, 
                            new List<bool>() { true },
                        },
                        new List<List<bool>>() 
                        {
                            new List<bool>() { false }, 
                        },
                    },
                    new List<List<List<bool>>>() 
                    {
                        new List<List<bool>>() 
                        {
                            new List<bool>() { true, false, true }, 
                        },
                    },
                };

            DeserializationHelper.Array4DHelper<bool>(values);
        }

        /// <summary>
        /// Read an empty boolean array.
        /// </summary>
        [TestMethod]
        public void ReadEmptyBooleanArray()
        {
            DeserializationHelper.EmptyArrayHelper<bool>();
        }
    }
}
