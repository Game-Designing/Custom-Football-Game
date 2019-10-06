package com.mopub.mobileads;

import android.app.Activity;
import com.mopub.common.MediationSettings;
import com.mopub.common.MoPubReward;
import com.mopub.common.Preconditions;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.util.ReflectionTarget;
import com.mopub.mobileads.MoPubRewardedVideoManager.RequestParameters;
import java.util.Set;

public class MoPubRewardedVideos {
    @ReflectionTarget
    private static void initializeRewardedVideo(Activity activity, MediationSettings... mediationSettings) {
        Preconditions.checkNotNull(activity);
        MoPubRewardedVideoManager.init(activity, mediationSettings);
    }

    @ReflectionTarget
    private static void initializeRewardedVideo(Activity activity, SdkConfiguration sdkConfiguration) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(sdkConfiguration);
        initializeRewardedVideo(activity, sdkConfiguration.getMediationSettings());
    }

    @ReflectionTarget
    public static void setRewardedVideoListener(MoPubRewardedVideoListener listener) {
        MoPubRewardedVideoManager.setVideoListener(listener);
    }

    @ReflectionTarget
    public static void loadRewardedVideo(String adUnitId, MediationSettings... mediationSettings) {
        Preconditions.checkNotNull(adUnitId);
        MoPubRewardedVideoManager.loadVideo(adUnitId, null, mediationSettings);
    }

    @ReflectionTarget
    public static void loadRewardedVideo(String adUnitId, RequestParameters requestParameters, MediationSettings... mediationSettings) {
        Preconditions.checkNotNull(adUnitId);
        MoPubRewardedVideoManager.loadVideo(adUnitId, requestParameters, mediationSettings);
    }

    @ReflectionTarget
    public static boolean hasRewardedVideo(String adUnitId) {
        Preconditions.checkNotNull(adUnitId);
        return MoPubRewardedVideoManager.hasVideo(adUnitId);
    }

    @ReflectionTarget
    public static void showRewardedVideo(String adUnitId) {
        Preconditions.checkNotNull(adUnitId);
        MoPubRewardedVideoManager.showVideo(adUnitId);
    }

    @ReflectionTarget
    public static void showRewardedVideo(String adUnitId, String customData) {
        Preconditions.checkNotNull(adUnitId);
        MoPubRewardedVideoManager.showVideo(adUnitId, customData);
    }

    @ReflectionTarget
    public static Set<MoPubReward> getAvailableRewards(String adUnitId) {
        Preconditions.checkNotNull(adUnitId);
        return MoPubRewardedVideoManager.getAvailableRewards(adUnitId);
    }

    @ReflectionTarget
    public static void selectReward(String adUnitId, MoPubReward selectedReward) {
        Preconditions.checkNotNull(adUnitId);
        Preconditions.checkNotNull(selectedReward);
        MoPubRewardedVideoManager.selectReward(adUnitId, selectedReward);
    }
}
