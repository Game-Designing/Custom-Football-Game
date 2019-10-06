package com.mopub.mobileads;

import android.app.Activity;
import com.mopub.common.MoPubReward;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import java.util.Map;

public class MoPubRewardedVideo extends MoPubRewardedAd {

    /* renamed from: e */
    private RewardedVastVideoInterstitial f34857e = new RewardedVastVideoInterstitial();

    /* renamed from: com.mopub.mobileads.MoPubRewardedVideo$a */
    private class C11333a extends MoPubRewardedAdListener implements C11346a {
        public C11333a() {
            super(MoPubRewardedVideo.class);
        }

        public void onVideoComplete() {
            if (MoPubRewardedVideo.this.mo37087e() == null) {
                MoPubLog.log(AdLogEvent.CUSTOM, "No rewarded video was loaded, so no reward is possible");
                return;
            }
            MoPubRewardedVideoManager.onRewardedVideoCompleted(this.f34851a, MoPubRewardedVideo.this.getAdNetworkId(), MoPubReward.success(MoPubRewardedVideo.this.mo37087e(), MoPubRewardedVideo.this.mo37086d()));
        }
    }

    /* access modifiers changed from: protected */
    public String getAdNetworkId() {
        String str = this.f34850d;
        return str != null ? str : "mopub_rewarded_video_id";
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36904b() {
        RewardedVastVideoInterstitial rewardedVastVideoInterstitial = this.f34857e;
        if (rewardedVastVideoInterstitial != null) {
            rewardedVastVideoInterstitial.onInvalidate();
        }
        this.f34857e = null;
        super.mo36904b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36905b(Activity activity, Map<String, Object> localExtras, Map<String, String> serverExtras) throws Exception {
        super.mo36905b(activity, localExtras, serverExtras);
        RewardedVastVideoInterstitial rewardedVastVideoInterstitial = this.f34857e;
        if (rewardedVastVideoInterstitial == null) {
            MoPubLog.log(AdLogEvent.CUSTOM, "mRewardedVastVideoInterstitial is null. Has this class been invalidated?");
            return;
        }
        rewardedVastVideoInterstitial.loadInterstitial(activity, new C11333a(), localExtras, serverExtras);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo36994c() {
        if (!mo36993a() || this.f34857e == null) {
            MoPubLog.log(AdLogEvent.CUSTOM, "Unable to show MoPub rewarded video");
            return;
        }
        MoPubLog.log(AdLogEvent.CUSTOM, "Showing MoPub rewarded video.");
        this.f34857e.showInterstitial();
    }
}
