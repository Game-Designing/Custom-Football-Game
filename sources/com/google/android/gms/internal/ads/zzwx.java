package com.google.android.gms.internal.ads;

public enum zzwx implements zzdoe {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_UNKNOWN(1000);
    

    /* renamed from: d */
    private static final zzdof<zzwx> f29659d = null;

    /* renamed from: f */
    private final int f29661f;

    /* renamed from: d */
    public final int mo30728d() {
        return this.f29661f;
    }

    /* renamed from: a */
    public static zzwx m31481a(int i) {
        if (i == 0) {
            return ENUM_FALSE;
        }
        if (i == 1) {
            return ENUM_TRUE;
        }
        if (i != 1000) {
            return null;
        }
        return ENUM_UNKNOWN;
    }

    /* renamed from: e */
    public static zzdog m31482e() {
        return C9203Vt.f21875a;
    }

    private zzwx(int i) {
        this.f29661f = i;
    }

    static {
        f29659d = new C9182Ut();
    }
}
