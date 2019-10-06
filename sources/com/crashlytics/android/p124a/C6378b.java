package com.crashlytics.android.p124a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import java.io.File;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;
import p024io.fabric.sdk.android.p348a.p350b.C13854m.C13855a;
import p024io.fabric.sdk.android.p348a.p350b.C13854m.C13856b;
import p024io.fabric.sdk.android.p348a.p350b.C13858o;
import p024io.fabric.sdk.android.p348a.p350b.C13867x;
import p024io.fabric.sdk.android.p348a.p353e.C13905s;
import p024io.fabric.sdk.android.p348a.p353e.C13909v;

/* renamed from: com.crashlytics.android.a.b */
/* compiled from: Answers */
public class C6378b extends C0102l<Boolean> {

    /* renamed from: g */
    boolean f11399g = false;

    /* renamed from: h */
    C6368J f11400h;

    /* renamed from: a */
    public void mo19377a(C6397t event) {
        if (event == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.f11399g) {
            m12333a("logCustom");
        } else {
            C6368J j = this.f11400h;
            if (j != null) {
                j.mo19355a(event);
            }
        }
    }

    /* renamed from: a */
    public void mo19379a(C13856b exception) {
        C6368J j = this.f11400h;
        if (j != null) {
            j.mo19357a(exception.mo43246b());
        }
    }

    /* renamed from: a */
    public void mo19378a(C13855a exception) {
        C6368J j = this.f11400h;
        if (j != null) {
            j.mo19358a(exception.mo43246b(), exception.mo43245a());
        }
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    /* renamed from: z */
    public boolean mo3314z() {
        long installedAt;
        String str = "!SDK-VERSION-STRING!:com.crashlytics.sdk.android:answers:1.4.7.32";
        try {
            Context context = mo3307i();
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String versionCode = Integer.toString(packageInfo.versionCode);
            String versionName = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            if (VERSION.SDK_INT >= 9) {
                installedAt = packageInfo.firstInstallTime;
            } else {
                installedAt = new File(packageManager.getApplicationInfo(packageName, 0).sourceDir).lastModified();
            }
            this.f11400h = C6368J.m12305a(this, context, mo3310t(), versionCode, versionName, installedAt);
            this.f11400h.mo19360c();
            this.f11399g = new C13867x().mo43258e(context);
            return true;
        } catch (Exception e) {
            C13920f.m44245e().mo43325b("Answers", "Error retrieving app properties", e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public Boolean m12339g() {
        String str = "Answers";
        boolean a = C13858o.m44068a(mo3307i()).mo43247a();
        Boolean valueOf = Boolean.valueOf(false);
        if (!a) {
            C13920f.m44245e().mo43326c("Fabric", "Analytics collection disabled, because data collection is disabled by Firebase.");
            this.f11400h.mo19359b();
            return valueOf;
        }
        try {
            C13909v settingsData = C13905s.m44193b().mo43313a();
            if (settingsData == null) {
                C13920f.m44245e().mo43324b(str, "Failed to retrieve settings");
                return valueOf;
            } else if (settingsData.f42194d.f42162d) {
                C13920f.m44245e().mo43326c(str, "Analytics collection enabled");
                this.f11400h.mo19356a(settingsData.f42195e, mo19376A());
                return Boolean.valueOf(true);
            } else {
                C13920f.m44245e().mo43326c(str, "Analytics collection disabled");
                this.f11400h.mo19359b();
                return valueOf;
            }
        } catch (Exception e) {
            C13920f.m44245e().mo43325b(str, "Error dealing with settings", e);
            return valueOf;
        }
    }

    /* renamed from: u */
    public String mo2535u() {
        return "com.crashlytics.sdk.android:answers";
    }

    /* renamed from: w */
    public String mo2536w() {
        return "1.4.7.32";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: A */
    public String mo19376A() {
        return C13852l.m44043b(mo3307i(), "com.crashlytics.ApiEndpoint");
    }

    /* renamed from: a */
    private void m12333a(String method) {
        C13929o e = C13920f.m44245e();
        StringBuilder sb = new StringBuilder();
        sb.append("Method ");
        sb.append(method);
        sb.append(" is not supported when using Crashlytics through Firebase.");
        e.mo43321a("Answers", sb.toString());
    }
}
