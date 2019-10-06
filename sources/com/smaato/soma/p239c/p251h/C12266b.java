package com.smaato.soma.p239c.p251h;

import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p252i.C12277c;
import com.smaato.soma.p255d.C12315h;

/* renamed from: com.smaato.soma.c.h.b */
/* compiled from: BannerState */
public class C12266b {

    /* renamed from: a */
    private C12269c f38397a = null;

    /* renamed from: b */
    private C12267a f38398b = C12267a.STATE_EMPTY;

    /* renamed from: c */
    private boolean f38399c = false;

    /* renamed from: com.smaato.soma.c.h.b$a */
    /* compiled from: BannerState */
    public enum C12267a {
        STATE_EMPTY,
        STATE_BANNERDISPLAYED,
        STATE_BANNEREXPANDED
    }

    /* renamed from: com.smaato.soma.c.h.b$b */
    /* compiled from: BannerState */
    private enum C12268b {
        TRANSITION_EXPANDBANNER,
        TRANSITION_CLOSENOORMMA,
        TRANSITION_CLOSEORMMA,
        TRANSITION_DISPLAYBANNER
    }

    /* renamed from: a */
    public void mo39640a(boolean enabled) {
        this.f38399c = enabled;
    }

    /* renamed from: a */
    private void m40360a(String message) {
        if (this.f38399c) {
            C12146d.m39965a(new C12147e("BannerState", message, 1, C12143a.DEBUG));
        }
    }

    /* renamed from: b */
    private void m40361b(C12267a state) {
        int i = C12265a.f38395a[state.ordinal()];
        if (i == 1) {
            m40360a("Exit state BannerDisplayed");
            this.f38397a.mo39649e();
        } else if (i == 2) {
            m40360a("Exit state BannerExpanded");
            this.f38397a.mo39652h();
        } else if (i != 3) {
            m40360a("Unknown exit state");
            C12277c.m40409a().mo39667c();
        } else {
            m40360a("Exit state Empty");
            this.f38397a.mo39645a();
        }
    }

    /* renamed from: a */
    private void m40357a(C12267a state) {
        int i = C12265a.f38395a[state.ordinal()];
        if (i == 1) {
            m40360a("Enter state BannerDisplayed");
            this.f38397a.mo39646b();
            C12315h.m40496c().mo39734b();
        } else if (i == 2) {
            m40360a("Enter state BannerExpanded");
            this.f38397a.mo39654j();
        } else if (i != 3) {
            m40360a("Unknown enter state");
            C12277c.m40409a().mo39667c();
        } else {
            m40360a("Enter state Empty");
            this.f38397a.mo39653i();
        }
    }

    /* renamed from: a */
    private void m40358a(C12268b transition) {
        int i = C12265a.f38396b[transition.ordinal()];
        if (i == 1) {
            m40360a("Trigger transition ExpandBanner");
            this.f38397a.mo39650f();
        } else if (i == 2) {
            m40360a("Trigger transition CloseNoOrmma");
            this.f38397a.mo39648d();
        } else if (i == 3) {
            m40360a("Trigger transition CloseOrmma");
            this.f38397a.mo39651g();
        } else if (i != 4) {
            m40360a("Unable to call Transition");
            C12277c.m40409a().mo39667c();
        } else {
            m40360a("Trigger transition DisplayBanner");
            this.f38397a.mo39647c();
        }
    }

    /* renamed from: a */
    private void m40359a(C12268b transition, C12267a newState) {
        m40361b(this.f38398b);
        m40358a(transition);
        this.f38398b = newState;
        m40357a(newState);
    }

    /* renamed from: a */
    public void mo39639a(C12269c delegate) {
        this.f38397a = delegate;
    }

    /* renamed from: a */
    public C12267a mo39638a() {
        return this.f38398b;
    }

    /* renamed from: e */
    public boolean mo39644e() {
        if (this.f38398b != C12267a.STATE_BANNERDISPLAYED) {
            return false;
        }
        m40359a(C12268b.TRANSITION_EXPANDBANNER, C12267a.STATE_BANNEREXPANDED);
        return true;
    }

    /* renamed from: b */
    public boolean mo39641b() {
        if (this.f38398b != C12267a.STATE_BANNEREXPANDED) {
            return false;
        }
        m40359a(C12268b.TRANSITION_CLOSENOORMMA, C12267a.STATE_EMPTY);
        return true;
    }

    /* renamed from: c */
    public boolean mo39642c() {
        if (this.f38398b != C12267a.STATE_BANNEREXPANDED) {
            return false;
        }
        m40359a(C12268b.TRANSITION_CLOSEORMMA, C12267a.STATE_BANNERDISPLAYED);
        return true;
    }

    /* renamed from: d */
    public boolean mo39643d() {
        C12267a aVar = this.f38398b;
        if (aVar != C12267a.STATE_EMPTY && aVar != C12267a.STATE_BANNERDISPLAYED) {
            return false;
        }
        m40359a(C12268b.TRANSITION_DISPLAYBANNER, C12267a.STATE_BANNERDISPLAYED);
        return true;
    }
}
