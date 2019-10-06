package com.moat.analytics.mobile.vng;

import android.app.Application;
import android.content.Context;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.vng.k */
class C11174k extends MoatAnalytics implements C11204b {

    /* renamed from: a */
    boolean f34119a = false;

    /* renamed from: b */
    boolean f34120b = false;

    /* renamed from: c */
    boolean f34121c = false;

    /* renamed from: d */
    C11159g f34122d;

    /* renamed from: e */
    WeakReference<Context> f34123e;

    /* renamed from: f */
    private boolean f34124f = false;

    /* renamed from: g */
    private String f34125g;

    C11174k() {
    }

    /* renamed from: a */
    private void m36769a(MoatOptions moatOptions, Application application) {
        if (this.f34124f) {
            C11185p.m36817a(3, "Analytics", (Object) this, "Moat SDK has already been started.");
            return;
        }
        C11198w.m36845a().mo36386b();
        if (moatOptions.loggingEnabled && m36770a(application.getApplicationContext())) {
            this.f34119a = true;
        }
        this.f34121c = moatOptions.disableLocationServices;
        if (application == null) {
            C11185p.m36819a("[ERROR] ", "Moat Analytics SDK didn't start, application was null");
            return;
        }
        this.f34123e = new WeakReference<>(application.getApplicationContext());
        this.f34124f = true;
        this.f34120b = moatOptions.autoTrackGMAInterstitials;
        C11144a.m36674a(application);
        C11198w.m36845a().mo36385a((C11204b) this);
        if (!moatOptions.disableAdIdCollection) {
            C11187s.m36825a((Context) application);
        }
        C11185p.m36819a("[SUCCESS] ", "Moat Analytics SDK Version 2.2.0 started");
    }

    /* renamed from: a */
    private static boolean m36770a(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    /* renamed from: d */
    private void m36771d() {
        if (this.f34122d == null) {
            this.f34122d = new C11159g(C11144a.m36673a(), C11162a.DISPLAY);
            this.f34122d.mo36338a(this.f34125g);
            StringBuilder sb = new StringBuilder();
            sb.append("Preparing native display tracking with partner code ");
            sb.append(this.f34125g);
            C11185p.m36817a(3, "Analytics", (Object) this, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Prepared for native display tracking with partner code ");
            sb2.append(this.f34125g);
            C11185p.m36819a("[SUCCESS] ", sb2.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo36366a() {
        return this.f34124f;
    }

    /* renamed from: b */
    public void mo36367b() {
        C11182o.m36794a();
        if (this.f34125g != null) {
            try {
                m36771d();
            } catch (Exception e) {
                C11176m.m36783a(e);
            }
        }
    }

    /* renamed from: c */
    public void mo36368c() {
    }

    public void prepareNativeDisplayTracking(String str) {
        this.f34125g = str;
        if (C11198w.m36845a().f34158a != C11206d.OFF) {
            try {
                m36771d();
            } catch (Exception e) {
                C11176m.m36783a(e);
            }
        }
    }

    public void start(Application application) {
        start(new MoatOptions(), application);
    }

    public void start(MoatOptions moatOptions, Application application) {
        try {
            m36769a(moatOptions, application);
        } catch (Exception e) {
            C11176m.m36783a(e);
        }
    }
}
