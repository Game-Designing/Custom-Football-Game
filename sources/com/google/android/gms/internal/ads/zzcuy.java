package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcuy implements zzdti<zzcuw> {

    /* renamed from: a */
    private final zzdtu<zzbbl> f27430a;

    /* renamed from: b */
    private final zzdtu<Context> f27431b;

    /* renamed from: c */
    private final zzdtu<zzbai> f27432c;

    private zzcuy(zzdtu<zzbbl> zzdtu, zzdtu<Context> zzdtu2, zzdtu<zzbai> zzdtu3) {
        this.f27430a = zzdtu;
        this.f27431b = zzdtu2;
        this.f27432c = zzdtu3;
    }

    /* renamed from: a */
    public static zzcuy m28899a(zzdtu<zzbbl> zzdtu, zzdtu<Context> zzdtu2, zzdtu<zzbai> zzdtu3) {
        return new zzcuy(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        return new zzcuw((zzbbl) this.f27430a.get(), (Context) this.f27431b.get(), (zzbai) this.f27432c.get());
    }
}
