/*******************************************************************************
 * Copyright (c) 2012-2014, Expedia, Inc.
 *
 * BinaryReader.java
 *
 * Tesla binary serialization reader.
 ******************************************************************************/

package com.expedia.tesla.serialization;

import java.io.Closeable;
import java.io.IOException;

import com.expedia.tesla.SchemaVersion;
import com.expedia.tesla.utils.Unsigned;

/**
 * Read basic Tesla encoded values defined in Tesla specification.
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 */
public interface TeslaReader extends Closeable {

	/**
	 * Get current Tesla schema version.
	 * 
	 * @return the version
	 */
	public SchemaVersion getVersion();
	
	/**
	 * Read a Tesla binary encoded {@code boolean} value.
	 * 
	 * @param name
	 *            The name of current value.
	 * 
	 * @return The decoded value.
	 * 
	 * @exception IOException
	 *                On input error.
	 * @exception TeslaDeserializationException
	 *                When the data can't be decoded to current value type, or
	 *                the end of stream/buffer is reached.
	 */
	public boolean readBoolean(String name) throws IOException,
			TeslaDeserializationException;

	/**
	 * Read a Tesla binary encoded {@code byte} value.
	 * 
	 * @param name
	 *            The name of current value.
	 * 
	 * @return The decoded value.
	 * 
	 * @exception IOException
	 *                On input error.
	 * @exception TeslaDeserializationException
	 *                When the data can't be decoded to current value type, or
	 *                the end of stream/buffer is reached.
	 */
	public byte readByte(String name) throws IOException,
			TeslaDeserializationException;

	/**
	 * Read a Tesla binary encoded {@code int16} value.
	 * 
	 * @param name
	 *            The name of current value.
	 * 
	 * @return The decoded value.
	 * 
	 * @exception IOException
	 *                On input error.
	 * @exception TeslaDeserializationException
	 *                When the data can't be decoded to current value type, or
	 *                the end of stream/buffer is reached.
	 */
	public short readInt16(String name) throws IOException,
			TeslaDeserializationException;

	/**
	 * Read a Tesla binary encoded {@code int32} value.
	 * 
	 * @param name
	 *            The name of current value.
	 * 
	 * @return The decoded value.
	 * 
	 * @exception IOException
	 *                On input error.
	 * @exception TeslaDeserializationException
	 *                When the data can't be decoded to current value type, or
	 *                the end of stream/buffer is reached.
	 */
	public int readInt32(String name) throws IOException,
			TeslaDeserializationException;

	/**
	 * Read a Tesla binary encoded {@code int64} value.
	 * 
	 * @param name
	 *            The name of current value.
	 * 
	 * @return The decoded value.
	 * 
	 * @exception IOException
	 *                On input error.
	 * @exception TeslaDeserializationException
	 *                When the data can't be decoded to current value type, or
	 *                the end of stream/buffer is reached.
	 */
	public long readInt64(String name) throws IOException,
			TeslaDeserializationException;

	/**
	 * Read a Tesla binary encoded {@code uint16} value.
	 * <p>
	 * <b>Note:</b> Java has no unsigned integers. Unsigned integers are
	 * represented using their signed counterparts, with the sign bit of the
	 * sign integer being used to store highest bit. Tesla provides a helper
	 * class {@link Unsigned} that promotes the returned signed integer values
	 * to wider integer types.
	 * 
	 * @param name
	 *            The name of current value.
	 * 
	 * @return The decoded value.
	 * 
	 * @exception IOException
	 *                On input error.
	 * @exception TeslaDeserializationException
	 *                When the data can't be decoded to current value type, or
	 *                the end of stream/buffer is reached.
	 */
	public short readUInt16(String name) throws IOException,
			TeslaDeserializationException;

	/**
	 * Read a Tesla binary encoded {@code uint32} value.
	 * <p>
	 * <b>Note:</b> Java has no unsigned integers. Unsigned integers are
	 * represented using their signed counterparts, with the sign bit of the
	 * sign integer being used to store highest bit. Tesla provides a helper
	 * class {@link Unsigned} that promotes the returned signed integer values
	 * to wider integer types.
	 * 
	 * @param name
	 *            The name of current value.
	 * 
	 * @return The decoded value.
	 * 
	 * @exception IOException
	 *                On input error.
	 * @exception TeslaDeserializationException
	 *                When the data can't be decoded to current value type, or
	 *                the end of stream/buffer is reached.
	 */
	public int readUInt32(String name) throws IOException,
			TeslaDeserializationException;

	/**
	 * Read a Tesla binary encoded {@code uint64} value.
	 * <p>
	 * <b>Note:</b> Java has no unsigned integers. Unsigned integers are
	 * represented using their signed counterparts, with the sign bit of the
	 * sign integer being used to store highest bit. Tesla provides a helper
	 * class {@link Unsigned} that promotes the returned signed integer values
	 * to wider integer types.
	 * 
	 * @param name
	 *            The name of current value.
	 * 
	 * @return The decoded value.
	 * 
	 * @exception IOException
	 *                On input error.
	 * @exception TeslaDeserializationException
	 *                When the data can't be decoded to current value type, or
	 *                the end of stream/buffer is reached.
	 */
	public long readUInt64(String name) throws IOException,
			TeslaDeserializationException;

	/**
	 * Read a Tesla binary encoded {@code float} value.
	 * 
	 * @param name
	 *            The name of current value.
	 * 
	 * @return The decoded value.
	 * 
	 * @exception IOException
	 *                On input error.
	 * @exception TeslaDeserializationException
	 *                When the data can't be decoded to current value type, or
	 *                the end of stream/buffer is reached.
	 */
	public float readFloat(String name) throws IOException,
			TeslaDeserializationException;

	/**
	 * Read a Tesla binary encoded {@code double} value.
	 * 
	 * @param name
	 *            The name of current value.
	 * 
	 * @return The decoded value.
	 * 
	 * @exception IOException
	 *                On input error.
	 * @exception TeslaDeserializationException
	 *                When the data can't be decoded to current value type, or
	 *                the end of stream/buffer is reached.
	 */
	public double readDouble(String name) throws IOException,
			TeslaDeserializationException;

	/**
	 * Read a Tesla binary encoded {@code binary} value.
	 * 
	 * @param name
	 *            The name of current value.
	 * 
	 * @return The decoded value.
	 * 
	 * @exception IOException
	 *                On input error.
	 * @exception TeslaDeserializationException
	 *                When the data can't be decoded to current value type, or
	 *                the end of stream/buffer is reached.
	 */
	public byte[] readBinary(String name) throws TeslaDeserializationException,
			IOException;

	/**
	 * Read a Tesla binary encoded {@code string} value.
	 * 
	 * @param name
	 *            The name of current value.
	 * 
	 * @return The decoded value.
	 * 
	 * @exception IOException
	 *                On input error.
	 * @exception TeslaDeserializationException
	 *                When the data can't be decoded to current value type, or
	 *                the end of stream/buffer is reached.
	 */
	public String readString(String name)
			throws TeslaDeserializationException, IOException;

	/**
	 * Read a Tesla binary encoded {@code enum} value.
	 * 
	 * @param name
	 *            The name of current value.
	 * 
	 * @return The decoded value.
	 * 
	 * @exception IOException
	 *                On input error.
	 * @exception TeslaDeserializationException
	 *                When the data can't be decoded to current value type, or
	 *                the end of stream/buffer is reached.
	 */
	public <T extends Enum<T>> T readEnum(String name, EnumMapper<T> mapper)
			throws TeslaDeserializationException, IOException;
}
