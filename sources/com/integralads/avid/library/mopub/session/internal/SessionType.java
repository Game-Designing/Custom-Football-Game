package com.integralads.avid.library.mopub.session.internal;

import com.vungle.warren.model.Advertisement;

public enum SessionType {
    DISPLAY("display"),
    VIDEO(Advertisement.KEY_VIDEO),
    MANAGED_DISPLAY("managedDisplay"),
    MANAGED_VIDEO("managedVideo");
    
    private final String value;

    private SessionType(String value2) {
        this.value = value2;
    }

    public String toString() {
        return this.value;
    }
}
