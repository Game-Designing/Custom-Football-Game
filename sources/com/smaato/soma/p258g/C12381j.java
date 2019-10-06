package com.smaato.soma.p258g;

import com.smaato.soma.C12064Na;
import com.smaato.soma.C12322e;
import com.smaato.soma.C12398ha;
import com.smaato.soma.C12408ia;
import com.smaato.soma.C12431j;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p258g.C12389r.C12391b;
import com.smaato.soma.p258g.C12389r.C12392c;

/* renamed from: com.smaato.soma.g.j */
/* compiled from: NativeAd */
class C12381j extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12064Na f38661a;

    /* renamed from: b */
    final /* synthetic */ C12322e f38662b;

    /* renamed from: c */
    final /* synthetic */ C12389r f38663c;

    C12381j(C12389r this$0, C12064Na na, C12322e eVar) {
        this.f38663c = this$0;
        this.f38661a = na;
        this.f38662b = eVar;
    }

    public Void process() {
        this.f38663c.f38681G = false;
        C12064Na na = this.f38661a;
        if (na == null) {
            return null;
        }
        this.f38663c.f38700s = na.getSessionId();
        this.f38663c.f38683b = this.f38662b;
        this.f38663c.f38684c = this.f38661a;
        if (this.f38661a.mo39290g() == C12408ia.NO_ERROR && this.f38661a.mo39284b() == C12431j.NATIVE) {
            this.f38663c.f38685d = this.f38661a.mo39295j();
            if (this.f38663c.f38685d == null) {
                return null;
            }
            if (this.f38663c.f38678D == null || this.f38663c.f38678D.equals(C12392c.ALL)) {
                this.f38663c.mo39861a(this.f38661a);
            } else {
                this.f38663c.f38685d.mo39517a(this.f38661a.mo39298m());
                C12389r rVar = this.f38663c;
                rVar.m40718c(rVar.f38685d);
            }
            this.f38663c.mo39876f();
            C12146d.m39965a(new C12147e("NATIVE", "Ad available", 1, C12143a.DEBUG));
            if (this.f38661a.mo39298m() != null) {
                this.f38663c.f38685d.mo39517a(this.f38661a.mo39298m());
            }
            if (this.f38663c.mo39870b(this.f38661a.mo39295j()) && this.f38663c.mo39873d() != null) {
                this.f38663c.f38685d.mo39531j().unregisterView();
                this.f38663c.f38685d.mo39531j().registerViewForInteraction(this.f38663c.mo39873d());
            }
            return null;
        }
        if (this.f38663c.m40730i() != null) {
            C12391b c = this.f38663c.m40730i();
            C12408ia iaVar = C12408ia.GENERAL_ERROR;
            c.onError(iaVar, iaVar.mo39903e());
        }
        if (this.f38663c.f38679E != null) {
            this.f38663c.f38679E.onReceiveAd(this.f38663c.f38683b, this.f38661a);
        }
        return null;
    }
}
