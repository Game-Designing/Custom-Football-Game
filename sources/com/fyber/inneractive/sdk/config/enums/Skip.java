package com.fyber.inneractive.sdk.config.enums;

import java.util.HashMap;
import java.util.Map;

public enum Skip {
    DEFAULT(Integer.valueOf(-1)),
    _0(Integer.valueOf(0)),
    _10(Integer.valueOf(10)),
    _15(Integer.valueOf(15)),
    _5(Integer.valueOf(5));
    
    private static final Map<Integer, Skip> CONSTANTS = null;
    private final Integer value;

    static {
        int i;
        Skip[] values;
        CONSTANTS = new HashMap();
        for (Skip skip : values()) {
            CONSTANTS.put(skip.value, skip);
        }
    }

    private Skip(Integer num) {
        this.value = num;
    }

    public final Integer value() {
        return this.value;
    }

    public static Skip fromValue(Integer num) {
        Skip skip = (Skip) CONSTANTS.get(num);
        if (skip != null) {
            return skip;
        }
        throw new IllegalArgumentException(String.valueOf(num));
    }
}
