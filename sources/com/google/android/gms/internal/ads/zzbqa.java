package com.google.android.gms.internal.ads;

public final class zzbqa implements zzdti<zzbuz<zzbrw>> {

    /* renamed from: a */
    private final zzbpx f25774a;

    /* renamed from: b */
    private final zzdtu<zzbqe> f25775b;

    private zzbqa(zzbpx zzbpx, zzdtu<zzbqe> zzdtu) {
        this.f25774a = zzbpx;
        this.f25775b = zzdtu;
    }

    /* renamed from: a */
    public static zzbqa m27674a(zzbpx zzbpx, zzdtu<zzbqe> zzdtu) {
        return new zzbqa(zzbpx, zzdtu);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzbqe) this.f25775b.get(), zzbbm.f25065b);
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
