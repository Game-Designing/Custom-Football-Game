package com.mopub.mobileads;

import android.os.Handler;
import com.mopub.common.ExternalViewabilitySession.VideoEvent;
import com.mopub.common.Preconditions;
import com.mopub.network.TrackingRequest;
import java.util.ArrayList;
import java.util.List;

public class VastVideoViewProgressRunnable extends RepeatingHandlerRunnable {

    /* renamed from: d */
    private final VastVideoViewController f35104d;

    /* renamed from: e */
    private final VastVideoConfig f35105e;

    public VastVideoViewProgressRunnable(VastVideoViewController videoViewController, VastVideoConfig vastVideoConfig, Handler handler) {
        super(handler);
        Preconditions.checkNotNull(videoViewController);
        Preconditions.checkNotNull(vastVideoConfig);
        this.f35104d = videoViewController;
        this.f35105e = vastVideoConfig;
        List<VastFractionalProgressTracker> trackers = new ArrayList<>();
        trackers.add(new VastFractionalProgressTracker(C11358a.QUARTILE_EVENT, VideoEvent.AD_STARTED.name(), 0.0f));
        trackers.add(new VastFractionalProgressTracker(C11358a.QUARTILE_EVENT, VideoEvent.AD_IMPRESSED.name(), 0.0f));
        trackers.add(new VastFractionalProgressTracker(C11358a.QUARTILE_EVENT, VideoEvent.AD_VIDEO_FIRST_QUARTILE.name(), 0.25f));
        trackers.add(new VastFractionalProgressTracker(C11358a.QUARTILE_EVENT, VideoEvent.AD_VIDEO_MIDPOINT.name(), 0.5f));
        trackers.add(new VastFractionalProgressTracker(C11358a.QUARTILE_EVENT, VideoEvent.AD_VIDEO_THIRD_QUARTILE.name(), 0.75f));
        this.f35105e.addFractionalTrackers(trackers);
    }

    public void doWork() {
        int videoLength = this.f35104d.mo37367j();
        int currentPosition = this.f35104d.mo37366i();
        this.f35104d.mo37372o();
        if (videoLength > 0) {
            List<VastTracker> trackersToTrack = this.f35105e.getUntriggeredTrackersBefore(currentPosition, videoLength);
            if (!trackersToTrack.isEmpty()) {
                List<String> trackUrls = new ArrayList<>();
                for (VastTracker tracker : trackersToTrack) {
                    if (tracker.getMessageType() == C11358a.TRACKING_URL) {
                        trackUrls.add(tracker.getContent());
                    } else if (tracker.getMessageType() == C11358a.QUARTILE_EVENT) {
                        this.f35104d.mo37365b(tracker.getContent());
                    }
                    tracker.setTracked();
                }
                TrackingRequest.makeTrackingHttpRequest((Iterable<String>) new VastMacroHelper(trackUrls).withAssetUri(this.f35104d.mo37368k()).withContentPlayHead(Integer.valueOf(currentPosition)).getUris(), this.f35104d.mo36929b());
            }
            this.f35104d.mo37364a(currentPosition);
        }
    }
}
