package com.integralads.avid.library.inmobi.session.internal;

import com.vungle.warren.model.Advertisement;

public enum MediaType {
    DISPLAY("display"),
    VIDEO(Advertisement.KEY_VIDEO);
    
    private final String value;

    private MediaType(String str) {
        this.value = str;
    }

    public final String toString() {
        return this.value;
    }
}
