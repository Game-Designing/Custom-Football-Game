package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcmz<AdT> implements zzdti<zzcmx<AdT>> {

    /* renamed from: a */
    private final zzdtu<zzczt> f27058a;

    /* renamed from: b */
    private final zzdtu<zzcmu> f27059b;

    /* renamed from: c */
    private final zzdtu<zzbrm> f27060c;

    /* renamed from: d */
    private final zzdtu<zzdae> f27061d;

    /* renamed from: e */
    private final zzdtu<zzbpe<AdT>> f27062e;

    /* renamed from: f */
    private final zzdtu<Executor> f27063f;

    /* renamed from: g */
    private final zzdtu<ScheduledExecutorService> f27064g;

    private zzcmz(zzdtu<zzczt> zzdtu, zzdtu<zzcmu> zzdtu2, zzdtu<zzbrm> zzdtu3, zzdtu<zzdae> zzdtu4, zzdtu<zzbpe<AdT>> zzdtu5, zzdtu<Executor> zzdtu6, zzdtu<ScheduledExecutorService> zzdtu7) {
        this.f27058a = zzdtu;
        this.f27059b = zzdtu2;
        this.f27060c = zzdtu3;
        this.f27061d = zzdtu4;
        this.f27062e = zzdtu5;
        this.f27063f = zzdtu6;
        this.f27064g = zzdtu7;
    }

    /* renamed from: a */
    public static <AdT> zzcmz<AdT> m28601a(zzdtu<zzczt> zzdtu, zzdtu<zzcmu> zzdtu2, zzdtu<zzbrm> zzdtu3, zzdtu<zzdae> zzdtu4, zzdtu<zzbpe<AdT>> zzdtu5, zzdtu<Executor> zzdtu6, zzdtu<ScheduledExecutorService> zzdtu7) {
        zzcmz zzcmz = new zzcmz(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5, zzdtu6, zzdtu7);
        return zzcmz;
    }

    public final /* synthetic */ Object get() {
        zzcmx zzcmx = new zzcmx((zzczt) this.f27058a.get(), (zzcmu) this.f27059b.get(), (zzbrm) this.f27060c.get(), (zzdae) this.f27061d.get(), (zzbpe) this.f27062e.get(), (Executor) this.f27063f.get(), (ScheduledExecutorService) this.f27064g.get());
        return zzcmx;
    }
}
