package com.moat.analytics.mobile.vng;

import android.app.Application;
import com.moat.analytics.mobile.vng.C11192v.C11193a;

public abstract class MoatAnalytics {

    /* renamed from: a */
    private static MoatAnalytics f34030a = null;

    public static synchronized MoatAnalytics getInstance() {
        MoatAnalytics moatAnalytics;
        synchronized (MoatAnalytics.class) {
            if (f34030a == null) {
                try {
                    f34030a = new C11174k();
                } catch (Exception e) {
                    C11176m.m36783a(e);
                    f34030a = new C11193a();
                }
            }
            moatAnalytics = f34030a;
        }
        return moatAnalytics;
    }

    public abstract void prepareNativeDisplayTracking(String str);

    public abstract void start(Application application);

    public abstract void start(MoatOptions moatOptions, Application application);
}
