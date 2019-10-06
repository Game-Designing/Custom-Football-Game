package com.google.android.gms.internal.ads;

public final class zzbqb implements zzdti<zzbuz<zzbsr>> {

    /* renamed from: a */
    private final zzbpx f25776a;

    /* renamed from: b */
    private final zzdtu<zzbqe> f25777b;

    private zzbqb(zzbpx zzbpx, zzdtu<zzbqe> zzdtu) {
        this.f25776a = zzbpx;
        this.f25777b = zzdtu;
    }

    /* renamed from: a */
    public static zzbqb m27675a(zzbpx zzbpx, zzdtu<zzbqe> zzdtu) {
        return new zzbqb(zzbpx, zzdtu);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzbqe) this.f25777b.get(), zzbbm.f25065b);
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
