package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcrr implements zzdti<zzcrp> {

    /* renamed from: a */
    private final zzdtu<zzcsk<zzcvf>> f27294a;

    /* renamed from: b */
    private final zzdtu<zzcxv> f27295b;

    /* renamed from: c */
    private final zzdtu<Context> f27296c;

    /* renamed from: d */
    private final zzdtu<zzawm> f27297d;

    private zzcrr(zzdtu<zzcsk<zzcvf>> zzdtu, zzdtu<zzcxv> zzdtu2, zzdtu<Context> zzdtu3, zzdtu<zzawm> zzdtu4) {
        this.f27294a = zzdtu;
        this.f27295b = zzdtu2;
        this.f27296c = zzdtu3;
        this.f27297d = zzdtu4;
    }

    /* renamed from: a */
    public static zzcrr m28829a(zzdtu<zzcsk<zzcvf>> zzdtu, zzdtu<zzcxv> zzdtu2, zzdtu<Context> zzdtu3, zzdtu<zzawm> zzdtu4) {
        return new zzcrr(zzdtu, zzdtu2, zzdtu3, zzdtu4);
    }

    public final /* synthetic */ Object get() {
        return new zzcrp((zzcsk) this.f27294a.get(), (zzcxv) this.f27295b.get(), (Context) this.f27296c.get(), (zzawm) this.f27297d.get());
    }
}
