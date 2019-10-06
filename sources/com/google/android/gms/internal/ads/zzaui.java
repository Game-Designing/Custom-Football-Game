package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdCallback;

@zzard
public final class zzaui extends zzatx {

    /* renamed from: b */
    private final RewardedAdCallback f24825b;

    public zzaui(RewardedAdCallback rewardedAdCallback) {
        this.f24825b = rewardedAdCallback;
    }

    /* renamed from: T */
    public final void mo30083T() {
        RewardedAdCallback rewardedAdCallback = this.f24825b;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdOpened();
        }
    }

    /* renamed from: Q */
    public final void mo30082Q() {
        RewardedAdCallback rewardedAdCallback = this.f24825b;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdClosed();
        }
    }

    /* renamed from: a */
    public final void mo30084a(zzatq zzatq) {
        RewardedAdCallback rewardedAdCallback = this.f24825b;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onUserEarnedReward(new zzauh(zzatq));
        }
    }

    /* renamed from: q */
    public final void mo30085q(int i) {
        RewardedAdCallback rewardedAdCallback = this.f24825b;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(i);
        }
    }
}
