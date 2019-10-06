package com.moat.analytics.mobile.iro;

import android.app.Application;
import android.content.Context;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.iro.j */
final class C11031j extends MoatAnalytics implements C11058a {

    /* renamed from: ʼ */
    private String f33729;

    /* renamed from: ˊ */
    C11011b f33730;

    /* renamed from: ˊॱ */
    private MoatOptions f33731;

    /* renamed from: ˋ */
    WeakReference<Context> f33732;

    /* renamed from: ˎ */
    boolean f33733 = false;

    /* renamed from: ˏ */
    boolean f33734 = false;

    /* renamed from: ॱ */
    boolean f33735 = false;

    /* renamed from: ᐝ */
    private boolean f33736 = false;

    C11031j() {
    }

    public final void start(MoatOptions moatOptions, Application application) {
        try {
            if (this.f33736) {
                C11011b.m36234(3, "Analytics", this, "Moat SDK has already been started.");
                return;
            }
            this.f33731 = moatOptions;
            C11054t.m36390().mo36125();
            this.f33734 = moatOptions.disableLocationServices;
            if (application != null) {
                if (moatOptions.loggingEnabled && C11044p.m36360(application.getApplicationContext())) {
                    this.f33735 = true;
                }
                this.f33732 = new WeakReference<>(application.getApplicationContext());
                this.f33736 = true;
                this.f33733 = moatOptions.autoTrackGMAInterstitials;
                C11009a.m36223(application);
                C11054t.m36390().mo36126((C11058a) this);
                if (!moatOptions.disableAdIdCollection) {
                    C11044p.m36355(application);
                }
                C11011b.m36232("[SUCCESS] ", "Moat Analytics SDK Version 2.4.0 started");
                return;
            }
            throw new C11043o("Moat Analytics SDK didn't start, application was null");
        } catch (Exception e) {
            C11043o.m36351(e);
        }
    }

    public final void start(Application application) {
        start(new MoatOptions(), application);
    }

    public final void prepareNativeDisplayTracking(String str) {
        this.f33729 = str;
        if (C11054t.m36390().f33794 != C11060c.f33810) {
            try {
                m36319();
            } catch (Exception e) {
                C11043o.m36351(e);
            }
        }
    }

    /* renamed from: ˋ */
    private void m36319() {
        if (this.f33730 == null) {
            this.f33730 = new C11011b(C11009a.m36225(), C11014a.f33644);
            this.f33730.mo36038(this.f33729);
            StringBuilder sb = new StringBuilder("Preparing native display tracking with partner code ");
            sb.append(this.f33729);
            C11011b.m36234(3, "Analytics", this, sb.toString());
            StringBuilder sb2 = new StringBuilder("Prepared for native display tracking with partner code ");
            sb2.append(this.f33729);
            C11011b.m36232("[SUCCESS] ", sb2.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ */
    public final boolean mo36107() {
        return this.f33736;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ */
    public final boolean mo36108() {
        MoatOptions moatOptions = this.f33731;
        return moatOptions != null && moatOptions.disableLocationServices;
    }

    /* renamed from: ॱ */
    public final void mo36109() throws C11043o {
        C11043o.m36348();
        C11032k.m36332();
        if (this.f33729 != null) {
            try {
                m36319();
            } catch (Exception e) {
                C11043o.m36351(e);
            }
        }
    }
}
