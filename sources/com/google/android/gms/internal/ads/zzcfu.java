package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcfu implements zzdti<Set<zzbuz<zzbtk>>> {

    /* renamed from: a */
    private final zzcfp f26549a;

    /* renamed from: b */
    private final zzdtu<zzcfz> f26550b;

    /* renamed from: c */
    private final zzdtu<Executor> f26551c;

    private zzcfu(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26549a = zzcfp;
        this.f26550b = zzdtu;
        this.f26551c = zzdtu2;
    }

    /* renamed from: a */
    public static zzcfu m28386a(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcfu(zzcfp, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        Set i = zzcfp.m28380i((zzcfz) this.f26550b.get(), (Executor) this.f26551c.get());
        zzdto.m30114a(i, "Cannot return null from a non-@Nullable @Provides method");
        return i;
    }
}
