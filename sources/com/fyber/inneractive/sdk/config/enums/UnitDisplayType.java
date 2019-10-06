package com.fyber.inneractive.sdk.config.enums;

import com.mopub.common.AdType;
import java.util.HashMap;
import java.util.Map;
import p005cm.aptoide.p006pt.BuildConfig;

public enum UnitDisplayType {
    INTERSTITIAL(AdType.INTERSTITIAL),
    LANDSCAPE("landscape"),
    MRECT("mrect"),
    BANNER("banner"),
    REWARDED("rewarded"),
    SQUARE("square"),
    VERTICAL("vertical"),
    DEFAULT(BuildConfig.APTOIDE_THEME);
    
    private static final Map<String, UnitDisplayType> CONSTANTS = null;
    private String stringValue;

    static {
        int i;
        UnitDisplayType[] values;
        CONSTANTS = new HashMap();
        for (UnitDisplayType unitDisplayType : values()) {
            CONSTANTS.put(unitDisplayType.stringValue, unitDisplayType);
        }
    }

    private UnitDisplayType(String str) {
        this.stringValue = str;
    }

    public final String value() {
        return this.stringValue;
    }

    public static UnitDisplayType fromValue(String str) {
        UnitDisplayType unitDisplayType = (UnitDisplayType) CONSTANTS.get(str);
        if (unitDisplayType != null) {
            return unitDisplayType;
        }
        throw new IllegalArgumentException(str);
    }

    public final boolean isFullscreenUnit() {
        return this == INTERSTITIAL || this == REWARDED;
    }

    public final String toString() {
        return this.stringValue;
    }
}
