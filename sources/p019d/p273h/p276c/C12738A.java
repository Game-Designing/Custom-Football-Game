package p019d.p273h.p276c;

import java.util.TimerTask;
import p019d.p273h.p276c.C12791c.C12792a;
import p019d.p273h.p276c.p284h.C12913g;

/* renamed from: d.h.c.A */
/* compiled from: InterstitialSmash */
class C12738A extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C12740C f39068a;

    C12738A(C12740C this$0) {
        this.f39068a = this$0;
    }

    public void run() {
        cancel();
        C12740C c = this.f39068a;
        if (c.f39350a == C12792a.INIT_PENDING && c.f39071w != null) {
            this.f39068a.mo41388a(C12792a.INIT_FAILED);
            this.f39068a.f39071w.mo41657b(C12913g.m41923b("Timeout", "Interstitial"), this.f39068a);
        }
    }
}
