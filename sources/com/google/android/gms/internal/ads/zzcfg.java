package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcfg implements zzdti<zzbuz<zzczz>> {

    /* renamed from: a */
    private final zzdtu<zzcfk> f26522a;

    /* renamed from: b */
    private final zzdtu<Executor> f26523b;

    private zzcfg(zzdtu<zzcfk> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26522a = zzdtu;
        this.f26523b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcfg m28358a(zzdtu<zzcfk> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcfg(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzcfk) this.f26522a.get(), (Executor) this.f26523b.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
