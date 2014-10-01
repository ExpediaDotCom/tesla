/**
 * BinaryReference.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

 
package com.expedia.tesla.compiler.test.passcompile.full.referencetest;

public class BinaryReference  {
    protected byte[] referenceField1;
    protected byte[] referenceField2;

    public BinaryReference() {
    }

    public BinaryReference(
        byte[] referenceField1,
        byte[] referenceField2) {
        setReferenceField1(referenceField1);
        setReferenceField2(referenceField2);
    }

    
    public byte[] getReferenceField1() {
        return this.referenceField1;
    }

    public void setReferenceField1(byte[] value) {
        this.referenceField1 = value;
    }
    
    public byte[] getReferenceField2() {
        return this.referenceField2;
    }

    public void setReferenceField2(byte[] value) {
        this.referenceField2 = value;
    }
    

    @java.lang.Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(this.referenceField1)
                .append(this.referenceField2)
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
        BinaryReference other = (BinaryReference) obj;
        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(this.referenceField1, other.referenceField1)
                .append(this.referenceField2, other.referenceField2)
                .isEquals();
    }

    
}