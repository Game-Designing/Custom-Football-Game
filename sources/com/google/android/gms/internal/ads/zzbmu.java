package com.google.android.gms.internal.ads;

public final class zzbmu implements zzdti<zzaly> {

    /* renamed from: a */
    private final zzdtu<zzalr> f25579a;

    private zzbmu(zzdtu<zzalr> zzdtu) {
        this.f25579a = zzdtu;
    }

    /* renamed from: a */
    public static zzbmu m27269a(zzdtu<zzalr> zzdtu) {
        return new zzbmu(zzdtu);
    }

    public final /* synthetic */ Object get() {
        zzaly a = ((zzalr) this.f25579a.get()).mo29809a();
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
