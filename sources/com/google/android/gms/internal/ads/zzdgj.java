package com.google.android.gms.internal.ads;

public enum zzdgj implements zzdoe {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA256(3),
    SHA512(4),
    UNRECOGNIZED(-1);
    

    /* renamed from: f */
    private static final zzdof<zzdgj> f27857f = null;

    /* renamed from: h */
    private final int f27859h;

    /* renamed from: d */
    public final int mo30728d() {
        if (this != UNRECOGNIZED) {
            return this.f27859h;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    /* renamed from: a */
    public static zzdgj m29393a(int i) {
        if (i == 0) {
            return UNKNOWN_HASH;
        }
        if (i == 1) {
            return SHA1;
        }
        if (i == 3) {
            return SHA256;
        }
        if (i != 4) {
            return null;
        }
        return SHA512;
    }

    private zzdgj(int i) {
        this.f27859h = i;
    }

    static {
        f27857f = new C8900Hn();
    }
}
