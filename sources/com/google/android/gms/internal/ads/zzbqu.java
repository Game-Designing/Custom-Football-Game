package com.google.android.gms.internal.ads;

public final class zzbqu implements zzdti<zzbuz<zzbtk>> {

    /* renamed from: a */
    private final zzbqt f25812a;

    /* renamed from: b */
    private final zzdtu<zzbqr> f25813b;

    private zzbqu(zzbqt zzbqt, zzdtu<zzbqr> zzdtu) {
        this.f25812a = zzbqt;
        this.f25813b = zzdtu;
    }

    /* renamed from: a */
    public static zzbqu m27701a(zzbqt zzbqt, zzdtu<zzbqr> zzdtu) {
        return new zzbqu(zzbqt, zzdtu);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzbqr) this.f25813b.get(), zzbbm.f25065b);
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
