package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbsm;

public final class zzcoi<AdT, AdapterT, ListenerT extends zzbsm> implements zzdti<zzcoe<AdT, AdapterT, ListenerT>> {

    /* renamed from: a */
    private final zzdtu<zzczt> f27112a;

    /* renamed from: b */
    private final zzdtu<zzbbl> f27113b;

    /* renamed from: c */
    private final zzdtu<zzcjz<AdapterT, ListenerT>> f27114c;

    /* renamed from: d */
    private final zzdtu<zzcka<AdT, AdapterT, ListenerT>> f27115d;

    private zzcoi(zzdtu<zzczt> zzdtu, zzdtu<zzbbl> zzdtu2, zzdtu<zzcjz<AdapterT, ListenerT>> zzdtu3, zzdtu<zzcka<AdT, AdapterT, ListenerT>> zzdtu4) {
        this.f27112a = zzdtu;
        this.f27113b = zzdtu2;
        this.f27114c = zzdtu3;
        this.f27115d = zzdtu4;
    }

    /* renamed from: a */
    public static <AdT, AdapterT, ListenerT extends zzbsm> zzcoi<AdT, AdapterT, ListenerT> m28628a(zzdtu<zzczt> zzdtu, zzdtu<zzbbl> zzdtu2, zzdtu<zzcjz<AdapterT, ListenerT>> zzdtu3, zzdtu<zzcka<AdT, AdapterT, ListenerT>> zzdtu4) {
        return new zzcoi<>(zzdtu, zzdtu2, zzdtu3, zzdtu4);
    }

    public final /* synthetic */ Object get() {
        return new zzcoe((zzczt) this.f27112a.get(), (zzbbl) this.f27113b.get(), (zzcjz) this.f27114c.get(), (zzcka) this.f27115d.get());
    }
}
