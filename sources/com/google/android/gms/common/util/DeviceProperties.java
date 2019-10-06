package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class DeviceProperties {

    /* renamed from: a */
    private static Boolean f20293a;

    /* renamed from: b */
    private static Boolean f20294b;

    /* renamed from: c */
    private static Boolean f20295c;

    /* renamed from: d */
    private static Boolean f20296d;

    private DeviceProperties() {
    }

    @TargetApi(20)
    @KeepForSdk
    /* renamed from: c */
    public static boolean m22094c(Context context) {
        if (f20293a == null) {
            f20293a = Boolean.valueOf(PlatformVersion.m22113g() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f20293a.booleanValue();
    }

    @TargetApi(26)
    @KeepForSdk
    /* renamed from: d */
    public static boolean m22095d(Context context) {
        return m22094c(context) && (!PlatformVersion.m22116j() || (m22093b(context) && !PlatformVersion.m22117k()));
    }

    @TargetApi(21)
    @KeepForSdk
    /* renamed from: b */
    public static boolean m22093b(Context context) {
        if (f20294b == null) {
            f20294b = Boolean.valueOf(PlatformVersion.m22114h() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f20294b.booleanValue();
    }

    @KeepForSdk
    /* renamed from: a */
    public static boolean m22092a(Context context) {
        if (f20295c == null) {
            PackageManager packageManager = context.getPackageManager();
            f20295c = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services"));
        }
        return f20295c.booleanValue();
    }

    /* renamed from: e */
    public static boolean m22096e(Context context) {
        if (f20296d == null) {
            f20296d = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f20296d.booleanValue();
    }

    @KeepForSdk
    /* renamed from: a */
    public static boolean m22091a() {
        return "user".equals(Build.TYPE);
    }
}
