namespace TeslaTest
{
    using System.Collections.Generic;
    using Expedia.Tesla.Serialization;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    /// <summary>
    /// This is a test class for BinaryDeserializationTest and is intended
    /// to contain all BinaryDeserializationTest Unit Tests.
    /// </summary>
    [TestClass]
    public class BinaryDeserializationTest
    {
        /// <summary>
        /// Read a binary value.
        /// </summary>
        [TestMethod]
        public void ReadBinaryTest()
        {
            // Test binary object of length 10: 
            // { 0x01, 0x02, 0x32, 0x00, 0x23, 0x90, 0xFE, 0xA3, 0xB8, 0x99 }
            byte[] expected = new byte[] { 0x02, 0x02, 0x32, 0x00, 0x23, 0x90, 0xFE, 0xA3, 0xB8, 0x99 };

            System.IO.Stream stream = new SerializedStreamBuilder()
                .Binary(expected)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            byte[] actual = reader.ReadBinary(string.Empty, false);

            TestHelper.AssertCollectionEquals<byte>(expected, actual);
        }

        /// <summary>
        /// Read a nullable binary.
        /// </summary>
        [TestMethod]
        public void ReadNullableBinaryTest()
        {
            byte[] expected = new byte[] { 0x12, 0x66, 0x3 };

            System.IO.Stream stream = new SerializedStreamBuilder()
                .NullableFlag(false)
                .Size((ulong)expected.Length)
                .RawBytes(expected)
                .NullableFlag(true)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            byte[] actual;

            actual = reader.ReadBinary(string.Empty, true);
            TestHelper.AssertCollectionEquals<byte>(expected, actual);

            actual = reader.ReadBinary(string.Empty, true);
            Assert.IsNull(actual);
        }

        /// <summary>
        /// Read a 1D array of binary data.
        /// </summary>
        [TestMethod]
        public void ReadBinary1DArrayTest()
        {
            List<byte[]> values = new List<byte[]>() 
                { 
                    new byte[] { 0x01, 0x02, 0x32 },
                    new byte[] { 0x01, 0x02 },
                };

            DeserializationHelper.BinaryArrayHelper(values);
        }

        /// <summary>
        /// Read an empty binary array.
        /// </summary>
        [TestMethod]
        public void ReadEmptyBinaryArray()
        {
            DeserializationHelper.EmptyArrayHelper<byte[]>();
        }

        /// <summary>
        /// Read an invalid binary size.
        /// </summary>
        [TestMethod]
        public void ReadInvalidBinarySize()
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .Int64(long.MaxValue)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadBinary(string.Empty, false);
                },
                "Invalid data was encountered in the stream. The stream is corrupted.");
        }        
    }
}
