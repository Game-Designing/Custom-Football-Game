package com.moat.analytics.mobile.sma;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.ads.AdActivity;
import com.moat.analytics.mobile.sma.p230a.p232b.C11076a;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.sma.f */
class C11084f {

    /* renamed from: a */
    private static WebAdTracker f33876a;

    /* renamed from: b */
    private static WeakReference<Activity> f33877b = new WeakReference<>(null);

    C11084f() {
    }

    /* renamed from: a */
    private static void m36469a() {
        if (f33876a != null) {
            C11111p.m36577a(3, "GMAInterstitialHelper", f33877b.get(), "Stopping to track GMA interstitial");
            f33876a.stopTracking();
            f33876a = null;
        }
    }

    /* renamed from: a */
    static void m36470a(Activity activity) {
        try {
            if (C11124w.m36605a().f33971a != C11132d.OFF) {
                if (!m36472b(activity)) {
                    m36469a();
                    f33877b = new WeakReference<>(null);
                } else if (f33877b.get() == null || f33877b.get() != activity) {
                    View decorView = activity.getWindow().getDecorView();
                    if (decorView instanceof ViewGroup) {
                        C11076a a = C11078ab.m36448a((ViewGroup) decorView);
                        if (a.mo36177c()) {
                            f33877b = new WeakReference<>(activity);
                            m36471a((WebView) a.mo36175b());
                        } else {
                            C11111p.m36577a(3, "GMAInterstitialHelper", (Object) activity, "Sorry, no WebView in this activity");
                        }
                    }
                }
            }
        } catch (Exception e) {
            C11102m.m36543a(e);
        }
    }

    /* renamed from: a */
    private static void m36471a(WebView webView) {
        C11111p.m36577a(3, "GMAInterstitialHelper", f33877b.get(), "Starting to track GMA interstitial");
        f33876a = MoatFactory.create().createWebAdTracker(webView);
        f33876a.startTracking();
    }

    /* renamed from: b */
    private static boolean m36472b(Activity activity) {
        String name = activity.getClass().getName();
        StringBuilder sb = new StringBuilder();
        sb.append("Activity name: ");
        sb.append(name);
        C11111p.m36577a(3, "GMAInterstitialHelper", (Object) activity, sb.toString());
        return name.contains(AdActivity.CLASS_NAME);
    }
}
