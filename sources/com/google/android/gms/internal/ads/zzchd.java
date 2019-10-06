package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzchd implements zzdti<zzbuz<zzbtk>> {

    /* renamed from: a */
    private final zzdtu<C9362cj> f26620a;

    /* renamed from: b */
    private final zzdtu<Executor> f26621b;

    private zzchd(zzdtu<C9362cj> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26620a = zzdtu;
        this.f26621b = zzdtu2;
    }

    /* renamed from: a */
    public static zzchd m28433a(zzdtu<C9362cj> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzchd(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((C9362cj) this.f26620a.get(), (Executor) this.f26621b.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
