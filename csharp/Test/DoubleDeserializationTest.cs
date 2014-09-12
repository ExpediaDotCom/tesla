namespace TeslaTest
{
    using System.Collections.Generic;
    using System.Text;
    using Expedia.Tesla.Serialization;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    /// <summary>
    /// This is a test class for DoubleDeserializationTest and is intended
    /// to contain all DoubleDeserializationTest Unit Tests.
    /// </summary>
    [TestClass]
    public class DoubleDeserializationTest
    {
        /// <summary>
        /// Read double values.
        /// </summary>
        [TestMethod]
        public void ReadDoubleTest()
        {
            // Test double values: {103801738.120123, -0.0000212384134}

            // prepare test buffer
            UTF8Encoding utf8 = new UTF8Encoding();
            System.IO.MemoryStream ms = new System.IO.MemoryStream();
            System.IO.BinaryWriter bw = new System.IO.BinaryWriter(ms, utf8);
            bw.Write((double)103801738.120123);
            bw.Write((double)-0.0000212384134);
            bw.Write(double.NaN);
            bw.Write(double.NegativeInfinity);
            bw.Write(double.PositiveInfinity);
            ms.Seek(0, System.IO.SeekOrigin.Begin);

            BinaryReader reader = new BinaryReader(ms, DeserializationHelper.CannedVersion);
            string name = string.Empty;
            double actual;
            actual = reader.ReadDouble(name);
            Assert.AreEqual((double)103801738.120123, actual);
            actual = reader.ReadDouble(name);
            Assert.AreEqual((double)-0.0000212384134, actual);
            actual = reader.ReadDouble(name);
            Assert.IsTrue(double.IsNaN(actual));
            actual = reader.ReadDouble(name);
            Assert.IsTrue(double.IsNegativeInfinity(actual));
            actual = reader.ReadDouble(name);
            Assert.IsTrue(double.IsPositiveInfinity(actual));
        }

        /// <summary>
        /// Read a 1D array of doubles.
        /// </summary>
        [TestMethod]
        public void ReadDouble1DArrayTest()
        {
            List<double> values = new List<double>() { 0x01, 1.1F, 2.2F, 3.3e300 };

            DeserializationHelper.Array1DHelper<double>(values);
        }

        /// <summary>
        /// Read a 2D array of doubles.
        /// </summary>
        [TestMethod]
        public void ReadDouble2DArrayTest()
        {
            List<List<double>> values = new List<List<double>>() 
                { 
                    new List<double>() { 0x01, 1.1F, 2.2F, 3.3e300 }, 
                    new List<double>() { -2.5F, 0xFD, 3000 },
                };

            DeserializationHelper.Array2DHelper<double>(values);
        }

        /// <summary>
        /// Read a 3D array of doubles.
        /// </summary>
        [TestMethod]
        public void ReadDouble3DArrayTest()
        {
            List<List<List<double>>> values = new List<List<List<double>>>() 
                { 
                    new List<List<double>>() 
                    {
                        new List<double>() { 0x01, 1.1F, 2.2F, 3.3e300 }, 
                        new List<double>() { -2.5F, 0xFD, 3000 },
                    },
                    new List<List<double>>() 
                    {
                        new List<double>() { 1.5F, 2.2F, -1e10F }, 
                    },
                };

            DeserializationHelper.Array3DHelper<double>(values);
        }

        /// <summary>
        /// Read a 4D array of doubles.
        /// </summary>
        [TestMethod]
        public void ReadDouble4DArrayTest()
        {
            List<List<List<List<double>>>> values = new List<List<List<List<double>>>>() 
                { 
                    new List<List<List<double>>>() 
                    {
                        new List<List<double>>() 
                        {
                        new List<double>() { 0x01, 1.1F, 2.2F, 3.3e300 }, 
                        new List<double>() { -2.5F, 0xFD, 3000 },
                        },
                        new List<List<double>>() 
                        {
                           new List<double>() { 1.5F, 2.2F, -1e10F }, 
                        },
                    },
                    new List<List<List<double>>>() 
                    {
                        new List<List<double>>() 
                        {
                            new List<double>() { 0x12, 0x23 }, 
                        },
                    },
                };

            DeserializationHelper.Array4DHelper<double>(values);
        }

        /// <summary>
        /// Read an empty double array.
        /// </summary>
        [TestMethod]
        public void ReadEmptyDoubleArray()
        {
            DeserializationHelper.EmptyArrayHelper<double>();
        }
    }
}
