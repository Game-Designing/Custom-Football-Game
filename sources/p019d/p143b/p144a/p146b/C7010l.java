package p019d.p143b.p144a.p146b;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.net.Uri;
import android.view.ViewParent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.adview.C5856b;
import p019d.p143b.p144a.p145a.C6925a;
import p019d.p143b.p144a.p145a.C6930f;
import p019d.p143b.p144a.p145a.C6938n;
import p019d.p143b.p144a.p147c.C7086Lb;
import p019d.p143b.p144a.p147c.C7142c;
import p019d.p143b.p144a.p147c.C7171ja;
import p019d.p143b.p144a.p147c.C7212tb;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.b.l */
class C7010l extends WebViewClient {

    /* renamed from: a */
    private final C7267q f13036a;

    /* renamed from: b */
    private final C7262l f13037b;

    /* renamed from: c */
    private final C6988a f13038c;

    public C7010l(C6988a aVar, C7267q qVar) {
        this.f13036a = qVar;
        this.f13037b = qVar.mo23049b();
        this.f13038c = aVar;
    }

    /* renamed from: a */
    private void m14455a(Uri uri, C6957Ga ga) {
        C7262l lVar;
        String str;
        String str2 = "AdWebViewClient";
        try {
            String queryParameter = uri.getQueryParameter("n");
            if (C7269s.m15819a(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("load_type");
                if ("external".equalsIgnoreCase(queryParameter2)) {
                    C7262l lVar2 = this.f13037b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Loading new page externally: ");
                    sb.append(queryParameter);
                    lVar2.mo22918c(str2, sb.toString());
                    C7269s.m15818a(ga.getContext(), Uri.parse(queryParameter), (C7142c) this.f13036a);
                    C7171ja.m15286c(this.f13038c.mo22589h(), this.f13038c.mo22591j(), this.f13038c.mo22592k(), this.f13036a);
                    return;
                } else if ("internal".equalsIgnoreCase(queryParameter2)) {
                    C7262l lVar3 = this.f13037b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Loading new page in WebView: ");
                    sb2.append(queryParameter);
                    lVar3.mo22918c(str2, sb2.toString());
                    ga.loadUrl(queryParameter);
                    String queryParameter3 = uri.getQueryParameter("bg_color");
                    if (C7269s.m15819a(queryParameter3)) {
                        ga.setBackgroundColor(Color.parseColor(queryParameter3));
                        return;
                    }
                    return;
                } else {
                    lVar = this.f13037b;
                    str = "Could not find load type in original uri";
                }
            } else {
                lVar = this.f13037b;
                str = "Could not find url to load from query in original uri";
            }
            lVar.mo22916b(str2, str);
        } catch (Throwable th) {
            this.f13037b.mo22916b(str2, "Failed to load new page from query in original uri");
        }
    }

    /* renamed from: a */
    private void m14456a(C6925a aVar, C6957Ga ga) {
        C6930f ra = aVar.mo22411ra();
        if (ra != null) {
            C6938n.m14212a(ra.mo22433c(), (C7142c) this.f13038c.mo22593l());
            m14457a(ga, ra.mo22431a());
        }
    }

    /* renamed from: a */
    private void m14457a(C6957Ga ga, Uri uri) {
        C7251a a = ga.mo22528a();
        String b = ga.mo22533b();
        C5856b k = this.f13038c.mo22592k();
        if (k == null || a == null) {
            C7262l lVar = this.f13037b;
            StringBuilder sb = new StringBuilder();
            sb.append("Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = ");
            sb.append(uri);
            lVar.mo22916b("AdWebViewClient", sb.toString());
            return;
        }
        C7086Lb c = ga.mo22534c();
        if (c != null) {
            c.mo22886b();
        }
        this.f13038c.mo22581a(a, b, k, uri);
    }

    /* renamed from: c */
    private void m14458c(C6957Ga ga) {
        this.f13038c.mo22588g();
    }

    /* renamed from: d */
    private void m14459d(C6957Ga ga) {
        this.f13038c.mo22586e();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22629a(C6957Ga ga) {
        ViewParent parent = ga.getParent();
        if (parent instanceof C5856b) {
            ((C5856b) parent).mo18300b();
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x016a, code lost:
        if (r7.mo22413ta() != false) goto L_0x00a5;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo22630a(android.webkit.WebView r10, java.lang.String r11, boolean r12) {
        /*
            r9 = this;
            d.b.d.l r0 = r9.f13037b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Processing click on ad URL \""
            r1.append(r2)
            r1.append(r11)
            java.lang.String r2 = "\""
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "AdWebViewClient"
            r0.mo22920d(r2, r1)
            r0 = 1
            if (r11 == 0) goto L_0x017c
            boolean r1 = r10 instanceof p019d.p143b.p144a.p146b.C6957Ga
            if (r1 == 0) goto L_0x017c
            android.net.Uri r1 = android.net.Uri.parse(r11)
            r3 = r10
            d.b.a.b.Ga r3 = (p019d.p143b.p144a.p146b.C6957Ga) r3
            java.lang.String r4 = r1.getScheme()
            java.lang.String r5 = r1.getHost()
            java.lang.String r6 = r1.getPath()
            d.b.a.b.a r7 = r9.f13038c
            d.b.d.a r7 = r7.mo22591j()
            java.lang.String r8 = "applovin"
            boolean r8 = r8.equals(r4)
            if (r8 == 0) goto L_0x0131
            java.lang.String r8 = "com.applovin.sdk"
            boolean r8 = r8.equals(r5)
            if (r8 == 0) goto L_0x0131
            java.lang.String r12 = "/adservice/next_ad"
            boolean r12 = r12.equals(r6)
            if (r12 == 0) goto L_0x005a
            r9.mo22629a(r3)
            goto L_0x017c
        L_0x005a:
            java.lang.String r12 = "/adservice/close_ad"
            boolean r12 = r12.equals(r6)
            if (r12 == 0) goto L_0x0067
            r9.mo22631b(r3)
            goto L_0x017c
        L_0x0067:
            java.lang.String r12 = "/adservice/expand_ad"
            boolean r12 = r12.equals(r6)
            if (r12 == 0) goto L_0x0074
            r9.m14458c(r3)
            goto L_0x017c
        L_0x0074:
            java.lang.String r12 = "/adservice/contract_ad"
            boolean r12 = r12.equals(r6)
            if (r12 == 0) goto L_0x0081
            r9.m14459d(r3)
            goto L_0x017c
        L_0x0081:
            java.lang.String r12 = p019d.p143b.p144a.p147c.C7134a.f13430a
            boolean r12 = r12.equals(r6)
            if (r12 == 0) goto L_0x008a
            return r0
        L_0x008a:
            java.lang.String r12 = p019d.p143b.p144a.p147c.C7134a.f13433d
            boolean r12 = r12.equals(r6)
            if (r12 == 0) goto L_0x0097
            r9.m14455a(r1, r3)
            goto L_0x017c
        L_0x0097:
            java.lang.String r12 = p019d.p143b.p144a.p147c.C7134a.f13431b
            boolean r12 = r12.equals(r6)
            if (r12 == 0) goto L_0x00b5
            boolean r10 = r7 instanceof p019d.p143b.p144a.p145a.C6925a
            if (r10 == 0) goto L_0x00aa
            d.b.a.a.a r7 = (p019d.p143b.p144a.p145a.C6925a) r7
        L_0x00a5:
            r9.m14456a(r7, r3)
            goto L_0x017c
        L_0x00aa:
            java.lang.String r10 = p019d.p143b.p144a.p147c.C7134a.f13431b
            android.net.Uri r10 = android.net.Uri.parse(r10)
            r9.m14457a(r3, r10)
            goto L_0x017c
        L_0x00b5:
            if (r6 == 0) goto L_0x0104
            java.lang.String r12 = "/launch/"
            boolean r12 = r6.startsWith(r12)
            if (r12 == 0) goto L_0x0104
            java.util.List r11 = r1.getPathSegments()
            if (r11 == 0) goto L_0x017c
            int r12 = r11.size()
            if (r12 <= r0) goto L_0x017c
            int r12 = r11.size()
            int r12 = r12 - r0
            java.lang.Object r11 = r11.get(r12)
            java.lang.String r11 = (java.lang.String) r11
            android.content.Context r10 = r10.getContext()     // Catch:{ Exception -> 0x00eb }
            android.content.pm.PackageManager r12 = r10.getPackageManager()     // Catch:{ Exception -> 0x00eb }
            android.content.Intent r12 = r12.getLaunchIntentForPackage(r11)     // Catch:{ Exception -> 0x00eb }
            r10.startActivity(r12)     // Catch:{ Exception -> 0x00eb }
            r10 = 0
            r9.m14457a(r3, r10)     // Catch:{ Exception -> 0x00eb }
            goto L_0x017c
        L_0x00eb:
            r10 = move-exception
            d.b.d.l r12 = r9.f13037b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Threw Exception Trying to Launch App for Package: "
            r1.append(r3)
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r12.mo22917b(r2, r11, r10)
            goto L_0x017c
        L_0x0104:
            d.b.d.l r10 = r9.f13037b
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r1 = "Unknown URL: "
            r12.append(r1)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            r10.mo22913a(r2, r11)
            d.b.d.l r10 = r9.f13037b
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Path: "
            r11.append(r12)
            r11.append(r6)
            java.lang.String r11 = r11.toString()
            r10.mo22913a(r2, r11)
            goto L_0x017c
        L_0x0131:
            if (r12 == 0) goto L_0x017a
            boolean r10 = r7 instanceof p019d.p143b.p144a.p147c.C7234z
            if (r10 == 0) goto L_0x0172
            r10 = r7
            d.b.a.c.z r10 = (p019d.p143b.p144a.p147c.C7234z) r10
            java.util.List r11 = r10.mo23428ca()
            java.util.List r10 = r10.mo23429da()
            boolean r12 = r11.isEmpty()
            if (r12 != 0) goto L_0x014e
            boolean r11 = r11.contains(r4)
            if (r11 == 0) goto L_0x015b
        L_0x014e:
            boolean r11 = r10.isEmpty()
            if (r11 != 0) goto L_0x0160
            boolean r10 = r10.contains(r5)
            if (r10 == 0) goto L_0x015b
            goto L_0x0160
        L_0x015b:
            d.b.d.l r10 = r9.f13037b
            java.lang.String r11 = "URL is not whitelisted - bypassing click"
            goto L_0x0176
        L_0x0160:
            boolean r10 = r7 instanceof p019d.p143b.p144a.p145a.C6925a
            if (r10 == 0) goto L_0x016e
            d.b.a.a.a r7 = (p019d.p143b.p144a.p145a.C6925a) r7
            boolean r10 = r7.mo22413ta()
            if (r10 == 0) goto L_0x016e
            goto L_0x00a5
        L_0x016e:
            r9.m14457a(r3, r1)
            goto L_0x017c
        L_0x0172:
            d.b.d.l r10 = r9.f13037b
            java.lang.String r11 = "Bypassing click for ad of invalid type"
        L_0x0176:
            r10.mo22916b(r2, r11)
            goto L_0x017c
        L_0x017a:
            r10 = 0
            return r10
        L_0x017c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p143b.p144a.p146b.C7010l.mo22630a(android.webkit.WebView, java.lang.String, boolean):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo22631b(C6957Ga ga) {
        this.f13038c.mo22585d();
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f13038c.mo22578a(webView);
    }

    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        boolean hasGesture = new C7212tb(this.f13036a).mo23270L() ? webResourceRequest.hasGesture() : true;
        Uri url = webResourceRequest.getUrl();
        if (url != null) {
            return mo22630a(webView, url.toString(), hasGesture);
        }
        this.f13037b.mo22916b("AdWebViewClient", "No url found for request");
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return mo22630a(webView, str, true);
    }
}
