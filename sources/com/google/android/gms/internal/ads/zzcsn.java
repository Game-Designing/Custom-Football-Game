package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzcsn implements zzdti<zzcsk<zzcvf>> {

    /* renamed from: a */
    private final zzdtu<C9128Sl> f27337a;

    /* renamed from: b */
    private final zzdtu<Clock> f27338b;

    public zzcsn(zzdtu<C9128Sl> zzdtu, zzdtu<Clock> zzdtu2) {
        this.f27337a = zzdtu;
        this.f27338b = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        C9128Sl sl = (C9128Sl) this.f27337a.get();
        zzcsk zzcsk = new zzcsk(sl, ((Long) zzyt.m31536e().mo29599a(zzacu.f24006Sb)).longValue(), (Clock) this.f27338b.get());
        zzdto.m30114a(zzcsk, "Cannot return null from a non-@Nullable @Provides method");
        return zzcsk;
    }
}
