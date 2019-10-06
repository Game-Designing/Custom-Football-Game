package com.mopub.network;

import com.mopub.network.MoPubNetworkError.Reason;
import com.mopub.volley.VolleyError;

/* renamed from: com.mopub.network.e */
/* compiled from: AdLoader */
class C11671e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdLoader f36392a;

    C11671e(AdLoader this$0) {
        this.f36392a = this$0;
    }

    public void run() {
        this.f36392a.m38493a((VolleyError) new MoPubNetworkError(Reason.NO_FILL));
    }
}
