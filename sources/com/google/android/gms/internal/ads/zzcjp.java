package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

public final class zzcjp implements zzdti<zzcjm> {

    /* renamed from: a */
    private final zzdtu<Context> f26716a;

    /* renamed from: b */
    private final zzdtu<zzbbh<Bundle>> f26717b;

    /* renamed from: c */
    private final zzdtu<zzcji> f26718c;

    /* renamed from: d */
    private final zzdtu<zzcjc> f26719d;

    private zzcjp(zzdtu<Context> zzdtu, zzdtu<zzbbh<Bundle>> zzdtu2, zzdtu<zzcji> zzdtu3, zzdtu<zzcjc> zzdtu4) {
        this.f26716a = zzdtu;
        this.f26717b = zzdtu2;
        this.f26718c = zzdtu3;
        this.f26719d = zzdtu4;
    }

    /* renamed from: a */
    public static zzcjp m28501a(zzdtu<Context> zzdtu, zzdtu<zzbbh<Bundle>> zzdtu2, zzdtu<zzcji> zzdtu3, zzdtu<zzcjc> zzdtu4) {
        return new zzcjp(zzdtu, zzdtu2, zzdtu3, zzdtu4);
    }

    public final /* synthetic */ Object get() {
        return new zzcjm((Context) this.f26716a.get(), (zzbbh) this.f26717b.get(), (zzcji) this.f26718c.get(), (zzcjc) this.f26719d.get());
    }
}
