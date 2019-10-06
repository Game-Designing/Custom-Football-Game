package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbns implements zzdti<zzbuz<zzbsr>> {

    /* renamed from: a */
    private final zzbnk f25626a;

    /* renamed from: b */
    private final zzdtu<Context> f25627b;

    /* renamed from: c */
    private final zzdtu<zzbai> f25628c;

    /* renamed from: d */
    private final zzdtu<zzcxm> f25629d;

    /* renamed from: e */
    private final zzdtu<zzcxv> f25630e;

    public zzbns(zzbnk zzbnk, zzdtu<Context> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<zzcxm> zzdtu3, zzdtu<zzcxv> zzdtu4) {
        this.f25626a = zzbnk;
        this.f25627b = zzdtu;
        this.f25628c = zzdtu2;
        this.f25629d = zzdtu3;
        this.f25630e = zzdtu4;
    }

    /* renamed from: a */
    public static zzbuz<zzbsr> m27305a(zzbnk zzbnk, Context context, zzbai zzbai, zzcxm zzcxm, zzcxv zzcxv) {
        zzbuz<zzbsr> zzbuz = new zzbuz<>(new C9210Wf(context, zzbai, zzcxm, zzcxv), zzbbm.f25065b);
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }

    public final /* synthetic */ Object get() {
        return m27305a(this.f25626a, (Context) this.f25627b.get(), (zzbai) this.f25628c.get(), (zzcxm) this.f25629d.get(), (zzcxv) this.f25630e.get());
    }
}
