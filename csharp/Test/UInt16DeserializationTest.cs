namespace TeslaTest
{
    using System.Collections.Generic;
    using Expedia.Tesla.Serialization;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    /// <summary>
    /// This is a test class for UInt16DeserializationTest and is intended
    /// to contain all UInt16DeserializationTest Unit Tests.
    /// </summary>
    [TestClass]
    public class UInt16DeserializationTest
    {
        /// <summary>
        /// Read UInt16 values.
        /// </summary>
        [TestMethod]
        public void ReadUInt16Test()
        {
            // Test value        Encoded Bytes 
            //       130         10000010 00000001
            //      16385        10000001 10000000 00000001
            byte[] buffer = { 0x82, 0x01, 0x81, 0x80, 0x01 };
            BinaryReader reader = new BinaryReader(buffer, DeserializationHelper.CannedVersion);
            string name = string.Empty;
            ushort actual;

            actual = reader.ReadUInt16(name);
            Assert.AreEqual(130, actual);

            actual = reader.ReadUInt16(name);
            Assert.AreEqual(16385, actual);
        }

        /// <summary>
        /// Reads a too small UInt16 value.
        /// </summary>
        [TestMethod]
        public void ReadTooSmallUInt16Test()
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .Int64(long.MinValue)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadUInt16(string.Empty);
                },
                "Bad format UInt16 value. The value was read is outside the range of the UInt16.");
        }

        /// <summary>
        /// Reads a too large UInt16 value.
        /// </summary>
        [TestMethod]
        public void ReadTooLargeUInt16Test()
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .Int64(long.MaxValue)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadUInt16(string.Empty);
                },
                "Bad format UInt16 value. The value was read is outside the range of the UInt16.");
        }

        /// <summary>
        /// Read a 1D array of ushorts.
        /// </summary>
        [TestMethod]
        public void ReadUInt161DArrayTest()
        {
            List<ushort> values = new List<ushort>() { 1, 0, ushort.MinValue, 1000, ushort.MaxValue };

            DeserializationHelper.Array1DHelper<ushort>(values);
        }

        /// <summary>
        /// Read a 2D array of ushorts.
        /// </summary>
        [TestMethod]
        public void ReadUInt162DArrayTest()
        {
            List<List<ushort>> values = new List<List<ushort>>() 
                { 
                    new List<ushort>() { 1, 0, ushort.MinValue, 1000, ushort.MaxValue }, 
                    new List<ushort>() { ushort.MinValue, 2 },
                };

            DeserializationHelper.Array2DHelper<ushort>(values);
        }

        /// <summary>
        /// Read a 3D array of ushorts.
        /// </summary>
        [TestMethod]
        public void ReadUInt163DArrayTest()
        {
            List<List<List<ushort>>> values = new List<List<List<ushort>>>() 
                { 
                    new List<List<ushort>>() 
                    {
                        new List<ushort>() { 1, 0, ushort.MinValue, 1000, ushort.MaxValue }, 
                        new List<ushort>() { ushort.MinValue, 2 },
                    },
                    new List<List<ushort>>() 
                    {
                        new List<ushort>() { 0x02, ushort.MinValue, 0x29 }, 
                    },
                };

            DeserializationHelper.Array3DHelper<ushort>(values);
        }

        /// <summary>
        /// Read a 4D array of ushorts.
        /// </summary>
        [TestMethod]
        public void ReadUInt164DArrayTest()
        {
            List<List<List<List<ushort>>>> values = new List<List<List<List<ushort>>>>() 
                { 
                    new List<List<List<ushort>>>() 
                    {
                        new List<List<ushort>>() 
                        {
                            new List<ushort>() { 1, 0, ushort.MinValue, 1000, ushort.MaxValue }, 
                            new List<ushort>() { ushort.MinValue, 2 },
                        },
                        new List<List<ushort>>() 
                        {
                            new List<ushort>() { 0x02, ushort.MinValue, 0x29 }, 
                        },
                    },
                    new List<List<List<ushort>>>() 
                    {
                        new List<List<ushort>>() 
                        {
                            new List<ushort>() { 0x12, 0x23 }, 
                        },
                    },
                };

            DeserializationHelper.Array4DHelper<ushort>(values);
        }

        /// <summary>
        /// Read an empty UInt16 array.
        /// </summary>
        [TestMethod]
        public void ReadEmptyUInt16Array()
        {
            DeserializationHelper.EmptyArrayHelper<ushort>();
        }
    }
}
