package com.mopub.mobileads;

import com.mopub.common.MoPub;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.vungle.warren.InitCallback;
import com.vungle.warren.Vungle;
import com.vungle.warren.Vungle.Consent;

/* renamed from: com.mopub.mobileads.kb */
/* compiled from: VungleRouter */
class C11420kb implements InitCallback {

    /* renamed from: a */
    final /* synthetic */ VungleRouter f35308a;

    C11420kb(VungleRouter this$0) {
        this.f35308a = this$0;
    }

    public void onSuccess() {
        MoPubLog.log(AdapterLogEvent.CUSTOM, VungleRouter.f35161a, "SDK is initialized successfully.");
        VungleRouter.f35163c = C11365a.INITIALIZED;
        this.f35308a.m37732c();
        Vungle.updateConsentStatus(MoPub.canCollectPersonalInformation() ? Consent.OPTED_IN : Consent.OPTED_OUT, "");
    }

    public void onError(Throwable throwable) {
        MoPubLog.log(AdapterLogEvent.CUSTOM_WITH_THROWABLE, "Initialization failed.", throwable);
        VungleRouter.f35163c = C11365a.NOTINITIALIZED;
    }

    public void onAutoCacheAdAvailable(String placementId) {
    }
}
