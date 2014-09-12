namespace TeslaTest
{
    using System.Collections.Generic;
    using Expedia.Tesla.Serialization;
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Expedia.Tesla.Schema;
    using System;

    /// <summary>
    /// This is a test class for round-trip tests.
    /// </summary>
    [TestClass]
    public class RoundtripTest
    {
        /// <summary>
        /// A canned version to be used for streams when we don't care about
        /// its value.
        /// </summary>
        public const uint CannedVersionNumber = 13;
        public static SchemaVersion CannedVersion = new SchemaVersion((short)CannedVersionNumber);

        /// <summary>
        /// Roundtrips a nullable string.
        /// </summary>
        [TestMethod]
        public void NullableStringTest()
        {
            System.IO.MemoryStream stream = new System.IO.MemoryStream();

            BinaryWriter writer = new BinaryWriter(stream, RoundtripTest.CannedVersion);

            const string Expected = "foo";

            writer.Write(string.Empty, Expected, true);

            stream.Seek(0L, System.IO.SeekOrigin.Begin);

            BinaryReader reader = new BinaryReader(stream, RoundtripTest.CannedVersion);

            string actual = reader.ReadString(string.Empty, true);

            Assert.AreEqual<string>(Expected, actual);
        }

        /// <summary>
        /// Roundtrips a null string.
        /// </summary>
        [TestMethod]
        public void NullStringTest()
        {
            System.IO.MemoryStream stream = new System.IO.MemoryStream();

            BinaryWriter writer = new BinaryWriter(stream, RoundtripTest.CannedVersion);

            writer.Write(string.Empty, (string)null, true);

            stream.Seek(0L, System.IO.SeekOrigin.Begin);

            BinaryReader reader = new BinaryReader(stream, RoundtripTest.CannedVersion);

            string actual = reader.ReadString(string.Empty, true);

            Assert.IsNull(actual);
        }

        /// <summary>
        /// Roundtrips an object.
        /// </summary>
        [TestMethod]
        public void ObjectTest()
        {
            InnerClass expected = new InnerClass() { m_bool = true, m_double = 0.1, m_float = 150 };

            System.IO.MemoryStream stream = new System.IO.MemoryStream();
            BinaryWriter writer = new BinaryWriter(stream, RoundtripTest.CannedVersion);

            expected.Serialize(writer);

            stream.Seek(0L, System.IO.SeekOrigin.Begin);

            BinaryReader reader = new BinaryReader(stream, RoundtripTest.CannedVersion);
                        
            InnerClass actual = new InnerClass();
            actual.Deserialize(reader);

            Assert.AreEqual<InnerClass>(expected, actual);
        }
        
        /// <summary>
        /// Roundtrips a nested object.
        /// </summary>
        [TestMethod]
        public void NestedObjectTest()
        {            
            SampleClass expected = new SampleClass();
            expected.m_int = 0;
            expected.m_byte = 1;
            expected.m_longarray = new List<long>() { 1, -2 };
            expected.m_string = "test";
            expected.m_obj = new InnerClass() { m_bool = true, m_double = 0.1, m_float = 150 };

            System.IO.MemoryStream stream = new System.IO.MemoryStream();
            BinaryWriter writer = new BinaryWriter(stream, RoundtripTest.CannedVersion);

            expected.Serialize(writer);

            stream.Seek(0L, System.IO.SeekOrigin.Begin);

            BinaryReader reader = new BinaryReader(stream, RoundtripTest.CannedVersion);

            SampleClass actual = new SampleClass();
            actual.Deserialize(reader);

            Assert.AreEqual<SampleClass>(expected, actual);
        }

        /// <summary>
        /// Roundtrips a enum with all enum values as a lis
        /// </summary>
        [TestMethod]
        public void TotalEnumRoundTripTest()
        {
            System.IO.MemoryStream stream = new System.IO.MemoryStream();

            BinaryWriter writer = new BinaryWriter(stream, RoundtripTest.CannedVersion);

            TestHelper.TestingEnumType[] Expected = TestHelper.GetEnumValues<TestHelper.TestingEnumType>();

            foreach (var item in Expected)
            {
                writer.Write<TestHelper.TestingEnumType>(string.Empty, item);
            }

            stream.Seek(0L, System.IO.SeekOrigin.Begin);

            BinaryReader reader = new BinaryReader(stream, RoundtripTest.CannedVersion);

            TestHelper.TestingEnumType[] actual = new TestHelper.TestingEnumType[Expected.Length];

            for(int i = 0; i < actual.Length; i++)
            {
                actual[i] = reader.ReadEnum<TestHelper.TestingEnumType>(string.Empty);
            }

            TestHelper.AssertCollectionEquals<TestHelper.TestingEnumType>(Expected, actual);
        }

        /// <summary>
        /// Roundtrips a enum with all enum values as a lis
        /// </summary>
        [TestMethod]
        public void TotalEnumArrayRoundTripTest()
        {
            System.IO.MemoryStream stream = new System.IO.MemoryStream();

            BinaryWriter writer = new BinaryWriter(stream, RoundtripTest.CannedVersion);

            List<TestHelper.TestingEnumType> ExpectedEnums = new List<TestHelper.TestingEnumType>
            { 
                TestHelper.TestingEnumType.EqualTo, 
                TestHelper.TestingEnumType.EvenLess, 
                TestHelper.TestingEnumType.GreaterThan, 
                TestHelper.TestingEnumType.LessThan 
            };

            writer.WriteEnumArray<TestHelper.TestingEnumType>(string.Empty, ExpectedEnums, true);
            writer.WriteEnumArray<TestHelper.TestingEnumType>(string.Empty, ExpectedEnums, false);
            
            stream.Seek(0L, System.IO.SeekOrigin.Begin);

            BinaryReader reader = new BinaryReader(stream, RoundtripTest.CannedVersion);

            List<TestHelper.TestingEnumType> actualEnums = (List<TestHelper.TestingEnumType>)reader.ReadEnumArray<TestHelper.TestingEnumType>(string.Empty, true);
            TestHelper.AssertCollectionEquals<TestHelper.TestingEnumType>(ExpectedEnums, actualEnums);

            actualEnums = (List<TestHelper.TestingEnumType>)reader.ReadEnumArray<TestHelper.TestingEnumType>(string.Empty, false);
            TestHelper.AssertCollectionEquals<TestHelper.TestingEnumType>(ExpectedEnums, actualEnums);
        }

    }
}
