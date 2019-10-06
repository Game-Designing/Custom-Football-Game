package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcfq implements zzdti<Set<zzbuz<zzbrl>>> {

    /* renamed from: a */
    private final zzcfp f26537a;

    /* renamed from: b */
    private final zzdtu<zzcfz> f26538b;

    /* renamed from: c */
    private final zzdtu<Executor> f26539c;

    private zzcfq(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26537a = zzcfp;
        this.f26538b = zzdtu;
        this.f26539c = zzdtu2;
    }

    /* renamed from: a */
    public static zzcfq m28381a(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcfq(zzcfp, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        Set e = zzcfp.m28376e((zzcfz) this.f26538b.get(), (Executor) this.f26539c.get());
        zzdto.m30114a(e, "Cannot return null from a non-@Nullable @Provides method");
        return e;
    }
}
