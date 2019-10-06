package com.ironsource.sdk.controller;

import android.os.Build.VERSION;
import p019d.p273h.p285d.p295h.C12999b;
import p019d.p273h.p285d.p295h.C13003f;

/* renamed from: com.ironsource.sdk.controller.m */
/* compiled from: IronSourceWebView */
class C10864m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f33126a;

    /* renamed from: b */
    final /* synthetic */ StringBuilder f33127b;

    /* renamed from: c */
    final /* synthetic */ C10877y f33128c;

    C10864m(C10877y this$0, String str, StringBuilder sb) {
        this.f33128c = this$0;
        this.f33126a = str;
        this.f33127b = sb;
    }

    public void run() {
        String str = " ";
        C13003f.m42438c(this.f33128c.f33192o, this.f33126a);
        try {
            if (this.f33128c.f33176T != null) {
                if (this.f33128c.f33176T.booleanValue()) {
                    this.f33128c.m35524g(this.f33127b.toString());
                } else {
                    this.f33128c.loadUrl(this.f33126a);
                }
            } else if (VERSION.SDK_INT >= 19) {
                this.f33128c.m35524g(this.f33127b.toString());
                this.f33128c.f33176T = Boolean.valueOf(true);
            } else {
                this.f33128c.loadUrl(this.f33126a);
                this.f33128c.f33176T = Boolean.valueOf(false);
            }
        } catch (NoSuchMethodError e) {
            String z = this.f33128c.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("evaluateJavascrip NoSuchMethodError: SDK version=");
            sb.append(VERSION.SDK_INT);
            sb.append(str);
            sb.append(e);
            C13003f.m42437b(z, sb.toString());
            this.f33128c.loadUrl(this.f33126a);
            this.f33128c.f33176T = Boolean.valueOf(false);
        } catch (Throwable t) {
            String z2 = this.f33128c.f33192o;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("injectJavascript: ");
            sb2.append(t.toString());
            C13003f.m42437b(z2, sb2.toString());
            new C12999b().execute(new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=injectJavaScript"});
        }
    }
}
