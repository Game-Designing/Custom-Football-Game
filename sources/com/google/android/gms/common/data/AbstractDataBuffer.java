package com.google.android.gms.common.data;

import java.util.Iterator;

public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {

    /* renamed from: a */
    protected final DataHolder f19952a;

    public abstract T get(int i);

    public int getCount() {
        DataHolder dataHolder = this.f19952a;
        if (dataHolder == null) {
            return 0;
        }
        return dataHolder.getCount();
    }

    public Iterator<T> iterator() {
        return new DataBufferIterator(this);
    }

    /* renamed from: a */
    public void mo27353a() {
        DataHolder dataHolder = this.f19952a;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }
}
