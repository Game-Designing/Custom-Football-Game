package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcft implements zzdti<Set<zzbuz<zzbsr>>> {

    /* renamed from: a */
    private final zzcfp f26546a;

    /* renamed from: b */
    private final zzdtu<zzcfz> f26547b;

    /* renamed from: c */
    private final zzdtu<Executor> f26548c;

    private zzcft(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26546a = zzcfp;
        this.f26547b = zzdtu;
        this.f26548c = zzdtu2;
    }

    /* renamed from: a */
    public static zzcft m28384a(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcft(zzcfp, zzdtu, zzdtu2);
    }

    /* renamed from: a */
    public static Set<zzbuz<zzbsr>> m28385a(zzcfp zzcfp, zzcfz zzcfz, Executor executor) {
        Set<zzbuz<zzbsr>> c = zzcfp.m28374c(zzcfz, executor);
        zzdto.m30114a(c, "Cannot return null from a non-@Nullable @Provides method");
        return c;
    }

    public final /* synthetic */ Object get() {
        return m28385a(this.f26546a, (zzcfz) this.f26547b.get(), (Executor) this.f26548c.get());
    }
}
