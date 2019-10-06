package com.fyber.inneractive.sdk.util;

import android.view.WindowManager;
import android.webkit.WebView;

/* renamed from: com.fyber.inneractive.sdk.util.ae */
public final class C7991ae {

    /* renamed from: a */
    private static boolean f16312a = false;

    /* renamed from: b */
    private static WebView f16313b = null;

    /* renamed from: c */
    private static WindowManager f16314c;

    /* renamed from: a */
    public static void m18036a() {
        f16312a = false;
        if (f16314c != null) {
            WebView webView = f16313b;
            if (!(webView == null || webView.getParent() == null)) {
                try {
                    f16314c.removeView(f16313b);
                    IAlog.m18019a("KitKatWebViewUtils | removed static webview from window");
                } catch (Exception e) {
                }
            }
        }
        WebView webView2 = f16313b;
        if (webView2 != null) {
            try {
                webView2.destroy();
                IAlog.m18019a("KitKatWebViewUtils | destroyed static webview");
            } catch (Exception e2) {
            }
        }
        f16314c = null;
        f16313b = null;
    }
}
