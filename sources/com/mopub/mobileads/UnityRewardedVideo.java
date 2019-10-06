package com.mopub.mobileads;

import android.app.Activity;
import com.mopub.common.BaseLifecycleListener;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPubReward;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAds.FinishState;
import com.unity3d.ads.UnityAds.PlacementState;
import com.unity3d.ads.UnityAds.UnityAdsError;
import com.unity3d.ads.mediation.IUnityAdsExtendedListener;
import java.util.Map;

public class UnityRewardedVideo extends CustomEventRewardedVideo {

    /* renamed from: a */
    private static final LifecycleListener f34961a = new C11354b();

    /* renamed from: b */
    private static final C11353a f34962b = new C11353a();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final String f34963c = UnityRewardedVideo.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static String f34964d = "";

    /* renamed from: e */
    private UnityAdsAdapterConfiguration f34965e = new UnityAdsAdapterConfiguration();

    /* renamed from: f */
    private Activity f34966f;

    /* renamed from: com.mopub.mobileads.UnityRewardedVideo$a */
    private static class C11353a implements IUnityAdsExtendedListener, CustomEventRewardedVideoListener {
        private C11353a() {
        }

        public void onUnityAdsReady(String placementId) {
            if (placementId.equals(UnityRewardedVideo.f34964d)) {
                AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("Unity rewarded video cached for placement ");
                sb.append(placementId);
                sb.append(".");
                MoPubLog.log(adapterLogEvent, UnityRewardedVideo.f34963c, sb.toString());
                MoPubRewardedVideoManager.onRewardedVideoLoadSuccess(UnityRewardedVideo.class, placementId);
                MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, UnityRewardedVideo.f34963c);
            }
        }

        public void onUnityAdsStart(String placementId) {
            MoPubRewardedVideoManager.onRewardedVideoStarted(UnityRewardedVideo.class, placementId);
            AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Unity rewarded video started for placement ");
            sb.append(placementId);
            sb.append(".");
            MoPubLog.log(adapterLogEvent, UnityRewardedVideo.f34963c, sb.toString());
            MoPubLog.log(AdapterLogEvent.SHOW_SUCCESS, UnityRewardedVideo.f34963c);
        }

        public void onUnityAdsFinish(String placementId, FinishState finishState) {
            AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Unity Ad finished with finish state = ");
            sb.append(finishState);
            MoPubLog.log(adapterLogEvent, UnityRewardedVideo.f34963c, sb.toString());
            if (finishState == FinishState.ERROR) {
                MoPubRewardedVideoManager.onRewardedVideoPlaybackError(UnityRewardedVideo.class, UnityRewardedVideo.f34964d, MoPubErrorCode.NETWORK_NO_FILL);
                AdapterLogEvent adapterLogEvent2 = AdapterLogEvent.CUSTOM;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unity rewarded video encountered a playback error for placement ");
                sb2.append(placementId);
                MoPubLog.log(adapterLogEvent2, UnityRewardedVideo.f34963c, sb2.toString());
                MoPubLog.log(AdapterLogEvent.SHOW_FAILED, UnityRewardedVideo.f34963c, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
            } else if (finishState == FinishState.COMPLETED) {
                String str = "";
                MoPubLog.log(AdapterLogEvent.SHOULD_REWARD, UnityRewardedVideo.f34963c, Integer.valueOf(MoPubReward.NO_REWARD_AMOUNT), str);
                MoPubRewardedVideoManager.onRewardedVideoCompleted(UnityRewardedVideo.class, UnityRewardedVideo.f34964d, MoPubReward.success(str, MoPubReward.NO_REWARD_AMOUNT));
                AdapterLogEvent adapterLogEvent3 = AdapterLogEvent.CUSTOM;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unity rewarded video completed for placement ");
                sb3.append(placementId);
                MoPubLog.log(adapterLogEvent3, UnityRewardedVideo.f34963c, sb3.toString());
            } else if (finishState == FinishState.SKIPPED) {
                MoPubLog.log(AdapterLogEvent.CUSTOM, UnityRewardedVideo.f34963c, "Unity ad was skipped, no reward will be given.");
            }
            MoPubRewardedVideoManager.onRewardedVideoClosed(UnityRewardedVideo.class, UnityRewardedVideo.f34964d);
            UnityRouter.m37552b().removeListener(placementId);
        }

        public void onUnityAdsClick(String placementId) {
            MoPubRewardedVideoManager.onRewardedVideoClicked(UnityRewardedVideo.class, placementId);
            AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Unity rewarded video clicked for placement ");
            sb.append(placementId);
            sb.append(".");
            MoPubLog.log(adapterLogEvent, UnityRewardedVideo.f34963c, sb.toString());
            MoPubLog.log(AdapterLogEvent.CLICKED, UnityRewardedVideo.f34963c);
        }

        public void onUnityAdsPlacementStateChanged(String placementId, PlacementState oldState, PlacementState newState) {
            if (placementId.equals(UnityRewardedVideo.f34964d) && newState == PlacementState.NO_FILL) {
                MoPubRewardedVideoManager.onRewardedVideoLoadFailure(UnityRewardedVideo.class, UnityRewardedVideo.f34964d, MoPubErrorCode.NETWORK_NO_FILL);
                MoPubLog.log(AdapterLogEvent.LOAD_FAILED, UnityRewardedVideo.f34963c, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
                UnityRouter.m37552b().removeListener(UnityRewardedVideo.f34964d);
            }
        }

        public void onUnityAdsError(UnityAdsError unityAdsError, String message) {
            AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Unity rewarded video cache failed for placement ");
            sb.append(UnityRewardedVideo.f34964d);
            sb.append(".");
            MoPubLog.log(adapterLogEvent, UnityRewardedVideo.f34963c, sb.toString());
            MoPubErrorCode errorCode = C11355a.m37553a(unityAdsError);
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(UnityRewardedVideo.class, UnityRewardedVideo.f34964d, errorCode);
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, UnityRewardedVideo.f34963c, Integer.valueOf(errorCode.getIntCode()), errorCode);
        }
    }

    /* renamed from: com.mopub.mobileads.UnityRewardedVideo$b */
    private static final class C11354b extends BaseLifecycleListener {
        private C11354b() {
        }

        public void onCreate(Activity activity) {
            super.onCreate(activity);
        }

        public void onResume(Activity activity) {
            super.onResume(activity);
        }
    }

    public CustomEventRewardedVideoListener getVideoListenerForSdk() {
        return f34962b;
    }

    public LifecycleListener getLifecycleListener() {
        return f34961a;
    }

    public String getAdNetworkId() {
        return f34964d;
    }

    public boolean checkAndInitializeSdk(Activity launcherActivity, Map<String, Object> map, Map<String, String> serverExtras) throws Exception {
        synchronized (UnityRewardedVideo.class) {
            f34964d = UnityRouter.m37548a(serverExtras, f34964d);
            if (UnityAds.isInitialized()) {
                return false;
            }
            this.f34965e.setCachedInitializationParameters(launcherActivity, serverExtras);
            UnityRouter.m37552b().setCurrentPlacementId(f34964d);
            if (!UnityRouter.m37551a(serverExtras, launcherActivity)) {
                return false;
            }
            UnityRouter.m37552b().addListener(f34964d, f34962b);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36905b(Activity activity, Map<String, Object> map, Map<String, String> serverExtras) throws Exception {
        f34964d = UnityRouter.m37548a(serverExtras, f34964d);
        this.f34966f = activity;
        UnityRouter.m37552b().addListener(f34964d, f34962b);
        if (hasVideoAvailable()) {
            MoPubRewardedVideoManager.onRewardedVideoLoadSuccess(UnityRewardedVideo.class, f34964d);
            MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, f34963c);
        } else if (UnityAds.getPlacementState(f34964d) == PlacementState.NO_FILL) {
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(UnityRewardedVideo.class, f34964d, MoPubErrorCode.NETWORK_NO_FILL);
            UnityRouter.m37552b().removeListener(f34964d);
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f34963c, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
        }
    }

    public boolean hasVideoAvailable() {
        return UnityAds.isReady(f34964d);
    }

    public void showVideo() {
        MoPubLog.log(AdapterLogEvent.SHOW_ATTEMPTED, f34963c);
        if (hasVideoAvailable()) {
            UnityAds.show(this.f34966f, f34964d);
            return;
        }
        MoPubLog.log(AdapterLogEvent.CUSTOM, f34963c, "Attempted to show Unity rewarded video before it was available.");
        MoPubLog.log(AdapterLogEvent.SHOW_FAILED, f34963c, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36904b() {
        UnityRouter.m37552b().removeListener(f34964d);
    }
}
