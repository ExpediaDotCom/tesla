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
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;

import com.expedia.tesla.ISchemaVersion;
import com.expedia.tesla.SchemaVersion;
import com.expedia.tesla.utils.BitConverter;
import com.expedia.tesla.utils.LockFreeMemoryInputStream;
import com.expedia.tesla.utils.Unsigned;

/**
 * The Class BinaryReader.
 * 
 * @see com.com.expedia.tesla.serialization.ITeslaReader
 */
public class BinaryReader implements Closeable {
	protected static final Charset UTF8 = Charset.forName("UTF-8");

	protected static final String CORRUPT_STREAM = "Invalid data was encountered in the stream. The stream is corrupted.";

	private ISchemaVersion version;
	private InputStream in;
	private byte[] byteBuffer = new byte[8];
	private int bytes;

	/**
	 * Instantiates a new binary reader.
	 * 
	 * @param buffer
	 *            the buffer
	 * @param schemaHash
	 *            the schema hash
	 */
	public BinaryReader(byte[] buffer, long schemaHash) {
		this(buffer, 0, buffer.length, schemaHash);
	}

	/**
	 * Instantiates a new binary reader.
	 * 
	 * @param buffer
	 *            the buffer
	 * @param version
	 *            the schema version
	 */
	public BinaryReader(byte[] buffer, ISchemaVersion version) {
		this(buffer, 0, buffer.length, version);
	}

	/**
	 * Instantiates a new binary reader.
	 * 
	 * @param buffer
	 *            the buffer
	 * @param offset
	 *            the offset
	 * @param length
	 *            the length
	 * @param schemaHash
	 *            the schema hash
	 */
	public BinaryReader(byte[] buffer, int offset, int length, long schemaHash) {
		this(buffer, offset, length, new SchemaVersion(schemaHash));
	}

	/**
	 * Instantiates a new binary reader.
	 * 
	 * @param buffer
	 *            the buffer
	 * @param offset
	 *            the offset
	 * @param length
	 *            the length
	 * @param version
	 *            the schema version
	 */
	public BinaryReader(byte[] buffer, int offset, int length,
			ISchemaVersion version) {
		this(new LockFreeMemoryInputStream(buffer, offset, length), version);
	}

	/**
	 * Instantiates a new binary reader.
	 * 
	 * @param in
	 *            The input stream.
	 * 
	 * @param version
	 *            The schema version.
	 */
	public BinaryReader(InputStream in, ISchemaVersion version) {
		this.version = version;
		this.in = in;
	}

	/**
	 * Instantiates a new binary reader.
	 * 
	 * @param in
	 *            The input stream.
	 * 
	 * @param schemaHash
	 *            The schema hash.
	 */
	public BinaryReader(InputStream in, long schemaHash) {
		this(in, new SchemaVersion(schemaHash));
	}

	/**
	 * @return the version
	 */
	public ISchemaVersion getVersion() {
		return version;
	}

	@Override
	public void close() throws IOException {
		in.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaReader#readBoolean(java.lang.String
	 * )
	 */
	public boolean readBoolean(String name) throws IOException,
			TeslaDeserializationException {
		byte v = readByte();
		switch (v) {
		case TeslaConstants.BOOLEAN_FALSE:
			return false;
		case TeslaConstants.BOOLEAN_TRUE:
			return true;
		default:
			throw new TeslaDeserializationException("Invalid boolean value: "
					+ v);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaReader#readByte(java.lang.String)
	 */
	public byte readByte(String name) throws IOException,
			TeslaDeserializationException {
		return readByte();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaReader#readInt16(java.lang.String)
	 */
	public short readInt16(String name) throws IOException,
			TeslaDeserializationException {
		long value = this.readZigZag();
		if (value < Short.MIN_VALUE || Short.MAX_VALUE < value) {
			throw new TeslaDeserializationException(CORRUPT_STREAM);
		}
		return (short) value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaReader#readInt32(java.lang.String)
	 */
	public int readInt32(String name) throws IOException,
			TeslaDeserializationException {
		long value = this.readZigZag();
		if (value < Integer.MIN_VALUE || Integer.MAX_VALUE < value) {
			throw new TeslaDeserializationException(CORRUPT_STREAM);
		}
		return (int) value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaReader#readInt64(java.lang.String)
	 */
	public long readInt64(String name) throws IOException,
			TeslaDeserializationException {
		return this.readZigZag();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaReader#readUInt16(java.lang.String)
	 */
	public short readUInt16(String name) throws IOException,
			TeslaDeserializationException {
		long value = this.readVInt();
		if (Unsigned.isInvalidUInt16(value)) {
			throw new TeslaDeserializationException(CORRUPT_STREAM);
		}
		return (short) value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaReader#readUInt32(java.lang.String)
	 */
	public int readUInt32(String name) throws IOException,
			TeslaDeserializationException {
		long value = this.readVInt();
		if (Unsigned.isInvalidUInt32(value)) {
			throw new TeslaDeserializationException(CORRUPT_STREAM);
		}
		return (int) value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaReader#readUInt64(java.lang.String)
	 */
	public long readUInt64(String name) throws IOException,
			TeslaDeserializationException {
		final BigInteger value = this.readVIntBig();
		assert !Unsigned.isInvalidUInt64(value);
		return value.longValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaReader#readFloat(java.lang.String)
	 */
	public float readFloat(String name) throws IOException,
			TeslaDeserializationException {
		readBytes(byteBuffer, 0, 4);
		return BitConverter.toFloat(byteBuffer, 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaReader#readDouble(java.lang.String)
	 */
	public double readDouble(String name) throws IOException,
			TeslaDeserializationException {
		readBytes(byteBuffer, 0, 8);
		return BitConverter.toDouble(byteBuffer, 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaReader#readBinary(java.lang.String,
	 * boolean)
	 */
	public byte[] readBinary(String name, boolean nullable)
			throws TeslaDeserializationException, IOException {
		return this.readBinaryInternal(name, nullable, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaReader#readString(java.lang.String,
	 * boolean)
	 */
	public String readString(String name, boolean nullable)
			throws TeslaDeserializationException, IOException {
		final byte[] buffer = this.readBinaryInternal(name, nullable, false);
		return buffer == null ? null : new String(buffer, 0, bytes, UTF8);
	}

	private byte[] readBinaryInternal(String name, boolean nullable,
			boolean newBuffer) throws TeslaDeserializationException,
			IOException {
		if (nullable && this.readBoolean(null))
			return null;
		long size = this.readVInt();
		if (size < 0 || Integer.MAX_VALUE < size) {
			throw new TeslaDeserializationException(CORRUPT_STREAM);
		}
		bytes = (int) size;
		if (newBuffer) {
			final byte[] buffer = new byte[bytes];
			readBytes(buffer, 0, bytes);
			return buffer;
		} else {
			if (byteBuffer.length < bytes)
				byteBuffer = new byte[bytes];
			readBytes(byteBuffer, 0, bytes);
			return byteBuffer;
		}
	}

	protected final byte readByte() throws IOException,
			TeslaDeserializationException {
		int b = in.read();
		if (b == -1) {
			throw new TeslaDeserializationException("The end of the buffer "
					+ "was reached during deserialization.");
		}
		return (byte) b;
	}

	protected final void readBytes(byte b[], int off, int len)
			throws IOException, TeslaDeserializationException {
		int n = 0;
		int count = 0;
		while (n < len) {
			count = in.read(b, off + n, len - n);
			if (count < 0)
				throw new TeslaDeserializationException(
						"The end of the buffer "
								+ "was reached during deserialization.");
			n += count;
		}
	}

	protected final long readVInt() throws IOException,
			TeslaDeserializationException {
		long value = 0;
		int b = 0x80;
		for (int offset = 0; (b & 0x80) != 0; offset += 7) {
			b = this.readByte();
			if (offset >= 63 && b > 1) {
				throw new TeslaDeserializationException(
						"Bad format integer was encounted. The data may be corrupted.");
			}
			value |= ((long) b & 0x7f) << offset;
		}
		return value;
	}

	protected final BigInteger readVIntBig() throws IOException,
			TeslaDeserializationException {
		BigInteger value = BigInteger.ZERO;
		int b = 0x80;
		for (int offset = 0; (b & 0x80) != 0; offset += 7) {
			b = this.readByte();
			if (offset >= 63 & b > 1) {
				throw new TeslaDeserializationException(
						"Bad format integer was encounted. The data may be corrupted.");
			}
			value = value.or(BigInteger.valueOf(b & 0x7F).shiftLeft(offset));
		}
		return value;
	}

	protected final long readZigZag() throws IOException,
			TeslaDeserializationException {
		long n = readVInt();
		return (n >>> 1) ^ -(n & 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.tesla.serialization.ITeslaReader#readEnum(java.lang.String,
	 * com.expedia.tesla.serialization.EnumMapper)
	 */
	public <T extends Enum<T>> T readEnum(String name, EnumMapper<T> mapper)
			throws TeslaDeserializationException, IOException {
		return mapper.fromInteger(readInt32(name));
	}
}