package com.fasterxml.jackson.databind.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T>, Iterable<T> {

    /* renamed from: _a */
    private final T[] f12556_a;
    private int _index = 0;

    public ArrayIterator(T[] a) {
        this.f12556_a = a;
    }

    public boolean hasNext() {
        return this._index < this.f12556_a.length;
    }

    public T next() {
        int i = this._index;
        T[] tArr = this.f12556_a;
        if (i < tArr.length) {
            this._index = i + 1;
            return tArr[i];
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator() {
        return this;
    }
}
