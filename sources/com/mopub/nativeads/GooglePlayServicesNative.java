package com.mopub.nativeads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.mopub.common.MediationSettings;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.mobileads.GooglePlayServicesAdapterConfiguration;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class GooglePlayServicesNative extends CustomEventNative {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f35660a = GooglePlayServicesNative.class.getSimpleName();

    /* renamed from: b */
    private static AtomicBoolean f35661b = new AtomicBoolean(false);

    /* renamed from: c */
    private GooglePlayServicesAdapterConfiguration f35662c = new GooglePlayServicesAdapterConfiguration();

    public static final class GooglePlayServicesMediationSettings implements MediationSettings {

        /* renamed from: a */
        private static Bundle f35663a;

        public GooglePlayServicesMediationSettings() {
        }

        public GooglePlayServicesMediationSettings(Bundle bundle) {
            f35663a = bundle;
        }

        public void setNpaBundle(Bundle bundle) {
            f35663a = bundle;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public static Bundle m38137b() {
            return f35663a;
        }
    }

    /* renamed from: com.mopub.nativeads.GooglePlayServicesNative$a */
    static class C11529a extends BaseNativeAd {

        /* renamed from: e */
        private String f35664e;

        /* renamed from: f */
        private String f35665f;

        /* renamed from: g */
        private String f35666g;

        /* renamed from: h */
        private String f35667h;

        /* renamed from: i */
        private String f35668i;

        /* renamed from: j */
        private Double f35669j;

        /* renamed from: k */
        private String f35670k;

        /* renamed from: l */
        private String f35671l;

        /* renamed from: m */
        private String f35672m;

        /* renamed from: n */
        private String f35673n;

        /* renamed from: o */
        private boolean f35674o;
        /* access modifiers changed from: private */

        /* renamed from: p */
        public CustomEventNativeListener f35675p;
        /* access modifiers changed from: private */

        /* renamed from: q */
        public UnifiedNativeAd f35676q;

        public C11529a(CustomEventNativeListener customEventNativeListener) {
            this.f35675p = customEventNativeListener;
        }

        public String getMediaView() {
            return this.f35673n;
        }

        public void setMediaView(String mediaView) {
            this.f35673n = mediaView;
        }

        public String getTitle() {
            return this.f35664e;
        }

        public String getText() {
            return this.f35665f;
        }

        public String getMainImageUrl() {
            return this.f35666g;
        }

        public String getIconImageUrl() {
            return this.f35667h;
        }

        public String getCallToAction() {
            return this.f35668i;
        }

        public Double getStarRating() {
            return this.f35669j;
        }

        public String getAdvertiser() {
            return this.f35670k;
        }

        public String getStore() {
            return this.f35671l;
        }

        public String getPrice() {
            return this.f35672m;
        }

        public void setTitle(String title) {
            this.f35664e = title;
        }

        public void setText(String text) {
            this.f35665f = text;
        }

        public void setMainImageUrl(String mainImageUrl) {
            this.f35666g = mainImageUrl;
        }

        public void setIconImageUrl(String iconImageUrl) {
            this.f35667h = iconImageUrl;
        }

        public void setCallToAction(String callToAction) {
            this.f35668i = callToAction;
        }

        public void setStarRating(Double starRating) {
            this.f35669j = starRating;
        }

        public void setAdvertiser(String advertiser) {
            this.f35670k = advertiser;
        }

        public void setStore(String store) {
            this.f35671l = store;
        }

        public void setPrice(String price) {
            this.f35672m = price;
        }

        public boolean shouldSwapMargins() {
            return this.f35674o;
        }

        public UnifiedNativeAd getUnifiedNativeAd() {
            return this.f35676q;
        }

        public void loadAd(Context context, String adUnitId, Map<String, Object> localExtras) {
            Context context2 = context;
            Map<String, Object> map = localExtras;
            Builder builder = new Builder(context2, adUnitId);
            String str = "swap_margins";
            if (map.containsKey(str)) {
                Object swapMarginExtra = map.get(str);
                if (swapMarginExtra instanceof Boolean) {
                    this.f35674o = ((Boolean) swapMarginExtra).booleanValue();
                }
            }
            NativeAdOptions.Builder optionsBuilder = new NativeAdOptions.Builder();
            optionsBuilder.setReturnUrlsForImageAssets(true);
            optionsBuilder.setRequestMultipleImages(false);
            optionsBuilder.setReturnUrlsForImageAssets(false);
            String str2 = "orientation_preference";
            if (map.containsKey(str2) && m38149d(map.get(str2))) {
                optionsBuilder.setImageOrientation(((Integer) map.get(str2)).intValue());
            }
            String str3 = "ad_choices_placement";
            if (map.containsKey(str3) && m38148c(map.get(str3))) {
                optionsBuilder.setAdChoicesPlacement(((Integer) map.get(str3)).intValue());
            }
            AdLoader adLoader = builder.forUnifiedNativeAd(new C11611j(this, context2)).withAdListener(new C11608i(this)).withNativeAdOptions(optionsBuilder.build()).build();
            AdRequest.Builder requestBuilder = new AdRequest.Builder();
            requestBuilder.setRequestAgent(MoPubLog.LOGTAG);
            String contentUrl = (String) map.get("contentUrl");
            if (!TextUtils.isEmpty(contentUrl)) {
                requestBuilder.setContentUrl(contentUrl);
            }
            String testDeviceId = (String) map.get("testDevices");
            if (!TextUtils.isEmpty(testDeviceId)) {
                requestBuilder.addTestDevice(testDeviceId);
            }
            m38140a(requestBuilder);
            Boolean childDirected = (Boolean) map.get("tagForChildDirectedTreatment");
            if (childDirected != null) {
                requestBuilder.tagForChildDirectedTreatment(childDirected.booleanValue());
            }
            Boolean underAgeOfConsent = (Boolean) map.get("tagForUnderAgeOfConsent");
            if (underAgeOfConsent != null) {
                if (underAgeOfConsent.booleanValue()) {
                    requestBuilder.setTagForUnderAgeOfConsent(1);
                } else {
                    requestBuilder.setTagForUnderAgeOfConsent(0);
                }
            }
            adLoader.loadAd(requestBuilder.build());
            MoPubLog.log(AdapterLogEvent.LOAD_ATTEMPTED, GooglePlayServicesNative.f35660a);
        }

        /* renamed from: a */
        private void m38140a(AdRequest.Builder builder) {
            if (GooglePlayServicesMediationSettings.m38137b() != null && !GooglePlayServicesMediationSettings.m38137b().isEmpty()) {
                builder.addNetworkExtrasBundle(AdMobAdapter.class, GooglePlayServicesMediationSettings.m38137b());
            }
        }

        /* renamed from: d */
        private boolean m38149d(Object extra) {
            boolean z = false;
            if (extra == null || !(extra instanceof Integer)) {
                return false;
            }
            Integer preference = (Integer) extra;
            if (preference.intValue() == 0 || preference.intValue() == 2 || preference.intValue() == 1) {
                z = true;
            }
            return z;
        }

        /* renamed from: c */
        private boolean m38148c(Object extra) {
            boolean z = false;
            if (extra == null || !(extra instanceof Integer)) {
                return false;
            }
            Integer placement = (Integer) extra;
            if (placement.intValue() == 0 || placement.intValue() == 1 || placement.intValue() == 3 || placement.intValue() == 2) {
                z = true;
            }
            return z;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public boolean m38142a(UnifiedNativeAd unifiedNativeAd) {
            if (unifiedNativeAd.getHeadline() == null || unifiedNativeAd.getBody() == null || unifiedNativeAd.getImages() == null || unifiedNativeAd.getImages().size() <= 0 || unifiedNativeAd.getImages().get(0) == null || unifiedNativeAd.getIcon() == null || unifiedNativeAd.getCallToAction() == null) {
                return false;
            }
            return true;
        }

        public void prepare(View view) {
        }

        public void clear(View view) {
            this.f35675p = null;
            this.f35676q.cancelUnconfirmedClick();
        }

        public void destroy() {
            UnifiedNativeAd unifiedNativeAd = this.f35676q;
            if (unifiedNativeAd != null) {
                unifiedNativeAd.destroy();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m38139a(Context context, List<String> imageUrls) {
            NativeImageHelper.preCacheImages(context, imageUrls, new C11614k(this));
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m38146b(UnifiedNativeAd unifiedNativeAd) {
            setMainImageUrl(((Image) unifiedNativeAd.getImages().get(0)).getUri().toString());
            setIconImageUrl(unifiedNativeAd.getIcon().getUri().toString());
            setCallToAction(unifiedNativeAd.getCallToAction());
            setTitle(unifiedNativeAd.getHeadline());
            setText(unifiedNativeAd.getBody());
            if (unifiedNativeAd.getStarRating() != null) {
                setStarRating(unifiedNativeAd.getStarRating());
            }
            if (unifiedNativeAd.getStore() != null) {
                setStore(unifiedNativeAd.getStore());
            }
            if (unifiedNativeAd.getPrice() != null) {
                setPrice(unifiedNativeAd.getPrice());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void loadNativeAd(Context context, CustomEventNativeListener customEventNativeListener, Map<String, Object> localExtras, Map<String, String> serverExtras) {
        if (!f35661b.getAndSet(true)) {
            String str = "appid";
            if (!serverExtras.containsKey(str) || TextUtils.isEmpty((CharSequence) serverExtras.get(str))) {
                MobileAds.initialize(context);
            } else {
                MobileAds.initialize(context, (String) serverExtras.get(str));
            }
        }
        String adUnitId = (String) serverExtras.get("adunit");
        if (TextUtils.isEmpty(adUnitId)) {
            customEventNativeListener.onNativeAdFailed(NativeErrorCode.NETWORK_NO_FILL);
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f35660a, Integer.valueOf(NativeErrorCode.NETWORK_NO_FILL.getIntCode()), NativeErrorCode.NETWORK_NO_FILL);
            return;
        }
        new C11529a(customEventNativeListener).loadAd(context, adUnitId, localExtras);
        this.f35662c.setCachedInitializationParameters(context, serverExtras);
    }
}
