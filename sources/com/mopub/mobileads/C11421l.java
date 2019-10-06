package com.mopub.mobileads;

import com.applovin.adview.C5856b;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7254d;

/* renamed from: com.mopub.mobileads.l */
/* compiled from: AppLovinBanner */
class C11421l implements C7254d {

    /* renamed from: a */
    final /* synthetic */ C5856b f35309a;

    /* renamed from: b */
    final /* synthetic */ CustomEventBannerListener f35310b;

    /* renamed from: c */
    final /* synthetic */ AppLovinBanner f35311c;

    C11421l(AppLovinBanner this$0, C5856b bVar, CustomEventBannerListener customEventBannerListener) {
        this.f35311c = this$0;
        this.f35309a = bVar;
        this.f35310b = customEventBannerListener;
    }

    public void adReceived(C7251a ad) {
        AppLovinBanner.m37274b((Runnable) new C11415j(this, ad));
    }

    public void failedToReceiveAd(int errorCode) {
        AppLovinBanner.m37274b((Runnable) new C11418k(this, errorCode));
    }
}
