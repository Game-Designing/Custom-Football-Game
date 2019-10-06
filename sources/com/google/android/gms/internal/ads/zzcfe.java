package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcfe implements zzdti<zzbuz<zzbro>> {

    /* renamed from: a */
    private final zzdtu<zzcfb> f26518a;

    /* renamed from: b */
    private final zzdtu<Executor> f26519b;

    private zzcfe(zzdtu<zzcfb> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26518a = zzdtu;
        this.f26519b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcfe m28356a(zzdtu<zzcfb> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcfe(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzcfb) this.f26518a.get(), (Executor) this.f26519b.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
