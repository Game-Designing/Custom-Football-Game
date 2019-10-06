package com.mopub.network;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.network.MultiAdRequest.Listener;
import com.mopub.volley.VolleyError;

/* renamed from: com.mopub.network.a */
/* compiled from: AdLoader */
class C11667a implements Listener {

    /* renamed from: a */
    final /* synthetic */ AdLoader f36387a;

    C11667a(AdLoader this$0) {
        this.f36387a = this$0;
    }

    public void onErrorResponse(VolleyError volleyError) {
        MoPubLog.log(AdLogEvent.RESPONSE_RECEIVED, volleyError.getMessage());
        this.f36387a.f36284j = true;
        this.f36387a.f36283i = false;
        this.f36387a.m38493a(volleyError);
    }

    public void onSuccessResponse(MultiAdResponse response) {
        synchronized (this.f36387a.f36280f) {
            this.f36387a.f36283i = false;
            this.f36387a.f36279e = response;
            if (this.f36387a.f36279e.hasNext()) {
                this.f36387a.m38492a(this.f36387a.f36279e.next());
            }
        }
    }
}
