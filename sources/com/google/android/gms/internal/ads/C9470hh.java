package com.google.android.gms.internal.ads;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.hh */
final class C9470hh implements zzbpe<zzbph> {

    /* renamed from: a */
    private final Map<String, zzcjv<zzbph>> f22409a;

    /* renamed from: b */
    private final Map<String, zzcjv<zzbyn>> f22410b;

    /* renamed from: c */
    private final Map<String, zzclw<zzbyn>> f22411c;

    /* renamed from: d */
    private final zzdtu<zzbpe<zzbnf>> f22412d;

    /* renamed from: e */
    private final zzbzc f22413e;

    C9470hh(Map<String, zzcjv<zzbph>> map, Map<String, zzcjv<zzbyn>> map2, Map<String, zzclw<zzbyn>> map3, zzdtu<zzbpe<zzbnf>> zzdtu, zzbzc zzbzc) {
        this.f22409a = map;
        this.f22410b = map2;
        this.f22411c = map3;
        this.f22412d = zzdtu;
        this.f22413e = zzbzc;
    }

    /* renamed from: a */
    public final zzcjv<zzbph> mo28990a(int i, String str) {
        zzcjv<zzbph> zzcjv = (zzcjv) this.f22409a.get(str);
        if (zzcjv != null) {
            return zzcjv;
        }
        if (i != 1) {
            if (i != 4) {
                return null;
            }
            zzclw zzclw = (zzclw) this.f22411c.get(str);
            if (zzclw != null) {
                return zzbph.m27653a(zzclw);
            }
            zzcjv zzcjv2 = (zzcjv) this.f22410b.get(str);
            if (zzcjv2 != null) {
                return zzbph.m27652a(zzcjv2);
            }
            return null;
        } else if (this.f22413e.mo31038d() == null) {
            return null;
        } else {
            zzcjv a = ((zzbpe) this.f22412d.get()).mo28990a(i, str);
            if (a == null) {
                return null;
            }
            return zzbph.m27652a(a);
        }
    }
}
