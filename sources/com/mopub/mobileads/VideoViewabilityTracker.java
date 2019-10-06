package com.mopub.mobileads;

public class VideoViewabilityTracker extends VastTracker {

    /* renamed from: e */
    private final int f35116e;

    /* renamed from: f */
    private final int f35117f;

    public VideoViewabilityTracker(int viewablePlaytimeMS, int percentViewable, String trackerUrl) {
        super(trackerUrl);
        this.f35116e = viewablePlaytimeMS;
        this.f35117f = percentViewable;
    }

    public int getViewablePlaytimeMS() {
        return this.f35116e;
    }

    public int getPercentViewable() {
        return this.f35117f;
    }
}
