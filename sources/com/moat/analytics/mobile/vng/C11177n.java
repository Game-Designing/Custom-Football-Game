package com.moat.analytics.mobile.vng;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.vng.p233a.p234a.C11146a;
import com.moat.analytics.mobile.vng.p233a.p235b.C11147a;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.vng.n */
class C11177n extends MoatFactory {
    C11177n() {
        if (!m36789a()) {
            C11185p.m36817a(3, "Factory", (Object) this, "Failed to initialize MoatFactory. Please check that you've initialized the Moat SDK correctly.");
            C11185p.m36819a("[ERROR] ", "Failed to initialize MoatFactory, SDK was not started");
            throw new C11176m();
        }
    }

    /* renamed from: a */
    private NativeDisplayTracker m36784a(View view, final Map<String, String> map) {
        C11146a.m36681a(view);
        C11146a.m36681a(map);
        final WeakReference weakReference = new WeakReference(view);
        return (NativeDisplayTracker) C11208x.m36866a((C11210a<T>) new C11210a<NativeDisplayTracker>() {
            /* renamed from: a */
            public C11147a<NativeDisplayTracker> mo36294a() {
                View view = (View) weakReference.get();
                String str = "[ERROR] ";
                String str2 = "Factory";
                if (view == null) {
                    C11185p.m36817a(3, str2, (Object) this, "Target view is null. Not creating NativeDisplayTracker.");
                    C11185p.m36819a(str, "NativeDisplayTracker creation failed, subject view is null");
                    return C11147a.m36682a();
                }
                Map map = map;
                if (map == null || map.isEmpty()) {
                    C11185p.m36817a(3, str2, (Object) this, "adIds is null or empty. NativeDisplayTracker initialization failed.");
                    C11185p.m36819a(str, "NativeDisplayTracker creation failed, adIds is null or empty");
                    return C11147a.m36682a();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Creating NativeDisplayTracker for ");
                sb.append(view.getClass().getSimpleName());
                String str3 = "@";
                sb.append(str3);
                sb.append(view.hashCode());
                C11185p.m36817a(3, str2, (Object) this, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Attempting to create NativeDisplayTracker for ");
                sb2.append(view.getClass().getSimpleName());
                sb2.append(str3);
                sb2.append(view.hashCode());
                C11185p.m36819a("[INFO] ", sb2.toString());
                return C11147a.m36683a(new C11190t(view, map));
            }
        }, NativeDisplayTracker.class);
    }

    /* renamed from: a */
    private NativeVideoTracker m36785a(final String str) {
        return (NativeVideoTracker) C11208x.m36866a((C11210a<T>) new C11210a<NativeVideoTracker>() {
            /* renamed from: a */
            public C11147a<NativeVideoTracker> mo36294a() {
                String str = str;
                String str2 = "Factory";
                if (str == null || str.isEmpty()) {
                    C11185p.m36817a(3, str2, (Object) this, "partnerCode is null or empty. NativeVideoTracker initialization failed.");
                    C11185p.m36819a("[ERROR] ", "NativeDisplayTracker creation failed, partnerCode is null or empty");
                    return C11147a.m36682a();
                }
                C11185p.m36817a(3, str2, (Object) this, "Creating NativeVideo tracker.");
                C11185p.m36819a("[INFO] ", "Attempting to create NativeVideoTracker");
                return C11147a.m36683a(new C11191u(str));
            }
        }, NativeVideoTracker.class);
    }

    /* renamed from: a */
    private WebAdTracker m36786a(ViewGroup viewGroup) {
        C11146a.m36681a(viewGroup);
        final WeakReference weakReference = new WeakReference(viewGroup);
        return (WebAdTracker) C11208x.m36866a((C11210a<T>) new C11210a<WebAdTracker>() {
            /* renamed from: a */
            public C11147a<WebAdTracker> mo36294a() {
                ViewGroup viewGroup = (ViewGroup) weakReference.get();
                String str = "[ERROR] ";
                String str2 = "Factory";
                if (viewGroup == null) {
                    C11185p.m36817a(3, str2, (Object) this, "Target ViewGroup is null. Not creating WebAdTracker.");
                    C11185p.m36819a(str, "WebAdTracker not created, adContainer ViewGroup is null");
                    return C11147a.m36682a();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Creating WebAdTracker for ");
                sb.append(viewGroup.getClass().getSimpleName());
                String str3 = "@";
                sb.append(str3);
                sb.append(viewGroup.hashCode());
                C11185p.m36817a(3, str2, (Object) this, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Attempting to create WebAdTracker for ");
                sb2.append(viewGroup.getClass().getSimpleName());
                sb2.append(str3);
                sb2.append(viewGroup.hashCode());
                C11185p.m36819a("[INFO] ", sb2.toString());
                C11147a a = C11149ab.m36689a(viewGroup);
                boolean c = a.mo36307c();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("WebView ");
                sb3.append(c ? "" : "not ");
                sb3.append("found inside of ad container.");
                C11185p.m36817a(3, str2, (Object) this, sb3.toString());
                if (!c) {
                    C11185p.m36819a(str, "WebAdTracker not created, no WebView to track inside of ad container");
                }
                return C11147a.m36683a(new C11148aa((WebView) a.mo36306c(null)));
            }
        }, WebAdTracker.class);
    }

    /* renamed from: a */
    private WebAdTracker m36787a(WebView webView) {
        C11146a.m36681a(webView);
        final WeakReference weakReference = new WeakReference(webView);
        return (WebAdTracker) C11208x.m36866a((C11210a<T>) new C11210a<WebAdTracker>() {
            /* renamed from: a */
            public C11147a<WebAdTracker> mo36294a() {
                WebView webView = (WebView) weakReference.get();
                String str = "Factory";
                if (webView == null) {
                    C11185p.m36817a(3, str, (Object) this, "Target ViewGroup is null. Not creating WebAdTracker.");
                    C11185p.m36819a("[ERROR] ", "WebAdTracker not created, webView is null");
                    return C11147a.m36682a();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Creating WebAdTracker for ");
                sb.append(webView.getClass().getSimpleName());
                String str2 = "@";
                sb.append(str2);
                sb.append(webView.hashCode());
                C11185p.m36817a(3, str, (Object) this, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Attempting to create WebAdTracker for ");
                sb2.append(webView.getClass().getSimpleName());
                sb2.append(str2);
                sb2.append(webView.hashCode());
                C11185p.m36819a("[INFO] ", sb2.toString());
                return C11147a.m36683a(new C11148aa(webView));
            }
        }, WebAdTracker.class);
    }

    /* renamed from: a */
    private <T> T m36788a(MoatPlugin<T> moatPlugin) {
        return moatPlugin.mo36274a();
    }

    /* renamed from: a */
    private boolean m36789a() {
        return ((C11174k) MoatAnalytics.getInstance()).mo36366a();
    }

    public <T> T createCustomTracker(MoatPlugin<T> moatPlugin) {
        try {
            return m36788a(moatPlugin);
        } catch (Exception e) {
            C11176m.m36783a(e);
            return moatPlugin.mo36275b();
        }
    }

    public NativeDisplayTracker createNativeDisplayTracker(View view, Map<String, String> map) {
        try {
            return m36784a(view, map);
        } catch (Exception e) {
            C11176m.m36783a(e);
            return new C11195c();
        }
    }

    public NativeVideoTracker createNativeVideoTracker(String str) {
        try {
            return m36785a(str);
        } catch (Exception e) {
            C11176m.m36783a(e);
            return new C11196d();
        }
    }

    public WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
        try {
            return m36786a(viewGroup);
        } catch (Exception e) {
            C11176m.m36783a(e);
            return new C11197e();
        }
    }

    public WebAdTracker createWebAdTracker(WebView webView) {
        try {
            return m36787a(webView);
        } catch (Exception e) {
            C11176m.m36783a(e);
            return new C11197e();
        }
    }
}
