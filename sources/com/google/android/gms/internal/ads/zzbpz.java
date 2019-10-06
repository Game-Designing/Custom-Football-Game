package com.google.android.gms.internal.ads;

public final class zzbpz implements zzdti<zzbuz<zzbrl>> {

    /* renamed from: a */
    private final zzbpx f25772a;

    /* renamed from: b */
    private final zzdtu<zzbqe> f25773b;

    private zzbpz(zzbpx zzbpx, zzdtu<zzbqe> zzdtu) {
        this.f25772a = zzbpx;
        this.f25773b = zzdtu;
    }

    /* renamed from: a */
    public static zzbpz m27673a(zzbpx zzbpx, zzdtu<zzbqe> zzdtu) {
        return new zzbpz(zzbpx, zzdtu);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzbqe) this.f25773b.get(), zzbbm.f25065b);
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
