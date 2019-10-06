package com.mopub.mobileads;

import android.app.Activity;
import android.os.Handler;
import com.mopub.common.DataKeys;
import com.mopub.common.LifecycleListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.mobileads.AdTypeTranslator.CustomEventType;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import java.util.Map;

public abstract class MoPubRewardedAd extends CustomEventRewardedAd {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f34847a;

    /* renamed from: b */
    private String f34848b;

    /* renamed from: c */
    private int f34849c;

    /* renamed from: d */
    protected String f34850d;

    protected class MoPubRewardedAdListener implements CustomEventInterstitialListener {

        /* renamed from: a */
        final Class<? extends MoPubRewardedAd> f34851a;

        /* renamed from: b */
        private final Runnable f34852b;

        /* renamed from: c */
        private Handler f34853c = new Handler();

        public MoPubRewardedAdListener(Class<? extends MoPubRewardedAd> customEventClass) {
            Preconditions.checkNotNull(customEventClass);
            this.f34851a = customEventClass;
            this.f34852b = new C11356V(this, MoPubRewardedAd.this);
        }

        public void onInterstitialLoaded() {
            MoPubLog.log(AdLogEvent.LOAD_SUCCESS, new Object[0]);
            MoPubRewardedAd.this.f34847a = true;
            if (CustomEventType.isMoPubSpecific(this.f34851a.getName())) {
                this.f34853c.postDelayed(this.f34852b, 14400000);
            }
            MoPubRewardedVideoManager.onRewardedVideoLoadSuccess(this.f34851a, MoPubRewardedAd.this.getAdNetworkId());
        }

        public void onInterstitialFailed(MoPubErrorCode errorCode) {
            MoPubLog.log(AdLogEvent.SHOW_FAILED, Integer.valueOf(errorCode.getIntCode()), errorCode);
            this.f34853c.removeCallbacks(this.f34852b);
            if (C11351U.f34942a[errorCode.ordinal()] != 1) {
                MoPubRewardedVideoManager.onRewardedVideoLoadFailure(this.f34851a, MoPubRewardedAd.this.getAdNetworkId(), errorCode);
            } else {
                MoPubRewardedVideoManager.onRewardedVideoPlaybackError(this.f34851a, MoPubRewardedAd.this.getAdNetworkId(), errorCode);
            }
        }

        public void onInterstitialShown() {
            MoPubLog.log(AdLogEvent.SHOW_SUCCESS, new Object[0]);
            this.f34853c.removeCallbacks(this.f34852b);
            MoPubRewardedVideoManager.onRewardedVideoStarted(this.f34851a, MoPubRewardedAd.this.getAdNetworkId());
        }

        public void onInterstitialClicked() {
            MoPubLog.log(AdLogEvent.CLICKED, new Object[0]);
            MoPubRewardedVideoManager.onRewardedVideoClicked(this.f34851a, MoPubRewardedAd.this.getAdNetworkId());
        }

        public void onInterstitialImpression() {
        }

        public void onLeaveApplication() {
            MoPubLog.log(AdLogEvent.WILL_LEAVE_APPLICATION, new Object[0]);
        }

        public void onInterstitialDismissed() {
            MoPubLog.log(AdLogEvent.WILL_DISAPPEAR, new Object[0]);
            MoPubRewardedVideoManager.onRewardedVideoClosed(this.f34851a, MoPubRewardedAd.this.getAdNetworkId());
            MoPubRewardedAd.this.mo36904b();
        }
    }

    /* access modifiers changed from: protected */
    public LifecycleListener getLifecycleListener() {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity launcherActivity, Map<String, Object> map, Map<String, String> map2) throws Exception {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36905b(Activity activity, Map<String, Object> localExtras, Map<String, String> serverExtras) throws Exception {
        Preconditions.checkNotNull(activity, "activity cannot be null");
        Preconditions.checkNotNull(localExtras, "localExtras cannot be null");
        Preconditions.checkNotNull(serverExtras, "serverExtras cannot be null");
        Object rewardedAdCurrencyName = localExtras.get(DataKeys.REWARDED_AD_CURRENCY_NAME_KEY);
        if (rewardedAdCurrencyName instanceof String) {
            this.f34848b = (String) rewardedAdCurrencyName;
        } else {
            MoPubLog.log(AdLogEvent.CUSTOM, "No currency name specified for rewarded video. Using the default name.");
            this.f34848b = "";
        }
        Object rewardedAdCurrencyAmount = localExtras.get(DataKeys.REWARDED_AD_CURRENCY_AMOUNT_STRING_KEY);
        if (rewardedAdCurrencyAmount instanceof String) {
            try {
                this.f34849c = Integer.parseInt((String) rewardedAdCurrencyAmount);
            } catch (NumberFormatException e) {
                AdLogEvent adLogEvent = AdLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to convert currency amount: ");
                sb.append(rewardedAdCurrencyAmount);
                sb.append(". Using the default reward amount: ");
                sb.append(0);
                MoPubLog.log(adLogEvent, sb.toString());
                this.f34849c = 0;
            }
        } else {
            MoPubLog.log(AdLogEvent.CUSTOM, "No currency amount specified for rewarded ad. Using the default reward amount: 0");
            this.f34849c = 0;
        }
        if (this.f34849c < 0) {
            MoPubLog.log(AdLogEvent.CUSTOM, "Negative currency amount specified for rewarded ad. Using the default reward amount: 0");
            this.f34849c = 0;
        }
        Object adUnitId = localExtras.get(DataKeys.AD_UNIT_ID_KEY);
        if (adUnitId instanceof String) {
            this.f34850d = (String) adUnitId;
            return;
        }
        MoPubLog.log(AdLogEvent.CUSTOM, "Unable to set ad unit for rewarded ad.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36904b() {
        this.f34847a = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo36993a() {
        return this.f34847a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo37087e() {
        return this.f34848b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public int mo37086d() {
        return this.f34849c;
    }
}
