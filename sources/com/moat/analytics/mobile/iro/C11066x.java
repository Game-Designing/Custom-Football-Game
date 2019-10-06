package com.moat.analytics.mobile.iro;

import android.view.ViewGroup;
import android.webkit.WebView;

/* renamed from: com.moat.analytics.mobile.iro.x */
final class C11066x extends C11015c implements WebAdTracker {
    C11066x(ViewGroup viewGroup) {
        this((WebView) C11064v.m36406(viewGroup, false).orElse(null));
        String str = "WebAdTracker";
        String str2 = "[ERROR] ";
        String str3 = "WebAdTracker initialization not successful, ";
        if (viewGroup == null) {
            String str4 = "Target ViewGroup is null";
            StringBuilder sb = new StringBuilder(str3);
            sb.append(str4);
            String sb2 = sb.toString();
            C11011b.m36234(3, str, this, sb2);
            C11011b.m36232(str2, sb2);
            this.f33652 = new C11043o(str4);
        }
        if (this.f33656 == null) {
            String str5 = "No WebView to track inside of ad container";
            StringBuilder sb3 = new StringBuilder(str3);
            sb3.append(str5);
            String sb4 = sb3.toString();
            C11011b.m36234(3, str, this, sb4);
            C11011b.m36232(str2, sb4);
            this.f33652 = new C11043o(str5);
        }
    }

    C11066x(WebView webView) {
        super(webView, false, false);
        String str = "WebAdTracker";
        C11011b.m36234(3, str, this, "Initializing.");
        if (webView == null) {
            String str2 = "WebView is null";
            StringBuilder sb = new StringBuilder("WebAdTracker initialization not successful, ");
            sb.append(str2);
            String sb2 = sb.toString();
            C11011b.m36234(3, str, this, sb2);
            C11011b.m36232("[ERROR] ", sb2);
            this.f33652 = new C11043o(str2);
            return;
        }
        try {
            super.mo36059(webView);
            StringBuilder sb3 = new StringBuilder("WebAdTracker created for ");
            sb3.append(mo36056());
            C11011b.m36232("[SUCCESS] ", sb3.toString());
        } catch (C11043o e) {
            this.f33652 = e;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ */
    public final String mo36057() {
        return "WebAdTracker";
    }
}
