package com.moat.analytics.mobile.inm;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.inm.p227a.p229b.C10932a;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.inm.n */
class C10961n extends MoatFactory {
    C10961n() {
        if (!m36084a()) {
            String str = "Failed to initialize MoatFactory";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(", SDK was not started");
            C10969p.m36114a("[ERROR] ", 3, "Factory", this, sb.toString());
            throw new C10960m(str);
        }
    }

    /* renamed from: a */
    private NativeDisplayTracker m36079a(View view, final Map<String, String> map) {
        final WeakReference weakReference = new WeakReference(view);
        return (NativeDisplayTracker) C10994x.m36172a((C10996a<T>) new C10996a<NativeDisplayTracker>() {
            /* renamed from: a */
            public C10932a<NativeDisplayTracker> mo35863a() {
                View view = (View) weakReference.get();
                StringBuilder sb = new StringBuilder("Attempting to create NativeDisplayTracker for ");
                sb.append(C10969p.m36111a(view));
                C10969p.m36114a("[INFO] ", 3, "Factory", this, sb.toString());
                return C10932a.m35954a(new C10976t(view, map));
            }
        }, NativeDisplayTracker.class);
    }

    /* renamed from: a */
    private NativeVideoTracker m36080a(final String str) {
        return (NativeVideoTracker) C10994x.m36172a((C10996a<T>) new C10996a<NativeVideoTracker>() {
            /* renamed from: a */
            public C10932a<NativeVideoTracker> mo35863a() {
                C10969p.m36114a("[INFO] ", 3, "Factory", this, "Attempting to create NativeVideoTracker");
                return C10932a.m35954a(new C10977u(str));
            }
        }, NativeVideoTracker.class);
    }

    /* renamed from: a */
    private WebAdTracker m36081a(ViewGroup viewGroup) {
        final WeakReference weakReference = new WeakReference(viewGroup);
        return (WebAdTracker) C10994x.m36172a((C10996a<T>) new C10996a<WebAdTracker>() {
            /* renamed from: a */
            public C10932a<WebAdTracker> mo35863a() {
                ViewGroup viewGroup = (ViewGroup) weakReference.get();
                StringBuilder sb = new StringBuilder("Attempting to create WebAdTracker for adContainer ");
                sb.append(C10969p.m36111a((View) viewGroup));
                C10969p.m36114a("[INFO] ", 3, "Factory", this, sb.toString());
                return C10932a.m35954a(new C10933aa(viewGroup));
            }
        }, WebAdTracker.class);
    }

    /* renamed from: a */
    private WebAdTracker m36082a(WebView webView) {
        final WeakReference weakReference = new WeakReference(webView);
        return (WebAdTracker) C10994x.m36172a((C10996a<T>) new C10996a<WebAdTracker>() {
            /* renamed from: a */
            public C10932a<WebAdTracker> mo35863a() {
                WebView webView = (WebView) weakReference.get();
                StringBuilder sb = new StringBuilder("Attempting to create WebAdTracker for ");
                sb.append(C10969p.m36111a((View) webView));
                C10969p.m36114a("[INFO] ", 3, "Factory", this, sb.toString());
                return C10932a.m35954a(new C10933aa(webView));
            }
        }, WebAdTracker.class);
    }

    /* renamed from: a */
    private <T> T m36083a(MoatPlugin<T> moatPlugin) {
        return moatPlugin.mo35833a();
    }

    /* renamed from: a */
    private boolean m36084a() {
        return ((C10958k) MoatAnalytics.getInstance()).mo35952a();
    }

    public <T> T createCustomTracker(MoatPlugin<T> moatPlugin) {
        try {
            return m36083a(moatPlugin);
        } catch (Exception e) {
            C10960m.m36077a(e);
            return moatPlugin.mo35834b();
        }
    }

    public NativeDisplayTracker createNativeDisplayTracker(View view, Map<String, String> map) {
        try {
            return m36079a(view, map);
        } catch (Exception e) {
            C10960m.m36077a(e);
            return new C10981c();
        }
    }

    public NativeVideoTracker createNativeVideoTracker(String str) {
        try {
            return m36080a(str);
        } catch (Exception e) {
            C10960m.m36077a(e);
            return new C10982d();
        }
    }

    public WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
        try {
            return m36081a(viewGroup);
        } catch (Exception e) {
            C10960m.m36077a(e);
            return new C10983e();
        }
    }

    public WebAdTracker createWebAdTracker(WebView webView) {
        try {
            return m36082a(webView);
        } catch (Exception e) {
            C10960m.m36077a(e);
            return new C10983e();
        }
    }
}
