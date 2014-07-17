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

import com.expedia.tesla.ISchemaVersion;
import com.expedia.tesla.SchemaVersion;
import com.expedia.tesla.utils.BitConverter;
import com.expedia.tesla.utils.Unsigned;

/**
 * The Class BinaryWriter.
 * 
 * @see com.expedia.tesla.serialization.ITeslaWriter
 */
public class BinaryWriter implements Closeable, Flushable {
	private static final Charset UTF8 = Charset.forName("UTF-8");

	private ISchemaVersion version;
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
	public BinaryWriter(OutputStream stream, ISchemaVersion version) {
		this.version = version;
		if (stream == null) {
			throw new IllegalArgumentException("stream");
		}
		this.stream = stream;
	}

	/**
	 * @return the version
	 */
	public ISchemaVersion getVersion() {
		return version;
	}

	@Override
	public void close() throws IOException {
		this.stream.close();
	}

	@Override
	public void flush() throws IOException {
		this.stream.flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaWriter#writeBoolean(java.lang.String
	 * , boolean)
	 */
	public void writeBoolean(String name, boolean value) throws IOException {
		this.stream.write(value ? TeslaConstants.BOOLEAN_TRUE
				: TeslaConstants.BOOLEAN_FALSE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaWriter#writeByte(java.lang.String,
	 * byte)
	 */
	public void writeByte(String name, byte value) throws IOException {
		this.stream.write(Unsigned.toUByte(value));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaWriter#writeInt16(java.lang.String,
	 * short)
	 */
	public void writeInt16(String name, short value) throws IOException {
		this.writeVInt(((value << 1) ^ (value >> 15)) & 0xffff);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaWriter#writeInt32(java.lang.String,
	 * int)
	 */
	public void writeInt32(String name, int value) throws IOException {
		this.writeVInt(((value << 1) ^ (value >> 31)) & 0xffffffffL);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaWriter#writeInt64(java.lang.String,
	 * long)
	 */
	public void writeInt64(String name, long value) throws IOException {
		this.writeVInt((value << 1) ^ (value >> 63));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaWriter#writeUInt16(java.lang.String
	 * , int)
	 */
	public void writeUInt16(String name, short value) throws IOException {
		this.writeVInt(Unsigned.toUInt16(value));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaWriter#writeUInt32(java.lang.String
	 * , long)
	 */
	public void writeUInt32(String name, int value) throws IOException {
		this.writeVInt(Unsigned.toUInt32(value));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaWriter#writeUInt64(java.lang.String
	 * , java.math.BigInteger)
	 */
	public void writeUInt64(String name, long value) throws IOException {
		this.writeVInt(Unsigned.toUInt64(value));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaWriter#writeFloat(java.lang.String,
	 * float)
	 */
	public void writeFloat(String name, float value) throws IOException {
		this.stream.write(BitConverter.getBytes(value));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaWriter#writeDouble(java.lang.String
	 * , double)
	 */
	public void writeDouble(String name, double value) throws IOException {
		this.stream.write(BitConverter.getBytes(value));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaWriter#writeBinary(java.lang.String
	 * , byte[], boolean)
	 */
	public void writeBinary(String name, byte[] buffer, boolean nullable)
			throws TeslaSerializationException, IOException {
		if (this.writeNullableFlag(buffer, nullable))
			return;
		this.writeVInt(buffer.length);
		this.stream.write(buffer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaWriter#writeString(java.lang.String
	 * , java.lang.String, boolean)
	 */
	public void writeString(String name, String value, boolean nullable)
			throws TeslaSerializationException, IOException {
		if (this.writeNullableFlag(value, nullable))
			return;
		final byte[] buffer = value.getBytes(UTF8);
		this.writeVInt(buffer.length);
		this.stream.write(buffer);
	}

	/**
	 * Write nullable flag.
	 * 
	 * @param value
	 *            the value
	 * @param nullable
	 *            the nullable
	 * @return true if value is null
	 * @throws IOException
	 * @throws TeslaSerializationException
	 */
	protected boolean writeNullableFlag(Object value, boolean nullable)
			throws IOException, TeslaSerializationException {
		if (nullable) {
			writeNull(value == null);
			return value == null;
		}
		if (value == null) {
			throw new TeslaSerializationException(
					"Null value was written as a non-nullable member.");
		}
		return false;
	}

	protected void writeNull(boolean isNull) throws IOException {
		this.writeBoolean(null, isNull);
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
			// TODO: Investigate unrolling
			int lsb = (int) (value & 0x7f);
			this.stream.write(lsb | ((value >>>= 7) == 0 ? 0 : 0x80));
		} while (value != 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaWriter#writeEnum(java.lang.String,
	 * java.lang.Enum, com.expedia.tesla.serialization.EnumMapper)
	 */
	public <T extends Enum<T>> void writeEnum(String name, T value,
			EnumMapper<T> mapper) throws IOException {
		writeInt32(name, mapper.toInteger(value));
	}
}
