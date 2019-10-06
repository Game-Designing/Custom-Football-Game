package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbjz implements zzdti<zzasl> {

    /* renamed from: a */
    private final zzdtu<Context> f25434a;

    public zzbjz(zzdtu<Context> zzdtu) {
        this.f25434a = zzdtu;
    }

    public final /* synthetic */ Object get() {
        Context context = (Context) this.f25434a.get();
        zzasj zzasj = new zzasj(context, new zzaso(context).mo30037a());
        zzdto.m30114a(zzasj, "Cannot return null from a non-@Nullable @Provides method");
        return zzasj;
    }
}
