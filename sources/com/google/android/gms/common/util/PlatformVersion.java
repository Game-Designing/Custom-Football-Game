package com.google.android.gms.common.util;

import android.os.Build.VERSION;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@VisibleForTesting
public final class PlatformVersion {
    private PlatformVersion() {
    }

    @KeepForSdk
    /* renamed from: a */
    public static boolean m22107a() {
        return true;
    }

    @KeepForSdk
    /* renamed from: b */
    public static boolean m22108b() {
        return true;
    }

    @KeepForSdk
    /* renamed from: c */
    public static boolean m22109c() {
        return true;
    }

    @KeepForSdk
    /* renamed from: d */
    public static boolean m22110d() {
        return VERSION.SDK_INT >= 17;
    }

    @KeepForSdk
    /* renamed from: e */
    public static boolean m22111e() {
        return VERSION.SDK_INT >= 18;
    }

    @KeepForSdk
    /* renamed from: f */
    public static boolean m22112f() {
        return VERSION.SDK_INT >= 19;
    }

    @KeepForSdk
    /* renamed from: g */
    public static boolean m22113g() {
        return VERSION.SDK_INT >= 20;
    }

    @KeepForSdk
    /* renamed from: h */
    public static boolean m22114h() {
        return VERSION.SDK_INT >= 21;
    }

    @KeepForSdk
    /* renamed from: i */
    public static boolean m22115i() {
        return VERSION.SDK_INT >= 23;
    }

    @KeepForSdk
    /* renamed from: j */
    public static boolean m22116j() {
        return VERSION.SDK_INT >= 24;
    }

    @KeepForSdk
    /* renamed from: k */
    public static boolean m22117k() {
        return VERSION.SDK_INT >= 26;
    }

    @KeepForSdk
    /* renamed from: l */
    public static boolean m22118l() {
        return VERSION.SDK_INT >= 28;
    }
}
