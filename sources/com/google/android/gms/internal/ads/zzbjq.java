package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbjq implements zzdti<Context> {

    /* renamed from: a */
    private final zzbjn f25422a;

    public zzbjq(zzbjn zzbjn) {
        this.f25422a = zzbjn;
    }

    /* renamed from: a */
    public static Context m27122a(zzbjn zzbjn) {
        Context a = zzbjn.mo30703a();
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }

    public final /* synthetic */ Object get() {
        return m27122a(this.f25422a);
    }
}
