package com.google.android.gms.internal.ads;

public final class zzbpu implements zzdti<zzcxu> {

    /* renamed from: a */
    private final zzbpr f25766a;

    private zzbpu(zzbpr zzbpr) {
        this.f25766a = zzbpr;
    }

    /* renamed from: a */
    public static zzbpu m27668a(zzbpr zzbpr) {
        return new zzbpu(zzbpr);
    }

    /* renamed from: b */
    public static zzcxu m27669b(zzbpr zzbpr) {
        zzcxu a = zzbpr.mo30860a();
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }

    public final /* synthetic */ Object get() {
        return m27669b(this.f25766a);
    }
}
