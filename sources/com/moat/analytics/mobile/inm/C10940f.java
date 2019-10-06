package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.ads.AdActivity;
import com.moat.analytics.mobile.inm.p227a.p229b.C10932a;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.inm.f */
class C10940f {

    /* renamed from: a */
    private static WebAdTracker f33444a;

    /* renamed from: b */
    private static WeakReference<Activity> f33445b = new WeakReference<>(null);

    C10940f() {
    }

    /* renamed from: a */
    private static void m35992a() {
        if (f33444a != null) {
            C10969p.m36113a(3, "GMAInterstitialHelper", f33445b.get(), "Stopping to track GMA interstitial");
            f33444a.stopTracking();
            f33444a = null;
        }
    }

    /* renamed from: a */
    static void m35993a(Activity activity) {
        try {
            if (C10984w.m36151a().f33561a != C10992d.OFF) {
                if (!m35995b(activity)) {
                    m35992a();
                    f33445b = new WeakReference<>(null);
                } else if (f33445b.get() == null || f33445b.get() != activity) {
                    View decorView = activity.getWindow().getDecorView();
                    if (decorView instanceof ViewGroup) {
                        C10932a a = C10934ab.m35960a((ViewGroup) decorView, true);
                        if (a.mo35882c()) {
                            f33445b = new WeakReference<>(activity);
                            m35994a((WebView) a.mo35880b());
                            return;
                        }
                        C10969p.m36113a(3, "GMAInterstitialHelper", (Object) activity, "Sorry, no WebView in this activity");
                    }
                }
            }
        } catch (Exception e) {
            C10960m.m36077a(e);
        }
    }

    /* renamed from: a */
    private static void m35994a(WebView webView) {
        C10969p.m36113a(3, "GMAInterstitialHelper", f33445b.get(), "Starting to track GMA interstitial");
        WebAdTracker createWebAdTracker = MoatFactory.create().createWebAdTracker(webView);
        f33444a = createWebAdTracker;
        createWebAdTracker.startTracking();
    }

    /* renamed from: b */
    private static boolean m35995b(Activity activity) {
        String name = activity.getClass().getName();
        StringBuilder sb = new StringBuilder("Activity name: ");
        sb.append(name);
        C10969p.m36113a(3, "GMAInterstitialHelper", (Object) activity, sb.toString());
        return name.contains(AdActivity.CLASS_NAME);
    }
}
