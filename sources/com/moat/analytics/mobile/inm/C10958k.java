package com.moat.analytics.mobile.inm;

import android.app.Application;
import android.content.Context;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.inm.k */
class C10958k extends MoatAnalytics implements C10990b {

    /* renamed from: a */
    boolean f33506a = false;

    /* renamed from: b */
    boolean f33507b = false;

    /* renamed from: c */
    boolean f33508c = false;

    /* renamed from: d */
    C10941g f33509d;

    /* renamed from: e */
    WeakReference<Context> f33510e;

    /* renamed from: f */
    private boolean f33511f = false;

    /* renamed from: g */
    private String f33512g;

    /* renamed from: h */
    private MoatOptions f33513h;

    C10958k() {
    }

    /* renamed from: a */
    private void m36060a(MoatOptions moatOptions, Application application) {
        if (this.f33511f) {
            C10969p.m36113a(3, "Analytics", (Object) this, "Moat SDK has already been started.");
            return;
        }
        this.f33513h = moatOptions;
        C10984w.m36151a().mo35976b();
        this.f33508c = moatOptions.disableLocationServices;
        if (application != null) {
            if (moatOptions.loggingEnabled && C10972s.m36125b(application.getApplicationContext())) {
                this.f33506a = true;
            }
            this.f33510e = new WeakReference<>(application.getApplicationContext());
            this.f33511f = true;
            this.f33507b = moatOptions.autoTrackGMAInterstitials;
            C10929a.m35945a(application);
            C10984w.m36151a().mo35975a((C10990b) this);
            if (!moatOptions.disableAdIdCollection) {
                C10972s.m36123a((Context) application);
            }
            C10969p.m36116a("[SUCCESS] ", "Moat Analytics SDK Version 2.5.0 started");
            return;
        }
        throw new C10960m("Moat Analytics SDK didn't start, application was null");
    }

    /* renamed from: e */
    private void m36061e() {
        if (this.f33509d == null) {
            this.f33509d = new C10941g(C10929a.m35944a(), C10946a.DISPLAY);
            this.f33509d.mo35918a(this.f33512g);
            StringBuilder sb = new StringBuilder("Preparing native display tracking with partner code ");
            sb.append(this.f33512g);
            C10969p.m36113a(3, "Analytics", (Object) this, sb.toString());
            StringBuilder sb2 = new StringBuilder("Prepared for native display tracking with partner code ");
            sb2.append(this.f33512g);
            C10969p.m36116a("[SUCCESS] ", sb2.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo35952a() {
        return this.f33511f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo35953b() {
        MoatOptions moatOptions = this.f33513h;
        return moatOptions != null && moatOptions.disableLocationServices;
    }

    /* renamed from: c */
    public void mo35954c() {
        C10960m.m36076a();
        C10966o.m36089a();
        if (this.f33512g != null) {
            try {
                m36061e();
            } catch (Exception e) {
                C10960m.m36077a(e);
            }
        }
    }

    /* renamed from: d */
    public void mo35955d() {
    }

    public void prepareNativeDisplayTracking(String str) {
        this.f33512g = str;
        if (C10984w.m36151a().f33561a != C10992d.OFF) {
            try {
                m36061e();
            } catch (Exception e) {
                C10960m.m36077a(e);
            }
        }
    }

    public void start(Application application) {
        start(new MoatOptions(), application);
    }

    public void start(MoatOptions moatOptions, Application application) {
        try {
            m36060a(moatOptions, application);
        } catch (Exception e) {
            C10960m.m36077a(e);
        }
    }
}
