package com.google.android.gms.internal.ads;

public final class zzbrd implements zzdti<String> {

    /* renamed from: a */
    private final zzbqy f25830a;

    /* renamed from: b */
    private final zzdtu<zzbqe> f25831b;

    private zzbrd(zzbqy zzbqy, zzdtu<zzbqe> zzdtu) {
        this.f25830a = zzbqy;
        this.f25831b = zzdtu;
    }

    /* renamed from: a */
    public static zzbrd m27720a(zzbqy zzbqy, zzdtu<zzbqe> zzdtu) {
        return new zzbrd(zzbqy, zzdtu);
    }

    public final /* synthetic */ Object get() {
        String a = ((zzbqe) this.f25831b.get()).mo30864a();
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
