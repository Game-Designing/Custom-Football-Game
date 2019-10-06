package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7252b;

/* renamed from: com.mopub.mobileads.h */
/* compiled from: AppLovinBanner */
class C11405h implements C7252b {

    /* renamed from: a */
    final /* synthetic */ CustomEventBannerListener f35271a;

    /* renamed from: b */
    final /* synthetic */ AppLovinBanner f35272b;

    C11405h(AppLovinBanner this$0, CustomEventBannerListener customEventBannerListener) {
        this.f35272b = this$0;
        this.f35271a = customEventBannerListener;
    }

    public void adClicked(C7251a ad) {
        MoPubLog.m37080d("Banner clicked");
        CustomEventBannerListener customEventBannerListener = this.f35271a;
        if (customEventBannerListener != null) {
            customEventBannerListener.onBannerClicked();
        }
    }
}
