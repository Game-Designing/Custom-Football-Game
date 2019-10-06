package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7253c;

/* renamed from: com.mopub.mobileads.g */
/* compiled from: AppLovinBanner */
class C11402g implements C7253c {

    /* renamed from: a */
    final /* synthetic */ AppLovinBanner f35269a;

    C11402g(AppLovinBanner this$0) {
        this.f35269a = this$0;
    }

    public void adDisplayed(C7251a ad) {
        MoPubLog.m37080d("Banner displayed");
    }

    public void adHidden(C7251a ad) {
        MoPubLog.m37080d("Banner dismissed");
    }
}
