package com.bumptech.glide.p106g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.bumptech.glide.load.C6344g;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.bumptech.glide.g.a */
/* compiled from: ApplicationVersionSignature */
public final class C5998a {

    /* renamed from: a */
    private static final ConcurrentMap<String, C6344g> f10630a = new ConcurrentHashMap();

    /* renamed from: a */
    public static C6344g m11207a(Context context) {
        String packageName = context.getPackageName();
        C6344g result = (C6344g) f10630a.get(packageName);
        if (result != null) {
            return result;
        }
        C6344g toAdd = m11210c(context);
        C6344g result2 = (C6344g) f10630a.putIfAbsent(packageName, toAdd);
        if (result2 == null) {
            return toAdd;
        }
        return result2;
    }

    /* renamed from: c */
    private static C6344g m11210c(Context context) {
        return new C6000c(m11208a(m11209b(context)));
    }

    /* renamed from: a */
    private static String m11208a(PackageInfo packageInfo) {
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionCode);
        }
        return UUID.randomUUID().toString();
    }

    /* renamed from: b */
    private static PackageInfo m11209b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot resolve info for");
            sb.append(context.getPackageName());
            Log.e("AppVersionSignature", sb.toString(), e);
            return null;
        }
    }
}
