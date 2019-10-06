package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbqi implements zzdti<zzbuz<zzbrl>> {

    /* renamed from: a */
    private final zzdtu<zzbme> f25791a;

    /* renamed from: b */
    private final zzdtu<Executor> f25792b;

    private zzbqi(zzdtu<zzbme> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f25791a = zzdtu;
        this.f25792b = zzdtu2;
    }

    /* renamed from: a */
    public static zzbqi m27686a(zzdtu<zzbme> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzbqi(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzbme) this.f25791a.get(), (Executor) this.f25792b.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
