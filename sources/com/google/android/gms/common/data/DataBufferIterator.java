package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

@KeepForSdk
public class DataBufferIterator<T> implements Iterator<T> {

    /* renamed from: a */
    protected final DataBuffer<T> f19959a;

    /* renamed from: b */
    protected int f19960b = -1;

    public DataBufferIterator(DataBuffer<T> dataBuffer) {
        Preconditions.m21857a(dataBuffer);
        this.f19959a = dataBuffer;
    }

    public boolean hasNext() {
        return this.f19960b < this.f19959a.getCount() - 1;
    }

    public T next() {
        if (hasNext()) {
            DataBuffer<T> dataBuffer = this.f19959a;
            int i = this.f19960b + 1;
            this.f19960b = i;
            return dataBuffer.get(i);
        }
        int i2 = this.f19960b;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Cannot advance the iterator beyond ");
        sb.append(i2);
        throw new NoSuchElementException(sb.toString());
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
