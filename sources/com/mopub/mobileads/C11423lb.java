package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.vungle.warren.PlayAdCallback;

/* renamed from: com.mopub.mobileads.lb */
/* compiled from: VungleRouter */
class C11423lb implements PlayAdCallback {

    /* renamed from: a */
    final /* synthetic */ VungleRouter f35313a;

    C11423lb(VungleRouter this$0) {
        this.f35313a = this$0;
    }

    public void onAdEnd(String id, boolean completed, boolean isCTAClicked) {
        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("onAdEnd - Placement ID: ");
        sb.append(id);
        MoPubLog.log(adapterLogEvent, VungleRouter.f35161a, sb.toString());
        VungleRouterListener targetListener = (VungleRouterListener) VungleRouter.f35164d.get(id);
        if (targetListener != null) {
            targetListener.onAdEnd(id, completed, isCTAClicked);
            return;
        }
        AdapterLogEvent adapterLogEvent2 = AdapterLogEvent.CUSTOM;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAdEnd - VungleRouterListener is not found for Placement ID: ");
        sb2.append(id);
        MoPubLog.log(adapterLogEvent2, VungleRouter.f35161a, sb2.toString());
    }

    public void onAdStart(String id) {
        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("onAdStart - Placement ID: ");
        sb.append(id);
        MoPubLog.log(adapterLogEvent, VungleRouter.f35161a, sb.toString());
        VungleRouterListener targetListener = (VungleRouterListener) VungleRouter.f35164d.get(id);
        if (targetListener != null) {
            targetListener.onAdStart(id);
            return;
        }
        AdapterLogEvent adapterLogEvent2 = AdapterLogEvent.CUSTOM;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAdStart - VungleRouterListener is not found for Placement ID: ");
        sb2.append(id);
        MoPubLog.log(adapterLogEvent2, VungleRouter.f35161a, sb2.toString());
    }

    public void onError(String id, Throwable error) {
        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM_WITH_THROWABLE;
        StringBuilder sb = new StringBuilder();
        sb.append("onUnableToPlayAd - Placement ID: ");
        sb.append(id);
        MoPubLog.log(adapterLogEvent, sb.toString(), error);
        VungleRouterListener targetListener = (VungleRouterListener) VungleRouter.f35164d.get(id);
        if (targetListener != null) {
            targetListener.onUnableToPlayAd(id, error.getLocalizedMessage());
            return;
        }
        AdapterLogEvent adapterLogEvent2 = AdapterLogEvent.CUSTOM;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onUnableToPlayAd - VungleRouterListener is not found for Placement ID: ");
        sb2.append(id);
        MoPubLog.log(adapterLogEvent2, VungleRouter.f35161a, sb2.toString());
    }
}
