package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.IntentActions;
import com.mopub.network.TrackingRequest;

/* renamed from: com.mopub.mobileads.Xa */
/* compiled from: VastVideoViewController */
class C11370Xa implements C11373a {

    /* renamed from: a */
    final /* synthetic */ VastCompanionAdConfig f35181a;

    /* renamed from: b */
    final /* synthetic */ Context f35182b;

    /* renamed from: c */
    final /* synthetic */ VastVideoViewController f35183c;

    C11370Xa(VastVideoViewController this$0, VastCompanionAdConfig vastCompanionAdConfig, Context context) {
        this.f35183c = this$0;
        this.f35181a = vastCompanionAdConfig;
        this.f35182b = context;
    }

    public void onVastWebViewClick() {
        this.f35183c.mo36927a(IntentActions.ACTION_INTERSTITIAL_CLICK);
        TrackingRequest.makeVastTrackingHttpRequest(this.f35181a.getClickTrackers(), null, Integer.valueOf(this.f35183c.f35079H), null, this.f35182b);
        this.f35181a.mo37210a(this.f35182b, 1, null, this.f35183c.f35081e.getDspCreativeId());
    }
}
