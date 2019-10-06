package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.CacheService;
import com.mopub.common.DataKeys;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Json;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.VastManager.VastManagerListener;
import com.mopub.mobileads.factories.VastManagerFactory;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class VastVideoInterstitial extends ResponseBodyInterstitial implements VastManagerListener {
    public static final String ADAPTER_NAME = VastVideoInterstitial.class.getSimpleName();

    /* renamed from: g */
    private CustomEventInterstitialListener f35060g;

    /* renamed from: h */
    private String f35061h;

    /* renamed from: i */
    private VastManager f35062i;

    /* renamed from: j */
    private VastVideoConfig f35063j;

    /* renamed from: k */
    private JSONObject f35064k;

    /* renamed from: l */
    private Map<String, String> f35065l;

    VastVideoInterstitial() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37028a(Map<String, String> serverExtras) {
        this.f35061h = (String) serverExtras.get(DataKeys.HTML_RESPONSE_BODY_KEY);
        String externalViewabilityTrackers = (String) serverExtras.get(DataKeys.EXTERNAL_VIDEO_VIEWABILITY_TRACKERS_KEY);
        try {
            this.f35065l = Json.jsonStringToMap(externalViewabilityTrackers);
        } catch (JSONException e) {
            AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to parse video viewability trackers to JSON: ");
            sb.append(externalViewabilityTrackers);
            MoPubLog.log(adapterLogEvent, sb.toString());
        }
        String videoTrackers = (String) serverExtras.get(DataKeys.VIDEO_TRACKERS_KEY);
        if (!TextUtils.isEmpty(videoTrackers)) {
            try {
                this.f35064k = new JSONObject(videoTrackers);
            } catch (JSONException e2) {
                SdkLogEvent sdkLogEvent = SdkLogEvent.ERROR;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to parse video trackers to JSON: ");
                sb2.append(videoTrackers);
                MoPubLog.log(sdkLogEvent, sb2.toString(), e2);
                this.f35064k = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37027a(CustomEventInterstitialListener customEventInterstitialListener) {
        this.f35060g = customEventInterstitialListener;
        if (!CacheService.initializeDiskCache(this.f34914c)) {
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, ADAPTER_NAME, Integer.valueOf(MoPubErrorCode.VIDEO_CACHE_ERROR.getIntCode()), MoPubErrorCode.VIDEO_CACHE_ERROR);
            this.f35060g.onInterstitialFailed(MoPubErrorCode.VIDEO_CACHE_ERROR);
            return;
        }
        this.f35062i = VastManagerFactory.create(this.f34914c);
        this.f35062i.prepareVastVideoConfiguration(this.f35061h, this, this.f34915d.getDspCreativeId(), this.f34914c);
        MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, ADAPTER_NAME);
    }

    public void showInterstitial() {
        MoPubLog.log(AdapterLogEvent.SHOW_ATTEMPTED, ADAPTER_NAME);
        BaseVideoPlayerActivity.m37294b(this.f34914c, this.f35063j, this.f34916e);
    }

    public void onInvalidate() {
        VastManager vastManager = this.f35062i;
        if (vastManager != null) {
            vastManager.cancel();
        }
        super.onInvalidate();
    }

    public void onVastVideoConfigurationPrepared(VastVideoConfig vastVideoConfig) {
        if (vastVideoConfig == null) {
            this.f35060g.onInterstitialFailed(MoPubErrorCode.VIDEO_DOWNLOAD_ERROR);
            return;
        }
        this.f35063j = vastVideoConfig;
        this.f35063j.addVideoTrackers(this.f35064k);
        this.f35063j.addExternalViewabilityTrackers(this.f35065l);
        this.f35060g.onInterstitialLoaded();
    }
}
