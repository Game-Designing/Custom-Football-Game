package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzblf implements zzdti<zzayu> {

    /* renamed from: a */
    private final zzdtu<Context> f25496a;

    public zzblf(zzdtu<Context> zzdtu) {
        this.f25496a = zzdtu;
    }

    public final /* synthetic */ Object get() {
        zzayu zzayu = new zzayu((Context) this.f25496a.get());
        zzdto.m30114a(zzayu, "Cannot return null from a non-@Nullable @Provides method");
        return zzayu;
    }
}
