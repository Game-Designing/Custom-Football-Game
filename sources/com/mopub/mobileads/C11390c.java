package com.mopub.mobileads;

import com.mopub.network.AdLoader.Listener;
import com.mopub.network.AdResponse;
import com.mopub.volley.VolleyError;

/* renamed from: com.mopub.mobileads.c */
/* compiled from: AdViewController */
class C11390c implements Listener {

    /* renamed from: a */
    final /* synthetic */ AdViewController f35245a;

    C11390c(AdViewController this$0) {
        this.f35245a = this$0;
    }

    public void onSuccess(AdResponse response) {
        this.f35245a.mo36860a(response);
    }

    public void onErrorResponse(VolleyError volleyError) {
        this.f35245a.mo36861a(volleyError);
    }
}
