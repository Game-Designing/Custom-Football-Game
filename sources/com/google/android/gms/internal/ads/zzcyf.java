package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

public final class zzcyf implements zzdti<Clock> {

    /* renamed from: a */
    private final zzcye f27631a;

    public zzcyf(zzcye zzcye) {
        this.f27631a = zzcye;
    }

    public final /* synthetic */ Object get() {
        Clock d = DefaultClock.m22087d();
        zzdto.m30114a(d, "Cannot return null from a non-@Nullable @Provides method");
        return d;
    }
}
