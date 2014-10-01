/**
 * BasicTestObject.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

 
package com.expedia.tesla.compiler.test.passcompile.full.all_types;

public class BasicTestObject  {
    protected com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject objectField;
    protected com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum enumField;
    protected boolean boolField;
    protected byte byteField;
    protected short int16Field;
    protected short uInt16Field;
    protected int int32Field;
    protected int uInt32Field;
    protected long int64Field;
    protected long uInt64Field;
    protected float floatField;
    protected double doubleField;
    protected byte[] binaryField;
    protected java.lang.String stringField;

    public BasicTestObject() {
    }

    public BasicTestObject(
        com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject objectField,
        com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum enumField,
        boolean boolField,
        byte byteField,
        short int16Field,
        short uInt16Field,
        int int32Field,
        int uInt32Field,
        long int64Field,
        long uInt64Field,
        float floatField,
        double doubleField,
        byte[] binaryField,
        java.lang.String stringField) {
        setObjectField(objectField);
        setEnumField(enumField);
        setBoolField(boolField);
        setByteField(byteField);
        setInt16Field(int16Field);
        setUInt16Field(uInt16Field);
        setInt32Field(int32Field);
        setUInt32Field(uInt32Field);
        setInt64Field(int64Field);
        setUInt64Field(uInt64Field);
        setFloatField(floatField);
        setDoubleField(doubleField);
        setBinaryField(binaryField);
        setStringField(stringField);
    }

    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject getObjectField() {
        return this.objectField;
    }

    public void setObjectField(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEmbeddedObject value) {
        this.objectField = value;
    }
    
    public com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum getEnumField() {
        return this.enumField;
    }

    public void setEnumField(com.expedia.tesla.compiler.test.passcompile.full.all_types.TestEnum value) {
        this.enumField = value;
    }
    
    public boolean getBoolField() {
        return this.boolField;
    }

    public void setBoolField(boolean value) {
        this.boolField = value;
    }
    
    public byte getByteField() {
        return this.byteField;
    }

    public void setByteField(byte value) {
        this.byteField = value;
    }
    
    public short getInt16Field() {
        return this.int16Field;
    }

    public void setInt16Field(short value) {
        this.int16Field = value;
    }
    
    public short getUInt16Field() {
        return this.uInt16Field;
    }

    public void setUInt16Field(short value) {
        this.uInt16Field = value;
    }
    
    public int getInt32Field() {
        return this.int32Field;
    }

    public void setInt32Field(int value) {
        this.int32Field = value;
    }
    
    public int getUInt32Field() {
        return this.uInt32Field;
    }

    public void setUInt32Field(int value) {
        this.uInt32Field = value;
    }
    
    public long getInt64Field() {
        return this.int64Field;
    }

    public void setInt64Field(long value) {
        this.int64Field = value;
    }
    
    public long getUInt64Field() {
        return this.uInt64Field;
    }

    public void setUInt64Field(long value) {
        this.uInt64Field = value;
    }
    
    public float getFloatField() {
        return this.floatField;
    }

    public void setFloatField(float value) {
        this.floatField = value;
    }
    
    public double getDoubleField() {
        return this.doubleField;
    }

    public void setDoubleField(double value) {
        this.doubleField = value;
    }
    
    public byte[] getBinaryField() {
        return this.binaryField;
    }

    public void setBinaryField(byte[] value) {
        this.binaryField = value;
    }
    
    public java.lang.String getStringField() {
        return this.stringField;
    }

    public void setStringField(java.lang.String value) {
        this.stringField = value;
    }
    

    @java.lang.Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(this.objectField)
                .append(this.enumField)
                .append(this.boolField)
                .append(this.byteField)
                .append(this.int16Field)
                .append(this.uInt16Field)
                .append(this.int32Field)
                .append(this.uInt32Field)
                .append(this.int64Field)
                .append(this.uInt64Field)
                .append(this.floatField)
                .append(this.doubleField)
                .append(this.binaryField)
                .append(this.stringField)
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
        BasicTestObject other = (BasicTestObject) obj;
        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(this.objectField, other.objectField)
                .append(this.enumField, other.enumField)
                .append(this.boolField, other.boolField)
                .append(this.byteField, other.byteField)
                .append(this.int16Field, other.int16Field)
                .append(this.uInt16Field, other.uInt16Field)
                .append(this.int32Field, other.int32Field)
                .append(this.uInt32Field, other.uInt32Field)
                .append(this.int64Field, other.int64Field)
                .append(this.uInt64Field, other.uInt64Field)
                .append(this.floatField, other.floatField)
                .append(this.doubleField, other.doubleField)
                .append(this.binaryField, other.binaryField)
                .append(this.stringField, other.stringField)
                .isEquals();
    }

    
}