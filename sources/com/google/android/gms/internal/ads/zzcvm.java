package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcvm implements zzdti<zzcvk> {

    /* renamed from: a */
    private final zzdtu<zzbbl> f27459a;

    /* renamed from: b */
    private final zzdtu<Context> f27460b;

    private zzcvm(zzdtu<zzbbl> zzdtu, zzdtu<Context> zzdtu2) {
        this.f27459a = zzdtu;
        this.f27460b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcvm m28909a(zzdtu<zzbbl> zzdtu, zzdtu<Context> zzdtu2) {
        return new zzcvm(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcvk((zzbbl) this.f27459a.get(), (Context) this.f27460b.get());
    }
}
