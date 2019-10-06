package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public final class zzfl<T> {

    /* renamed from: a */
    private final Map<String, AtomicReference<T>> f28413a = new HashMap();

    /* renamed from: a */
    public final AtomicReference<T> mo31748a(String str) {
        synchronized (this) {
            if (!this.f28413a.containsKey(str)) {
                this.f28413a.put(str, new AtomicReference());
            }
        }
        return (AtomicReference) this.f28413a.get(str);
    }
}
