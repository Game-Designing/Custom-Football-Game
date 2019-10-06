package com.mopub.mobileads;

import android.content.Context;
import com.mopub.network.TrackingRequest;

/* renamed from: com.mopub.mobileads.Va */
/* compiled from: VastVideoViewController */
class C11357Va implements C11373a {

    /* renamed from: a */
    final /* synthetic */ C11302Ca f34972a;

    /* renamed from: b */
    final /* synthetic */ Context f34973b;

    /* renamed from: c */
    final /* synthetic */ VastVideoViewController f34974c;

    C11357Va(VastVideoViewController this$0, C11302Ca ca, Context context) {
        this.f34974c = this$0;
        this.f34972a = ca;
        this.f34973b = context;
    }

    public void onVastWebViewClick() {
        TrackingRequest.makeVastTrackingHttpRequest(this.f34972a.mo36948a(), null, Integer.valueOf(this.f34974c.mo37366i()), this.f34974c.mo37368k(), this.f34973b);
        this.f34972a.mo36950a(this.f34974c.mo36929b(), (String) null, this.f34974c.f35081e.getDspCreativeId());
    }
}
