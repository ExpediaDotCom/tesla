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
namespace Expedia.Tesla.Serialization
{
    using System;

    /// <summary>
    /// Tesla Serialization Exception.
    /// </summary>
    public class TeslaSerializationException : TeslaException
    {
        /// <summary>
        /// Initializes a new instance of the TeslaSerializationException class.
        /// </summary>
        /// <param name="msg">Error message</param>
        public TeslaSerializationException(string msg)
            : base(msg)
        {
        }

        /// <summary>
        /// Initializes a new instance of the TeslaSerializationException class.
        /// </summary>
        /// <param name="msg">Error message</param>
        /// <param name="innerException">The exception that is the cause of the current exception</param>
        public TeslaSerializationException(string msg, Exception innerException)
            : base(msg, innerException)
        {
        }
    }
}