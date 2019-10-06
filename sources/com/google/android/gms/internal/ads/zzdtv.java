package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class zzdtv {

    /* renamed from: a */
    private static String f28317a;

    /* renamed from: a */
    public static String m30125a(Context context) {
        String str;
        String str2 = f28317a;
        if (str2 != null) {
            return str2;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        if (resolveActivity != null) {
            str = resolveActivity.activityInfo.packageName;
        } else {
            str = null;
        }
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            Intent intent2 = new Intent();
            intent2.setAction("android.support.customtabs.action.CustomTabsService");
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            if (packageManager.resolveService(intent2, 0) != null) {
                arrayList.add(resolveInfo.activityInfo.packageName);
            }
        }
        if (arrayList.isEmpty()) {
            f28317a = null;
        } else if (arrayList.size() == 1) {
            f28317a = (String) arrayList.get(0);
        } else if (TextUtils.isEmpty(str) || m30126a(context, intent) || !arrayList.contains(str)) {
            String str3 = "com.android.chrome";
            if (arrayList.contains(str3)) {
                f28317a = str3;
            } else {
                String str4 = "com.chrome.beta";
                if (arrayList.contains(str4)) {
                    f28317a = str4;
                } else {
                    String str5 = "com.chrome.dev";
                    if (arrayList.contains(str5)) {
                        f28317a = str5;
                    } else {
                        String str6 = "com.google.android.apps.chrome";
                        if (arrayList.contains(str6)) {
                            f28317a = str6;
                        }
                    }
                }
            }
        } else {
            f28317a = str;
        }
        return f28317a;
    }

    /* renamed from: a */
    private static boolean m30126a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
            if (queryIntentActivities != null) {
                if (queryIntentActivities.size() != 0) {
                    for (ResolveInfo resolveInfo : queryIntentActivities) {
                        IntentFilter intentFilter = resolveInfo.filter;
                        if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0 && resolveInfo.activityInfo != null) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (RuntimeException e) {
            Log.e("CustomTabsHelper", "Runtime exception while getting specialized handlers");
        }
    }
}
