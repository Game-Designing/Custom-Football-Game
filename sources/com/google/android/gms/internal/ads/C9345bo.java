package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.bo */
final /* synthetic */ class C9345bo {

    /* renamed from: a */
    static final /* synthetic */ int[] f22129a = new int[zzdkv.values().length];

    /* renamed from: b */
    static final /* synthetic */ int[] f22130b = new int[zzdkt.values().length];

    static {
        try {
            f22130b[zzdkt.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f22130b[zzdkt.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f22130b[zzdkt.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f22129a[zzdkv.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f22129a[zzdkv.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f22129a[zzdkv.COMPRESSED.ordinal()] = 3;
        } catch (NoSuchFieldError e6) {
        }
    }
}
