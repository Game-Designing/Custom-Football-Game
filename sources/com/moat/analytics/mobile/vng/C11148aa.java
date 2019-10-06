package com.moat.analytics.mobile.vng;

import android.webkit.WebView;

/* renamed from: com.moat.analytics.mobile.vng.aa */
class C11148aa extends C11153b implements WebAdTracker {
    C11148aa(WebView webView) {
        super(webView, false, false);
        C11185p.m36817a(3, "WebAdTracker", (Object) this, "In initialization method.");
        super.mo36317a(webView);
        StringBuilder sb = new StringBuilder();
        sb.append(mo36311a());
        sb.append(" created for ");
        sb.append(mo36323e());
        C11185p.m36819a("[SUCCESS] ", sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo36311a() {
        return "WebAdTracker";
    }
}
