/**
 * complexttypetest.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

 
package com.expedia.tesla.compiler.test.passcompile.full;

public class complexttypetest  {
    protected java.util.List<java.lang.String> field1;
    protected java.util.List<java.util.List<java.lang.String>> field2;
    protected java.util.List<java.util.List<java.util.List<java.lang.String>>> field3;
    protected java.util.List<java.lang.String> field4;
    protected java.util.List<java.lang.String> field5;

    public complexttypetest() {
    }

    public complexttypetest(
        java.util.List<java.lang.String> field1,
        java.util.List<java.util.List<java.lang.String>> field2,
        java.util.List<java.util.List<java.util.List<java.lang.String>>> field3,
        java.util.List<java.lang.String> field4,
        java.util.List<java.lang.String> field5) {
        getField1(field1);
        getField2(field2);
        getField3(field3);
        getField4(field4);
        getField5(field5);
    }

    
    public java.util.List<java.lang.String> getField1() {
        return this.field1;
    }

    public void getField1(java.util.List<java.lang.String> value) {
        this.field1 = value;
    }
    
    public java.util.List<java.util.List<java.lang.String>> getField2() {
        return this.field2;
    }

    public void getField2(java.util.List<java.util.List<java.lang.String>> value) {
        this.field2 = value;
    }
    
    public java.util.List<java.util.List<java.util.List<java.lang.String>>> getField3() {
        return this.field3;
    }

    public void getField3(java.util.List<java.util.List<java.util.List<java.lang.String>>> value) {
        this.field3 = value;
    }
    
    public java.util.List<java.lang.String> getField4() {
        return this.field4;
    }

    public void getField4(java.util.List<java.lang.String> value) {
        this.field4 = value;
    }
    
    public java.util.List<java.lang.String> getField5() {
        return this.field5;
    }

    public void getField5(java.util.List<java.lang.String> value) {
        this.field5 = value;
    }
    

    @java.lang.Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(this.field1)
                .append(this.field2)
                .append(this.field3)
                .append(this.field4)
                .append(this.field5)
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
        complexttypetest other = (complexttypetest) obj;
        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(this.field1, other.field1)
                .append(this.field2, other.field2)
                .append(this.field3, other.field3)
                .append(this.field4, other.field4)
                .append(this.field5, other.field5)
                .isEquals();
    }

    
}