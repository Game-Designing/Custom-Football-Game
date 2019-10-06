package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import java.io.Serializable;
import java.util.Locale;

public class VastFractionalProgressTracker extends VastTracker implements Comparable<VastFractionalProgressTracker>, Serializable {

    /* renamed from: e */
    private final float f34987e;

    public VastFractionalProgressTracker(C11358a messageType, String content, float trackingFraction) {
        super(messageType, content);
        Preconditions.checkArgument(trackingFraction >= 0.0f);
        this.f34987e = trackingFraction;
    }

    public VastFractionalProgressTracker(String trackingUrl, float trackingFraction) {
        this(C11358a.TRACKING_URL, trackingUrl, trackingFraction);
    }

    public float trackingFraction() {
        return this.f34987e;
    }

    public int compareTo(VastFractionalProgressTracker other) {
        return Double.compare((double) trackingFraction(), (double) other.trackingFraction());
    }

    public String toString() {
        return String.format(Locale.US, "%2f: %s", new Object[]{Float.valueOf(this.f34987e), getContent()});
    }
}
