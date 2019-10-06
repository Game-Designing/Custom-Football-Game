package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcug implements zzdti<zzcue> {

    /* renamed from: a */
    private final zzdtu<zzbbl> f27391a;

    /* renamed from: b */
    private final zzdtu<Bundle> f27392b;

    private zzcug(zzdtu<zzbbl> zzdtu, zzdtu<Bundle> zzdtu2) {
        this.f27391a = zzdtu;
        this.f27392b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcug m28881a(zzdtu<zzbbl> zzdtu, zzdtu<Bundle> zzdtu2) {
        return new zzcug(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcue((zzbbl) this.f27391a.get(), (Bundle) this.f27392b.get());
    }
}
