//--------------------------------------------------------------------------------------------------
// <copyright file="ISchemaVersion.cs" company="Expedia">
//        Copyright (c) 2013 Expedia Inc.  All rights reserved.
// </copyright>
// <summary>
//        Tesla Schema versioning interface.
// </summary>
//--------------------------------------------------------------------------------------------------

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Expedia.Tesla.Schema
{

    /// <summary>
    /// Application schema version interface.
      
    ///  Tesla V1 use one TML file to define all versions. The schema is versioned by
    ///  a 16 bit integer value. You can specify a min/max version number for each
    ///  class or field definition.
     
    ///   Tesla V2 use totally different verioning system. Each application schema
    ///   version is defined in its own TML file. Once the version is shipped, it can't
    ///   be changed. A new version of the same objects is defined in a different copy
    ///   of TML file. Tesla compiler will merge all versions for you automatically
    ///   when the TML files are compiled. Meanwhile, compiler will generate a hash
    ///   value for each schema version. This hash value will be used to validate the
    ///   schema when it is serializing/deserializing an object.
    /// </summary>
    public interface ISchemaVersion
    {
	    /**
	    * Get the schema hash.
	    * 
	    * @return schema hash
	    */
	    long getSchemaHash();
    }

}
