package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzcfa implements zzdti<zzcex> {

    /* renamed from: a */
    private final zzdtu<zzwj> f26509a;

    /* renamed from: b */
    private final zzdtu<Map<zzczs, zzcez>> f26510b;

    private zzcfa(zzdtu<zzwj> zzdtu, zzdtu<Map<zzczs, zzcez>> zzdtu2) {
        this.f26509a = zzdtu;
        this.f26510b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcfa m28350a(zzdtu<zzwj> zzdtu, zzdtu<Map<zzczs, zzcez>> zzdtu2) {
        return new zzcfa(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcex((zzwj) this.f26509a.get(), (Map) this.f26510b.get());
    }
}
