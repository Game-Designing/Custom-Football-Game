package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.vungle.warren.LoadAdCallback;

/* renamed from: com.mopub.mobileads.mb */
/* compiled from: VungleRouter */
class C11426mb implements LoadAdCallback {

    /* renamed from: a */
    final /* synthetic */ VungleRouter f35316a;

    C11426mb(VungleRouter this$0) {
        this.f35316a = this$0;
    }

    public void onAdLoad(String id) {
        m37827a(id, true);
    }

    public void onError(String id, Throwable cause) {
        m37827a(id, false);
    }

    /* renamed from: a */
    private void m37827a(String placementReferenceId, boolean isAdAvailable) {
        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("onAdAvailabilityUpdate - Placement ID: ");
        sb.append(placementReferenceId);
        MoPubLog.log(adapterLogEvent, VungleRouter.f35161a, sb.toString());
        VungleRouterListener targetListener = (VungleRouterListener) VungleRouter.f35164d.get(placementReferenceId);
        if (targetListener != null) {
            targetListener.onAdAvailabilityUpdate(placementReferenceId, isAdAvailable);
            return;
        }
        AdapterLogEvent adapterLogEvent2 = AdapterLogEvent.CUSTOM;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAdAvailabilityUpdate - VungleRouterListener is not found for Placement ID: ");
        sb2.append(placementReferenceId);
        MoPubLog.log(adapterLogEvent2, VungleRouter.f35161a, sb2.toString());
    }
}
