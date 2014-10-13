﻿/*******************************************************************************
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
    /// <summary>
    /// ISerializable defines the basic object serialization interface. All classes that designed to be serialized 
    /// with Tesla are supposed to implement this interface.
    /// </summary>
    public interface ISerializable
    {
        /// <summary>
        /// Serialize the object.
        /// </summary>
        /// <param name="writer">A TeslaWriter to which the serialized object data will be written.</param>
        void Serialize(ITeslaWriter writer);

        /// <summary>
        /// Deserialize the object
        /// </summary>
        /// <param name="reader">A TeslaReader from which the data of this object will be read.</param>
        void Deserialize(ITeslaReader reader);
    }
}