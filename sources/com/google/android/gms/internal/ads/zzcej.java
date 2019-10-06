package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcej implements zzdti<zzbuz<zzbsr>> {

    /* renamed from: a */
    private final zzdtu<zzcep> f26482a;

    /* renamed from: b */
    private final zzdtu<Executor> f26483b;

    private zzcej(zzdtu<zzcep> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26482a = zzdtu;
        this.f26483b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcej m28331a(zzdtu<zzcep> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcej(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzcep) this.f26482a.get(), (Executor) this.f26483b.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
