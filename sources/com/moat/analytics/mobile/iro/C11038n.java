package com.moat.analytics.mobile.iro;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.iro.base.functional.Optional;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.iro.n */
final class C11038n extends MoatFactory {
    C11038n() throws C11043o {
        if (!((C11031j) MoatAnalytics.getInstance()).mo36107()) {
            String str = "Failed to initialize MoatFactory";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(", SDK was not started");
            String sb2 = sb.toString();
            C11011b.m36234(3, "Factory", this, sb2);
            C11011b.m36232("[ERROR] ", sb2);
            throw new C11043o(str);
        }
    }

    public final WebAdTracker createWebAdTracker(WebView webView) {
        try {
            final WeakReference weakReference = new WeakReference(webView);
            return (WebAdTracker) C11050s.m36379(new C11052a<WebAdTracker>() {
                /* renamed from: ˏ */
                public final Optional<WebAdTracker> mo36029() {
                    WebView webView = (WebView) weakReference.get();
                    StringBuilder sb = new StringBuilder("Attempting to create WebAdTracker for ");
                    sb.append(C11011b.m36236(webView));
                    String sb2 = sb.toString();
                    C11011b.m36234(3, "Factory", this, sb2);
                    C11011b.m36232("[INFO] ", sb2);
                    return Optional.m36239of(new C11066x(webView));
                }
            }, WebAdTracker.class);
        } catch (Exception e) {
            C11043o.m36351(e);
            return new C11005b();
        }
    }

    public final WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
        try {
            final WeakReference weakReference = new WeakReference(viewGroup);
            return (WebAdTracker) C11050s.m36379(new C11052a<WebAdTracker>() {
                /* renamed from: ˏ */
                public final Optional<WebAdTracker> mo36029() throws C11043o {
                    ViewGroup viewGroup = (ViewGroup) weakReference.get();
                    StringBuilder sb = new StringBuilder("Attempting to create WebAdTracker for adContainer ");
                    sb.append(C11011b.m36236(viewGroup));
                    String sb2 = sb.toString();
                    C11011b.m36234(3, "Factory", this, sb2);
                    C11011b.m36232("[INFO] ", sb2);
                    return Optional.m36239of(new C11066x(viewGroup));
                }
            }, WebAdTracker.class);
        } catch (Exception e) {
            C11043o.m36351(e);
            return new C11005b();
        }
    }

    public final NativeDisplayTracker createNativeDisplayTracker(View view, final Map<String, String> map) {
        try {
            final WeakReference weakReference = new WeakReference(view);
            return (NativeDisplayTracker) C11050s.m36379(new C11052a<NativeDisplayTracker>() {
                /* renamed from: ˏ */
                public final Optional<NativeDisplayTracker> mo36029() {
                    View view = (View) weakReference.get();
                    StringBuilder sb = new StringBuilder("Attempting to create NativeDisplayTracker for ");
                    sb.append(C11011b.m36236(view));
                    String sb2 = sb.toString();
                    C11011b.m36234(3, "Factory", this, sb2);
                    C11011b.m36232("[INFO] ", sb2);
                    return Optional.m36239of(new C11049r(view, map));
                }
            }, NativeDisplayTracker.class);
        } catch (Exception e) {
            C11043o.m36351(e);
            return new C11004a();
        }
    }

    public final NativeVideoTracker createNativeVideoTracker(final String str) {
        try {
            return (NativeVideoTracker) C11050s.m36379(new C11052a<NativeVideoTracker>() {
                /* renamed from: ˏ */
                public final Optional<NativeVideoTracker> mo36029() {
                    String str = "Attempting to create NativeVideoTracker";
                    C11011b.m36234(3, "Factory", this, str);
                    C11011b.m36232("[INFO] ", str);
                    return Optional.m36239of(new C11048q(str));
                }
            }, NativeVideoTracker.class);
        } catch (Exception e) {
            C11043o.m36351(e);
            return new C11006c();
        }
    }

    public final <T> T createCustomTracker(C11037m<T> mVar) {
        try {
            return mVar.create();
        } catch (Exception e) {
            C11043o.m36351(e);
            return mVar.createNoOp();
        }
    }
}
