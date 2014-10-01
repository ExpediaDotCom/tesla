/*******************************************************************************
 * Copyright (c) 2013, Expedia, Inc.
 *
 * BooleanRoundTripTest.java
 ******************************************************************************/
package com.expedia.tesla.serialization;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Generic round-trip serialization tests for Boolean values. Implement
 * getWriter and getReader to instantiate this test suite.
 * 
 * @author dheld
 */
public abstract class BooleanRoundTripTemplate extends BaseRoundTripTemplate
		implements BooleanFixture {
	public BooleanRoundTripTemplate(RoundTripFactory factory) {
		super(factory);
	}

	@Test
	public void writeReadBoolean_False_Succeeds() throws Exception {
		this.getWriter().writeBoolean(null, FALSE_VALUE);
		assertEquals(FALSE_VALUE, this.getReader().readBoolean(null));
	}

	@Test
	public void writeReadBoolean_True_Succeeds() throws Exception {
		this.getWriter().writeBoolean(null, TRUE_VALUE);
		assertEquals(TRUE_VALUE, this.getReader().readBoolean(null));
	}
}
