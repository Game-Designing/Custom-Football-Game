package com.google.android.gms.internal.ads;

public enum zzbz implements zzdoe {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_FAILURE(2),
    ENUM_UNKNOWN(1000);
    

    /* renamed from: e */
    private static final zzdof<zzbz> f26152e = null;

    /* renamed from: g */
    private final int f26154g;

    /* renamed from: d */
    public final int mo30728d() {
        return this.f26154g;
    }

    /* renamed from: a */
    public static zzbz m28048a(int i) {
        if (i == 0) {
            return ENUM_FALSE;
        }
        if (i == 1) {
            return ENUM_TRUE;
        }
        if (i == 2) {
            return ENUM_FAILURE;
        }
        if (i != 1000) {
            return null;
        }
        return ENUM_UNKNOWN;
    }

    /* renamed from: e */
    public static zzdog m28049e() {
        return C8999Mh.f21476a;
    }

    private zzbz(int i) {
        this.f26154g = i;
    }

    static {
        f26152e = new C8810Dh();
    }
}
