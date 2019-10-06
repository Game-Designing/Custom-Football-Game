package com.mopub.network;

import com.mopub.network.MoPubNetworkError.Reason;
import com.mopub.volley.VolleyError;

/* renamed from: com.mopub.network.b */
/* compiled from: AdLoader */
class C11668b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdLoader f36388a;

    C11668b(AdLoader this$0) {
        this.f36388a = this$0;
    }

    public void run() {
        this.f36388a.m38493a((VolleyError) new MoPubNetworkError(Reason.UNSPECIFIED));
    }
}
