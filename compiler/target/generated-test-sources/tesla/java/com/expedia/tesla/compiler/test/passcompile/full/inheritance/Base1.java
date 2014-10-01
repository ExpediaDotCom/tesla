/**
 * Base1.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

 
package com.expedia.tesla.compiler.test.passcompile.full.inheritance;

public class Base1  {
    protected int int32Field;

    public Base1() {
    }

    public Base1(
        int int32Field) {
        setInt32Field(int32Field);
    }

    
    public int getInt32Field() {
        return this.int32Field;
    }

    public void setInt32Field(int value) {
        this.int32Field = value;
    }
    

    @java.lang.Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(this.int32Field)
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
        Base1 other = (Base1) obj;
        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(this.int32Field, other.int32Field)
                .isEquals();
    }

    
}