package com.inmobi.commons.core.utilities.p225b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.inmobi.commons.core.utilities.C10701e;
import com.inmobi.commons.p217a.C10619a;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.inmobi.commons.core.utilities.b.b */
/* compiled from: DeviceInfo */
public class C10691b {
    @SuppressLint({"MissingPermission", "NewApi"})
    /* renamed from: b */
    private static String m35102b() {
        Context b = C10619a.m34839b();
        String str = "";
        if (b == null) {
            return str;
        }
        String str2 = "1";
        if (C10701e.m35150a(b, "root", "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) b.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (VERSION.SDK_INT < 28) {
                        int type = activeNetworkInfo.getType();
                        int subtype = activeNetworkInfo.getSubtype();
                        if (type == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(type);
                            sb.append("|");
                            sb.append(subtype);
                            str = sb.toString();
                        } else {
                            str = type == 1 ? str2 : Integer.toString(type);
                        }
                    } else {
                        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                        if (networkCapabilities != null) {
                            if (networkCapabilities.hasTransport(0)) {
                                StringBuilder sb2 = new StringBuilder("0|");
                                sb2.append(activeNetworkInfo.getSubtype());
                                str = sb2.toString();
                            } else {
                                str = networkCapabilities.hasTransport(1) ? str2 : networkCapabilities.hasTransport(2) ? "7" : networkCapabilities.hasTransport(3) ? "9" : networkCapabilities.hasTransport(4) ? "17" : networkCapabilities.hasTransport(5) ? "10" : networkCapabilities.hasTransport(6) ? "11" : "8";
                            }
                        }
                    }
                }
            }
        }
        return str;
    }

    /* renamed from: a */
    public static Map<String, String> m35101a(boolean z) {
        int i;
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("d-brand-name", Build.BRAND);
            hashMap.put("d-manufacturer-name", Build.MANUFACTURER);
            hashMap.put("d-model-name", Build.MODEL);
            hashMap.put("d-nettype-raw", m35102b());
            hashMap.put("d-localization", Locale.getDefault().toString());
            String str = "d-media-volume";
            Context b = C10619a.m34839b();
            if (b != null) {
                if (!z) {
                    AudioManager audioManager = (AudioManager) b.getSystemService("audio");
                    i = (audioManager.getStreamVolume(3) * 100) / audioManager.getStreamMaxVolume(3);
                    hashMap.put(str, String.valueOf(i));
                    return hashMap;
                }
            }
            i = 0;
            hashMap.put(str, String.valueOf(i));
        } catch (Exception e) {
            C10691b.class.getSimpleName();
            new StringBuilder("SDK encountered unexpected error in getting device info; ").append(e.getMessage());
        }
        return hashMap;
    }

    /* renamed from: a */
    public static int m35099a() {
        String b = m35102b();
        if (b.startsWith(BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID)) {
            return 0;
        }
        if (b.startsWith("1")) {
            return 1;
        }
        return 2;
    }

    /* renamed from: a */
    public static int m35100a(Context context) {
        return ((AudioManager) context.getSystemService("audio")).getStreamVolume(3);
    }
}
