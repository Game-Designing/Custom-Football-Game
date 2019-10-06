package com.google.android.gms.internal.ads;

public final class zzbps implements zzdti<zzcxm> {

    /* renamed from: a */
    private final zzbpr f25764a;

    private zzbps(zzbpr zzbpr) {
        this.f25764a = zzbpr;
    }

    /* renamed from: a */
    public static zzbps m27664a(zzbpr zzbpr) {
        return new zzbps(zzbpr);
    }

    /* renamed from: b */
    public static zzcxm m27665b(zzbpr zzbpr) {
        zzcxm b = zzbpr.mo30861b();
        zzdto.m30114a(b, "Cannot return null from a non-@Nullable @Provides method");
        return b;
    }

    public final /* synthetic */ Object get() {
        return m27665b(this.f25764a);
    }
}
