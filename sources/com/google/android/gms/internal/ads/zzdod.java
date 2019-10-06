package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzdod {

    /* renamed from: a */
    static final Charset f28084a = Charset.forName("UTF-8");

    /* renamed from: b */
    private static final Charset f28085b = Charset.forName("ISO-8859-1");

    /* renamed from: c */
    public static final byte[] f28086c;

    /* renamed from: d */
    private static final ByteBuffer f28087d;

    /* renamed from: e */
    private static final zzdnd f28088e;

    /* renamed from: a */
    static <T> T m29915a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    static <T> T m29917a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: b */
    public static boolean m29919b(byte[] bArr) {
        return C9199Vp.m23150a(bArr);
    }

    /* renamed from: c */
    public static String m29920c(byte[] bArr) {
        return new String(bArr, f28084a);
    }

    /* renamed from: a */
    public static int m29912a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: a */
    public static int m29913a(boolean z) {
        return z ? 1231 : 1237;
    }

    /* renamed from: a */
    public static int m29914a(byte[] bArr) {
        int length = bArr.length;
        int a = m29911a(length, bArr, 0, length);
        if (a == 0) {
            return 1;
        }
        return a;
    }

    /* renamed from: a */
    static int m29911a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + bArr[i5];
        }
        return i4;
    }

    /* renamed from: a */
    static boolean m29918a(zzdpk zzdpk) {
        return false;
    }

    /* renamed from: a */
    static Object m29916a(Object obj, Object obj2) {
        return ((zzdpk) obj).mo31604d().mo31535a((zzdpk) obj2).mo31613i();
    }

    static {
        byte[] bArr = new byte[0];
        f28086c = bArr;
        f28087d = ByteBuffer.wrap(bArr);
        byte[] bArr2 = f28086c;
        f28088e = zzdnd.m29671a(bArr2, 0, bArr2.length, false);
    }
}
