package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcff implements zzdti<zzbuz<zzbsr>> {

    /* renamed from: a */
    private final zzdtu<zzcfb> f26520a;

    /* renamed from: b */
    private final zzdtu<Executor> f26521b;

    private zzcff(zzdtu<zzcfb> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26520a = zzdtu;
        this.f26521b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcff m28357a(zzdtu<zzcfb> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcff(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzcfb) this.f26520a.get(), (Executor) this.f26521b.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
