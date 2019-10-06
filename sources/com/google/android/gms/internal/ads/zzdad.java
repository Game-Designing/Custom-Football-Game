package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdad implements zzdti<zzalr> {

    /* renamed from: a */
    private final zzdac f27725a;

    /* renamed from: b */
    private final zzdtu<Context> f27726b;

    /* renamed from: c */
    private final zzdtu<zzbai> f27727c;

    public zzdad(zzdac zzdac, zzdtu<Context> zzdtu, zzdtu<zzbai> zzdtu2) {
        this.f27725a = zzdac;
        this.f27726b = zzdtu;
        this.f27727c = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        zzalr b = new zzalk().mo29807b((Context) this.f27726b.get(), (zzbai) this.f27727c.get());
        zzdto.m30114a(b, "Cannot return null from a non-@Nullable @Provides method");
        return b;
    }
}
