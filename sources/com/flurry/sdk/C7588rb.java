package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.flurry.sdk.C7607ud.C7608a;

/* renamed from: com.flurry.sdk.rb */
public class C7588rb implements C7608a {

    /* renamed from: a */
    private static final String f15055a = C7588rb.class.getSimpleName();

    /* renamed from: b */
    private static C7588rb f15056b;

    /* renamed from: c */
    private String f15057c;

    /* renamed from: d */
    private String f15058d;

    private C7588rb() {
        C7602td a = C7602td.m16825a();
        String str = "VersionName";
        this.f15057c = (String) a.mo24023a(str);
        a.mo24024a(str, (C7608a) this);
        String str2 = f15055a;
        StringBuilder sb = new StringBuilder("initSettings, VersionName = ");
        sb.append(this.f15057c);
        C7513ec.m16639a(4, str2, sb.toString());
    }

    /* renamed from: a */
    public static synchronized C7588rb m16810a() {
        C7588rb rbVar;
        synchronized (C7588rb.class) {
            if (f15056b == null) {
                f15056b = new C7588rb();
            }
            rbVar = f15056b;
        }
        return rbVar;
    }

    /* renamed from: b */
    public static String m16811b() {
        return VERSION.RELEASE;
    }

    /* renamed from: c */
    public static String m16812c() {
        return Build.DEVICE;
    }

    /* renamed from: d */
    public final synchronized String mo24014d() {
        if (!TextUtils.isEmpty(this.f15057c)) {
            return this.f15057c;
        } else if (!TextUtils.isEmpty(this.f15058d)) {
            return this.f15058d;
        } else {
            this.f15058d = m16813e();
            return this.f15058d;
        }
    }

    /* renamed from: e */
    private static String m16813e() {
        try {
            Context context = C7379Fb.m16300a().f14432d;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo.versionName != null) {
                return packageInfo.versionName;
            }
            if (packageInfo.versionCode != 0) {
                return Integer.toString(packageInfo.versionCode);
            }
            return "Unknown";
        } catch (Throwable th) {
            C7513ec.m16640a(6, f15055a, "", th);
        }
    }

    /* renamed from: a */
    public final void mo23820a(String str, Object obj) {
        if (str.equals("VersionName")) {
            this.f15057c = (String) obj;
            String str2 = f15055a;
            StringBuilder sb = new StringBuilder("onSettingUpdate, VersionName = ");
            sb.append(this.f15057c);
            C7513ec.m16639a(4, str2, sb.toString());
            return;
        }
        C7513ec.m16639a(6, f15055a, "onSettingUpdate internal error!");
    }
}
