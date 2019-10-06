package com.mopub.mobileads;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MediationSettings;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class GooglePlayServicesRewardedVideo extends CustomEventRewardedVideo {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f34766a = GooglePlayServicesRewardedVideo.class.getSimpleName();

    /* renamed from: b */
    private static AtomicBoolean f34767b;

    /* renamed from: c */
    private String f34768c = "";

    /* renamed from: d */
    private RewardedAd f34769d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f34770e;

    /* renamed from: f */
    private WeakReference<Activity> f34771f;

    /* renamed from: g */
    private GooglePlayServicesAdapterConfiguration f34772g;

    /* renamed from: h */
    private RewardedAdLoadCallback f34773h = new C11301C(this);

    /* renamed from: i */
    private RewardedAdCallback f34774i = new C11304D(this);

    public static final class GooglePlayServicesMediationSettings implements MediationSettings {

        /* renamed from: a */
        private static String f34775a;

        /* renamed from: b */
        private static String f34776b;

        /* renamed from: c */
        private static String f34777c;

        /* renamed from: d */
        private static Boolean f34778d;

        /* renamed from: e */
        private static Boolean f34779e;

        public GooglePlayServicesMediationSettings(Bundle bundle) {
            String str = "contentUrl";
            if (bundle.containsKey(str)) {
                f34776b = bundle.getString(str);
            }
            String str2 = "testDevices";
            if (bundle.containsKey(str2)) {
                f34777c = bundle.getString(str2);
            }
            String str3 = "npa";
            if (bundle.containsKey(str3)) {
                f34775a = bundle.getString(str3);
            }
            String str4 = "tagForChildDirectedTreatment";
            if (bundle.containsKey(str4)) {
                f34778d = Boolean.valueOf(bundle.getBoolean(str4));
            }
            String str5 = "tagForUnderAgeOfConsent";
            if (bundle.containsKey(str5)) {
                f34779e = Boolean.valueOf(bundle.getBoolean(str5));
            }
        }

        public void setNpaValue(String npa) {
            f34775a = npa;
        }

        public void setContentUrl(String url) {
            f34776b = url;
        }

        public void setTestDeviceId(String id) {
            f34777c = id;
        }

        public void setTaggedForChildDirectedTreatment(boolean flag) {
            f34778d = Boolean.valueOf(flag);
        }

        public void setTaggedForUnderAgeOfConsent(boolean flag) {
            f34779e = Boolean.valueOf(flag);
        }

        /* access modifiers changed from: private */
        /* renamed from: g */
        public static String m37394g() {
            return f34775a;
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public static String m37393f() {
            return f34776b;
        }

        /* access modifiers changed from: private */
        /* renamed from: h */
        public static String m37395h() {
            return f34777c;
        }

        /* access modifiers changed from: private */
        /* renamed from: i */
        public static Boolean m37396i() {
            return f34778d;
        }

        /* access modifiers changed from: private */
        /* renamed from: j */
        public static Boolean m37397j() {
            return f34779e;
        }
    }

    public GooglePlayServicesRewardedVideo() {
        f34767b = new AtomicBoolean(false);
        this.f34772g = new GooglePlayServicesAdapterConfiguration();
    }

    /* access modifiers changed from: protected */
    public LifecycleListener getLifecycleListener() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getAdNetworkId() {
        return this.f34768c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36904b() {
        if (this.f34769d != null) {
            this.f34769d = null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity launcherActivity, Map<String, Object> map, Map<String, String> serverExtras) throws Exception {
        if (f34767b.getAndSet(true)) {
            return false;
        }
        String str = "appid";
        if (TextUtils.isEmpty((CharSequence) serverExtras.get(str))) {
            MobileAds.initialize(launcherActivity);
        } else {
            MobileAds.initialize(launcherActivity, (String) serverExtras.get(str));
        }
        this.f34768c = (String) serverExtras.get("adunit");
        if (TextUtils.isEmpty(this.f34768c)) {
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f34766a, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(GooglePlayServicesRewardedVideo.class, getAdNetworkId(), MoPubErrorCode.NETWORK_NO_FILL);
            return false;
        }
        this.f34772g.setCachedInitializationParameters(launcherActivity, serverExtras);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36905b(Activity activity, Map<String, Object> map, Map<String, String> serverExtras) throws Exception {
        this.f34768c = (String) serverExtras.get("adunit");
        if (TextUtils.isEmpty(this.f34768c)) {
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f34766a, Integer.valueOf(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR.getIntCode()), MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(GooglePlayServicesRewardedVideo.class, GooglePlayServicesRewardedVideo.class.getSimpleName(), MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        this.f34771f = new WeakReference<>(activity);
        this.f34769d = new RewardedAd(activity, this.f34768c);
        Builder builder = new Builder();
        builder.setRequestAgent(MoPubLog.LOGTAG);
        String contentUrl = GooglePlayServicesMediationSettings.m37393f();
        if (!TextUtils.isEmpty(contentUrl)) {
            builder.setContentUrl(contentUrl);
        }
        String testDeviceId = GooglePlayServicesMediationSettings.m37395h();
        if (!TextUtils.isEmpty(testDeviceId)) {
            builder.addTestDevice(testDeviceId);
        }
        m37381a(builder);
        Boolean isTFCD = GooglePlayServicesMediationSettings.m37396i();
        if (isTFCD != null) {
            builder.tagForChildDirectedTreatment(isTFCD.booleanValue());
        }
        Boolean isTFUA = GooglePlayServicesMediationSettings.m37397j();
        if (isTFUA != null) {
            if (isTFUA.booleanValue()) {
                builder.setTagForUnderAgeOfConsent(1);
            } else {
                builder.setTagForUnderAgeOfConsent(0);
            }
        }
        this.f34769d.loadAd(builder.build(), this.f34773h);
        MoPubLog.log(getAdNetworkId(), AdapterLogEvent.LOAD_ATTEMPTED, f34766a);
    }

    /* renamed from: a */
    private void m37381a(Builder builder) {
        if (!TextUtils.isEmpty(GooglePlayServicesMediationSettings.m37394g())) {
            Bundle npaBundle = new Bundle();
            npaBundle.putString("npa", GooglePlayServicesMediationSettings.m37394g());
            builder.addNetworkExtrasBundle(AdMobAdapter.class, npaBundle);
        }
    }

    /* access modifiers changed from: protected */
    public boolean hasVideoAvailable() {
        return this.f34769d != null && this.f34770e;
    }

    /* access modifiers changed from: protected */
    public void showVideo() {
        MoPubLog.log(AdapterLogEvent.SHOW_ATTEMPTED, f34766a);
        if (hasVideoAvailable()) {
            WeakReference<Activity> weakReference = this.f34771f;
            if (!(weakReference == null || weakReference.get() == null)) {
                this.f34769d.show((Activity) this.f34771f.get(), this.f34774i);
                return;
            }
        }
        MoPubLog.log(AdapterLogEvent.SHOW_FAILED, f34766a, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
        MoPubRewardedVideoManager.onRewardedVideoPlaybackError(GooglePlayServicesRewardedVideo.class, getAdNetworkId(), m37379a(3));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public MoPubErrorCode m37379a(int error) {
        if (error == 0) {
            return MoPubErrorCode.INTERNAL_ERROR;
        }
        if (error == 1) {
            return MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
        }
        if (error == 2) {
            return MoPubErrorCode.NO_CONNECTION;
        }
        if (error != 3) {
            return MoPubErrorCode.UNSPECIFIED;
        }
        return MoPubErrorCode.NO_FILL;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public MoPubErrorCode m37383b(int error) {
        if (error == 0) {
            return MoPubErrorCode.INTERNAL_ERROR;
        }
        if (error == 1) {
            return MoPubErrorCode.INTERNAL_ERROR;
        }
        if (error == 2) {
            return MoPubErrorCode.WARMUP;
        }
        if (error != 3) {
            return MoPubErrorCode.UNSPECIFIED;
        }
        return MoPubErrorCode.VIDEO_PLAYBACK_ERROR;
    }
}
