package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzbun implements zzdti<zzcmu> {

    /* renamed from: a */
    private final zzbtv f25894a;

    /* renamed from: b */
    private final zzdtu<Clock> f25895b;

    private zzbun(zzbtv zzbtv, zzdtu<Clock> zzdtu) {
        this.f25894a = zzbtv;
        this.f25895b = zzdtu;
    }

    /* renamed from: a */
    public static zzbun m27817a(zzbtv zzbtv, zzdtu<Clock> zzdtu) {
        return new zzbun(zzbtv, zzdtu);
    }

    public final /* synthetic */ Object get() {
        zzcmu a = this.f25894a.mo30899a((Clock) this.f25895b.get());
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
