package com.mopub.mraid;

import com.mopub.common.UrlHandler.MoPubSchemeListener;

/* renamed from: com.mopub.mraid.k */
/* compiled from: MraidController */
class C11494k implements MoPubSchemeListener {

    /* renamed from: a */
    final /* synthetic */ MraidController f35571a;

    C11494k(MraidController this$0) {
        this.f35571a = this$0;
    }

    public void onFinishLoad() {
    }

    public void onClose() {
    }

    public void onFailLoad() {
    }

    public void onCrash() {
        if (this.f35571a.f35506n != null) {
            this.f35571a.f35506n.loadUrl("chrome://crash");
        }
    }
}
