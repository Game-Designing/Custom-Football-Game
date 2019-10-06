package com.mopub.mobileads;

import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.mopub.common.MoPubReward;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;

/* renamed from: com.mopub.mobileads.D */
/* compiled from: GooglePlayServicesRewardedVideo */
class C11304D extends RewardedAdCallback {

    /* renamed from: a */
    final /* synthetic */ GooglePlayServicesRewardedVideo f34740a;

    C11304D(GooglePlayServicesRewardedVideo this$0) {
        this.f34740a = this$0;
    }

    public void onRewardedAdOpened() {
        MoPubLog.log(AdapterLogEvent.SHOW_SUCCESS, GooglePlayServicesRewardedVideo.f34766a);
        MoPubRewardedVideoManager.onRewardedVideoStarted(GooglePlayServicesRewardedVideo.class, this.f34740a.getAdNetworkId());
    }

    public void onRewardedAdClosed() {
        MoPubLog.log(AdapterLogEvent.DID_DISAPPEAR, GooglePlayServicesRewardedVideo.f34766a);
        MoPubRewardedVideoManager.onRewardedVideoClosed(GooglePlayServicesRewardedVideo.class, this.f34740a.getAdNetworkId());
    }

    public void onUserEarnedReward(RewardItem rewardItem) {
        MoPubLog.log(AdapterLogEvent.SHOULD_REWARD, GooglePlayServicesRewardedVideo.f34766a, Integer.valueOf(rewardItem.getAmount()), rewardItem.getType());
        MoPubRewardedVideoManager.onRewardedVideoCompleted(GooglePlayServicesRewardedVideo.class, this.f34740a.getAdNetworkId(), MoPubReward.success(rewardItem.getType(), rewardItem.getAmount()));
    }

    public void onRewardedAdFailedToShow(int error) {
        MoPubLog.log(AdapterLogEvent.SHOW_FAILED, GooglePlayServicesRewardedVideo.f34766a);
        MoPubRewardedVideoManager.onRewardedVideoPlaybackError(GooglePlayServicesRewardedVideo.class, this.f34740a.getAdNetworkId(), this.f34740a.m37383b(error));
    }
}
