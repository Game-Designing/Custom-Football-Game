package com.smaato.soma.p239c.p251h;

import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p252i.C12277c;

/* renamed from: com.smaato.soma.c.h.e */
/* compiled from: LoadingState */
public class C12271e {

    /* renamed from: a */
    private C12274f f38410a = null;

    /* renamed from: b */
    private C12272a f38411b = C12272a.STATE_IDLE;

    /* renamed from: c */
    private boolean f38412c = false;

    /* renamed from: com.smaato.soma.c.h.e$a */
    /* compiled from: LoadingState */
    public enum C12272a {
        STATE_IDLE,
        STATE_XMLLOADING,
        STATE_BLOCKED,
        STATE_BANNERLOADING
    }

    /* renamed from: com.smaato.soma.c.h.e$b */
    /* compiled from: LoadingState */
    private enum C12273b {
        TRANSITION_LOADXML,
        TRANSITION_LOADBANNER,
        TRANSITION_BLOCKLOADING,
        TRANSITION_UNBLOCKLOADING,
        TRANSITION_FINISHLOADING,
        TRANSITION_ERRORLOADING
    }

    /* renamed from: a */
    public void mo39656a(C12272a mCurrentState) {
        this.f38411b = mCurrentState;
    }

    /* renamed from: a */
    public void mo39658a(boolean enabled) {
        this.f38412c = enabled;
    }

    /* renamed from: a */
    private void m40381a(String message) {
        if (this.f38412c) {
            C12146d.m39965a(new C12147e("LoadingState", message, 1, C12143a.DEBUG));
        }
    }

    /* renamed from: c */
    private void m40383c(C12272a state) {
        if (state == C12272a.STATE_IDLE) {
            m40381a("Exit state Idle");
            this.f38410a.mo39269g();
        } else if (state == C12272a.STATE_XMLLOADING) {
            m40381a("Exit state XmlLoading");
            this.f38410a.mo39272j();
        } else if (state == C12272a.STATE_BLOCKED) {
            m40381a("Exit state Blocked");
            this.f38410a.mo39274l();
        } else if (state == C12272a.STATE_BANNERLOADING) {
            m40381a("Exit state BannerLoading");
            this.f38410a.mo39268f();
        }
    }

    /* renamed from: b */
    private void m40382b(C12272a state) {
        if (state == C12272a.STATE_IDLE) {
            this.f38410a.mo39267e();
            m40381a("Enter state Idle");
        } else if (state == C12272a.STATE_XMLLOADING) {
            m40381a("Enter state XmlLoading");
            this.f38410a.mo39263a();
        } else if (state == C12272a.STATE_BLOCKED) {
            m40381a("Enter state Blocked");
            this.f38410a.mo39273k();
        } else if (state == C12272a.STATE_BANNERLOADING) {
            m40381a("Enter state BannerLoading");
            this.f38410a.mo39271i();
        }
    }

    /* renamed from: a */
    private void m40379a(C12273b transition) {
        switch (C12270d.f38409a[transition.ordinal()]) {
            case 1:
                m40381a("Trigger transition LoadXml");
                this.f38410a.mo39270h();
                return;
            case 2:
                m40381a("Trigger transition LoadBanner");
                this.f38410a.mo39276n();
                return;
            case 3:
                m40381a("Trigger transition BlockLoading");
                this.f38410a.mo39275m();
                return;
            case 4:
                m40381a("Trigger transition UnblockLoading");
                this.f38410a.mo39264b();
                return;
            case 5:
                m40381a("Trigger transition FinishLoading");
                this.f38410a.mo39266d();
                return;
            case 6:
                m40381a("Trigger transition ErrorLoading");
                this.f38410a.mo39265c();
                return;
            default:
                m40381a("Unable to Trigger transition");
                C12277c.m40409a().mo39667c();
                return;
        }
    }

    /* renamed from: a */
    private void m40380a(C12273b transition, C12272a newState) {
        m40383c(this.f38411b);
        m40379a(transition);
        this.f38411b = newState;
        m40382b(newState);
    }

    /* renamed from: a */
    public void mo39657a(C12274f delegate) {
        this.f38410a = delegate;
    }

    /* renamed from: a */
    public C12272a mo39655a() {
        return this.f38411b;
    }

    /* renamed from: f */
    public boolean mo39663f() {
        if (this.f38411b == C12272a.STATE_IDLE) {
            m40380a(C12273b.TRANSITION_LOADXML, C12272a.STATE_XMLLOADING);
            return true;
        }
        m40381a("Unable to trigger LoadXml");
        C12277c.m40409a().mo39667c();
        return false;
    }

    /* renamed from: e */
    public boolean mo39662e() {
        if (this.f38411b == C12272a.STATE_XMLLOADING) {
            m40380a(C12273b.TRANSITION_LOADBANNER, C12272a.STATE_BANNERLOADING);
            return true;
        }
        m40381a("Unable to trigger LoadBanner");
        return false;
    }

    /* renamed from: b */
    public boolean mo39659b() {
        C12272a aVar = this.f38411b;
        if (aVar == C12272a.STATE_XMLLOADING || aVar == C12272a.STATE_IDLE || aVar == C12272a.STATE_BANNERLOADING) {
            m40380a(C12273b.TRANSITION_BLOCKLOADING, C12272a.STATE_BLOCKED);
            return true;
        }
        m40381a("Unable to trigger BlockLoading");
        C12277c.m40409a().mo39667c();
        return false;
    }

    /* renamed from: g */
    public boolean mo39664g() {
        if (this.f38411b == C12272a.STATE_BLOCKED) {
            m40380a(C12273b.TRANSITION_UNBLOCKLOADING, C12272a.STATE_IDLE);
            return true;
        }
        m40381a("Unable to trigger UnblockLoading");
        C12277c.m40409a().mo39667c();
        return false;
    }

    /* renamed from: d */
    public boolean mo39661d() {
        if (this.f38411b == C12272a.STATE_BANNERLOADING) {
            m40380a(C12273b.TRANSITION_FINISHLOADING, C12272a.STATE_IDLE);
            return true;
        }
        m40381a("Unable to trigger FinishLoading");
        C12277c.m40409a().mo39667c();
        return false;
    }

    /* renamed from: c */
    public boolean mo39660c() {
        if (this.f38411b == C12272a.STATE_XMLLOADING) {
            m40380a(C12273b.TRANSITION_ERRORLOADING, C12272a.STATE_IDLE);
            return true;
        }
        m40381a("Unable to trigger ErrorLoading");
        C12277c.m40409a().mo39667c();
        return false;
    }
}
