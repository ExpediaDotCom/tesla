/**
 * TestEmbeddedObject.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

 
package com.expedia.tesla.compiler.test.passcompile.full.all_types;

public class TestEmbeddedObject  {
    protected int intField;

    public TestEmbeddedObject() {
    }

    public TestEmbeddedObject(
        int intField) {
        setIntField(intField);
    }

    
    public int getIntField() {
        return this.intField;
    }

    public void setIntField(int value) {
        this.intField = value;
    }
    

    @java.lang.Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(this.intField)
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
        TestEmbeddedObject other = (TestEmbeddedObject) obj;
        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(this.intField, other.intField)
                .isEquals();
    }

    
}