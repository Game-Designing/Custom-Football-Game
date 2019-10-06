package com.smaato.soma;

/* renamed from: com.smaato.soma.c */
/* compiled from: AdDimension */
public enum C12150c {
    DEFAULT("MMA"),
    f38087b(r3),
    f38088c(r4),
    MEDIUMRECTANGLE("MEDRECT"),
    LEADERBOARD("LEADER"),
    SKYSCRAPER("SKY"),
    WIDESKYSCRAPER("WIDESKY"),
    INTERSTITIAL_PORTRAIT("full_320x480", "full_768x1024"),
    INTERSTITIAL_LANDSCAPE("full_480x320", "full_1024x768"),
    NOT_SET("");
    

    /* renamed from: l */
    private final String f38097l;

    /* renamed from: m */
    private final String f38098m;

    private C12150c(String requestString) {
        this(r1, r2, requestString, requestString);
    }

    private C12150c(String requestString, String requestStringTablet) {
        this.f38097l = requestString;
        this.f38098m = requestStringTablet;
    }

    /* renamed from: a */
    public String mo39386a(boolean isTablet) {
        return isTablet ? this.f38098m : this.f38097l;
    }
}
