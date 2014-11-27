/*******************************************************************************
 * Copyright (c) 2014 Expedia Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package com.expedia.tesla.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;

import com.expedia.tesla.SchemaVersion;
import com.expedia.tesla.utils.BitConverter;
import com.expedia.tesla.utils.LockFreeMemoryInputStream;
import com.expedia.tesla.utils.Unsigned;

/**
 * Read basic Tesla binary encoded values defined in Tesla binary encoding
 * specification.
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 * @see BinaryWrier
 */
public class BinaryReader implements TeslaReader {

	protected static final Charset UTF8 = Charset.forName("UTF-8");

	protected static final String CORRUPT_STREAM = "Invalid data was encountered in the stream. The stream is corrupted.";

	private SchemaVersion version;
	private InputStream in;
	
	// byteBuffer and bytes are reused for reading integer values. byteBuffer holds the last read binary data while 
	// bytes represents its size in byte.
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
	public BinaryReader(byte[] buffer, SchemaVersion version) {
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
			SchemaVersion version) {
		this(new LockFreeMemoryInputStream(buffer, offset, length), version);
	}

	/**
	 * Instantiates a new binary reader.
	 * 
	 * @param in
	 *            The input stream.
	 * @param version
	 *            The schema version.
	 */
	public BinaryReader(InputStream in, SchemaVersion version) {
		if (in == null) {
			throw new IllegalArgumentException("input stream cannot be null!");
		}
		this.version = version;
		this.in = in;
	}

	/**
	 * Instantiates a new binary reader.
	 * 
	 * @param in
	 *            The input stream.
	 * @param schemaHash
	 *            The schema hash.
	 */
	public BinaryReader(InputStream in, long schemaHash) {
		this(in, new SchemaVersion(schemaHash));
	}

	/**
	 * Get current Tesla schema version.
	 * 
	 * @return the version
	 */
	public SchemaVersion getVersion() {
		return version;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void close() throws IOException {
		in.close();
	}

	/**
	 * Read a Tesla binary encoded {@code boolean} value.
	 * <p>
	 * In order to make it easier to detect corrupted data, the boolean value
	 * TRUE is encoded in one byte 0x0D and FALSE is encoded in 0x05.
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
			TeslaDeserializationException {
		return readByte();
	}

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
			TeslaDeserializationException {
		long value = this.readZigZag();
		if (value < Short.MIN_VALUE || Short.MAX_VALUE < value) {
			throw new TeslaDeserializationException(CORRUPT_STREAM);
		}
		return (short) value;
	}

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
			TeslaDeserializationException {
		long value = this.readZigZag();
		if (value < Integer.MIN_VALUE || Integer.MAX_VALUE < value) {
			throw new TeslaDeserializationException(CORRUPT_STREAM);
		}
		return (int) value;
	}

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
			TeslaDeserializationException {
		return this.readZigZag();
	}

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
			TeslaDeserializationException {
		long value = this.readVInt();
		if (Unsigned.isInvalidUInt16(value)) {
			throw new TeslaDeserializationException(CORRUPT_STREAM);
		}
		return (short) value;
	}

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
			TeslaDeserializationException {
		long value = this.readVInt();
		if (Unsigned.isInvalidUInt32(value)) {
			throw new TeslaDeserializationException(CORRUPT_STREAM);
		}
		return (int) value;
	}

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
			TeslaDeserializationException {
		final BigInteger value = this.readVIntBig();
		if (Unsigned.isInvalidUInt64(value)) {
			throw new TeslaDeserializationException(CORRUPT_STREAM);
		}
		return value.longValue();
	}

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
			TeslaDeserializationException {
		readBytes(byteBuffer, 0, 4);
		return BitConverter.toFloat(byteBuffer, 0);
	}

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
			TeslaDeserializationException {
		readBytes(byteBuffer, 0, 8);
		return BitConverter.toDouble(byteBuffer, 0);
	}

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
			IOException {
		return this.readBinaryInternal(name, true);
	}

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
			throws TeslaDeserializationException, IOException {
		final byte[] buffer = this.readBinaryInternal(name, false);
		return buffer == null ? null : new String(buffer, 0, bytes, UTF8);
	}

	private byte[] readBinaryInternal(String name, boolean newBuffer)
			throws TeslaDeserializationException, IOException {
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
			throws TeslaDeserializationException, IOException {
		return mapper.fromInteger(readInt32(name));
	}
}
