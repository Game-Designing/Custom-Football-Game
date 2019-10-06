package com.google.android.gms.internal.ads;

public final class zzbxn implements zzdti<zzbzc> {

    /* renamed from: a */
    private final zzbxk f26008a;

    private zzbxn(zzbxk zzbxk) {
        this.f26008a = zzbxk;
    }

    /* renamed from: a */
    public static zzbxn m27900a(zzbxk zzbxk) {
        return new zzbxn(zzbxk);
    }

    /* renamed from: b */
    public static zzbzc m27901b(zzbxk zzbxk) {
        zzbzc a = zzbxk.mo30939a();
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }

    public final /* synthetic */ Object get() {
        return m27901b(this.f26008a);
    }
}
