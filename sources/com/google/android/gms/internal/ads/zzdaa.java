package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzdaa implements zzdti<zzczt> {

    /* renamed from: a */
    private final zzdtu<zzbbl> f27721a;

    /* renamed from: b */
    private final zzdtu<ScheduledExecutorService> f27722b;

    /* renamed from: c */
    private final zzdtu<C8752Am> f27723c;

    private zzdaa(zzdtu<zzbbl> zzdtu, zzdtu<ScheduledExecutorService> zzdtu2, zzdtu<C8752Am> zzdtu3) {
        this.f27721a = zzdtu;
        this.f27722b = zzdtu2;
        this.f27723c = zzdtu3;
    }

    /* renamed from: a */
    public static zzdaa m29069a(zzdtu<zzbbl> zzdtu, zzdtu<ScheduledExecutorService> zzdtu2, zzdtu<C8752Am> zzdtu3) {
        return new zzdaa(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        return new zzczt((zzbbl) this.f27721a.get(), (ScheduledExecutorService) this.f27722b.get(), (C8752Am) this.f27723c.get());
    }
}
