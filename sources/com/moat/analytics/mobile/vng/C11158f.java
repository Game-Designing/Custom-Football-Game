package com.moat.analytics.mobile.vng;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.ads.AdActivity;
import com.moat.analytics.mobile.vng.p233a.p235b.C11147a;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.vng.f */
class C11158f {

    /* renamed from: a */
    private static WebAdTracker f34063a;

    /* renamed from: b */
    private static WeakReference<Activity> f34064b = new WeakReference<>(null);

    C11158f() {
    }

    /* renamed from: a */
    private static void m36710a() {
        if (f34063a != null) {
            C11185p.m36817a(3, "GMAInterstitialHelper", f34064b.get(), "Stopping to track GMA interstitial");
            f34063a.stopTracking();
            f34063a = null;
        }
    }

    /* renamed from: a */
    static void m36711a(Activity activity) {
        try {
            if (C11198w.m36845a().f34158a != C11206d.OFF) {
                if (!m36713b(activity)) {
                    m36710a();
                    f34064b = new WeakReference<>(null);
                } else if (f34064b.get() == null || f34064b.get() != activity) {
                    View decorView = activity.getWindow().getDecorView();
                    if (decorView instanceof ViewGroup) {
                        C11147a a = C11149ab.m36689a((ViewGroup) decorView);
                        if (a.mo36307c()) {
                            f34064b = new WeakReference<>(activity);
                            m36712a((WebView) a.mo36305b());
                        } else {
                            C11185p.m36817a(3, "GMAInterstitialHelper", (Object) activity, "Sorry, no WebView in this activity");
                        }
                    }
                }
            }
        } catch (Exception e) {
            C11176m.m36783a(e);
        }
    }

    /* renamed from: a */
    private static void m36712a(WebView webView) {
        C11185p.m36817a(3, "GMAInterstitialHelper", f34064b.get(), "Starting to track GMA interstitial");
        f34063a = MoatFactory.create().createWebAdTracker(webView);
        f34063a.startTracking();
    }

    /* renamed from: b */
    private static boolean m36713b(Activity activity) {
        String name = activity.getClass().getName();
        StringBuilder sb = new StringBuilder();
        sb.append("Activity name: ");
        sb.append(name);
        C11185p.m36817a(3, "GMAInterstitialHelper", (Object) activity, sb.toString());
        return name.contains(AdActivity.CLASS_NAME);
    }
}
