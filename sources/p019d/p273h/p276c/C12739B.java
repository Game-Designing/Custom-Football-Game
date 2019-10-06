package p019d.p273h.p276c;

import java.util.Date;
import java.util.TimerTask;
import p019d.p273h.p276c.C12791c.C12792a;
import p019d.p273h.p276c.p284h.C12913g;

/* renamed from: d.h.c.B */
/* compiled from: InterstitialSmash */
class C12739B extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C12740C f39069a;

    C12739B(C12740C this$0) {
        this.f39069a = this$0;
    }

    public void run() {
        cancel();
        C12740C c = this.f39069a;
        if (c.f39350a == C12792a.LOAD_PENDING && c.f39071w != null) {
            this.f39069a.mo41388a(C12792a.NOT_AVAILABLE);
            this.f39069a.f39071w.mo41655a(C12913g.m41922b("Timeout"), this.f39069a, new Date().getTime() - this.f39069a.f39073y);
        }
    }
}
