package com.moat.analytics.mobile.inm;

import android.app.Application;
import com.moat.analytics.mobile.inm.C10978v.C10979a;

public abstract class MoatAnalytics {

    /* renamed from: a */
    private static MoatAnalytics f33410a = null;

    public static synchronized MoatAnalytics getInstance() {
        MoatAnalytics moatAnalytics;
        synchronized (MoatAnalytics.class) {
            if (f33410a == null) {
                try {
                    f33410a = new C10958k();
                } catch (Exception e) {
                    C10960m.m36077a(e);
                    f33410a = new C10979a();
                }
            }
            moatAnalytics = f33410a;
        }
        return moatAnalytics;
    }

    public abstract void prepareNativeDisplayTracking(String str);

    public abstract void start(Application application);

    public abstract void start(MoatOptions moatOptions, Application application);
}
