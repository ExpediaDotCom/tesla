/**
 * TypeId.java
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
 * Use Tesla type id to define field type for a Java property. Tesla type id is
 * a string representation of Tesla type, which consists of primitive types,
 * classes, enums, array, nullable, reference.
 * 
 * <p>
 * Example:
 * 
 * <pre>
 * 	{@literal @}TypeId({@code "nullable<reference<string>>"})
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
 * 		<field name="" displayname="address" getter="getAddress" setter="setAddress" 
 * 			type="nullable(reference(string))" />
 * }
 * </pre>
 * 
 * @see Nullable
 * @author Yunfei Zuo (yzuo@expedia.com)
 * 
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeId {
	String value();
}
