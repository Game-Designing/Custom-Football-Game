package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbmm implements zzdti<zzbml> {

    /* renamed from: a */
    private final zzdtu<Context> f25546a;

    /* renamed from: b */
    private final zzdtu<zzty> f25547b;

    private zzbmm(zzdtu<Context> zzdtu, zzdtu<zzty> zzdtu2) {
        this.f25546a = zzdtu;
        this.f25547b = zzdtu2;
    }

    /* renamed from: a */
    public static zzbmm m27255a(zzdtu<Context> zzdtu, zzdtu<zzty> zzdtu2) {
        return new zzbmm(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzbml((Context) this.f25546a.get(), (zzty) this.f25547b.get());
    }
}
