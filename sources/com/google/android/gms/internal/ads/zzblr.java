package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzblr implements zzdti<zzblq> {

    /* renamed from: a */
    private final zzdtu<Map<String, zzbls>> f25507a;

    private zzblr(zzdtu<Map<String, zzbls>> zzdtu) {
        this.f25507a = zzdtu;
    }

    /* renamed from: a */
    public static zzblr m27228a(zzdtu<Map<String, zzbls>> zzdtu) {
        return new zzblr(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzblq((Map) this.f25507a.get());
    }
}
