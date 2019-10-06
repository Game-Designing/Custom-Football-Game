package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.Sl */
final class C9128Sl implements zzcva<zzcvf> {

    /* renamed from: a */
    private final zzbbl f21709a;

    /* renamed from: b */
    private final Context f21710b;

    public C9128Sl(zzbbl zzbbl, Context context) {
        this.f21709a = zzbbl;
        this.f21710b = context;
    }

    /* renamed from: a */
    public final zzbbh<zzcvf> mo28586a() {
        return this.f21709a.mo30326a((Callable<T>) new C9153Tl<T>(this));
    }

    /* renamed from: a */
    private static String m22966a(Context context) {
        try {
            PackageInfo b = Wrappers.m22139a(context).mo27947b("com.android.vending", 128);
            if (b == null) {
                return null;
            }
            int i = b.versionCode;
            String str = b.packageName;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
            sb.append(i);
            sb.append(".");
            sb.append(str);
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m22967a(Context context, PackageManager packageManager) {
        ResolveInfo a = m22965a(packageManager, "market://details?id=com.google.android.gms.ads");
        if (a == null) {
            return null;
        }
        ActivityInfo activityInfo = a.activityInfo;
        if (activityInfo == null) {
            return null;
        }
        try {
            PackageInfo b = Wrappers.m22139a(context).mo27947b(activityInfo.packageName, 0);
            if (b == null) {
                return null;
            }
            int i = b.versionCode;
            String str = activityInfo.packageName;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
            sb.append(i);
            sb.append(".");
            sb.append(str);
            return sb.toString();
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    /* renamed from: a */
    private static ResolveInfo m22965a(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ zzcvf mo28587b() throws Exception {
        boolean z;
        PackageManager packageManager = this.f21710b.getPackageManager();
        Locale locale = Locale.getDefault();
        boolean z2 = m22965a(packageManager, "geo:0,0?q=donuts") != null;
        boolean z3 = m22965a(packageManager, "http://www.google.com") != null;
        String country = locale.getCountry();
        boolean startsWith = Build.DEVICE.startsWith("generic");
        boolean a = DeviceProperties.m22092a(this.f21710b);
        boolean b = DeviceProperties.m22093b(this.f21710b);
        String language = locale.getLanguage();
        String a2 = m22967a(this.f21710b, packageManager);
        String a3 = m22966a(this.f21710b);
        String str = Build.FINGERPRINT;
        Context context = this.f21710b;
        if (packageManager != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
            List queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                int i = 0;
                while (true) {
                    if (i >= queryIntentActivities.size()) {
                        break;
                    }
                    if (resolveActivity.activityInfo.name.equals(((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name)) {
                        z = resolveActivity.activityInfo.packageName.equals(zzdtv.m30125a(context));
                        break;
                    }
                    i++;
                }
                zzcvf zzcvf = new zzcvf(z2, z3, country, startsWith, a, b, language, a2, a3, str, z, Build.MODEL);
                return zzcvf;
            }
        }
        z = false;
        zzcvf zzcvf2 = new zzcvf(z2, z3, country, startsWith, a, b, language, a2, a3, str, z, Build.MODEL);
        return zzcvf2;
    }
}
