package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcfx implements zzdti<Set<zzbuz<zzbrw>>> {

    /* renamed from: a */
    private final zzcfp f26558a;

    /* renamed from: b */
    private final zzdtu<zzcfz> f26559b;

    /* renamed from: c */
    private final zzdtu<Executor> f26560c;

    private zzcfx(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26558a = zzcfp;
        this.f26559b = zzdtu;
        this.f26560c = zzdtu2;
    }

    /* renamed from: a */
    public static zzcfx m28389a(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcfx(zzcfp, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        Set f = zzcfp.m28377f((zzcfz) this.f26559b.get(), (Executor) this.f26560c.get());
        zzdto.m30114a(f, "Cannot return null from a non-@Nullable @Provides method");
        return f;
    }
}
