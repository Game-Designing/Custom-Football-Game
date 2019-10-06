package com.mopub.common;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import java.util.Map;
import java.util.Set;

public interface ExternalViewabilitySession {

    public enum VideoEvent {
        AD_LOADED(null, "recordAdLoadedEvent"),
        AD_STARTED("AD_EVT_START", "recordAdStartedEvent"),
        AD_STOPPED("AD_EVT_STOPPED", "recordAdStoppedEvent"),
        AD_PAUSED("AD_EVT_PAUSED", "recordAdPausedEvent"),
        AD_PLAYING("AD_EVT_PLAYING", "recordAdPlayingEvent"),
        AD_SKIPPED("AD_EVT_SKIPPED", "recordAdSkippedEvent"),
        AD_IMPRESSED(null, "recordAdImpressionEvent"),
        AD_CLICK_THRU(null, "recordAdClickThruEvent"),
        AD_VIDEO_FIRST_QUARTILE("AD_EVT_FIRST_QUARTILE", "recordAdVideoFirstQuartileEvent"),
        AD_VIDEO_MIDPOINT("AD_EVT_MID_POINT", "recordAdVideoMidpointEvent"),
        AD_VIDEO_THIRD_QUARTILE("AD_EVT_THIRD_QUARTILE", "recordAdVideoThirdQuartileEvent"),
        AD_COMPLETE("AD_EVT_COMPLETE", "recordAdCompleteEvent"),
        RECORD_AD_ERROR(null, "recordAdError");
        

        /* renamed from: b */
        private String f34320b;

        /* renamed from: c */
        private String f34321c;

        private VideoEvent(String moatEnumName, String avidMethodName) {
            this.f34320b = moatEnumName;
            this.f34321c = avidMethodName;
        }

        public String getMoatEnumName() {
            return this.f34320b;
        }

        public String getAvidMethodName() {
            return this.f34321c;
        }
    }

    Boolean createDisplaySession(Context context, WebView webView, boolean z);

    Boolean createVideoSession(Activity activity, View view, Set<String> set, Map<String, String> map);

    Boolean endDisplaySession();

    Boolean endVideoSession();

    String getName();

    Boolean initialize(Context context);

    Boolean invalidate();

    Boolean onVideoPrepared(View view, int i);

    Boolean recordVideoEvent(VideoEvent videoEvent, int i);

    Boolean registerVideoObstruction(View view);

    Boolean startDeferredDisplaySession(Activity activity);
}
