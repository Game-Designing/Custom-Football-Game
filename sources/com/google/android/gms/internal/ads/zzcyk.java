package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.ads.internal.zzg;
import java.util.HashMap;
import java.util.Map;

public final class zzcyk {

    /* renamed from: a */
    private final Map<String, zzcym> f27639a = new HashMap();

    /* renamed from: b */
    private final Context f27640b;

    /* renamed from: c */
    private final zzawm f27641c;

    /* renamed from: d */
    private final zzbai f27642d;

    /* renamed from: e */
    private final zzdh f27643e;

    public zzcyk(Context context, zzbai zzbai, zzawm zzawm) {
        this.f27640b = context;
        this.f27642d = zzbai;
        this.f27641c = zzawm;
        this.f27643e = new zzdh(new zzg(context, zzbai));
    }

    /* renamed from: a */
    public final zzcym mo31308a(String str) {
        if (str == null) {
            return m29008a();
        }
        if (this.f27639a.containsKey(str)) {
            return (zzcym) this.f27639a.get(str);
        }
        zzcym b = m29009b(str);
        this.f27639a.put(str, b);
        return b;
    }

    /* renamed from: a */
    private final zzcym m29008a() {
        zzcym zzcym = new zzcym(this.f27640b, this.f27641c.mo30177i(), this.f27641c.mo30179k(), this.f27643e);
        return zzcym;
    }

    /* renamed from: b */
    private final zzcym m29009b(String str) {
        zzasq a = zzasq.m25743a(this.f27640b);
        try {
            a.mo30053a(str);
            zzaxc zzaxc = new zzaxc();
            zzaxc.mo30227a(this.f27640b, str, false);
            zzaxf zzaxf = new zzaxf(this.f27641c.mo30177i(), zzaxc);
            zzcym zzcym = new zzcym(a, zzaxf, new zzawu(zzazt.m26316c(), zzaxf), new zzdh(new zzg(this.f27640b, this.f27642d)));
            return zzcym;
        } catch (NameNotFoundException e) {
            return m29008a();
        }
    }
}
