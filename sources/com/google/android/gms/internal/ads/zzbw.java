package com.google.android.gms.internal.ads;

public enum zzbw implements zzdoe {
    UNKNOWN_ENCRYPTION_METHOD(0),
    BITSLICER(1),
    TINK_HYBRID(2),
    UNENCRYPTED(3);
    

    /* renamed from: e */
    private static final zzdof<zzbw> f25929e = null;

    /* renamed from: g */
    private final int f25931g;

    /* renamed from: d */
    public final int mo30728d() {
        return this.f25931g;
    }

    /* renamed from: a */
    public static zzbw m27861a(int i) {
        if (i == 0) {
            return UNKNOWN_ENCRYPTION_METHOD;
        }
        if (i == 1) {
            return BITSLICER;
        }
        if (i == 2) {
            return TINK_HYBRID;
        }
        if (i != 3) {
            return null;
        }
        return UNENCRYPTED;
    }

    /* renamed from: e */
    public static zzdog m27862e() {
        return C9558lh.f22717a;
    }

    private zzbw(int i) {
        this.f25931g = i;
    }

    static {
        f25929e = new C9448gh();
    }
}
