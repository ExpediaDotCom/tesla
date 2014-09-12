namespace TeslaTest
{
    using System.Collections.Generic;
    using System.Text;
    using Expedia.Tesla.Serialization;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    /// <summary>
    /// This is a test class for FloatDeserializationTest and is intended
    /// to contain all FloatDeserializationTest Unit Tests.
    /// </summary>
    [TestClass]
    public class FloatDeserializationTest
    {
        /// <summary>
        /// Read float values.
        /// </summary>
        [TestMethod]
        public void ReadFloatTest()
        {
            // Test floats {-89171.12f, 1.783421e31f}

            // prepare test buffer
            UTF8Encoding utf8 = new UTF8Encoding();
            System.IO.MemoryStream ms = new System.IO.MemoryStream();
            System.IO.BinaryWriter bw = new System.IO.BinaryWriter(ms, utf8);
            bw.Write((float)-89171.12);
            bw.Write((float)1.783421e31);
            bw.Write(float.NaN);
            bw.Write(float.NegativeInfinity);
            bw.Write(float.PositiveInfinity);
            ms.Seek(0, System.IO.SeekOrigin.Begin);

            BinaryReader reader = new BinaryReader(ms, DeserializationHelper.CannedVersion);
            string name = string.Empty;
            float actual;
            actual = reader.ReadFloat(name);
            Assert.AreEqual((float)-89171.12, actual);
            actual = reader.ReadFloat(name);
            Assert.AreEqual((float)1.783421e31, actual);
            actual = reader.ReadFloat(name);
            Assert.IsTrue(float.IsNaN(actual));
            actual = reader.ReadFloat(name);
            Assert.IsTrue(float.IsNegativeInfinity(actual));
            actual = reader.ReadFloat(name);
            Assert.IsTrue(float.IsPositiveInfinity(actual));
        }

        /// <summary>
        /// Reads a too small Float value.
        /// </summary>
        [TestMethod]
        public void ReadTooSmallFloatTest()
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .Double(double.MinValue)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            float actual = reader.ReadFloat(string.Empty);

            Assert.AreEqual<float>(float.NaN, actual);
        }

        /// <summary>
        /// Reads a too large Float value.
        /// </summary>
        [TestMethod]
        public void ReadTooLargeFloatTest()
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .Double(double.MaxValue)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            float actual = reader.ReadFloat(string.Empty);

            Assert.AreEqual<float>(float.NaN, actual);
        }

        /// <summary>
        /// Read a 1D array of floats.
        /// </summary>
        [TestMethod]
        public void ReadFloat1DArrayTest()
        {
            List<float> values = new List<float>() { 0x01, 1.1F, 2.2F, 3.3F };

            DeserializationHelper.Array1DHelper<float>(values);
        }

        /// <summary>
        /// Read a 2D array of floats.
        /// </summary>
        [TestMethod]
        public void ReadFloat2DArrayTest()
        {
            List<List<float>> values = new List<List<float>>() 
                { 
                    new List<float>() { 0x01, 1.1F, 2.2F, 3.3F }, 
                    new List<float>() { -2.5F, 0xFD, 3000 },
                };

            DeserializationHelper.Array2DHelper<float>(values);
        }

        /// <summary>
        /// Read a 3D array of floats.
        /// </summary>
        [TestMethod]
        public void ReadFloat3DArrayTest()
        {
            List<List<List<float>>> values = new List<List<List<float>>>() 
                { 
                    new List<List<float>>() 
                    {
                        new List<float>() { 0x01, 1.1F, 2.2F, 3.3F }, 
                        new List<float>() { -2.5F, 0xFD, 3000 },
                    },
                    new List<List<float>>() 
                    {
                        new List<float>() { 1.5F, 2.2F, -1e10F }, 
                    },
                };

            DeserializationHelper.Array3DHelper<float>(values);
        }

        /// <summary>
        /// Read a 4D array of floats.
        /// </summary>
        [TestMethod]
        public void ReadFloat4DArrayTest()
        {
            List<List<List<List<float>>>> values = new List<List<List<List<float>>>>() 
                { 
                    new List<List<List<float>>>() 
                    {
                        new List<List<float>>() 
                        {
                        new List<float>() { 0x01, 1.1F, 2.2F, 3.3F }, 
                        new List<float>() { -2.5F, 0xFD, 3000 },
                        },
                        new List<List<float>>() 
                        {
                           new List<float>() { 1.5F, 2.2F, -1e10F }, 
                        },
                    },
                    new List<List<List<float>>>() 
                    {
                        new List<List<float>>() 
                        {
                            new List<float>() { 0x12, 0x23 }, 
                        },
                    },
                };

            DeserializationHelper.Array4DHelper<float>(values);
        }

        /// <summary>
        /// Read an empty float array.
        /// </summary>
        [TestMethod]
        public void ReadEmptyFloatArray()
        {
            DeserializationHelper.EmptyArrayHelper<float>();
        }
    }
}
