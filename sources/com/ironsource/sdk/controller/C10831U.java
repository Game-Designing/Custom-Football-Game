package com.ironsource.sdk.controller;

import android.webkit.WebView;
import com.ironsource.sdk.controller.C10877y.C10880c;
import com.ironsource.sdk.data.C10897j;
import p019d.p273h.p285d.p295h.C13003f;

/* renamed from: com.ironsource.sdk.controller.U */
/* compiled from: IronSourceWebView */
class C10831U implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f33053a;

    /* renamed from: b */
    final /* synthetic */ C10880c f33054b;

    C10831U(C10880c this$1, String str) {
        this.f33054b = this$1;
        this.f33053a = str;
    }

    public void run() {
        try {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("moatAPI(");
            sb.append(this.f33053a);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10897j ssaObj = new C10897j(this.f33053a);
            C10851ga F = C10877y.this.f33185fa;
            String jVar = ssaObj.toString();
            C10881a aVar = new C10881a();
            C10877y yVar = C10877y.this;
            yVar.getWebview();
            F.mo35429a(jVar, aVar, (WebView) yVar);
        } catch (Exception e) {
            e.printStackTrace();
            String z2 = C10877y.this.f33192o;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moatAPI failed with exception ");
            sb2.append(e.getMessage());
            C13003f.m42438c(z2, sb2.toString());
        }
    }
}
