package com.mopub.mobileads;

import android.app.Activity;
import android.text.TextUtils;
import com.mopub.common.DataKeys;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MediationSettings;
import com.mopub.common.MoPubReward;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.vungle.warren.AdConfig;
import java.util.Map;

public class VungleRewardedVideo extends CustomEventRewardedVideo {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f35134a = VungleRewardedVideo.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static VungleRouter f35135b;

    /* renamed from: c */
    private static boolean f35136c;

    /* renamed from: d */
    private C11364a f35137d;

    /* renamed from: e */
    private VungleAdapterConfiguration f35138e;

    /* renamed from: f */
    private String f35139f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f35140g = "vngl_id";
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f35141h;

    /* renamed from: i */
    private String f35142i;

    /* renamed from: j */
    private String f35143j;

    public static class VungleMediationSettings implements MediationSettings {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final String f35144a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final String f35145b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final String f35146c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final String f35147d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public final String f35148e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public final boolean f35149f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public final int f35150g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public final int f35151h;

        public static class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a */
            public String f35152a;
            /* access modifiers changed from: private */

            /* renamed from: b */
            public String f35153b;
            /* access modifiers changed from: private */

            /* renamed from: c */
            public String f35154c;
            /* access modifiers changed from: private */

            /* renamed from: d */
            public String f35155d;
            /* access modifiers changed from: private */

            /* renamed from: e */
            public String f35156e;
            /* access modifiers changed from: private */

            /* renamed from: f */
            public boolean f35157f = true;
            /* access modifiers changed from: private */

            /* renamed from: g */
            public int f35158g = 0;
            /* access modifiers changed from: private */

            /* renamed from: h */
            public int f35159h = 0;

            public Builder withUserId(String userId) {
                this.f35152a = userId;
                return this;
            }

            public Builder withCancelDialogTitle(String title) {
                this.f35153b = title;
                return this;
            }

            public Builder withCancelDialogBody(String body) {
                this.f35154c = body;
                return this;
            }

            public Builder withCancelDialogCloseButton(String buttonText) {
                this.f35155d = buttonText;
                return this;
            }

            public Builder withCancelDialogKeepWatchingButton(String buttonText) {
                this.f35156e = buttonText;
                return this;
            }

            public Builder withSoundEnabled(boolean isSoundEnabled) {
                this.f35157f = isSoundEnabled;
                return this;
            }

            public Builder withFlexViewCloseTimeInSec(int flexViewCloseTimeInSec) {
                this.f35158g = flexViewCloseTimeInSec;
                return this;
            }

            public Builder withOrdinalViewCount(int ordinalViewCount) {
                this.f35159h = ordinalViewCount;
                return this;
            }

            public VungleMediationSettings build() {
                return new VungleMediationSettings(this);
            }
        }

        private VungleMediationSettings(Builder builder) {
            this.f35144a = builder.f35152a;
            this.f35145b = builder.f35153b;
            this.f35146c = builder.f35154c;
            this.f35147d = builder.f35155d;
            this.f35148e = builder.f35156e;
            this.f35149f = builder.f35157f;
            this.f35150g = builder.f35158g;
            this.f35151h = builder.f35159h;
        }
    }

    /* renamed from: com.mopub.mobileads.VungleRewardedVideo$a */
    private class C11364a implements VungleRouterListener {
        private C11364a() {
        }

        public void onAdEnd(String placementReferenceId, boolean wasSuccessfulView, boolean wasCallToActionClicked) {
            if (VungleRewardedVideo.this.f35140g.equals(placementReferenceId)) {
                AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("onAdEnd - Placement ID: ");
                sb.append(placementReferenceId);
                sb.append(", wasSuccessfulView: ");
                sb.append(wasSuccessfulView);
                sb.append(", wasCallToActionClicked: ");
                sb.append(wasCallToActionClicked);
                MoPubLog.log(adapterLogEvent, VungleRewardedVideo.f35134a, sb.toString());
                VungleRewardedVideo.this.f35141h = false;
                if (wasSuccessfulView) {
                    String str = "";
                    MoPubLog.log(AdapterLogEvent.SHOULD_REWARD, VungleRewardedVideo.f35134a, Integer.valueOf(MoPubReward.NO_REWARD_AMOUNT), str);
                    MoPubRewardedVideoManager.onRewardedVideoCompleted(VungleRewardedVideo.class, VungleRewardedVideo.this.f35140g, MoPubReward.success(str, MoPubReward.NO_REWARD_AMOUNT));
                }
                if (wasCallToActionClicked) {
                    MoPubRewardedVideoManager.onRewardedVideoClicked(VungleRewardedVideo.class, VungleRewardedVideo.this.f35140g);
                    MoPubLog.log(AdapterLogEvent.CLICKED, VungleRewardedVideo.f35134a);
                }
                MoPubRewardedVideoManager.onRewardedVideoClosed(VungleRewardedVideo.class, VungleRewardedVideo.this.f35140g);
                VungleRewardedVideo.f35135b.removeRouterListener(VungleRewardedVideo.this.f35140g);
            }
        }

        public void onAdStart(String placementReferenceId) {
            if (VungleRewardedVideo.this.f35140g.equals(placementReferenceId)) {
                AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("onAdStart - Placement ID: ");
                sb.append(placementReferenceId);
                MoPubLog.log(adapterLogEvent, VungleRewardedVideo.f35134a, sb.toString());
                VungleRewardedVideo.this.f35141h = true;
                MoPubRewardedVideoManager.onRewardedVideoStarted(VungleRewardedVideo.class, VungleRewardedVideo.this.f35140g);
                MoPubLog.log(AdapterLogEvent.SHOW_SUCCESS, VungleRewardedVideo.f35134a);
            }
        }

        public void onUnableToPlayAd(String placementReferenceId, String reason) {
            if (VungleRewardedVideo.this.f35140g.equals(placementReferenceId)) {
                AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("onUnableToPlayAd - Placement ID: ");
                sb.append(placementReferenceId);
                sb.append(", reason: ");
                sb.append(reason);
                MoPubLog.log(adapterLogEvent, VungleRewardedVideo.f35134a, sb.toString());
                VungleRewardedVideo.this.f35141h = false;
                MoPubRewardedVideoManager.onRewardedVideoLoadFailure(VungleRewardedVideo.class, VungleRewardedVideo.this.f35140g, MoPubErrorCode.NETWORK_NO_FILL);
                MoPubLog.log(AdapterLogEvent.LOAD_FAILED, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
            }
        }

        public void onAdAvailabilityUpdate(String placementReferenceId, boolean isAdAvailable) {
            if (VungleRewardedVideo.this.f35140g.equals(placementReferenceId) && !VungleRewardedVideo.this.f35141h) {
                if (isAdAvailable) {
                    AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
                    StringBuilder sb = new StringBuilder();
                    sb.append("rewarded video ad successfully loaded - Placement ID: ");
                    sb.append(placementReferenceId);
                    MoPubLog.log(adapterLogEvent, VungleRewardedVideo.f35134a, sb.toString());
                    MoPubRewardedVideoManager.onRewardedVideoLoadSuccess(VungleRewardedVideo.class, VungleRewardedVideo.this.f35140g);
                    MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, VungleRewardedVideo.f35134a);
                    return;
                }
                AdapterLogEvent adapterLogEvent2 = AdapterLogEvent.CUSTOM;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("rewarded video ad is not loaded - Placement ID: ");
                sb2.append(placementReferenceId);
                MoPubLog.log(adapterLogEvent2, VungleRewardedVideo.f35134a, sb2.toString());
                MoPubRewardedVideoManager.onRewardedVideoLoadFailure(VungleRewardedVideo.class, VungleRewardedVideo.this.f35140g, MoPubErrorCode.NETWORK_NO_FILL);
                MoPubLog.log(AdapterLogEvent.LOAD_FAILED, VungleRewardedVideo.f35134a, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
            }
        }
    }

    public VungleRewardedVideo() {
        f35135b = VungleRouter.getInstance();
        if (this.f35137d == null) {
            this.f35137d = new C11364a();
        }
        this.f35138e = new VungleAdapterConfiguration();
    }

    public LifecycleListener getLifecycleListener() {
        return f35135b.getLifecycleListener();
    }

    /* access modifiers changed from: protected */
    public String getAdNetworkId() {
        return this.f35140g;
    }

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity launcherActivity, Map<String, Object> map, Map<String, String> serverExtras) throws Exception {
        synchronized (VungleRewardedVideo.class) {
            if (f35136c) {
                return false;
            }
            if (!m37705a(serverExtras)) {
                this.f35139f = "YOUR_APP_ID_HERE";
            }
            if (!f35135b.isVungleInitialized()) {
                f35135b.initVungle(launcherActivity, this.f35139f);
                this.f35138e.setCachedInitializationParameters(launcherActivity, serverExtras);
            }
            f35136c = true;
            return true;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36905b(Activity activity, Map<String, Object> localExtras, Map<String, String> serverExtras) throws Exception {
        this.f35141h = false;
        if (!m37705a(serverExtras)) {
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(VungleRewardedVideo.class, this.f35140g, MoPubErrorCode.NETWORK_NO_FILL);
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f35134a, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
            return;
        }
        Object adUnitObject = localExtras.get(DataKeys.AD_UNIT_ID_KEY);
        if (adUnitObject instanceof String) {
            this.f35142i = (String) adUnitObject;
        }
        Object customerIdObject = localExtras.get("rewarded-ad-customer-id");
        if ((customerIdObject instanceof String) && !TextUtils.isEmpty((String) customerIdObject)) {
            this.f35143j = (String) customerIdObject;
        }
        if (f35135b.isVungleInitialized()) {
            if (f35135b.isValidPlacement(this.f35140g)) {
                f35135b.loadAdForPlacement(this.f35140g, this.f35137d);
            } else {
                AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                String str = "Invalid or Inactive Placement ID: ";
                sb.append(str);
                sb.append(this.f35140g);
                MoPubLog.log(adapterLogEvent, sb.toString());
                AdapterLogEvent adapterLogEvent2 = AdapterLogEvent.CUSTOM;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(this.f35140g);
                MoPubLog.log(adapterLogEvent2, f35134a, sb2.toString());
                MoPubRewardedVideoManager.onRewardedVideoLoadFailure(VungleRewardedVideo.class, this.f35140g, MoPubErrorCode.NETWORK_NO_FILL);
                MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f35134a, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
            }
            MoPubLog.log(getAdNetworkId(), AdapterLogEvent.LOAD_ATTEMPTED, f35134a);
        } else {
            AdapterLogEvent adapterLogEvent3 = AdapterLogEvent.CUSTOM;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("There should not be this case. loadWithSdkInitialized is called before the SDK starts initialization for Placement ID: ");
            sb3.append(this.f35140g);
            MoPubLog.log(adapterLogEvent3, f35134a, sb3.toString());
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(VungleRewardedVideo.class, this.f35140g, MoPubErrorCode.NETWORK_NO_FILL);
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f35134a, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
        }
    }

    /* access modifiers changed from: protected */
    public boolean hasVideoAvailable() {
        return f35135b.isAdPlayableForPlacement(this.f35140g);
    }

    /* access modifiers changed from: protected */
    public void showVideo() {
        MoPubLog.log(AdapterLogEvent.SHOW_ATTEMPTED, f35134a);
        AdConfig adConfig = new AdConfig();
        m37701a(adConfig);
        f35135b.playAdForPlacement(this.f35140g, adConfig);
        this.f35141h = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36904b() {
        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("onInvalidate is called for Placement ID:");
        sb.append(this.f35140g);
        MoPubLog.log(adapterLogEvent, f35134a, sb.toString());
        f35135b.removeRouterListener(this.f35140g);
        this.f35137d = null;
    }

    /* renamed from: a */
    private boolean m37705a(Map<String, String> serverExtras) {
        boolean isAllDataValid = true;
        String str = "appId";
        if (serverExtras.containsKey(str)) {
            this.f35139f = (String) serverExtras.get(str);
            String str2 = this.f35139f;
            if (str2 != null && str2.isEmpty()) {
                MoPubLog.log(AdapterLogEvent.CUSTOM, f35134a, "App ID is empty.");
                isAllDataValid = false;
            }
        } else {
            MoPubLog.log(AdapterLogEvent.CUSTOM, f35134a, "AppID is not in serverExtras.");
            isAllDataValid = false;
        }
        String str3 = "pid";
        if (serverExtras.containsKey(str3)) {
            this.f35140g = (String) serverExtras.get(str3);
            String str4 = this.f35140g;
            if (str4 == null || !str4.isEmpty()) {
                return isAllDataValid;
            }
            MoPubLog.log(AdapterLogEvent.CUSTOM, f35134a, "Placement ID for this Ad Unit is empty.");
            return false;
        }
        MoPubLog.log(AdapterLogEvent.CUSTOM, f35134a, "Placement ID for this Ad Unit is not in serverExtras.");
        return false;
    }

    /* renamed from: a */
    private void m37701a(AdConfig adConfig) {
        VungleMediationSettings globalMediationSettings = (VungleMediationSettings) MoPubRewardedVideoManager.getGlobalMediationSettings(VungleMediationSettings.class);
        VungleMediationSettings instanceMediationSettings = (VungleMediationSettings) MoPubRewardedVideoManager.getInstanceMediationSettings(VungleMediationSettings.class, this.f35142i);
        if (instanceMediationSettings != null) {
            m37702a(adConfig, instanceMediationSettings);
        } else if (globalMediationSettings != null) {
            m37702a(adConfig, globalMediationSettings);
        }
    }

    /* renamed from: a */
    private void m37702a(AdConfig adConfig, VungleMediationSettings mediationSettings) {
        String userId = null;
        if (!TextUtils.isEmpty(this.f35143j)) {
            userId = this.f35143j;
        } else if (!TextUtils.isEmpty(mediationSettings.f35144a)) {
            userId = mediationSettings.f35144a;
        }
        f35135b.setIncentivizedFields(userId, mediationSettings.f35145b, mediationSettings.f35146c, mediationSettings.f35148e, mediationSettings.f35147d);
        adConfig.setMuted(!mediationSettings.f35149f);
        adConfig.setFlexViewCloseTime(mediationSettings.f35150g);
        adConfig.setOrdinal(mediationSettings.f35151h);
    }
}
