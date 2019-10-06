package com.mopub.nativeads;

import com.mopub.network.MoPubNetworkError.Reason;

/* renamed from: com.mopub.nativeads.aa */
/* compiled from: MoPubNative */
/* synthetic */ class C11585aa {

    /* renamed from: a */
    static final /* synthetic */ int[] f36114a = new int[Reason.values().length];

    static {
        try {
            f36114a[Reason.BAD_BODY.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f36114a[Reason.BAD_HEADER_DATA.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f36114a[Reason.WARMING_UP.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f36114a[Reason.NO_FILL.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f36114a[Reason.UNSPECIFIED.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
