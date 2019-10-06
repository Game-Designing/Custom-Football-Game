package com.inmobi.ads;

import android.app.Application;
import android.view.View;
import android.webkit.WebView;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.utilities.uid.C10709c;
import com.inmobi.p207a.C10300o;
import com.moat.analytics.mobile.inm.MoatAnalytics;
import com.moat.analytics.mobile.inm.MoatFactory;
import com.moat.analytics.mobile.inm.MoatOptions;
import com.moat.analytics.mobile.inm.NativeDisplayTracker;
import com.moat.analytics.mobile.inm.ReactiveVideoTracker;
import com.moat.analytics.mobile.inm.ReactiveVideoTrackerPlugin;
import com.moat.analytics.mobile.inm.WebAdTracker;
import java.util.Map;

/* renamed from: com.inmobi.ads.z */
/* compiled from: InMobiMoatFactory */
class C10613z {

    /* renamed from: a */
    private static final String f32327a = C10613z.class.getSimpleName();

    /* renamed from: b */
    private static final boolean f32328b = false;

    /* renamed from: c */
    private static boolean f32329c = false;

    C10613z() {
    }

    static {
        "row".contains("staging");
    }

    /* renamed from: a */
    static void m34819a(Application application) {
        if (!f32329c) {
            try {
                MoatOptions moatOptions = new MoatOptions();
                moatOptions.loggingEnabled = f32328b;
                moatOptions.disableLocationServices = !C10300o.m33571a().f31217a.f31222a.mo33676a();
                C10709c.m35160a();
                Boolean g = C10709c.m35166g();
                if (g == null || g.booleanValue()) {
                    moatOptions.disableAdIdCollection = true;
                }
                MoatAnalytics.getInstance().start(moatOptions, application);
                f32329c = true;
            } catch (Exception e) {
                new StringBuilder("Exception in initializing the Moat library : ").append(e.getMessage());
                C10621a.m34854a().mo34423a(new C10658a(e));
            }
        }
    }

    /* renamed from: a */
    static WebAdTracker m34818a(Application application, WebView webView) {
        if (!f32329c) {
            m34819a(application);
        }
        return MoatFactory.create().createWebAdTracker(webView);
    }

    /* renamed from: a */
    static NativeDisplayTracker m34816a(Application application, String str, View view, Map<String, String> map) {
        if (!f32329c) {
            m34819a(application);
        }
        MoatAnalytics.getInstance().prepareNativeDisplayTracking(str);
        return MoatFactory.create().createNativeDisplayTracker(view, map);
    }

    /* renamed from: a */
    static ReactiveVideoTracker m34817a(Application application, String str) {
        if (!f32329c) {
            m34819a(application);
        }
        return (ReactiveVideoTracker) MoatFactory.create().createCustomTracker(new ReactiveVideoTrackerPlugin(str));
    }
}
