package com.google.zxing.p201d;

/* renamed from: com.google.zxing.d.a */
/* compiled from: CodaBarReader */
public final class C10231a extends C10245n {

    /* renamed from: a */
    static final char[] f31028a = "0123456789-$:/.+ABCD".toCharArray();

    /* renamed from: b */
    static final int[] f31029b = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: c */
    private static final char[] f31030c = {'A', 'B', 'C', 'D'};

    /* renamed from: a */
    static boolean m33363a(char[] array, char key) {
        if (array != null) {
            for (char c : array) {
                if (c == key) {
                    return true;
                }
            }
        }
        return false;
    }
}
