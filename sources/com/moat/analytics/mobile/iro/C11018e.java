package com.moat.analytics.mobile.iro;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.ads.AdActivity;
import com.moat.analytics.mobile.iro.base.functional.Optional;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.iro.e */
final class C11018e {

    /* renamed from: ˊ */
    private static WeakReference<Activity> f33670 = new WeakReference<>(null);

    /* renamed from: ˏ */
    private static WebAdTracker f33671;

    C11018e() {
    }

    /* renamed from: ˊ */
    static void m36263(Activity activity) {
        String str = "GMAInterstitialHelper";
        try {
            if (C11054t.m36390().f33794 != C11060c.f33810) {
                String name = activity.getClass().getName();
                StringBuilder sb = new StringBuilder("Activity name: ");
                sb.append(name);
                C11011b.m36234(3, str, activity, sb.toString());
                if (!name.contains(AdActivity.CLASS_NAME)) {
                    if (f33671 != null) {
                        C11011b.m36234(3, str, f33670.get(), "Stopping to track GMA interstitial");
                        f33671.stopTracking();
                        f33671 = null;
                    }
                    f33670 = new WeakReference<>(null);
                } else if (f33670.get() == null || f33670.get() != activity) {
                    View decorView = activity.getWindow().getDecorView();
                    if (decorView instanceof ViewGroup) {
                        Optional r1 = C11064v.m36406((ViewGroup) decorView, true);
                        if (r1.isPresent()) {
                            f33670 = new WeakReference<>(activity);
                            WebView webView = (WebView) r1.get();
                            C11011b.m36234(3, str, f33670.get(), "Starting to track GMA interstitial");
                            WebAdTracker createWebAdTracker = MoatFactory.create().createWebAdTracker(webView);
                            f33671 = createWebAdTracker;
                            createWebAdTracker.startTracking();
                            return;
                        }
                        C11011b.m36234(3, str, activity, "Sorry, no WebView in this activity");
                    }
                }
            }
        } catch (Exception e) {
            C11043o.m36351(e);
        }
    }
}
