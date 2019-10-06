package com.mopub.nativeads;

import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.q */
/* compiled from: InMobiNativeCustomEvent */
/* synthetic */ class C11634q {

    /* renamed from: a */
    static final /* synthetic */ int[] f36218a = new int[StatusCode.values().length];

    /* renamed from: b */
    private static transient /* synthetic */ boolean[] f36219b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38462a() {
        boolean[] zArr = f36219b;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4379418031552420536L, "com/mopub/nativeads/InMobiNativeCustomEvent$1", 20);
        f36219b = probes;
        return probes;
    }

    static {
        boolean[] a = m38462a();
        try {
            a[0] = true;
            f36218a[StatusCode.INTERNAL_ERROR.ordinal()] = 1;
            a[1] = true;
        } catch (NoSuchFieldError e) {
            try {
                a[2] = true;
            } catch (NoSuchFieldError e2) {
                try {
                    a[4] = true;
                } catch (NoSuchFieldError e3) {
                    try {
                        a[6] = true;
                    } catch (NoSuchFieldError e4) {
                        try {
                            a[8] = true;
                        } catch (NoSuchFieldError e5) {
                            try {
                                a[10] = true;
                            } catch (NoSuchFieldError e6) {
                                try {
                                    a[12] = true;
                                } catch (NoSuchFieldError e7) {
                                    try {
                                        a[14] = true;
                                    } catch (NoSuchFieldError e8) {
                                        try {
                                            a[16] = true;
                                        } catch (NoSuchFieldError e9) {
                                            a[18] = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        f36218a[StatusCode.REQUEST_INVALID.ordinal()] = 2;
        a[3] = true;
        f36218a[StatusCode.NETWORK_UNREACHABLE.ordinal()] = 3;
        a[5] = true;
        f36218a[StatusCode.NO_FILL.ordinal()] = 4;
        a[7] = true;
        f36218a[StatusCode.REQUEST_PENDING.ordinal()] = 5;
        a[9] = true;
        f36218a[StatusCode.REQUEST_TIMED_OUT.ordinal()] = 6;
        a[11] = true;
        f36218a[StatusCode.SERVER_ERROR.ordinal()] = 7;
        a[13] = true;
        f36218a[StatusCode.AD_ACTIVE.ordinal()] = 8;
        a[15] = true;
        f36218a[StatusCode.EARLY_REFRESH_REQUEST.ordinal()] = 9;
        a[17] = true;
        a[19] = true;
    }
}
