package com.google.android.gms.internal.ads;

public final class zzcyh implements zzdti<zzbuz<zzbro>> {

    /* renamed from: a */
    private final zzcyg f27632a;

    /* renamed from: b */
    private final zzdtu<zzcyi> f27633b;

    private zzcyh(zzcyg zzcyg, zzdtu<zzcyi> zzdtu) {
        this.f27632a = zzcyg;
        this.f27633b = zzdtu;
    }

    /* renamed from: a */
    public static zzcyh m29004a(zzcyg zzcyg, zzdtu<zzcyi> zzdtu) {
        return new zzcyh(zzcyg, zzdtu);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzcyi) this.f27633b.get(), zzbbm.f25065b);
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
