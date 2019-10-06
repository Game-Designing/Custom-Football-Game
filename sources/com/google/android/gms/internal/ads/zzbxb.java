package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbxb implements zzdti<zzbxa> {

    /* renamed from: a */
    private final zzdtu<Context> f25977a;

    /* renamed from: b */
    private final zzdtu<zzbgz> f25978b;

    /* renamed from: c */
    private final zzdtu<zzcxm> f25979c;

    /* renamed from: d */
    private final zzdtu<zzbai> f25980d;

    /* renamed from: e */
    private final zzdtu<Integer> f25981e;

    private zzbxb(zzdtu<Context> zzdtu, zzdtu<zzbgz> zzdtu2, zzdtu<zzcxm> zzdtu3, zzdtu<zzbai> zzdtu4, zzdtu<Integer> zzdtu5) {
        this.f25977a = zzdtu;
        this.f25978b = zzdtu2;
        this.f25979c = zzdtu3;
        this.f25980d = zzdtu4;
        this.f25981e = zzdtu5;
    }

    /* renamed from: a */
    public static zzbxb m27888a(zzdtu<Context> zzdtu, zzdtu<zzbgz> zzdtu2, zzdtu<zzcxm> zzdtu3, zzdtu<zzbai> zzdtu4, zzdtu<Integer> zzdtu5) {
        zzbxb zzbxb = new zzbxb(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5);
        return zzbxb;
    }

    public final /* synthetic */ Object get() {
        zzbxa zzbxa = new zzbxa((Context) this.f25977a.get(), (zzbgz) this.f25978b.get(), (zzcxm) this.f25979c.get(), (zzbai) this.f25980d.get(), ((Integer) this.f25981e.get()).intValue());
        return zzbxa;
    }
}
