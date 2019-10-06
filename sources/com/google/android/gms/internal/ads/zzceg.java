package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzceg implements zzdti<zzbuz<zzxr>> {

    /* renamed from: a */
    private final zzdtu<zzcep> f26476a;

    /* renamed from: b */
    private final zzdtu<Executor> f26477b;

    private zzceg(zzdtu<zzcep> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26476a = zzdtu;
        this.f26477b = zzdtu2;
    }

    /* renamed from: a */
    public static zzceg m28328a(zzdtu<zzcep> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzceg(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzcep) this.f26476a.get(), (Executor) this.f26477b.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
