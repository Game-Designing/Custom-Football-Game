package com.fyber.inneractive.sdk.config.enums;

import java.util.HashMap;
import java.util.Map;

public enum TapAction {
    CTR("ctr"),
    FULLSCREEN("fullscreen"),
    DO_NOTHING("noAction");
    
    private static final Map<String, TapAction> CONSTANTS = null;
    private final String value;

    static {
        int i;
        TapAction[] values;
        CONSTANTS = new HashMap();
        for (TapAction tapAction : values()) {
            CONSTANTS.put(tapAction.value, tapAction);
        }
    }

    private TapAction(String str) {
        this.value = str;
    }

    public final String toString() {
        return this.value;
    }

    public final String value() {
        return this.value;
    }

    public static TapAction fromValue(String str) {
        TapAction tapAction = (TapAction) CONSTANTS.get(str);
        if (tapAction != null) {
            return tapAction;
        }
        throw new IllegalArgumentException(str);
    }
}
