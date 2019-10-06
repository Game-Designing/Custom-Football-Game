package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcuu implements zzdti<zzcus> {

    /* renamed from: a */
    private final zzdtu<zzavg> f27418a;

    /* renamed from: b */
    private final zzdtu<zzbbl> f27419b;

    /* renamed from: c */
    private final zzdtu<Context> f27420c;

    private zzcuu(zzdtu<zzavg> zzdtu, zzdtu<zzbbl> zzdtu2, zzdtu<Context> zzdtu3) {
        this.f27418a = zzdtu;
        this.f27419b = zzdtu2;
        this.f27420c = zzdtu3;
    }

    /* renamed from: a */
    public static zzcuu m28895a(zzdtu<zzavg> zzdtu, zzdtu<zzbbl> zzdtu2, zzdtu<Context> zzdtu3) {
        return new zzcuu(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        return new zzcus((zzavg) this.f27418a.get(), (zzbbl) this.f27419b.get(), (Context) this.f27420c.get());
    }
}
