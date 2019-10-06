package com.mopub.mobileads;

/* renamed from: com.mopub.mobileads.ab */
/* compiled from: VideoTrackingEvent */
enum C11380ab {
    START("start"),
    FIRST_QUARTILE("firstQuartile"),
    MIDPOINT("midpoint"),
    THIRD_QUARTILE("thirdQuartile"),
    COMPLETE("complete"),
    COMPANION_AD_VIEW("companionAdView"),
    COMPANION_AD_CLICK("companionAdClick"),
    UNKNOWN("");
    

    /* renamed from: b */
    private final String f35197b;

    private C11380ab(String name) {
        this.f35197b = name;
    }

    public String getName() {
        return this.f35197b;
    }

    public static C11380ab fromString(String name) {
        C11380ab[] values;
        if (name == null) {
            return UNKNOWN;
        }
        for (C11380ab event : values()) {
            if (name.equals(event.getName())) {
                return event;
            }
        }
        return UNKNOWN;
    }
}
