package com.google.android.gms.internal.ads;

public final class zzcoy implements zzdti<zzcow> {

    /* renamed from: a */
    private final zzcow f27149a;

    private zzcoy(zzcow zzcow) {
        this.f27149a = zzcow;
    }

    /* renamed from: a */
    public static zzcoy m28649a(zzcow zzcow) {
        return new zzcoy(zzcow);
    }

    public final /* synthetic */ Object get() {
        zzcow zzcow = this.f27149a;
        if (zzcow != null) {
            zzdto.m30114a(zzcow, "Cannot return null from a non-@Nullable @Provides method");
            return zzcow;
        }
        throw null;
    }
}
