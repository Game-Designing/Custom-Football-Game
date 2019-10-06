package com.mopub.mobileads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;
import com.mopub.common.MediationSettings;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import java.util.Map;

public class GooglePlayServicesInterstitial extends CustomEventInterstitial {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f34760b = GooglePlayServicesInterstitial.class.getSimpleName();

    /* renamed from: c */
    private GooglePlayServicesAdapterConfiguration f34761c = new GooglePlayServicesAdapterConfiguration();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CustomEventInterstitialListener f34762d;

    /* renamed from: e */
    private InterstitialAd f34763e;

    public static final class GooglePlayServicesMediationSettings implements MediationSettings {

        /* renamed from: a */
        private static Bundle f34764a;

        public GooglePlayServicesMediationSettings() {
        }

        public GooglePlayServicesMediationSettings(Bundle bundle) {
            f34764a = bundle;
        }

        public void setNpaBundle(Bundle bundle) {
            f34764a = bundle;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public static Bundle m37377b() {
            return f34764a;
        }
    }

    /* renamed from: com.mopub.mobileads.GooglePlayServicesInterstitial$a */
    private class C11313a extends AdListener {
        private C11313a() {
        }

        public void onAdClosed() {
            if (GooglePlayServicesInterstitial.this.f34762d != null) {
                GooglePlayServicesInterstitial.this.f34762d.onInterstitialDismissed();
            }
        }

        public void onAdFailedToLoad(int errorCode) {
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, GooglePlayServicesInterstitial.f34760b, Integer.valueOf(m37378a(errorCode).getIntCode()), m37378a(errorCode));
            if (GooglePlayServicesInterstitial.this.f34762d != null) {
                GooglePlayServicesInterstitial.this.f34762d.onInterstitialFailed(m37378a(errorCode));
            }
        }

        public void onAdLeftApplication() {
            if (GooglePlayServicesInterstitial.this.f34762d != null) {
                GooglePlayServicesInterstitial.this.f34762d.onInterstitialClicked();
            }
        }

        public void onAdLoaded() {
            MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, GooglePlayServicesInterstitial.f34760b);
            if (GooglePlayServicesInterstitial.this.f34762d != null) {
                GooglePlayServicesInterstitial.this.f34762d.onInterstitialLoaded();
            }
        }

        public void onAdOpened() {
            MoPubLog.log(AdapterLogEvent.SHOW_SUCCESS, GooglePlayServicesInterstitial.f34760b);
            if (GooglePlayServicesInterstitial.this.f34762d != null) {
                GooglePlayServicesInterstitial.this.f34762d.onInterstitialShown();
                GooglePlayServicesInterstitial.this.f34762d.onInterstitialImpression();
            }
        }

        /* renamed from: a */
        private MoPubErrorCode m37378a(int error) {
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
    }

    /* access modifiers changed from: protected */
    public void loadInterstitial(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> localExtras, Map<String, String> serverExtras) {
        Context context2 = context;
        Map<String, Object> map = localExtras;
        Map<String, String> map2 = serverExtras;
        mo36971a(false);
        this.f34762d = customEventInterstitialListener;
        if (m37374a(map2)) {
            String adUnitId = (String) map2.get("adUnitID");
            this.f34761c.setCachedInitializationParameters(context2, map2);
            this.f34763e = new InterstitialAd(context2);
            this.f34763e.setAdListener(new C11313a());
            this.f34763e.setAdUnitId(adUnitId);
            Builder builder = new Builder();
            builder.setRequestAgent(MoPubLog.LOGTAG);
            String contentUrl = (String) map.get("contentUrl");
            if (!TextUtils.isEmpty(contentUrl)) {
                builder.setContentUrl(contentUrl);
            }
            String testDeviceId = (String) map.get("testDevices");
            if (!TextUtils.isEmpty(testDeviceId)) {
                builder.addTestDevice(testDeviceId);
            }
            m37373a(builder);
            Boolean childDirected = (Boolean) map.get("tagForChildDirectedTreatment");
            if (childDirected != null) {
                builder.tagForChildDirectedTreatment(childDirected.booleanValue());
            }
            Boolean underAgeOfConsent = (Boolean) map.get("tagForUnderAgeOfConsent");
            if (underAgeOfConsent != null) {
                if (underAgeOfConsent.booleanValue()) {
                    builder.setTagForUnderAgeOfConsent(1);
                } else {
                    builder.setTagForUnderAgeOfConsent(0);
                }
            }
            try {
                this.f34763e.loadAd(builder.build());
                MoPubLog.log(adUnitId, AdapterLogEvent.LOAD_ATTEMPTED, f34760b);
            } catch (NoClassDefFoundError e) {
                MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f34760b, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
                CustomEventInterstitialListener customEventInterstitialListener2 = this.f34762d;
                if (customEventInterstitialListener2 != null) {
                    customEventInterstitialListener2.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
                }
            }
            return;
        }
        MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f34760b, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
        CustomEventInterstitialListener customEventInterstitialListener3 = this.f34762d;
        if (customEventInterstitialListener3 != null) {
            customEventInterstitialListener3.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
        }
    }

    /* renamed from: a */
    private void m37373a(Builder builder) {
        if (GooglePlayServicesMediationSettings.m37377b() != null && !GooglePlayServicesMediationSettings.m37377b().isEmpty()) {
            builder.addNetworkExtrasBundle(AdMobAdapter.class, GooglePlayServicesMediationSettings.m37377b());
        }
    }

    /* access modifiers changed from: protected */
    public void showInterstitial() {
        MoPubLog.log(AdapterLogEvent.SHOW_ATTEMPTED, f34760b);
        if (this.f34763e.isLoaded()) {
            this.f34763e.show();
            return;
        }
        MoPubLog.log(AdapterLogEvent.SHOW_FAILED, f34760b, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
        CustomEventInterstitialListener customEventInterstitialListener = this.f34762d;
        if (customEventInterstitialListener != null) {
            customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
        }
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        InterstitialAd interstitialAd = this.f34763e;
        if (interstitialAd != null) {
            interstitialAd.setAdListener(null);
        }
    }

    /* renamed from: a */
    private boolean m37374a(Map<String, String> serverExtras) {
        return serverExtras.containsKey("adUnitID");
    }
}
