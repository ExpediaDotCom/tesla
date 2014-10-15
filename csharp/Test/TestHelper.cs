/*******************************************************************************
 * Copyright (c) 2014 Expedia Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

namespace TeslaTest
{
    using System;
    using System.Collections;
    using System.Collections.Generic;
    using System.Reflection;
    using Expedia.Tesla.Schema;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    /// <summary>
    /// Provides helper methods for testing.
    /// </summary>
    public static class TestHelper
    {

        /// <summary>
        /// Creates a MethodInfo based on the method name accounting for Enum types as well .
        /// </summary>
        /// <typeparam name="T">Type of the underlying value stored in the array.</typeparam>
        /// <param name="methodName">method name.</param>
        /// <param name="readerwriterType">The binary reader or writer Type</param>
        /// <param name="paramslist">Parameter Type list</param>
        public static MethodInfo GetMethodInfoFromName<T>(string methodName, Type readerwriterType, Type[] paramslist)
        {
            MethodInfo methodInfo;
            if (typeof(T).IsEnum)
            {
                MethodInfo generic = readerwriterType.GetMethod(methodName, paramslist);
                methodInfo = generic.MakeGenericMethod(typeof(T));
            }
            else
                methodInfo = readerwriterType.GetMethod(methodName);

            return methodInfo;
        }

        /// <summary>
        /// An Enum Type for unit testing round trip.
        /// </summary>
        public enum TestingEnumType { EvenLess = int.MinValue, ReallyLow = -32768, LessThan = -1, 
                                      EqualTo = 0,
                                      GreaterThan = 1, ReallyGreater = 32767, EvenGreater = int.MaxValue};

        /// <summary>
        /// Loops through all the values of any Enum type and returns as array with enums.
        /// </summary>
        public static T[] GetEnumValues<T>() where T : struct
        {
            if (!typeof(T).IsEnum)
            {
                throw new ArgumentException("GetValues<T> can only be called for types derived from System.Enum", "T");
            }
            return (T[])Enum.GetValues(typeof(T));
        }


        /// <summary>
        /// Expected schema version to be used for unit testing
        /// its value.
        /// </summary>
        public static SchemaVersion GetEexpectedVersion()
        {
            short CannedVersionNumber = 10;
            return new SchemaVersion((short)CannedVersionNumber);
        }

        /// <summary>
        /// Expects the supplied method to throw an <see cref="ArgumentException"/>
        /// exception when invoked with the exact given argument name. If no exception is thrown,
        /// if an exception of another type is thrown or if the message of the Expected
        /// exception mismatches the excepted argument name, an Assert.Fail statement will cause
        /// the test to fail.
        /// </summary>
        /// <param name="method">The method that's Expected to throw an exception.</param>
        /// <param name="argument">The argument.</param>
        public static void ExpectArgumentNullException(Action method, string argument)
        {
            TestHelper.ExpectException<ArgumentNullException>(method, "Value cannot be null.\r\nParameter name: {0}", argument);
        }

        /// <summary>
        /// Expects the supplied method to throw an <see cref="ArgumentException"/>
        /// exception when invoked with the exact given argument name. If no exception is thrown,
        /// if an exception of another type is thrown or if the message of the Expected
        /// exception mismatches the excepted argument name, an Assert.Fail statement will cause
        /// the test to fail.
        /// </summary>
        /// <param name="method">The method that's Expected to throw an exception.</param>
        /// <param name="argument">The argument.</param>
        public static void ExpectArgumentException(Action method, string argument)
        {
            TestHelper.ExpectException<ArgumentException>(method, argument);
        }

        /// <summary>
        /// Expects the supplied method to throw an exception of the specified
        /// type T when invoked. If no exception is thrown or if an exception of another type is thrown,
        /// an Assert.Fail statement will cause the test to fail.
        /// <para/>
        /// IMPORTANT: The actual message of the exception will not be checked. This facility should ONLY
        /// be used when the message is unimportant (e.g.: for canned CLR exceptions).
        /// </summary>
        /// <typeparam name="T">The type of <see cref="Exception"/> to expect.</typeparam>
        /// <param name="method">The method that's Expected to throw an exception.</param>
        public static void ExpectException<T>(Action method) where T : Exception
        {
            TestHelper.ExpectException<T>(method, null);
        }

        /// <summary>
        /// Expects the supplied method to throw an exception of the specified
        /// type T when invoked with the exact given message. If no exception is thrown, 
        /// if an exception of another type is thrown or if the message of the Expected
        /// exception mismatches the excepted value, an Assert.Fail statement will cause
        /// the test to fail.
        /// </summary>
        /// <typeparam name="T">The type of <see cref="Exception"/> to expect.</typeparam>
        /// <param name="method">The method that's Expected to throw an exception.</param>
        /// <param name="format">The format for the Expected message.</param>
        /// <param name="args">The args for the Expected message.</param>
        public static void ExpectException<T>(Action method, string format, params object[] args) where T : Exception
        {
            bool expectedExceptionThrown = false;

            try
            {
                try
                {
                    method();
                }
                catch (TargetInvocationException e)
                {
                    throw e.InnerException;
                }
            }
            catch (T e)
            {
                expectedExceptionThrown = true;

                if (format != null)
                {
                    string expected = format;

                    if (args.Length != 0)
                    {
                        expected = string.Format(format, args);
                    }

                    if (!string.Equals(e.Message, expected, StringComparison.InvariantCulture))
                    {
                        Assert.Fail("Expection '{0}' was encountered, but the expected message '{1}' does not match the actual message '{2}'.", typeof(T).Name, expected, e.Message);
                    }
                }
            }

            if (!expectedExceptionThrown)
            {
                Assert.Fail("'{0}' was expected but no exception was thrown.", typeof(T).Name);
            }
        }

        /// <summary>
        /// Asserts that the collections contain the same data in the same sequence.
        /// </summary>
        /// <typeparam name="T">Underlying type of the collection.</typeparam>
        /// <param name="expected">The expected collection.</param>
        /// <param name="actual">The actual collection.</param>
        public static void AssertCollectionEquals<T>(ICollection<T> expected, ICollection<T> actual)
        {
            if (expected == null && actual == null)
            {
                return;
            }

            Assert.IsNotNull(expected);
            Assert.IsNotNull(actual);
            
            Assert.AreEqual<int>(expected.Count, actual.Count, "The collections have different sizes.", expected.Count, actual.Count);

            using (IEnumerator<T> expectedEnumerator = expected.GetEnumerator())
            {
                using (IEnumerator<T> actualEnumerator = actual.GetEnumerator())
                {
                    uint entry = 1;

                    while (expectedEnumerator.MoveNext() && actualEnumerator.MoveNext())
                    {
                        Assert.AreEqual<T>(
                            expectedEnumerator.Current,
                            actualEnumerator.Current,
                            "Values do not match for entry #{0}.",
                            entry);

                        ++entry;
                    }
                }
            }
        }
    }
}
