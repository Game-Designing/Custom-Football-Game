package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcsf implements zzdti<zzcsd> {

    /* renamed from: a */
    private final zzdtu<zzbbl> f27323a;

    /* renamed from: b */
    private final zzdtu<Context> f27324b;

    private zzcsf(zzdtu<zzbbl> zzdtu, zzdtu<Context> zzdtu2) {
        this.f27323a = zzdtu;
        this.f27324b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcsf m28839a(zzdtu<zzbbl> zzdtu, zzdtu<Context> zzdtu2) {
        return new zzcsf(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcsd((zzbbl) this.f27323a.get(), (Context) this.f27324b.get());
    }
}
