package com.mopub.common;

import com.mopub.common.UrlHandler.ResultActions;

/* renamed from: com.mopub.common.d */
/* compiled from: BrowserWebViewClient */
class C11243d implements ResultActions {

    /* renamed from: a */
    final /* synthetic */ C11244e f34397a;

    C11243d(C11244e this$0) {
        this.f34397a = this$0;
    }

    public void urlHandlingSucceeded(String url, UrlAction urlAction) {
        if (urlAction.equals(UrlAction.OPEN_IN_APP_BROWSER)) {
            this.f34397a.f34399b.getWebView().loadUrl(url);
        } else {
            this.f34397a.f34399b.finish();
        }
    }

    public void urlHandlingFailed(String url, UrlAction lastFailedUrlAction) {
    }
}
