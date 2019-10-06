package com.smaato.soma.p239c.p240a;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;

/* renamed from: com.smaato.soma.c.a.a */
/* compiled from: AppLink */
public class C12152a {

    /* renamed from: a */
    String f38102a;

    /* renamed from: b */
    String f38103b;

    /* renamed from: c */
    String f38104c;

    /* renamed from: d */
    String f38105d;

    /* renamed from: c */
    public String mo39393c() {
        return this.f38102a;
    }

    /* renamed from: d */
    public void mo39395d(String appUrl) {
        this.f38102a = appUrl;
    }

    /* renamed from: b */
    public String mo39391b() {
        return this.f38103b;
    }

    /* renamed from: c */
    public void mo39394c(String appPackage) {
        this.f38103b = appPackage;
    }

    /* renamed from: a */
    public void mo39389a(String appClass) {
        this.f38104c = appClass;
    }

    /* renamed from: a */
    public String mo39388a() {
        return this.f38105d;
    }

    /* renamed from: b */
    public void mo39392b(String appName) {
        this.f38105d = appName;
    }

    /* renamed from: a */
    public boolean mo39390a(Context context) {
        if (mo39391b() == null || mo39391b().length() < 1) {
            return false;
        }
        return m39975a(mo39391b(), context);
    }

    /* renamed from: a */
    private boolean m39975a(String uri, Context context) {
        try {
            context.getPackageManager().getPackageInfo(uri, 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("App Name : ");
        result.append(this.f38105d);
        result.append("App URL : ");
        result.append(this.f38102a);
        result.append("App Package : ");
        result.append(this.f38103b);
        result.append("App Class : ");
        result.append(this.f38104c);
        return result.toString();
    }
}
