package com.fyber.inneractive.sdk.p179l;

import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.p159a.C7639a;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.l.e */
final class C7947e extends WebChromeClient {
    C7947e() {
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        StringBuilder sb = new StringBuilder("IAwebChromeClient onConsoleMessage: ");
        sb.append(consoleMessage.message());
        IAlog.m18019a(sb.toString());
        C7639a.m16877a(consoleMessage.message());
        return true;
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        StringBuilder sb = new StringBuilder("IAwebChromeClientonJsAlert: ");
        sb.append(str2);
        IAlog.m18019a(sb.toString());
        jsResult.cancel();
        return true;
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        StringBuilder sb = new StringBuilder("IAwebChromeClientonJsConfirm: ");
        sb.append(str2);
        IAlog.m18019a(sb.toString());
        jsResult.cancel();
        return true;
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        StringBuilder sb = new StringBuilder("IAwebChromeClientonJsPrompt: ");
        sb.append(str2);
        IAlog.m18019a(sb.toString());
        jsPromptResult.cancel();
        return true;
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        StringBuilder sb = new StringBuilder("IAwebChromeClientonJsBeforeUnload: ");
        sb.append(str2);
        IAlog.m18019a(sb.toString());
        jsResult.confirm();
        return true;
    }
}
