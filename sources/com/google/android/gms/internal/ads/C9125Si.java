package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.Si */
final /* synthetic */ class C9125Si implements Callable {

    /* renamed from: a */
    private final zzbbh f21698a;

    /* renamed from: b */
    private final zzbai f21699b;

    /* renamed from: c */
    private final ApplicationInfo f21700c;

    /* renamed from: d */
    private final String f21701d;

    /* renamed from: e */
    private final List f21702e;

    /* renamed from: f */
    private final PackageInfo f21703f;

    /* renamed from: g */
    private final zzbbh f21704g;

    /* renamed from: h */
    private final zzaxb f21705h;

    /* renamed from: i */
    private final String f21706i;

    C9125Si(zzbbh zzbbh, zzbai zzbai, ApplicationInfo applicationInfo, String str, List list, PackageInfo packageInfo, zzbbh zzbbh2, zzaxb zzaxb, String str2) {
        this.f21698a = zzbbh;
        this.f21699b = zzbai;
        this.f21700c = applicationInfo;
        this.f21701d = str;
        this.f21702e = list;
        this.f21703f = packageInfo;
        this.f21704g = zzbbh2;
        this.f21705h = zzaxb;
        this.f21706i = str2;
    }

    public final Object call() {
        zzbbh zzbbh = this.f21698a;
        zzbai zzbai = this.f21699b;
        ApplicationInfo applicationInfo = this.f21700c;
        String str = this.f21701d;
        List list = this.f21702e;
        PackageInfo packageInfo = this.f21703f;
        zzbbh zzbbh2 = this.f21704g;
        zzaxb zzaxb = this.f21705h;
        String str2 = this.f21706i;
        zzarx zzarx = new zzarx((Bundle) zzbbh.get(), zzbai, applicationInfo, str, list, packageInfo, (String) zzbbh2.get(), zzaxb.mo30224m(), str2);
        return zzarx;
    }
}
