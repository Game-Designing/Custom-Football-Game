package com.google.android.gms.internal.ads;

public enum zzdhm implements zzdoe {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);
    

    /* renamed from: g */
    private static final zzdof<zzdhm> f27889g = null;

    /* renamed from: i */
    private final int f27891i;

    /* renamed from: d */
    public final int mo30728d() {
        if (this != UNRECOGNIZED) {
            return this.f27891i;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    /* renamed from: a */
    public static zzdhm m29550a(int i) {
        if (i == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i == 1) {
            return TINK;
        }
        if (i == 2) {
            return LEGACY;
        }
        if (i == 3) {
            return RAW;
        }
        if (i != 4) {
            return null;
        }
        return CRUNCHY;
    }

    private zzdhm(int i) {
        this.f27891i = i;
    }

    static {
        f27889g = new C9218Wn();
    }
}
