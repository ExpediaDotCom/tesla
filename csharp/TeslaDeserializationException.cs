//--------------------------------------------------------------------------------------------------
// <copyright file="TeslaDeserializationException.cs" company="Expedia">
//        Copyright (c) 2011 Expedia Inc.  All rights reserved.
// </copyright>
// <summary>
//        Implementation of the TeslaDeserializationException class.
// </summary>
//--------------------------------------------------------------------------------------------------
namespace Expedia.Tesla.Serialization
{
    using System;

    /// <summary>
    /// Tesla Deserialization Exception.
    /// </summary>
    public class TeslaDeserializationException : TeslaException
    {
        /// <summary>
        /// Initializes a new instance of the TeslaDeserializationException class.
        /// </summary>
        /// <param name="msg">Error message</param>
        public TeslaDeserializationException(string msg)
            : base(msg)
        {
        }

        /// <summary>
        /// Initializes a new instance of the TeslaDeserializationException class.
        /// </summary>
        /// <param name="msg">Error message</param>
        /// <param name="innerException">The exception that is the cause of the current exception</param>
        public TeslaDeserializationException(string msg, Exception innerException)
            : base(msg, innerException)
        {
        }
    }
}