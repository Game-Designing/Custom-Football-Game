package com.google.android.gms.internal.ads;

import p024io.realm.internal.Collection;

/* renamed from: com.google.android.gms.internal.ads.Wp */
final class C9220Wp {
    /* access modifiers changed from: private */
    /* renamed from: d */
    public static boolean m23195d(byte b) {
        return b >= 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static boolean m23196e(byte b) {
        return b < -32;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static boolean m23197f(byte b) {
        return b < -16;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m23192b(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m23191b(byte b, byte b2, char[] cArr, int i) throws zzdok {
        if (b < -62 || m23198g(b2)) {
            throw zzdok.m29935h();
        }
        cArr[i] = (char) (((b & 31) << 6) | (b2 & 63));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m23190b(byte b, byte b2, byte b3, char[] cArr, int i) throws zzdok {
        if (m23198g(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || m23198g(b3)))) {
            throw zzdok.m29935h();
        }
        cArr[i] = (char) (((b & 15) << 12) | ((b2 & 63) << 6) | (b3 & 63));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m23189b(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws zzdok {
        if (m23198g(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || m23198g(b3) || m23198g(b4)) {
            throw zzdok.m29935h();
        }
        byte b5 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
        cArr[i] = (char) ((b5 >>> 10) + 55232);
        cArr[i + 1] = (char) ((b5 & 1023) + Collection.MODE_EMPTY);
    }

    /* renamed from: g */
    private static boolean m23198g(byte b) {
        return b > -65;
    }
}
