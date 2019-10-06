package com.moat.analytics.mobile.iro;

import android.app.Application;

public abstract class MoatAnalytics {

    /* renamed from: ˎ */
    private static MoatAnalytics f33627 = null;

    public abstract void prepareNativeDisplayTracking(String str);

    public abstract void start(Application application);

    public abstract void start(MoatOptions moatOptions, Application application);

    public static synchronized MoatAnalytics getInstance() {
        MoatAnalytics moatAnalytics;
        synchronized (MoatAnalytics.class) {
            if (f33627 == null) {
                try {
                    f33627 = new C11031j();
                } catch (Exception e) {
                    C11043o.m36351(e);
                    f33627 = new com.moat.analytics.mobile.iro.NoOp.MoatAnalytics();
                }
            }
            moatAnalytics = f33627;
        }
        return moatAnalytics;
    }
}
