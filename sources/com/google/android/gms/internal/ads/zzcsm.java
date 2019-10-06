package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzcsm implements zzdti<zzcsk<zzcsg>> {

    /* renamed from: a */
    private final zzdtu<zzcsh> f27335a;

    /* renamed from: b */
    private final zzdtu<Clock> f27336b;

    public zzcsm(zzdtu<zzcsh> zzdtu, zzdtu<Clock> zzdtu2) {
        this.f27335a = zzdtu;
        this.f27336b = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        zzcsk zzcsk = new zzcsk((zzcsh) this.f27335a.get(), 10000, (Clock) this.f27336b.get());
        zzdto.m30114a(zzcsk, "Cannot return null from a non-@Nullable @Provides method");
        return zzcsk;
    }
}
