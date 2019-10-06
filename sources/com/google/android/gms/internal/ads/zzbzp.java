package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzbzp implements zzdti<zzbzl> {

    /* renamed from: a */
    private final zzdtu<Context> f26202a;

    /* renamed from: b */
    private final zzdtu<zzaxb> f26203b;

    /* renamed from: c */
    private final zzdtu<zzcxv> f26204c;

    /* renamed from: d */
    private final zzdtu<zzbyx> f26205d;

    /* renamed from: e */
    private final zzdtu<zzbyt> f26206e;

    /* renamed from: f */
    private final zzdtu<zzbzt> f26207f;

    /* renamed from: g */
    private final zzdtu<Executor> f26208g;

    /* renamed from: h */
    private final zzdtu<Executor> f26209h;

    private zzbzp(zzdtu<Context> zzdtu, zzdtu<zzaxb> zzdtu2, zzdtu<zzcxv> zzdtu3, zzdtu<zzbyx> zzdtu4, zzdtu<zzbyt> zzdtu5, zzdtu<zzbzt> zzdtu6, zzdtu<Executor> zzdtu7, zzdtu<Executor> zzdtu8) {
        this.f26202a = zzdtu;
        this.f26203b = zzdtu2;
        this.f26204c = zzdtu3;
        this.f26205d = zzdtu4;
        this.f26206e = zzdtu5;
        this.f26207f = zzdtu6;
        this.f26208g = zzdtu7;
        this.f26209h = zzdtu8;
    }

    /* renamed from: a */
    public static zzbzp m28126a(zzdtu<Context> zzdtu, zzdtu<zzaxb> zzdtu2, zzdtu<zzcxv> zzdtu3, zzdtu<zzbyx> zzdtu4, zzdtu<zzbyt> zzdtu5, zzdtu<zzbzt> zzdtu6, zzdtu<Executor> zzdtu7, zzdtu<Executor> zzdtu8) {
        zzbzp zzbzp = new zzbzp(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5, zzdtu6, zzdtu7, zzdtu8);
        return zzbzp;
    }

    public final /* synthetic */ Object get() {
        zzbzl zzbzl = new zzbzl((Context) this.f26202a.get(), (zzaxb) this.f26203b.get(), (zzcxv) this.f26204c.get(), (zzbyx) this.f26205d.get(), (zzbyt) this.f26206e.get(), (zzbzt) this.f26207f.get(), (Executor) this.f26208g.get(), (Executor) this.f26209h.get());
        return zzbzl;
    }
}
