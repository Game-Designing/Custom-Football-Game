package com.smaato.soma;

import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.smaato.soma.ia */
/* compiled from: ErrorCode */
public enum C12408ia {
    NO_ERROR(BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID),
    UNKNOWN_PUBLISHER_OR_ADSPACE_ID("106"),
    f38748c(r4),
    NO_AD_AVAILABLE("42"),
    GENERAL_ERROR("107"),
    f38751f(r7),
    INVALID_REQUEST,
    ADAPTER_NOT_FOUND,
    ADAPTER_CONFIGURATION_ERROR,
    UNSPECIFIED,
    NETWORK_TIMEOUT,
    NETWORK_NO_FILL,
    NETWORK_INVALID_STATE;
    

    /* renamed from: o */
    private String f38760o;

    private C12408ia(String responseString) {
        this.f38760o = responseString;
    }

    /* renamed from: e */
    public String mo39903e() {
        return this.f38760o;
    }

    /* renamed from: a */
    public static C12408ia m40800a(String string) {
        for (C12408ia value : values()) {
            if (value.f38760o.equalsIgnoreCase(string)) {
                return value;
            }
        }
        return null;
    }
}
