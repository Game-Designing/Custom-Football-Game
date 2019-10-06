package com.google.android.gms.internal.ads;

import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.ads.Vo */
final class C9198Vo<K> implements Entry<K, Object> {

    /* renamed from: a */
    private Entry<K, zzdon> f21862a;

    private C9198Vo(Entry<K, zzdon> entry) {
        this.f21862a = entry;
    }

    public final K getKey() {
        return this.f21862a.getKey();
    }

    public final Object getValue() {
        if (((zzdon) this.f21862a.getValue()) == null) {
            return null;
        }
        zzdon.m29938c();
        throw null;
    }

    /* renamed from: a */
    public final zzdon mo28662a() {
        return (zzdon) this.f21862a.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzdpk) {
            return ((zzdon) this.f21862a.getValue()).mo31623a((zzdpk) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
