package com.mopub.mobileads;

import com.mopub.network.MoPubNetworkError.Reason;

/* renamed from: com.mopub.mobileads.ba */
/* compiled from: MoPubRewardedVideoManager */
/* synthetic */ class C11384ba {

    /* renamed from: a */
    static final /* synthetic */ int[] f35219a = new int[Reason.values().length];

    static {
        try {
            f35219a[Reason.NO_FILL.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f35219a[Reason.WARMING_UP.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f35219a[Reason.BAD_BODY.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f35219a[Reason.BAD_HEADER_DATA.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
