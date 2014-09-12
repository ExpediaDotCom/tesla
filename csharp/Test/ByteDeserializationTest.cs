namespace TeslaTest
{
    using System.Collections.Generic;
    using Expedia.Tesla.Serialization;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    /// <summary>
    /// This is a test class for ByteDeserializationTest and is intended
    /// to contain all ByteDeserializationTest Unit Tests.
    /// </summary>
    [TestClass]
    public class ByteDeserializationTest
    {
        /// <summary>
        /// Call ReadByte for different valid values.
        /// </summary>
        [TestMethod]
        public void ReadByteTest()
        {
            byte[] buffer = new byte[] { 0x01, 0x02, 0x32, 0x00, 0x23, 0x90, 0xFE, 0xA3, 0xFF, 0xB8, 0x99 };
            BinaryReader reader = new BinaryReader(buffer, DeserializationHelper.CannedVersion);

            foreach (byte expected in buffer)
            {
                byte actual = reader.ReadByte(string.Empty);
                Assert.AreEqual(expected, actual);
            }
        }

        /// <summary>
        /// Reads a byte from an empty stream.
        /// </summary>
        [TestMethod]
        public void ReadEmptyByteTest()
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadByte(string.Empty);
                },
                "The end of the stream is reached during deserialization.");
        }

        /// <summary>
        /// Read a 1D array of bytes.
        /// </summary>
        [TestMethod]
        public void ReadByte1DArrayTest()
        {
            List<byte> values = new List<byte>() { 0x01, 0x02, 0x32, 0x00, 0x23, 0x90, 0xFE, 0xFF, 0xA3, 0xB8, 0x99 };

            DeserializationHelper.Array1DHelper<byte>(values);
        }

        /// <summary>
        /// Read a 2D array of bytes.
        /// </summary>
        [TestMethod]
        public void ReadByte2DArrayTest()
        {
            List<List<byte>> values = new List<List<byte>>() 
                { 
                    new List<byte>() { 0x01, 0x02 }, 
                    new List<byte>() { 0x00, 0xFD, 0x98 },
                };
            
            DeserializationHelper.Array2DHelper<byte>(values);
        }

        /// <summary>
        /// Read a 3D array of bytes.
        /// </summary>
        [TestMethod]
        public void ReadByte3DArrayTest()
        {
            List<List<List<byte>>> values = new List<List<List<byte>>>() 
                { 
                    new List<List<byte>>() 
                    {
                        new List<byte>() { 0x01, 0x02 }, 
                        new List<byte>() { 0x00, 0xFD, 0x98 },
                    },
                    new List<List<byte>>() 
                    {
                        new List<byte>() { 0x02, 0x13, 0x29 }, 
                    },
                };
            
            DeserializationHelper.Array3DHelper<byte>(values);
        }

        /// <summary>
        /// Read a 4D array of bytes.
        /// </summary>
        [TestMethod]
        public void ReadByte4DArrayTest()
        {
            List<List<List<List<byte>>>> values = new List<List<List<List<byte>>>>() 
                { 
                    new List<List<List<byte>>>() 
                    {
                        new List<List<byte>>() 
                        {
                            new List<byte>() { 0x01, 0x02 }, 
                            new List<byte>() { 0x00, 0xFD, 0x98 },
                        },
                        new List<List<byte>>() 
                        {
                            new List<byte>() { 0x02, 0x13, 0x29 }, 
                        },
                    },
                    new List<List<List<byte>>>() 
                    {
                        new List<List<byte>>() 
                        {
                            new List<byte>() { 0x12, 0x23 }, 
                        },
                    },
                };

            DeserializationHelper.Array4DHelper<byte>(values);
        }

        /// <summary>
        /// Read an empty byte array.
        /// </summary>
        [TestMethod]
        public void ReadEmptyByteArray()
        {
            DeserializationHelper.EmptyArrayHelper<byte>();
        }
    }    
}
