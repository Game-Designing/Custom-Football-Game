package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcst implements zzdti<zzcsp> {

    /* renamed from: a */
    private final zzdtu<Context> f27342a;

    /* renamed from: b */
    private final zzdtu<zzbbl> f27343b;

    private zzcst(zzdtu<Context> zzdtu, zzdtu<zzbbl> zzdtu2) {
        this.f27342a = zzdtu;
        this.f27343b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcst m28846a(zzdtu<Context> zzdtu, zzdtu<zzbbl> zzdtu2) {
        return new zzcst(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcsp((Context) this.f27342a.get(), (zzbbl) this.f27343b.get());
    }
}
