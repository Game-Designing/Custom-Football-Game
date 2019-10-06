package com.integralads.avid.library.mopub.session.internal;

import com.vungle.warren.model.Advertisement;

public enum MediaType {
    DISPLAY("display"),
    VIDEO(Advertisement.KEY_VIDEO);
    
    private final String value;

    private MediaType(String value2) {
        this.value = value2;
    }

    public String toString() {
        return this.value;
    }
}
