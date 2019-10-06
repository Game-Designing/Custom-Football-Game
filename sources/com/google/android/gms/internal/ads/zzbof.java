package com.google.android.gms.internal.ads;

public final class zzbof implements zzdti<zzcjv<zzbnf>> {

    /* renamed from: a */
    private final zzdtu<Boolean> f25653a;

    /* renamed from: b */
    private final zzdtu<zzcmo> f25654b;

    /* renamed from: c */
    private final zzdtu<zzcoe<zzbnf, zzams, zzcla>> f25655c;

    public zzbof(zzdtu<Boolean> zzdtu, zzdtu<zzcmo> zzdtu2, zzdtu<zzcoe<zzbnf, zzams, zzcla>> zzdtu3) {
        this.f25653a = zzdtu;
        this.f25654b = zzdtu2;
        this.f25655c = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        zzcjv zzcjv = (zzcmo) this.f25654b.get();
        Object obj = (zzcoe) this.f25655c.get();
        if (!((Boolean) this.f25653a.get()).booleanValue()) {
            zzcjv = obj;
        }
        zzdto.m30114a(zzcjv, "Cannot return null from a non-@Nullable @Provides method");
        return zzcjv;
    }
}
