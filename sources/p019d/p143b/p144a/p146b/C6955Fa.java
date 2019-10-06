package p019d.p143b.p144a.p146b;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.b.Fa */
class C6955Fa extends WebChromeClient {

    /* renamed from: a */
    private final C7262l f12889a;

    public C6955Fa(C7267q qVar) {
        this.f12889a = qVar.mo23049b();
    }

    public void onConsoleMessage(String str, int i, String str2) {
        C7262l lVar = this.f12889a;
        StringBuilder sb = new StringBuilder();
        sb.append("console.log[");
        sb.append(i);
        sb.append("] :");
        sb.append(str);
        lVar.mo22913a("AdWebView", sb.toString());
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        StringBuilder sb = new StringBuilder();
        sb.append(consoleMessage.sourceId());
        String str = ": ";
        sb.append(str);
        sb.append(consoleMessage.lineNumber());
        sb.append(str);
        sb.append(consoleMessage.message());
        this.f12889a.mo22918c("AdWebView", sb.toString());
        return true;
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        C7262l lVar = this.f12889a;
        StringBuilder sb = new StringBuilder();
        sb.append("Alert attempted: ");
        sb.append(str2);
        lVar.mo22913a("AdWebView", sb.toString());
        return true;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        C7262l lVar = this.f12889a;
        StringBuilder sb = new StringBuilder();
        sb.append("JS onBeforeUnload attempted: ");
        sb.append(str2);
        lVar.mo22913a("AdWebView", sb.toString());
        return true;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        C7262l lVar = this.f12889a;
        StringBuilder sb = new StringBuilder();
        sb.append("JS confirm attempted: ");
        sb.append(str2);
        lVar.mo22913a("AdWebView", sb.toString());
        return true;
    }
}
