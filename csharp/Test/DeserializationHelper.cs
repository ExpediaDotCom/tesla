namespace TeslaTest
{
    using System;
    using System.Collections;
    using System.Collections.Generic;
    using System.Reflection;
    using Expedia.Tesla.Serialization;
    using Expedia.Tesla.Schema;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    /// <summary>
    /// This constains the deserialization helper methods.
    /// </summary>
    [TestClass]
    public class DeserializationHelper
    {
        /// <summary>
        /// A canned version to be used for streams when we don't care about
        /// its value.
        /// </summary>
        public const uint CannedVersionNumber = 13;
        public static SchemaVersion CannedVersion = new SchemaVersion((short)CannedVersionNumber);

        /// <summary>
        /// Helps test empty array cases for both nullable and non-nullable.
        /// </summary>
        /// <typeparam name="T">Underlying type of the array.</typeparam>
        public static void EmptyArrayHelper<T>()
        {
            DeserializationHelper.EmptyArrayHelper<T>(false);
            DeserializationHelper.EmptyArrayHelper<T>(true);
        }

        /// <summary>
        /// Reader Wrapper for TestHelper.GetMethodInfoFromName.
        /// </summary>
        /// <typeparam name="T">Type of the underlying value stored in the array.</typeparam>
        /// <param name="methodName">method name.</param>
        /// <param name="reader">The binary reader</param>
        private static MethodInfo GetReaderMethodInfoFromName<T>(string methodName, BinaryReader reader)
        {
            Type readerwriterType = reader.GetType();
            Type[] paramslist = new Type[] { typeof(string), typeof(bool), typeof(uint) };

            return TestHelper.GetMethodInfoFromName<T>(methodName, readerwriterType, paramslist);
        }

        /// <summary>
        /// Helps test empty arrays.
        /// </summary>
        /// <typeparam name="T">Type of the underlying value stored in the array.</typeparam>
        /// <param name="nullable">If set to <c>true</c> [nullable].</param>
        public static void EmptyArrayHelper<T>(bool nullable)
        {
            SerializedStreamBuilder builder = new SerializedStreamBuilder();

            if (nullable)
            {
                builder.NullableFlag(false);
            }
            
            System.IO.Stream stream = builder                
                .Size(0)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            for (uint rank = 1; rank <= 4; rank++)
            {
                string methodName = DeserializationHelper.GetReaderMethodName(typeof(T));

                MethodInfo methodInfo = GetReaderMethodInfoFromName<T>(methodName, reader);

                ICollection obj = (ICollection)methodInfo.Invoke(reader, new object[] { string.Empty, nullable, rank });
                Assert.AreEqual<int>(obj.Count, 0);

                stream.Seek(0L, System.IO.SeekOrigin.Begin);
            }
        }

        /// <summary>
        /// Helps test 1D arrays for both the nullable and non-nullable case.
        /// </summary>
        /// <typeparam name="T">Type of the underlying value stored in the array.</typeparam>
        /// <param name="values">The values.</param>
        public static void Array1DHelper<T>(List<T> values)
        {
            DeserializationHelper.Array1DHelper<T>(values, false);
            DeserializationHelper.Array1DHelper<T>(values, true);
        }

        /// <summary>
        /// Helps test 1D arrays.
        /// </summary>
        /// <typeparam name="T">Type of the underlying value stored in the array.</typeparam>
        /// <param name="values">The values.</param>
        /// <param name="nullable">If set to <c>true</c> [nullable].</param>
        public static void Array1DHelper<T>(List<T> values, bool nullable)
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .Array<T>(values, nullable)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            string methodName = DeserializationHelper.GetReaderMethodName(typeof(T));

            MethodInfo methodInfo = GetReaderMethodInfoFromName<T>(methodName, reader);

            List<T> actual = (List<T>)methodInfo.Invoke(reader, new object[] { string.Empty, nullable, 1U });

            if (values != null)
            {
                Assert.IsNotNull(actual);
            }
            else
            {
                Assert.IsNull(actual);
            }

            TestHelper.AssertCollectionEquals<T>(values, actual);
        }

        /// <summary>
        /// Gets the name of the reader method.
        /// </summary>
        /// <param name="type">The type.</param>
        /// <returns>Reader method name.</returns>
        public static string GetReaderMethodName(Type type)
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

            string methodName = string.Concat("Read", prefix, "Array");

            return methodName;
        }

        /// <summary>
        /// Helps test 2D arrays for both the nullable and non-nullable case.
        /// </summary>
        /// <typeparam name="T">Type of the underlying value stored in the array.</typeparam>
        /// <param name="values">The values.</param>
        public static void Array2DHelper<T>(List<List<T>> values)
        {
            DeserializationHelper.Array2DHelper<T>(values, false);
            DeserializationHelper.Array2DHelper<T>(values, true);
        }

        /// <summary>
        /// Helps test 2D arrays.
        /// </summary>
        /// <typeparam name="T">Type of the underlying value stored in the array.</typeparam>
        /// <param name="values">The values.</param>
        /// <param name="nullable">If set to <c>true</c> [nullable].</param>
        public static void Array2DHelper<T>(List<List<T>> values, bool nullable)
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .Array<T>(values, nullable)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            string methodName = DeserializationHelper.GetReaderMethodName(typeof(T));

            MethodInfo methodInfo = GetReaderMethodInfoFromName<T>(methodName, reader);

            List<List<T>> actual = (List<List<T>>)methodInfo.Invoke(reader, new object[] { string.Empty, nullable, 2U });
            Assert.IsNotNull(actual);
            
            using (IEnumerator<List<T>> valuesEnumerator = values.GetEnumerator())
            {
                using (IEnumerator<List<T>> actualEnumerator = actual.GetEnumerator())
                {
                    Assert.AreEqual<int>(values.Count, actual.Count);

                    while (valuesEnumerator.MoveNext() && actualEnumerator.MoveNext())
                    {
                        TestHelper.AssertCollectionEquals<T>(valuesEnumerator.Current, actualEnumerator.Current);
                    }
                }
            }
        }

        /// <summary>
        /// Helps test 3D arrays for both the nullable and non-nullable case.
        /// </summary>
        /// <typeparam name="T">Type of the underlying value stored in the array.</typeparam>
        /// <param name="values">The values.</param>
        public static void Array3DHelper<T>(List<List<List<T>>> values)
        {
            DeserializationHelper.Array3DHelper<T>(values, false);
            DeserializationHelper.Array3DHelper<T>(values, true);
        }

        /// <summary>
        /// Helps test 2D arrays.
        /// </summary>
        /// <typeparam name="T">Type of the underlying value stored in the array.</typeparam>
        /// <param name="values">The values.</param>
        /// <param name="nullable">If set to <c>true</c> [nullable].</param>
        public static void Array3DHelper<T>(List<List<List<T>>> values, bool nullable)
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .Array<T>(values, nullable)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            string methodName = DeserializationHelper.GetReaderMethodName(typeof(T));

            MethodInfo methodInfo = GetReaderMethodInfoFromName<T>(methodName, reader);

            List<List<List<T>>> actual = (List<List<List<T>>>)methodInfo.Invoke(reader, new object[] { string.Empty, nullable, 3U });
            Assert.IsNotNull(actual);                     

            using (IEnumerator<List<List<T>>> values2DEnumerator = values.GetEnumerator())
            {
                using (IEnumerator<List<List<T>>> actual2DEnumerator = actual.GetEnumerator())
                {
                    Assert.AreEqual<int>(values.Count, actual.Count);

                    while (values2DEnumerator.MoveNext() && actual2DEnumerator.MoveNext())
                    {
                        Assert.AreEqual<int>(values2DEnumerator.Current.Count, actual2DEnumerator.Current.Count);

                        using (IEnumerator<List<T>> valuesEnumerator = values2DEnumerator.Current.GetEnumerator())
                        {
                            using (IEnumerator<List<T>> actualEnumerator = actual2DEnumerator.Current.GetEnumerator())
                            {
                                while (valuesEnumerator.MoveNext() && actualEnumerator.MoveNext())
                                {
                                    TestHelper.AssertCollectionEquals<T>(valuesEnumerator.Current, actualEnumerator.Current);
                                }
                            }
                        }
                    }
                }
            }
        }

        /// <summary>
        /// Helps test 4D arrays for both the nullable and non-nullable case.
        /// </summary>
        /// <typeparam name="T">Type of the underlying value stored in the array.</typeparam>
        /// <param name="values">The values.</param>
        public static void Array4DHelper<T>(List<List<List<List<T>>>> values)
        {
            DeserializationHelper.Array4DHelper<T>(values, false);
            DeserializationHelper.Array4DHelper<T>(values, true);
        }

        /// <summary>
        /// Helps test 4D arrays.
        /// </summary>
        /// <typeparam name="T">Type of the underlying value stored in the array.</typeparam>
        /// <param name="values">The values.</param>
        /// <param name="nullable">If set to <c>true</c> [nullable].</param>
        public static void Array4DHelper<T>(List<List<List<List<T>>>> values, bool nullable)
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .Array<T>(values, nullable)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            string methodName = DeserializationHelper.GetReaderMethodName(typeof(T));

            MethodInfo methodInfo = GetReaderMethodInfoFromName<T>(methodName, reader);

            List<List<List<List<T>>>> actual = (List<List<List<List<T>>>>)methodInfo.Invoke(reader, new object[] { string.Empty, nullable, 4U });
            Assert.IsNotNull(actual);

            using (IEnumerator<List<List<List<T>>>> values3DEnumerator = values.GetEnumerator())
            {
                using (IEnumerator<List<List<List<T>>>> actual3DEnumerator = actual.GetEnumerator())
                {
                    Assert.AreEqual<int>(values.Count, actual.Count);

                    while (values3DEnumerator.MoveNext() && actual3DEnumerator.MoveNext())
                    {
                        using (IEnumerator<List<List<T>>> values2DEnumerator = values3DEnumerator.Current.GetEnumerator())
                        {
                            using (IEnumerator<List<List<T>>> actual2DEnumerator = actual3DEnumerator.Current.GetEnumerator())
                            {
                                Assert.AreEqual<int>(values3DEnumerator.Current.Count, actual3DEnumerator.Current.Count);

                                while (values2DEnumerator.MoveNext() && actual2DEnumerator.MoveNext())
                                {
                                    Assert.AreEqual<int>(values2DEnumerator.Current.Count, actual2DEnumerator.Current.Count);

                                    using (IEnumerator<List<T>> valuesEnumerator = values2DEnumerator.Current.GetEnumerator())
                                    {
                                        using (IEnumerator<List<T>> actualEnumerator = actual2DEnumerator.Current.GetEnumerator())
                                        {
                                            while (valuesEnumerator.MoveNext() && actualEnumerator.MoveNext())
                                            {
                                                TestHelper.AssertCollectionEquals<T>(valuesEnumerator.Current, actualEnumerator.Current);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        /// <summary>
        /// Helps test binary data.
        /// </summary>
        /// <param name="values">The values.</param>
        /// <param name="nullable">If set to <c>true</c> [nullable].</param>
        public static void BinaryHelper(byte[] values, bool nullable)
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .Array<byte>(values, nullable)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            byte[] actual = reader.ReadBinary(string.Empty, nullable);

            if (values != null)
            {
                Assert.IsNotNull(actual);
            }
            else
            {
                Assert.IsNull(actual);
            }

            TestHelper.AssertCollectionEquals<byte>(values, actual);
        }

        /// <summary>
        /// Helps test binary arrays for both the non-nullable and nullable case.
        /// </summary>
        /// <param name="values">The values.</param>
        public static void BinaryArrayHelper(List<byte[]> values)
        {
            DeserializationHelper.BinaryArrayHelper(values, false);
            DeserializationHelper.BinaryArrayHelper(values, true);
        }

        /// <summary>
        /// Helps test binary arrays.
        /// </summary>
        /// <param name="values">The values.</param>
        /// <param name="nullable">If set to <c>true</c> [nullable].</param>
        public static void BinaryArrayHelper(List<byte[]> values, bool nullable)
        {
            System.IO.Stream stream = new SerializedStreamBuilder()
                .Array<byte>(values, nullable)
                .ToStream();

            BinaryReader reader = new BinaryReader(stream, DeserializationHelper.CannedVersion);

            List<byte[]> actual = (List<byte[]>)reader.ReadBinaryArray(string.Empty, nullable, 1);
            Assert.IsNotNull(actual);

            using (IEnumerator<byte[]> valuesEnumerator = values.GetEnumerator())
            {
                using (IEnumerator<byte[]> actualEnumerator = actual.GetEnumerator())
                {
                    Assert.AreEqual<int>(values.Count, actual.Count);

                    while (valuesEnumerator.MoveNext() && actualEnumerator.MoveNext())
                    {
                        TestHelper.AssertCollectionEquals<byte>(valuesEnumerator.Current, actualEnumerator.Current);
                    }
                }
            }
        }
    }    
}
