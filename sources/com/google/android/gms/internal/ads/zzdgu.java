package com.google.android.gms.internal.ads;

public enum zzdgu implements zzdoe {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);
    

    /* renamed from: f */
    private static final zzdof<zzdgu> f27874f = null;

    /* renamed from: h */
    private final int f27876h;

    /* renamed from: d */
    public final int mo30728d() {
        if (this != UNRECOGNIZED) {
            return this.f27876h;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    /* renamed from: a */
    public static zzdgu m29441a(int i) {
        if (i == 0) {
            return UNKNOWN_STATUS;
        }
        if (i == 1) {
            return ENABLED;
        }
        if (i == 2) {
            return DISABLED;
        }
        if (i != 3) {
            return null;
        }
        return DESTROYED;
    }

    private zzdgu(int i) {
        this.f27876h = i;
    }

    static {
        f27874f = new C9026Nn();
    }
}
