package com.smaato.soma.p236a;

import android.webkit.WebView;
import com.smaato.soma.C12398ha;

/* renamed from: com.smaato.soma.a.o */
/* compiled from: AbstractBannerPackage */
class C12128o extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ WebView f38036a;

    /* renamed from: b */
    final /* synthetic */ C12127b f38037b;

    C12128o(C12127b this$1, WebView webView) {
        this.f38037b = this$1;
        this.f38036a = webView;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Void process() throws java.lang.Exception {
        /*
            r5 = this;
            com.smaato.soma.b.e r0 = new com.smaato.soma.b.e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Page Finished Loading... "
            r1.append(r2)
            com.smaato.soma.a.n$b r2 = r5.f38037b
            com.smaato.soma.c.h.e r2 = r2.f38033d
            com.smaato.soma.c.h.e$a r2 = r2.mo39655a()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.smaato.soma.b.a r2 = com.smaato.soma.p238b.C12143a.DEBUG
            java.lang.String r3 = "Banner_Package"
            r4 = 1
            r0.<init>(r3, r1, r4, r2)
            com.smaato.soma.p238b.C12146d.m39965a(r0)
            com.smaato.soma.a.n$b r0 = r5.f38037b
            com.smaato.soma.a.n r0 = com.smaato.soma.p236a.C12125n.this
            com.smaato.soma.fa r0 = r0.f38029l
            boolean r1 = r0 instanceof com.smaato.soma.C12042D
            if (r1 == 0) goto L_0x0037
            com.smaato.soma.c.h.b r0 = r0.getBannerState()
            r0.mo39643d()
        L_0x0037:
            com.smaato.soma.a.n$b r0 = r5.f38037b
            com.smaato.soma.c.h.e r0 = r0.f38033d
            com.smaato.soma.c.h.e$a r0 = r0.mo39655a()
            com.smaato.soma.c.h.e$a r1 = com.smaato.soma.p239c.p251h.C12271e.C12272a.STATE_BANNERLOADING
            if (r0 != r1) goto L_0x0053
            com.smaato.soma.a.n$b r0 = r5.f38037b
            com.smaato.soma.a.n r1 = com.smaato.soma.p236a.C12125n.this
            com.smaato.soma.fa r1 = r1.f38029l
            boolean r1 = r1 instanceof com.smaato.soma.interstitial.C12428r
            if (r1 == 0) goto L_0x0053
            com.smaato.soma.c.h.e r0 = r0.f38033d
            r0.mo39661d()
            goto L_0x0062
        L_0x0053:
            com.smaato.soma.a.n$b r0 = r5.f38037b
            com.smaato.soma.a.n r1 = com.smaato.soma.p236a.C12125n.this
            com.smaato.soma.fa r1 = r1.f38029l
            boolean r1 = r1 instanceof com.smaato.soma.interstitial.C12428r
            if (r1 != 0) goto L_0x0062
            com.smaato.soma.c.h.e r0 = r0.f38033d
            r0.mo39661d()
        L_0x0062:
            android.webkit.WebView r0 = r5.f38036a
            if (r0 == 0) goto L_0x006d
            java.lang.String r1 = "javascript:(function() {  var metaTags = document.getElementsByTagName('meta');  var results = [];  for (var i = 0; i < metaTags.length; i++) {    var property = metaTags[i].getAttribute('property');    if (property && property.substring(0, 'al:'.length) === 'al:') {      var tag = { \"property\": metaTags[i].getAttribute('property') };      if (metaTags[i].hasAttribute('content')) {        tag['content'] = metaTags[i].getAttribute('content');      }      results.push(tag);    }  }  window.HTMLOUT.processJSON(JSON.stringify(results));})()"
            r0.loadUrl(r1)     // Catch:{ Exception -> 0x006c }
            goto L_0x006d
        L_0x006c:
            r0 = move-exception
        L_0x006d:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smaato.soma.p236a.C12128o.process():java.lang.Void");
    }
}
