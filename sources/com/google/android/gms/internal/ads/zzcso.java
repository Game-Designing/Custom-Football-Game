package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzcso implements zzdti<zzcxk> {

    /* renamed from: a */
    private final zzdtu<Clock> f27339a;

    public zzcso(zzdtu<Clock> zzdtu) {
        this.f27339a = zzdtu;
    }

    public final /* synthetic */ Object get() {
        zzcxk zzcxk = new zzcxk((Clock) this.f27339a.get());
        zzdto.m30114a(zzcxk, "Cannot return null from a non-@Nullable @Provides method");
        return zzcxk;
    }
}
