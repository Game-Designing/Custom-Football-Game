package com.google.android.gms.internal.ads;

public final class zzbpt implements zzdti<String> {

    /* renamed from: a */
    private final zzbpr f25765a;

    private zzbpt(zzbpr zzbpr) {
        this.f25765a = zzbpr;
    }

    /* renamed from: a */
    public static zzbpt m27666a(zzbpr zzbpr) {
        return new zzbpt(zzbpr);
    }

    /* renamed from: b */
    public static String m27667b(zzbpr zzbpr) {
        String c = zzbpr.mo30862c();
        zzdto.m30114a(c, "Cannot return null from a non-@Nullable @Provides method");
        return c;
    }

    public final /* synthetic */ Object get() {
        return m27667b(this.f25765a);
    }
}
