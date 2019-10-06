package com.fyber.inneractive.sdk.config.enums;

import java.util.HashMap;
import java.util.Map;

public enum Orientation {
    LANDSCAPE("landscape"),
    PORTRAIT("portrait"),
    USER("user");
    
    private static final Map<String, Orientation> CONSTANTS = null;
    private final String value;

    static {
        int i;
        Orientation[] values;
        CONSTANTS = new HashMap();
        for (Orientation orientation : values()) {
            CONSTANTS.put(orientation.value, orientation);
        }
    }

    private Orientation(String str) {
        this.value = str;
    }

    public final String toString() {
        return this.value;
    }

    public final String value() {
        return this.value;
    }

    public static Orientation fromValue(String str) {
        Orientation orientation = (Orientation) CONSTANTS.get(str);
        if (orientation != null) {
            return orientation;
        }
        throw new IllegalArgumentException(str);
    }
}
