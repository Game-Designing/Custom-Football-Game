package com.mopub.mraid;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

/* renamed from: com.mopub.mraid.f */
/* compiled from: MraidBridge */
class C11489f extends MraidWebViewClient {

    /* renamed from: b */
    final /* synthetic */ MraidBridge f35566b;

    C11489f(MraidBridge this$0) {
        this.f35566b = this$0;
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return this.f35566b.mo37609a(url);
    }

    public void onPageFinished(WebView view, String url) {
        this.f35566b.m37966g();
    }

    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("Error: ");
        sb.append(description);
        MoPubLog.log(sdkLogEvent, sb.toString());
        super.onReceivedError(view, errorCode, description, failingUrl);
    }

    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        this.f35566b.mo37601a(detail);
        return true;
    }
}
