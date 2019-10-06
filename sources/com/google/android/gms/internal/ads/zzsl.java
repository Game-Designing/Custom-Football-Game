package com.google.android.gms.internal.ads;

import android.util.Pair;

public final class zzsl {

    /* renamed from: a */
    private static final byte[] f29310a = {0, 0, 0, 1};

    /* renamed from: b */
    private static final int[] f29311b = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* renamed from: c */
    private static final int[] f29312c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* renamed from: a */
    public static Pair<Integer, Integer> m31085a(byte[] bArr) {
        zzss zzss = new zzss(bArr);
        int a = m31084a(zzss);
        int b = m31087b(zzss);
        int a2 = zzss.mo32193a(4);
        if (a == 5 || a == 29) {
            b = m31087b(zzss);
            if (m31084a(zzss) == 22) {
                a2 = zzss.mo32193a(4);
            }
        }
        int i = f29312c[a2];
        zzsk.m31080a(i != -1);
        return Pair.create(Integer.valueOf(b), Integer.valueOf(i));
    }

    /* renamed from: a */
    public static byte[] m31086a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = f29310a;
        byte[] bArr3 = new byte[(bArr2.length + i2)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, f29310a.length, i2);
        return bArr3;
    }

    /* renamed from: a */
    private static int m31084a(zzss zzss) {
        int a = zzss.mo32193a(5);
        if (a == 31) {
            return zzss.mo32193a(6) + 32;
        }
        return a;
    }

    /* renamed from: b */
    private static int m31087b(zzss zzss) {
        int a = zzss.mo32193a(4);
        if (a == 15) {
            return zzss.mo32193a(24);
        }
        zzsk.m31080a(a < 13);
        return f29311b[a];
    }
}
