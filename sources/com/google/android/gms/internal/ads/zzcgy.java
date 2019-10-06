package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.List;

public final class zzcgy implements zzdti<zzbbh<zzarx>> {

    /* renamed from: a */
    private final zzdtu<zzczt> f26593a;

    /* renamed from: b */
    private final zzdtu<zzbbh<Bundle>> f26594b;

    /* renamed from: c */
    private final zzdtu<zzbai> f26595c;

    /* renamed from: d */
    private final zzdtu<ApplicationInfo> f26596d;

    /* renamed from: e */
    private final zzdtu<String> f26597e;

    /* renamed from: f */
    private final zzdtu<List<String>> f26598f;

    /* renamed from: g */
    private final zzdtu<PackageInfo> f26599g;

    /* renamed from: h */
    private final zzdtu<zzbbh<String>> f26600h;

    /* renamed from: i */
    private final zzdtu<zzaxb> f26601i;

    /* renamed from: j */
    private final zzdtu<String> f26602j;

    private zzcgy(zzdtu<zzczt> zzdtu, zzdtu<zzbbh<Bundle>> zzdtu2, zzdtu<zzbai> zzdtu3, zzdtu<ApplicationInfo> zzdtu4, zzdtu<String> zzdtu5, zzdtu<List<String>> zzdtu6, zzdtu<PackageInfo> zzdtu7, zzdtu<zzbbh<String>> zzdtu8, zzdtu<zzaxb> zzdtu9, zzdtu<String> zzdtu10) {
        this.f26593a = zzdtu;
        this.f26594b = zzdtu2;
        this.f26595c = zzdtu3;
        this.f26596d = zzdtu4;
        this.f26597e = zzdtu5;
        this.f26598f = zzdtu6;
        this.f26599g = zzdtu7;
        this.f26600h = zzdtu8;
        this.f26601i = zzdtu9;
        this.f26602j = zzdtu10;
    }

    /* renamed from: a */
    public static zzcgy m28426a(zzdtu<zzczt> zzdtu, zzdtu<zzbbh<Bundle>> zzdtu2, zzdtu<zzbai> zzdtu3, zzdtu<ApplicationInfo> zzdtu4, zzdtu<String> zzdtu5, zzdtu<List<String>> zzdtu6, zzdtu<PackageInfo> zzdtu7, zzdtu<zzbbh<String>> zzdtu8, zzdtu<zzaxb> zzdtu9, zzdtu<String> zzdtu10) {
        zzcgy zzcgy = new zzcgy(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5, zzdtu6, zzdtu7, zzdtu8, zzdtu9, zzdtu10);
        return zzcgy;
    }

    public final /* synthetic */ Object get() {
        zzbbh zzbbh = (zzbbh) this.f26594b.get();
        zzbai zzbai = (zzbai) this.f26595c.get();
        ApplicationInfo applicationInfo = (ApplicationInfo) this.f26596d.get();
        String str = (String) this.f26597e.get();
        List list = (List) this.f26598f.get();
        PackageInfo packageInfo = (PackageInfo) this.f26599g.get();
        zzbbh zzbbh2 = (zzbbh) this.f26600h.get();
        zzaxb zzaxb = (zzaxb) this.f26601i.get();
        String str2 = (String) this.f26602j.get();
        zzczh a = ((zzczt) this.f26593a.get()).mo31317a(zzczs.REQUEST_PARCEL, (zzbbh<?>[]) new zzbbh[]{zzbbh, zzbbh2});
        C9125Si si = new C9125Si(zzbbh, zzbai, applicationInfo, str, list, packageInfo, zzbbh2, zzaxb, str2);
        zzcze a2 = a.mo31321a(si).mo31325a();
        zzdto.m30114a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
