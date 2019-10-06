package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzciz implements zzdti<zzbuz<zzczz>> {

    /* renamed from: a */
    private final zzdtu<zzcjk> f26687a;

    /* renamed from: b */
    private final zzdtu<Executor> f26688b;

    private zzciz(zzdtu<zzcjk> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26687a = zzdtu;
        this.f26688b = zzdtu2;
    }

    /* renamed from: a */
    public static zzciz m28469a(zzdtu<zzcjk> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzciz(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzcjk) this.f26687a.get(), (Executor) this.f26688b.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
