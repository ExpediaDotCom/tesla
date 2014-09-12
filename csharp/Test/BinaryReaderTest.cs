namespace TeslaTest
{
    using System;
    using System.Collections.Generic;
    using System.Text;
    using Expedia.Tesla.Serialization;
    using Expedia.Tesla.Schema;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    /// <summary>
    /// This is a test class for BinaryReaderTest and is intended
    /// to contain all BinaryReaderTest Unit Tests.
    /// </summary>
    [TestClass]
    public class BinaryReaderTest
    {
        /// <summary>
        /// Validates the Expected Version.
        /// </summary>
        [TestMethod]
        public void VersionTest()
        {
            SchemaVersion expected = TestHelper.GetEexpectedVersion();

            SerializedStreamBuilder builder = new SerializedStreamBuilder();

            BinaryReader reader = new BinaryReader(builder.ToStream(), expected);

            Assert.AreEqual<short>(expected.getVersionNumber(), reader.Version.getVersionNumber());
        }

        /// <summary>
        /// Reads an invalid nullable flag.
        /// </summary>
        [TestMethod]
        public void ReadInvalidNullableTest()
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .RawByte(0xFF)
                .String("foo", null)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadString(string.Empty, true);
                },
                "Invalid boolean value: 255.");
        }

        /// <summary>
        /// Read a 1D array with null data.
        /// </summary>
        [TestMethod]
        public void ReadNull1DArrayTest()
        {
            DeserializationHelper.Array1DHelper<string>(null, true);
        }

        /// <summary>
        /// Read a zero-rank array.
        /// </summary>
        [TestMethod]
        public void ReadZeroRankArray()
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .Size(0)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            TestHelper.ExpectArgumentException(
                () =>
                {
                    reader.ReadBinaryArray(string.Empty, false, 0);
                },
                "rank");
        }

        /// <summary>
        /// Read an invalid array size.
        /// </summary>
        [TestMethod]
        public void ReadInvalidArraySize()
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .Int64(long.MaxValue)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadByteArray(string.Empty, false, 1);
                },
                "Invalid data was encountered in the stream. The stream is corrupted.");
        }

        /// <summary>
        /// Reads an object.
        /// </summary>
        [TestMethod]
        public void ReadObjectTest()
        {
            InnerClass expected = new InnerClass() { m_bool = true, m_double = 0.1, m_float = 150 };
            List<byte> lb = new List<byte>();
            lb.AddRange(BitConverter.GetBytes(expected.m_float));
            lb.AddRange(BitConverter.GetBytes(expected.m_double));
            lb.Add((byte)(expected.m_bool ? 0xD : 0x5));
            BinaryReader reader = new BinaryReader(lb.ToArray(), DeserializationHelper.CannedVersion);

            InnerClass actual = reader.ReadObject<InnerClass>(string.Empty, false);

            Assert.AreEqual<InnerClass>(expected, actual);
        }

        /// <summary>
        /// Reads an object with nested object.
        /// </summary>
        [TestMethod]
        public void ReadNestedObjectTest()
        {
            SampleClass expected = new SampleClass();
            expected.m_int = 0;
            expected.m_byte = 1;
            expected.m_longarray = new List<long>() { 1, -2 };
            expected.m_string = "test";
            expected.m_obj = null;

            byte[] buffer = new byte[] { 0x00, 0x01, 0x02, 0x02, 0x03, 0x04, 0x74, 0x65, 0x73, 0x74, 0x0D };
            SampleClass actual = new SampleClass();
            actual.Deserialize(new BinaryReader(buffer, DeserializationHelper.CannedVersion));

            Assert.AreEqual<SampleClass>(expected, actual);

            expected.m_obj = new InnerClass() { m_bool = true, m_double = 0.1, m_float = 150 };
            List<byte> lb = new List<byte> { 0x00, 0x01, 0x02, 0x02, 0x03, 0x04, 0x74, 0x65, 0x73, 0x74, 0x05 };
            lb.AddRange(BitConverter.GetBytes(expected.m_obj.m_float));
            lb.AddRange(BitConverter.GetBytes(expected.m_obj.m_double));
            lb.Add((byte)0xD);
            actual.Deserialize(new BinaryReader(lb.ToArray(), DeserializationHelper.CannedVersion));

            Assert.AreEqual<SampleClass>(expected, actual);
        }

        /// <summary>
        /// Read a 1D array of objects.
        /// </summary>
        [TestMethod]
        public void ReadObject1DArrayTest()
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

            BinaryReader reader = new BinaryReader(builder.ToStream(), DeserializationHelper.CannedVersion);
            
            List<InnerClass> actual = (List<InnerClass>)reader.ReadObjectArray<InnerClass>(string.Empty, false, 1);
            Assert.IsNotNull(actual);

            TestHelper.AssertCollectionEquals<InnerClass>(values, actual);
        }

        /// <summary>
        /// Throws <see cref="EndOfStreamException"/> when a boolean is read.
        /// </summary>
        [TestMethod]
        public void ThrowEndOfStreamOnReadBooleanTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnRead(new System.IO.EndOfStreamException("foo"), false);

            BinaryReader reader = new BinaryReader(actual, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadBoolean(string.Empty);
                },
                "The end of the stream is reached during deserialization.");
        }

        /// <summary>
        /// Throws <see cref="ObjectDisposedException"/> when a boolean is read.
        /// </summary>
        [TestMethod]
        public void ThrowObjectDisposedOnReadBooleanTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnRead(new ObjectDisposedException("foo"), false);

            BinaryReader reader = new BinaryReader(actual, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadBoolean(string.Empty);
                },
                "Stream was closed during deserialization.");
        }

        /// <summary>
        /// Throws <see cref="IOException"/> when a boolean is read.
        /// </summary>
        [TestMethod]
        public void ThrowIOExceptionOnReadBooleanTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnRead(new System.IO.IOException("foo"), false);

            BinaryReader reader = new BinaryReader(actual, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadBoolean(string.Empty);
                },
                "An IO error happened during deserialization.");
        }

        /// <summary>
        /// Throws <see cref="EndOfStreamException"/> when a string is read.
        /// </summary>
        [TestMethod]
        public void ThrowEndOfStreamOnReadStringTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnRead(new System.IO.EndOfStreamException("foo"), false);

            BinaryReader reader = new BinaryReader(actual, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadString(string.Empty, false);
                },
                "The end of the stream is reached during deserialization.");
        }

        /// <summary>
        /// Throws <see cref="ObjectDisposedException"/> when a string is read.
        /// </summary>
        [TestMethod]
        public void ThrowObjectDisposedOnReadStringTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnRead(new ObjectDisposedException("foo"), false);

            BinaryReader reader = new BinaryReader(actual, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadString(string.Empty, false);
                },
                "Stream was closed during deserialization.");
        }

        /// <summary>
        /// Throws <see cref="IOException"/> when a string is read.
        /// </summary>
        [TestMethod]
        public void ThrowIOExceptionOnReadStringTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnRead(new System.IO.IOException("foo"), false);

            BinaryReader reader = new BinaryReader(actual, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadString(string.Empty, false);
                },
                "An IO error happened during deserialization.");
        }

        /// <summary>
        /// Throws <see cref="EndOfStreamException"/> when a byte is read.
        /// </summary>
        [TestMethod]
        public void ThrowEndOfStreamOnReadByteTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnRead(new System.IO.EndOfStreamException("foo"), false);

            BinaryReader reader = new BinaryReader(actual, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadByte(string.Empty);
                },
                "The end of the stream is reached during deserialization.");
        }

        /// <summary>
        /// Throws <see cref="ObjectDisposedException"/> when a byte is read.
        /// </summary>
        [TestMethod]
        public void ThrowObjectDisposedOnReadByteTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnRead(new ObjectDisposedException("foo"), false);

            BinaryReader reader = new BinaryReader(actual, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadByte(string.Empty);
                },
                "Stream was closed during deserialization.");
        }

        /// <summary>
        /// Throws <see cref="IOException"/> when a byte is read.
        /// </summary>
        [TestMethod]
        public void ThrowIOExceptionOnReadByteTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnRead(new System.IO.IOException("foo"), false);

            BinaryReader reader = new BinaryReader(actual, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadByte(string.Empty);
                },
                "An IO error happened during deserialization.");
        }

        /// <summary>
        /// Throws <see cref="EndOfStreamException"/> when binary data is read.
        /// </summary>
        [TestMethod]
        public void ThrowEndOfStreamOnReadBinaryTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnRead(new System.IO.EndOfStreamException("foo"), true);

            BinaryReader reader = new BinaryReader(actual, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadBinary(string.Empty, false);
                },
                "The end of the stream is reached during deserialization.");
        }

        /// <summary>
        /// Throws <see cref="ObjectDisposedException"/> when binary data is read.
        /// </summary>
        [TestMethod]
        public void ThrowObjectDisposedOnReadBinaryTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnRead(new ObjectDisposedException("foo"), true);

            BinaryReader reader = new BinaryReader(actual, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadBinary(string.Empty, false);
                },
                "Stream was closed during deserialization.");
        }

        /// <summary>
        /// Throws <see cref="IOException"/> when binary data is read.
        /// </summary>
        [TestMethod]
        public void ThrowIOExceptionOnReadBinaryTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnRead(new System.IO.IOException("foo"), true);

            BinaryReader reader = new BinaryReader(actual, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadBinary(string.Empty, false);
                },
                "An IO error happened during deserialization.");
        }

        /// <summary>
        /// Throws <see cref="EndOfStreamException"/> when a float is read.
        /// </summary>
        [TestMethod]
        public void ThrowEndOfStreamOnReadFloatTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnRead(new System.IO.EndOfStreamException("foo"), false);

            BinaryReader reader = new BinaryReader(actual, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadFloat(string.Empty);
                },
                "The end of the stream is reached during deserialization.");
        }

        /// <summary>
        /// Throws <see cref="ObjectDisposedException"/> when a float is read.
        /// </summary>
        [TestMethod]
        public void ThrowObjectDisposedOnReadFloatTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnRead(new ObjectDisposedException("foo"), false);

            BinaryReader reader = new BinaryReader(actual, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadFloat(string.Empty);
                },
                "Stream was closed during deserialization.");
        }

        /// <summary>
        /// Throws <see cref="IOException"/> when a float is read.
        /// </summary>
        [TestMethod]
        public void ThrowIOExceptionOnReadFloatTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnRead(new System.IO.IOException("foo"), false);

            BinaryReader reader = new BinaryReader(actual, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadFloat(string.Empty);
                },
                "An IO error happened during deserialization.");
        }

        /// <summary>
        /// Throws <see cref="EndOfStreamException"/> when a double is read.
        /// </summary>
        [TestMethod]
        public void ThrowEndOfStreamOnReadDoubleTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnRead(new System.IO.EndOfStreamException("foo"), false);

            BinaryReader reader = new BinaryReader(actual, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadDouble(string.Empty);
                },
                "The end of the stream is reached during deserialization.");
        }

        /// <summary>
        /// Throws <see cref="ObjectDisposedException"/> when a double is read.
        /// </summary>
        [TestMethod]
        public void ThrowObjectDisposedOnReadDoubleTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnRead(new ObjectDisposedException("foo"), false);

            BinaryReader reader = new BinaryReader(actual, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadDouble(string.Empty);
                },
                "Stream was closed during deserialization.");
        }

        /// <summary>
        /// Throws <see cref="IOException"/> when a double is read.
        /// </summary>
        [TestMethod]
        public void ThrowIOExceptionOnReadDoubleTest()
        {
            System.IO.Stream actual = MockObjects.CreateMockStreamThrowsOnRead(new System.IO.IOException("foo"), false);

            BinaryReader reader = new BinaryReader(actual, DeserializationHelper.CannedVersion);

            TestHelper.ExpectException<TeslaDeserializationException>(
                () =>
                {
                    reader.ReadDouble(string.Empty);
                },
                "An IO error happened during deserialization.");
        }
    }    
}