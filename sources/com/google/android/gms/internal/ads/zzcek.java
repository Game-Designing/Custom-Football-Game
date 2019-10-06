package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcek implements zzdti<zzbuz<zzbtk>> {

    /* renamed from: a */
    private final zzdtu<zzcep> f26484a;

    /* renamed from: b */
    private final zzdtu<Executor> f26485b;

    private zzcek(zzdtu<zzcep> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26484a = zzdtu;
        this.f26485b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcek m28332a(zzdtu<zzcep> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcek(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzcep) this.f26484a.get(), (Executor) this.f26485b.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
