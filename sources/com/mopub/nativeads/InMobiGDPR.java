package com.mopub.nativeads;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.BuildConfig;

public class InMobiGDPR {

    /* renamed from: a */
    private static String f35707a = BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;

    /* renamed from: b */
    private static boolean f35708b = false;

    /* renamed from: c */
    private static boolean f35709c = false;

    /* renamed from: d */
    private static transient /* synthetic */ boolean[] f35710d;

    /* renamed from: c */
    private static /* synthetic */ boolean[] m38162c() {
        boolean[] zArr = f35710d;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8025808476299455870L, "com/mopub/nativeads/InMobiGDPR", 10);
        f35710d = probes;
        return probes;
    }

    public InMobiGDPR() {
        m38162c()[0] = true;
    }

    static {
        boolean[] c = m38162c();
        c[9] = true;
    }

    public static void grantConsent() {
        boolean[] c = m38162c();
        f35709c = true;
        f35708b = true;
        c[1] = true;
    }

    public static void revokeConsent() {
        boolean[] c = m38162c();
        f35709c = true;
        f35708b = false;
        c[2] = true;
    }

    public static void isGDPRApplicable(boolean isGDPRApplicable) {
        boolean[] c = m38162c();
        f35709c = true;
        if (isGDPRApplicable) {
            f35707a = "1";
            c[3] = true;
        } else {
            f35707a = BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;
            c[4] = true;
        }
        c[5] = true;
    }

    /* renamed from: b */
    static String m38161b() {
        boolean[] c = m38162c();
        String str = f35707a;
        c[6] = true;
        return str;
    }

    /* renamed from: a */
    static boolean m38160a() {
        boolean[] c = m38162c();
        boolean z = f35708b;
        c[7] = true;
        return z;
    }

    public static boolean isConsentUpdated() {
        boolean[] c = m38162c();
        boolean z = f35709c;
        c[8] = true;
        return z;
    }
}
