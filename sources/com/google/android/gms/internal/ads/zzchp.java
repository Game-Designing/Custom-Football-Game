package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzchp implements zzdti<zzchl> {

    /* renamed from: a */
    private final zzdtu<zzbtg> f26635a;

    /* renamed from: b */
    private final zzdtu<zzcxv> f26636b;

    /* renamed from: c */
    private final zzdtu<zzcgn> f26637c;

    /* renamed from: d */
    private final zzdtu<zzbbl> f26638d;

    /* renamed from: e */
    private final zzdtu<ScheduledExecutorService> f26639e;

    /* renamed from: f */
    private final zzdtu<zzcji> f26640f;

    private zzchp(zzdtu<zzbtg> zzdtu, zzdtu<zzcxv> zzdtu2, zzdtu<zzcgn> zzdtu3, zzdtu<zzbbl> zzdtu4, zzdtu<ScheduledExecutorService> zzdtu5, zzdtu<zzcji> zzdtu6) {
        this.f26635a = zzdtu;
        this.f26636b = zzdtu2;
        this.f26637c = zzdtu3;
        this.f26638d = zzdtu4;
        this.f26639e = zzdtu5;
        this.f26640f = zzdtu6;
    }

    /* renamed from: a */
    public static zzchp m28446a(zzdtu<zzbtg> zzdtu, zzdtu<zzcxv> zzdtu2, zzdtu<zzcgn> zzdtu3, zzdtu<zzbbl> zzdtu4, zzdtu<ScheduledExecutorService> zzdtu5, zzdtu<zzcji> zzdtu6) {
        zzchp zzchp = new zzchp(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5, zzdtu6);
        return zzchp;
    }

    public final /* synthetic */ Object get() {
        zzchl zzchl = new zzchl((zzbtg) this.f26635a.get(), (zzcxv) this.f26636b.get(), (zzcgn) this.f26637c.get(), (zzbbl) this.f26638d.get(), (ScheduledExecutorService) this.f26639e.get(), (zzcji) this.f26640f.get());
        return zzchl;
    }
}
