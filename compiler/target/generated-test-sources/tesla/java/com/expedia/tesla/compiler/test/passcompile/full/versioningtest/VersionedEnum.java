/**
 * VersionedEnum.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

package com.expedia.tesla.compiler.test.passcompile.full.versioningtest;

import com.expedia.tesla.serialization.EnumMapper;

public enum VersionedEnum
{
    Value1,
    Value2,
    Value3,
    Value5,
    Value4;

    public final static EnumMapper<VersionedEnum> MAPPER = 
        new EnumMapper.Builder<VersionedEnum>()
            .add(Value1, 1)
            .add(Value2, 2)
            .add(Value3, 3)
            .add(Value5, 5)
            .add(Value4, 4)
            .build();
}