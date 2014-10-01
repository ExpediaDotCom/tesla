/**
 * ReferenceArray.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

 
package com.expedia.tesla.compiler.test.passcompile.full.referencetest;

public class ReferenceArray  {
    protected java.util.List<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject> referenceArrayField;

    public ReferenceArray() {
    }

    public ReferenceArray(
        java.util.List<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject> referenceArrayField) {
        setReferenceArrayField(referenceArrayField);
    }

    
    public java.util.List<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject> getReferenceArrayField() {
        return this.referenceArrayField;
    }

    public void setReferenceArrayField(java.util.List<com.expedia.tesla.compiler.test.passcompile.full.referencetest.TestEmbeddedObject> value) {
        this.referenceArrayField = value;
    }
    

    @java.lang.Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(this.referenceArrayField)
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
        ReferenceArray other = (ReferenceArray) obj;
        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(this.referenceArrayField, other.referenceArrayField)
                .isEquals();
    }

    
}