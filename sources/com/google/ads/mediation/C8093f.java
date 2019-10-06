package com.google.ads.mediation;

import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/* renamed from: com.google.ads.mediation.f */
final class C8093f implements RewardedVideoAdListener {

    /* renamed from: a */
    private final /* synthetic */ AbstractAdViewAdapter f16468a;

    C8093f(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.f16468a = abstractAdViewAdapter;
    }

    public final void onRewardedVideoAdLoaded() {
        this.f16468a.zzmi.onAdLoaded(this.f16468a);
    }

    public final void onRewardedVideoAdOpened() {
        this.f16468a.zzmi.onAdOpened(this.f16468a);
    }

    public final void onRewardedVideoStarted() {
        this.f16468a.zzmi.onVideoStarted(this.f16468a);
    }

    public final void onRewardedVideoAdClosed() {
        this.f16468a.zzmi.onAdClosed(this.f16468a);
        this.f16468a.zzmh = null;
    }

    public final void onRewarded(RewardItem rewardItem) {
        this.f16468a.zzmi.onRewarded(this.f16468a, rewardItem);
    }

    public final void onRewardedVideoAdLeftApplication() {
        this.f16468a.zzmi.onAdLeftApplication(this.f16468a);
    }

    public final void onRewardedVideoAdFailedToLoad(int i) {
        this.f16468a.zzmi.onAdFailedToLoad(this.f16468a, i);
    }

    public final void onRewardedVideoCompleted() {
        this.f16468a.zzmi.onVideoCompleted(this.f16468a);
    }
}
