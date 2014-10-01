/**
 * Reference.java
 * 
 * Copyright 2013 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.expedia.tesla.schema.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * To tell the Tesla compiler that the annotated property is a reference.
 * 
 * <p>
 * Example:
 * 
 * <pre>
 * 	{@literal @}Reference
 * 		public String getAddress() {
 * 			return this.address;
 * 		}
 * 
 * 		public void setAddress(String address) {
 * 			this.address = address;
 * 		}
 * </pre>
 * 
 * Tesla compiler will generate following Tesla schema
 * <p>
 * 
 * <pre>
 * {@code 
 * 		<field name="" displayname="address" getter="getAddress" setter="setAddress" type="reference(string)" />
 * }
 * </pre>
 * 
 * @see Nullable
 * @author Yunfei Zuo (yzuo@expedia.com)
 * 
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Reference {

}
