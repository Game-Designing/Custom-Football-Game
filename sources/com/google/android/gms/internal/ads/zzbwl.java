package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbwl implements zzdti<zzbuz<zzbrl>> {

    /* renamed from: a */
    private final zzbvz f25949a;

    /* renamed from: b */
    private final zzdtu<zzbxg> f25950b;

    /* renamed from: c */
    private final zzdtu<Executor> f25951c;

    private zzbwl(zzbvz zzbvz, zzdtu<zzbxg> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f25949a = zzbvz;
        this.f25950b = zzdtu;
        this.f25951c = zzdtu2;
    }

    /* renamed from: a */
    public static zzbwl m27872a(zzbvz zzbvz, zzdtu<zzbxg> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzbwl(zzbvz, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzbxg) this.f25950b.get(), (Executor) this.f25951c.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
