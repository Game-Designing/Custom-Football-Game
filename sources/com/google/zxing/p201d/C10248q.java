package com.google.zxing.p201d;

import com.google.zxing.FormatException;

/* renamed from: com.google.zxing.d.q */
/* compiled from: UPCEANReader */
public abstract class C10248q extends C10245n {

    /* renamed from: a */
    static final int[] f31054a = {1, 1, 1};

    /* renamed from: b */
    static final int[] f31055b = {1, 1, 1, 1, 1};

    /* renamed from: c */
    static final int[] f31056c = {1, 1, 1, 1, 1, 1};

    /* renamed from: d */
    static final int[][] f31057d = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};

    /* renamed from: e */
    static final int[][] f31058e = new int[20][];

    static {
        System.arraycopy(f31057d, 0, f31058e, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr = f31057d[i - 10];
            int[] widths = iArr;
            int[] reversedWidths = new int[iArr.length];
            for (int j = 0; j < widths.length; j++) {
                reversedWidths[j] = widths[(widths.length - j) - 1];
            }
            f31058e[i] = reversedWidths;
        }
    }

    /* renamed from: a */
    static boolean m33390a(CharSequence s) throws FormatException {
        int length = s.length();
        boolean z = false;
        int length2 = length;
        if (length == 0) {
            return false;
        }
        int sum = 0;
        for (int i = length2 - 2; i >= 0; i -= 2) {
            int charAt = s.charAt(i) - '0';
            int digit = charAt;
            if (charAt < 0 || digit > 9) {
                throw FormatException.m33193a();
            }
            sum += digit;
        }
        int sum2 = sum * 3;
        for (int i2 = length2 - 1; i2 >= 0; i2 -= 2) {
            int charAt2 = s.charAt(i2) - '0';
            int digit2 = charAt2;
            if (charAt2 < 0 || digit2 > 9) {
                throw FormatException.m33193a();
            }
            sum2 += digit2;
        }
        if (sum2 % 10 == 0) {
            z = true;
        }
        return z;
    }
}
