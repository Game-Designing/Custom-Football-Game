package com.integralads.avid.library.mopub.session.internal;

import android.content.Context;
import android.webkit.WebView;
import com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext;

public abstract class InternalAvidHtmlAdSession extends InternalAvidAdSession<WebView> {
    public InternalAvidHtmlAdSession(Context context, String avidAdSessionId, ExternalAvidAdSessionContext avidAdSessionContext) {
        super(context, avidAdSessionId, avidAdSessionContext);
    }

    public WebView getWebView() {
        return (WebView) getView();
    }

    /* access modifiers changed from: protected */
    public void onViewRegistered() {
        super.onViewRegistered();
        updateWebViewManager();
    }

    /* access modifiers changed from: protected */
    public void onViewUnregistered() {
        super.onViewUnregistered();
        updateWebViewManager();
    }
}
