package com.mopub.mobileads;

import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.ResultActions;

/* renamed from: com.mopub.mobileads.F */
/* compiled from: HtmlWebViewClient */
class C11308F implements ResultActions {

    /* renamed from: a */
    final /* synthetic */ C11310G f34745a;

    C11308F(C11310G this$0) {
        this.f34745a = this$0;
    }

    public void urlHandlingSucceeded(String url, UrlAction urlAction) {
        if (this.f34745a.f34751e.wasClicked()) {
            this.f34745a.f34750d.onClicked();
            this.f34745a.f34751e.onResetUserClick();
        }
    }

    public void urlHandlingFailed(String url, UrlAction lastFailedUrlAction) {
    }
}
