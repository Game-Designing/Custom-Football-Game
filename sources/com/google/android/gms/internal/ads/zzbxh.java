package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

public final class zzbxh implements zzdti<zzbxg> {

    /* renamed from: a */
    private final zzdtu<zzavf> f25994a;

    /* renamed from: b */
    private final zzdtu<Context> f25995b;

    /* renamed from: c */
    private final zzdtu<zzavg> f25996c;

    /* renamed from: d */
    private final zzdtu<View> f25997d;

    /* renamed from: e */
    private final zzdtu<Integer> f25998e;

    private zzbxh(zzdtu<zzavf> zzdtu, zzdtu<Context> zzdtu2, zzdtu<zzavg> zzdtu3, zzdtu<View> zzdtu4, zzdtu<Integer> zzdtu5) {
        this.f25994a = zzdtu;
        this.f25995b = zzdtu2;
        this.f25996c = zzdtu3;
        this.f25997d = zzdtu4;
        this.f25998e = zzdtu5;
    }

    /* renamed from: a */
    public static zzbxh m27896a(zzdtu<zzavf> zzdtu, zzdtu<Context> zzdtu2, zzdtu<zzavg> zzdtu3, zzdtu<View> zzdtu4, zzdtu<Integer> zzdtu5) {
        zzbxh zzbxh = new zzbxh(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5);
        return zzbxh;
    }

    public final /* synthetic */ Object get() {
        zzbxg zzbxg = new zzbxg((zzavf) this.f25994a.get(), (Context) this.f25995b.get(), (zzavg) this.f25996c.get(), (View) this.f25997d.get(), ((Integer) this.f25998e.get()).intValue());
        return zzbxg;
    }
}
