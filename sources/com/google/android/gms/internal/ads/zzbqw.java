package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbqw implements zzdti<zzbam<zzcxm, zzayb>> {

    /* renamed from: a */
    private final zzdtu<Context> f25814a;

    /* renamed from: b */
    private final zzdtu<zzbai> f25815b;

    /* renamed from: c */
    private final zzdtu<zzcxv> f25816c;

    public zzbqw(zzdtu<Context> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<zzcxv> zzdtu3) {
        this.f25814a = zzdtu;
        this.f25815b = zzdtu2;
        this.f25816c = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        C9491ig igVar = new C9491ig((Context) this.f25814a.get(), (zzbai) this.f25815b.get(), (zzcxv) this.f25816c.get());
        zzdto.m30114a(igVar, "Cannot return null from a non-@Nullable @Provides method");
        return igVar;
    }
}
