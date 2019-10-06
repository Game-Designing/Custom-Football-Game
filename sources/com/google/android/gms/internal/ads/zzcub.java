package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;

public final class zzcub implements zzcuz<Bundle>, zzcva<zzcuz<Bundle>> {

    /* renamed from: a */
    private final ApplicationInfo f27384a;

    /* renamed from: b */
    private final PackageInfo f27385b;

    zzcub(ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        this.f27384a = applicationInfo;
        this.f27385b = packageInfo;
    }

    /* renamed from: a */
    public final zzbbh<zzcuz<Bundle>> mo28586a() {
        return zzbar.m26376a(this);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = this.f27384a.packageName;
        PackageInfo packageInfo = this.f27385b;
        Integer valueOf = packageInfo == null ? null : Integer.valueOf(packageInfo.versionCode);
        bundle.putString("pn", str);
        if (valueOf != null) {
            bundle.putInt("vc", valueOf.intValue());
        }
    }
}
