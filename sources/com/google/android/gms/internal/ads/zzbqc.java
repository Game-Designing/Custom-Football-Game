package com.google.android.gms.internal.ads;

public final class zzbqc implements zzdti<zzbuz<zzbtk>> {

    /* renamed from: a */
    private final zzbpx f25778a;

    /* renamed from: b */
    private final zzdtu<zzbqe> f25779b;

    private zzbqc(zzbpx zzbpx, zzdtu<zzbqe> zzdtu) {
        this.f25778a = zzbpx;
        this.f25779b = zzdtu;
    }

    /* renamed from: a */
    public static zzbqc m27676a(zzbpx zzbpx, zzdtu<zzbqe> zzdtu) {
        return new zzbqc(zzbpx, zzdtu);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzbqe) this.f25779b.get(), zzbbm.f25065b);
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
