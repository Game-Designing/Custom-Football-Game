package com.mopub.mobileads;

import com.mopub.common.UrlHandler.MoPubSchemeListener;

/* renamed from: com.mopub.mobileads.E */
/* compiled from: HtmlWebViewClient */
class C11306E implements MoPubSchemeListener {

    /* renamed from: a */
    final /* synthetic */ C11310G f34741a;

    C11306E(C11310G this$0) {
        this.f34741a = this$0;
    }

    public void onFinishLoad() {
        this.f34741a.f34750d.onLoaded(this.f34741a.f34751e);
    }

    public void onClose() {
        this.f34741a.f34750d.onCollapsed();
    }

    public void onFailLoad() {
        this.f34741a.f34751e.stopLoading();
        this.f34741a.f34750d.onFailed(MoPubErrorCode.UNSPECIFIED);
    }

    public void onCrash() {
    }
}
