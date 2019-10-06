package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcix implements zzdti<zzbuz<zzbro>> {

    /* renamed from: a */
    private final zzdtu<zzcjg> f26683a;

    /* renamed from: b */
    private final zzdtu<Executor> f26684b;

    private zzcix(zzdtu<zzcjg> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26683a = zzdtu;
        this.f26684b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcix m28467a(zzdtu<zzcjg> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcix(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzcjg) this.f26683a.get(), (Executor) this.f26684b.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
