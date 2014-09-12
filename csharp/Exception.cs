//==========================================================================
//
// Copyright (C) 2011, Expedia Inc.  All rights reserved.
//
// File:    ITeslaReader.cs
//
// Desc:    Tesla serialization library exceptions. 
//
// History:
//      11/14/2011     yzuo    Created
//
//==========================================================================
namespace Expedia.Tesla.Serialization
{
    using System;

    /// <summary>
    /// The root Exception class of Tesla.
    /// </summary>
    public class TeslaException : Exception
    {
        /// <summary>
        /// Constructor.
        /// </summary>
        /// <param name="message">The message.</param>
        public TeslaException(string message)
            : base(message)
        {
        }

        /// <summary>
        /// Constructor.
        /// </summary>
        /// <param name="message">The message.</param>
        /// <param name="innerException">The exception that is the cause of the current exception</param>
        public TeslaException(string message, Exception innerException)
            : base(message, innerException)
        {
        }
    }

    /// <summary>
    /// Error of Tesla serialization.
    /// </summary>
    public class TeslaSerializationException : TeslaException
    {
        /// <summary>
        /// Constructor.
        /// </summary>
        /// <param name="msg">Error message</param>
        public TeslaSerializationException(string msg)
            : base(msg)
        {
        }

        /// <summary>
        /// Constructor.
        /// </summary>
        /// <param name="msg">Error message</param>
        /// <param name="innerException">The exception that is the cause of the current exception</param>
        public TeslaSerializationException(string msg, Exception innerException)
            : base(msg, innerException)
        {
        }
    }

    /// <summary>
    /// Error of Tesla deserialization.
    /// </summary>
    public class TeslaDeserializationException : TeslaException
    {
        /// <summary>
        /// Constructor.
        /// </summary>
        /// <param name="msg">Error message</param>
        public TeslaDeserializationException(string msg)
            : base(msg)
        {
        }

        /// <summary>
        /// Constructor.
        /// </summary>
        /// <param name="msg">Error message</param>
        /// <param name="innerException">The exception that is the cause of the current exception</param>
        public TeslaDeserializationException(string msg, Exception innerException)
            : base(msg, innerException)
        {
        }
    }
}