//--------------------------------------------------------------------------------------------------
// <copyright file="TeslaSerializationException.cs" company="Expedia">
//        Copyright (c) 2011 Expedia Inc.  All rights reserved.
// </copyright>
// <summary>
//        Implementation of the TeslaSerializationException class.
// </summary>
//--------------------------------------------------------------------------------------------------
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