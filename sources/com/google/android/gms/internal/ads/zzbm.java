package com.google.android.gms.internal.ads;

public enum zzbm implements zzdoe {
    ENUM_SIGNAL_SOURCE_UNKNOWN(0),
    ENUM_SIGNAL_SOURCE_DISABLE(1),
    ENUM_SIGNAL_SOURCE_ADSHIELD(2),
    ENUM_SIGNAL_SOURCE_GASS(3),
    ENUM_SIGNAL_SOURCE_CALLER_PROVIDED(4);
    

    /* renamed from: f */
    private static final zzdof<zzbm> f25520f = null;

    /* renamed from: h */
    private final int f25522h;

    /* renamed from: d */
    public final int mo30728d() {
        return this.f25522h;
    }

    /* renamed from: a */
    public static zzbm m27237a(int i) {
        if (i == 0) {
            return ENUM_SIGNAL_SOURCE_UNKNOWN;
        }
        if (i == 1) {
            return ENUM_SIGNAL_SOURCE_DISABLE;
        }
        if (i == 2) {
            return ENUM_SIGNAL_SOURCE_ADSHIELD;
        }
        if (i == 3) {
            return ENUM_SIGNAL_SOURCE_GASS;
        }
        if (i != 4) {
            return null;
        }
        return ENUM_SIGNAL_SOURCE_CALLER_PROVIDED;
    }

    /* renamed from: e */
    public static zzdog m27238e() {
        return C9252Yf.f21988a;
    }

    private zzbm(int i) {
        this.f25522h = i;
    }

    static {
        f25520f = new C9147Tf();
    }
}
