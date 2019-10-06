package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAds.FinishState;
import com.unity3d.ads.UnityAds.PlacementState;
import com.unity3d.ads.UnityAds.UnityAdsError;
import com.unity3d.ads.mediation.IUnityAdsExtendedListener;
import com.vungle.warren.model.Advertisement;
import java.util.Map;

public class UnityInterstitial extends CustomEventInterstitial implements IUnityAdsExtendedListener {

    /* renamed from: b */
    private static final String f34953b = UnityInterstitial.class.getSimpleName();

    /* renamed from: c */
    private CustomEventInterstitialListener f34954c;

    /* renamed from: d */
    private Context f34955d;

    /* renamed from: e */
    private String f34956e = Advertisement.KEY_VIDEO;

    /* renamed from: f */
    private boolean f34957f = false;

    /* renamed from: g */
    private UnityAdsAdapterConfiguration f34958g = new UnityAdsAdapterConfiguration();

    /* access modifiers changed from: protected */
    public void loadInterstitial(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> serverExtras) {
        this.f34956e = UnityRouter.m37548a(serverExtras, this.f34956e);
        this.f34954c = customEventInterstitialListener;
        this.f34955d = context;
        this.f34957f = true;
        this.f34958g.setCachedInitializationParameters(context, serverExtras);
        UnityRouter.m37552b().addListener(this.f34956e, this);
        UnityRouter.m37552b().setCurrentPlacementId(this.f34956e);
        m37542a(serverExtras);
        if (UnityAds.isReady(this.f34956e)) {
            this.f34954c.onInterstitialLoaded();
            this.f34957f = false;
            MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, f34953b);
        } else if (UnityAds.getPlacementState(this.f34956e) == PlacementState.NO_FILL) {
            this.f34954c.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
            UnityRouter.m37552b().removeListener(this.f34956e);
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f34953b, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
        }
    }

    /* renamed from: a */
    private void m37542a(Map<String, String> serverExtras) {
        if (!UnityAds.isInitialized()) {
            Context context = this.f34955d;
            if (!(context instanceof Activity)) {
                MoPubLog.log(AdapterLogEvent.CUSTOM, f34953b, "Context is null or is not an instanceof Activity.");
                return;
            }
            UnityRouter.m37551a(serverExtras, (Activity) context);
        }
    }

    /* access modifiers changed from: protected */
    public void showInterstitial() {
        MoPubLog.log(AdapterLogEvent.SHOW_ATTEMPTED, f34953b);
        if (UnityAds.isReady(this.f34956e)) {
            Context context = this.f34955d;
            if (context != null) {
                UnityAds.show((Activity) context, this.f34956e);
                return;
            }
        }
        MoPubLog.log(AdapterLogEvent.SHOW_FAILED, f34953b, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
        MoPubLog.log(AdapterLogEvent.CUSTOM, f34953b, "Attempted to show Unity interstitial video before it was available.");
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        UnityRouter.m37552b().removeListener(this.f34956e);
        this.f34954c = null;
    }

    public void onUnityAdsReady(String placementId) {
        if (this.f34957f) {
            CustomEventInterstitialListener customEventInterstitialListener = this.f34954c;
            if (customEventInterstitialListener != null) {
                customEventInterstitialListener.onInterstitialLoaded();
                this.f34957f = false;
                MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, f34953b);
            }
        }
    }

    public void onUnityAdsStart(String placementId) {
        CustomEventInterstitialListener customEventInterstitialListener = this.f34954c;
        if (customEventInterstitialListener != null) {
            customEventInterstitialListener.onInterstitialShown();
        }
        MoPubLog.log(AdapterLogEvent.SHOW_SUCCESS, f34953b);
    }

    public void onUnityAdsFinish(String placementId, FinishState finishState) {
        if (this.f34954c != null) {
            if (finishState == FinishState.ERROR) {
                AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("Unity interstitial video encountered a playback error for placement ");
                sb.append(placementId);
                MoPubLog.log(adapterLogEvent, f34953b, sb.toString());
                this.f34954c.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
                MoPubLog.log(AdapterLogEvent.SHOW_FAILED, f34953b, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
            } else {
                AdapterLogEvent adapterLogEvent2 = AdapterLogEvent.CUSTOM;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unity interstitial video completed for placement ");
                sb2.append(placementId);
                MoPubLog.log(adapterLogEvent2, f34953b, sb2.toString());
                this.f34954c.onInterstitialDismissed();
            }
        }
        UnityRouter.m37552b().removeListener(placementId);
    }

    public void onUnityAdsClick(String placementId) {
        CustomEventInterstitialListener customEventInterstitialListener = this.f34954c;
        if (customEventInterstitialListener != null) {
            customEventInterstitialListener.onInterstitialClicked();
        }
        MoPubLog.log(AdapterLogEvent.CLICKED, f34953b);
    }

    public void onUnityAdsPlacementStateChanged(String placementId, PlacementState oldState, PlacementState newState) {
        if (placementId.equals(this.f34956e)) {
            CustomEventInterstitialListener customEventInterstitialListener = this.f34954c;
            if (customEventInterstitialListener != null && newState == PlacementState.NO_FILL) {
                customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
                UnityRouter.m37552b().removeListener(this.f34956e);
                MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f34953b, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
            }
        }
    }

    public void onUnityAdsError(UnityAdsError unityAdsError, String message) {
        if (this.f34954c != null) {
            AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Unity interstitial video cache failed for placement ");
            sb.append(this.f34956e);
            sb.append(".");
            MoPubLog.log(adapterLogEvent, f34953b, sb.toString());
            MoPubErrorCode errorCode = C11355a.m37553a(unityAdsError);
            this.f34954c.onInterstitialFailed(errorCode);
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f34953b, Integer.valueOf(errorCode.getIntCode()), errorCode);
        }
    }
}
