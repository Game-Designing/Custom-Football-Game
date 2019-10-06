package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcfs implements zzdti<Set<zzbuz<zzbrx>>> {

    /* renamed from: a */
    private final zzcfp f26543a;

    /* renamed from: b */
    private final zzdtu<zzcfz> f26544b;

    /* renamed from: c */
    private final zzdtu<Executor> f26545c;

    private zzcfs(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26543a = zzcfp;
        this.f26544b = zzdtu;
        this.f26545c = zzdtu2;
    }

    /* renamed from: a */
    public static zzcfs m28383a(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcfs(zzcfp, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        Set a = zzcfp.m28371a((zzcfz) this.f26544b.get(), (Executor) this.f26545c.get());
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
