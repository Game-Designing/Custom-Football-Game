package com.fyber.inneractive.sdk.config.enums;

import java.util.HashMap;
import java.util.Map;

public enum Vendor {
    MOAT("moat");
    
    private static final Map<String, Vendor> CONSTANTS = null;
    private final String value;

    static {
        int i;
        Vendor[] values;
        CONSTANTS = new HashMap();
        for (Vendor vendor : values()) {
            CONSTANTS.put(vendor.value, vendor);
        }
    }

    private Vendor(String str) {
        this.value = str;
    }

    public final String toString() {
        return this.value;
    }

    public final String value() {
        return this.value;
    }

    public static Vendor fromValue(String str) {
        Vendor vendor = (Vendor) CONSTANTS.get(str);
        if (vendor != null) {
            return vendor;
        }
        throw new IllegalArgumentException(str);
    }
}
