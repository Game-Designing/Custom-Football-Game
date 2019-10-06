package com.google.android.gms.internal.ads;

public enum zzcc implements zzdoe {
    UNKNOWN_PROTO(0),
    AFMA_SIGNALS(1),
    UNITY_SIGNALS(2),
    PARTNER_SIGNALS(3);
    

    /* renamed from: e */
    private static final zzdof<zzcc> f26341e = null;

    /* renamed from: g */
    private final int f26343g;

    /* renamed from: d */
    public final int mo30728d() {
        return this.f26343g;
    }

    /* renamed from: a */
    public static zzcc m28222a(int i) {
        if (i == 0) {
            return UNKNOWN_PROTO;
        }
        if (i == 1) {
            return AFMA_SIGNALS;
        }
        if (i == 2) {
            return UNITY_SIGNALS;
        }
        if (i != 3) {
            return null;
        }
        return PARTNER_SIGNALS;
    }

    /* renamed from: e */
    public static zzdog m28223e() {
        return C9815xi.f23469a;
    }

    private zzcc(int i) {
        this.f26343g = i;
    }

    static {
        f26341e = new C9559li();
    }
}
