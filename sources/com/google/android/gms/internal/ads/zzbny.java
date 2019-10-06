package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbny implements zzdti<zzbuz<zzue>> {

    /* renamed from: a */
    private final zzbnk f25642a;

    /* renamed from: b */
    private final zzdtu<zzboz> f25643b;

    /* renamed from: c */
    private final zzdtu<Executor> f25644c;

    public zzbny(zzbnk zzbnk, zzdtu<zzboz> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f25642a = zzbnk;
        this.f25643b = zzdtu;
        this.f25644c = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzboz) this.f25643b.get(), (Executor) this.f25644c.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
