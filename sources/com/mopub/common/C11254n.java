package com.mopub.common;

import com.mopub.common.ExternalViewabilitySessionManager.ViewabilityVendor;

/* renamed from: com.mopub.common.n */
/* compiled from: ExternalViewabilitySessionManager */
/* synthetic */ class C11254n {

    /* renamed from: a */
    static final /* synthetic */ int[] f34428a = new int[ViewabilityVendor.values().length];

    static {
        try {
            f34428a[ViewabilityVendor.AVID.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f34428a[ViewabilityVendor.MOAT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f34428a[ViewabilityVendor.ALL.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
