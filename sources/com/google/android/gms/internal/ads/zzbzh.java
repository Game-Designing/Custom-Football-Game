package com.google.android.gms.internal.ads;

public final class zzbzh implements zzdti<zzbyt> {

    /* renamed from: a */
    private final zzbzf f26176a;

    private zzbzh(zzbzf zzbzf) {
        this.f26176a = zzbzf;
    }

    /* renamed from: a */
    public static zzbzh m28088a(zzbzf zzbzf) {
        return new zzbzh(zzbzf);
    }

    /* renamed from: b */
    public static zzbyt m28089b(zzbzf zzbzf) {
        zzbyt a = zzbzf.mo31049a();
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }

    public final /* synthetic */ Object get() {
        return m28089b(this.f26176a);
    }
}
