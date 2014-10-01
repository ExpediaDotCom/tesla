/**
 * MultiDerived.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

 
package com.expedia.tesla.compiler.test.passcompile.full.inheritance;

public class MultiDerived  {
    protected int int32Field;
    protected short int16Field;
    protected byte byteField;

    public MultiDerived() {
    }

    public MultiDerived(
        int int32Field,
        short int16Field,
        byte byteField) {
        setInt32Field(int32Field);
        setInt16Field(int16Field);
        setByteField(byteField);
    }

    
    public int getInt32Field() {
        return this.int32Field;
    }

    public void setInt32Field(int value) {
        this.int32Field = value;
    }
    
    public short getInt16Field() {
        return this.int16Field;
    }

    public void setInt16Field(short value) {
        this.int16Field = value;
    }
    
    public byte getByteField() {
        return this.byteField;
    }

    public void setByteField(byte value) {
        this.byteField = value;
    }
    

    @java.lang.Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(this.int32Field)
                .append(this.int16Field)
                .append(this.byteField)
                .toHashCode();
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MultiDerived other = (MultiDerived) obj;
        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(this.int32Field, other.int32Field)
                .append(this.int16Field, other.int16Field)
                .append(this.byteField, other.byteField)
                .isEquals();
    }

    
}