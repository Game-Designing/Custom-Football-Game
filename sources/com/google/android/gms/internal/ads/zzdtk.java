package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class zzdtk<K, V> implements zzdti<Map<K, V>> {

    /* renamed from: a */
    private static final zzdtu<Map<Object, Object>> f28305a = zzdtj.m30109a(Collections.emptyMap());

    /* renamed from: b */
    private final Map<K, zzdtu<V>> f28306b;

    /* renamed from: a */
    public static <K, V> zzdtm<K, V> m30110a(int i) {
        return new zzdtm<>(i);
    }

    private zzdtk(Map<K, zzdtu<V>> map) {
        this.f28306b = Collections.unmodifiableMap(map);
    }

    public final /* synthetic */ Object get() {
        LinkedHashMap c = zzdtf.m30104c(this.f28306b.size());
        for (Entry entry : this.f28306b.entrySet()) {
            c.put(entry.getKey(), ((zzdtu) entry.getValue()).get());
        }
        return Collections.unmodifiableMap(c);
    }
}
