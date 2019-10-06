package com.mopub.mobileads;

import com.mopub.common.Preconditions;

public enum VastErrorCode {
    XML_PARSING_ERROR("100"),
    WRAPPER_TIMEOUT("301"),
    NO_ADS_VAST_RESPONSE("303"),
    GENERAL_LINEAR_AD_ERROR("400"),
    GENERAL_COMPANION_AD_ERROR("600"),
    UNDEFINED_ERROR("900");
    

    /* renamed from: b */
    private final String f34983b;

    private VastErrorCode(String errorCode) {
        Preconditions.checkNotNull(errorCode, "errorCode cannot be null");
        this.f34983b = errorCode;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo37219e() {
        return this.f34983b;
    }
}
