/**
 * NotNullable.java
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
 * To tell the Tesla compiler that the annotated property is not nullable.
 * 
 * <p>
 * Example:
 * 
 * <pre>
 * 	{@literal @}NotNullable
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
 * 		<field name="" displayname="address" getter="getAddress" setter="setAddress" type="string" />
 * }
 * </pre>
 * 
 * @see Reference
 * @author Yunfei Zuo (yzuo@expedia.com)
 * 
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNullable {

}
