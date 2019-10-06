package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@zzard
public final class zzazh {

    /* renamed from: a */
    private Map<Integer, Bitmap> f25017a = new ConcurrentHashMap();

    /* renamed from: b */
    private AtomicInteger f25018b = new AtomicInteger(0);

    /* renamed from: a */
    public final Bitmap mo30299a(Integer num) {
        return (Bitmap) this.f25017a.get(num);
    }
}
