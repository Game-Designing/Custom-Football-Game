package com.google.android.gms.internal.ads;

public final class zzbxm implements zzdti<zzbxk> {

    /* renamed from: a */
    private final zzbxk f26007a;

    private zzbxm(zzbxk zzbxk) {
        this.f26007a = zzbxk;
    }

    /* renamed from: a */
    public static zzbxm m27899a(zzbxk zzbxk) {
        return new zzbxm(zzbxk);
    }

    public final /* synthetic */ Object get() {
        zzbxk zzbxk = this.f26007a;
        if (zzbxk != null) {
            zzdto.m30114a(zzbxk, "Cannot return null from a non-@Nullable @Provides method");
            return zzbxk;
        }
        throw null;
    }
}
