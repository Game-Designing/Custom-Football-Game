package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbmr implements zzdti<zzbmg> {

    /* renamed from: a */
    private final zzdtu<zzty> f25569a;

    /* renamed from: b */
    private final zzdtu<zzaly> f25570b;

    /* renamed from: c */
    private final zzdtu<Executor> f25571c;

    private zzbmr(zzdtu<zzty> zzdtu, zzdtu<zzaly> zzdtu2, zzdtu<Executor> zzdtu3) {
        this.f25569a = zzdtu;
        this.f25570b = zzdtu2;
        this.f25571c = zzdtu3;
    }

    /* renamed from: a */
    public static zzbmr m27266a(zzdtu<zzty> zzdtu, zzdtu<zzaly> zzdtu2, zzdtu<Executor> zzdtu3) {
        return new zzbmr(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        zzaly zzaly = (zzaly) this.f25570b.get();
        Executor executor = (Executor) this.f25571c.get();
        zzbmg zzbmg = new zzbmg(((zzty) this.f25569a.get()).mo32246d(), zzaly, executor);
        zzdto.m30114a(zzbmg, "Cannot return null from a non-@Nullable @Provides method");
        return zzbmg;
    }
}
