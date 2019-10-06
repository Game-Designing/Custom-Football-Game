package com.moat.analytics.mobile.sma;

import android.app.Application;
import android.content.Context;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.sma.k */
class C11100k extends MoatAnalytics implements C11130b {

    /* renamed from: a */
    boolean f33932a = false;

    /* renamed from: b */
    boolean f33933b = false;

    /* renamed from: c */
    boolean f33934c = false;

    /* renamed from: d */
    C11085g f33935d;

    /* renamed from: e */
    WeakReference<Context> f33936e;

    /* renamed from: f */
    private boolean f33937f = false;

    /* renamed from: g */
    private String f33938g;

    C11100k() {
    }

    /* renamed from: a */
    private void m36529a(MoatOptions moatOptions, Application application) {
        if (this.f33937f) {
            C11111p.m36577a(3, "Analytics", (Object) this, "Moat SDK has already been started.");
            return;
        }
        C11124w.m36605a().mo36254b();
        if (moatOptions.loggingEnabled && m36530a(application.getApplicationContext())) {
            this.f33932a = true;
        }
        this.f33934c = moatOptions.disableLocationServices;
        if (application == null) {
            C11111p.m36579a("[ERROR] ", "Moat Analytics SDK didn't start, application was null");
            return;
        }
        this.f33936e = new WeakReference<>(application.getApplicationContext());
        this.f33937f = true;
        this.f33933b = moatOptions.autoTrackGMAInterstitials;
        C11073a.m36433a(application);
        C11124w.m36605a().mo36253a((C11130b) this);
        if (!moatOptions.disableAdIdCollection) {
            C11113s.m36585a((Context) application);
        }
        C11111p.m36579a("[SUCCESS] ", "Moat Analytics SDK Version 2.3.0 started");
    }

    /* renamed from: a */
    private static boolean m36530a(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    /* renamed from: d */
    private void m36531d() {
        if (this.f33935d == null) {
            this.f33935d = new C11085g(C11073a.m36432a(), C11088a.DISPLAY);
            this.f33935d.mo36205a(this.f33938g);
            StringBuilder sb = new StringBuilder();
            sb.append("Preparing native display tracking with partner code ");
            sb.append(this.f33938g);
            C11111p.m36577a(3, "Analytics", (Object) this, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Prepared for native display tracking with partner code ");
            sb2.append(this.f33938g);
            C11111p.m36579a("[SUCCESS] ", sb2.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo36234a() {
        return this.f33937f;
    }

    /* renamed from: b */
    public void mo36235b() {
        C11108o.m36554a();
        if (this.f33938g != null) {
            try {
                m36531d();
            } catch (Exception e) {
                C11102m.m36543a(e);
            }
        }
    }

    /* renamed from: c */
    public void mo36236c() {
    }

    public void prepareNativeDisplayTracking(String str) {
        this.f33938g = str;
        if (C11124w.m36605a().f33971a != C11132d.OFF) {
            try {
                m36531d();
            } catch (Exception e) {
                C11102m.m36543a(e);
            }
        }
    }

    public void start(Application application) {
        start(new MoatOptions(), application);
    }

    public void start(MoatOptions moatOptions, Application application) {
        try {
            m36529a(moatOptions, application);
        } catch (Exception e) {
            C11102m.m36543a(e);
        }
    }
}
