package com.mopub.common.privacy;

public enum ConsentStatus {
    EXPLICIT_YES("explicit_yes"),
    EXPLICIT_NO("explicit_no"),
    UNKNOWN("unknown"),
    POTENTIAL_WHITELIST("potential_whitelist"),
    DNT("dnt");
    

    /* renamed from: b */
    private final String f34456b;

    private ConsentStatus(String value) {
        this.f34456b = value;
    }

    public String getValue() {
        return this.f34456b;
    }

    public static ConsentStatus fromString(String name) {
        ConsentStatus[] values;
        if (name == null) {
            return UNKNOWN;
        }
        for (ConsentStatus consentState : values()) {
            if (name.equals(consentState.name())) {
                return consentState;
            }
        }
        return UNKNOWN;
    }
}
