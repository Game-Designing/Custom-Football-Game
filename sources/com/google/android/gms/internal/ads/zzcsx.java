package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcsx implements zzdti<zzcsv> {

    /* renamed from: a */
    private final zzdtu<Context> f27347a;

    /* renamed from: b */
    private final zzdtu<zzbbl> f27348b;

    private zzcsx(zzdtu<Context> zzdtu, zzdtu<zzbbl> zzdtu2) {
        this.f27347a = zzdtu;
        this.f27348b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcsx m28849a(zzdtu<Context> zzdtu, zzdtu<zzbbl> zzdtu2) {
        return new zzcsx(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcsv((Context) this.f27347a.get(), (zzbbl) this.f27348b.get());
    }
}
