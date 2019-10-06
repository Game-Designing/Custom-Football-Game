package com.mopub.mobileads;

import android.app.Activity;
import com.mopub.common.MoPubReward;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.mraid.RewardedMraidInterstitial;
import com.mopub.mraid.RewardedMraidInterstitial.RewardedMraidInterstitialListener;
import java.util.Map;

public class MoPubRewardedPlayable extends MoPubRewardedAd {

    /* renamed from: e */
    private RewardedMraidInterstitial f34855e = new RewardedMraidInterstitial();

    /* renamed from: com.mopub.mobileads.MoPubRewardedPlayable$a */
    private class C11332a extends MoPubRewardedAdListener implements RewardedMraidInterstitialListener {
        public C11332a() {
            super(MoPubRewardedPlayable.class);
        }

        public void onMraidComplete() {
            if (MoPubRewardedPlayable.this.mo37087e() == null) {
                MoPubLog.log(AdLogEvent.CUSTOM, "No rewarded video was loaded, so no reward is possible");
                return;
            }
            MoPubRewardedVideoManager.onRewardedVideoCompleted(this.f34851a, MoPubRewardedPlayable.this.getAdNetworkId(), MoPubReward.success(MoPubRewardedPlayable.this.mo37087e(), MoPubRewardedPlayable.this.mo37086d()));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36905b(Activity activity, Map<String, Object> localExtras, Map<String, String> serverExtras) throws Exception {
        super.mo36905b(activity, localExtras, serverExtras);
        RewardedMraidInterstitial rewardedMraidInterstitial = this.f34855e;
        if (rewardedMraidInterstitial == null) {
            MoPubLog.log(AdLogEvent.CUSTOM, "mRewardedMraidInterstitial is null. Has this class been invalidated?");
            return;
        }
        rewardedMraidInterstitial.loadInterstitial(activity, new C11332a(), localExtras, serverExtras);
    }

    /* access modifiers changed from: protected */
    public String getAdNetworkId() {
        String str = this.f34850d;
        return str != null ? str : "mopub_rewarded_playable_id";
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36904b() {
        RewardedMraidInterstitial rewardedMraidInterstitial = this.f34855e;
        if (rewardedMraidInterstitial != null) {
            rewardedMraidInterstitial.onInvalidate();
        }
        this.f34855e = null;
        super.mo36904b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo36994c() {
        if (!mo36993a() || this.f34855e == null) {
            MoPubLog.log(AdLogEvent.CUSTOM, "MoPub rewarded playable not loaded. Unable to show playable.");
            return;
        }
        MoPubLog.log(AdLogEvent.CUSTOM, "Showing MoPub rewarded playable.");
        this.f34855e.showInterstitial();
    }
}
