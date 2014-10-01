/**
 * SingleDerived.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

 
package com.expedia.tesla.compiler.test.passcompile.full.inheritance;

public class SingleDerived extends com.expedia.tesla.compiler.test.passcompile.full.inheritance.Base1 {
    protected boolean booleanField;

    public SingleDerived() {
    }

    public SingleDerived(
        int int32Field,
        boolean booleanField) {
        setInt32Field(int32Field);
        setBooleanField(booleanField);
    }

    
    public boolean getBooleanField() {
        return this.booleanField;
    }

    public void setBooleanField(boolean value) {
        this.booleanField = value;
    }
    

    @java.lang.Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(this.int32Field)
                .append(this.booleanField)
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
        SingleDerived other = (SingleDerived) obj;
        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(this.int32Field, other.int32Field)
                .append(this.booleanField, other.booleanField)
                .isEquals();
    }

    
}