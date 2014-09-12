//--------------------------------------------------------------------------------------------------
// <copyright file="ISerializable.cs" company="Expedia">
//        Copyright (c) 2011 Expedia Inc.  All rights reserved.
// </copyright>
// <summary>
//        Tesla serialization interface. 
// </summary>
//--------------------------------------------------------------------------------------------------
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