package com.integralads.avid.library.inmobi.session.internal;

import com.vungle.warren.model.Advertisement;

public enum SessionType {
    DISPLAY("display"),
    VIDEO(Advertisement.KEY_VIDEO),
    MANAGED_DISPLAY("managedDisplay"),
    MANAGED_VIDEO("managedVideo");
    
    private final String value;

    private SessionType(String str) {
        this.value = str;
    }

    public final String toString() {
        return this.value;
    }
}
