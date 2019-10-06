package com.mopub.network;

import com.mopub.network.MoPubNetworkError.Reason;
import com.mopub.volley.VolleyError;

/* renamed from: com.mopub.network.c */
/* compiled from: AdLoader */
class C11669c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdLoader f36389a;

    C11669c(AdLoader this$0) {
        this.f36389a = this$0;
    }

    public void run() {
        this.f36389a.m38493a((VolleyError) new MoPubNetworkError(Reason.NO_FILL));
    }
}
