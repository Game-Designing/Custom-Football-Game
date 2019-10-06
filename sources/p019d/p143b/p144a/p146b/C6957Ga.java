package p019d.p143b.p144a.p146b;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import p019d.p143b.p144a.p145a.C6925a;
import p019d.p143b.p144a.p145a.C6930f;
import p019d.p143b.p144a.p145a.C6933i;
import p019d.p143b.p144a.p145a.C6934j;
import p019d.p143b.p144a.p147c.C7043Ac;
import p019d.p143b.p144a.p147c.C7052D;
import p019d.p143b.p144a.p147c.C7086Lb;
import p019d.p143b.p144a.p147c.C7182m;
import p019d.p143b.p144a.p147c.C7209sc;
import p019d.p143b.p144a.p147c.C7212tb;
import p019d.p143b.p144a.p147c.C7213tc;
import p019d.p143b.p144a.p147c.C7234z;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.b.Ga */
class C6957Ga extends WebView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C7262l f12891a;

    /* renamed from: b */
    private final C7267q f12892b;

    /* renamed from: c */
    private C7086Lb f12893c;

    /* renamed from: d */
    private C7251a f12894d = null;

    /* renamed from: e */
    private String f12895e = null;

    /* renamed from: f */
    private boolean f12896f = false;

    C6957Ga(C7010l lVar, C7267q qVar, Context context) {
        super(context);
        if (qVar != null) {
            this.f12892b = qVar;
            this.f12891a = qVar.mo23049b();
            setBackgroundColor(0);
            WebSettings settings = getSettings();
            settings.setSupportMultipleWindows(false);
            settings.setJavaScriptEnabled(true);
            setWebViewClient(lVar);
            setWebChromeClient(new C6955Fa(qVar));
            setVerticalScrollBarEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setScrollBarStyle(33554432);
            setOnTouchListener(new C6959Ha(this));
            setOnLongClickListener(new C6980Sa(this));
            return;
        }
        throw new IllegalArgumentException("No sdk specified.");
    }

    /* renamed from: a */
    private String m14349a(String str, String str2, String str3) {
        if (C7269s.m15819a(str)) {
            return C7209sc.m15470a(str3, str).replace("{SOURCE}", str2);
        }
        return null;
    }

    /* renamed from: a */
    private void m14350a(C7234z zVar) {
        try {
            if (new C7212tb(this.f12892b).mo23303j() || zVar.mo23419Y()) {
                m14351a((Runnable) new C6996e(this));
            }
            if (C7182m.m15327e()) {
                m14351a((Runnable) new C6998f(this, zVar));
            }
            if (C7182m.m15328f() && zVar.mo23425aa()) {
                m14351a((Runnable) new C7000g(this));
            }
            C7213tc ba = zVar.mo23427ba();
            if (ba != null) {
                WebSettings settings = getSettings();
                PluginState b = ba.mo23330b();
                if (b != null) {
                    m14351a((Runnable) new C7002h(this, settings, b));
                }
                Boolean c = ba.mo23331c();
                if (c != null) {
                    m14351a((Runnable) new C7004i(this, settings, c));
                }
                Boolean d = ba.mo23332d();
                if (d != null) {
                    m14351a((Runnable) new C7006j(this, settings, d));
                }
                Boolean e = ba.mo23333e();
                if (e != null) {
                    m14351a((Runnable) new C7008k(this, settings, e));
                }
                Boolean f = ba.mo23334f();
                if (f != null) {
                    m14351a((Runnable) new C6961Ia(this, settings, f));
                }
                Boolean g = ba.mo23335g();
                if (g != null) {
                    m14351a((Runnable) new C6963Ja(this, settings, g));
                }
                Boolean h = ba.mo23336h();
                if (h != null) {
                    m14351a((Runnable) new C6965Ka(this, settings, h));
                }
                Boolean i = ba.mo23337i();
                if (i != null) {
                    m14351a((Runnable) new C6967La(this, settings, i));
                }
                Boolean j = ba.mo23338j();
                if (j != null) {
                    m14351a((Runnable) new C6969Ma(this, settings, j));
                }
                Boolean k = ba.mo23339k();
                if (k != null) {
                    m14351a((Runnable) new C6971Na(this, settings, k));
                }
                if (C7182m.m15326d()) {
                    Boolean l = ba.mo23340l();
                    if (l != null) {
                        m14351a((Runnable) new C6973Oa(this, settings, l));
                    }
                    Boolean m = ba.mo23341m();
                    if (m != null) {
                        m14351a((Runnable) new C6975Pa(this, settings, m));
                    }
                }
                if (C7182m.m15329g()) {
                    Integer a = ba.mo23329a();
                    if (a != null) {
                        m14351a((Runnable) new C6977Qa(this, settings, a));
                    }
                }
                if (C7182m.m15330h()) {
                    Boolean n = ba.mo23342n();
                    if (n != null) {
                        m14351a((Runnable) new C6978Ra(this, settings, n));
                    }
                }
            }
        } catch (Throwable th) {
            this.f12891a.mo22917b("AdWebView", "Unable to apply WebView settings", th);
        }
    }

    /* renamed from: a */
    private void m14351a(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            this.f12891a.mo22917b("AdWebView", "Unable to apply WebView setting", th);
        }
    }

    /* renamed from: a */
    private void m14352a(String str, String str2, String str3, String str4, C7267q qVar) {
        String a = m14349a(str3, str, str4);
        String str5 = "Rendering webview for VAST ad with resourceContents : ";
        String str6 = "AdWebView";
        if (C7269s.m15819a(a)) {
            C7262l lVar = this.f12891a;
            StringBuilder sb = new StringBuilder();
            sb.append(str5);
            sb.append(a);
            lVar.mo22918c(str6, sb.toString());
            loadDataWithBaseURL(str2, a, "text/html", null, "");
            return;
        }
        String a2 = m14349a(new C7212tb(qVar).mo23327y(), str, str4);
        if (C7269s.m15819a(a2)) {
            C7262l lVar2 = this.f12891a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str5);
            sb2.append(a2);
            lVar2.mo22918c(str6, sb2.toString());
            loadDataWithBaseURL(str2, a2, "text/html", null, "");
            return;
        }
        C7262l lVar3 = this.f12891a;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Rendering webview for VAST ad with resourceURL : ");
        sb3.append(str);
        lVar3.mo22918c(str6, sb3.toString());
        loadUrl(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C7251a mo22528a() {
        return this.f12894d;
    }

    /* renamed from: a */
    public void mo22529a(C7086Lb lb) {
        this.f12893c = lb;
    }

    /* renamed from: a */
    public void mo22530a(C7251a aVar, String str) {
        C7262l lVar;
        String str2;
        C7262l lVar2;
        String str3;
        String str4;
        String Z;
        String str5;
        String str6;
        String str7;
        String Z2;
        C7267q qVar;
        String str8 = "AdWebView";
        if (!this.f12896f) {
            this.f12894d = aVar;
            this.f12895e = str;
            try {
                if (aVar instanceof C7052D) {
                    loadDataWithBaseURL("/", ((C7052D) aVar).mo22780c(), "text/html", null, "");
                    lVar = this.f12891a;
                    str2 = "Empty ad rendered";
                } else {
                    C7234z zVar = (C7234z) aVar;
                    m14350a(zVar);
                    if (zVar.mo23412R()) {
                        setVisibility(0);
                    }
                    if (aVar instanceof C7043Ac) {
                        loadDataWithBaseURL(zVar.mo23420Z(), C7209sc.m15470a(str, ((C7043Ac) aVar).mo22740oa()), "text/html", null, "");
                        lVar = this.f12891a;
                        str2 = "AppLovinAd rendered";
                    } else if (aVar instanceof C6925a) {
                        C6925a aVar2 = (C6925a) aVar;
                        C6930f ra = aVar2.mo22411ra();
                        if (ra != null) {
                            C6933i b = ra.mo22432b();
                            Uri b2 = b.mo22451b();
                            String uri = b2 != null ? b2.toString() : "";
                            String c = b.mo22452c();
                            String ua = aVar2.mo22415ua();
                            C7212tb tbVar = new C7212tb(this.f12892b);
                            if (!C7269s.m15819a(uri)) {
                                if (!C7269s.m15819a(c)) {
                                    lVar2 = this.f12891a;
                                    str3 = "Unable to load companion ad. No resources provided.";
                                    lVar2.mo22916b(str8, str3);
                                    return;
                                }
                            }
                            if (b.mo22448a() == C6934j.STATIC) {
                                this.f12891a.mo22918c(str8, "Rendering WebView for static VAST ad");
                                loadDataWithBaseURL(zVar.mo23420Z(), m14349a(tbVar.mo23326x(), uri, str), "text/html", null, "");
                                return;
                            }
                            if (b.mo22448a() == C6934j.HTML) {
                                if (C7269s.m15819a(c)) {
                                    String a = m14349a(ua, c, str);
                                    str4 = C7269s.m15819a(a) ? a : c;
                                    C7262l lVar3 = this.f12891a;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Rendering WebView for HTML VAST ad with resourceContents: ");
                                    sb.append(str4);
                                    lVar3.mo22918c(str8, sb.toString());
                                    Z = zVar.mo23420Z();
                                    str5 = "text/html";
                                    str6 = null;
                                    str7 = "";
                                } else if (C7269s.m15819a(uri)) {
                                    this.f12891a.mo22918c(str8, "Preparing to load HTML VAST ad resourceUri");
                                    Z2 = zVar.mo23420Z();
                                    qVar = this.f12892b;
                                    m14352a(uri, Z2, ua, str, qVar);
                                    return;
                                } else {
                                    return;
                                }
                            } else if (b.mo22448a() != C6934j.IFRAME) {
                                lVar2 = this.f12891a;
                                str3 = "Failed to render VAST companion ad of invalid type";
                                lVar2.mo22916b(str8, str3);
                                return;
                            } else if (C7269s.m15819a(uri)) {
                                this.f12891a.mo22918c(str8, "Preparing to load iFrame VAST ad resourceUri");
                                Z2 = zVar.mo23420Z();
                                qVar = this.f12892b;
                                m14352a(uri, Z2, ua, str, qVar);
                                return;
                            } else if (C7269s.m15819a(c)) {
                                String a2 = m14349a(ua, c, str);
                                str4 = C7269s.m15819a(a2) ? a2 : c;
                                C7262l lVar4 = this.f12891a;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Rendering WebView for iFrame VAST ad with resourceContents: ");
                                sb2.append(str4);
                                lVar4.mo22918c(str8, sb2.toString());
                                Z = zVar.mo23420Z();
                                str5 = "text/html";
                                str6 = null;
                                str7 = "";
                            } else {
                                return;
                            }
                            loadDataWithBaseURL(Z, str4, str5, str6, str7);
                            return;
                        }
                        lVar = this.f12891a;
                        str2 = "No companion ad provided.";
                    } else {
                        return;
                    }
                }
                lVar.mo22918c(str8, str2);
            } catch (Throwable th) {
                C7262l lVar5 = this.f12891a;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unable to render AppLovinAd with placement = \"");
                sb3.append(str);
                sb3.append("\"");
                lVar5.mo22917b(str8, sb3.toString(), th);
            }
        } else {
            this.f12891a.mo22921e(str8, "Ad can not be loaded in a destroyed webview");
        }
    }

    /* renamed from: a */
    public void mo22531a(String str) {
        mo22532a(str, (Runnable) null);
    }

    /* renamed from: a */
    public void mo22532a(String str, Runnable runnable) {
        String str2 = "AdWebView";
        try {
            C7262l lVar = this.f12891a;
            StringBuilder sb = new StringBuilder();
            sb.append("Forwarding \"");
            sb.append(str);
            sb.append("\" to ad template");
            lVar.mo22918c(str2, sb.toString());
            loadUrl(str);
        } catch (Throwable th) {
            this.f12891a.mo22917b(str2, "Unable to forward to template", th);
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo22533b() {
        return this.f12895e;
    }

    /* renamed from: c */
    public C7086Lb mo22534c() {
        return this.f12893c;
    }

    public void computeScroll() {
    }

    public void destroy() {
        String str = "AdWebView";
        this.f12896f = true;
        try {
            super.destroy();
            this.f12891a.mo22918c(str, "Web view destroyed");
        } catch (Throwable th) {
            C7262l lVar = this.f12891a;
            if (lVar != null) {
                lVar.mo22917b(str, "destroy() threw exception", th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        try {
            super.onFocusChanged(z, i, rect);
        } catch (Exception e) {
            this.f12891a.mo22917b("AdWebView", "onFocusChanged() threw exception", e);
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
    }

    public void onWindowFocusChanged(boolean z) {
        try {
            super.onWindowFocusChanged(z);
        } catch (Exception e) {
            this.f12891a.mo22917b("AdWebView", "onWindowFocusChanged() threw exception", e);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        try {
            super.onWindowVisibilityChanged(i);
        } catch (Exception e) {
            this.f12891a.mo22917b("AdWebView", "onWindowVisibilityChanged() threw exception", e);
        }
    }

    public boolean requestFocus(int i, Rect rect) {
        try {
            return super.requestFocus(i, rect);
        } catch (Exception e) {
            this.f12891a.mo22917b("AdWebView", "requestFocus() threw exception", e);
            return false;
        }
    }

    public void scrollTo(int i, int i2) {
    }
}
