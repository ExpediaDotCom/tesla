/**
 * TestObject.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

 
package com.expedia.tesla.compiler.test.passcompile.full.all_types;

public class TestObject  {
    protected com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject basicTestObjectField;
    protected com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject referenceTestObjectField;
    protected com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject optionalBasicTestObjectField;
    protected com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject arrayTestObjectField;
    protected com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject array2DTestObjectField;
    protected com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject optionalArrayTestObjectField;

    public TestObject() {
    }

    public TestObject(
        com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject basicTestObjectField,
        com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject referenceTestObjectField,
        com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject optionalBasicTestObjectField,
        com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject arrayTestObjectField,
        com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject array2DTestObjectField,
        com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject optionalArrayTestObjectField) {
        setBasicTestObjectField(basicTestObjectField);
        setReferenceTestObjectField(referenceTestObjectField);
        setOptionalBasicTestObjectField(optionalBasicTestObjectField);
        setArrayTestObjectField(arrayTestObjectField);
        setArray2DTestObjectField(array2DTestObjectField);
        setOptionalArrayTestObjectField(optionalArrayTestObjectField);
    }

    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject getBasicTestObjectField() {
        return this.basicTestObjectField;
    }

    public void setBasicTestObjectField(com.expedia.tesla.compiler.test.passcompile.full.all_types.BasicTestObject value) {
        this.basicTestObjectField = value;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject getReferenceTestObjectField() {
        return this.referenceTestObjectField;
    }

    public void setReferenceTestObjectField(com.expedia.tesla.compiler.test.passcompile.full.all_types.ReferenceTestObject value) {
        this.referenceTestObjectField = value;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject getOptionalBasicTestObjectField() {
        return this.optionalBasicTestObjectField;
    }

    public void setOptionalBasicTestObjectField(com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalBasicTestObject value) {
        this.optionalBasicTestObjectField = value;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject getArrayTestObjectField() {
        return this.arrayTestObjectField;
    }

    public void setArrayTestObjectField(com.expedia.tesla.compiler.test.passcompile.full.all_types.ArrayTestObject value) {
        this.arrayTestObjectField = value;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject getArray2DTestObjectField() {
        return this.array2DTestObjectField;
    }

    public void setArray2DTestObjectField(com.expedia.tesla.compiler.test.passcompile.full.all_types.Array2DTestObject value) {
        this.array2DTestObjectField = value;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject getOptionalArrayTestObjectField() {
        return this.optionalArrayTestObjectField;
    }

    public void setOptionalArrayTestObjectField(com.expedia.tesla.compiler.test.passcompile.full.all_types.OptionalArrayTestObject value) {
        this.optionalArrayTestObjectField = value;
    }
    

    @java.lang.Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(this.basicTestObjectField)
                .append(this.referenceTestObjectField)
                .append(this.optionalBasicTestObjectField)
                .append(this.arrayTestObjectField)
                .append(this.array2DTestObjectField)
                .append(this.optionalArrayTestObjectField)
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
        TestObject other = (TestObject) obj;
        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(this.basicTestObjectField, other.basicTestObjectField)
                .append(this.referenceTestObjectField, other.referenceTestObjectField)
                .append(this.optionalBasicTestObjectField, other.optionalBasicTestObjectField)
                .append(this.arrayTestObjectField, other.arrayTestObjectField)
                .append(this.array2DTestObjectField, other.array2DTestObjectField)
                .append(this.optionalArrayTestObjectField, other.optionalArrayTestObjectField)
                .isEquals();
    }

    
}