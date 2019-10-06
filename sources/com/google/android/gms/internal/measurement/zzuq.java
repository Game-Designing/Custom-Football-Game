package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzuq {

    /* renamed from: a */
    static final Charset f30342a = Charset.forName("UTF-8");

    /* renamed from: b */
    private static final Charset f30343b = Charset.forName("ISO-8859-1");

    /* renamed from: c */
    public static final byte[] f30344c;

    /* renamed from: d */
    private static final ByteBuffer f30345d;

    /* renamed from: e */
    private static final zztq f30346e;

    /* renamed from: a */
    static <T> T m32540a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    static <T> T m32542a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: b */
    public static boolean m32544b(byte[] bArr) {
        return C9956bb.m32069a(bArr);
    }

    /* renamed from: c */
    public static String m32545c(byte[] bArr) {
        return new String(bArr, f30342a);
    }

    /* renamed from: a */
    public static int m32537a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: a */
    public static int m32538a(boolean z) {
        return z ? 1231 : 1237;
    }

    /* renamed from: a */
    public static int m32539a(byte[] bArr) {
        int length = bArr.length;
        int a = m32536a(length, bArr, 0, length);
        if (a == 0) {
            return 1;
        }
        return a;
    }

    /* renamed from: a */
    static int m32536a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + bArr[i5];
        }
        return i4;
    }

    /* renamed from: a */
    static boolean m32543a(zzvv zzvv) {
        return false;
    }

    /* renamed from: a */
    static Object m32541a(Object obj, Object obj2) {
        return ((zzvv) obj).mo32896c().mo32842a((zzvv) obj2).mo32906v();
    }

    static {
        byte[] bArr = new byte[0];
        f30344c = bArr;
        f30345d = ByteBuffer.wrap(bArr);
        byte[] bArr2 = f30344c;
        f30346e = zztq.m32402a(bArr2, 0, bArr2.length, false);
    }
}
