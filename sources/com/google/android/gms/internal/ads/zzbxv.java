package com.google.android.gms.internal.ads;

public final class zzbxv implements zzdti<zzcyb<zzccj>> {

    /* renamed from: a */
    private final zzdtu<zzccj> f26016a;

    /* renamed from: b */
    private final zzdtu<zzbbl> f26017b;

    public zzbxv(zzdtu<zzccj> zzdtu, zzdtu<zzbbl> zzdtu2) {
        this.f26016a = zzdtu;
        this.f26017b = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        zzbbl zzbbl = (zzbbl) this.f26017b.get();
        zzcyb zzcyb = new zzcyb(new C9492ih(this.f26016a), zzbbl);
        zzdto.m30114a(zzcyb, "Cannot return null from a non-@Nullable @Provides method");
        return zzcyb;
    }
}
