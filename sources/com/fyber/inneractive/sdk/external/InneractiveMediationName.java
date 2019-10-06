package com.fyber.inneractive.sdk.external;

import com.integralads.avid.library.mopub.BuildConfig;

public enum InneractiveMediationName {
    MOPUB(BuildConfig.SDK_NAME),
    ADMOB("admob"),
    DFP("dfp"),
    FYBER("fyber"),
    OTHER("other");
    

    /* renamed from: a */
    final String f15407a;

    private InneractiveMediationName(String str) {
        this.f15407a = str;
    }

    public final String getKey() {
        return this.f15407a;
    }
}
