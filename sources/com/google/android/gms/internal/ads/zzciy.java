package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzciy implements zzdti<zzbuz<zzbsr>> {

    /* renamed from: a */
    private final zzdtu<zzcjg> f26685a;

    /* renamed from: b */
    private final zzdtu<Executor> f26686b;

    private zzciy(zzdtu<zzcjg> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26685a = zzdtu;
        this.f26686b = zzdtu2;
    }

    /* renamed from: a */
    public static zzciy m28468a(zzdtu<zzcjg> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzciy(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzcjg) this.f26685a.get(), (Executor) this.f26686b.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
