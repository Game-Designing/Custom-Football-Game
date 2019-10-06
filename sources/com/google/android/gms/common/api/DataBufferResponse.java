package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataBuffer;
import java.util.Iterator;

@KeepForSdk
public class DataBufferResponse<T, R extends AbstractDataBuffer<T> & Result> extends Response<R> implements DataBuffer<T> {
    public int getCount() {
        return ((AbstractDataBuffer) mo27407b()).getCount();
    }

    public T get(int i) {
        return ((AbstractDataBuffer) mo27407b()).get(i);
    }

    public Iterator<T> iterator() {
        return ((AbstractDataBuffer) mo27407b()).iterator();
    }

    /* renamed from: a */
    public void mo27353a() {
        ((AbstractDataBuffer) mo27407b()).mo27353a();
    }
}
