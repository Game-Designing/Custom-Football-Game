package com.google.android.gms.internal.ads;

public final class zzcyp implements zzdti<zzaxb> {

    /* renamed from: a */
    private final zzcyo f27651a;

    /* renamed from: b */
    private final zzdtu<zzcym> f27652b;

    private zzcyp(zzcyo zzcyo, zzdtu<zzcym> zzdtu) {
        this.f27651a = zzcyo;
        this.f27652b = zzdtu;
    }

    /* renamed from: a */
    public static zzcyp m29011a(zzcyo zzcyo, zzdtu<zzcym> zzdtu) {
        return new zzcyp(zzcyo, zzdtu);
    }

    public final /* synthetic */ Object get() {
        zzaxb zzaxb = ((zzcym) this.f27652b.get()).f27645b;
        zzdto.m30114a(zzaxb, "Cannot return null from a non-@Nullable @Provides method");
        return zzaxb;
    }
}
