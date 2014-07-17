/**
 * FieldName.java
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
 * The {@code @FieldName} can be used on public property getters to specify
 * Tesla field name for User defined Tesla objects. If this is not set, Tesla
 * will use the Java property name by default.
 * <p>
 * Example:
 * 
 * <pre>
 * 		<code>
 * 		{@literal @}FieldName("address")
 * 		{@literal @}DisplayName("Address")
 * 		public String getAddress() {
 * 			return this.address;
 * 		}
 * 
 * 		public void setAddress(String address) {
 * 			this.address = address;
 * 		}
 * 		</code>
 * </pre>
 * <p>
 * Tesla compiler will generate following Tesla schema
 * <p>
 * 
 * <pre>
 * {@code 
 * 		<field name="address" displayname="Address" getter="getAddress" setter="setAddress" type="string" />
 * }
 * </pre>
 * 
 * @see DisplayName
 * @author Yunfei Zuo (yzuo@expedia.com)
 * 
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldName {
	String value();
}
