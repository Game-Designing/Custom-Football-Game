package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzceh implements zzdti<zzbuz<zzbro>> {

    /* renamed from: a */
    private final zzdtu<zzcep> f26478a;

    /* renamed from: b */
    private final zzdtu<Executor> f26479b;

    private zzceh(zzdtu<zzcep> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26478a = zzdtu;
        this.f26479b = zzdtu2;
    }

    /* renamed from: a */
    public static zzceh m28329a(zzdtu<zzcep> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzceh(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzcep) this.f26478a.get(), (Executor) this.f26479b.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
