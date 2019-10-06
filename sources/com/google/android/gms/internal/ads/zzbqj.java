package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbqj implements zzdti<zzbuz<zzbrw>> {

    /* renamed from: a */
    private final zzdtu<zzbme> f25793a;

    /* renamed from: b */
    private final zzdtu<Executor> f25794b;

    private zzbqj(zzdtu<zzbme> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f25793a = zzdtu;
        this.f25794b = zzdtu2;
    }

    /* renamed from: a */
    public static zzbqj m27687a(zzdtu<zzbme> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzbqj(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzbme) this.f25793a.get(), (Executor) this.f25794b.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
