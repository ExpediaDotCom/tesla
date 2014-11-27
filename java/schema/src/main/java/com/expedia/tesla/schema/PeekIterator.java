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
package com.expedia.tesla.schema;

import java.util.Iterator;

/**
 * Implement a peeking iterator. This can be used to peek at values in the underlying iterator before iterating over 
 * them.
 *
 * @author Yunfei Zuo (yzuo@expedia.com)
 */
public class PeekIterator<T> implements Iterator<T> {

	private Iterator<T> itr;
	private T next;

	/**
	 * Constructor.
	 * 
	 * @param itr
	 * 		the underlying iterator
	 */
	PeekIterator(Iterator<T> itr) {
		this.itr = itr;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasNext() {
		if (next != null)
			return true;
		return itr.hasNext();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T next() {
		if (next != null) {
			T data = next;
			next = null;
			return data;
		}
		return itr.next();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Peek at the current value without advancing the iterator.
	 *  
	 * @return
	 * 		the current value
	 */
	public T peek() {
		if (next == null) {
			next = next();
		}

		return next;
	}

}
