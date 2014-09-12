using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Expedia.Tesla.Serialization;

namespace TeslaTest
{
    class InnerClass : ISerializable
    {
        public float m_float;
        public double m_double;
        public bool m_bool;

        public void Serialize(ITeslaWriter writer)
        {
            writer.WriteObjectBegin("InnerClass");
            writer.Write("m_float", m_float);
            writer.Write("m_double", m_double);
            writer.Write("m_bool", m_bool);
            writer.WriteObjectEnd("InnerClass");
        }

        public void Deserialize(ITeslaReader reader)
        {
            reader.ReadObjectBegin("InnerClass");
            m_float = reader.ReadFloat("m_float");
            m_double = reader.ReadDouble("m_double");
            m_bool = reader.ReadBoolean("m_bool");
            reader.ReadObjectEnd("InnerClass");
        }

        public static bool operator== (InnerClass a, InnerClass b)
        {
            if (!Object.ReferenceEquals(a, null))
                return a.Equals(b);
            else if (Object.ReferenceEquals(a, null) && Object.ReferenceEquals(b, null))
                return true;
            else
                return false;
        }

        public static bool operator !=(InnerClass a, InnerClass b)
        {
            return !(a == b);
        }

        public override bool Equals(System.Object obj)
        {
            // If parameter is null return false.
            if (obj == null)
            {
                return false;
            }

            // If parameter cannot be cast to Point return false.
            InnerClass b = obj as InnerClass;
            if ((System.Object)b == null)
            {
                return false;
            }

            // Return true if the fields match:
            return (Math.Abs(this.m_float - b.m_float) < 1E-25) && (Math.Abs(this.m_double - b.m_double) < 1E-25) && (this.m_bool == b.m_bool);
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }
    }

    class SampleClass : ISerializable
    {
        public int m_int;
        public byte m_byte;
        public List<long> m_longarray;
        public string m_string;
        public InnerClass m_obj;

        public void Serialize(ITeslaWriter writer)
        {
            writer.WriteObjectBegin("SampleClass");
            writer.Write("m_int", m_int);
            writer.Write("m_byte", m_byte);
            writer.WriteInt64Array("m_longarray", m_longarray, false, 1);
            writer.Write("m_string", m_string, false);
            writer.Write("m_obj", m_obj, true);
            writer.WriteObjectEnd("SampleClass");
        }

        public void Deserialize(ITeslaReader reader)
        {
            reader.ReadObjectBegin("SampleClass");
            m_int = reader.ReadInt32("m_int");
            m_byte = reader.ReadByte("m_byte");
            m_longarray = (List<long>)reader.ReadInt64Array("m_longarray", false, 1);
            m_string = reader.ReadString("m_string", false);
            m_obj = reader.ReadObject<InnerClass>("m_obj", true);
            reader.ReadObjectEnd("SampleClass");
        }

        public static bool operator== (SampleClass a, SampleClass b)
        {
            if (!Object.ReferenceEquals(a, null))
                return a.Equals(b);
            else if (Object.ReferenceEquals(a, null) && Object.ReferenceEquals(b, null))
                return true;
            else
                return false;
        }

        public static bool operator !=(SampleClass a, SampleClass b)
        {
            return !(a == b);
        }

        public override bool Equals(System.Object obj)
        {
            // If parameter is null return false.
            if (obj == null)
            {
                return false;
            }

            // If parameter cannot be cast to Point return false.
            SampleClass b = obj as SampleClass;
            if ((System.Object)b == null)
            {
                return false;
            }

            // Return true if the fields match:
            return (this.m_int == b.m_int) && (this.m_byte == b.m_byte) && (this.m_string == b.m_string)
                && Enumerable.SequenceEqual<long>(this.m_longarray, b.m_longarray) && (this.m_obj == b.m_obj);
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }
    }
}
