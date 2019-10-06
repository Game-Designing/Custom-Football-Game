package com.mopub.mobileads;

import android.app.Activity;
import android.text.TextUtils;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPub;
import com.mopub.common.MoPubReward;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import java.util.Map;
import p005cm.aptoide.p006pt.BuildConfig;
import p019d.p273h.p276c.C12741D;
import p019d.p273h.p276c.C12741D.C12742a;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p281e.C12820l;
import p019d.p273h.p276c.p282f.C12874h;

public class IronSourceRewardedVideo extends CustomEventRewardedVideo implements C12874h {

    /* renamed from: a */
    private static final String f34805a = IronSourceRewardedVideo.class.getSimpleName();

    /* renamed from: b */
    private static boolean f34806b = true;

    /* renamed from: c */
    private String f34807c = BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;

    /* renamed from: d */
    private String f34808d = null;

    /* renamed from: e */
    private IronSourceAdapterConfiguration f34809e = new IronSourceAdapterConfiguration();

    /* renamed from: f */
    private LifecycleListener f34810f = new C11335N(this);

    /* access modifiers changed from: protected */
    public LifecycleListener getLifecycleListener() {
        return this.f34810f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36904b() {
    }

    /* access modifiers changed from: protected */
    public String getAdNetworkId() {
        return this.f34807c;
    }

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity launcherActivity, Map<String, Object> map, Map<String, String> serverExtras) throws Exception {
        String str = "applicationKey";
        C12741D.m41157a(MoPub.canCollectPersonalInformation());
        String applicationKey = "";
        try {
            if (serverExtras.get(str) != null) {
                applicationKey = (String) serverExtras.get(str);
            }
            m37414a(serverExtras);
            m37413a(launcherActivity, applicationKey);
            return f34806b;
        } catch (Exception e) {
            MoPubLog.log(AdapterLogEvent.CUSTOM_WITH_THROWABLE, e);
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(IronSourceRewardedVideo.class, this.f34807c, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36905b(Activity activity, Map<String, Object> map, Map<String, String> serverExtras) throws Exception {
        m37414a(serverExtras);
        this.f34809e.setCachedInitializationParameters(activity, serverExtras);
        if (f34806b) {
            return;
        }
        if (hasVideoAvailable()) {
            MoPubRewardedVideoManager.onRewardedVideoLoadSuccess(IronSourceRewardedVideo.class, this.f34807c);
            MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, f34805a);
            AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("IronSource Rewarded Video loaded successfully for instance ");
            sb.append(this.f34807c);
            MoPubLog.log(adapterLogEvent, f34805a, sb.toString());
            return;
        }
        MoPubRewardedVideoManager.onRewardedVideoLoadFailure(IronSourceRewardedVideo.class, this.f34807c, MoPubErrorCode.NETWORK_NO_FILL);
        MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f34805a, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
        AdapterLogEvent adapterLogEvent2 = AdapterLogEvent.CUSTOM;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("IronSource Rewarded Video failed to load for instance ");
        sb2.append(this.f34807c);
        MoPubLog.log(adapterLogEvent2, f34805a, sb2.toString());
    }

    /* access modifiers changed from: protected */
    public boolean hasVideoAvailable() {
        return C12741D.m41162b(this.f34807c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo36993a() {
        return C12741D.m41162b(this.f34807c);
    }

    /* access modifiers changed from: protected */
    public void showVideo() {
        MoPubLog.log(AdapterLogEvent.SHOW_ATTEMPTED, f34805a);
        if (TextUtils.isEmpty(this.f34808d)) {
            C12741D.m41166f(this.f34807c);
        } else {
            C12741D.m41161b(this.f34807c, this.f34808d);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo36994c() {
        if (TextUtils.isEmpty(this.f34808d)) {
            C12741D.m41166f(this.f34807c);
        } else {
            C12741D.m41161b(this.f34807c, this.f34808d);
        }
    }

    /* renamed from: a */
    private void m37413a(Activity activity, String appKey) {
        if (!TextUtils.isEmpty(appKey)) {
            C12741D.m41155a((C12874h) this);
            if (f34806b) {
                MoPubLog.log(AdapterLogEvent.CUSTOM, f34805a, "IronSource initialization succeeded for RewardedVideo");
                C12741D.m41164d("mopub300");
                C12741D.m41160b(activity, appKey, C12742a.REWARDED_VIDEO);
                MoPubLog.log(getAdNetworkId(), AdapterLogEvent.LOAD_ATTEMPTED, f34805a);
                return;
            }
            return;
        }
        MoPubLog.log(AdapterLogEvent.CUSTOM, f34805a, "IronSource initialization Failed, make sure that 'applicationKey' server parameter is added");
        MoPubRewardedVideoManager.onRewardedVideoLoadFailure(IronSourceRewardedVideo.class, this.f34807c, MoPubErrorCode.NETWORK_NO_FILL);
        MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f34805a, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
    }

    /* renamed from: a */
    private void m37414a(Map<String, String> serverExtras) {
        String str = "placementName";
        if (serverExtras.get(str) != null) {
            this.f34808d = (String) serverExtras.get(str);
        }
        String str2 = "instanceId";
        if (serverExtras.get(str2) != null && !TextUtils.isEmpty((CharSequence) serverExtras.get(str2))) {
            this.f34807c = (String) serverExtras.get(str2);
        }
    }

    /* renamed from: a */
    private MoPubErrorCode m37412a(C12799b ironSourceError) {
        if (ironSourceError == null) {
            return MoPubErrorCode.INTERNAL_ERROR;
        }
        int a = ironSourceError.mo41428a();
        if (a != 501) {
            if (a == 502) {
                return MoPubErrorCode.VIDEO_CACHE_ERROR;
            }
            if (!(a == 505 || a == 506)) {
                if (a == 520) {
                    return MoPubErrorCode.NO_CONNECTION;
                }
                switch (a) {
                    case 508:
                        break;
                    case 509:
                        return MoPubErrorCode.NETWORK_NO_FILL;
                    case 510:
                        return MoPubErrorCode.INTERNAL_ERROR;
                    default:
                        return MoPubErrorCode.UNSPECIFIED;
                }
            }
        }
        return MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
    }

    public void onRewardedVideoAvailabilityChanged(String instanceId, boolean available) {
        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("IronSource Rewarded Video changed availability: ");
        sb.append(available);
        sb.append(" for instance ");
        sb.append(this.f34807c);
        MoPubLog.log(adapterLogEvent, f34805a, sb.toString());
        if (this.f34807c.equals(instanceId) && f34806b) {
            if (available) {
                MoPubRewardedVideoManager.onRewardedVideoLoadSuccess(IronSourceRewardedVideo.class, this.f34807c);
                MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, f34805a);
                AdapterLogEvent adapterLogEvent2 = AdapterLogEvent.CUSTOM;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("IronSource Rewarded Video loaded successfully for instance ");
                sb2.append(this.f34807c);
                MoPubLog.log(adapterLogEvent2, f34805a, sb2.toString());
            } else {
                MoPubRewardedVideoManager.onRewardedVideoLoadFailure(IronSourceRewardedVideo.class, this.f34807c, MoPubErrorCode.NETWORK_NO_FILL);
                MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f34805a, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
                AdapterLogEvent adapterLogEvent3 = AdapterLogEvent.CUSTOM;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("IronSource Rewarded Video failed to load for instance ");
                sb3.append(this.f34807c);
                MoPubLog.log(adapterLogEvent3, f34805a, sb3.toString());
            }
            f34806b = false;
        }
    }

    public void onRewardedVideoAdOpened(String instanceId) {
        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("IronSource Rewarded Video opened ad for instance ");
        sb.append(instanceId);
        MoPubLog.log(adapterLogEvent, f34805a, sb.toString());
        MoPubRewardedVideoManager.onRewardedVideoStarted(IronSourceRewardedVideo.class, instanceId);
        MoPubLog.log(AdapterLogEvent.SHOW_SUCCESS, f34805a);
    }

    public void onRewardedVideoAdClosed(String instanceId) {
        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("IronSource Rewarded Video closed ad for instance ");
        sb.append(instanceId);
        MoPubLog.log(adapterLogEvent, f34805a, sb.toString());
        MoPubRewardedVideoManager.onRewardedVideoClosed(IronSourceRewardedVideo.class, instanceId);
    }

    public void onRewardedVideoAdRewarded(String instanceId, C12820l placement) {
        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("IronSource Rewarded Video received reward for instance ");
        sb.append(instanceId);
        MoPubLog.log(adapterLogEvent, f34805a, sb.toString());
        if (placement != null) {
            MoPubLog.log(AdapterLogEvent.SHOULD_REWARD, f34805a, Integer.valueOf(placement.mo41505d()), placement.mo41506e());
            MoPubRewardedVideoManager.onRewardedVideoCompleted(IronSourceRewardedVideo.class, instanceId, MoPubReward.success(placement.mo41506e(), placement.mo41505d()));
        }
    }

    public void onRewardedVideoAdShowFailed(String instanceId, C12799b ironSourceError) {
        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("IronSource Rewarded Video failed to show for instance ");
        sb.append(instanceId);
        MoPubLog.log(adapterLogEvent, f34805a, sb.toString());
        MoPubRewardedVideoManager.onRewardedVideoPlaybackError(IronSourceRewardedVideo.class, instanceId, m37412a(ironSourceError));
        MoPubLog.log(AdapterLogEvent.SHOW_FAILED, f34805a, Integer.valueOf(m37412a(ironSourceError).getIntCode()), m37412a(ironSourceError));
    }

    public void onRewardedVideoAdClicked(String instanceId, C12820l placement) {
        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("IronSource Rewarded Video clicked for instance ");
        sb.append(instanceId);
        MoPubLog.log(adapterLogEvent, f34805a, sb.toString());
        MoPubRewardedVideoManager.onRewardedVideoClicked(IronSourceRewardedVideo.class, instanceId);
        MoPubLog.log(AdapterLogEvent.CLICKED, f34805a);
    }
}
