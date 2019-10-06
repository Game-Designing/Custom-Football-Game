package com.mopub.common;

public enum CreativeOrientation {
    PORTRAIT,
    LANDSCAPE,
    DEVICE;

    public static CreativeOrientation fromString(String orientation) {
        if ("l".equalsIgnoreCase(orientation)) {
            return LANDSCAPE;
        }
        if ("p".equalsIgnoreCase(orientation)) {
            return PORTRAIT;
        }
        return DEVICE;
    }
}
