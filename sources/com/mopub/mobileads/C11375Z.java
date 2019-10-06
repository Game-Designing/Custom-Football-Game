package com.mopub.mobileads;

import com.mopub.common.MoPubReward;

/* renamed from: com.mopub.mobileads.Z */
/* compiled from: MoPubRewardedVideoManager */
class C11375Z implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f35188a;

    /* renamed from: b */
    final /* synthetic */ String f35189b;

    C11375Z(String str, String str2) {
        this.f35188a = str;
        this.f35189b = str2;
    }

    public void run() {
        String rewardName;
        String rewardAmount;
        String className;
        MoPubReward reward = MoPubRewardedVideoManager.f34859a.f34864f.mo37521d(this.f35188a);
        if (reward == null) {
            rewardName = "";
        } else {
            rewardName = reward.getLabel();
        }
        if (reward == null) {
            rewardAmount = Integer.toString(0);
        } else {
            rewardAmount = Integer.toString(reward.getAmount());
        }
        CustomEventRewardedAd customEvent = MoPubRewardedVideoManager.f34859a.f34864f.mo37520c(this.f35188a);
        if (customEvent == null || customEvent.getClass() == null) {
            className = null;
        } else {
            className = customEvent.getClass().getName();
        }
        RewardedVideoCompletionRequestHandler.makeRewardedVideoCompletionRequest(MoPubRewardedVideoManager.f34859a.f34863e, this.f35189b, MoPubRewardedVideoManager.f34859a.f34864f.mo37516b(), rewardName, rewardAmount, className, MoPubRewardedVideoManager.f34859a.f34864f.mo37517b(this.f35188a));
    }
}
