package com.inmobi.commons.core.utilities.p225b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.security.NetworkSecurityPolicy;
import com.inmobi.commons.p217a.C10619a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.inmobi.commons.core.utilities.b.a */
/* compiled from: AppInfo */
public class C10690a {

    /* renamed from: d */
    private static final String f32617d = C10690a.class.getSimpleName();

    /* renamed from: e */
    private static C10690a f32618e;

    /* renamed from: f */
    private static Object f32619f = new Object();

    /* renamed from: a */
    public String f32620a;

    /* renamed from: b */
    public Map<String, String> f32621b = new HashMap();

    /* renamed from: c */
    public int f32622c;

    /* renamed from: g */
    private String f32623g;

    /* renamed from: h */
    private String f32624h;

    /* renamed from: i */
    private String f32625i;

    private C10690a() {
        Context b = C10619a.m34839b();
        try {
            PackageManager packageManager = b.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(b.getPackageName(), 128);
            if (applicationInfo != null) {
                this.f32623g = applicationInfo.packageName;
                this.f32624h = applicationInfo.loadLabel(packageManager).toString();
                this.f32620a = packageManager.getInstallerPackageName(this.f32623g);
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(b.getPackageName(), 128);
            String str = null;
            String str2 = "";
            if (packageInfo != null) {
                str = packageInfo.versionName;
                if (str == null || str.equals(str2)) {
                    if (VERSION.SDK_INT < 28) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(packageInfo.versionCode);
                        str = sb.toString();
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(packageInfo.getLongVersionCode());
                        str = sb2.toString();
                    }
                }
            }
            if (str != null && !str.equals(str2)) {
                this.f32625i = str;
            }
        } catch (Exception e) {
        }
        this.f32622c = m35098b();
        this.f32621b.put("u-appbid", this.f32623g);
        this.f32621b.put("u-appdnm", this.f32624h);
        this.f32621b.put("u-appver", this.f32625i);
        this.f32621b.put("u-appsecure", Integer.toString(this.f32622c));
    }

    /* renamed from: a */
    public static C10690a m35097a() {
        C10690a aVar = f32618e;
        if (aVar == null) {
            synchronized (f32619f) {
                aVar = f32618e;
                if (aVar == null) {
                    aVar = new C10690a();
                    f32618e = aVar;
                }
            }
        }
        return aVar;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    private static int m35098b() {
        try {
            if (VERSION.SDK_INT < 23 || NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                return 0;
            }
            return 1;
        } catch (Exception e) {
            return 2;
        }
    }
}
