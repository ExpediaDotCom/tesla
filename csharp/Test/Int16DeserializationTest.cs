namespace TeslaTest
{
    using System.Collections.Generic;
    using Expedia.Tesla.Serialization;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    /// <summary>
    /// This is a test class for Int16DeserializationTest and is intended
    /// to contain all Int16DeserializationTest Unit Tests.
    /// </summary>
    [TestClass]
    public class Int16DeserializationTest
    {
        /// <summary>
        /// Read Int16 values.
        /// </summary>
        [TestMethod]
        public void ReadInt16Test()
        {
            // Test value   Encoded As     Encoded Bytes 
            //        1         2          00000010
            //       -2         3          00000011 
            byte[] buffer = new byte[2] { 0x02, 0x03 };
            BinaryReader reader = new BinaryReader(buffer, DeserializationHelper.CannedVersion);
            string name = string.Empty;
            short actual;
            actual = reader.ReadInt16(name);
            Assert.AreEqual(1, actual);
            actual = reader.ReadInt16(name);
            Assert.AreEqual(-2, actual);
        }

        /// <summary>
        /// Reads a too small Int16 value.
        /// </summary>
        [TestMethod]
        public void ReadTooSmallInt16Test()
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .Int64(long.MinValue)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadInt16(string.Empty);
                },
                "Bad format Int16 value. The value was read is outside the range of the Int16.");
        }

        /// <summary>
        /// Reads a too large Int16 value.
        /// </summary>
        [TestMethod]
        public void ReadTooLargeInt16Test()
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .Int64(long.MaxValue)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadInt16(string.Empty);
                },
                "Bad format Int16 value. The value was read is outside the range of the Int16.");
        }

        /// <summary>
        /// Read a 1D array of shorts.
        /// </summary>
        [TestMethod]
        public void ReadInt161DArrayTest()
        {
            List<short> values = new List<short>() { -1, 0, short.MinValue, 1000, short.MaxValue };

            DeserializationHelper.Array1DHelper<short>(values);
        }

        /// <summary>
        /// Read a 2D array of shorts.
        /// </summary>
        [TestMethod]
        public void ReadInt162DArrayTest()
        {
            List<List<short>> values = new List<List<short>>() 
                { 
                    new List<short>() { -1, 0, short.MinValue, 1000, short.MaxValue }, 
                    new List<short>() { -1, short.MaxValue, 10 },
                };

            DeserializationHelper.Array2DHelper<short>(values);
        }

        /// <summary>
        /// Read a 3D array of shorts.
        /// </summary>
        [TestMethod]
        public void ReadInt163DArrayTest()
        {
            List<List<List<short>>> values = new List<List<List<short>>>() 
                { 
                    new List<List<short>>() 
                    {
                        new List<short>() { -1, 0, short.MinValue, 1000, short.MaxValue }, 
                        new List<short>() { -1, short.MaxValue, 10 },
                    },
                    new List<List<short>>() 
                    {
                        new List<short>() { 0x02, 0x13, 0x29 }, 
                    },
                };

            DeserializationHelper.Array3DHelper<short>(values);
        }

        /// <summary>
        /// Read a 4D array of shorts.
        /// </summary>
        [TestMethod]
        public void ReadInt164DArrayTest()
        {
            List<List<List<List<short>>>> values = new List<List<List<List<short>>>>() 
                { 
                    new List<List<List<short>>>() 
                    {
                        new List<List<short>>() 
                        {
                        new List<short>() { -1, 0, short.MinValue, 1000, short.MaxValue }, 
                        new List<short>() { -1, short.MaxValue, 10 },
                        },
                        new List<List<short>>() 
                        {
                            new List<short>() { 0x02, 0x13, 0x29 }, 
                        },
                    },
                    new List<List<List<short>>>() 
                    {
                        new List<List<short>>() 
                        {
                            new List<short>() { 0x12, 0x23 }, 
                        },
                    },
                };

            DeserializationHelper.Array4DHelper<short>(values);
        }

        /// <summary>
        /// Read an empty Int16 array.
        /// </summary>
        [TestMethod]
        public void ReadEmptyInt16Array()
        {
            DeserializationHelper.EmptyArrayHelper<short>();
        }
    }    
}
