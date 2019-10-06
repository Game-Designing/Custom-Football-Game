package com.moat.analytics.mobile.sma;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.sma.p230a.p231a.C11075a;
import com.moat.analytics.mobile.sma.p230a.p232b.C11076a;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.sma.n */
class C11103n extends MoatFactory {
    C11103n() {
        if (!m36549a()) {
            C11111p.m36577a(3, "Factory", (Object) this, "Failed to initialize MoatFactory. Please check that you've initialized the Moat SDK correctly.");
            C11111p.m36579a("[ERROR] ", "Failed to initialize MoatFactory, SDK was not started");
            throw new C11102m();
        }
    }

    /* renamed from: a */
    private NativeDisplayTracker m36544a(View view, final Map<String, String> map) {
        C11075a.m36440a(view);
        C11075a.m36440a(map);
        final WeakReference weakReference = new WeakReference(view);
        return (NativeDisplayTracker) C11134x.m36626a((C11136a<T>) new C11136a<NativeDisplayTracker>() {
            /* renamed from: a */
            public C11076a<NativeDisplayTracker> mo36164a() {
                View view = (View) weakReference.get();
                String str = "[ERROR] ";
                String str2 = "Factory";
                if (view == null) {
                    C11111p.m36577a(3, str2, (Object) this, "Target view is null. Not creating NativeDisplayTracker.");
                    C11111p.m36579a(str, "NativeDisplayTracker creation failed, subject view is null");
                    return C11076a.m36441a();
                }
                Map map = map;
                if (map == null || map.isEmpty()) {
                    C11111p.m36577a(3, str2, (Object) this, "adIds is null or empty. NativeDisplayTracker initialization failed.");
                    C11111p.m36579a(str, "NativeDisplayTracker creation failed, adIds is null or empty");
                    return C11076a.m36441a();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Creating NativeDisplayTracker for ");
                sb.append(view.getClass().getSimpleName());
                String str3 = "@";
                sb.append(str3);
                sb.append(view.hashCode());
                C11111p.m36577a(3, str2, (Object) this, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Attempting to create NativeDisplayTracker for ");
                sb2.append(view.getClass().getSimpleName());
                sb2.append(str3);
                sb2.append(view.hashCode());
                C11111p.m36579a("[INFO] ", sb2.toString());
                return C11076a.m36442a(new C11116t(view, map));
            }
        }, NativeDisplayTracker.class);
    }

    /* renamed from: a */
    private NativeVideoTracker m36545a(final String str) {
        return (NativeVideoTracker) C11134x.m36626a((C11136a<T>) new C11136a<NativeVideoTracker>() {
            /* renamed from: a */
            public C11076a<NativeVideoTracker> mo36164a() {
                String str = str;
                String str2 = "Factory";
                if (str == null || str.isEmpty()) {
                    C11111p.m36577a(3, str2, (Object) this, "partnerCode is null or empty. NativeVideoTracker initialization failed.");
                    C11111p.m36579a("[ERROR] ", "NativeDisplayTracker creation failed, partnerCode is null or empty");
                    return C11076a.m36441a();
                }
                C11111p.m36577a(3, str2, (Object) this, "Creating NativeVideo tracker.");
                C11111p.m36579a("[INFO] ", "Attempting to create NativeVideoTracker");
                return C11076a.m36442a(new C11117u(str));
            }
        }, NativeVideoTracker.class);
    }

    /* renamed from: a */
    private WebAdTracker m36546a(ViewGroup viewGroup) {
        C11075a.m36440a(viewGroup);
        final WeakReference weakReference = new WeakReference(viewGroup);
        return (WebAdTracker) C11134x.m36626a((C11136a<T>) new C11136a<WebAdTracker>() {
            /* renamed from: a */
            public C11076a<WebAdTracker> mo36164a() {
                ViewGroup viewGroup = (ViewGroup) weakReference.get();
                String str = "[ERROR] ";
                String str2 = "Factory";
                if (viewGroup == null) {
                    C11111p.m36577a(3, str2, (Object) this, "Target ViewGroup is null. Not creating WebAdTracker.");
                    C11111p.m36579a(str, "WebAdTracker not created, adContainer ViewGroup is null");
                    return C11076a.m36441a();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Creating WebAdTracker for ");
                sb.append(viewGroup.getClass().getSimpleName());
                String str3 = "@";
                sb.append(str3);
                sb.append(viewGroup.hashCode());
                C11111p.m36577a(3, str2, (Object) this, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Attempting to create WebAdTracker for ");
                sb2.append(viewGroup.getClass().getSimpleName());
                sb2.append(str3);
                sb2.append(viewGroup.hashCode());
                C11111p.m36579a("[INFO] ", sb2.toString());
                C11076a a = C11078ab.m36448a(viewGroup);
                boolean c = a.mo36177c();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("WebView ");
                sb3.append(c ? "" : "not ");
                sb3.append("found inside of ad container.");
                C11111p.m36577a(3, str2, (Object) this, sb3.toString());
                if (!c) {
                    C11111p.m36579a(str, "WebAdTracker not created, no WebView to track inside of ad container");
                }
                return C11076a.m36442a(new C11077aa((WebView) a.mo36176c(null)));
            }
        }, WebAdTracker.class);
    }

    /* renamed from: a */
    private WebAdTracker m36547a(WebView webView) {
        C11075a.m36440a(webView);
        final WeakReference weakReference = new WeakReference(webView);
        return (WebAdTracker) C11134x.m36626a((C11136a<T>) new C11136a<WebAdTracker>() {
            /* renamed from: a */
            public C11076a<WebAdTracker> mo36164a() {
                WebView webView = (WebView) weakReference.get();
                String str = "Factory";
                if (webView == null) {
                    C11111p.m36577a(3, str, (Object) this, "Target ViewGroup is null. Not creating WebAdTracker.");
                    C11111p.m36579a("[ERROR] ", "WebAdTracker not created, webView is null");
                    return C11076a.m36441a();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Creating WebAdTracker for ");
                sb.append(webView.getClass().getSimpleName());
                String str2 = "@";
                sb.append(str2);
                sb.append(webView.hashCode());
                C11111p.m36577a(3, str, (Object) this, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Attempting to create WebAdTracker for ");
                sb2.append(webView.getClass().getSimpleName());
                sb2.append(str2);
                sb2.append(webView.hashCode());
                C11111p.m36579a("[INFO] ", sb2.toString());
                return C11076a.m36442a(new C11077aa(webView));
            }
        }, WebAdTracker.class);
    }

    /* renamed from: a */
    private <T> T m36548a(MoatPlugin<T> moatPlugin) {
        return moatPlugin.mo36144a();
    }

    /* renamed from: a */
    private boolean m36549a() {
        return ((C11100k) MoatAnalytics.getInstance()).mo36234a();
    }

    public <T> T createCustomTracker(MoatPlugin<T> moatPlugin) {
        try {
            return m36548a(moatPlugin);
        } catch (Exception e) {
            C11102m.m36543a(e);
            return moatPlugin.mo36145b();
        }
    }

    public NativeDisplayTracker createNativeDisplayTracker(View view, Map<String, String> map) {
        try {
            return m36544a(view, map);
        } catch (Exception e) {
            C11102m.m36543a(e);
            return new C11121c();
        }
    }

    public NativeVideoTracker createNativeVideoTracker(String str) {
        try {
            return m36545a(str);
        } catch (Exception e) {
            C11102m.m36543a(e);
            return new C11122d();
        }
    }

    public WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
        try {
            return m36546a(viewGroup);
        } catch (Exception e) {
            C11102m.m36543a(e);
            return new C11123e();
        }
    }

    public WebAdTracker createWebAdTracker(WebView webView) {
        try {
            return m36547a(webView);
        } catch (Exception e) {
            C11102m.m36543a(e);
            return new C11123e();
        }
    }
}
