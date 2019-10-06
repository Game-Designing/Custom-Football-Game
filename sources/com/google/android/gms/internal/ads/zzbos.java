package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbos implements zzdti<zzbol> {

    /* renamed from: a */
    private final zzdtu<zzaga> f25674a;

    /* renamed from: b */
    private final zzdtu<Runnable> f25675b;

    /* renamed from: c */
    private final zzdtu<Executor> f25676c;

    /* renamed from: d */
    private final zzdtu<zzcxu> f25677d;

    /* renamed from: e */
    private final zzdtu<zzcxm> f25678e;

    /* renamed from: f */
    private final zzdtu<zzbry> f25679f;

    /* renamed from: g */
    private final zzdtu<zzbso> f25680g;

    /* renamed from: h */
    private final zzdtu<String> f25681h;

    public zzbos(zzdtu<zzaga> zzdtu, zzdtu<Runnable> zzdtu2, zzdtu<Executor> zzdtu3, zzdtu<zzcxu> zzdtu4, zzdtu<zzcxm> zzdtu5, zzdtu<zzbry> zzdtu6, zzdtu<zzbso> zzdtu7, zzdtu<String> zzdtu8) {
        this.f25674a = zzdtu;
        this.f25675b = zzdtu2;
        this.f25676c = zzdtu3;
        this.f25677d = zzdtu4;
        this.f25678e = zzdtu5;
        this.f25679f = zzdtu6;
        this.f25680g = zzdtu7;
        this.f25681h = zzdtu8;
    }

    public final /* synthetic */ Object get() {
        zzbol zzbol = new zzbol((zzaga) this.f25674a.get(), (Runnable) this.f25675b.get(), (Executor) this.f25676c.get());
        zzbql.m27693a((zzbpc) zzbol, (zzcxu) this.f25677d.get());
        zzbql.m27692a((zzbpc) zzbol, (zzcxm) this.f25678e.get());
        zzbql.m27690a((zzbpc) zzbol, (zzbry) this.f25679f.get());
        zzbql.m27691a((zzbpc) zzbol, (zzbso) this.f25680g.get());
        zzbql.m27694a((zzbpc) zzbol, (String) this.f25681h.get());
        return zzbol;
    }
}
