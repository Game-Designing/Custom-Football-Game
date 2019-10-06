package com.google.zxing.p204f.p205a;

/* renamed from: com.google.zxing.f.a.b */
/* compiled from: Mode */
public enum C10264b {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);
    

    /* renamed from: l */
    private final int[] f31110l;

    /* renamed from: m */
    private final int f31111m;

    private C10264b(int[] characterCountBitsForVersions, int bits) {
        this.f31110l = characterCountBitsForVersions;
        this.f31111m = bits;
    }

    /* renamed from: a */
    public int mo33616a(C10265c version) {
        int offset;
        int c = version.mo33621c();
        int number = c;
        if (c <= 9) {
            offset = 0;
        } else if (number <= 26) {
            offset = 1;
        } else {
            offset = 2;
        }
        return this.f31110l[offset];
    }

    /* renamed from: e */
    public int mo33617e() {
        return this.f31111m;
    }
}
