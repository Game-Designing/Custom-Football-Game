package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzchi implements zzdti<zzchv> {

    /* renamed from: a */
    private final zzdtu<Context> f26627a;

    private zzchi(zzdtu<Context> zzdtu) {
        this.f26627a = zzdtu;
    }

    /* renamed from: a */
    public static zzchi m28438a(zzdtu<Context> zzdtu) {
        return new zzchi(zzdtu);
    }

    public final /* synthetic */ Object get() {
        zzchv zzchv = new zzchv((Context) this.f26627a.get());
        zzdto.m30114a(zzchv, "Cannot return null from a non-@Nullable @Provides method");
        return zzchv;
    }
}
