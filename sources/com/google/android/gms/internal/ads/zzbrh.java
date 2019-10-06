package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbrh implements zzdti<zzavb> {

    /* renamed from: a */
    private final zzbrg f25834a;

    /* renamed from: b */
    private final zzdtu<Context> f25835b;

    /* renamed from: c */
    private final zzdtu<zzbai> f25836c;

    /* renamed from: d */
    private final zzdtu<zzcxm> f25837d;

    /* renamed from: e */
    private final zzdtu<zzavd> f25838e;

    private zzbrh(zzbrg zzbrg, zzdtu<Context> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<zzcxm> zzdtu3, zzdtu<zzavd> zzdtu4) {
        this.f25834a = zzbrg;
        this.f25835b = zzdtu;
        this.f25836c = zzdtu2;
        this.f25837d = zzdtu3;
        this.f25838e = zzdtu4;
    }

    /* renamed from: a */
    public static zzbrh m27724a(zzbrg zzbrg, zzdtu<Context> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<zzcxm> zzdtu3, zzdtu<zzavd> zzdtu4) {
        zzbrh zzbrh = new zzbrh(zzbrg, zzdtu, zzdtu2, zzdtu3, zzdtu4);
        return zzbrh;
    }

    public final /* synthetic */ Object get() {
        Context context = (Context) this.f25835b.get();
        zzbai zzbai = (zzbai) this.f25836c.get();
        zzcxm zzcxm = (zzcxm) this.f25837d.get();
        zzavd zzavd = (zzavd) this.f25838e.get();
        zzauy zzauy = zzcxm.f27573x;
        if (zzauy == null) {
            return null;
        }
        zzauq zzauq = new zzauq(context, zzbai, zzauy, zzcxm.f27565p.f27586b, zzavd);
        return zzauq;
    }
}
