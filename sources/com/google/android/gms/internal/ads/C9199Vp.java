package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* renamed from: com.google.android.gms.internal.ads.Vp */
final class C9199Vp {

    /* renamed from: a */
    private static final C9241Xp f21863a;

    /* renamed from: a */
    public static boolean m23150a(byte[] bArr) {
        return f21863a.mo28702a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static boolean m23151a(byte[] bArr, int i, int i2) {
        return f21863a.mo28702a(bArr, i, i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m23152b(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m23153b(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m23154b(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static int m23157d(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return m23152b(b);
        }
        if (i3 == 1) {
            return m23153b(b, bArr[i]);
        }
        if (i3 == 2) {
            return m23154b((int) b, (int) bArr[i], (int) bArr[i + 1]);
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    static int m23147a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new C9283Zp(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        long j = ((long) i3) + 4294967296L;
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    static int m23148a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return f21863a.mo28700a(charSequence, bArr, i, i2);
    }

    /* renamed from: b */
    static String m23155b(byte[] bArr, int i, int i2) throws zzdok {
        return f21863a.mo28703b(bArr, i, i2);
    }

    /* renamed from: a */
    static void m23149a(CharSequence charSequence, ByteBuffer byteBuffer) {
        C9241Xp xp = f21863a;
        if (byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(m23148a(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
        } else if (byteBuffer.isDirect()) {
            xp.mo28701a(charSequence, byteBuffer);
        } else {
            C9241Xp.m23223b(charSequence, byteBuffer);
        }
    }

    static {
        C9241Xp xp;
        if (!(C9132Sp.m22995b() && C9132Sp.m22999c()) || C9587mo.m23884a()) {
            xp = new C9262Yp();
        } else {
            xp = new C9303_p();
        }
        f21863a = xp;
    }
}
