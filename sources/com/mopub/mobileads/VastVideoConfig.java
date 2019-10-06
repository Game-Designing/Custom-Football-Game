package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.DeviceUtils.ForceOrientation;
import com.mopub.common.util.Strings;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class VastVideoConfig implements Serializable {

    /* renamed from: A */
    private final Set<String> f35017A = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: B */
    public String f35018B;

    /* renamed from: C */
    private String f35019C;

    /* renamed from: D */
    private String f35020D;

    /* renamed from: E */
    private boolean f35021E;

    /* renamed from: a */
    private final ArrayList<VastTracker> f35022a = new ArrayList<>();

    /* renamed from: b */
    private final ArrayList<VastFractionalProgressTracker> f35023b = new ArrayList<>();

    /* renamed from: c */
    private final ArrayList<VastAbsoluteProgressTracker> f35024c = new ArrayList<>();

    /* renamed from: d */
    private final ArrayList<VastTracker> f35025d = new ArrayList<>();

    /* renamed from: e */
    private final ArrayList<VastTracker> f35026e = new ArrayList<>();

    /* renamed from: f */
    private final ArrayList<VastTracker> f35027f = new ArrayList<>();

    /* renamed from: g */
    private final ArrayList<VastTracker> f35028g = new ArrayList<>();

    /* renamed from: h */
    private final ArrayList<VastTracker> f35029h = new ArrayList<>();

    /* renamed from: i */
    private final ArrayList<VastTracker> f35030i = new ArrayList<>();

    /* renamed from: j */
    private final ArrayList<VastTracker> f35031j = new ArrayList<>();

    /* renamed from: k */
    private String f35032k;

    /* renamed from: l */
    private String f35033l;

    /* renamed from: m */
    private String f35034m;

    /* renamed from: n */
    private String f35035n;

    /* renamed from: o */
    private VastCompanionAdConfig f35036o;

    /* renamed from: p */
    private VastCompanionAdConfig f35037p;

    /* renamed from: q */
    private Map<String, VastCompanionAdConfig> f35038q = new HashMap();

    /* renamed from: r */
    private C11302Ca f35039r;

    /* renamed from: s */
    private boolean f35040s = false;

    /* renamed from: t */
    private String f35041t;

    /* renamed from: u */
    private String f35042u;

    /* renamed from: v */
    private String f35043v;

    /* renamed from: w */
    private ForceOrientation f35044w = ForceOrientation.FORCE_LANDSCAPE;

    /* renamed from: x */
    private VideoViewabilityTracker f35045x;

    /* renamed from: y */
    private final Map<String, String> f35046y = new HashMap();

    /* renamed from: z */
    private final Set<String> f35047z = new HashSet();

    public void setDspCreativeId(String dspCreativeId) {
        this.f35018B = dspCreativeId;
    }

    public String getDspCreativeId() {
        return this.f35018B;
    }

    public void addImpressionTrackers(List<VastTracker> impressionTrackers) {
        Preconditions.checkNotNull(impressionTrackers, "impressionTrackers cannot be null");
        this.f35022a.addAll(impressionTrackers);
    }

    public void addFractionalTrackers(List<VastFractionalProgressTracker> fractionalTrackers) {
        Preconditions.checkNotNull(fractionalTrackers, "fractionalTrackers cannot be null");
        this.f35023b.addAll(fractionalTrackers);
        Collections.sort(this.f35023b);
    }

    public void addAbsoluteTrackers(List<VastAbsoluteProgressTracker> absoluteTrackers) {
        Preconditions.checkNotNull(absoluteTrackers, "absoluteTrackers cannot be null");
        this.f35024c.addAll(absoluteTrackers);
        Collections.sort(this.f35024c);
    }

    public void addCompleteTrackers(List<VastTracker> completeTrackers) {
        Preconditions.checkNotNull(completeTrackers, "completeTrackers cannot be null");
        this.f35027f.addAll(completeTrackers);
    }

    public void addPauseTrackers(List<VastTracker> pauseTrackers) {
        Preconditions.checkNotNull(pauseTrackers, "pauseTrackers cannot be null");
        this.f35025d.addAll(pauseTrackers);
    }

    public void addResumeTrackers(List<VastTracker> resumeTrackers) {
        Preconditions.checkNotNull(resumeTrackers, "resumeTrackers cannot be null");
        this.f35026e.addAll(resumeTrackers);
    }

    public void addCloseTrackers(List<VastTracker> closeTrackers) {
        Preconditions.checkNotNull(closeTrackers, "closeTrackers cannot be null");
        this.f35028g.addAll(closeTrackers);
    }

    public void addSkipTrackers(List<VastTracker> skipTrackers) {
        Preconditions.checkNotNull(skipTrackers, "skipTrackers cannot be null");
        this.f35029h.addAll(skipTrackers);
    }

    public void addClickTrackers(List<VastTracker> clickTrackers) {
        Preconditions.checkNotNull(clickTrackers, "clickTrackers cannot be null");
        this.f35030i.addAll(clickTrackers);
    }

    public void addErrorTrackers(List<VastTracker> errorTrackers) {
        Preconditions.checkNotNull(errorTrackers, "errorTrackers cannot be null");
        this.f35031j.addAll(errorTrackers);
    }

    public void addVideoTrackers(JSONObject videoTrackers) {
        if (videoTrackers != null) {
            JSONArray urls = videoTrackers.optJSONArray(Constants.VIDEO_TRACKING_URLS_KEY);
            JSONArray events = videoTrackers.optJSONArray(Constants.VIDEO_TRACKING_EVENTS_KEY);
            if (urls != null && events != null) {
                for (int i = 0; i < events.length(); i++) {
                    String eventName = events.optString(i);
                    List<String> urlsForEvent = m37588a(eventName, urls);
                    C11380ab event = C11380ab.fromString(eventName);
                    if (!(eventName == null || urlsForEvent == null)) {
                        switch (C11329Ma.f34828a[event.ordinal()]) {
                            case 1:
                                m37594d(urlsForEvent);
                                break;
                            case 2:
                                m37591a(urlsForEvent, 0.25f);
                                break;
                            case 3:
                                m37591a(urlsForEvent, 0.5f);
                                break;
                            case 4:
                                m37591a(urlsForEvent, 0.75f);
                                break;
                            case 5:
                                m37593c(urlsForEvent);
                                break;
                            case 6:
                                m37592b(urlsForEvent);
                                break;
                            case 7:
                                m37590a(urlsForEvent);
                                break;
                            default:
                                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                                StringBuilder sb = new StringBuilder();
                                sb.append("Encountered unknown video tracking event: ");
                                sb.append(eventName);
                                MoPubLog.log(sdkLogEvent, sb.toString());
                                break;
                        }
                    }
                }
            }
        }
    }

    public void addExternalViewabilityTrackers(Map<String, String> externalViewabilityTrackers) {
        if (externalViewabilityTrackers != null) {
            this.f35046y.putAll(externalViewabilityTrackers);
        }
    }

    public void addAvidJavascriptResources(Set<String> javascriptResources) {
        if (javascriptResources != null) {
            this.f35047z.addAll(javascriptResources);
        }
    }

    public void addMoatImpressionPixels(Set<String> impressionPixels) {
        if (impressionPixels != null) {
            this.f35017A.addAll(impressionPixels);
        }
    }

    public void setClickThroughUrl(String clickThroughUrl) {
        this.f35032k = clickThroughUrl;
    }

    public void setNetworkMediaFileUrl(String networkMediaFileUrl) {
        this.f35033l = networkMediaFileUrl;
    }

    public void setDiskMediaFileUrl(String diskMediaFileUrl) {
        this.f35034m = diskMediaFileUrl;
    }

    public void setVastCompanionAd(VastCompanionAdConfig landscapeVastCompanionAdConfig, VastCompanionAdConfig portraitVastCompanionAdConfig) {
        this.f35036o = landscapeVastCompanionAdConfig;
        this.f35037p = portraitVastCompanionAdConfig;
    }

    public void setSocialActionsCompanionAds(Map<String, VastCompanionAdConfig> socialActionsCompanionAds) {
        this.f35038q = socialActionsCompanionAds;
    }

    public void setVastIconConfig(C11302Ca vastIconConfig) {
        this.f35039r = vastIconConfig;
    }

    public void setCustomCtaText(String customCtaText) {
        if (customCtaText != null) {
            this.f35041t = customCtaText;
        }
    }

    public void setCustomSkipText(String customSkipText) {
        if (customSkipText != null) {
            this.f35042u = customSkipText;
        }
    }

    public void setCustomCloseIconUrl(String customCloseIconUrl) {
        if (customCloseIconUrl != null) {
            this.f35043v = customCloseIconUrl;
        }
    }

    public void setCustomForceOrientation(ForceOrientation customForceOrientation) {
        if (customForceOrientation != null && customForceOrientation != ForceOrientation.UNDEFINED) {
            this.f35044w = customForceOrientation;
            this.f35021E = true;
        }
    }

    public void setSkipOffset(String skipOffset) {
        if (skipOffset != null) {
            this.f35035n = skipOffset;
        }
    }

    public void setVideoViewabilityTracker(VideoViewabilityTracker videoViewabilityTracker) {
        if (videoViewabilityTracker != null) {
            this.f35045x = videoViewabilityTracker;
        }
    }

    public void setIsRewardedVideo(boolean isRewardedVideo) {
        this.f35040s = isRewardedVideo;
    }

    public void setPrivacyInformationIconImageUrl(String privacyInformationIconImageUrl) {
        this.f35019C = privacyInformationIconImageUrl;
    }

    public void setPrivacyInformationIconClickthroughUrl(String privacyInformationIconClickthroughUrl) {
        this.f35020D = privacyInformationIconClickthroughUrl;
    }

    public List<VastTracker> getImpressionTrackers() {
        return this.f35022a;
    }

    public ArrayList<VastAbsoluteProgressTracker> getAbsoluteTrackers() {
        return this.f35024c;
    }

    public ArrayList<VastFractionalProgressTracker> getFractionalTrackers() {
        return this.f35023b;
    }

    public List<VastTracker> getPauseTrackers() {
        return this.f35025d;
    }

    public List<VastTracker> getResumeTrackers() {
        return this.f35026e;
    }

    public List<VastTracker> getCompleteTrackers() {
        return this.f35027f;
    }

    public List<VastTracker> getCloseTrackers() {
        return this.f35028g;
    }

    public List<VastTracker> getSkipTrackers() {
        return this.f35029h;
    }

    public List<VastTracker> getClickTrackers() {
        return this.f35030i;
    }

    public List<VastTracker> getErrorTrackers() {
        return this.f35031j;
    }

    public String getClickThroughUrl() {
        return this.f35032k;
    }

    public String getNetworkMediaFileUrl() {
        return this.f35033l;
    }

    public String getDiskMediaFileUrl() {
        return this.f35034m;
    }

    public VastCompanionAdConfig getVastCompanionAd(int orientation) {
        if (orientation == 1) {
            return this.f35037p;
        }
        if (orientation != 2) {
            return this.f35036o;
        }
        return this.f35036o;
    }

    public Map<String, VastCompanionAdConfig> getSocialActionsCompanionAds() {
        return this.f35038q;
    }

    public C11302Ca getVastIconConfig() {
        return this.f35039r;
    }

    public String getCustomCtaText() {
        return this.f35041t;
    }

    public String getCustomSkipText() {
        return this.f35042u;
    }

    public String getCustomCloseIconUrl() {
        return this.f35043v;
    }

    public VideoViewabilityTracker getVideoViewabilityTracker() {
        return this.f35045x;
    }

    public Map<String, String> getExternalViewabilityTrackers() {
        return this.f35046y;
    }

    public Set<String> getAvidJavascriptResources() {
        return this.f35047z;
    }

    public Set<String> getMoatImpressionPixels() {
        return this.f35017A;
    }

    public boolean isCustomForceOrientationSet() {
        return this.f35021E;
    }

    public boolean hasCompanionAd() {
        return (this.f35036o == null || this.f35037p == null) ? false : true;
    }

    public ForceOrientation getCustomForceOrientation() {
        return this.f35044w;
    }

    public String getSkipOffsetString() {
        return this.f35035n;
    }

    public boolean isRewardedVideo() {
        return this.f35040s;
    }

    public String getPrivacyInformationIconImageUrl() {
        return this.f35019C;
    }

    public String getPrivacyInformationIconClickthroughUrl() {
        return this.f35020D;
    }

    public void handleImpression(Context context, int contentPlayHead) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.f35022a, null, Integer.valueOf(contentPlayHead), this.f35033l, context);
    }

    public void handleClickForResult(Activity activity, int contentPlayHead, int requestCode) {
        m37589a(activity, contentPlayHead, Integer.valueOf(requestCode));
    }

    public void handleClickWithoutResult(Context context, int contentPlayHead) {
        m37589a(context.getApplicationContext(), contentPlayHead, null);
    }

    /* renamed from: a */
    private void m37589a(Context context, int contentPlayHead, Integer requestCode) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.f35030i, null, Integer.valueOf(contentPlayHead), this.f35033l, context);
        if (!TextUtils.isEmpty(this.f35032k)) {
            new Builder().withDspCreativeId(this.f35018B).withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).withResultActions(new C11327La(this, context, requestCode)).withoutMoPubBrowser().build().handleUrl(context, this.f35032k);
        }
    }

    public void handleResume(Context context, int contentPlayHead) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.f35026e, null, Integer.valueOf(contentPlayHead), this.f35033l, context);
    }

    public void handlePause(Context context, int contentPlayHead) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.f35025d, null, Integer.valueOf(contentPlayHead), this.f35033l, context);
    }

    public void handleClose(Context context, int contentPlayHead) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.f35028g, null, Integer.valueOf(contentPlayHead), this.f35033l, context);
        TrackingRequest.makeVastTrackingHttpRequest(this.f35029h, null, Integer.valueOf(contentPlayHead), this.f35033l, context);
    }

    public void handleComplete(Context context, int contentPlayHead) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.f35027f, null, Integer.valueOf(contentPlayHead), this.f35033l, context);
    }

    public void handleError(Context context, VastErrorCode errorCode, int contentPlayHead) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.f35031j, errorCode, Integer.valueOf(contentPlayHead), this.f35033l, context);
    }

    public List<VastTracker> getUntriggeredTrackersBefore(int currentPositionMillis, int videoLengthMillis) {
        if (!NoThrow.checkArgument(videoLengthMillis > 0) || currentPositionMillis < 0) {
            return Collections.emptyList();
        }
        float progressFraction = ((float) currentPositionMillis) / ((float) videoLengthMillis);
        List<VastTracker> untriggeredTrackers = new ArrayList<>();
        String str = "";
        VastAbsoluteProgressTracker absoluteTest = new VastAbsoluteProgressTracker(str, currentPositionMillis);
        int absoluteTrackerCount = this.f35024c.size();
        for (int i = 0; i < absoluteTrackerCount; i++) {
            VastAbsoluteProgressTracker tracker = (VastAbsoluteProgressTracker) this.f35024c.get(i);
            if (tracker.compareTo(absoluteTest) > 0) {
                break;
            }
            if (!tracker.isTracked()) {
                untriggeredTrackers.add(tracker);
            }
        }
        VastFractionalProgressTracker fractionalTest = new VastFractionalProgressTracker(str, progressFraction);
        int fractionalTrackerCount = this.f35023b.size();
        for (int i2 = 0; i2 < fractionalTrackerCount; i2++) {
            VastFractionalProgressTracker tracker2 = (VastFractionalProgressTracker) this.f35023b.get(i2);
            if (tracker2.compareTo(fractionalTest) > 0) {
                break;
            }
            if (!tracker2.isTracked()) {
                untriggeredTrackers.add(tracker2);
            }
        }
        return untriggeredTrackers;
    }

    public int getRemainingProgressTrackerCount() {
        return getUntriggeredTrackersBefore(MoPubClientPositioning.NO_REPEAT, MoPubClientPositioning.NO_REPEAT).size();
    }

    public Integer getSkipOffsetMillis(int videoDuration) {
        Integer skipOffsetMilliseconds;
        String str = this.f35035n;
        if (str != null) {
            try {
                if (Strings.isAbsoluteTracker(str)) {
                    skipOffsetMilliseconds = Strings.parseAbsoluteOffset(this.f35035n);
                } else if (Strings.isPercentageTracker(this.f35035n)) {
                    skipOffsetMilliseconds = Integer.valueOf(Math.round(((float) videoDuration) * (Float.parseFloat(this.f35035n.replace("%", "")) / 100.0f)));
                } else {
                    MoPubLog.log(SdkLogEvent.CUSTOM, String.format("Invalid VAST skipoffset format: %s", new Object[]{this.f35035n}));
                    return null;
                }
                if (skipOffsetMilliseconds != null) {
                    if (skipOffsetMilliseconds.intValue() < videoDuration) {
                        return skipOffsetMilliseconds;
                    }
                    return Integer.valueOf(videoDuration);
                }
            } catch (NumberFormatException e) {
                MoPubLog.log(SdkLogEvent.CUSTOM, String.format("Failed to parse skipoffset %s", new Object[]{this.f35035n}));
            }
        }
        return null;
    }

    /* renamed from: a */
    private List<String> m37588a(String event, JSONArray urls) {
        Preconditions.checkNotNull(urls);
        if (event == null) {
            return null;
        }
        List<String> hydratedUrls = new ArrayList<>();
        for (int i = 0; i < urls.length(); i++) {
            String url = urls.optString(i);
            if (url != null) {
                hydratedUrls.add(url.replace(Constants.VIDEO_TRACKING_URL_MACRO, event));
            }
        }
        return hydratedUrls;
    }

    /* renamed from: e */
    private List<VastTracker> m37595e(List<String> urls) {
        Preconditions.checkNotNull(urls);
        List<VastTracker> trackers = new ArrayList<>();
        for (String url : urls) {
            trackers.add(new VastTracker(url));
        }
        return trackers;
    }

    /* renamed from: c */
    private void m37593c(List<String> urls) {
        Preconditions.checkNotNull(urls);
        addCompleteTrackers(m37595e(urls));
    }

    /* renamed from: d */
    private void m37594d(List<String> urls) {
        Preconditions.checkNotNull(urls);
        List<VastAbsoluteProgressTracker> startTrackers = new ArrayList<>();
        for (String url : urls) {
            startTrackers.add(new VastAbsoluteProgressTracker(url, 0));
        }
        addAbsoluteTrackers(startTrackers);
    }

    /* renamed from: a */
    private void m37591a(List<String> urls, float fraction) {
        Preconditions.checkNotNull(urls);
        List<VastFractionalProgressTracker> fractionalTrackers = new ArrayList<>();
        for (String url : urls) {
            fractionalTrackers.add(new VastFractionalProgressTracker(url, fraction));
        }
        addFractionalTrackers(fractionalTrackers);
    }

    /* renamed from: b */
    private void m37592b(List<String> urls) {
        Preconditions.checkNotNull(urls);
        if (hasCompanionAd()) {
            List<VastTracker> companionAdViewTrackers = m37595e(urls);
            this.f35036o.addCreativeViewTrackers(companionAdViewTrackers);
            this.f35037p.addCreativeViewTrackers(companionAdViewTrackers);
        }
    }

    /* renamed from: a */
    private void m37590a(List<String> urls) {
        Preconditions.checkNotNull(urls);
        if (hasCompanionAd()) {
            List<VastTracker> companionAdClickTrackers = m37595e(urls);
            this.f35036o.addClickTrackers(companionAdClickTrackers);
            this.f35037p.addClickTrackers(companionAdClickTrackers);
        }
    }
}
