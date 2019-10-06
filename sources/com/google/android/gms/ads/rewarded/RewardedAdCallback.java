package com.google.android.gms.ads.rewarded;

public class RewardedAdCallback {
    public static final int ERROR_CODE_AD_REUSED = 1;
    public static final int ERROR_CODE_APP_NOT_FOREGROUND = 3;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_NOT_READY = 2;

    public void onRewardedAdOpened() {
    }

    public void onRewardedAdClosed() {
    }

    public void onUserEarnedReward(RewardItem rewardItem) {
    }

    public void onRewardedAdFailedToShow(int i) {
    }
}
