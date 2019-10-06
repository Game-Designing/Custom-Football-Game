package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbad;

@KeepName
@KeepForSdkWithMembers
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {

    /* renamed from: a */
    private View f19221a;
    @VisibleForTesting

    /* renamed from: b */
    private CustomEventBanner f19222b;
    @VisibleForTesting

    /* renamed from: c */
    private CustomEventInterstitial f19223c;
    @VisibleForTesting

    /* renamed from: d */
    private CustomEventNative f19224d;

    @VisibleForTesting
    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter$a */
    static final class C8591a implements CustomEventBannerListener {

        /* renamed from: a */
        private final CustomEventAdapter f19225a;

        /* renamed from: b */
        private final MediationBannerListener f19226b;

        public C8591a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f19225a = customEventAdapter;
            this.f19226b = mediationBannerListener;
        }

        public final void onAdLoaded(View view) {
            zzbad.m26352a("Custom event adapter called onAdLoaded.");
            this.f19225a.m20844a(view);
            this.f19226b.onAdLoaded(this.f19225a);
        }

        public final void onAdFailedToLoad(int i) {
            zzbad.m26352a("Custom event adapter called onAdFailedToLoad.");
            this.f19226b.onAdFailedToLoad(this.f19225a, i);
        }

        public final void onAdClicked() {
            zzbad.m26352a("Custom event adapter called onAdClicked.");
            this.f19226b.onAdClicked(this.f19225a);
        }

        public final void onAdOpened() {
            zzbad.m26352a("Custom event adapter called onAdOpened.");
            this.f19226b.onAdOpened(this.f19225a);
        }

        public final void onAdClosed() {
            zzbad.m26352a("Custom event adapter called onAdClosed.");
            this.f19226b.onAdClosed(this.f19225a);
        }

        public final void onAdLeftApplication() {
            zzbad.m26352a("Custom event adapter called onAdLeftApplication.");
            this.f19226b.onAdLeftApplication(this.f19225a);
        }
    }

    @VisibleForTesting
    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter$b */
    class C8592b implements CustomEventInterstitialListener {

        /* renamed from: a */
        private final CustomEventAdapter f19227a;

        /* renamed from: b */
        private final MediationInterstitialListener f19228b;

        public C8592b(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f19227a = customEventAdapter;
            this.f19228b = mediationInterstitialListener;
        }

        public final void onAdLoaded() {
            zzbad.m26352a("Custom event adapter called onReceivedAd.");
            this.f19228b.onAdLoaded(CustomEventAdapter.this);
        }

        public final void onAdFailedToLoad(int i) {
            zzbad.m26352a("Custom event adapter called onFailedToReceiveAd.");
            this.f19228b.onAdFailedToLoad(this.f19227a, i);
        }

        public final void onAdClicked() {
            zzbad.m26352a("Custom event adapter called onAdClicked.");
            this.f19228b.onAdClicked(this.f19227a);
        }

        public final void onAdOpened() {
            zzbad.m26352a("Custom event adapter called onAdOpened.");
            this.f19228b.onAdOpened(this.f19227a);
        }

        public final void onAdClosed() {
            zzbad.m26352a("Custom event adapter called onAdClosed.");
            this.f19228b.onAdClosed(this.f19227a);
        }

        public final void onAdLeftApplication() {
            zzbad.m26352a("Custom event adapter called onAdLeftApplication.");
            this.f19228b.onAdLeftApplication(this.f19227a);
        }
    }

    @VisibleForTesting
    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter$c */
    static class C8593c implements CustomEventNativeListener {

        /* renamed from: a */
        private final CustomEventAdapter f19230a;

        /* renamed from: b */
        private final MediationNativeListener f19231b;

        public C8593c(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.f19230a = customEventAdapter;
            this.f19231b = mediationNativeListener;
        }

        public final void onAdLoaded(NativeAdMapper nativeAdMapper) {
            zzbad.m26352a("Custom event adapter called onAdLoaded.");
            this.f19231b.onAdLoaded((MediationNativeAdapter) this.f19230a, nativeAdMapper);
        }

        public final void onAdLoaded(UnifiedNativeAdMapper unifiedNativeAdMapper) {
            zzbad.m26352a("Custom event adapter called onAdLoaded.");
            this.f19231b.onAdLoaded((MediationNativeAdapter) this.f19230a, unifiedNativeAdMapper);
        }

        public final void onAdFailedToLoad(int i) {
            zzbad.m26352a("Custom event adapter called onAdFailedToLoad.");
            this.f19231b.onAdFailedToLoad(this.f19230a, i);
        }

        public final void onAdOpened() {
            zzbad.m26352a("Custom event adapter called onAdOpened.");
            this.f19231b.onAdOpened(this.f19230a);
        }

        public final void onAdClicked() {
            zzbad.m26352a("Custom event adapter called onAdClicked.");
            this.f19231b.onAdClicked(this.f19230a);
        }

        public final void onAdClosed() {
            zzbad.m26352a("Custom event adapter called onAdClosed.");
            this.f19231b.onAdClosed(this.f19230a);
        }

        public final void onAdLeftApplication() {
            zzbad.m26352a("Custom event adapter called onAdLeftApplication.");
            this.f19231b.onAdLeftApplication(this.f19230a);
        }

        public final void onAdImpression() {
            zzbad.m26352a("Custom event adapter called onAdImpression.");
            this.f19231b.onAdImpression(this.f19230a);
        }
    }

    /* renamed from: a */
    private static <T> T m20843a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzbad.m26359d(sb.toString());
            return null;
        }
    }

    public final void onDestroy() {
        CustomEventBanner customEventBanner = this.f19222b;
        if (customEventBanner != null) {
            customEventBanner.onDestroy();
        }
        CustomEventInterstitial customEventInterstitial = this.f19223c;
        if (customEventInterstitial != null) {
            customEventInterstitial.onDestroy();
        }
        CustomEventNative customEventNative = this.f19224d;
        if (customEventNative != null) {
            customEventNative.onDestroy();
        }
    }

    public final void onPause() {
        CustomEventBanner customEventBanner = this.f19222b;
        if (customEventBanner != null) {
            customEventBanner.onPause();
        }
        CustomEventInterstitial customEventInterstitial = this.f19223c;
        if (customEventInterstitial != null) {
            customEventInterstitial.onPause();
        }
        CustomEventNative customEventNative = this.f19224d;
        if (customEventNative != null) {
            customEventNative.onPause();
        }
    }

    public final void onResume() {
        CustomEventBanner customEventBanner = this.f19222b;
        if (customEventBanner != null) {
            customEventBanner.onResume();
        }
        CustomEventInterstitial customEventInterstitial = this.f19223c;
        if (customEventInterstitial != null) {
            customEventInterstitial.onResume();
        }
        CustomEventNative customEventNative = this.f19224d;
        if (customEventNative != null) {
            customEventNative.onResume();
        }
    }

    public final View getBannerView() {
        return this.f19221a;
    }

    public final void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        Bundle bundle3;
        String str = "class_name";
        this.f19222b = (CustomEventBanner) m20843a(bundle.getString(str));
        if (this.f19222b == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
            return;
        }
        if (bundle2 == null) {
            bundle3 = null;
        } else {
            bundle3 = bundle2.getBundle(bundle.getString(str));
        }
        this.f19222b.requestBannerAd(context, new C8591a(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle3);
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        Bundle bundle3;
        String str = "class_name";
        this.f19223c = (CustomEventInterstitial) m20843a(bundle.getString(str));
        if (this.f19223c == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
            return;
        }
        if (bundle2 == null) {
            bundle3 = null;
        } else {
            bundle3 = bundle2.getBundle(bundle.getString(str));
        }
        this.f19223c.requestInterstitialAd(context, new C8592b(this, mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle3);
    }

    public final void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        Bundle bundle3;
        String str = "class_name";
        this.f19224d = (CustomEventNative) m20843a(bundle.getString(str));
        if (this.f19224d == null) {
            mediationNativeListener.onAdFailedToLoad(this, 0);
            return;
        }
        if (bundle2 == null) {
            bundle3 = null;
        } else {
            bundle3 = bundle2.getBundle(bundle.getString(str));
        }
        this.f19224d.requestNativeAd(context, new C8593c(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle3);
    }

    public final void showInterstitial() {
        this.f19223c.showInterstitial();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m20844a(View view) {
        this.f19221a = view;
    }
}
