package com.google.android.gms.internal.ads;

public enum zzdfd implements zzdoe {
    UNKNOWN_FORMAT(0),
    UNCOMPRESSED(1),
    COMPRESSED(2),
    DO_NOT_USE_CRUNCHY_UNCOMPRESSED(3),
    UNRECOGNIZED(-1);
    

    /* renamed from: f */
    private static final zzdof<zzdfd> f27841f = null;

    /* renamed from: h */
    private final int f27843h;

    /* renamed from: d */
    public final int mo30728d() {
        if (this != UNRECOGNIZED) {
            return this.f27843h;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    /* renamed from: a */
    public static zzdfd m29327a(int i) {
        if (i == 0) {
            return UNKNOWN_FORMAT;
        }
        if (i == 1) {
            return UNCOMPRESSED;
        }
        if (i == 2) {
            return COMPRESSED;
        }
        if (i != 3) {
            return null;
        }
        return DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
    }

    private zzdfd(int i) {
        this.f27843h = i;
    }

    static {
        f27841f = new C9841yn();
    }
}
