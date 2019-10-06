package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbqh implements zzdti<zzbuz<zzxr>> {

    /* renamed from: a */
    private final zzdtu<zzbme> f25789a;

    /* renamed from: b */
    private final zzdtu<Executor> f25790b;

    private zzbqh(zzdtu<zzbme> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f25789a = zzdtu;
        this.f25790b = zzdtu2;
    }

    /* renamed from: a */
    public static zzbqh m27685a(zzdtu<zzbme> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzbqh(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzbme) this.f25789a.get(), (Executor) this.f25790b.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
