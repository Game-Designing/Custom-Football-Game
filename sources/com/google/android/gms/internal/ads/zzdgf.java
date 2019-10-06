package com.google.android.gms.internal.ads;

public enum zzdgf implements zzdoe {
    UNKNOWN_CURVE(0),
    NIST_P256(2),
    NIST_P384(3),
    NIST_P521(4),
    UNRECOGNIZED(-1);
    

    /* renamed from: f */
    private static final zzdof<zzdgf> f27849f = null;

    /* renamed from: h */
    private final int f27851h;

    /* renamed from: d */
    public final int mo30728d() {
        if (this != UNRECOGNIZED) {
            return this.f27851h;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    /* renamed from: a */
    public static zzdgf m29388a(int i) {
        if (i == 0) {
            return UNKNOWN_CURVE;
        }
        if (i == 2) {
            return NIST_P256;
        }
        if (i == 3) {
            return NIST_P384;
        }
        if (i != 4) {
            return null;
        }
        return NIST_P521;
    }

    private zzdgf(int i) {
        this.f27851h = i;
    }

    static {
        f27849f = new C8858Fn();
    }
}
