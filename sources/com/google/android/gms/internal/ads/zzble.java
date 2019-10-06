package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

public final class zzble implements zzdti<zzdan> {

    /* renamed from: a */
    private final zzdtu<Context> f25495a;

    public zzble(zzdtu<Context> zzdtu) {
        this.f25495a = zzdtu;
    }

    public final /* synthetic */ Object get() {
        zzdan zzdan = new zzdan((Context) this.f25495a.get(), zzk.zzlu().mo30298b());
        zzdto.m30114a(zzdan, "Cannot return null from a non-@Nullable @Provides method");
        return zzdan;
    }
}
