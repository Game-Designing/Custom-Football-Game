package com.google.android.gms.internal.measurement;

import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.measurement.ga */
final class C9970ga<K> implements Entry<K, Object> {

    /* renamed from: a */
    private Entry<K, zzuy> f30113a;

    private C9970ga(Entry<K, zzuy> entry) {
        this.f30113a = entry;
    }

    public final K getKey() {
        return this.f30113a.getKey();
    }

    public final Object getValue() {
        if (((zzuy) this.f30113a.getValue()) == null) {
            return null;
        }
        zzuy.m32554c();
        throw null;
    }

    /* renamed from: a */
    public final zzuy mo32727a() {
        return (zzuy) this.f30113a.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzvv) {
            return ((zzuy) this.f30113a.getValue()).mo32913a((zzvv) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
