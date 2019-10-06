package com.flurry.sdk;

import android.telephony.TelephonyManager;

/* renamed from: com.flurry.sdk.pb */
public class C7576pb {

    /* renamed from: a */
    private static final String f14994a = C7576pb.class.getSimpleName();

    /* renamed from: b */
    private static C7576pb f14995b;

    private C7576pb() {
    }

    /* renamed from: a */
    public static synchronized C7576pb m16765a() {
        C7576pb pbVar;
        synchronized (C7576pb.class) {
            if (f14995b == null) {
                f14995b = new C7576pb();
            }
            pbVar = f14995b;
        }
        return pbVar;
    }

    /* renamed from: b */
    public static String m16766b() {
        TelephonyManager telephonyManager = (TelephonyManager) C7379Fb.m16300a().f14432d.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getNetworkOperatorName();
    }

    /* renamed from: c */
    public static String m16767c() {
        TelephonyManager telephonyManager = (TelephonyManager) C7379Fb.m16300a().f14432d.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getNetworkOperator();
    }
}
