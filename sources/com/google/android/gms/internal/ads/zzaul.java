package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

@zzard
public final class zzaul extends zzauc {

    /* renamed from: b */
    private final RewardedAdLoadCallback f24826b;

    public zzaul(RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.f24826b = rewardedAdLoadCallback;
    }

    /* renamed from: Ba */
    public final void mo30087Ba() {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.f24826b;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdLoaded();
        }
    }

    /* renamed from: p */
    public final void mo30088p(int i) {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.f24826b;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdFailedToLoad(i);
        }
    }
}
