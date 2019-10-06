package com.smaato.soma;

import android.app.Application;
import android.content.Context;
import com.moat.analytics.mobile.sma.MoatAnalytics;
import com.moat.analytics.mobile.sma.MoatOptions;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p246f.C12253x;
import com.smaato.soma.p239c.p246f.p249c.C12229k;

/* renamed from: com.smaato.soma.Oa */
/* compiled from: SOMA */
public class C12066Oa {

    /* renamed from: a */
    private static boolean f37930a;

    /* renamed from: b */
    private static String f37931b;

    /* renamed from: a */
    public static void m39872a(Application application, C12229k userSettings) {
        if (!f37930a) {
            if (application == null) {
                C12146d.m39965a(new C12147e("SOMA", "Application passed to SOMA.init() must not be null!", 1, C12143a.ERROR));
                return;
            }
            MoatOptions moatOptions = new MoatOptions();
            Context applicationContext = application.getApplicationContext();
            boolean z = false;
            moatOptions.disableAdIdCollection = userSettings.mo39587h() == 1 || !C12253x.m40318a(applicationContext);
            if (userSettings.mo39587h() == 1 || !C12253x.m40319b(applicationContext)) {
                z = true;
            }
            moatOptions.disableLocationServices = z;
            MoatAnalytics.getInstance().start(moatOptions, application);
            MoatAnalytics.getInstance().prepareNativeDisplayTracking("smaatoinappdisplay335120528678");
            f37931b = application.getPackageName();
            f37930a = true;
        }
    }

    /* renamed from: b */
    public static boolean m39873b() {
        return f37930a;
    }

    /* renamed from: a */
    public static String m39871a() {
        return f37931b;
    }
}
