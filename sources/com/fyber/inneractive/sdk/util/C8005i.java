package com.fyber.inneractive.sdk.util;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.mopub.mraid.MraidNativeCommandHandler;

/* renamed from: com.fyber.inneractive.sdk.util.i */
public final class C8005i extends C8006j {

    /* renamed from: b */
    private static String f16334b;

    /* renamed from: a */
    public static String m18051a() {
        String str = "phone";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) C8006j.m18075n().getSystemService(str);
            String networkOperator = telephonyManager.getNetworkOperator();
            if (telephonyManager.getPhoneType() == 2) {
                TelephonyManager telephonyManager2 = (TelephonyManager) C8006j.m18075n().getSystemService(str);
                if (telephonyManager2 != null && telephonyManager2.getSimState() == 5) {
                    networkOperator = telephonyManager.getSimOperator();
                }
            }
            return networkOperator;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    public static int m18053b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) C8006j.m18075n().getSystemService("connectivity");
        if (!C8006j.m18073b("android.permission.ACCESS_NETWORK_STATE")) {
            return 8;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getType();
        }
        return 8;
    }

    /* renamed from: c */
    public static int m18054c() {
        try {
            return ((TelephonyManager) C8006j.m18075n().getSystemService("phone")).getNetworkType();
        } catch (Exception e) {
            return 0;
        }
    }

    /* renamed from: d */
    public static String m18055d() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append(" ");
        sb.append(Build.MODEL);
        return sb.toString();
    }

    /* renamed from: e */
    public static String m18056e() {
        return C8006j.f16335a.getPackageName();
    }

    /* renamed from: f */
    public static String m18057f() {
        try {
            return C8006j.m18075n().getPackageManager().getPackageInfo(C8006j.m18075n().getPackageName(), 0).versionName;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: g */
    public static String m18058g() {
        try {
            return ((TelephonyManager) C8006j.m18075n().getSystemService("phone")).getNetworkCountryIso();
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: h */
    public static String m18059h() {
        try {
            return ((TelephonyManager) C8006j.m18075n().getSystemService("phone")).getNetworkOperatorName();
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: i */
    public static String m18060i() {
        if (TextUtils.isEmpty(f16334b)) {
            String str = "http.agent";
            if (VERSION.SDK_INT >= 17) {
                try {
                    f16334b = WebSettings.getDefaultUserAgent(C8006j.m18075n());
                } catch (Exception e) {
                    f16334b = System.getProperty(str);
                }
            } else {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    try {
                        f16334b = new WebView(C8006j.m18075n()).getSettings().getUserAgentString();
                    } catch (Exception e2) {
                    }
                }
                f16334b = System.getProperty(str);
            }
        }
        return f16334b;
    }

    /* renamed from: a */
    public static boolean m18052a(Intent intent) {
        if (C8006j.m18075n().getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    public static boolean m18061j() {
        return "mounted".equals(Environment.getExternalStorageState()) && C8006j.m18075n().checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    /* renamed from: k */
    public static boolean m18062k() {
        return VERSION.SDK_INT >= 14 && m18052a(new Intent("android.intent.action.INSERT").setType(MraidNativeCommandHandler.ANDROID_CALENDAR_CONTENT_TYPE));
    }

    /* renamed from: l */
    public static boolean m18063l() {
        boolean z = (C8006j.m18075n().getResources().getConfiguration().screenLayout & 15) == 4;
        StringBuilder sb = new StringBuilder("This device has a tablet resolution? ");
        sb.append(z);
        IAlog.m18019a(sb.toString());
        return z;
    }

    /* renamed from: a */
    public static int m18050a(String str) {
        return Math.min(3, str.length());
    }

    /* renamed from: m */
    public static boolean m18064m() {
        if (C8006j.m18075n().getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", C8006j.m18075n().getPackageName()) != 0) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) C8006j.m18075n().getSystemService("connectivity");
        try {
            if (connectivityManager.getNetworkInfo(1).getState() == State.CONNECTED || connectivityManager.getNetworkInfo(1).getState() == State.CONNECTING) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
