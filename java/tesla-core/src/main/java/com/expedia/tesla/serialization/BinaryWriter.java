/*******************************************************************************
 * Copyright (c) 2012-2013, Expedia, Inc.
 *
 * BinaryWriter.java
 *
 * Tesla binary serialization writer.
 ******************************************************************************/

package com.expedia.tesla.serialization;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;

import com.expedia.tesla.SchemaVersion;
import com.expedia.tesla.utils.BitConverter;
import com.expedia.tesla.utils.Unsigned;

/**
 * Encode basic type values in Tesla binary encoding.
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 */
public class BinaryWriter implements TeslaWriter, Closeable, Flushable {

	private static final Charset UTF8 = Charset.forName("UTF-8");

	private SchemaVersion version;
	private OutputStream stream;

	/**
	 * Instantiates a new binary writer.
	 * 
	 * @param stream
	 *            the output stream
	 * @param schemaHash
	 *            the schema hash
	 */
	public BinaryWriter(OutputStream stream, long schemaHash) {
		this(stream, new SchemaVersion(schemaHash));
	}

	/**
	 * Instantiates a new binary writer.
	 * 
	 * @param stream
	 *            output stream buffer
	 * @param version
	 *            schema version object
	 */
	public BinaryWriter(OutputStream stream, SchemaVersion version) {
		this.version = version;
		if (stream == null) {
			throw new IllegalArgumentException("stream");
		}
		this.stream = stream;
	}

	/**
	 * Get current schema version.
	 * 
	 * @return the version
	 */
	public SchemaVersion getVersion() {
		return version;
	}

	/**
	 * Close the underlying output stream.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void close() throws IOException {
		this.stream.close();
	}

	/**
	 * Flush the underlying output stream.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void flush() throws IOException {
		this.stream.flush();
	}

	/**
	 * Write a boolean value in Tesla binary encoded {@code boolean} value
	 * format.
	 * <p>
	 * In order to make it easier to detect corrupted data, the boolean value
	 * {@code true} is encoded in one byte {@value TeslaConstants.BOOLEAN_TRUE}
	 * and {@code false} is encoded in {@value TeslaConstants.BOOLEAN_FALSE}.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @exception IOException
	 *                On output error.
	 */
	public void writeBoolean(String name, boolean value) throws IOException {
		this.stream.write(value ? TeslaConstants.BOOLEAN_TRUE
				: TeslaConstants.BOOLEAN_FALSE);
	}

	/**
	 * Write a byte value in Tesla binary encoded {@code byte} value format.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @exception IOException
	 *                On output error.
	 */
	public void writeByte(String name, byte value) throws IOException {
		this.stream.write(Unsigned.toUByte(value));
	}

	/**
	 * Write a 16-bit integer value in Tesla binary encoded {@code int16} value format.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @exception IOException
	 *                On output error.
	 */
	public void writeInt16(String name, short value) throws IOException {
		this.writeVInt(((value << 1) ^ (value >> 15)) & 0xffff);
	}

	/**
	 * Write a 32-bit integer value in Tesla binary encoded {@code int32} value format.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @exception IOException
	 *                On output error.
	 */
	public void writeInt32(String name, int value) throws IOException {
		this.writeVInt(((value << 1) ^ (value >> 31)) & 0xffffffffL);
	}

	/**
	 * Write a 64-bit integer value in Tesla binary encoded {@code int64} value format.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @exception IOException
	 *                On output error.
	 */
	public void writeInt64(String name, long value) throws IOException {
		this.writeVInt((value << 1) ^ (value >> 63));
	}

	/**
	 * Write an unsigned 16-bit integer value in Tesla binary encoded {@code uint16} value format.
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
	 */
	public void writeUInt16(String name, short value) throws IOException {
		this.writeVInt(Unsigned.toUInt16(value));
	}

	/**
	 * Write an unsigned 32-bit integer value in Tesla binary encoded {@code uint32} value format.
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
	 */
	public void writeUInt32(String name, int value) throws IOException {
		this.writeVInt(Unsigned.toUInt32(value));
	}

	/**
	 * Write an unsigned 64-bit integer value in Tesla binary encoded {@code uint64} value format.
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
	 */
	public void writeUInt64(String name, long value) throws IOException {
		this.writeVInt(Unsigned.toUInt64(value));
	}

	/**
	 * Write a 32-bit floating point number in Tesla binary encoded {@code float} value format.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @exception IOException
	 *                On output error.
	 */
	public void writeFloat(String name, float value) throws IOException {
		this.stream.write(BitConverter.getBytes(value));
	}

	/**
	 * Write a 64-bit floating point number in Tesla binary encoded {@code double} value format.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @exception IOException
	 *                On output error.
	 */
	public void writeDouble(String name, double value) throws IOException {
		this.stream.write(BitConverter.getBytes(value));
	}

	/**
	 * Write a binary buffer in Tesla binary encoded {@code binary} value format.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @throws IOException On output error.
	 */
	public void writeBinary(String name, byte[] buffer)
			throws IOException {
		this.writeVInt(buffer.length);
		this.stream.write(buffer);
	}

	/**
	 * Write a string in Tesla binary encoded {@code string} value format.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @throws IOException On output error.
	 */
	public void writeString(String name, String value)
			throws TeslaSerializationException, IOException {
		final byte[] buffer = value.getBytes(UTF8);
		this.writeVInt(buffer.length);
		this.stream.write(buffer);
	}

	/**
	 * Write an enumeration value in Tesla binary encoded {@code enum} value format.
	 * 
	 * @param name
	 *            The name of current value.
	 * @param value
	 *            The value to write.
	 * 
	 * @throws IOException On output error.
	 */
	public <T extends Enum<T>> void writeEnum(String name, T value,
			EnumMapper<T> mapper) throws IOException {
		writeInt32(name, mapper.toInteger(value));
	}

	protected void writeVInt(BigInteger value) throws IOException {
		do {
			int lsb = value.intValue() & 0x7F;
			value = value.shiftRight(7);
			this.stream.write(lsb | (value.signum() == 0 ? 0 : 0x80));
		} while (value.signum() != 0);
	}

	protected void writeVInt(long value) throws IOException {
		do {
			int lsb = (int) (value & 0x7f);
			this.stream.write(lsb | ((value >>>= 7) == 0 ? 0 : 0x80));
		} while (value != 0);
	}

}
