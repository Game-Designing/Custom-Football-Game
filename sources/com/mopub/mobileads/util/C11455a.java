package com.mopub.mobileads.util;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

/* renamed from: com.mopub.mobileads.util.a */
/* compiled from: WebViews */
class C11455a extends WebChromeClient {
    C11455a() {
    }

    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        MoPubLog.log(SdkLogEvent.CUSTOM, message);
        result.confirm();
        return true;
    }

    public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
        MoPubLog.log(SdkLogEvent.CUSTOM, message);
        result.confirm();
        return true;
    }

    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        MoPubLog.log(SdkLogEvent.CUSTOM, message);
        result.confirm();
        return true;
    }

    public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
        MoPubLog.log(SdkLogEvent.CUSTOM, message);
        result.confirm();
        return true;
    }
}
