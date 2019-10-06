package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbzg implements zzdti<zzavf> {

    /* renamed from: a */
    private final zzbzf f26173a;

    /* renamed from: b */
    private final zzdtu<Context> f26174b;

    /* renamed from: c */
    private final zzdtu<zzcxv> f26175c;

    private zzbzg(zzbzf zzbzf, zzdtu<Context> zzdtu, zzdtu<zzcxv> zzdtu2) {
        this.f26173a = zzbzf;
        this.f26174b = zzdtu;
        this.f26175c = zzdtu2;
    }

    /* renamed from: a */
    public static zzbzg m28087a(zzbzf zzbzf, zzdtu<Context> zzdtu, zzdtu<zzcxv> zzdtu2) {
        return new zzbzg(zzbzf, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzavf zzavf = new zzavf((Context) this.f26174b.get(), ((zzcxv) this.f26175c.get()).f27602f);
        zzdto.m30114a(zzavf, "Cannot return null from a non-@Nullable @Provides method");
        return zzavf;
    }
}
