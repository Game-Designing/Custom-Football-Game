package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.bb */
final class C9956bb {

    /* renamed from: a */
    private static final C9959cb f30086a;

    /* renamed from: a */
    public static boolean m32069a(byte[] bArr) {
        return f30086a.mo32715a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static boolean m32070a(byte[] bArr, int i, int i2) {
        return f30086a.mo32715a(bArr, i, i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m32071b(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m32072b(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m32073b(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static int m32075c(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return m32071b(b);
        }
        if (i3 == 1) {
            return m32072b(b, bArr[i]);
        }
        if (i3 == 2) {
            return m32073b((int) b, (int) bArr[i], (int) bArr[i + 1]);
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    static int m32067a(CharSequence charSequence) {
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
                                throw new C9965eb(i2, length2);
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
    static int m32068a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return f30086a.mo32714a(charSequence, bArr, i, i2);
    }

    static {
        C9959cb cbVar;
        if (!(C9946_a.m32002b() && C9946_a.m32006c()) || C9905F.m31779a()) {
            cbVar = new C9962db();
        } else {
            cbVar = new C9968fb();
        }
        f30086a = cbVar;
    }
}
