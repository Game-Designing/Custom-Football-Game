package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import java.util.Map;

class RewardedVastVideoInterstitial extends VastVideoInterstitial {
    public static final String ADAPTER_NAME = RewardedVastVideoInterstitial.class.getSimpleName();

    /* renamed from: m */
    private RewardedVideoBroadcastReceiver f34925m;

    /* renamed from: com.mopub.mobileads.RewardedVastVideoInterstitial$a */
    interface C11346a extends CustomEventInterstitialListener {
        void onVideoComplete();
    }

    RewardedVastVideoInterstitial() {
    }

    public void loadInterstitial(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> localExtras, Map<String, String> serverExtras) {
        MoPubLog.log(AdapterLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
        super.loadInterstitial(context, customEventInterstitialListener, localExtras, serverExtras);
        if (customEventInterstitialListener instanceof C11346a) {
            this.f34925m = new RewardedVideoBroadcastReceiver((C11346a) customEventInterstitialListener, this.f34916e);
            RewardedVideoBroadcastReceiver rewardedVideoBroadcastReceiver = this.f34925m;
            rewardedVideoBroadcastReceiver.register(rewardedVideoBroadcastReceiver, context);
        }
    }

    public void onVastVideoConfigurationPrepared(VastVideoConfig vastVideoConfig) {
        MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, ADAPTER_NAME);
        if (vastVideoConfig != null) {
            vastVideoConfig.setIsRewardedVideo(true);
        }
        super.onVastVideoConfigurationPrepared(vastVideoConfig);
    }

    public void onInvalidate() {
        super.onInvalidate();
        RewardedVideoBroadcastReceiver rewardedVideoBroadcastReceiver = this.f34925m;
        if (rewardedVideoBroadcastReceiver != null) {
            rewardedVideoBroadcastReceiver.unregister(rewardedVideoBroadcastReceiver);
        }
    }
}
