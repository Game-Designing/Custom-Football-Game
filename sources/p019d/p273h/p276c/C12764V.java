package p019d.p273h.p276c;

import java.util.Date;
import java.util.TimerTask;
import p019d.p273h.p276c.p284h.C12913g;

/* renamed from: d.h.c.V */
/* compiled from: ProgIsSmash */
class C12764V extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C12765W f39216a;

    C12764V(C12765W this$0) {
        this.f39216a = this$0;
    }

    public void run() {
        C12765W w = this.f39216a;
        StringBuilder sb = new StringBuilder();
        sb.append("timed out state=");
        sb.append(this.f39216a.f39217e.name());
        sb.append(" isBidder=");
        sb.append(this.f39216a.mo41449o());
        w.m41351c(sb.toString());
        if (this.f39216a.f39217e != C12766a.INIT_IN_PROGRESS || !this.f39216a.mo41449o()) {
            this.f39216a.m41345a(C12766a.LOAD_FAILED);
            this.f39216a.f39218f.mo41268a(C12913g.m41922b("timed out"), this.f39216a, new Date().getTime() - this.f39216a.f39224l);
            return;
        }
        this.f39216a.m41345a(C12766a.NO_INIT);
    }
}
