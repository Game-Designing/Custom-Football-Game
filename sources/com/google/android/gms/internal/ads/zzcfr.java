package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcfr implements zzdti<Set<zzbuz<zzbro>>> {

    /* renamed from: a */
    private final zzcfp f26540a;

    /* renamed from: b */
    private final zzdtu<zzcfz> f26541b;

    /* renamed from: c */
    private final zzdtu<Executor> f26542c;

    private zzcfr(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26540a = zzcfp;
        this.f26541b = zzdtu;
        this.f26542c = zzdtu2;
    }

    /* renamed from: a */
    public static zzcfr m28382a(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcfr(zzcfp, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        Set d = zzcfp.m28375d((zzcfz) this.f26541b.get(), (Executor) this.f26542c.get());
        zzdto.m30114a(d, "Cannot return null from a non-@Nullable @Provides method");
        return d;
    }
}
