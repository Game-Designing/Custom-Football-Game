package com.moat.analytics.mobile.inm;

import android.view.ViewGroup;
import android.webkit.WebView;

/* renamed from: com.moat.analytics.mobile.inm.aa */
class C10933aa extends C10935b implements WebAdTracker {
    C10933aa(ViewGroup viewGroup) {
        this((WebView) C10934ab.m35960a(viewGroup, false).mo35881c(null));
        String str = "WebAdTracker";
        String str2 = "[ERROR] ";
        String str3 = "WebAdTracker initialization not successful, ";
        if (viewGroup == null) {
            String str4 = "Target ViewGroup is null";
            StringBuilder sb = new StringBuilder(str3);
            sb.append(str4);
            C10969p.m36114a(str2, 3, str, this, sb.toString());
            this.f33421a = new C10960m(str4);
        }
        if (this.f33422b == null) {
            String str5 = "No WebView to track inside of ad container";
            StringBuilder sb2 = new StringBuilder(str3);
            sb2.append(str5);
            C10969p.m36114a(str2, 3, str, this, sb2.toString());
            this.f33421a = new C10960m(str5);
        }
    }

    C10933aa(WebView webView) {
        super(webView, false, false);
        String str = "WebAdTracker";
        C10969p.m36113a(3, str, (Object) this, "Initializing.");
        if (webView == null) {
            String str2 = "WebView is null";
            StringBuilder sb = new StringBuilder("WebAdTracker initialization not successful, ");
            sb.append(str2);
            C10969p.m36114a("[ERROR] ", 3, str, this, sb.toString());
            this.f33421a = new C10960m(str2);
            return;
        }
        try {
            super.mo35887a(webView);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(mo35886a());
            sb2.append(" created for ");
            sb2.append(mo35897g());
            C10969p.m36116a("[SUCCESS] ", sb2.toString());
        } catch (C10960m e) {
            this.f33421a = e;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo35886a() {
        return "WebAdTracker";
    }
}
