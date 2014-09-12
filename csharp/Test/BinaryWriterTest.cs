namespace TeslaTest
{
    using System;
    using System.Collections;
    using System.Collections.Generic;
    using System.Reflection;
    using System.Text;
    using Expedia.Tesla.Serialization;
    using Expedia.Tesla.Schema;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    /// <summary>
    /// This is a test class for BinaryWriterTest and is intended
    /// to contain all BinaryWriterTest Unit Tests.
    /// </summary>
    [TestClass]
    public class BinaryWriterTest
    {
        /// <summary>
        /// A canned version to be used for streams when we don't care about
        /// its value.
        /// </summary>
        public const uint CannedVersionNumber = 13;
        public static SchemaVersion CannedVersion = new SchemaVersion((short)CannedVersionNumber);

        /// <summary>
        /// Writes byte values.
        /// </summary>
        [TestMethod]
        public void WriteByteTest()
        {
            System.IO.MemoryStream output = new System.IO.MemoryStream();
            byte[] expected = new byte[] { 0x01, 0x02, 0x32, 0x00, 0x23, 0x90, 0xFE, 0xFF, 0xA3, 0xB8, 0x99 };
            BinaryWriter writer = new BinaryWriter(output, BinaryWriterTest.CannedVersion); 
            
            foreach (byte b in expected)
            {
                writer.Write(string.Empty, b);
            }

            TestHelper.AssertCollectionEquals<byte>(expected, output.ToArray());
        }

        /// <summary>
        /// Write a null value for a non-nullable type.
        /// </summary>
        [TestMethod]
        public void WriteNullForNonNullableTypeTest()
        {
            System.IO.MemoryStream output = new System.IO.MemoryStream();

            BinaryWriter writer = new BinaryWriter(output, BinaryWriterTest.CannedVersion);

            TestHelper.ExpectException<TeslaSerializationException>(
                () =>
                {
                    writer.Write(string.Empty, (string)null, false);
                },
                "Null value was written as a non-nullable member.");
        }

        /// <summary>
        /// Write a nullable array.
        /// </summary>
        [TestMethod]
        public void WriteNullableArrayTest()
        {
            BinaryWriterTest.ArrayHelper<short>(null, true, 1);
        }
        
        /// <summary>
        /// Write a zero-rank array.
        /// </summary>
        [TestMethod]
        public void WriteZeroRankArray()
        {
            System.IO.MemoryStream output = new System.IO.MemoryStream();

            BinaryWriter writer = new BinaryWriter(output, BinaryWriterTest.CannedVersion);

            TestHelper.ExpectArgumentException(
               () =>
               {
                   writer.WriteInt32Array(string.Empty, null, true, 0);
               },
               "rank");
        }

        /// <summary>
        /// Write a 1D array with an unexpected non-collection  value.
        /// </summary>
        [TestMethod]
        public void WriteUnexpectedValueFor1DArrayTest()
        {
            List<string> values = new List<string> { "foo", "bar" };

            TestHelper.ExpectException<TeslaSerializationException>(
                () =>
                {
                    BinaryWriterTest.ArrayHelper<string>(values, 2);
                },
                "A non-sequence value is serialized as array. Sequence type must implement ICollection and ICollection<T>. The actual type is System.String T: System.String, rank: 1");
        }

        /// <summary>
        /// Write an array with an unexpected non-collection value.
        /// </summary>
        [TestMethod]
        public void WriteUnexpectedValueForArrayTest()
        {
            System.IO.MemoryStream output = new System.IO.MemoryStream();

            BinaryWriter writer = new BinaryWriter(output, BinaryWriterTest.CannedVersion);
            
            TestHelper.ExpectException<TeslaSerializationException>(
               () =>
               {
                   writer.WriteInt32Array(string.Empty, new List<List<int>> { new List<int> { 3 } }, false, 4);
               },
               "A non-sequence value is serialized as multiple dimensional array. Sequence type must implement ICollection and ICollection<T>");
        }

        /// <summary>
        /// Write an 1D array of bytes.
        /// </summary>
        [TestMethod]
        public void WriteByte1DArrayTest()
        {
            List<byte> values = new List<byte>() { 0x01, 0x02, 0x32, 0x00, 0x23, 0x90, 0xFE, 0xFF, 0xA3, 0xB8, 0x99 };

            BinaryWriterTest.ArrayHelper<byte>(values, 1);
        }

        /// <summary>
        /// Write an 1D array of bytes.
        /// </summary>
        [TestMethod]
        public void WriteByte2DArrayTest()
        {
            List<List<byte>> values = new List<List<byte>>
                {
                    new List<byte>() { 0x01, 0x02, 0x32, 0x00, 0x23, 0x90, 0xFE, 0xFF, 0xA3, 0xB8, 0x99 },
                    new List<byte>() { 0x55, 0x66 },
                };

            BinaryWriterTest.ArrayHelper<byte>(values, 2);
        }

        /// <summary>
        /// Writes Int16 values.
        /// </summary>
        [TestMethod]
        public void WriteInt16Test()
        {
            // Test value   Encoded As     Encoded Bytes 
            //        1         2          00000010
            //       -2         3          00000011 
            byte[] expected = new byte[2] { 0x02, 0x03 };

            System.IO.MemoryStream output = new System.IO.MemoryStream();
            BinaryWriter writer = new BinaryWriter(output, BinaryWriterTest.CannedVersion);

            writer.Write(string.Empty, (short)1);
            writer.Write(string.Empty, (short)-2);

            TestHelper.AssertCollectionEquals<byte>(expected, output.ToArray());
        }

        /// <summary>
        /// Write an 1D array of shorts.
        /// </summary>
        [TestMethod]
        public void WriteInt161DArrayTest()
        {
            List<short> values = new List<short>() { 125, 0x02, 0x32, 0x00, -23, 0x90, 0xFE, 0xFF, 0xA3, 0xB8, 0x99 };

            BinaryWriterTest.ArrayHelper<short>(values, 1);
        }

        /// <summary>
        /// Write an 1D array of shorts.
        /// </summary>
        [TestMethod]
        public void WriteInt162DArrayTest()
        {
            List<List<short>> values = new List<List<short>>
                {
                    new List<short>() { 0x01, 0x02, 0x32, 0x00, 0x23, 0x90, -1324, 0xFF, 0xA3, 0xB8, 0x99 },
                    new List<short>() { 10000, 0x66 },
                };

            BinaryWriterTest.ArrayHelper<short>(values, 2);
        }

        /// <summary>
        /// Writes Int32 values.
        /// </summary>
        [TestMethod]
        public void WriteInt32Test()
        {
            // Test value    Encoded As     Encoded Bytes 
            //       -2          3          00000011
            // 2147483647    4294967294     11111110 11111111 11111111 11111111 00001111
            // -2147483648   4294967295     11111111 11111111 11111111 11111111 00001111 
            byte[] expected = 
                { 
                    0x03,
                    0xFE, 0xFF, 0xFF, 0xFF, 0x0F,
                    0xFF, 0xFF, 0xFF, 0xFF, 0x0F 
                };

            System.IO.MemoryStream output = new System.IO.MemoryStream();
            BinaryWriter writer = new BinaryWriter(output, BinaryWriterTest.CannedVersion);

            writer.Write(string.Empty, (int)-2);
            writer.Write(string.Empty, (int)2147483647);
            writer.Write(string.Empty, (int)-2147483648);

            TestHelper.AssertCollectionEquals<byte>(expected, output.ToArray());
        }

        /// <summary>
        /// Write an 1D array of ints.
        /// </summary>
        [TestMethod]
        public void WriteInt321DArrayTest()
        {
            List<int> values = new List<int>() { 12431, 0x02, 0x32, 0x00, 0x23, 0x90, 0xFE, 0xFF, 0xA3, 0xB8, -20000 };

            BinaryWriterTest.ArrayHelper<int>(values, 1);
        }

        /// <summary>
        /// Write an 1D array of ints.
        /// </summary>
        [TestMethod]
        public void WriteInt322DArrayTest()
        {
            List<List<int>> values = new List<List<int>>
                {
                    new List<int>() { 0x01, 0x02, 0x32, 0x00, 0x23, 0x90, 0xFE, 0xFF, 0xA3, 0xB8, -20000 },
                    new List<int>() { 5555, 0x66 },
                };

            BinaryWriterTest.ArrayHelper<int>(values, 2);
        }

        /// <summary>
        /// Writes Int64 values.
        /// </summary>
        [TestMethod]
        public void WriteInt64Test()
        {
            // Test value    Encoded As     Encoded Bytes 
            //       -2          3          00000011
            // 2147483647    4294967294     11111110 11111111 11111111 11111111 00001111
            // -2147483648   4294967295     11111111 11111111 11111111 11111111 00001111 
            // INT64_MAX     0xFFFFFFFE     11111110 11111111 11111111 11111111 11111111 11111111 11111111 11111111 11111111 00000001
            // INT64_MIN     0xFFFFFFFF     11111111 11111111 11111111 11111111 11111111 11111111 11111111 11111111 11111111 00000001
            byte[] expected = 
                { 
                    0x03,
                    0xFE, 0xFF, 0xFF, 0xFF, 0x0F,
                    0xFF, 0xFF, 0xFF, 0xFF, 0x0F,
                    0xFE, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x01,
                    0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x01
                };

            System.IO.MemoryStream output = new System.IO.MemoryStream();
            BinaryWriter writer = new BinaryWriter(output, BinaryWriterTest.CannedVersion);

            writer.Write(string.Empty, (long)-2);
            writer.Write(string.Empty, (long)2147483647);
            writer.Write(string.Empty, (long)-2147483648);
            writer.Write(string.Empty, (long)+9223372036854775807);
            writer.Write(string.Empty, (long)-9223372036854775808);

            TestHelper.AssertCollectionEquals<byte>(expected, output.ToArray());
        }

        /// <summary>
        /// Write an 1D array of longs.
        /// </summary>
        [TestMethod]
        public void WriteInt641DArrayTest()
        {
            List<long> values = new List<long>() { 1243331, 0x02, 0x64, 0x00, 0x23, 0x90, 0xFE, 0xFF, 0xA3, 0xB8, -40000 };

            BinaryWriterTest.ArrayHelper<long>(values, 1);
        }

        /// <summary>
        /// Write an 1D array of longs.
        /// </summary>
        [TestMethod]
        public void WriteInt642DArrayTest()
        {
            List<List<long>> values = new List<List<long>>
                {
                    new List<long>() { 0x01, 0x02, 0x64, 0x00, 0x23, 0x90, 0xFE, 0xFF, 0xA3, 0xB8, -200000 },
                    new List<long>() { 555335, 0x66 },
                };

            BinaryWriterTest.ArrayHelper<long>(values, 2);
        }

        /// <summary>
        /// Writes UInt16 values.
        /// </summary>
        [TestMethod]
        public void WriteUInt16Test()
        {
            // Test value        Encoded Bytes 
            //       130         10000010 00000001
            //      16385        10000001 10000000 00000001
            byte[] expected = { 0x82, 0x01, 0x81, 0x80, 0x01 };

            System.IO.MemoryStream output = new System.IO.MemoryStream();
            BinaryWriter writer = new BinaryWriter(output, BinaryWriterTest.CannedVersion);

            writer.Write(string.Empty, (ushort)130);
            writer.Write(string.Empty, (ushort)16385);

            TestHelper.AssertCollectionEquals<byte>(expected, output.ToArray());
        }

        /// <summary>
        /// Write an 1D array of ushorts.
        /// </summary>
        [TestMethod]
        public void WriteUInt161DArrayTest()
        {
            List<ushort> values = new List<ushort>() { 125, 0x02, 0x32, 0x00, 0x23, 0x90, 0xFE, 0xFF, 0xA3, 0xB8, 0x99 };

            BinaryWriterTest.ArrayHelper<ushort>(values, 1);
        }

        /// <summary>
        /// Write an 1D array of ushorts.
        /// </summary>
        [TestMethod]
        public void WriteUInt162DArrayTest()
        {
            List<List<ushort>> values = new List<List<ushort>>
                {
                    new List<ushort>() { 0x01, 0x02, 0x32, 0x00, 0x23, 0x90, 0xFE, 0xFF, 0xA3, 0xB8, 0x99 },
                    new List<ushort>() { 10000, 0x66 },
                };

            BinaryWriterTest.ArrayHelper<ushort>(values, 2);
        }

        /// <summary>
        /// Writes UInt32 values.
        /// </summary>
        [TestMethod]
        public void WriteUInt32Test()
        {
            // Test value        Encoded Bytes 
            //       130         10000010 00000001
            //      16385        10000001 10000000 00000001
            byte[] expected = { 0x82, 0x01, 0x81, 0x80, 0x01 };

            System.IO.MemoryStream output = new System.IO.MemoryStream();
            BinaryWriter writer = new BinaryWriter(output, BinaryWriterTest.CannedVersion);

            writer.Write(string.Empty, (uint)130);
            writer.Write(string.Empty, (uint)16385);

            TestHelper.AssertCollectionEquals<byte>(expected, output.ToArray());
        }
        
        /// <summary>
        /// Write an 1D array of uints.
        /// </summary>
        [TestMethod]
        public void WriteUInt321DArrayTest()
        {
            List<uint> values = new List<uint>() { 1252, 0x02, 0x32, 0x00, 0x23, 0x90, 0xFE, 0xFF, 0xA3, 0xB8, 0x99 };

            BinaryWriterTest.ArrayHelper<uint>(values, 1);
        }

        /// <summary>
        /// Write an 1D array of uints.
        /// </summary>
        [TestMethod]
        public void WriteUInt322DArrayTest()
        {
            List<List<uint>> values = new List<List<uint>>
                {
                    new List<uint>() { 0x01, 0x02, 0x32, 0x00, 0x23, 0x90, 0xFE, 0xFF, 0xA3, 0xB8, 0x99 },
                    new List<uint>() { 100020, 0x66 },
                };

            BinaryWriterTest.ArrayHelper<uint>(values, 2);
        }

        /// <summary>
        /// Writes UInt64 values.
        /// </summary>
        [TestMethod]
        public void WriteUInt64Test()
        {
            // Test value        Encoded Bytes 
            //       130         10000010 00000001
            //      16385        10000001 10000000 00000001
            byte[] expected = { 0x82, 0x01, 0x81, 0x80, 0x01 };

            System.IO.MemoryStream output = new System.IO.MemoryStream();
            BinaryWriter writer = new BinaryWriter(output, BinaryWriterTest.CannedVersion);

            writer.Write(string.Empty, (ulong)130);
            writer.Write(string.Empty, (ulong)16385);

            TestHelper.AssertCollectionEquals<byte>(expected, output.ToArray());
        }
        
        /// <summary>
        /// Write an 1D array of ulongs.
        /// </summary>
        [TestMethod]
        public void WriteULong641DArrayTest()
        {
            List<ulong> values = new List<ulong>() { 121152, 0x02, 0x64, 0x00, 0x23, 0x90, 0xFE, 0xFF, 0xA3, 0xB8, 0x99 };

            BinaryWriterTest.ArrayHelper<ulong>(values, 1);
        }

        /// <summary>
        /// Write an 1D array of ulongs.
        /// </summary>
        [TestMethod]
        public void WriteULong642DArrayTest()
        {
            List<List<ulong>> values = new List<List<ulong>>
                {
                    new List<ulong>() { 0x01, 0x02, 0x64, 0x00, 0x23, 0x90, 0xFE, 0xFF, 0xA3, 0xB8, 0x99 },
                    new List<ulong>() { 10001120, 0x66 },
                };

            BinaryWriterTest.ArrayHelper<ulong>(values, 2);
        }

        /// <summary>
        /// Writes boolean values.
        /// </summary>
        [TestMethod]
        public void WriteBoolTest()
        {
            byte[] expected = { 0x0D, 0x05 };

            System.IO.MemoryStream output = new System.IO.MemoryStream();
            BinaryWriter writer = new BinaryWriter(output, BinaryWriterTest.CannedVersion);

            writer.Write(string.Empty, true);
            writer.Write(string.Empty, false);

            TestHelper.AssertCollectionEquals<byte>(expected, output.ToArray());
        }

        /// <summary>
        /// Write an 1D array of bools.
        /// </summary>
        [TestMethod]
        public void WriteBoolean1DArrayTest()
        {
            List<bool> values = new List<bool>() { true, false, true };

            BinaryWriterTest.ArrayHelper<bool>(values, 1);
        }

        /// <summary>
        /// Write an 1D array of bools.
        /// </summary>
        [TestMethod]
        public void WriteBoolean2DArrayTest()
        {
            List<List<bool>> values = new List<List<bool>>
                {
                    new List<bool>() { true, false, true },
                    new List<bool>() { false },
                };

            BinaryWriterTest.ArrayHelper<bool>(values, 2);
        }

        /// <summary>
        /// Writes float values.
        /// </summary>
        [TestMethod]
        public void WriteFloatTest()
        {
            // Test floats {-89171.12f, 1.783421e31f}

            // prepare Expected buffer
            UTF8Encoding utf8 = new UTF8Encoding();
            System.IO.MemoryStream ms = new System.IO.MemoryStream();
            System.IO.BinaryWriter bw = new System.IO.BinaryWriter(ms, utf8);
            bw.Write((float)-89171.12);
            bw.Write((float)1.783421e31);
            byte[] expected = ms.ToArray();

            System.IO.MemoryStream output = new System.IO.MemoryStream();
            BinaryWriter writer = new BinaryWriter(output, BinaryWriterTest.CannedVersion);

            writer.Write(string.Empty, (float)-89171.12);
            writer.Write(string.Empty, (float)1.783421e31);

            TestHelper.AssertCollectionEquals<byte>(expected, output.ToArray());
        }

        /// <summary>
        /// Write an 1D array of floats.
        /// </summary>
        [TestMethod]
        public void WriteFloat1DArrayTest()
        {
            List<float> values = new List<float>() { 1.5F, -2.0F, 1e21F };

            BinaryWriterTest.ArrayHelper<float>(values, 1);
        }

        /// <summary>
        /// Write an 1D array of floats.
        /// </summary>
        [TestMethod]
        public void WriteFloat2DArrayTest()
        {
            List<List<float>> values = new List<List<float>>
                {
                    new List<float>() { 1.5F, -2.0F, 1e21F },
                    new List<float>() { -10e10F },
                };

            BinaryWriterTest.ArrayHelper<float>(values, 2);
        }

        /// <summary>
        /// Writes double values.
        /// </summary>
        [TestMethod]
        public void WriteDoubleTest()
        {
            // Test double values: {103801738.120123, -0.0000212384134}

            // prepare test buffer
            UTF8Encoding utf8 = new UTF8Encoding();
            System.IO.MemoryStream ms = new System.IO.MemoryStream();
            System.IO.BinaryWriter bw = new System.IO.BinaryWriter(ms, utf8);
            bw.Write((double)103801738.120123);
            bw.Write((double)-0.0000212384134);
            byte[] expected = ms.ToArray();

            System.IO.MemoryStream output = new System.IO.MemoryStream();
            BinaryWriter writer = new BinaryWriter(output, BinaryWriterTest.CannedVersion);

            writer.Write(string.Empty, (double)103801738.120123);
            writer.Write(string.Empty, (double)-0.0000212384134);

            TestHelper.AssertCollectionEquals<byte>(expected, output.ToArray());
        }

        /// <summary>
        /// Write an 1D array of doubles.
        /// </summary>
        [TestMethod]
        public void WriteDouble1DArrayTest()
        {
            List<double> values = new List<double>() { 1.5F, -2.0F, 1e211 };

            BinaryWriterTest.ArrayHelper<double>(values, 1);
        }

        /// <summary>
        /// Write an 1D array of doubles.
        /// </summary>
        [TestMethod]
        public void WriteDouble2DArrayTest()
        {
            List<List<double>> values = new List<List<double>>
                {
                    new List<double>() { 1.5F, -2.0F, 1e21 },
                    new List<double>() { -10e100 },
                };

            BinaryWriterTest.ArrayHelper<double>(values, 2);
        }

        /// <summary>
        /// Writes string values.
        /// </summary>
        [TestMethod]
        public void WriteStringTest()
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

            byte[] expected = ms.ToArray();

            System.IO.MemoryStream output = new System.IO.MemoryStream();
            BinaryWriter writer = new BinaryWriter(output, BinaryWriterTest.CannedVersion);

            foreach (string s in testStrings)
            {
                writer.Write(string.Empty, s, false);
            }

            TestHelper.AssertCollectionEquals<byte>(expected, output.ToArray());
        }

        /// <summary>
        /// Write an 1D array of strings.
        /// </summary>
        [TestMethod]
        public void WriteString1DArrayTest()
        {
            List<string> values = new List<string>() { "foo", "bar" };

            BinaryWriterTest.ArrayHelper<string>(values, 1);
        }

        /// <summary>
        /// Write an 1D array of strings.
        /// </summary>
        [TestMethod]
        public void WriteString2DArrayTest()
        {
            List<List<string>> values = new List<List<string>>() 
                {                     
                    new List<string>() { "foo", "bar" }, 
                    new List<string>() { "no", "no", "and no" },
                };

            BinaryWriterTest.ArrayHelper<string>(values, 2);
        }

        /// <summary>
        /// Writes Enum values.
        /// </summary>
        [TestMethod]
        public void WriteEnumTest()
        {
            TestHelper.TestingEnumType[] testEnums = new TestHelper.TestingEnumType[] 
            { 
                TestHelper.TestingEnumType.EqualTo, 
                TestHelper.TestingEnumType.EvenLess, 
                TestHelper.TestingEnumType.GreaterThan, 
                TestHelper.TestingEnumType.LessThan 
            };

            // prepare test buffer
            // Enum         Test value      Encoded As     Encoded Bytes 
            //EqualTo       0               0              00000011
            //EvenLess      -2147483648     4294967295     11111111 11111111 11111111 11111111 00001111
            //GreaterThan   1               2              00000010
            //LessThan      -1              1              00000001
            byte[] expected = 
                { 
                    0x00,
                    0xFF, 0xFF, 0xFF, 0xFF, 0x0F,
                    0x02, 
                    0x01
                };            

            System.IO.MemoryStream output = new System.IO.MemoryStream();
            BinaryWriter writer = new BinaryWriter(output, BinaryWriterTest.CannedVersion);

            foreach (TestHelper.TestingEnumType e in testEnums)
            {
                writer.Write<TestHelper.TestingEnumType>(string.Empty, e);
            }

            TestHelper.AssertCollectionEquals<byte>(expected, output.ToArray());
        }

        /// <summary>
        /// Write an 1D array of Enum.
        /// </summary>
        [TestMethod]
        public void WriteEnum1DArrayTest()
        {
            List<TestHelper.TestingEnumType> values = new List<TestHelper.TestingEnumType>() { TestHelper.TestingEnumType.ReallyLow, TestHelper.TestingEnumType.EvenGreater };

            BinaryWriterTest.ArrayHelper<TestHelper.TestingEnumType>(values, 1);
        }

        /// <summary>
        /// Write an 2D array of Enum.
        /// </summary>
        [TestMethod]
        public void WriteEnum2DArrayTest()
        {
            List<List<TestHelper.TestingEnumType>> values = new List<List<TestHelper.TestingEnumType>>() 
                {                     
                    new List<TestHelper.TestingEnumType>() { TestHelper.TestingEnumType.ReallyLow, TestHelper.TestingEnumType.EvenGreater }, 
                    new List<TestHelper.TestingEnumType>() { TestHelper.TestingEnumType.GreaterThan, TestHelper.TestingEnumType.EvenGreater, TestHelper.TestingEnumType.ReallyGreater, TestHelper.TestingEnumType.EvenGreater },
                };

            BinaryWriterTest.ArrayHelper<TestHelper.TestingEnumType>(values, 2);
        }

        /// <summary>
        /// Writes a binary values.
        /// </summary>
        [TestMethod]
        public void WriteBinaryTest()
        {
            // Test binary object of length 10: 
            // { 0x01, 0x02, 0x32, 0x00, 0x23, 0x90, 0xFE, 0xA3, 0xB8, 0x99 }
            byte[] binary = new byte[] { 0x01, 0x02, 0x32, 0x00, 0x23, 0x90, 0xFE, 0xA3, 0xB8, 0x99 };

            byte[] expected = new SerializedStreamBuilder()
                .Binary(binary)
                .ToArray();

            System.IO.MemoryStream actual = new System.IO.MemoryStream();

            BinaryWriter writer = new BinaryWriter(actual, BinaryWriterTest.CannedVersion);
            writer.Write(string.Empty, binary, false);

            TestHelper.AssertCollectionEquals<byte>(expected, actual.ToArray());
        }

        /// <summary>
        /// Writes a binary values.
        /// </summary>
        [TestMethod]
        public void WriteBinaryArrayTest()
        {
            // Test binary object of length 10: 
            // { 0x01, 0x02, 0x32, 0x00, 0x23, 0x90, 0xFE, 0xA3, 0xB8, 0x99 }
            List<byte[]> binary = new List<byte[]>
            {   
                new byte[] { 0x01, 0x02, 0x32, 0x00, 0x23, 0x90, 0xFE, 0xA3, 0xB8, 0x99 },
                new byte[] { 0x01, 0x02 },
            };

            byte[] expected = new SerializedStreamBuilder()
                .Array<byte[]>(binary, false)
                .ToArray();

            System.IO.MemoryStream actual = new System.IO.MemoryStream();

            BinaryWriter writer = new BinaryWriter(actual, BinaryWriterTest.CannedVersion);
            writer.WriteBinaryArray(string.Empty, binary, false, 1);

            TestHelper.AssertCollectionEquals<byte>(expected, actual.ToArray());
        }

        /// <summary>
        /// Writes an object.
        /// </summary>
        [TestMethod]
        public void WriteObjectTest()
        {
            InnerClass innerClass = new InnerClass() { m_bool = true, m_double = 0.1, m_float = 150 };

            List<byte> expected = new List<byte>();
            expected.AddRange(BitConverter.GetBytes(innerClass.m_float));
            expected.AddRange(BitConverter.GetBytes(innerClass.m_double));
            expected.Add((byte)(innerClass.m_bool ? 0xD : 0x5));

            System.IO.MemoryStream actual = new System.IO.MemoryStream();

            BinaryWriter writer = new BinaryWriter(actual, BinaryWriterTest.CannedVersion);
            writer.Write(string.Empty, innerClass, false);

            TestHelper.AssertCollectionEquals<byte>(expected.ToArray(), actual.ToArray());
        }

        /// <summary>
        /// Writes a objects with nested object.
        /// </summary>
        [TestMethod]
        public void WriteNestedObjectTest()
        {
            SampleClass sampleClass = new SampleClass();
            sampleClass.m_int = 0;
            sampleClass.m_byte = 1;
            sampleClass.m_longarray = new List<long>() { 1, -2 };
            sampleClass.m_string = "test";
            sampleClass.m_obj = null;

            byte[] expected = new byte[] { 0x00, 0x01, 0x02, 0x02, 0x03, 0x04, 0x74, 0x65, 0x73, 0x74, 0x0D };
            
            System.IO.MemoryStream actual = new System.IO.MemoryStream();

            BinaryWriter writer = new BinaryWriter(actual, BinaryWriterTest.CannedVersion);
            sampleClass.Serialize(writer);

            TestHelper.AssertCollectionEquals<byte>(expected, actual.ToArray());
            
            sampleClass.m_obj = new InnerClass() { m_bool = true, m_double = 0.1, m_float = 150 };
            
            List<byte> lb = new List<byte> { 0x00, 0x01, 0x02, 0x02, 0x03, 0x04, 0x74, 0x65, 0x73, 0x74, 0x05 };
            lb.AddRange(BitConverter.GetBytes(sampleClass.m_obj.m_float));
            lb.AddRange(BitConverter.GetBytes(sampleClass.m_obj.m_double));
            lb.Add((byte)0xD);

            actual = new System.IO.MemoryStream();

            writer = new BinaryWriter(actual, BinaryWriterTest.CannedVersion);
            sampleClass.Serialize(writer);

            TestHelper.AssertCollectionEquals<byte>(lb.ToArray(), actual.ToArray());
        }

        /// <summary>
        /// Write a 1D array of objects.
        /// </summary>
        [TestMethod]
        public void WriteObject1DArrayTest()
        {
            List<InnerClass> values = new List<InnerClass>() 
                { 
                    new InnerClass() { m_bool = true, m_double = 0.1, m_float = 150 },
                    new InnerClass() { m_bool = false, m_double = 2.1, m_float = 150e5F },
                };

            SerializedStreamBuilder builder = new SerializedStreamBuilder()
                .Size((byte)2);

            foreach (InnerClass innerClass in values)
            {
                builder
                    .Float(innerClass.m_float)
                    .Double(innerClass.m_double)
                    .Boolean(innerClass.m_bool);
            }

            System.IO.MemoryStream actual = new System.IO.MemoryStream();

            BinaryWriter writer = new BinaryWriter(actual, BinaryWriterTest.CannedVersion);

            writer.WriteObjectArray<InnerClass>(string.Empty, values, false, 1);
            
            TestHelper.AssertCollectionEquals<byte>(builder.ToArray(), actual.ToArray());
        }

        /// <summary>
        /// Throws <see cref="ObjectDisposedException"/> when a boolean is written.
        /// </summary>
        [TestMethod]
        public void ThrowObjectDisposedOnWriteBooleanTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnWrite(new ObjectDisposedException("foo"), false);

            BinaryWriter writer = new BinaryWriter(actual, BinaryWriterTest.CannedVersion);

            TestHelper.ExpectException<TeslaSerializationException>(
                () =>
                {
                    writer.Write(string.Empty, true);
                },
                "Stream was closed during serialization.");
        }

        /// <summary>
        /// Throws <see cref="IOException"/> when a boolean is written.
        /// </summary>
        [TestMethod]
        public void ThrowIOExceptionOnWriteBooleanTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnWrite(new System.IO.IOException("foo"), false);

            BinaryWriter writer = new BinaryWriter(actual, BinaryWriterTest.CannedVersion);

            TestHelper.ExpectException<TeslaSerializationException>(
                () =>
                {
                    writer.Write(string.Empty, false);
                },
                "An IO error happened during serialization.");
        }

        /// <summary>
        /// Throws <see cref="ObjectDisposedException"/> when a string is written.
        /// </summary>
        [TestMethod]
        public void ThrowObjectDisposedOnWriteStringTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnWrite(new ObjectDisposedException("foo"), false);

            BinaryWriter writer = new BinaryWriter(actual, BinaryWriterTest.CannedVersion);

            TestHelper.ExpectException<TeslaSerializationException>(
                () =>
                {
                    writer.Write(string.Empty, "foo", false);
                },
                "Stream was closed during serialization.");
        }

        /// <summary>
        /// Throws <see cref="IOException"/> when a string is written.
        /// </summary>
        [TestMethod]
        public void ThrowIOExceptionOnWriteStringTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnWrite(new System.IO.IOException("foo"), false);

            BinaryWriter writer = new BinaryWriter(actual, BinaryWriterTest.CannedVersion);

            TestHelper.ExpectException<TeslaSerializationException>(
                () =>
                {
                    writer.Write(string.Empty, "foo", false);
                },
                "An IO error happened during serialization.");
        }

        /// <summary>
        /// Throws <see cref="ObjectDisposedException"/> when a byte is written.
        /// </summary>
        [TestMethod]
        public void ThrowObjectDisposedOnWriteByteTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnWrite(new ObjectDisposedException("foo"), false);

            BinaryWriter writer = new BinaryWriter(actual, BinaryWriterTest.CannedVersion);

            TestHelper.ExpectException<TeslaSerializationException>(
                () =>
                {
                    writer.Write(string.Empty, (byte)1);
                },
                "Stream was closed during serialization.");
        }

        /// <summary>
        /// Throws <see cref="IOException"/> when a byte is written.
        /// </summary>
        [TestMethod]
        public void ThrowIOExceptionOnWriteByteTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnWrite(new System.IO.IOException("foo"), false);

            BinaryWriter writer = new BinaryWriter(actual, BinaryWriterTest.CannedVersion);

            TestHelper.ExpectException<TeslaSerializationException>(
                () =>
                {
                    writer.Write(string.Empty, (byte)1);
                },
                "An IO error happened during serialization.");
        }

        /// <summary>
        /// Throws <see cref="ObjectDisposedException"/> when binary data is written.
        /// </summary>
        [TestMethod]
        public void ThrowObjectDisposedOnWriteBinaryTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnWrite(new ObjectDisposedException("foo"), true);

            BinaryWriter writer = new BinaryWriter(actual, BinaryWriterTest.CannedVersion);

            TestHelper.ExpectException<TeslaSerializationException>(
                () =>
                {
                    writer.Write(string.Empty, new byte[] { 0x1, 0x2, 0x3 }, false);
                },
                "Stream was closed during serialization.");
        }

        /// <summary>
        /// Throws <see cref="IOException"/> when binary data is written.
        /// </summary>
        [TestMethod]
        public void ThrowIOExceptionOnWriteBinaryTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnWrite(new System.IO.IOException("foo"), true);

            BinaryWriter writer = new BinaryWriter(actual, BinaryWriterTest.CannedVersion);

            TestHelper.ExpectException<TeslaSerializationException>(
                () =>
                {
                    writer.Write(string.Empty, new byte[] { 0x1, 0x2, 0x3 }, false);
                },
                "An IO error happened during serialization.");
        }

        /// <summary>
        /// Throws <see cref="ObjectDisposedException"/> when a float is written.
        /// </summary>
        [TestMethod]
        public void ThrowObjectDisposedOnWriteFloatTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnWrite(new ObjectDisposedException("foo"), false);

            BinaryWriter writer = new BinaryWriter(actual, BinaryWriterTest.CannedVersion);

            TestHelper.ExpectException<TeslaSerializationException>(
                () =>
                {
                    writer.Write(string.Empty, 1.1F);
                },
                "Stream was closed during serialization.");
        }

        /// <summary>
        /// Throws <see cref="IOException"/> when a float is written.
        /// </summary>
        [TestMethod]
        public void ThrowIOExceptionOnWriteFloatTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnWrite(new System.IO.IOException("foo"), false);

            BinaryWriter writer = new BinaryWriter(actual, BinaryWriterTest.CannedVersion);

            TestHelper.ExpectException<TeslaSerializationException>(
                () =>
                {
                    writer.Write(string.Empty, 2.1F);
                },
                "An IO error happened during serialization.");
        }

        /// <summary>
        /// Throws <see cref="ObjectDisposedException"/> when a double is written.
        /// </summary>
        [TestMethod]
        public void ThrowObjectDisposedOnWriteDoubleTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnWrite(new ObjectDisposedException("foo"), false);

            BinaryWriter writer = new BinaryWriter(actual, BinaryWriterTest.CannedVersion);

            TestHelper.ExpectException<TeslaSerializationException>(
                () =>
                {
                    writer.Write(string.Empty, 1e50);
                },
                "Stream was closed during serialization.");
        }

        /// <summary>
        /// Throws <see cref="IOException"/> when a double is written.
        /// </summary>
        [TestMethod]
        public void ThrowIOExceptionOnWriteDoubleTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnWrite(new System.IO.IOException("foo"), false);

            BinaryWriter writer = new BinaryWriter(actual, BinaryWriterTest.CannedVersion);

            TestHelper.ExpectException<TeslaSerializationException>(
                () =>
                {
                    writer.Write(string.Empty, 1e50);
                },
                "An IO error happened during serialization.");
        }

        /// <summary>
        /// Gets the name of the writer method.
        /// </summary>
        /// <param name="type">The type.</param>
        /// <returns>Reader method name.</returns>
        private static string GetWriterMethodName(Type type)
        {
            string prefix;

            if (type.IsEnum)
            {
                prefix = "Enum";
            }
            else if (Type.GetType("System.Single").Equals(type))
            {
                prefix = "Float";
            }
            else if (Type.GetType("System.Double").Equals(type))
            {
                prefix = "Double";
            }
            else if (Type.GetType("System.Byte[]").Equals(type))
            {
                prefix = "Binary";
            }
            else
            {
                prefix = type.ToString().Split('.')[1];
            }

            string methodName = string.Concat("Write", prefix, "Array");

            return methodName;
        }

        /// <summary>
        /// Helps test n-dimensional arrays.
        /// </summary>
        /// <typeparam name="T">Type of the underlying value stored in the array.</typeparam>
        /// <param name="values">The values.</param>
        /// <param name="rank">The rank.</param>
        private static void ArrayHelper<T>(ICollection values, uint rank)
        {
            BinaryWriterTest.ArrayHelper<T>(values, false, rank);
        }

        /// <summary>
        /// Writer Wrapper for TestHelper.GetMethodInfoFromName.
        /// </summary>
        /// <typeparam name="T">Type of the underlying value stored in the array.</typeparam>
        /// <param name="methodName">method name.</param>
        /// <param name="writer">The binary writer</param>
        private static MethodInfo GetWriterMethodInfoFromName<T>(string methodName, BinaryWriter writer)
        {
            Type readerwriterType = writer.GetType();
            Type[] paramslist = new Type[] { typeof(string), typeof(object), typeof(bool), typeof(uint) };

            return TestHelper.GetMethodInfoFromName<T>(methodName, readerwriterType, paramslist);
        }

        /// <summary>
        /// Helps test n-dimensional arrays.
        /// </summary>
        /// <typeparam name="T">Type of the underlying value stored in the array.</typeparam>
        /// <param name="values">The values.</param>
        /// <param name="nullable">If set to <c>true</c> [nullable].</param>
        /// <param name="rank">The rank.</param>
        private static void ArrayHelper<T>(ICollection values, bool nullable, uint rank)
        {
            System.IO.MemoryStream output = new System.IO.MemoryStream();

            BinaryWriter writer = new BinaryWriter(output, BinaryWriterTest.CannedVersion);

            string methodName = BinaryWriterTest.GetWriterMethodName(typeof(T));

            MethodInfo methodInfo = GetWriterMethodInfoFromName<T>(methodName, writer);

            methodInfo.Invoke(writer, new object[] { string.Empty, values, nullable, rank });

            byte[] expected = new SerializedStreamBuilder()
                .Array<T>(values, nullable)
                .ToArray();

            TestHelper.AssertCollectionEquals<byte>(expected, output.ToArray());
        }
    }
}
