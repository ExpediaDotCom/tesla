/**
 *
 * SchemaVersion.cs
 *
 * Copyright 2013 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Expedia.Tesla.Schema
{

     /// <summary>
     /// Application schema version interface. An application schema is defined in a
     /// schema file (TML) file. Tesla use schema file hash internally as application
     /// schema version.
     /// 
     /// Tesla can easily detect schema mismatch by comparing schema file hash.
     /// However, it is not human friendly. This class gives more human friendly
     /// version alias. Tesla provide a following version alias:
     /// Version name: any string value. This is defined in TML file.
     /// Version number: an short integer number.
     /// TML file name: the name of TML file in which the schema is defined.
     /// </summary>
    public class SchemaVersion : IComparable<SchemaVersion>, ISchemaVersion
    {
	    private long schemaHash;
	    private short versionNumber;
	    private String name;
	    private String tmlFileName;

	    public SchemaVersion(long schemaHash, short versionNumber, String name, String tmlFileName)
	    {
		    this.name = name;
		    this.schemaHash = schemaHash;
		    this.versionNumber = versionNumber;
		    this.tmlFileName = tmlFileName;
	    }

	    public SchemaVersion(long schemaHash) : this(schemaHash, (short) 0, null, null)
        {

        }

        public SchemaVersion(short versionNumber) : this(versionNumber, versionNumber, null, null)
	    {
		    
	    }

	    public SchemaVersion(SchemaVersion version) : this(version.getSchemaHash(), version.getVersionNumber(), version.getName(), version.tmlFileName)	
	    {
		
        }

	    public String getName()
	    {
		    return name;
	    }

	    public String getTmlFileName()
	    {
		    return tmlFileName;
	    }

	    public short getVersionNumber()
	    {
		    return versionNumber;
	    }

        public long getSchemaHash()
	    {
		    return schemaHash;
	    }

        public override String ToString()
	    {
		    return String.Format("SchemaVersion name: %s, number: %d, hash: %d, tml: %s", name,
				    versionNumber, schemaHash, tmlFileName);
	    }

        public int CompareTo(SchemaVersion other)
        {
            long d = this.schemaHash - other.schemaHash;
            return d == 0 ? 0 : (d < 0 ? -1 : 1);
        }
    }

}