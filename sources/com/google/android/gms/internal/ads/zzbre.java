package com.google.android.gms.internal.ads;

public final class zzbre implements zzdti<zzcxv> {

    /* renamed from: a */
    private final zzbqy f25832a;

    private zzbre(zzbqy zzbqy) {
        this.f25832a = zzbqy;
    }

    /* renamed from: a */
    public static zzbre m27721a(zzbqy zzbqy) {
        return new zzbre(zzbqy);
    }

    /* renamed from: b */
    public static zzcxv m27722b(zzbqy zzbqy) {
        zzcxv b = zzbqy.mo30868b();
        zzdto.m30114a(b, "Cannot return null from a non-@Nullable @Provides method");
        return b;
    }

    public final /* synthetic */ Object get() {
        return m27722b(this.f25832a);
    }
}
