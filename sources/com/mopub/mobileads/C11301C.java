package com.mopub.mobileads;

import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;

/* renamed from: com.mopub.mobileads.C */
/* compiled from: GooglePlayServicesRewardedVideo */
class C11301C extends RewardedAdLoadCallback {

    /* renamed from: a */
    final /* synthetic */ GooglePlayServicesRewardedVideo f34707a;

    C11301C(GooglePlayServicesRewardedVideo this$0) {
        this.f34707a = this$0;
    }

    public void onRewardedAdLoaded() {
        this.f34707a.f34770e = true;
        MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, GooglePlayServicesRewardedVideo.f34766a);
        MoPubRewardedVideoManager.onRewardedVideoLoadSuccess(GooglePlayServicesRewardedVideo.class, this.f34707a.getAdNetworkId());
    }

    public void onRewardedAdFailedToLoad(int error) {
        MoPubLog.log(AdapterLogEvent.LOAD_FAILED, GooglePlayServicesRewardedVideo.f34766a, Integer.valueOf(this.f34707a.m37379a(error).getIntCode()), this.f34707a.m37379a(error));
        MoPubRewardedVideoManager.onRewardedVideoLoadFailure(GooglePlayServicesRewardedVideo.class, this.f34707a.getAdNetworkId(), this.f34707a.m37379a(error));
    }
}
