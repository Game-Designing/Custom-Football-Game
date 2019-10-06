package p019d.p143b.p144a.p146b;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.b.ta */
public class C7027ta extends WebViewClient {

    /* renamed from: a */
    private final C7267q f13109a;

    /* renamed from: b */
    private final C7262l f13110b;

    /* renamed from: c */
    private WeakReference<C7029ua> f13111c;

    public C7027ta(C7267q qVar) {
        this.f13109a = qVar;
        this.f13110b = qVar.mo23049b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22710a(WebView webView, String str) {
        C7262l lVar = this.f13110b;
        StringBuilder sb = new StringBuilder();
        sb.append("Processing click on ad URL \"");
        sb.append(str);
        sb.append("\"");
        String str2 = "WebViewButtonClient";
        lVar.mo22920d(str2, sb.toString());
        if (str != null && (webView instanceof C7025sa)) {
            C7025sa saVar = (C7025sa) webView;
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            String path = parse.getPath();
            C7029ua uaVar = (C7029ua) this.f13111c.get();
            if ("applovin".equalsIgnoreCase(scheme) && "com.applovin.sdk".equalsIgnoreCase(host) && uaVar != null) {
                if ("/track_click".equals(path)) {
                    uaVar.mo22566a(saVar);
                } else if ("/close_ad".equals(path)) {
                    uaVar.mo22567b(saVar);
                } else if ("/skip_ad".equals(path)) {
                    uaVar.mo22568c(saVar);
                } else {
                    C7262l lVar2 = this.f13110b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unknown URL: ");
                    sb2.append(str);
                    lVar2.mo22913a(str2, sb2.toString());
                    C7262l lVar3 = this.f13110b;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Path: ");
                    sb3.append(path);
                    lVar3.mo22913a(str2, sb3.toString());
                }
            }
        }
    }

    /* renamed from: a */
    public void mo22711a(WeakReference<C7029ua> weakReference) {
        this.f13111c = weakReference;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        mo22710a(webView, str);
        return true;
    }
}
