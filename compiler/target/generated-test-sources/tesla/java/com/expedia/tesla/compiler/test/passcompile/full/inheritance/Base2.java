/**
 * Base2.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

 
package com.expedia.tesla.compiler.test.passcompile.full.inheritance;

public class Base2  {
    protected short int16Field;

    public Base2() {
    }

    public Base2(
        short int16Field) {
        setInt16Field(int16Field);
    }

    
    public short getInt16Field() {
        return this.int16Field;
    }

    public void setInt16Field(short value) {
        this.int16Field = value;
    }
    

    @java.lang.Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(this.int16Field)
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
        Base2 other = (Base2) obj;
        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(this.int16Field, other.int16Field)
                .isEquals();
    }

    
}