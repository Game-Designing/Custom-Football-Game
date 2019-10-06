package com.mopub.mraid;

import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;

/* renamed from: com.mopub.mraid.c */
/* compiled from: MraidBridge */
class C11486c extends WebChromeClient {

    /* renamed from: a */
    final /* synthetic */ MraidBridge f35563a;

    C11486c(MraidBridge this$0) {
        this.f35563a = this$0;
    }

    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        if (this.f35563a.f35485d != null) {
            return this.f35563a.f35485d.onJsAlert(message, result);
        }
        return super.onJsAlert(view, url, message, result);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (this.f35563a.f35485d != null) {
            return this.f35563a.f35485d.onConsoleMessage(consoleMessage);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public void onShowCustomView(View view, CustomViewCallback callback) {
        super.onShowCustomView(view, callback);
    }
}
