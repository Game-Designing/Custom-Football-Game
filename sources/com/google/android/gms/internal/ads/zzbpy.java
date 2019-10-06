package com.google.android.gms.internal.ads;

public final class zzbpy implements zzdti<zzbuz<zzxr>> {

    /* renamed from: a */
    private final zzbpx f25770a;

    /* renamed from: b */
    private final zzdtu<zzbqe> f25771b;

    private zzbpy(zzbpx zzbpx, zzdtu<zzbqe> zzdtu) {
        this.f25770a = zzbpx;
        this.f25771b = zzdtu;
    }

    /* renamed from: a */
    public static zzbpy m27672a(zzbpx zzbpx, zzdtu<zzbqe> zzdtu) {
        return new zzbpy(zzbpx, zzdtu);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzbqe) this.f25771b.get(), zzbbm.f25065b);
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
