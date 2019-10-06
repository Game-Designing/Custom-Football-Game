package com.moat.analytics.mobile.sma;

import android.app.Application;
import com.moat.analytics.mobile.sma.C11118v.C11119a;

public abstract class MoatAnalytics {

    /* renamed from: a */
    private static MoatAnalytics f33846a = null;

    public static synchronized MoatAnalytics getInstance() {
        MoatAnalytics moatAnalytics;
        synchronized (MoatAnalytics.class) {
            if (f33846a == null) {
                try {
                    f33846a = new C11100k();
                } catch (Exception e) {
                    C11102m.m36543a(e);
                    f33846a = new C11119a();
                }
            }
            moatAnalytics = f33846a;
        }
        return moatAnalytics;
    }

    public abstract void prepareNativeDisplayTracking(String str);

    public abstract void start(Application application);

    public abstract void start(MoatOptions moatOptions, Application application);
}
