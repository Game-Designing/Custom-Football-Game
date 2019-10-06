package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbqk implements zzdti<zzbuz<zzbsr>> {

    /* renamed from: a */
    private final zzdtu<zzbme> f25795a;

    /* renamed from: b */
    private final zzdtu<Executor> f25796b;

    private zzbqk(zzdtu<zzbme> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f25795a = zzdtu;
        this.f25796b = zzdtu2;
    }

    /* renamed from: a */
    public static zzbqk m27688a(zzdtu<zzbme> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzbqk(zzdtu, zzdtu2);
    }

    /* renamed from: a */
    public static zzbuz<zzbsr> m27689a(zzbme zzbme, Executor executor) {
        zzbuz<zzbsr> zzbuz = new zzbuz<>(zzbme, executor);
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }

    public final /* synthetic */ Object get() {
        return m27689a((zzbme) this.f25795a.get(), (Executor) this.f25796b.get());
    }
}
