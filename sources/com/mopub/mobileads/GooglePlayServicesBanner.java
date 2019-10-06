package com.mopub.mobileads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.mopub.common.MediationSettings;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.common.util.Views;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import java.util.Map;

public class GooglePlayServicesBanner extends CustomEventBanner {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f34755b = GooglePlayServicesBanner.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CustomEventBannerListener f34756c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AdView f34757d;

    public static final class GooglePlayServicesMediationSettings implements MediationSettings {

        /* renamed from: a */
        private static Bundle f34758a;

        public GooglePlayServicesMediationSettings() {
        }

        public GooglePlayServicesMediationSettings(Bundle bundle) {
            f34758a = bundle;
        }

        public void setNpaBundle(Bundle bundle) {
            f34758a = bundle;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public static Bundle m37370b() {
            return f34758a;
        }
    }

    /* renamed from: com.mopub.mobileads.GooglePlayServicesBanner$a */
    private class C11312a extends AdListener {
        private C11312a() {
        }

        public void onAdClosed() {
        }

        public void onAdFailedToLoad(int errorCode) {
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, GooglePlayServicesBanner.f34755b, Integer.valueOf(m37371a(errorCode).getIntCode()), m37371a(errorCode));
            if (GooglePlayServicesBanner.this.f34756c != null) {
                GooglePlayServicesBanner.this.f34756c.onBannerFailed(m37371a(errorCode));
            }
        }

        public void onAdLeftApplication() {
        }

        public void onAdLoaded() {
            MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, GooglePlayServicesBanner.f34755b);
            MoPubLog.log(AdapterLogEvent.SHOW_ATTEMPTED, GooglePlayServicesBanner.f34755b);
            MoPubLog.log(AdapterLogEvent.SHOW_SUCCESS, GooglePlayServicesBanner.f34755b);
            if (GooglePlayServicesBanner.this.f34756c != null) {
                GooglePlayServicesBanner.this.f34756c.onBannerLoaded(GooglePlayServicesBanner.this.f34757d);
            }
        }

        public void onAdOpened() {
            MoPubLog.log(AdapterLogEvent.CLICKED, GooglePlayServicesBanner.f34755b);
            if (GooglePlayServicesBanner.this.f34756c != null) {
                GooglePlayServicesBanner.this.f34756c.onBannerClicked();
            }
        }

        /* renamed from: a */
        private MoPubErrorCode m37371a(int error) {
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
    public void loadBanner(Context context, CustomEventBannerListener customEventBannerListener, Map<String, Object> localExtras, Map<String, String> serverExtras) {
        Map<String, Object> map = localExtras;
        Map<String, String> map2 = serverExtras;
        this.f34756c = customEventBannerListener;
        String str = "";
        if (m37366a(map2)) {
            String adUnitId = (String) map2.get("adUnitID");
            int adWidth = Integer.parseInt((String) map2.get("adWidth"));
            int adHeight = Integer.parseInt((String) map2.get("adHeight"));
            this.f34757d = new AdView(context);
            this.f34757d.setAdListener(new C11312a());
            this.f34757d.setAdUnitId(adUnitId);
            AdSize adSize = m37363a(adWidth, adHeight);
            if (adSize == null) {
                MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f34755b, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
                this.f34756c.onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
                return;
            }
            this.f34757d.setAdSize(adSize);
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
            m37365a(builder);
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
                this.f34757d.loadAd(builder.build());
                MoPubLog.log(adUnitId, AdapterLogEvent.LOAD_ATTEMPTED, f34755b);
            } catch (NoClassDefFoundError e) {
                MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f34755b, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
                this.f34756c.onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
            }
            return;
        }
        Context context2 = context;
        MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f34755b, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
        this.f34756c.onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        Views.removeFromParent(this.f34757d);
        AdView adView = this.f34757d;
        if (adView != null) {
            adView.setAdListener(null);
            this.f34757d.destroy();
        }
    }

    /* renamed from: a */
    private void m37365a(Builder builder) {
        if (GooglePlayServicesMediationSettings.m37370b() != null && !GooglePlayServicesMediationSettings.m37370b().isEmpty()) {
            builder.addNetworkExtrasBundle(AdMobAdapter.class, GooglePlayServicesMediationSettings.m37370b());
        }
    }

    /* renamed from: a */
    private boolean m37366a(Map<String, String> serverExtras) {
        try {
            Integer.parseInt((String) serverExtras.get("adWidth"));
            Integer.parseInt((String) serverExtras.get("adHeight"));
            return serverExtras.containsKey("adUnitID");
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /* renamed from: a */
    private AdSize m37363a(int width, int height) {
        if (width <= AdSize.BANNER.getWidth() && height <= AdSize.BANNER.getHeight()) {
            return AdSize.BANNER;
        }
        if (width <= AdSize.MEDIUM_RECTANGLE.getWidth() && height <= AdSize.MEDIUM_RECTANGLE.getHeight()) {
            return AdSize.MEDIUM_RECTANGLE;
        }
        if (width <= AdSize.FULL_BANNER.getWidth() && height <= AdSize.FULL_BANNER.getHeight()) {
            return AdSize.FULL_BANNER;
        }
        if (width > AdSize.LEADERBOARD.getWidth() || height > AdSize.LEADERBOARD.getHeight()) {
            return null;
        }
        return AdSize.LEADERBOARD;
    }
}
