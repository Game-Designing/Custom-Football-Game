package com.crashlytics.android.p126c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import p024io.fabric.sdk.android.p348a.p350b.C13868y;

/* renamed from: com.crashlytics.android.c.a */
/* compiled from: AppData */
class C6471a {

    /* renamed from: a */
    public final String f11611a;

    /* renamed from: b */
    public final String f11612b;

    /* renamed from: c */
    public final String f11613c;

    /* renamed from: d */
    public final String f11614d;

    /* renamed from: e */
    public final String f11615e;

    /* renamed from: f */
    public final String f11616f;

    /* renamed from: a */
    public static C6471a m12611a(Context context, C13868y idManager, String apiKey, String buildId) throws NameNotFoundException {
        String packageName = context.getPackageName();
        String installerPackageName = idManager.mo43264f();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String versionCode = Integer.toString(packageInfo.versionCode);
        String str = packageInfo.versionName;
        if (str == null) {
            str = "0.0";
        }
        C6471a aVar = new C6471a(apiKey, buildId, installerPackageName, packageName, versionCode, str);
        return aVar;
    }

    C6471a(String apiKey, String buildId, String installerPackageName, String packageName, String versionCode, String versionName) {
        this.f11611a = apiKey;
        this.f11612b = buildId;
        this.f11613c = installerPackageName;
        this.f11614d = packageName;
        this.f11615e = versionCode;
        this.f11616f = versionName;
    }
}
