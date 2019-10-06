package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbjr implements zzdti<Context> {

    /* renamed from: a */
    private final zzbjn f25423a;

    public zzbjr(zzbjn zzbjn) {
        this.f25423a = zzbjn;
    }

    public final /* synthetic */ Object get() {
        Context b = this.f25423a.mo30704b();
        zzdto.m30114a(b, "Cannot return null from a non-@Nullable @Provides method");
        return b;
    }
}
