/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * BinaryWriter.java
 *
 * Tesla binary serialization writer.
 ******************************************************************************/

package com.expedia.tesla.serialization;

import java.io.IOException;

import com.expedia.tesla.SchemaVersion;

/**
 * Encode basic type values.
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 */
public interface TeslaWriter {

	/**
	 * Get current schema version.
	 * 
	 * @return the version
	 */
	public SchemaVersion getVersion();

	/**
	 * Write a boolean value in Tesla encoded {@code boolean} value format.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @exception IOException
	 *                On output error.
	 * @exception TeslaSerializationException
	 *                On Tesla encoding error.
	 */
	public void writeBoolean(String name, boolean value) throws IOException,
			TeslaSerializationException;

	/**
	 * Write a byte value in Tesla encoded {@code byte} value format.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @exception IOException
	 *                On output error.
	 * @exception TeslaSerializationException
	 *                On Tesla encoding error.
	 */
	public void writeByte(String name, byte value) throws IOException,
			TeslaSerializationException;

	/**
	 * Write a 16-bit integer value in Tesla encoded {@code int16} value format.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @exception IOException
	 *                On output error.
	 * @exception TeslaSerializationException
	 *                On Tesla encoding error.
	 */
	public void writeInt16(String name, short value) throws IOException,
			TeslaSerializationException;

	/**
	 * Write a 32-bit integer value in Tesla encoded {@code int32} value format.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @exception IOException
	 *                On output error.
	 * @exception TeslaSerializationException
	 *                On Tesla encoding error.
	 */
	public void writeInt32(String name, int value) throws IOException;

	/**
	 * Write a 64-bit integer value in Tesla encoded {@code int64} value format.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @exception IOException
	 *                On output error.
	 * @exception TeslaSerializationException
	 *                On Tesla encoding error.
	 */
	public void writeInt64(String name, long value) throws IOException;

	/**
	 * Write an unsigned 16-bit integer value in Tesla encoded {@code uint16}
	 * value format.
	 * <p>
	 * <b>Note:</b> Java has no unsigned integers. Unsigned integers are
	 * represented using their signed counterparts, with the sign bit of the
	 * sign integer being used to store highest bit. Tesla provides a helper
	 * class {@link Unsigned} that promotes the returned signed integer values
	 * to wider integer types and convert between them.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @exception IOException
	 *                On output error.
	 * @exception TeslaSerializationException
	 *                On Tesla encoding error.
	 */
	public void writeUInt16(String name, short value) throws IOException;

	/**
	 * Write an unsigned 32-bit integer value in Tesla encoded {@code uint32}
	 * value format.
	 * <p>
	 * <b>Note:</b> Java has no unsigned integers. Unsigned integers are
	 * represented using their signed counterparts, with the sign bit of the
	 * sign integer being used to store highest bit. Tesla provides a helper
	 * class {@link Unsigned} that promotes the returned signed integer values
	 * to wider integer types and convert between them.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @exception IOException
	 *                On output error.
	 * @exception TeslaSerializationException
	 *                On Tesla encoding error.
	 */
	public void writeUInt32(String name, int value) throws IOException;

	/**
	 * Write an unsigned 64-bit integer value in Tesla encoded {@code uint64}
	 * value format.
	 * <p>
	 * <b>Note:</b> Java has no unsigned integers. Unsigned integers are
	 * represented using their signed counterparts, with the sign bit of the
	 * sign integer being used to store highest bit. Tesla provides a helper
	 * class {@link Unsigned} that promotes the returned signed integer values
	 * to wider integer types and convert between them.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @exception IOException
	 *                On output error.
	 * @exception TeslaSerializationException
	 *                On Tesla encoding error.
	 */
	public void writeUInt64(String name, long value) throws IOException;

	/**
	 * Write a 32-bit floating point number in Tesla encoded {@code float} value
	 * format.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @exception IOException
	 *                On output error.
	 * @exception TeslaSerializationException
	 *                On Tesla encoding error.
	 */
	public void writeFloat(String name, float value) throws IOException;

	/**
	 * Write a 64-bit floating point number in Tesla encoded {@code double}
	 * value format.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @exception IOException
	 *                On output error.
	 * @exception TeslaSerializationException
	 *                On Tesla encoding error.
	 */
	public void writeDouble(String name, double value) throws IOException;

	/**
	 * Write a binary buffer in Tesla encoded {@code binary} value format.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @throws IOException
	 *             On output error.
	 * @exception TeslaSerializationException
	 *                On Tesla encoding error.
	 */
	public void writeBinary(String name, byte[] buffer) throws IOException;

	/**
	 * Write a string in Tesla encoded {@code string} value format.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @throws IOException
	 *             On output error.
	 * @exception TeslaSerializationException
	 *                On Tesla encoding error.
	 */
	public void writeString(String name, String value)
			throws TeslaSerializationException, IOException;

	/**
	 * Write an enumeration value in Tesla encoded {@code enum} value format.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @throws IOException
	 *             On output error.
	 * @exception TeslaSerializationException
	 *                On Tesla encoding error.
	 */
	public <T extends Enum<T>> void writeEnum(String name, T value,
			EnumMapper<T> mapper) throws IOException;

}
