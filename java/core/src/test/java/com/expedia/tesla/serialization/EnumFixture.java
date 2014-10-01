/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * ByteFixture.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

import java.util.Arrays;
import java.util.List;

/**
 * Test fixture values for enum tests.
 * 
 * @author yzuo
 */
public interface EnumFixture extends Int32Fixture {
	static enum Int {
		Min, Max, Negative, Positive;

		public static EnumMapper<Int> MAPPER = new EnumMapper.Builder<Int>()
				.add(Min, MIN_VALUE).add(Max, MAX_VALUE)
				.add(Negative, NEGATIVE_VALUE).add(Positive, POSITIVE_VALUE)
				.build();
	}

	static final List<Int> ARRAY_VALUES = Arrays.asList(Int.Min, Int.Max,
			Int.Negative, Int.Positive);
}
