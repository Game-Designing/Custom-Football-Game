package com.google.android.gms.internal.ads;

public final class zzcyq implements zzdti<zzcym> {

    /* renamed from: a */
    private final zzcyo f27653a;

    /* renamed from: b */
    private final zzdtu<zzcyk> f27654b;

    /* renamed from: c */
    private final zzdtu<String> f27655c;

    private zzcyq(zzcyo zzcyo, zzdtu<zzcyk> zzdtu, zzdtu<String> zzdtu2) {
        this.f27653a = zzcyo;
        this.f27654b = zzdtu;
        this.f27655c = zzdtu2;
    }

    /* renamed from: a */
    public static zzcyq m29012a(zzcyo zzcyo, zzdtu<zzcyk> zzdtu, zzdtu<String> zzdtu2) {
        return new zzcyq(zzcyo, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzcym a = ((zzcyk) this.f27654b.get()).mo31308a((String) this.f27655c.get());
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
