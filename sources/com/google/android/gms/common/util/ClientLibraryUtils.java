package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;

@KeepForSdk
public class ClientLibraryUtils {
    private ClientLibraryUtils() {
    }

    @KeepForSdk
    /* renamed from: a */
    public static int m22072a(Context context, String str) {
        PackageInfo c = m22075c(context, str);
        if (c != null) {
            ApplicationInfo applicationInfo = c.applicationInfo;
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle == null) {
                    return -1;
                }
                return bundle.getInt("com.google.android.gms.version", -1);
            }
        }
        return -1;
    }

    /* renamed from: c */
    private static PackageInfo m22075c(Context context, String str) {
        try {
            return Wrappers.m22139a(context).mo27947b(str, 128);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m22074b(Context context, String str) {
        "com.google.android.gms".equals(str);
        try {
            if ((Wrappers.m22139a(context).mo27944a(str, 0).flags & 2097152) != 0) {
                return true;
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    @KeepForSdk
    /* renamed from: a */
    public static boolean m22073a() {
        return false;
    }
}
