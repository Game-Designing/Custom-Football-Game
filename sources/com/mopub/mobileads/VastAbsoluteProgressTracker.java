package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import java.io.Serializable;
import java.util.Locale;

public class VastAbsoluteProgressTracker extends VastTracker implements Comparable<VastAbsoluteProgressTracker>, Serializable {

    /* renamed from: e */
    private final int f34975e;

    public VastAbsoluteProgressTracker(C11358a messageType, String content, int trackingMilliseconds) {
        super(messageType, content);
        Preconditions.checkArgument(trackingMilliseconds >= 0);
        this.f34975e = trackingMilliseconds;
    }

    public VastAbsoluteProgressTracker(String trackingUrl, int trackingMilliseconds) {
        this(C11358a.TRACKING_URL, trackingUrl, trackingMilliseconds);
    }

    public int getTrackingMilliseconds() {
        return this.f34975e;
    }

    public int compareTo(VastAbsoluteProgressTracker other) {
        return getTrackingMilliseconds() - other.getTrackingMilliseconds();
    }

    public String toString() {
        return String.format(Locale.US, "%dms: %s", new Object[]{Integer.valueOf(this.f34975e), getContent()});
    }
}
