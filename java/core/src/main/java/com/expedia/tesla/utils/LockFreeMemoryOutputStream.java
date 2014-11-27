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

package com.expedia.tesla.utils;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/**
 * This class is copied from java.io.ByteArrayOutputStream and removed the
 * synchronized keyword from all methods in order to avoid synchronization cost. 
 * IT IS NOT THREAD SAFE.
 *
 * This class implements an no lock memory output stream in which the data is
 * written into a byte array. The buffer automatically grows as data is written
 * to it.
 * 
 * In order to avoid buffer copying, this class also provide direct access to
 * the internal buffer (<code>getInternalBuffer</code>). The method
 * <code>setPosition</code> can set the write offset inside the buffer.
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 */
public class LockFreeMemoryOutputStream extends ByteArrayOutputStream {
	/**
	 * Creates a new memory output stream. The buffer capacity is initially
	 * 65536 bytes, though its size increases if necessary.
	 */
	public LockFreeMemoryOutputStream() {
		super(65536);
	}

	/**
	 * Creates a new memory output stream, with a buffer capacity of the
	 * specified size, in bytes.
	 * 
	 * @param size
	 *            the initial size.
	 * @exception IllegalArgumentException
	 *                if size is negative.
	 */
	public LockFreeMemoryOutputStream(int size) {
		super(size);
	}

	/**
	 * Get the internal buffer. The data length may not be the same as the
	 * buffer length. Always call <code>size</size> to get the actual data size.
	 * 
	 * @return the internal buffer.
	 */
	public byte[] getInternalBuffer() {
		return this.buf;
	}

	/**
	 * Sets the current position.
	 * 
	 * @param position
	 *            the position to set.
	 */
	public void setPosition(int position) {
		ensureCapacity(position + 1);
		this.count = position;
	}

	/**
	 * Writes the specified byte to this byte array output stream.
	 * 
	 * @param b
	 *            the byte to be written.
	 */
	@Override
	public void write(int b) {
		ensureCapacity(count + 1);
		buf[count] = (byte) b;
		count += 1;
	}

	/**
	 * Writes <code>len</code> bytes from the specified byte array starting at
	 * offset <code>off</code> to this byte array output stream.
	 * 
	 * @param b
	 *            the data.
	 * @param off
	 *            the start offset in the data.
	 * @param len
	 *            the number of bytes to write.
	 */
	@Override
	public void write(byte b[], int off, int len) {
		if ((off < 0) || (off > b.length) || (len < 0)
				|| ((off + len) - b.length > 0)) {
			throw new IndexOutOfBoundsException();
		}
		ensureCapacity(count + len);
		System.arraycopy(b, off, buf, count, len);
		count += len;
	}

	/**
	 * Increases the capacity if necessary to ensure that it can hold at least
	 * the number of elements specified by the minimum capacity argument.
	 * 
	 * @param minCapacity
	 *            the desired minimum capacity
	 * @throws OutOfMemoryError
	 *             if {@code minCapacity < 0}. This is interpreted as a request
	 *             for the unsatisfiably large capacity
	 *             {@code (long) Integer.MAX_VALUE + (minCapacity - Integer.MAX_VALUE)}
	 *             .
	 */
	protected void ensureCapacity(int minCapacity) {
		// overflow-conscious code
		if (minCapacity - buf.length > 0)
			grow(minCapacity);
	}

	/**
	 * Increases the capacity to ensure that it can hold at least the number of
	 * elements specified by the minimum capacity argument.
	 * 
	 * @param minCapacity
	 *            the desired minimum capacity
	 */
	protected void grow(int minCapacity) {
		// overflow-conscious code
		int oldCapacity = buf.length;
		int newCapacity = oldCapacity << 1;
		if (newCapacity - minCapacity < 0)
			newCapacity = minCapacity;
		if (newCapacity < 0) {
			if (minCapacity < 0) // overflow
				throw new OutOfMemoryError();
			newCapacity = Integer.MAX_VALUE;
		}
		buf = Arrays.copyOf(buf, newCapacity);
	}
}