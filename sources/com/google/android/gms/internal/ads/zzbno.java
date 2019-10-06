package com.google.android.gms.internal.ads;

import android.view.View;

public final class zzbno implements zzdti<View> {

    /* renamed from: a */
    private final zzbnk f25621a;

    public zzbno(zzbnk zzbnk) {
        this.f25621a = zzbnk;
    }

    /* renamed from: a */
    public static View m27301a(zzbnk zzbnk) {
        View a = zzbnk.mo30750a();
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }

    public final /* synthetic */ Object get() {
        return m27301a(this.f25621a);
    }
}
