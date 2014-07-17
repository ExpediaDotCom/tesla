package com.expedia.tesla.schema;

import java.util.Iterator;

public class PeekIterator<T> implements Iterator<T> {

	private Iterator<T> itr;
	private T next;

	PeekIterator(Iterator<T> itr) {
		this.itr = itr;
	}

	@Override
	public boolean hasNext() {
		if (next != null)
			return true;
		return itr.hasNext();
	}

	@Override
	public T next() {
		if (next != null) {
			T data = next;
			next = null;
			return data;
		}
		return itr.next();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	public T peek() {
		if (next == null) {
			next = next();
		}

		return next;
	}

}
