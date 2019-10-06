package com.google.android.gms.internal.ads;

public final class zzcys implements zzdti<zzdh> {

    /* renamed from: a */
    private final zzcyo f27658a;

    /* renamed from: b */
    private final zzdtu<zzcym> f27659b;

    private zzcys(zzcyo zzcyo, zzdtu<zzcym> zzdtu) {
        this.f27658a = zzcyo;
        this.f27659b = zzdtu;
    }

    /* renamed from: a */
    public static zzcys m29014a(zzcyo zzcyo, zzdtu<zzcym> zzdtu) {
        return new zzcys(zzcyo, zzdtu);
    }

    public final /* synthetic */ Object get() {
        zzdh zzdh = ((zzcym) this.f27659b.get()).f27647d;
        zzdto.m30114a(zzdh, "Cannot return null from a non-@Nullable @Provides method");
        return zzdh;
    }
}
