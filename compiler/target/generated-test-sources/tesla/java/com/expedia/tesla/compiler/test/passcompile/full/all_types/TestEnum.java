/**
 * TestEnum.java
 * 
 * This file is generated code by Tesla compiler. Please don't edit. 
 */

package com.expedia.tesla.compiler.test.passcompile.full.all_types;

import com.expedia.tesla.serialization.EnumMapper;

public enum TestEnum
{
    Info,
    Warning,
    Error;

    public final static EnumMapper<TestEnum> MAPPER = 
        new EnumMapper.Builder<TestEnum>()
            .add(Info, 1)
            .add(Warning, 2)
            .add(Error, 3)
            .build();
}