package com.mopub.mobileads;

import com.applovin.adview.C5856b;
import com.applovin.adview.C5857c;
import com.applovin.adview.C5858d;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import p019d.p143b.p150d.C7251a;

/* renamed from: com.mopub.mobileads.i */
/* compiled from: AppLovinBanner */
class C11408i implements C5858d {

    /* renamed from: a */
    final /* synthetic */ CustomEventBannerListener f35275a;

    /* renamed from: b */
    final /* synthetic */ AppLovinBanner f35276b;

    C11408i(AppLovinBanner this$0, CustomEventBannerListener customEventBannerListener) {
        this.f35276b = this$0;
        this.f35275a = customEventBannerListener;
    }

    public void adOpenedFullscreen(C7251a appLovinAd, C5856b appLovinAdView) {
        MoPubLog.m37080d("Banner opened fullscreen");
        CustomEventBannerListener customEventBannerListener = this.f35275a;
        if (customEventBannerListener != null) {
            customEventBannerListener.onBannerExpanded();
        }
    }

    public void adClosedFullscreen(C7251a appLovinAd, C5856b appLovinAdView) {
        MoPubLog.m37080d("Banner closed fullscreen");
        CustomEventBannerListener customEventBannerListener = this.f35275a;
        if (customEventBannerListener != null) {
            customEventBannerListener.onBannerCollapsed();
        }
    }

    public void adLeftApplication(C7251a appLovinAd, C5856b appLovinAdView) {
        MoPubLog.m37080d("Banner left application");
    }

    public void adFailedToDisplay(C7251a appLovinAd, C5856b appLovinAdView, C5857c appLovinAdViewDisplayErrorCode) {
    }
}
