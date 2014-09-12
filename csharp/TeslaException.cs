//--------------------------------------------------------------------------------------------------
// <copyright file="TeslaException.cs" company="Expedia">
//        Copyright (c) 2011 Expedia Inc.  All rights reserved.
// </copyright>
// <summary>
//        Implementation of the TeslaException class.
// </summary>
//--------------------------------------------------------------------------------------------------
namespace Expedia.Tesla.Serialization
{
    using System;

    /// <summary>
    /// The root Exception class of Tesla.
    /// </summary>
    public class TeslaException : Exception
    {
        /// <summary>
        /// Initializes a new instance of the TeslaException class.
        /// </summary>
        /// <param name="message">The message.</param>
        public TeslaException(string message)
            : base(message)
        {
        }

        /// <summary>
        /// Initializes a new instance of the TeslaException class.
        /// </summary>
        /// <param name="message">The message.</param>
        /// <param name="innerException">The exception that is the cause of the current exception</param>
        public TeslaException(string message, Exception innerException)
            : base(message, innerException)
        {
        }
    }
}