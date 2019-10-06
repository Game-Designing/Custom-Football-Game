package com.flurry.sdk;

import android.location.Criteria;
import android.location.Location;

/* renamed from: com.flurry.sdk.td */
public final class C7602td extends C7607ud {

    /* renamed from: c */
    public static final Integer f15081c = Integer.valueOf(284);

    /* renamed from: d */
    public static final Integer f15082d = Integer.valueOf(11);

    /* renamed from: e */
    public static final Integer f15083e = Integer.valueOf(6);

    /* renamed from: f */
    public static final Integer f15084f = Integer.valueOf(0);

    /* renamed from: g */
    public static final String f15085g = null;

    /* renamed from: h */
    public static final Boolean f15086h;

    /* renamed from: i */
    public static final Boolean f15087i;

    /* renamed from: j */
    public static final String f15088j = null;

    /* renamed from: k */
    public static final Boolean f15089k;

    /* renamed from: l */
    public static final Criteria f15090l = null;

    /* renamed from: m */
    public static final Location f15091m = null;

    /* renamed from: n */
    public static final Long f15092n = Long.valueOf(10000);

    /* renamed from: o */
    public static final Boolean f15093o = Boolean.TRUE;

    /* renamed from: p */
    public static final Long f15094p = null;

    /* renamed from: q */
    public static final Byte f15095q = Byte.valueOf(-1);

    /* renamed from: r */
    public static final Boolean f15096r = Boolean.FALSE;

    /* renamed from: s */
    public static final String f15097s = null;

    /* renamed from: t */
    public static final Boolean f15098t;

    /* renamed from: u */
    public static final Boolean f15099u;

    /* renamed from: v */
    private static C7602td f15100v;

    static {
        Boolean bool = Boolean.TRUE;
        f15086h = bool;
        f15087i = bool;
        f15089k = bool;
        Boolean bool2 = Boolean.TRUE;
        f15098t = bool2;
        f15099u = bool2;
    }

    private C7602td() {
        mo24025a("AgentVersion", (Object) f15081c);
        mo24025a("ReleaseMajorVersion", (Object) f15082d);
        mo24025a("ReleaseMinorVersion", (Object) f15083e);
        mo24025a("ReleasePatchVersion", (Object) f15084f);
        String str = "";
        mo24025a("ReleaseBetaVersion", (Object) str);
        mo24025a("VersionName", (Object) f15085g);
        mo24025a("CaptureUncaughtExceptions", (Object) f15086h);
        mo24025a("UseHttps", (Object) f15087i);
        mo24025a("ReportUrl", (Object) f15088j);
        mo24025a("ReportLocation", (Object) f15089k);
        mo24025a("ExplicitLocation", (Object) f15091m);
        mo24025a("ContinueSessionMillis", (Object) f15092n);
        mo24025a("LogEvents", (Object) f15093o);
        mo24025a("Age", (Object) f15094p);
        mo24025a("Gender", (Object) f15095q);
        mo24025a("UserId", (Object) str);
        mo24025a("ProtonEnabled", (Object) f15096r);
        mo24025a("ProtonConfigUrl", (Object) f15097s);
        mo24025a("analyticsEnabled", (Object) f15098t);
        mo24025a("IncludeBackgroundSessionsInMetrics", (Object) f15099u);
        mo24025a("notificationsEnabled", (Object) Boolean.FALSE);
    }

    /* renamed from: a */
    public static synchronized C7602td m16825a() {
        C7602td tdVar;
        synchronized (C7602td.class) {
            if (f15100v == null) {
                f15100v = new C7602td();
            }
            tdVar = f15100v;
        }
        return tdVar;
    }
}
