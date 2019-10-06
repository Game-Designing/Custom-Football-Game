package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcfw implements zzdti<Set<zzbuz<zzxr>>> {

    /* renamed from: a */
    private final zzcfp f26555a;

    /* renamed from: b */
    private final zzdtu<zzcfz> f26556b;

    /* renamed from: c */
    private final zzdtu<Executor> f26557c;

    private zzcfw(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26555a = zzcfp;
        this.f26556b = zzdtu;
        this.f26557c = zzdtu2;
    }

    /* renamed from: a */
    public static zzcfw m28388a(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcfw(zzcfp, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        Set g = zzcfp.m28378g((zzcfz) this.f26556b.get(), (Executor) this.f26557c.get());
        zzdto.m30114a(g, "Cannot return null from a non-@Nullable @Provides method");
        return g;
    }
}
