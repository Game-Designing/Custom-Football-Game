package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcef implements zzdti<zzwj> {

    /* renamed from: a */
    private final zzdtu<Context> f26471a;

    /* renamed from: b */
    private final zzdtu<String> f26472b;

    /* renamed from: c */
    private final zzdtu<zzbai> f26473c;

    /* renamed from: d */
    private final zzdtu<Integer> f26474d;

    /* renamed from: e */
    private final zzdtu<String> f26475e;

    private zzcef(zzdtu<Context> zzdtu, zzdtu<String> zzdtu2, zzdtu<zzbai> zzdtu3, zzdtu<Integer> zzdtu4, zzdtu<String> zzdtu5) {
        this.f26471a = zzdtu;
        this.f26472b = zzdtu2;
        this.f26473c = zzdtu3;
        this.f26474d = zzdtu4;
        this.f26475e = zzdtu5;
    }

    /* renamed from: a */
    public static zzcef m28327a(zzdtu<Context> zzdtu, zzdtu<String> zzdtu2, zzdtu<zzbai> zzdtu3, zzdtu<Integer> zzdtu4, zzdtu<String> zzdtu5) {
        zzcef zzcef = new zzcef(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5);
        return zzcef;
    }

    public final /* synthetic */ Object get() {
        Context context = (Context) this.f26471a.get();
        String str = (String) this.f26472b.get();
        zzbai zzbai = (zzbai) this.f26473c.get();
        int intValue = ((Integer) this.f26474d.get()).intValue();
        String str2 = (String) this.f26475e.get();
        zzwj zzwj = new zzwj(new zzwo(context));
        zzxo zzxo = new zzxo();
        zzxo.f29698c = Integer.valueOf(zzbai.f25058b);
        zzxo.f29699d = Integer.valueOf(zzbai.f25059c);
        zzxo.f29700e = Integer.valueOf(zzbai.f25060d ? 0 : 2);
        zzwj.mo32329a((zzwk) new C9836yi(intValue, str, zzxo, str2));
        zzdto.m30114a(zzwj, "Cannot return null from a non-@Nullable @Provides method");
        return zzwj;
    }
}
