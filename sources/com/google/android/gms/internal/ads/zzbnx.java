package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbnx implements zzdti<zzavf> {

    /* renamed from: a */
    private final zzbnk f25639a;

    /* renamed from: b */
    private final zzdtu<Context> f25640b;

    /* renamed from: c */
    private final zzdtu<zzcxv> f25641c;

    public zzbnx(zzbnk zzbnk, zzdtu<Context> zzdtu, zzdtu<zzcxv> zzdtu2) {
        this.f25639a = zzbnk;
        this.f25640b = zzdtu;
        this.f25641c = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        zzavf zzavf = new zzavf((Context) this.f25640b.get(), ((zzcxv) this.f25641c.get()).f27602f);
        zzdto.m30114a(zzavf, "Cannot return null from a non-@Nullable @Provides method");
        return zzavf;
    }
}
