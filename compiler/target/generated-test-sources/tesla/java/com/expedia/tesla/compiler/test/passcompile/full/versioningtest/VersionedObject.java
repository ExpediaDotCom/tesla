/**
 * VersionedObject.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

 
package com.expedia.tesla.compiler.test.passcompile.full.versioningtest;

public class VersionedObject  {
    protected com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum enumField;
    protected java.lang.Integer depricatedInt32Field;
    protected java.lang.Long newInt64Field;

    public VersionedObject() {
    }

    public VersionedObject(
        com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum enumField,
        java.lang.Integer depricatedInt32Field,
        java.lang.Long newInt64Field) {
        setEnumField(enumField);
        setDepricatedInt32Field(depricatedInt32Field);
        setNewInt64Field(newInt64Field);
    }

    
    public com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum getEnumField() {
        return this.enumField;
    }

    public void setEnumField(com.expedia.tesla.compiler.test.passcompile.full.versioningtest.VersionedEnum value) {
        this.enumField = value;
    }
    
    public java.lang.Integer getDepricatedInt32Field() {
        return this.depricatedInt32Field;
    }

    public void setDepricatedInt32Field(java.lang.Integer value) {
        this.depricatedInt32Field = value;
    }
    
    public java.lang.Long getNewInt64Field() {
        return this.newInt64Field;
    }

    public void setNewInt64Field(java.lang.Long value) {
        this.newInt64Field = value;
    }
    

    @java.lang.Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(this.enumField)
                .append(this.depricatedInt32Field)
                .append(this.newInt64Field)
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
        VersionedObject other = (VersionedObject) obj;
        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(this.enumField, other.enumField)
                .append(this.depricatedInt32Field, other.depricatedInt32Field)
                .append(this.newInt64Field, other.newInt64Field)
                .isEquals();
    }

    
}