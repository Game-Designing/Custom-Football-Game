package com.moat.analytics.mobile.sma;

import android.webkit.WebView;

/* renamed from: com.moat.analytics.mobile.sma.aa */
class C11077aa extends C11079b implements WebAdTracker {
    C11077aa(WebView webView) {
        super(webView, false, false);
        C11111p.m36577a(3, "WebAdTracker", (Object) this, "Initializing.");
        super.mo36182a(webView);
        StringBuilder sb = new StringBuilder();
        sb.append(mo36181a());
        sb.append(" created for ");
        sb.append(mo36188e());
        C11111p.m36579a("[SUCCESS] ", sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo36181a() {
        return "WebAdTracker";
    }
}
