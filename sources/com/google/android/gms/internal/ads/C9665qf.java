package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebView;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;

@zzard
/* renamed from: com.google.android.gms.internal.ads.qf */
final class C9665qf {
    @VisibleForTesting

    /* renamed from: a */
    private static Boolean f22897a;

    private C9665qf() {
    }

    @TargetApi(19)
    /* renamed from: a */
    private static boolean m24042a(WebView webView) {
        boolean booleanValue;
        synchronized (C9665qf.class) {
            if (f22897a == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", null);
                    f22897a = Boolean.valueOf(true);
                } catch (IllegalStateException e) {
                    f22897a = Boolean.valueOf(false);
                }
            }
            booleanValue = f22897a.booleanValue();
        }
        return booleanValue;
    }

    @TargetApi(19)
    /* renamed from: a */
    static void m24041a(WebView webView, String str) {
        if (!PlatformVersion.m22112f() || !m24042a(webView)) {
            String str2 = "javascript:";
            String valueOf = String.valueOf(str);
            webView.loadUrl(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return;
        }
        webView.evaluateJavascript(str, null);
    }
}
